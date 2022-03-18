package com.simplicite.objects.Booking;

import com.simplicite.util.*;
import com.simplicite.util.tools.GMapTool;
import com.simplicite.util.tools.GMapTool.Location;
/**
 * Business object BookUsers
 */
public class BookUsers extends ObjectDB {
	private static final long serialVersionUID = 1L;
	
	
	/** Hook override: geolocate from address fields */
	@Override
	public String preSave() {
		if (!isBatchInstance()) try {
			// Geocode address fields
			ObjectField coords = getField("bookUserGeoCoord");
			ObjectField a1 = getField("usr_address1");
			ObjectField a2 = getField("usr_address2");
			ObjectField zc = getField("usr_address2");
			ObjectField ci = getField("usr_city");
			ObjectField co = getField("usr_country");

			if (coords.isEmpty() || a1.hasChanged() || a2.hasChanged() || zc.hasChanged() || ci.hasChanged() || co.hasChanged()) {
				String a = a1.getValue() + (a2.isEmpty() ? "" : ", " + a2.getValue()) + ", " + zc.getValue() + ", " + ci.getValue() + ", " + co.getValue();
				AppLog.info("Try to geocode " + a, getGrant());
				Location c = new GMapTool(getGrant()).geocodeOne(a);
				AppLog.info("Coordinates = " + c, getGrant());
				coords.setValue(c==null ?  "" : c.toString());
			}
		} catch (Exception e) {
			AppLog.error(null, e, getGrant());
		}
		return super.preSave();
	}	
}
