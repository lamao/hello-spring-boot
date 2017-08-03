
app.controller('entityTypeListController', ['$scope', '$http', '$q', 'constants', function($scope, $http, $q, constants) {

  $http.get("/api/entity-type").then(function(response) {
    $scope.items = response.data.content;
  });
}]);