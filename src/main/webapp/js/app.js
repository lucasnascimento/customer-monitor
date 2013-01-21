angular.module('monitor', []).
  config(['$routeProvider', function($routeProvider) {
  $routeProvider.
      when('/lideres', {templateUrl: 'partials/lider-list.html',   controller: LiderListCtrl}).
      when('/lideres/:codigoLider', {templateUrl: 'partials/lider-detail.html', controller: LiderDetailCtrl}).
      otherwise({redirectTo: '/lideres'});
}]);