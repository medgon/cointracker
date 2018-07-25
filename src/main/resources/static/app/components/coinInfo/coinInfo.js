(function(angular) {
	'use strict';
	angular.module('app').component('coinInfo', {
		templateUrl: '/cointracker/app/components/coinInfo/coinInfo.html', 
		controller: CoinController; 
	});
	
	function CoinController(coinService) { 

		this.getCoins = function(){

				coinService.getAllCoins(function(data){
					this.coin = data;
					console.log(this.coin);

				}.bind(this));

			}
			
			this.init = function(){
	            this.getCoins();
			};

			this.init();
		}
	
	
})(window.angular);	
