var app = angular.module("crmApp",['ui.bootstrap','ui.router']);
app.value("color",{"blue":"#00b8ec","red":"#ff1466","green":"#23ca89","gray":"#7a7a7a","orange":"#ff8a23"});
app.provider("colorService", function(){
	var data = {color:null, flag:true};
	var f = function(color, flag){
		if (color != null){
			data.color = color;
			data.flag = flag;
		}
		return data;
	};
	this.$get = function(){
		return f;
	};
});

		app.config(function($stateProvider, $urlRouterProvider){
		$urlRouterProvider.otherwise("login");
		$stateProvider.state("login",{
		url : "/login",
		templateUrl : "login.html",
		controller : "loginCtrl"
		}).state("main",{ 
			url : "/main",
			templateUrl : "main.html",
			controller : "mainCtrl"
		}).state("main.marketingPlan",{ //销售计划
			url : "/marketingPlan",
			templateUrl : "marketing/marketingPlan.html",
			controller : "marketingPlanCtrl"
		}).state("main.performance",{ //销售绩效
			url : "/performance",
			templateUrl : "marketing/performance.html",
			controller : "performanceCtrl"
		}).state("main.analyze",{ //销售分析
			url : "/analyze",
			templateUrl : "marketing/analyze.html",
			controller : "analyzeCtrl"
		}).state("main.forecast",{ //销售预测
			url : "/forecast",
			templateUrl : "marketing/forecast.html",
			controller : "forecastCtrl"
		}).state("main.chanceManage",{ //机会管理
			url : "/chanceManage",
			templateUrl : "marketing/chanceManage.html",
			controller : "chanceManage"
		}).state("main.contacts",{ //联系人
			url : "/contacts",
			templateUrl : "marketing/contacts.html",
			controller : "contactsCtrl"
		}).state("main.comAnalysis",{ //竞争分析
			url : "/comAnalysis",
			templateUrl : "marketing/comAnalysis.html",
			controller : "comAnalysisCtrl"
		}).state("main.orderIndex",{ //带下订单
			url : "/orderIndex",
			templateUrl : "order/orderIndex.html",
			controller : "orderIndexCtrl"
		}).state("main.orderCheck",{ //订单查看
			url : "/orderCheck",
			templateUrl : "order/orderCheck.html",
			controller : "orderCheckCtrl"
		}).state("main.orderStatistics",{ //订单统计
			url : "/orderStatistics",
			templateUrl : "order/orderStatistics.html",
			controller : "orderStatisticsCtrl"
		}).state("main.newContract",{ //创建合同
			url : "/newContract",
			templateUrl : "contract/newContract.html",
			controller : "newContractCtrl"
		}).state("main.contractCheck",{ //查看合同
			url : "/contractCheck",
			templateUrl : "contract/contractCheck.html",
			controller : "contractCheckCtrl"
		}).state("main.audit",{ //审核合同
			url : "/audit",
			templateUrl : "contract/audit.html",
			controller : "auditCtrl"
		}).state("main.custResources",{ //客户资源
			url : "/custResources",
			templateUrl : "customer/custResources.html",
			controller : "custResourcesCtrl"
		}).state("main.custPlan",{ //客户计划
			url : "/custPlan",
			templateUrl : "customer/custPlan.html",
			controller : "custPlanCtrl"
		}).state("main.custValue",{ //客户价值
			url : "/custValue",
			templateUrl : "customer/custValue.html",
			controller : "custValueCtrl"
//			controller : "custResourcesCtrl"
		}).state("main.custCredit",{ //客户信誉
			url : "/custCredit",
			templateUrl : "customer/custCredit.html",
			controller : "custCreditCtrl"
		}).state("main.satisfaction",{ //客户满意度
			url : "/satisfaction",
			templateUrl : "customer/satisfaction.html",
			controller : "satisfactionCtrl"
		}).state("main.custCare",{ //客户关怀
			url : "/custCare",
			templateUrl : "customer/custCare.html",
			controller : "custCareCtrl"
		}).state("main.serviceCheck",{ //查看服务
			url : "/serviceCheck",
			templateUrl : "service/serviceCheck.html",
			controller : "serviceCheckCtrl"
		}).state("main.faq",{ //常见问题
			url : "/faq",
			templateUrl : "service/faq.html",
			controller : "faqCtrl"
		}).state("main.constitute",{ //客户构成统计
			url : "/constitute",
			templateUrl : "analyze/constitute.html",
			controller : "constituteCtrl"
		}).state("main.loss",{ //客户流失统计
			url : "/loss",
			templateUrl : "analyze/loss.html",
			controller : "lossCtrl"
		}).state("main.contribution",{ //客户贡献统计
			url : "/contribution",
			templateUrl : "analyze/contribution.html",
			controller : "contributionCtrl"
		}).state("main.serviceAnalyze",{ //客户服务统计
			url : "/serviceAnalyze",
			templateUrl : "analyze/serviceAnalyze.html",
			controller : "serviceAnalyzeCtrl"
		}).state("main.personCenter",{ //个人中心
			url : "/personCenter",
			templateUrl : "setting/personCenter.html",
			controller : "personCenterCtrl"
		}).state("main.organization",{ //组织结构
			url : "/organization",
			templateUrl : "setting/organization.html",
			controller : "organizationCtrl"
		}).state("main.notice",{ //公告管理
			url : "/notice",
			templateUrl : "setting/notice.html",
			controller : "noticeCtrl"
		}).state("main.staff",{ //员工管理
			url : "/staff",
			templateUrl : "setting/staff.html",
			controller : "staffCtrl"
		}).state("main.basicSetting",{ //基础设置
			url : "/basicSetting",
			templateUrl : "setting/basicSetting.html",
			controller : "basicSettingCtrl"
		}).state("main.dataDict",{ //数据字典
			url : "/dataDict",
			templateUrl : "setting/dataDict.html",
			controller : "dataDictCtrl"
		}).state("main.role",{ //角色管理
			url : "/role",
			templateUrl : "setting/role.html",
			controller : "roleCtrl"
		});
});
	
app.config(function ($httpProvider) {
    $httpProvider.interceptors.push(['$rootScope', '$q', '$location',
        function ($rootScope, $q, $location) {
            return {
                'request': function (config) {
                    //处理AJAX请求（否则后台IsAjaxRequest()始终false）
                    config.headers['X-Requested-With'] = 'XMLHttpRequest';
                    return config || $q.when(config);
                },
                'requestError': function (rejection) {
                    return rejection;0.
                },
                'response': function (response) {
                    return response || $q.when(response);
                },
                'responseError': function (response) {
                    console.log('responseError:' + response);
                    if (response.status === 600 ) {
                        alert("会话超时，请重新登录！");
                        window.location.href = "./";
                    }else if(response.status === 601 ){
                    	alert("无权访问该页面");
                    }
                    return $q.reject(response);
                }
            };
        }]);
});	
		
		
		
//自定义

app.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

app.controller("loginCtrl", function($scope, $state, $http){
	$scope.user = {
			username : "",
			password : "",
			remember : false
	};
	$http({
		url : "cookie",
		method : "post"
	}).then(function(resp){
		$scope.user = resp.data.tempUser;
	});
	$scope.login = function(){
		if ($scope.user.username == null || $scope.user.password == null){
			alert("账号或密码不能为空");
		}
		//------AJAX----------------------
		$http({
			url : 'login',
			method : 'post',
		    params : $scope.user
		}).then(function(result){
			 var data = result.data.trim();
			   if(data == '登录成功'){
				   $state.go("main.personCenter");
			   }else{
				   alert(data);
			   }
		});
		//------AJAX-END----------------------
	}

	});
app.controller("mainCtrl", function($scope, $rootScope, color, $state, $uibModal, $http, $stateParams){
	//主页面退出返回到登录界面
	$scope.exit = function(){
		$state.go("login");
	}
	
	$scope.goPage = function(index){
		$state.go(this.c.url);
		$scope.childIsSelected = index;
	};
	$rootScope.themeColor = color.blue;
	
	$scope.menus =[];
	var temps = [];
    //------AJAX----------------------
	
	$http({
		url : 'menu',
		method : 'post',
	}).then(function(result){
		$scope.menus = result.data.menus;
		console.log($scope.menus);
		$scope.childMenu =  $scope.menus[0].childMenu;
		$scope.poitMenu($scope.menus.length - 1);
	});
	
	
	 $scope.poitMenu = function(index){
		 $scope.childMenu =  $scope.menus[index].childMenu;
		 $scope.parentIsSelected = index;
		 $scope.childIsSelected = 0;
	 }
	 
	 $http({
		 url : 'PersonCenterGetInfoServlet',
		 method : 'post'
	 }).then(function(result){
		 $scope.user = result.data.user;
		 console.log($scope.user.themeColor);
		 if ($scope.user.themeColor != ""){
			 $rootScope.themeColor = $scope.user.themeColor;
		 }
	 });
	 
	 $scope.cancel = function(){
		 var isOk = confirm("确认注销账户?");
		 if (isOk){
			 $http({
				 url : 'CancelServlet',
				 method : 'post'
			 }).then(function(result){
				 if (result){
					 alert(result.data);
					 $state.go("login");
				 }else{
					 alert("注销账户失败");
				 }
			 });
		 }
	 };
	 
	 $scope.help = function(){
		 var uibModalInstance = $uibModal.open({
			size : 'md',		//模态框大小
			backdrop : 'static',	//点击不消失
			templateUrl : 'setting/showImg.html',	//模板地址
			controller : function($uibModalInstance,$scope,$http){
				$scope.close = function(){
					$uibModalInstance.dismiss('close');
				}
			}
		 });
	 };
	 
	 $scope.about = function(){
		 var uibModalInstance = $uibModal.open({
			size : 'md',		//模态框大小
			backdrop : 'static',	//点击不消失
			templateUrl : 'setting/showAbout.html',	//模板地址
			controller : function($uibModalInstance,$scope,$http){
				$scope.close = function(){
					$uibModalInstance.dismiss('close');
				}
			}
		 });
	 };
	 
});

