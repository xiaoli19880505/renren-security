$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/workeraccountinfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'workerId', name: 'workerId', index: 'worker_id', width: 50, key: true },
			{ label: '工人身份证号', name: 'workerSfzh', index: 'worker_sfzh', width: 80 }, 			
			{ label: '开户行数据字典', name: 'bankDicId', index: 'bank_dic_id', width: 80 }, 			
			{ label: '工人开户账号', name: 'workerAccountNo', index: 'worker_account_no', width: 80 }, 			
			{ label: '上传人', name: 'createPersonId', index: 'create_person_id', width: 80 }, 			
			{ label: '上传时间', name: 'createTime', index: 'create_time', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
        queries:{
            workerSfzh:null,
            workerAccountNo:null
        },
		showList: true,
		title: null,
		workerAccountInfo: {},
        bankDicJson:[]
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.workerAccountInfo = {};
            this.loadDic();
            this.init();
		},
		update: function (event) {
			var workerId = getSelectedRow();
			if(workerId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(workerId)
		},
		saveOrUpdate: function (event) {
            var url = vm.workerAccountInfo.workerId == null ? "sys/workeraccountinfo/save" : "sys/workeraccountinfo/update";
            var bootstrapValidator = $("#projectForm").data('bootstrapValidator');
            bootstrapValidator.validate();
            if(bootstrapValidator.isValid()) {
                $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                    $.ajax({
                        type: "POST",
                        url: baseURL + url,
                        contentType: "application/json",
                        data: JSON.stringify(vm.workerAccountInfo),
                        success: function(r){
                            if(r.code === 0){
                                layer.msg("操作成功", {icon: 1});
                                vm.reload();
                                $('#btnSaveOrUpdate').button('reset');
                                $('#btnSaveOrUpdate').dequeue();
                            }else{
                                layer.alert(r.msg);
                                $('#btnSaveOrUpdate').button('reset');
                                $('#btnSaveOrUpdate').dequeue();
                            }
                        }
                    });
                });

            }else{
                $('#btnSaveOrUpdate').button('reset');
                $('#btnSaveOrUpdate').dequeue();
            }
		},
		del: function (event) {
			var workerIds = getSelectedRows();
			if(workerIds == null){
				return ;
			}
			var lock = false;
            layer.confirm('确定要删除选中的记录？', {
                btn: ['确定','取消'] //按钮
            }, function(){
               if(!lock) {
                    lock = true;
		            $.ajax({
                        type: "POST",
                        url: baseURL + "sys/workeraccountinfo/delete",
                        contentType: "application/json",
                        data: JSON.stringify(workerIds),
                        success: function(r){
                            if(r.code == 0){
                                layer.msg("操作成功", {icon: 1});
                                $("#jqGrid").trigger("reloadGrid");
                            }else{
                                layer.alert(r.msg);
                            }
                        }
				    });
			    }
             }, function(){
             });
		},
		getInfo: function(workerId){
			$.get(baseURL + "sys/workeraccountinfo/info/"+workerId, function(r){
                vm.workerAccountInfo = r.workerAccountInfo;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{
                    'workerSfzh': vm.queries.workerSfzh,
                    'workerAccountNo': vm.queries.workerAccountNo
                },
                page:page
            }).trigger("reloadGrid");
            $('#projectForm').data('bootstrapValidator').resetForm(true);
        },
        loadDic:function(){
            $.ajax({
                url: baseURL + 'sys/dict/alllist',
                type:'post',
                data:{
                    name:'银行编码'
                },
                success:function(data){
                    if(data.msg=='success'){
                        vm.bankDicJson=data.list;
                    }else{
                        layer.msg(data.msg);
                    }
                }
            })
        },
        changeId:function(){
            var text=$("#bankDicId").find('option:selected').text();
            var code=$("#bankDicId").find('option:selected').attr("code");
            vm.workerAccountInfo.bankCode=code;
            vm.workerAccountInfo.bankName=text;
        },
        init:function(){
            $('#projectForm').bootstrapValidator({
                message: '输入信息有误',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    workerSfzh: {
                        message: '输入内容有误',
                        validators: {
                            notEmpty: {
                                message: '请输入工人身份证号'
                            },
                            regexp: {
                                regexp:/(^\d{15}$)|(^\d{17}(\d|X|x)$)/,
                                message: '身份证号格式错误'
                            }
                        }
                    },
                    bankDicId:{
                        validators: {
                            notEmpty: {
                                message: '请选择开户行数据字典'
                            }
                        }
                    },
                    workerAccountNo:{
                        validators: {
                            notEmpty: {
                                message: '请输入工人开户账号'
                            },
                            regexp: {
                                regexp:/^(0[1-9][0-9]*)$/ ,
                                message: '账户号只能输入数字'
                            }
                        }
                    }
                }
            });
        }

    }
});