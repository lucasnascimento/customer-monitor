function LiderListCtrl($scope, $http) {

	$http.get('api/lider').success(function(data) {
		$scope.lideres = data.liderDTOList;
	});

	$scope.orderProp = 'codigoLider';
}