/* 陈林林 代码编写处(包含控制器注册 ) 记得先更新后提交 **/


/* 陈林林 代码区域结束 **/


/* 王志涛 代码编写处(包含控制器注册 ) 记得先更新后提交 **/

//代下订单
app.controller("orderIndexCtrl", function($scope, $state, $http){
	$scope.currentPage = 1;
	$scope.totalpage = 0;
	$scope.displyCount = 8;
	
	
	$scope.searchCustName = function(){
		$http({
			url : "Customer",
			method : "post",
			params :{
				custName : $scope.addOrder.custName,
				currentPage : $scope.currentPage,	
				totalpage : $scope.totalpage,
				displyCount : $scope.displyCount
			}
		}).then(function success(resp){
			$scope.custInfo = resp.data.custData;
			$scope.custDisplay = true;
		});
	};
	
	$scope.custDisplay = true;
	$scope.chooseCustName = function(name){
		$scope.addOrder.custName = name;
		$scope.custDisplay = false;
	}
	
	$scope.searchProduct = function(){
		$http({
			url : "searchProduct",
			method : "post",
			params : {
				productName :$scope.addOrder.productName
			}
		}).then(function success(resp){
			console.log(resp.data.productInfo);
			$scope.productInfo = resp.data.productInfo;
			$scope.proDisplay = true;
		});
	}
	
	$scope.proDisplay = true;
	$scope.chooseProduct = function(data){
		$scope.addOrder.productName = data.name;
		$scope.addOrder.price = data.price;
		$scope.proDisplay = false;
	}
	
	$scope.addOrder = {
		custName : '',
		productName: '',
		price : '',
		remark :''
	};
	$scope.add = function(){
		$http({
			url : "addOrder",
			method : "post",
			params : $scope.addOrder
		}).then(function success(resp){
			alert(resp.data);
		});
	};
	
});

//订单查看
app.controller("orderCheckCtrl", function($scope, $state, $http){
	$scope.custName = "";
	$scope.currentPage = 1;
	$scope.showCount = 8;
	$scope.totalPage = 0;
	
	$scope.lastCon;
	
	$scope.search = function(rollPage){
		if(rollPage==undefined){
			$scope.currentPage = 1;
			$scope.lastCon = {
				custName: $scope.custName
			}
		}
		
		$http({
			url : "searchOrder",
			method : "post",
			params : {
				custName : $scope.lastCon.custName,
				currentPage : $scope.currentPage,
				showCount : $scope.showCount
			}
		}).then(function success(resp){
			$scope.totalPage = resp.data.totalPage;
			console.log($scope.orderInfo);
			$scope.orderInfo = resp.data.orderInfo;
		});
	};
	$scope.search();
	
	$scope.gotoPage = function(page){
		if (page == 0 || page > $scope.totalPage)
			return;
		$scope.currentPage = page;
		$scope.search(true);
	};
	
});

//订单统计
app.controller("orderStatisticsCtrl", function($scope, $state, $http, $uibModal){
	
});



//查看服务
app.controller("serviceCheckCtrl", function($scope, $state, $http, $uibModal){
	$scope.userName = "";
	$scope.currentPage = 1;
	$scope.showCount = 8;
	$scope.totalPage = 0;
	
	$scope.lastCon;
	
	$scope.search = function(rollPage){
		if(rollPage==undefined){
			$scope.currentPage = 1;
			$scope.lastCon = {
				userName: $scope.userName
			}
		}
		
		$http({
			url : "serviceSearch",
			method : "post",
			params : {
				userName : $scope.lastCon.userName,
				currentPage : $scope.currentPage,
				showCount : $scope.showCount
			}
		}).then(function success(resp){
			$scope.totalPage = resp.data.totalPage;
			$scope.serviceInfo = resp.data.serviceInfo;
		});
	};
	$scope.search();
	
	$scope.gotoPage = function(page){
		if (page == 0 || page > $scope.totalPage)
			return;
		$scope.currentPage = page;
		$scope.search(true);
	};
	
	//添加服务
	$scope.addService = function(){
		var uibModalInstance = $uibModal.open({
			size : 'md',
			backdrop : 'static',
			templateUrl : 'service/addServiceModal.html',
			controller : function($uibModalInstance,$scope){
				$scope.addService = {
					custName : '',
					serviceContent:''
				};
				
				$scope.add = function(){
					$http({
						url : "addService",
						method : "post",
						params : {
							custName : $scope.addService.custName,
							serviceContent : $scope.addService.serviceContent
						}
					}).then(function success(resp){
						alert(resp.data);
					},function(){
						alert("添加失败,请检查网络后再次尝试");
					});
					
					$scope.cancel();
				}
				
				$scope.cancel = function(){
					$uibModalInstance.dismiss('cancel');
				}
			}
		});
	}

	
	//修改服务
	$scope.modifyService = function(data){
		var parent = $scope;
		$http({
			url : "searchServiceBack",
			method : "post",
			params : {
				id : data.id
			}
		}).then(function success(resp){
			parent.serviceBack = resp.data;
			
			//服务的处理过程和结果，服务反馈查出来后跳出来模态框
			var uibModalInstance = $uibModal.open({
				size : 'md',
				backdrop : 'static',
				templateUrl : 'service/modifyServiceModal.html',
				controller : function($uibModalInstance,$scope){
					$scope.modifyService = {
						custName : data.custName,
						status : data.value,
						serviceContent:data.serverContent,
						process : parent.serviceBack.process,
						result : parent.serviceBack.result,
						back : parent.serviceBack.back
					};
					
					//点击修改后将服务内容更新
					$scope.modify = function(){
						
						$http({
							url : "modifyService",
							method : "post",
							params : {
								id : data.id,
								status : $scope.modifyService.status,
								serviceContent : $scope.modifyService.serviceContent,
								process : $scope.modifyService.process,
								result : $scope.modifyService.result,
								back : $scope.modifyService.back
							}
						}).then(function success(resp){
							parent.search();
							alert(resp.data);
						},function(){
							alert("修改失败,请检查网络后再次尝试");
						});
						
						$scope.cancel();
					}
					
					//点击关闭后关闭模态框
					$scope.cancel = function(){
						$uibModalInstance.dismiss('cancel');
					}
				}
			});
		},function(){
			alert("加载失败,请检查网络后再次尝试");
		});
			
	}
	
	
	//查看服务详细信息
	$scope.serviceDetails = function(data){
		var parent = $scope;
		
		//发出请求将详细信息查出
		$http({
			url : "searchServiceBack",
			method : "post",
			params : {
				id : data.id
			}
		}).then(function success(resp){
			parent.serviceBack = resp.data;
			
			//服务的处理过程和结果，服务反馈查出来后跳出来模态框
			var uibModalInstance = $uibModal.open({
				size : 'md',
				backdrop : 'static',
				templateUrl : 'service/serviceDetailsModal.html',
				controller : function($uibModalInstance,$scope){
					$scope.modifyService = {
						userName : data.userName,
						custName : data.custName,
						status : data.value,
						serviceContent:data.serverContent,
						process : parent.serviceBack.process,
						result : parent.serviceBack.result,
						back : parent.serviceBack.back
					};
					//点击关闭后关闭模态框
					$scope.cancel = function(){
						$uibModalInstance.dismiss('cancel');
					}
				}
			});
		},function(){
			alert("加载失败,请检查网络后再次尝试");
		});
			
	}
	
	$scope.chooseAll = false;
	$scope.chooseDatas = [];
	$scope.chooseAllData = function(){
		for(var i in $scope.serviceInfo){
			$scope.serviceInfo[i].choose = $scope.chooseAll;
			if($scope.chooseAll){
				$scope.chooseDatas.push($scope.serviceInfo[i].id);
			}else{
				$scope.chooseDatas = [];
			}
		}
	}
	
	$scope.chooseData = function(data){
		
		if(data.choose){
			$scope.chooseDatas.push(data.id);
		}else{
			for(var i in $scope.chooseDatas){
				if(data.id == $scope.chooseDatas[i]){
					$scope.chooseDatas.splice(i,1);
					break;
				}
			}
		}
		$scope.chooseAll = $scope.chooseDatas.length == $scope.serviceInfo.length;
	}
	
	//删除服务信息
	$scope.deleteService = function(id){
		
		if(id != undefined){
			$scope.chooseDatas.length = 0;
			$scope.chooseDatas.push(id);
		}
		if($scope.chooseDatas.length == 0){
			alert("请选择要删除的信息!");
			return;
		}
		console.log($scope.chooseDatas);
		var result = confirm("确认要删除该服务信息吗");
		if(result){
			$http({
				url : "deleteService",
				method : "post",
				params : {
					deleteData :$scope.chooseDatas
				}
			}).then(function success(resp){
				$scope.search();
				alert(resp.data);
			},function(){
				alert("删除失败,请检查网络后再次尝试");
			});
		}else{
			$scope.chooseDatas.length = 0;//将选中的要删除的信息清空
		}
	}
	
	
	$scope.allotDatas = [];
	//分配服务详细信息
	$scope.allotService = function(data){
		var parent = $scope;//将$scope存起来与模态框中的$scope相区分
		
		//判断是行级分配还是批量分配，并将已经处理过的服务筛除
		if(data == undefined){
			for(var i in $scope.chooseDatas){
				for(var j in $scope.serviceInfo){
					if($scope.chooseDatas[i] == $scope.serviceInfo[j].id){
						if($scope.serviceInfo[j].value == '已提交'){
							$scope.allotDatas.push($scope.serviceInfo[j]);
						}
					}
					
				}
			}
			if($scope.allotDatas.length == 0){
				alert("没有选中状态为已提交的服务，请重新选择");
				return;
			}
			if($scope.chooseDatas.length != $scope.allotDatas.length){
				alert("选中的服务有已处理过的，已自动为您筛选");
			}
		}else{
			for(var i in $scope.serviceInfo){
				if(data == $scope.serviceInfo[i].id ){
					$scope.allotDatas.push($scope.serviceInfo[i]);
				}
			}
		}
		var uibModalInstance = $uibModal.open({
			size : 'md',
			backdrop : 'static',
			templateUrl : 'service/allotServiceModal.html',
			controller : function($uibModalInstance,$scope){
				$scope.allotService = parent.allotDatas;
				$scope.userName = '';
				$scope.searchUser = function(){
					//发出请求将销售代表查出
					$http({
						url : "searchUser",
						method : "post",
						params : {
							userName: $scope.userName
						}
					}).then(function success(resp){
						console.log(resp.data)
						$scope.users = resp.data.users;
						$scope.isDisplay = true;
					},function(){
						alert("加载失败,请检查网络后再次尝试");
					});
				}
				
				//搜索提示是否显示
				$scope.isDisplay = true;
				
				//选中搜索提示为输入框赋值
				$scope.chooseValue = function(data){
					$scope.userName = data;
					$scope.isDisplay = false;
				}
				
				//点击分配后进行分配请求
				$scope.allot = function(){
					$scope.allotIds = [];
					for(var i in $scope.allotService){
						$scope.allotIds[i] = $scope.allotService[i].id;
					}
					console.log($scope.allotIds);
					//发出请求将服务进行分配
					$http({
						url : "allotService",
						method : "post",
						params : {
							ids : $scope.allotIds,
							userName: $scope.userName
						}
					}).then(function success(resp){
						alert(resp.data);
						parent.search();
						$scope.cancel();
					},function(){
						alert("加载失败,请检查网络后再次尝试");
						$scope.cancel();
					});
					
					
				}
				
				//点击关闭后关闭模态框
				$scope.cancel = function(){
					parent.allotDatas.length = 0;
					$uibModalInstance.dismiss('cancel');
				}
			}
		});
		
	}
	
	
});


