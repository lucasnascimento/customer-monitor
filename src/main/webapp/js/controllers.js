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

function ViewPortCtrl($scope, $timeout) {
	
	$scope.windowHeight = $(window).height() - 115 ;
	$('.ticket-displayview').css('height', $scope.windowHeight);
	console.log('$scope.windowHeight: '+$scope.windowHeight);
	$scope.selectedView = 0;

	$scope.changeView = function() {

		$scope.conteinerHeight = $('.ticket-conteiner').height();
		console.log('$scope.lineHeight: '+$scope.conteinerHeight);

		$scope.views = (  $scope.conteinerHeight / $scope.windowHeight );
		console.log('$scope.views: '+ $scope.views);
		
		
		$scope.topView = $scope.windowHeight * $scope.selectedView * -1;
		console.log('$scope.topView: '+ $scope.topView);
		$('.ticket-conteiner').css('top', $scope.topView);
		
		$scope.selectedView += 1;

		if ($scope.selectedView > $scope.views){
			$scope.selectedView = 0;
		}

		console.log($scope.views);
		console.log($scope.selectedView);
		
		$timeout( $scope.changeView, 2000 );
		
	};
	
	$timeout( $scope.changeView, 2000 );
}

