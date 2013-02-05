angular.module('monitor', []).
  config(['$routeProvider', function($routeProvider) {
  $routeProvider.
      when('/lideres', {templateUrl: 'partials/lider-list.html',   controller: LiderListCtrl}).
      when('/lideres/:codigoLider', {templateUrl: 'partials/lider-detail.html', controller: LiderDetailCtrl}).
      when('/lideres/:codigoLider/:pagina', {templateUrl: 'partials/lider-detail.html', controller: LiderDetailCtrl}).
      when('/setor', {templateUrl: 'partials/setor.html',   controller: SetorCtrl}).
      otherwise({redirectTo: '/lideres'});
}]);