app.controller("faqCtrl", function($scope, $state, $http,$uibModal){
	
	$scope.title = "";
	$scope.currentPage = 1;
	$scope.showCount = 8;
	$scope.totalPage = 0;
	
	$scope.lastCon;
	
	$scope.search = function(rollPage){
		if(rollPage==undefined){
			$scope.currentPage = 1;
			$scope.lastCon = {
				title: $scope.title
			}
		}
		
		$http({
			url : "faqSearch",
			method : "post",
			params : {
				title : $scope.lastCon.title,
				currentPage : $scope.currentPage,
				showCount : $scope.showCount
			}
		}).then(function success(resp){
			$scope.totalPage = resp.data.totalPage;
			$scope.faqInfo = resp.data.faqInfo;
		});
	};
	$scope.search();
	
	$scope.gotoPage = function(page){
		if (page == 0 || page > $scope.totalPage)
			return;
		$scope.currentPage = page;
		$scope.search(true);
	};

	$scope.faqDetails = function(faq){
		var parent = $scope;
		var uibModalInstance = $uibModal.open({
			size : 'md',
			backdrop : 'static',
			templateUrl : 'service/faqDetailsModal.html',
			controller : function($uibModalInstance,$scope){
				$scope.faqDetails = {
					title : faq.title,
					content: faq.content
				};
				
				//点击关闭后关闭模态框
				$scope.cancel = function(){
					$uibModalInstance.dismiss('cancel');
				}
			}
		});
	}
	
	$scope.addFaq = function(){
		var parent = $scope;
		var uibModalInstance = $uibModal.open({
			size : 'md',
			backdrop : 'static',
			templateUrl : 'service/addFaqModal.html',
			controller : function($uibModalInstance,$scope){
				$scope.addFaq = {
					title : '',
					content: ''
				};
				
				$scope.add = function(){
					$http({
						url : "addFaq",
						method : "post",
						params : {
							title : $scope.addFaq.title,
							content:$scope.addFaq.content
						}
					}).then(function success(resp){
						alert(resp.data);
					});
					$scope.cancel();
				}
				
				//点击关闭后关闭模态框
				$scope.cancel = function(){
					$uibModalInstance.dismiss('cancel');
				}
			}
		});
	}
	
	$scope.modifyFaq = function(faq){
		var parent = $scope;
		var uibModalInstance = $uibModal.open({
			size : 'md',
			backdrop : 'static',
			templateUrl : 'service/modifyFaqModal.html',
			controller : function($uibModalInstance,$scope){
				$scope.modifyFaq = {
					id :faq.id,
					title : faq.title,
					content: faq.content
				};
				
				$scope.modify = function(){
					$http({
						url : "modifyFaq",
						method : "post",
						params : {
							id : $scope.modifyFaq.id,
							title : $scope.modifyFaq.title,
							content:$scope.modifyFaq.content
						}
					}).then(function success(resp){
						alert(resp.data);
					});
					$scope.cancel();
				}
				
				//点击关闭后关闭模态框
				$scope.cancel = function(){
					$uibModalInstance.dismiss('cancel');
				}
			}
		});
	}
	
	
	$scope.chooseAll = false;
	$scope.chooseDatas = [];
	$scope.chooseAllData = function(){
		for(var i in $scope.faqInfo){
			$scope.faqInfo[i].choose = $scope.chooseAll;
			if($scope.chooseAll){
				$scope.chooseDatas.push($scope.faqInfo[i].id);
			}else{
				$scope.chooseDatas = [];
			}
		}
	}
	
	$scope.chooseData = function(data){
		
		if(data.choose){
			$scope.chooseDatas.push(data.id);
		}else{
			for(var i in $scope.chooseDatas){
				if(data.id == $scope.chooseDatas[i]){
					$scope.chooseDatas.splice(i,1);
					break;
				}
			}
		}
		$scope.chooseAll = $scope.chooseDatas.length == $scope.faqInfo.length;
	}
	
	//删除常见问题信息
	$scope.deleteFaq = function(id){
		
		if(id != undefined){
			$scope.chooseDatas.length = 0;
			$scope.chooseDatas.push(id);
		}
		if($scope.chooseDatas.length == 0){
			alert("请选择要删除的信息!");
			return;
		}
		console.log($scope.chooseDatas);
		var result = confirm("确认要删除该问题信息吗");
		if(result){
			$http({
				url : "deleteFaq",
				method : "post",
				params : {
					chooseIds :$scope.chooseDatas
				}
			}).then(function success(resp){
				$scope.search();
				alert(resp.data);
			},function(){
				alert("删除失败,请检查网络后再次尝试");
			});
		}else{
			$scope.chooseDatas.length = 0;//将选中的要删除的信息清空
		}
	}
	
});

/* 王志涛 代码区域结束 **/


/* 李思臣 代码编写处(包含控制器注册 ) 记得先更新后提交 **/

app.controller("auditCtrl", function($scope, $uibModal, $state, $http, $stateParams){
	
});

app.controller("contractCheckCtrl", function($scope, $uibModal, $state, $http, $stateParams){
	
});

app.controller("newContractCtrl", function($scope, $uibModal, $state, $http, $stateParams){
	
});

app.controller("constituteCtrl", function($scope, $uibModal, $state, $http, $stateParams){
	
});

app.controller("contributionCtrl", function($scope, $uibModal, $state, $http, $stateParams){
	
});

app.controller("lossCtrl", function($scope, $uibModal, $state, $http, $stateParams){
	
});

app.controller("serviceAnalyzeCtrl", function($scope, $uibModal, $state, $http, $stateParams){
	
});

