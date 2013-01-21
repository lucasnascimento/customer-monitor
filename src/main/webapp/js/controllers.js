function LiderListCtrl($scope, $http) {

	$http.get('api/lider').success(function(data) {
		$scope.lideres = data.liderDTOList;
	});

	$scope.orderProp = 'codigoLider';
}

function LiderDetailCtrl($scope, $routeParams, $http) {

	$http.get('api/lider/' + $routeParams.codigoLider).success(function(data) {
		$scope.lider = data.liderDTO;
		
		problemas = data.liderDTO.problemas;
		
		quantidadeProblemas = problemas.length;
		quantidadeLinhas = quantidadeProblemas / 4;
		
		var linhas = [];
		
		for(var i=0; i < quantidadeLinhas; i++){
			var linha = [];
			for (var j=1 ; j<=4 ; j++){
				linha.push( problemas[i+j] );
			}
			linhas.push ( linha );
		}
		
		quebra = quantidadeProblemas - (quantidadeLinhas * 4);
		
		var linha = [];
		for (var i = quantidadeProblemas - quebra ; i <= quantidadeProblemas ; i++){
			console.log(i);
			linha.push( problemas [i-1] );
		}
		linhas.push (linha);
		
		$scope.linhas = linhas;

		
		
	});
	
}