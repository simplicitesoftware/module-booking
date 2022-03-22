package com.simplicite.objects.Booking;

import com.simplicite.util.*;
import com.simplicite.util.tools.*;

/**
 * Business object BookGuests
 */
public class BookGuests extends BookUsers {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String postCreate() {
		String demandId = getGrant().getParameter("DEMANDID");
		if (isProcessInstance() && !Tool.isEmpty(demandId)){
			createBookingGuest(getGrant(), demandId, getRowId());
		} 
		return null;
	}
	
	public void createBookingGuest(Grant g, String demandId, String rowid){
		try {
			ObjectDB o = g.getTmpObject("BookBookingsBookGuests");
			BusinessObjectTool ot = o.getTool();
			ot.getForCreate();
			o.setFieldValue("bookBookingsId", demandId); 
			o.setFieldValue("bookGuestsId", rowid); 
			ot.validateAndSave();
			g.removeParameter("DEMANDID");
			
		} catch (Exception e) {
			AppLog.error(e, g);
		}
		
	}
}