app.controller("personCenterCtrl", function($scope, $uibModal, $state, $http, $stateParams){
	$scope.flush = function(){
		$http({
			url : 'PersonCenterGetInfoServlet',
			method : 'post'
		}).then(function(result){
			$scope.user = result.data.user;
			$scope.gender = $scope.user.sex == 1?"男" : "女";
			$scope.notices = result.data.notices;
		});
	};
	$scope.gender = "男";
	$scope.flush();
	$scope.showPersonCenterUpdateModal = function(){
		var parent = $scope;
		var uibModalInstance = $uibModal.open({
			size : 'md',		//模态框大小
			backdrop : 'static',	//点击不消失
			templateUrl : 'setting/personCenterUpdateModal.html',	//模板地址
			controller : function($uibModalInstance,$scope,$http){
				$scope.sex = parent.gender;
				$scope.close = function(){
					$uibModalInstance.dismiss('close');
				}
				$scope.updateUser = {
					section : parent.user.section,
					role : parent.user.role,
					id : parent.user.id,
					name : parent.user.name,
					username : parent.user.username,
					mobile : parent.user.mobile,
					sex : parent.user.sex,
					address : parent.user.address,
					age : parent.user.age,
					status : parent.user.status,
					sectionID : parent.user.sectionID,
					lockingTime : parent.user.lockingTime
				};
				$scope.updateOne = function(){
					if ($scope.updateUser.address == null || $scope.updateUser.mobile == null || $scope.updateUser.section == null || $scope.updateUser.role == null){
						alert("手机、地址、部门、职位不能为空");
					}
					$http({
						url : 'PersonCenterInfoUpdateServlet',
						method : 'post',
						params : $scope.updateUser
					}).then(function(result){
						var data = result.data;
						alert(data);
						$http({
							url : 'PersonCenterGetInfoServlet',
							method : 'post'
						}).then(function(result){
							parent.user = result.data.user;
							$scope.notices = result.data.notices;
						});
						$scope.close();
					});
				};
			}
		});
	};
	
	//日历
	$("#example").popover();
	var months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
	var header_color = ['#1E88E5','#039BE5','#00897B','#7CB342','#FFB300','#F4511E','#8E24AA','#5E35B1','#E53935','#8E24AA','#6D4C41','#546E7A'];
	var flag = 0;
	var now = new Date();
	var yyyy = now.getFullYear();
	var mm = now.getMonth() + 1;
	var dd = now.getDate();
	var timey = yyyy;
	var timem = mm;
	calculationCalendar(yyyy,mm);
	
	function calculationCalendar(year,month){
		var time = new Date(year, month, 0);
		var currentMonthDays = time.getDate();
		time.setDate(1);
		var week = time.getDay();
		if (week == 0)
			week = 7;
		var lastMonthShowDays = week - 1;
		time.setMonth(month - 1);
		time.setDate(0);
		var lastMonthDays = time.getDate();
		var dateArr = [];
		var startIndex = 0,endIndex = 0;
		for (var i = lastMonthDays - lastMonthShowDays + 1; i <= lastMonthDays; i++){
			dateArr.push(i);
			startIndex += 1;
			endIndex += 1;
		}
		for (var i = 1; i <= currentMonthDays; i++){
			dateArr.push(i);
			endIndex += 1;
		}
		var nextMonthDays = 42 - lastMonthShowDays - currentMonthDays;
		for (var i = 1; i <= nextMonthDays; i++){
			dateArr.push(i);
		}
		var html = '<div class="weeks"><div class="cell-week">MON</div><div class="cell-week">TUE</div><div class="cell-week">WED</div><div class="cell-week">THU</div><div class="cell-week">FRI</div><div class="cell-week">SAT</div><div class="cell-week">SUN</div></div>';
		for (var i = 0; i < dateArr.length; i++){
			if (i % 7 == 0){
				if (i >= startIndex && i < endIndex){
					html += "<div class='row'><div class='currentMonth'>" + dateArr[i] + "</div>";
				}else{
					html += "<div class='row'><div class='noCurrentMonth'>" + dateArr[i] + "</div>";
				}
			}else if(i % 7 == 6){
				if (i >= startIndex && i < endIndex){
					html += "<div class='currentMonth'>" + dateArr[i] + "</div></div>";
				}else{
					html += "<div class='noCurrentMonth'>" + dateArr[i] + "</div></div>";
				}
			}else{
				if (i >= startIndex && i < endIndex){
					html += "<div class='currentMonth'>" + dateArr[i] + "</div>";
				}else{
					html += "<div class='noCurrentMonth'>" + dateArr[i] + "</div>";
				}
				
			}
		}
		$(".render-a>.calendar_table").append(html);
		$('.row>div').addClass("cell");
		var yearAndMonth = months[month - 1]+ " " + year;
		$('.header>.text').text(yearAndMonth);
		if (year == yyyy && month == mm){
				$($('.currentMonth')[dd - 1]).addClass("currentDay");
		}
		setColor(month);
	};
	
	
	$(".prev-month").on("click",function(){
		$(".render-a>.calendar_table>div").remove();
		timem -= 1;
		if (timem == 0){
			timey -= 1;
			timem = 12;
		}
		calculationCalendar(timey,timem);
		if (flag == 0){
			flag = 360;
		}else{
			flag = 0;
		}
		exchangeDeg(flag);
	});
	
	$(".next-month").on("click",function(){
		$(".render-a>.calendar_table>div").remove();
		timem += 1;
		if (timem == 13){
			timey += 1;
			timem = 1;
		}
		calculationCalendar(timey,timem);
		if (flag == 0){
			flag = 360;
		}else{
			flag = 0;
		}
		exchangeDeg(flag);
	});
	
	function setColor(month){
		$(".header").css("background-color", header_color[month - 1]);
		$(".weeks").css("color", header_color[month - 1]);
		$(".currentMonth").css("color", header_color[month - 1]);
		$(".currentDay").css({
			"background-color": header_color[month - 1],
			"color": "white"
		});
		$(".header").css({
			"transform": "rotateX(0deg)",
			"transition": ".4s ease-in-out 0s"
		});
		$(".months").css({
		"transform": "rotateY(0deg)",
		"transition": ".4s ease-in-out 0s"
		});
	};
	
	function exchangeDeg(num){
		$(".header").css({
		"transform": "rotateX(" + num + "deg)",
		"transition": ".4s ease-in-out 0s"
		});
		$(".months").css({
		"transform": "rotateY(" + num + "deg)",
		"transition": ".4s ease-in-out 0s"
		});
	};
	
	
	
});


app.controller("dataDictCtrl", function($scope, $uibModal, $state, $http, $stateParams){
	
});

app.controller("staffCtrl", function($scope, $uibModal, $state, $http, $stateParams){
	$scope.con = {
			name : ""
	};
	$scope.lastCon;
	$scope.currentPage = 1;
	$scope.pageCount = 4;
	$scope.totalPage = 0;
	$scope.rollPage = false;
	$scope.searchUser = function(rollPage){
		if(rollPage == undefined){
			$scope.currentPage = 1;
			$scope.lastCon = {
				name : $scope.con.name
			}
		}
		$http({
			url : 'UserSearchServlet',
			method : 'post',
			params : {
				name : $scope.lastCon.name,
				currentPage : $scope.currentPage,
				pageCount : $scope.pageCount
			}
		}).then(function(result){
			$scope.users = result.data.users;
			$scope.totalPage = result.data.totalPage;
			$scope.rollPage = result.data.totalPage > 0;
		});
	};
	$scope.searchUser();
	$scope.goPage = function(page){
		if (page == 0 || page > $scope.totalPage)
			return;
		$scope.currentPage = page;
		$scope.searchUser(true);
	};
	
    $scope.ids = [];
	
	$scope.checkAllFlag = false;
	
	$scope.checkAll = function(){
		for (var i in $scope.users){
			$scope.users[i].checkFlag = $scope.checkAllFlag;
			if ($scope.checkAllFlag){
				$scope.ids.push($scope.users[i].id);
			}else{
				$scope.ids = [];
			}
		}
	};
	
	$scope.checkOne = function(one){
		if (one.checkFlag){
			$scope.ids.push(one.id);
		}else{
			for (var i in $scope.ids){
				if (one.id == $scope.ids[i]){
					$scope.ids.splice(i, 1);
					break;
				}
			}
		}
		$scope.checkAllFlag = $scope.ids.length == $scope.users.length;
	};
	
	$scope.deleteCheck = function(){
		if (!$scope.checkAllFlag && $scope.ids.length == 0){
			alert("请选择要删除的目标");
			return;
		}
		var isOk = confirm("确认删除选择的目标？");
		if (isOk){
			$http({
				url : 'SectionDeleteServlet',
				method : 'post',
				params : {
					ids : $scope.ids
				}
			}).then(function(result){
				var data = result.data;
				alert(data);
				$scope.searchSection(true);
			});
			$scope.ids = [];
		}
	};
	
//	===============================
	
	$scope.deleteOne = function(id){
		var isOk = confirm("确认删除选择的目标？");
		if (isOk){
			$http({
				url : 'SectionDeleteServlet',
				method : 'post',
				params : {
					ids : id
				}
			}).then(function(result){
				var data = result.data;
				alert(data);
				$scope.searchSection(true);
			});
		}
	};
	
	$scope.showUpdateSectionModal = function(section){
		var parent = $scope;
		var uibModalInstance = $uibModal.open({
			size : 'md',		//模态框大小
			backdrop : 'static',	//点击不消失
			templateUrl : 'setting/sectionUpdateModal.html',	//模板地址
			controller : function($uibModalInstance,$scope){
				$scope.close = function(){
					$uibModalInstance.dismiss('close');
				}
				
				$scope.updateSection = {
					id : section.id,
					name : section.name
				};
				
				$scope.updateOne = function(){
					if ($scope.updateSection.name == null){
						alert("部门名称不能为空");
					}
					$http({
						url : 'SectionUpdateServlet',
						method : 'post',
						params : $scope.updateSection
					}).then(function(result){
						var data = result.data;
						alert(data);
						$scope.close();
						parent.searchSection(true);
					});
				}
			}
		});
	};
	
	$scope.showUserAddModal = function(){
		var parent = $scope;
		var uibModalInstance = $uibModal.open({
			size : 'md',		//模态框大小
			backdrop : 'static',	//点击不消失
			templateUrl : 'setting/userAddModal.html',	//模板地址
			controller : function($uibModalInstance,$scope){
				$scope.close = function(){
					$uibModalInstance.dismiss('close');
				}
				
				$scope.showSectionSearch = true;
				$scope.showRoleSearch = true;
				$scope.addUser = {
						username : "",
						name : "",
						sex : "",
						age : "",
						mobile : "",
						section : "",
						role : "",
						roleID : "",
						address : "",
						sectionID : ""
				};
				
				$scope.searchAllsection = function(){
					 $http({
						 url : 'SectionSearchServlet',
						 method : 'post',
						 params :{
							 name : $scope.addUser.section ,
							 currentPage : 1,
							 pageCount : 4
						 }
					 }).then(function(result){
						 $scope.sections = result.data.sections;
						 $scope.showSectionSearch = true;
					 });
				};
				
				$scope.chekedSection = function(section){
					$scope.addUser.section = section.name;
					$scope.addUser.sectionID = section.id;
					$scope.showSectionSearch = false;
				};
				
				$scope.searchAllRole = function(){
					 $http({
						 url : 'RoleSearchServlet',
						 method : 'post',
						 params :{
							 name : $scope.addUser.role,
							 currentPage : 1,
							 pageCount : 4
						 }
					 }).then(function(result){
						 $scope.roles = result.data.roles;
						 $scope.showRoleSearch = true;
					 });
				};
				
				$scope.chekedRole = function(role){
					$scope.addUser.role = role.name;
					$scope.addUser.roleID = role.id;
					$scope.showRoleSearch = false;
				};
				
				$scope.addOne = function(){
					console.log($scope.addUser);
					if ($scope.addUser.username == null || $scope.addUser.name == null || $scope.addUser.sex == null || $scope.addUser.age == null || $scope.addUser.mobile == null || $scope.addUser.section == null || $scope.addUser.role == null || $scope.addUser.address == null){
						alert("任一项不能为空");
					}
					$http({
						url : 'UserAddServlet',
						method : 'post',
						params : $scope.addUser
					}).then(function(result){
						var data = result.data;
						alert(data);
						$scope.close();
						parent.searchUser(true);
					});
				}
			}
		});
	};
});

