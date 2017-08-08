app.controller('entityListController', ['$scope', '$http', '$q', 'constants', function($scope, $http, $q, constants) {
  $http.get("/api/entity").then(function(response){
    $scope.items = response.data.content;
  })
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

}]);
