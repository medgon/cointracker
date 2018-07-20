angular.module('app').service('coinService', function($http) {
	
	var coinService = {
			
			coinList: [];
			
			
			getAllCoins: function(callback){
				return $http.get('https://bittrex.com/api/v1.1/public/getmarkets')
						.then( function success(response){ 
							coinService.coinList = response.data;
							callback(response.data);
						}, function error(){
							console.log("Error!");
						});
			},
	}
	
	return coinService;
	
})
