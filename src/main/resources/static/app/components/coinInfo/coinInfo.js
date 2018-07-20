(function(angular) {
	'use strict';
	angular.module('app').component('coinInfo', {
		templateUrl: '/cointracker/app/components/coinInfo/coinInfo.html', 
		controller: CoinController; 
		binding: {
			coin: '<'
		}
	});
	
	function CoinController(coinService){
		coinService.getAllCoins(function(data){
			
		}){
			
		}
	}
	
/*	function HeaderController() { 
		
		var getCurrentUserContext = function(){
			//add code here to determine the menu options rendered to the user based on the user roles and permissions
		};
		
		this.init = function(){
			getCurrentUserContext();
		};
		
		this.init();
	}*/
	
})(window.angular);	
