var Singleton = (function () {
	var instance;

	function createInstance() {
		var obj = new Object();
		return obj;
	}

	return {
		getInstance: function() {
			if (!instance) {
				instance = createInstance();
			}
			return instance;
		}	
	};
})();

var one = Singleton.getInstance();
var two = Singleton.getInstance();
alert (one === two);