app.controller("roleCtrl", function($scope, $uibModal, $state, $http, $stateParams){
	$scope.con = {
			name : ""
	};
	$scope.lastCon;
	$scope.currentPage = 1;
	$scope.pageCount = 4;
	$scope.totalPage = 0;
	$scope.rollPage = false;
	$scope.searchRole = function(rollPage){
		if(rollPage == undefined){
			$scope.currentPage = 1;
			$scope.lastCon = {
				name : $scope.con.name
			}
		}
		$http({
			url : 'RoleSearchServlet',
			method : 'post',
			params : {
				name : $scope.lastCon.name,
				currentPage : $scope.currentPage,
				pageCount : $scope.pageCount
			}
		}).then(function(result){
			$scope.roles = result.data.roles;
			$scope.totalPage = result.data.totalPage;
			$scope.rollPage = result.data.totalPage > 0;
		});
	};
	$scope.searchRole();
	$scope.goPage = function(page){
		if (page == 0 || page > $scope.totalPage)
			return;
		$scope.currentPage = page;
		$scope.searchRole(true);
	};
	
//	===============================全选
	
	$scope.ids = [];
	
	$scope.checkAllFlag = false;
	
	$scope.checkAll = function(){
		for (var i in $scope.roles){
			$scope.roles[i].checkFlag = $scope.checkAllFlag;
			if ($scope.checkAllFlag){
				$scope.ids.push($scope.roles[i].id);
			}else{
				$scope.ids = [];
			}
		}
	};
	
	$scope.checkOne = function(one){
		if (one.checkFlag){
			$scope.ids.push(one.id);
		}else{
			for (var i in $scope.ids){
				if (one.id == $scope.ids[i]){
					$scope.ids.splice(i, 1);
					break;
				}
			}
		}
		$scope.checkAllFlag = $scope.ids.length == $scope.roles.length;
	};
	
	$scope.deleteCheck = function(){
		if (!$scope.checkAllFlag && $scope.ids.length == 0){
			alert("请选择要删除的目标");
			return;
		}
		var isOk = confirm("确认删除选择的目标？");
		if (isOk){
			$http({
				url : '',
				method : 'post',
				params : {
					ids : $scope.ids
				}
			}).then(function(result){
				var data = result.data;
				alert(data);
				$scope.searchSection(true);
			});
			$scope.ids = [];
		}
	};
});

app.controller("organizationCtrl", function($scope, $uibModal, $state, $http, $stateParams){
	$scope.con = {
			name : ""
	};
	$scope.lastCon;
	$scope.currentPage = 1;
	$scope.pageCount = 4;
	$scope.totalPage = 0;
	$scope.rollPage = false;
	$scope.searchSection = function(rollPage){
		if(rollPage == undefined){
			$scope.currentPage = 1;
			$scope.lastCon = {
				name : $scope.con.name
			}
		}
		$http({
			url : 'SectionSearchServlet',
			method : 'post',
			params : {
				name : $scope.lastCon.name,
				currentPage : $scope.currentPage,
				pageCount : $scope.pageCount
			}
		}).then(function(result){
			$scope.sections = result.data.sections;
			$scope.totalPage = result.data.totalPage;
			$scope.rollPage = result.data.totalPage > 0;
		});
	};
	$scope.searchSection();
	$scope.goPage = function(page){
		if (page == 0 || page > $scope.totalPage)
			return;
		$scope.currentPage = page;
		$scope.searchSection(true);
	};
	
//	===============================全选
	
	$scope.ids = [];
	
	$scope.checkAllFlag = false;
	
	$scope.checkAll = function(){
		for (var i in $scope.sections){
			$scope.sections[i].checkFlag = $scope.checkAllFlag;
			if ($scope.checkAllFlag){
				$scope.ids.push($scope.sections[i].id);
			}else{
				$scope.ids = [];
			}
		}
	};
	
	$scope.checkOne = function(one){
		if (one.checkFlag){
			$scope.ids.push(one.id);
		}else{
			for (var i in $scope.ids){
				if (one.id == $scope.ids[i]){
					$scope.ids.splice(i, 1);
					break;
				}
			}
		}
		$scope.checkAllFlag = $scope.ids.length == $scope.sections.length;
	};
	
	$scope.deleteCheck = function(){
		if (!$scope.checkAllFlag && $scope.ids.length == 0){
			alert("请选择要删除的目标");
			return;
		}
		var isOk = confirm("确认删除选择的目标？");
		if (isOk){
			$http({
				url : 'SectionDeleteServlet',
				method : 'post',
				params : {
					ids : $scope.ids
				}
			}).then(function(result){
				var data = result.data;
				alert(data);
				$scope.searchSection(true);
			});
			$scope.ids = [];
		}
	};
	
//	===============================
	
	$scope.deleteOne = function(id){
		var isOk = confirm("确认删除选择的目标？");
		if (isOk){
			$http({
				url : 'SectionDeleteServlet',
				method : 'post',
				params : {
					ids : id
				}
			}).then(function(result){
				var data = result.data;
				alert(data);
				$scope.searchSection(true);
			});
		}
	};
	
	$scope.showUpdateSectionModal = function(section){
		var parent = $scope;
		var uibModalInstance = $uibModal.open({
			size : 'md',		//模态框大小
			backdrop : 'static',	//点击不消失
			templateUrl : 'setting/sectionUpdateModal.html',	//模板地址
			controller : function($uibModalInstance,$scope){
				$scope.close = function(){
					$uibModalInstance.dismiss('close');
				}
				
				$scope.updateSection = {
					id : section.id,
					name : section.name
				};
				
				$scope.updateOne = function(){
					if ($scope.updateSection.name == null){
						alert("部门名称不能为空");
					}
					$http({
						url : 'SectionUpdateServlet',
						method : 'post',
						params : $scope.updateSection
					}).then(function(result){
						var data = result.data;
						alert(data);
						$scope.close();
						parent.searchSection(true);
					});
				}
			}
		});
	};
	
	$scope.showSectionAddModal = function(){
		var parent = $scope;
		var uibModalInstance = $uibModal.open({
			size : 'md',		//模态框大小
			backdrop : 'static',	//点击不消失
			templateUrl : 'setting/sectionAddModal.html',	//模板地址
			controller : function($uibModalInstance,$scope){
				$scope.close = function(){
					$uibModalInstance.dismiss('close');
				}
				
				$scope.addSection = {
						name : ""
				};
				
				$scope.addOne = function(){
					if ($scope.addSection.name == null){
						alert("名称不能为空");
					}
					$http({
						url : 'SectionAddServlet',
						method : 'post',
						params : $scope.addSection
					}).then(function(result){
						var data = result.data;
						alert(data);
						$scope.close();
						parent.searchSection(true);
					});
				}
			}
		});
	};
});

