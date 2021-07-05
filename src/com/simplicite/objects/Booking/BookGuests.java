package com.simplicite.objects.Booking;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;

/**
 * Business object BookGuests
 */
public class BookGuests extends BookUsers {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String postCreate() {
		if (isProcessInstance()){
			String demandId = getGrant().getParameter("DEMANDID");
			if (!Tool.isEmpty(demandId)){
				createBookingGuest(getGrant(), demandId, getRowId());
			}	
		} 
		return null;
	}
	
	public void createBookingGuest(Grant g, String demandId, String rowid){
		try {
			ObjectDB o = getGrant().getTmpObject("BookBookingsBookGuests");
			BusinessObjectTool ot = o.getTool();
			ot.getForCreate();
			o.setFieldValue("bookBookingsfk", demandId); 
			o.setFieldValue("bookGuestsId", rowid); 
			ot.validateAndSave();
			getGrant().removeParameter("DEMANDID");
			
		} catch (Exception e) {
			AppLog.error(e, getGrant());
		}
		
	}
}
