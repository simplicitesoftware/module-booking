//----------------------------------------------------
// Client-side logic for customer business object
//----------------------------------------------------
var BookUsers = BookUsers || (function($) {
	// Display Google Map
	var _map = function() {
		var rowId = _val("row_id");
		if (rowId && rowId != "0") {
			var c = _val("bookUserGeoCoord");
			if (c !== "") {
				var latlgn = c.replace(";", ",").split(",");
				var pos = new google.maps.LatLng(latlgn[0], latlgn[1]);
				var map = new google.maps.Map($("#client-map").show()[0], { center: pos, zoom: 13, mapTypeId: google.maps.MapTypeId.ROADMAP });
				var mrk = new google.maps.Marker({ position: pos, map: map });
				var name = $.escapeHTML(_val("bookUserFirstname") + " " + _val("BookUserLastname"));
				var addr = $.escapeHTML(_val("bookUserAddress1") + ", " + _val("bookUserZipcode") + " " + _val("bookUserCity") + ", " + _val("bookUserCountry"));
				var inf = new google.maps.InfoWindow({ content: "<div style=\"width: 200px; height: 75px;\"><b>" + name + "</b><br/>" + addr + "</div>" });
				google.maps.event.addListener(mrk, "click", function() { inf.open(map, mrk); });
			}
			return false;
		}
	};
	
	var _val;
	// Responsive UI hook
	Simplicite.UI.hooks.BookUsers = function(o, cbk) {
		_val = function(name) { return $ui.getUIField(null, o, name).ui.val(); };

	};
	
	return {
		// Action function
		map: function() {
			if (typeof google === "undefined" || typeof google.maps === "undefined") {
				$ui.loadScript({
					url: Simplicite.GOOGLE_MAPS_JS_URL,
					onload: _map
				});
			} else {
				_map();
			}
		}
	}
})(jQuery);