app.controller("basicSettingCtrl", function($scope, $rootScope, color, $uibModal, $state, $http, $stateParams){
	$scope.jscolor = $rootScope.themeColor.substring(1).toUpperCase();
	$scope.setJscolor = function(){
		$rootScope.themeColor = "#" + $scope.jscolor.toUpperCase();
	};
	$scope.setColor = function(color){
		$rootScope.themeColor = color.toUpperCase();
		$scope.jscolor = $rootScope.themeColor.substring(1).toUpperCase();
		$http({
			url : 'SaveThemeServlet',
			method : 'post',
			params : {
				color : $rootScope.themeColor
			}
		}).then(function(result){
			var data = result.data;
			if (data != "设置成功"){
				alert("设置失败，请检查网络");
			}else{
				alert("设置成功");
			}
		});
	};
	$scope.saveTheme = function(){
		$scope.setColor($rootScope.themeColor);
	};
	
});

app.controller("noticeCtrl", function($scope, $uibModal, $state, $http, $stateParams){
	$scope.con = {
			content : ""
	};
	$scope.lastCon;
	$scope.currentPage = 1;
	$scope.pageCount = 5;
	$scope.totalPage = 0;
	$scope.rollPage = false;
	$scope.searchNotice = function(rollPage){
		if(rollPage == undefined){
			$scope.currentPage = 1;
			$scope.lastCon = {
				content : $scope.con.content
			}
		}
		$http({
			url : 'NoticeSearchServlet',
			method : 'post',
			params : {
				content : $scope.lastCon.content,
				currentPage : $scope.currentPage,
				pageCount : $scope.pageCount
			}
		}).then(function(result){
			$scope.notices = result.data.notices;
			$scope.totalPage = result.data.totalPage;
			$scope.rollPage = result.data.totalPage > 0;
		});
	};
	$scope.searchNotice();
	$scope.goPage = function(page){
		if (page == 0 || page > $scope.totalPage)
			return;
		$scope.currentPage = page;
		$scope.searchNotice(true);
	};
	
//	===============================全选
	
	$scope.ids = [];
	
	$scope.checkAllFlag = false;
	
	$scope.checkAll = function(){
		for (var i in $scope.notices){
			$scope.notices[i].checkFlag = $scope.checkAllFlag;
			if ($scope.checkAllFlag){
				$scope.ids.push($scope.notices[i].id);
			}else{
				$scope.ids = [];
			}
		}
	};
	
	$scope.checkOne = function(one){
		if (one.checkFlag){
			$scope.ids.push(one.id);
		}else{
			for (var i in $scope.ids){
				if (one.id == $scope.ids[i]){
					$scope.ids.splice(i, 1);
					break;
				}
			}
		}
		$scope.checkAllFlag = $scope.ids.length == $scope.notices.length;
	};
	
	$scope.deleteCheck = function(){
		if (!$scope.checkAllFlag && $scope.ids.length == 0){
			alert("请选择要删除的目标");
			return;
		}
		var isOk = confirm("确认删除选择的目标？");
		if (isOk){
			$http({
				url : 'NoticeDeleteServlet',
				method : 'post',
				params : {
					ids : $scope.ids
				}
			}).then(function(result){
				var data = result.data;
				alert(data);
				$scope.searchNotice(true);
			});
			$scope.ids = [];
		}
	};
	
//	===============================
	
	$scope.deleteOne = function(id){
		var isOk = confirm("确认删除选择的目标？");
		if (isOk){
			$http({
				url : 'NoticeDeleteServlet',
				method : 'post',
				params : {
					ids : id
				}
			}).then(function(result){
				var data = result.data;
				alert(data);
				$scope.searchNotice(true);
			});
		}
	};
	
	$scope.showUpdateNoticeModal = function(notice){
		var parent = $scope;
		var uibModalInstance = $uibModal.open({
			size : 'md',		//模态框大小
			backdrop : 'static',	//点击不消失
			templateUrl : 'setting/noticeUpdateModal.html',	//模板地址
			controller : function($uibModalInstance,$scope){
				$scope.close = function(){
					$uibModalInstance.dismiss('close');
				}
				
				$scope.updateNotice = {
					id : notice.id,
					content : notice.content
				};
				
				$scope.updateOne = function(){
					if ($scope.updateNotice.content == null){
						alert("修改内容不能为空");
					}
					$http({
						url : 'NoticeUpdateServlet',
						method : 'post',
						params : $scope.updateNotice
					}).then(function(result){
						var data = result.data;
						if (data == "发布成功"){
							alert("修改成功");
						}else{
							alert("修改失败");
						}
						$scope.close();
						parent.searchNotice(true);
					});
				}
			}
		});
	};
	
	$scope.showNoticeAddModal = function(){
		var parent = $scope;
		var uibModalInstance = $uibModal.open({
			size : 'md',		//模态框大小
			backdrop : 'static',	//点击不消失
			templateUrl : 'setting/noticeAddModal.html',	//模板地址
			controller : function($uibModalInstance,$scope){
				$scope.close = function(){
					$uibModalInstance.dismiss('close');
				}
				
				$scope.addNotice = {
						content : ""
				};
				
				$scope.addOne = function(){
					if ($scope.addNotice.content == null){
						alert("内容不能为空");
					}
					$http({
						url : 'NoticeAddServlet',
						method : 'post',
						params : $scope.addNotice
					}).then(function(result){
						var data = result.data;
						alert(data);
						$scope.close();
						parent.searchNotice(true);
					});
				}
			}
		});
	};
});

/* 李思臣 代码区域结束 **/



/* 黄恒愉 代码编写处(包含控制器注册 ) 记得先更新后提交 **/
app.controller("custResourcesCtrl", function($scope,$uibModal, $state, $http, $stateParams){

	$scope.custData =[];
	$scope.currentPage=1; //当前页数
	$scope.totalpage=1; //总页数
	$scope.displyCount=5; //显示条数
	var custName = '';
	//刷新数据
	$scope.refresh = function(rollPage){
		if(rollPage == undefined ){  // 判断是否是点击下一页还是点击查询
			custName = $scope.custName;
			$scope.currentPage=1; //如果查询条件发生改变，当前页回到第一页
		 }
		 $scope.selectAll=false;
		//------AJAX----------------------
		$http({
			url : 'Customer',
			method : 'post',
			 params :{
				 custName : custName,
				 currentPage : $scope.currentPage,	
				 totalpage : $scope.totalpage,
				 displyCount : $scope.displyCount
			 }
		}).then(function(result){
			$scope.custData = result.data.custData;
			$scope.totalpage = result.data.total;
		});
		//------AJAX结束----------------------
	}



	$scope.refresh();
	  //点击搜索
		 $scope.searchCust = function(){

			 $scope.refresh();
		 }
	 //翻页函数
		 $scope.gotoPage = function(index){
			if(index < 1 || index > $scope.totalpage) return;
			$scope.currentPage = index;
			$scope.refresh(true);//传一个值，告诉刷新函数，这是一个点击翻页事件
		 }	
     //选择函数
		 $scope.selectCusts=[];
		 $scope.selectAll=false;
		 $scope.select = function(c){
			 if(c == undefined){
				 for(var i in $scope.custData){ //循环遍历每个数组元素，并为它们的sel属性赋值
					 $scope.custData[i].sel = $scope.selectAll;
					 if($scope.selectAll == true){
						 $scope.selectCusts.push($scope.custData[i]); //然后把全选的数据赋给操作的数组。
					 }else{
						 $scope.selectCusts=[];//.splice(i,1);//找了之后，
					 }
				 }
				 
			 }else{
				 if(c.sel){
					 $scope.selectCusts.push(c); //如果是单个的被选中，就追加到数组的末尾
				 }else{
					 for(var i in $scope.selectCusts){ //循环遍历每个数组元素，找到取消的对象，把它删了
						if($scope.selectCusts[i].id == c.id){
							$scope.selectCusts.splice(i,1);//找了之后，
						}
					 }
				 }
				 console.log($scope.selectCusts.length);
				 console.log($scope.custData.length);
				 if($scope.selectCusts.length == $scope.custData.length){
					 $scope.selectAll = true;
				 }else{
					 $scope.selectAll = false;
					// $scope.selectCusts = [];
				 }
			 
			 }
		 }
		 
		 
		 /** 分配客户资源模态框 */
		 $scope.assignModel = function(cust){
			 var parent = $scope;	//把上一个scope传给变量parent
			 var uibModalInstance = $uibModal.open({
				 size : 'md',//模态框大小
				 backdrop : 'static',//点击不消失
				 templateUrl : 'customer/modal/assignModel.html',//模板地址
				 controller : function($uibModalInstance,$scope){
					 $scope.custs = [];
					 $scope.custsID = []; 
					 //这里判断一下，是一个对象还是一个数组
					 if(cust != undefined){
						 $scope.custs = [cust];
						 $scope.custsID = [cust.id];
					 }else{
						 for(var i in parent.selectCusts){ //循环遍历每个数组元素，找到取消的对象，把它删了
							$scope.custs.push(parent.selectCusts[i]);
							$scope.custsID.push(parent.selectCusts[i].id);
							 }
						 console.log($scope.custs);
					 }
					 $scope.title = '分配客户资源';
					 //键盘弹起函数
					 $scope.keyboard = function(){
							 //------AJAX----------------------
							 $http({
								 url : 'CustGetUser',
								 method : 'post',
								 params :{
									 username : $scope.username, 
								 }
							 }).then(function(result){
								  //回调函数
								 $scope.users = result.data.users;
								
							 });
							 //------AJAX结束----------------------
					 }
					 $scope.chekedUser = function(user){
						 $scope.username = user.name;
						 //alert(user.id);
					 }
				     //取消关闭函数
					 $scope.close = function(){
						 $scope.custs = [];
						 $scope.custsID = []; 
						 parent.selectAll=false;
						 parent.select();
						 $uibModalInstance.dismiss('cancel');
						 //parent.refresh();
					 }
					 //确认函数
					 $scope.confirm = function(){
						 var isOk = false;
						 if( $scope.username == undefined || $scope.username == ''){
							 //alert('客户姓名不能为空');
							 $scope.meg1 = '您还没指定分配给哪位代表呢！！';
							 isOk = true;
						 }
						 console.log($scope.users);
						 if($scope.users == $scope.users.length){
							 isOk = true;
							 $scope.meg1 = '这个代表好像不是我们公司的！！';
						 }
						 if(isOk){
							 return;
						 }else{
							 $scope.meg1 = '';
						 }
						 //------AJAX----------------------
						 $http({
							 url : 'CustomerAssign',
							 method : 'post',
							 params :{
								 username : $scope.username, 
								 'custIDs' : $scope.custsID
							 }
						 }).then(function(result){
							 $scope.custs = [];
							 $scope.custsID = []; 
							 $scope.close();
						 });
						 //------AJAX结束----------------------
					 }
				 }
			 });
		 }//分配客户资源的模态框在此结束
		 
		/** 增加和修改用户模态框 */
		$scope.updateModel = function(cust){
		var parent = $scope;		
		//alert(cust.name);
		var uibModalInstance = $uibModal.open({
		size : 'md',//模态框大小
		backdrop : 'static',//点击不消失
		templateUrl : 'customer/modal/updateModel.html',//模板地址
		controller : function($uibModalInstance,$scope){
		$scope.cust = cust;
		if(cust == undefined){ 
			$scope.title = '添加客户信息';
			$scope.cust={ name : '',mobile : '', birthday : ''}
		  }else{
			$scope.title = '修改客户信息';
		  }
		
		$scope.close = function(){
		$uibModalInstance.dismiss('cancel');
		    parent.refresh();
				}
		$scope.confirm = function(){
		     var isOk = false;
			if( $scope.cust.name == undefined || $scope.cust.name == ''){
				//alert('客户姓名不能为空');
				$scope.meg1 = '客户姓名不能为空';
				isOk = true;
			}
			if( $scope.cust.mobile == undefined || $scope.cust.mobile == '' ){
				//alert('客户电话不能为空');
				$scope.meg2 = '客户电话不能为空';
				isOk = true;
			}
			if( $scope.cust.birthday == undefined  || $scope.cust.birthday == ''){
				//alert('客户电话不能为空');
				$scope.meg3 = '出生日期不能为空';
				isOk = true;
			}
			if(isOk){
				return;
			}else{
				$scope.meg1 = '';
				$scope.meg2 = '';
			}
			console.log($scope.cust);
			//------AJAX----------------------
			$http({
				url : 'CustomerUpdate',
				method : 'post',
				params :$scope.cust,
			}).then(function(result){
				 parent.refresh();
				 alert(result.data);
				 $scope.close();
			});
			//------AJAX结束----------------------
			 }
			}
		  });
		}//增加和修改的模态框在此结束
		

	});//客户资源控制器结束标记

