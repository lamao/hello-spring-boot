var app = angular.module('app', ['ngRoute','ngResource', 'constants', 'ui.bootstrap']);
app.config(function($locationProvider, $routeProvider) {

  $locationProvider.hashPrefix('');

  $routeProvider
    .when('/entities', {
      templateUrl: '/views/entity-list.html',
      controller: 'entityListController'
    })
    .when("/entity/:id", {
      templateUrl: "/views/entity-card.html",
      controller: "entityCardController"
    })
    .when('/entities/add', {
      templateUrl: '/views/entity-edit.html',
      controller: 'entityEditController'
    })
    .when('/entity-types', {
      templateUrl: '/views/entity-type-list.html',
      controller: 'entityTypeListController'
    })
    .when('/entity-types/add', {
      templateUrl: '/views/entity-type-edit.html',
      controller: 'entityTypeEditController'
    })
    .when('/property-definitions', {
      templateUrl: '/views/property-definition-list.html',
      controller: 'propertyDefinitionListController'
    })
    .when('/property-definitions/add', {
      templateUrl: '/views/property-definition-edit.html',
      controller: 'propertyDefinitionEditController'
    })
    .otherwise(
      { redirectTo: '/'}
    );
});