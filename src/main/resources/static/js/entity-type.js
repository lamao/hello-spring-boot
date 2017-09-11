
app.controller('entityTypeListController', ['$scope', '$http', '$q', 'constants', function($scope, $http, $q, constants) {

  $http.get("/api/entity-type").then(function(response) {
    $scope.items = response.data.content;
  });

  $scope.onRemove = function(itemId) {
    $http.delete("/api/entity-type/" + itemId).then(function(response){
      _.remove($scope.items, function(it) {
        return it.id == itemId;
      });
    });
  };
}]);

app.controller('entityTypeEditController', ['$scope', '$http', '$location', function($scope, $http, $location) {

  $scope.item = {
    propertyDefinitions: []
  };

  $scope.onSave = function() {
    $http.post("/api/entity-type", $scope.item)
      .then(function(response){
        $location.path("/entity-types");
      });
  };

  $scope.onAddPropertyDefinition = function() {
    $scope.item.propertyDefinitions.push({});
  };

}]);

app.controller("entityTypeCardController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {
  $http.get("/api/entity-type/" + $routeParams.id).then(function(response) {
    $scope.item = response.data;
  });
}]);