//客户价值分析
app.controller("custValueCtrl", function($scope,$uibModal, $state, $http, $stateParams){
	
	$scope.custData =[];
	$scope.currentPage=1; //当前页数
	$scope.totalpage=1; //总页数
	$scope.displyCount=10; //显示条数
	var custName = '';
	//刷新数据
	$scope.refresh = function(rollPage){
		if(rollPage == undefined ){  // 判断是否是点击下一页还是点击查询
			custName = $scope.custName;
			$scope.currentPage=1; //如果查询条件发生改变，当前页回到第一页
		}
		$scope.selectAll=false;
		//------AJAX----------------------
		$http({
			url : 'Customer',
			method : 'post',
			params :{
				custName : custName,
				currentPage : $scope.currentPage,	
				totalpage : $scope.totalpage,
				displyCount : $scope.displyCount
			}
		}).then(function(result){
			$scope.custData = result.data.custData;
			$scope.totalpage = result.data.total;
			$scope.dataImg($scope.custData);
			console.log($scope.custData);
		});
		//------AJAX结束----------------------
	}
	
	
	
	$scope.refresh();
	//点击搜索
	$scope.searchCust = function(){
		
		$scope.refresh();
	}
	//翻页函数
	$scope.gotoPage = function(index){
		if(index < 1 || index > $scope.totalpage) return;
		$scope.currentPage = index;
		$scope.refresh(true);//传一个值，告诉刷新函数，这是一个点击翻页事件
	}	
	//选择函数
	$scope.selectCusts=[];
	$scope.selectAll=false;
	$scope.select = function(c){
		if(c == undefined){
			console.log( $scope.selectAll);
			for(var i in $scope.custData){ //循环遍历每个数组元素，并为它们的sel属性赋值
				$scope.custData[i].sel = $scope.selectAll;
				if($scope.selectAll == true){
					$scope.selectCusts.push($scope.custData[i]); //然后把全选的数据赋给操作的数组。
				}else{
					$scope.selectCusts=[];//.splice(i,1);//找了之后，
				}
			}
			
		}else{
			console.log(c.sel);
			if(c.sel){
				$scope.selectCusts.push(c); //如果是单个的被选中，就追加到数组的末尾
			}else{
				for(var i in $scope.selectCusts){ //循环遍历每个数组元素，找到取消的对象，把它删了
					if($scope.selectCusts[i].id == c.id){
						$scope.selectCusts.splice(i,1);//找了之后，
					}
				}
			}
			console.log($scope.selectCusts.length);
			console.log($scope.custData.length);
			if($scope.selectCusts.length == $scope.custData.length){
				$scope.selectAll = true;
			}else{
				$scope.selectAll = false;
				// $scope.selectCusts = [];
			}
			
		}
	}
	
	/** 这一段图表显示，使用原生JS代码 */
 $scope.dataImg=function(arr){
	    var myChart = echarts.init(document.getElementById('valueImg'));
		var dataName = [];
		var data = [];
		var dataShow = [
            ['product', '信誉度', '满意度', '价值']
            ];
		for(var i in arr ){
			var credit = arr[i].credit;
			var satisfy = arr[i].satisfy;
			var value = (credit+satisfy)/2;
			dataShow.push([arr[i].name,credit,satisfy,value]);
		     }
		option = {
				//color:['yellow','pink','black'],
			    legend: {},
			    tooltip: {},
			    dataset: {
			        source:dataShow
			    },
			    xAxis: {type: 'category'},
			    yAxis: {},
			    series: [
			        {type: 'bar'},
			        {type: 'bar'},
			        {type: 'bar'}
			    	]
			};
		
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
		/** 图表显示相关代码在此结束 */
     }
 $scope.exportResult=function(){
	 
		//------AJAX----------------------
		$http({
			url : 'CustomerDataTransfer',
			method : 'get',
//			 params :{}
		}).then(function(result){
			alert("导出成功");
		});
		//------AJAX结束----------------------
 }

	
});//客户资源控制器结束标记

