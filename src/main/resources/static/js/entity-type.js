
app.controller('entityTypeListController', ['$scope', '$http', '$q', 'constants', function($scope, $http, $q, constants) {

  $http.get("/api/entity-type").then(function(response) {
    $scope.items = response.data.content;
  });
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
