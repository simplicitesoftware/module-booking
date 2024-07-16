var BookBookingFrontEnd = BookBookingFrontEnd || (function($) {
	var app, room;

	/**
	 * Render
	 * @param params Parameters
	 * @function
	 */
	function render(params) {
		try {
			if (typeof Mustache === 'undefined') throw 'Mustache not available';
			var div = $('#bookingfrontend');
			if (!params.pub) div.css('min-height', '1000px');
			
			app = app || (params.pub
				? new Simplicite.Ajax(params.root, 'api', 'public', 'ruHcwN5b')
				: Simplicite.Application); // Internal
	
			room = room || app.getBusinessObject('BookRoom');
			room.bannerURL = room.bannerURL || params.bannerURL; // Image banner URL
			room.toFixed = room.toFixed || function() { return function(n, r) { return parseFloat(r(n)).toFixed(2); } }; 

			room.search(function() {
				div.html(Mustache.render($('#booking-template').html(), room));
			}, null, { inlineDocs: true });
		} catch(e) {
			console.error('Render error: ' + e.message);
		}
	}

	return { render: render };	
})(jQuery);
