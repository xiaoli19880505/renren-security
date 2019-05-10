$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/projectbankaccount/list',
        datatype: "json",
        colModel: [			
			{ label: 'accountId', name: 'accountId', index: 'account_id', width: 50, key: true },
			{ label: '企业统一社会信用代码', name: 'busCode', index: 'bus_code', width: 80 }, 			
			{ label: '项目编号', name: 'proNo', index: 'pro_no', width: 80 }, 			
			{ label: '开户行数据字典id', name: 'bankDicId', index: 'bank_dic_id', width: 80 }, 			
			{ label: '工资专用账户账号', name: 'accountNo', index: 'account_no', width: 80 }, 			
			{ label: '专户开户户名', name: 'accountName', index: 'account_name', width: 80 }, 			
			{ label: '专户开户网点', name: 'accountNet', index: 'account_net', width: 80 }, 			
			{ label: '上传人id', name: 'createPersonId', index: 'create_person_id', width: 80 }, 			
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
        altRows:true,
        altclass:'ui-jqgrid-rowbackgroundColor',
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
    new AjaxUpload('#upload', {
        action: baseURL + "sys/oss/upload",
        name: 'file',
        autoSubmit:true,
        responseType:"json",
        fileType:'file',
        onSubmit:function(file, extension){
            if(vm.config.type == null){
                return false;
            }
                if (!(extension && /^(xls|xlsx|XLS|XLSX)$/.test(extension.toLowerCase()))){
                layer.alert('只支持excel文件！');
                return false;
            }
        },
        onComplete : function(file, r){
            if(r.code == 0){
                alert(r.url);
                vm.reload();
            }else{
                alert(r.msg);
            }
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		projectBankAccount: {},
        bankDicJson:[],
        config: {},
        queries:{
            accountNo: null,
            proNo:null,
            accountName:null
        }
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.projectBankAccount = {};
            this.loadDic();
            this.init();
		},
		update: function (event) {
			var accountId = getSelectedRow();
			if(accountId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            vm.getInfo(accountId)
		},
		saveOrUpdate: function (event) {
            var url = vm.projectBankAccount.accountId == null ? "sys/projectbankaccount/save" : "sys/projectbankaccount/update";
            var bootstrapValidator = $("#projectForm").data('bootstrapValidator');
            bootstrapValidator.validate();
            if(bootstrapValidator.isValid()){
                $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                    $.ajax({
                        type: "POST",
                        url: baseURL + url,
                        contentType: "application/json",
                        data: JSON.stringify(vm.projectBankAccount),
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
			var accountIds = getSelectedRows();
			if(accountIds == null){
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
                        url: baseURL + "sys/projectbankaccount/delete",
                        contentType: "application/json",
                        data: JSON.stringify(accountIds),
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
		getInfo: function(accountId){
			$.get(baseURL + "sys/projectbankaccount/info/"+accountId, function(r){
                vm.projectBankAccount = r.projectBankAccount;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{
                    'accountNo': vm.queries.accountNo,
                    'proNo': vm.queries.proNo,
                    'accountName': vm.queries.accountName
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
        getConfig: function () {
            $.getJSON(baseURL + "sys/oss/config", function(r){
                vm.config = r.config;
            });
        },
        changeId:function(){
		    var text=$("#bankDicId").find('option:selected').text();
		    var code=$("#bankDicId").find('option:selected').attr("code");
            vm.projectBankAccount.bankCode=code;
            vm.projectBankAccount.bankName=text;
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
                    busCode: {
                        message: '输入内容有误',
                        validators: {
                            notEmpty: {
                                message: '请输入企业统一社会信用代码'
                            },
                            regexp: {
                                regexp:/^[1-9A-GY]{1}[1239]{1}[1-5]{1}[0-9]{5}[0-9A-Z]{10}$/,
                                message: '企业统一社会信用代码格式错误'
                            }
                        }
                    },
                    proNo:{
                        validators: {
                            notEmpty: {
                                message: '请输入项目编号'
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
                    accountNo:{
                        validators: {
                            notEmpty: {
                                message: '请输入工资专用账户账号'
                            },
                            regexp: {
                                regexp:/^(0[1-9][0-9]*)$/ ,
                                message: '账户号只能输入数字'
                            }
                        }
                    },
                    accountName:{
                        validators: {
                            notEmpty: {
                                message: '请输入专户开户户名'
                            }
                        }
                    },
                    accountNet:{
                        validators: {
                            notEmpty: {
                                message: '请输入专户开户网点'
                            }
                        }
                    }
                }
            });
        }
	},
    created(){
        this.getConfig();
    }
});