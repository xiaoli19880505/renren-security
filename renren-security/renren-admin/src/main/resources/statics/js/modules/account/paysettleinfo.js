$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/paysettleinfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'seetleId', name: 'seetleId', index: 'seetle_id', width: 80, key: true },
			{ label: '项目编号', name: 'proNo', index: 'pro_no', width: 100 },
			{ label: '工人身份证号', name: 'workerSfzh', index: 'worker_sfzh', width: 200 },
			{ label: '发放批次号', name: 'grantBatchNo', index: 'grant_batch_no', width: 80 }, 			
			{ label: '银行名称', name: 'bankName', index: 'bank_name', width: 100 },
			{ label: '工资发放日期', name: 'payGrantTime', index: 'pay_grant_time', width: 150 },
			{ label: '工资开始时间', name: 'payBeginTime', index: 'pay_begin_time', width: 150 },
			{ label: '工资截止时间', name: 'payEndTime', index: 'pay_end_time', width: 150 },
			{ label: '应发工资', name: 'payTotal', index: 'pay_total', width: 100 },
			{ label: '预发工资', name: 'payPrepare', index: 'pay_prepare', width: 100 },
			{ label: '实发工资', name: 'payReal', index: 'pay_real', width: 100 },
			{ label: '记录时间', name: 'recordTime', index: 'record_time', width: 150 },
			{ label: '工人银行卡号', name: 'workerAccount', index: 'worker_account', width: 200 },
			{ label: '备注', name: 'remark', index: 'remark', width: 80 }, 			
			{ label: '上传人', name: 'createPersonId', index: 'create_person_id', width: 80 }, 			
			{ label: '上传时间', name: 'createTime', index: 'create_time', width: 150 }
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        shrinkToFit:false,
        autoScroll: true,
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
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "scroll" });
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		paySettleInfo: {},
        queries:{
            proNo:null,
            workerSfzh: null,
            workerAccount:null
        }
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.paySettleInfo = {};
			this.init();
		},
		update: function (event) {
			var seetleId = getSelectedRow();
			if(seetleId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(seetleId)
		},
		saveOrUpdate: function (event) {
            var url = vm.paySettleInfo.seetleId == null ? "sys/paysettleinfo/save" : "sys/paysettleinfo/update";
            var bootstrapValidator = $("#projectForm").data('bootstrapValidator');
            bootstrapValidator.validate();
            if(bootstrapValidator.isValid()){
                $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                    $.ajax({
                        type: "POST",
                        url: baseURL + url,
                        contentType: "application/json",
                        data: JSON.stringify(vm.paySettleInfo),
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
			var seetleIds = getSelectedRows();
			if(seetleIds == null){
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
                        url: baseURL + "sys/paysettleinfo/delete",
                        contentType: "application/json",
                        data: JSON.stringify(seetleIds),
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
		getInfo: function(seetleId){
			$.get(baseURL + "sys/paysettleinfo/info/"+seetleId, function(r){
                vm.paySettleInfo = r.paySettleInfo;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
			    postData:{
                    queries:{
                        proNo:vm.queries.proNo,
                        workerSfzh: vm.queries.workerSfzh,
                        workerAccount:vm.queries.workerAccount
                    }
                },
                page:page
            }).trigger("reloadGrid");
            $('#projectForm').data('bootstrapValidator').resetForm(true);
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
                    proNo:{
                        validators: {
                            notEmpty: {
                                message: '请输入项目编号'
                            }
                        }
                    },
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
                    grantBatchNo:{
                        validators: {
                            notEmpty: {
                                message: '请输入发放批次号'
                            }
                        }
                    },
                    bankName:{
                        validators: {
                            notEmpty: {
                                message: '请输入银行名称'
                            }
                        }
                    },
                    workerAccount:{
                        validators: {
                            notEmpty: {
                                message: '请输入工人银行卡号'
                            },
                            regexp: {
                                regexp:/^(0|[1-9][0-9]*)$/,
                                message: '工人银行卡号只能输入数字'
                            }
                        }
                    },
                    payGrantTime:{
                        trigger:'change',
                        validators: {
                            notEmpty: {
                                message: '选择工资发放日期'
                            }
                        }
                    },
                    payBeginTime:{
                        trigger:'change',
                        validators: {
                            notEmpty: {
                                message: '请选择工资开始时间'
                            }
                        }
                    },
                    payEndTime:{
                        trigger:'change',
                        validators: {
                            notEmpty: {
                                message: '请选择工资截止时间'
                            },
                            callback: {
                                message: '截止日期不能小于开始日期',
                                callback:function(value, validator,$field,options){
                                    var begin=new Date($("#payBeginTime").val().replace(/-/g,"/"));
                                    var end=new Date(value.replace(/-/g,"/"));
                                    if(begin-end>0){
                                        return false;
                                    }else{
                                        return true
                                    }
                                }
                            }
                        }
                    },
                    payTotal:{
                        validators: {
                            notEmpty: {
                                message: '请输入应发工资'
                            },
                            regexp: {
                                regexp: /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/ ,
                                message: '金额必须大于0，且最多含有2位小数!'
                            }
                        }
                    },
                    payPrepare:{
                        validators: {
                            notEmpty: {
                                message: '请输入预发工资'
                            },
                            regexp: {
                                regexp: /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/ ,
                                message: '金额必须大于0，且最多含有2位小数!'
                            }
                        }
                    },
                    payReal:{
                        validators: {
                            notEmpty: {
                                message: '请输入实发工资'
                            },
                            regexp: {
                                regexp: /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/ ,
                                message: '金额必须大于0，且最多含有2位小数!'
                            }
                        }
                    },
                    recordTime:{
                        trigger:'change',
                        validators: {
                            notEmpty: {
                                message: '请选择记录时间'
                            }
                        }
                    },
                }
            });
        }
	},
    mounted(){
        $('.timeGroup').datetimepicker({
            format:'yyyy-mm-dd hh:ii:ss',
            language:  'zh-CN',
            weekStart: 0, //一周从哪一天开始
            todayBtn:true, //
            autoclose:true,//选择后立即关闭
            startView: 2,//从月开始
            minView:0,//最精确视图
            forceParse: false,//是否强制转换
            pickerPosition:'bottom-left'
        }).on('hide', function (ev) {
            var value = $(ev.currentTarget).find('input').val();
            var modelName=$(ev.currentTarget).find('input').attr("name");
            vm.paySettleInfo[modelName] = value;
        });;
        $('#payGrantTime').datetimepicker({
            format:'yyyy-mm-dd',
            language:  'zh-CN',
            weekStart: 0, //一周从哪一天开始
            todayBtn:true, //
            autoclose:true,
            todayHighlight: 1,
            startView: 2,
            minView:2,
            pickerPosition:'bottom-left'
        }).on('hide', function (ev) {
            var value = $(ev.currentTarget).find('input').val();
            var modelName=$(ev.currentTarget).find('input').attr("name");
            vm.paySettleInfo[modelName] = value;
        });;

    }
});