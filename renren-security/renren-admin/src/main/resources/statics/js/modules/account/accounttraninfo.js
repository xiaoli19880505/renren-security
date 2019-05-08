$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/accounttraninfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'tranId', name: 'tranId', index: 'tran_id', width: 50, key: true },
			{ label: '项目专户id', name: 'accountId', index: 'account_id', width: 80 }, 			
			{ label: '交易金额', name: 'tranMon', index: 'tran_mon', width: 80 }, 			
			{ label: '专户余额', name: 'accountRemain', index: 'account_remain', width: 80 }, 			
			{ label: '交易状态', name: 'tranState', index: 'tran_state', width: 80 }, 			
			{ label: '进账账号', name: 'incomeAccountNo', index: 'income_account_no', width: 80 }, 			
			{ label: '进账单位名称', name: 'incomeUnitName', index: 'income_unit_name', width: 80 }, 			
			{ label: '出账批次号', name: 'outcomeBatchNo', index: 'outcome_batch_no', width: 80 }, 			
			{ label: '记录登记时间', name: 'recordTime', index: 'record_time', width: 80 }, 			
			{ label: '工资单开始时间', name: 'payslipBeginTime', index: 'payslip_begin_time', width: 80 }, 			
			{ label: '工资单结束时间', name: 'payslipEndTime', index: 'payslip_end_time', width: 80 }, 			
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
		showList: true,
		title: null,
		accountTranInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "上传";
			vm.accountTranInfo = {};
		},
		update: function (event) {
			var tranId = getSelectedRow();
			if(tranId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(tranId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.accountTranInfo.tranId == null ? "sys/accounttraninfo/save" : "sys/accounttraninfo/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.accountTranInfo),
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
		},
		del: function (event) {
			var tranIds = getSelectedRows();
			if(tranIds == null){
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
                        url: baseURL + "sys/accounttraninfo/delete",
                        contentType: "application/json",
                        data: JSON.stringify(tranIds),
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
		getInfo: function(tranId){
			$.get(baseURL + "sys/accounttraninfo/info/"+tranId, function(r){
                vm.accountTranInfo = r.accountTranInfo;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});