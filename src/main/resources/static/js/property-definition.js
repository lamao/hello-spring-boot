
app.controller('propertyDefinitionListController', ['$scope', '$http', '$q', 'constants', function($scope, $http, $q, constants) {

  $http.get("/api/property-definition").then(function(response) {
    $scope.items = response.data.content;
  });
}]);

app.controller('propertyDefinitionEditController', ['$scope', '$http', '$location', function($scope, $http, $location) {

  $scope.item = {};

  $scope.onSave = function() {
    $http.post("/api/property-definition", $scope.item)
      .then(function(response){
        $location.path("/property-definitions");
      });
  };

}]);
