function LiderListCtrl($scope, $http) {
	
	$http.get('api/lider').success(function(data) {
		$scope.lideres = data.liderDTOList;
	});
}

function LiderDetailCtrl($scope, $routeParams, $http, $timeout) {
	
	$scope.tempoUpdateView = 10;
	
	$scope.carregaProblemas = function(){
		$http.get('api/lider/' + $routeParams.codigoLider).success(function(data) {
			$scope.lider = data.liderDTO;
		});
		$timeout( $scope.carregaProblemas, 1000 * 60 * 60 );
	};
	
	$timeout( $scope.carregaProblemas, 100 );
}

function ViewPortCtrl($scope, $timeout) {

	$scope.windowHeight = $('.ticket-displayview').height() ;
	
	$scope.selectedView = 0;

	$scope.changeView = function() {

		$scope.conteinerHeight = $('.ticket-conteiner').height();

		$scope.views = (  $scope.conteinerHeight / $scope.windowHeight );
		
		$scope.topView = $scope.windowHeight * $scope.selectedView * -1;

		$('.ticket-conteiner').css('top', $scope.topView);
		
		$scope.selectedView += 1;

		if ($scope.selectedView > $scope.views){
			$scope.selectedView = 0;
		}
		
		$timeout( $scope.changeView, $scope.tempoUpdateView * 1000 );
		
	};
	
	$timeout( $scope.changeView, 500 );
}

