app.controller('entityListController', ['$scope', '$http', '$q', 'constants', function($scope, $http, $q, constants) {
  $http.get("/api/entity").then(function(response){
    $scope.items = response.data.content;
  });

  $scope.onRemove = function(itemId) {
    $http.delete("/api/entity/" + itemId).then(function(response) {
      _.remove($scope.items, function(it) {
        return it.id == itemId;
      });
    });
  };

}]);

app.controller('entityEditController', ['$scope', '$http', '$location', function($scope, $http, $location) {

  $scope.item = {};

  $http.get("/api/entity-type")
    .then(function(response) {
      $scope.entityTypes = response.data.content;
    });


  $scope.onSave = function() {
    $http.post("/api/entity", $scope.item)
      .then(function(response){
        $location.path("/entities");
      });
  };

  $scope.onChangeType = function() {
    var entityTypeId = $scope.item.type.id;
    $http.get("/api/entity-type/" + entityTypeId + "/property-definitions")
      .then(function(response) {
        var propertyDefinitions = response.data;
        $scope.item.properties = _.map(propertyDefinitions, function(it) {
          return {
            definition: it
          }
        });
      });
  };

}]);

app.controller("entityCardController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {
  $http.get("/api/entity/" + $routeParams.id).then(function(response) {
      $scope.item = response.data;
  });
}]);
