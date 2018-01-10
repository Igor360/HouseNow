app.controller('articlesController', function($scope, $http, API_URL){

    $http.get(API_URL+'home')
         .then(function successCallback(response){
            $scope.articles = response['data'];
         });
});       