/** 客户发展计划 */
app.controller("custPlanCtrl", function($scope,$uibModal, $state, $http, $stateParams){
	$scope.plans =[];
	$scope.currentPage=1; //当前页数
	$scope.totalpage=1; //总页数
	$scope.displyCount=2; //显示条数
	var custName = '';

	//刷新数据
	$scope.refresh = function(rollPage){
		
		if(rollPage == undefined ){  // 判断是否是点击下一页还是点击查询
			custName = $scope.custName;
			$scope.currentPage=1; //如果查询条件发生改变，当前页回到第一页
		 }
		 $scope.selectAll=false;
		//------AJAX----------------------
		$http({
			url : 'CustomerPlan',
			method : 'post',
			 params :{
				 username : $scope.username,
				 currentPage : $scope.currentPage,	
				 totalpage : $scope.totalpage,
				 displyCount : $scope.displyCount
			 }
		}).then(function(result){
			console.log(result.data);
			$scope.plans=result.data.plans;
			$scope.totalpage = result.data.total;
		});
		//------AJAX结束----------------------
	}

	$scope.refresh();
	  //点击搜索
		 $scope.searchUser = function(){
			 $scope.refresh();
		 }
	 //翻页函数
		 $scope.gotoPage = function(index){
			if(index < 1 || index > $scope.totalpage) return;
			$scope.currentPage = index;
			$scope.refresh(true);//传一个值，告诉刷新函数，这是一个点击翻页事件
		 }	
     //选择函数
		 $scope.selectObjs=[];
		 $scope.selectAll=false;
		 $scope.select = function(c){
			 if(c == undefined){
				 console.log( $scope.selectAll);
				 for(var i in $scope.plans){ //循环遍历每个数组元素，并为它们的sel属性赋值
					 $scope.plans[i].sel = $scope.selectAll;
					 if($scope.selectAll == true){
						 $scope.selectObjs.push($scope.plans[i]); //然后把全选的数据赋给操作的数组。
					 }else{
						 $scope.selectObjs=[];//.splice(i,1);//找了之后
						 //为了提高效率，这里可以加break跳出循环
					 }
				 }
				 
			 }else{
				 console.log(c.sel);
				 if(c.sel){
					 $scope.selectObjs.push(c); //如果是单个的被选中，就追加到数组的末尾
				 }else{
					 for(var i in $scope.selectObjs){ //循环遍历每个数组元素，找到取消的对象，把它删了
						if($scope.selectObjs[i].id == c.id){
							$scope.selectObjs.splice(i,1);//找了之后，
						}
					  }
				 }
				 console.log(len);
				 console.log($scope.plans.length);
				if($scope.selectObjs.length == $scope.plans.length){
				 // if(len == $scope.plans.length){
					 $scope.selectAll = true;
				 }else{
					 $scope.selectAll = false;
					// $scope.selectCusts = [];
				 }
			 
			 }
		 }//选择函数结束
		 
		 
		 /** 删除客户发展计划模态框 */
		 $scope.deletePlanModel = function(obj){
					 $scope.objsID = []; 
					 //这里判断一下，是一个对象还是一个数组
					 if(obj != undefined){
						 $scope.objsID = [obj.id];
					 }else{
						 for(var i in $scope.selectObjs){ //循环遍历每个数组元素，找到取消的对象，把它删了
							$scope.objsID.push($scope.selectObjs[i].id);
							 }
					 }
					 console.log($scope.objsID);
					 //确认函数
					 if( confirm('删除后不可恢复，你确定要删除吗?')){
						// alert();
						 //------AJAX----------------------
						 $http({
							 url : 'CustomerPlanDelete',
							 method : 'post',
							 params :{
								 'objsID' : $scope.objsID
							 }
						 }).then(function(result){
							 alert(result.data);
							 $scope.refresh();
						 });
						 //------AJAX结束----------------------
					 }
					 $scope.objsID = []; 
		 }//删除客户发展计划在此结束
		 
		 /** 增加发展计划模态框 */
			$scope.addModel = function(obj){
			var parent = $scope;		
			//alert(cust.name);
			var uibModalInstance = $uibModal.open({
			size : 'md',//模态框大小
			backdrop : 'static',//点击不消失
			templateUrl : 'customer/modal/addPlanModel.html',//模板地址
			controller : function($uibModalInstance,$scope){
			$scope.obj = obj;
			
			 //键盘弹起函数
			 $scope.keyboard = function(){
					 //------AJAX----------------------
					 $http({
						 url : 'CustGetUser',
						 method : 'post',
						 params :{
							 username : $scope.obj.name, 
						 }
					 }).then(function(result){
						  //回调函数
						 $scope.users = result.data.users;
					 });
					 //------AJAX结束----------------------
			 }
			 //点击查询列表，获取相对应的值
			 $scope.chekedUser = function(u){
				 $scope.obj.name=u.name;
				 $scope.obj.id = u.id;
			 }
			 

			 $scope.close = function(){
			$uibModalInstance.dismiss('cancel');
			   // parent.refresh();
					}
			$scope.confirm = function(){
			     var isOk = false;
				if( $scope.obj.name == undefined || $scope.obj.name == ''){
					$scope.meg1 = '用户姓名不能为空';
					isOk = true;
				}
				if( $scope.obj.planNum == undefined || $scope.obj.planNum == '' ){
					$scope.meg2 = '计划数量不能为空';
					isOk = true;
				}
				if( $scope.obj.planTime == undefined  || $scope.obj.planTime == ''){
					$scope.meg3 = '计划完成日期不能为空';
					isOk = true;
				}
				if(isOk){
					return;
				}else{
					$scope.meg1 = '';
					$scope.meg2 = '';
					$scope.meg3 = '';
				}
				console.log($scope.obj);
				//------AJAX----------------------
				$http({
					url : 'CustomerPlanAdd',
					method : 'post',
					params :
						$scope.obj,
				}).then(function(result){
					 parent.refresh();
					 alert(result.data);
					 $scope.close();
				});
				//------AJAX结束----------------------
				 }
				}
			  });
			}//增加的模态框在此结束
});//客户发展控制器结束标记


/** 客户关怀 */
app.controller("custCareCtrl", function($scope,$uibModal, $state, $http, $stateParams){
	$scope.plans =[];
	$scope.currentPage=1; //当前页数
	$scope.totalpage=1; //总页数
	$scope.displyCount=2; //显示条数
	var custName = '';

	//刷新数据
	$scope.refresh = function(rollPage){
		if(rollPage == undefined ){  // 判断是否是点击下一页还是点击查询
			custName = $scope.custName;
			$scope.currentPage=1; //如果查询条件发生改变，当前页回到第一页
		 }
		 $scope.selectAll=false;
		//------AJAX----------------------
		$http({
			url : 'CustCare',
			method : 'post',
			 params :{
				 username : $scope.username,
				 currentPage : $scope.currentPage,	
				 totalpage : $scope.totalpage,
				 displyCount : $scope.displyCount
			 }
		}).then(function(result){
			console.log(result.data);
			$scope.plans=result.data.cares;
			$scope.totalpage = result.data.total;
		});
		//------AJAX结束----------------------
	}

	$scope.refresh();
	  //点击搜索
		 $scope.searchUser = function(){
			 $scope.refresh();
		 }
	 //翻页函数
		 $scope.gotoPage = function(index){
			if(index < 1 || index > $scope.totalpage) return;
			$scope.currentPage = index;
			$scope.refresh(true);//传一个值，告诉刷新函数，这是一个点击翻页事件
		 }	
     //选择函数
		 $scope.selectObjs=[];
		 $scope.selectAll=false;
		 $scope.select = function(c){
			 if(c == undefined){
				 console.log( $scope.selectAll);
				 for(var i in $scope.plans){ //循环遍历每个数组元素，并为它们的sel属性赋值
					 $scope.plans[i].sel = $scope.selectAll;
					 if($scope.selectAll == true){
						 $scope.selectObjs.push($scope.plans[i]); //然后把全选的数据赋给操作的数组。
					 }else{
						 $scope.selectObjs=[];//.splice(i,1);//找了之后
						 //为了提高效率，这里可以加break跳出循环
					 }
				 }
				 
			 }else{
				 console.log(c.sel);
				 if(c.sel){
					 $scope.selectObjs.push(c); //如果是单个的被选中，就追加到数组的末尾
				 }else{
					 for(var i in $scope.selectObjs){ //循环遍历每个数组元素，找到取消的对象，把它删了
						if($scope.selectObjs[i].id == c.id){
							$scope.selectObjs.splice(i,1);//找了之后，
						}
					  }
				 }
				 console.log(len);
				 console.log($scope.plans.length);
				if($scope.selectObjs.length == $scope.plans.length){
				 // if(len == $scope.plans.length){
					 $scope.selectAll = true;
				 }else{
					 $scope.selectAll = false;
					// $scope.selectCusts = [];
				 }
			 
			 }
		 }//选择函数结束
		 
		 
		 /** 删除模态框 */
		 $scope.deletePlanModel = function(obj){
					 $scope.objsID = []; 
					 //这里判断一下，是一个对象还是一个数组
					 if(obj != undefined){
						 $scope.objsID = [obj.id];
					 }else{
						 for(var i in $scope.selectObjs){ //循环遍历每个数组元素，找到取消的对象，把它删了
							$scope.objsID.push($scope.selectObjs[i].id);
							 }
					 }
					 console.log($scope.objsID);
					 //确认函数
					 if( confirm('删除后不可恢复，你确定要删除吗?')){
						// alert();
						 //------AJAX----------------------
						 $http({
							 url : 'CustomerPlanDelete',
							 method : 'post',
							 params :{
								 'objsID' : $scope.objsID
							 }
						 }).then(function(result){
							 alert(result.data);
							 $scope.refresh();
						 });
						 //------AJAX结束----------------------
					 }
					 $scope.objsID = []; 
		 }//删除客户发展计划在此结束
		 
		 /** 增加关怀模态框 */
			$scope.addCareModel = function(obj){
			var parent = $scope;		
			//alert(cust.name);
			var uibModalInstance = $uibModal.open({
			size : 'md',//模态框大小
			backdrop : 'static',//点击不消失
			templateUrl : 'customer/modal/addCareModel.html',//模板地址
			controller : function($uibModalInstance,$scope){
			$scope.obj = obj;
			 //检测用户输入框函数
			 $scope.checkUser = function(){
					 //------AJAX----------------------
					 $http({
						 url : 'CustGetUser',
						 method : 'post',
						 params :{
							 username : $scope.obj.uname, 
						 }
					 }).then(function(result){
						  //回调函数
					 $scope.users = result.data.users;
					 console.log( $scope.users );
					 });
					 //------AJAX结束----------------------
			 }
			 //点击查询列表，获取相对应的值
			 $scope.choiceObj = function(u){
				 $scope.obj.uname=u.name;
				 $scope.obj.id = u.id;
			 }
			 

			 $scope.close = function(){
			$uibModalInstance.dismiss('cancel');
					}
			$scope.confirm = function(){
			  
				console.log($scope.obj);
				//------AJAX----------------------
				$http({
					url : 'CustomerCareAdd',
					method : 'post',
					params : $scope.obj
				}).then(function(result){
					 parent.refresh();
					 alert(result.data);
					 $scope.close();
				});
				//------AJAX结束----------------------
				 }
				}
			  });
			}//增加的模态框在此结束
});//客户关怀控制器结束标记
/** 客户关怀代码结束 */
/* 黄恒愉 代码区域结束 **/