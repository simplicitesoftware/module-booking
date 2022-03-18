package com.simplicite.objects.Booking;

import com.simplicite.util.*;
import com.simplicite.util.tools.*;
import org.json.JSONObject;
/**
 * Business object BookBookingsBookGuests
 */
public class BookBookingsBookGuests extends ObjectDB {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public String postUpdate() {
		
		if(!Tool.isEmpty(getFieldValue("bookBookingsBookGuestsBookRoomId")) ){
		try {
				ObjectDB o = getGrant().getTmpObject("BookBookings");
				BusinessObjectTool ot = o.getTool();
				if (ot.getForCreateOrUpdate(new JSONObject() 
					.put("row_id", getFieldValue("bookBookingsfk"))))
				{
					o.setStatus("TR");
					ot.validateAndSave();	
				}
				
			} catch (Exception e) {
				AppLog.error(e, getGrant());
			}

		}
		return null;
	}
}
