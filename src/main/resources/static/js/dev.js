app.controller('devPageController', ['$scope', '$http', '$q', '$uibModal', function($scope, $http, $q, $uibModal) {

  loadData().then(initialize());

  function loadData() {
    return $http.get("dev/db-manager/status").then(function(response) {
      $scope.isDbManagerLaunched = response.data.launched;
    });
  }

  function initialize() {
    $scope.onRunDbManager = function () {
      $http.post("/dev/db-manager/run").then(function () {
        $scope.isDbManagerLaunched = true;
        showInfoModal("Done", "Database manager launched");
      });

      function showInfoModal(title, message) {
        var modal = $uibModal.open({
          ariaLabelledBy: 'modal-title',
          ariaDescribedBy: 'modal-body',
          templateUrl: 'modal-info.tmpl',
          controller: 'modalInfoInstanceCtrl',
          resolve: {
            static: function () {
              return {
                title: title,
                message: message
              }
            }
          }
        });

        // modal.result.then(function (selectedItem) {
        //   console.info('Modal OK at: ' + new Date());
        // }, function () {
        //   console.info('Modal Close at: ' + new Date());
        // });
      }

    };
  }

}]);

app.controller('modalInfoInstanceCtrl', function ($scope, $uibModalInstance) {
  $scope.content = $scope.$resolve.static;
  $scope.onOk = $uibModalInstance.close;
});