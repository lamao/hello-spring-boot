app.controller('entityListController', ['$scope', '$http', '$q', 'constants', function($scope, $http, $q, constants) {
  $http.get("/api/entity").then(function(response){
    $scope.items = response.data.content;
  })
}]);