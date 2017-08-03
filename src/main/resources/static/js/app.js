var app = angular.module('app', ['ngRoute','ngResource', 'constants', 'ui.bootstrap']);
app.config(function($locationProvider, $routeProvider) {

  $locationProvider.hashPrefix('');

  $routeProvider
    .when('/entities', {
      templateUrl: '/views/entity-list.html',
      controller: 'entityListController'
    })
    .when('/entity-types', {
      templateUrl: '/views/entity-type-list.html',
      controller: 'entityTypeListController'
    })
    .when('/entity-types/add', {
      templateUrl: '/views/entity-type-edit.html',
      controller: 'entityTypeEditController'
    })
    .otherwise(
      { redirectTo: '/'}
    );
});