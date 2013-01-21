function LiderListCtrl($scope, $http) {

	$http.get('api/lider').success(function(data) {
		$scope.lideres = data.liderDTOList;
	});

	$scope.orderProp = 'codigoLider';
}

function LiderDetailCtrl($scope, $routeParams, $http) {

	$http.get('api/lider/' + $routeParams.codigoLider).success(function(data) {
		$scope.lider = data.liderDTO;
	});
	
}