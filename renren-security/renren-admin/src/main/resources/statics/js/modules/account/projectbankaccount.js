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
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		projectBankAccount: {},
        bankDicJson:[]
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.projectBankAccount = {};
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
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.projectBankAccount.accountId == null ? "sys/projectbankaccount/save" : "sys/projectbankaccount/update";
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
                page:page
            }).trigger("reloadGrid");
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
        }
	},
    mounted(){
	    this.loadDic();
    }
});