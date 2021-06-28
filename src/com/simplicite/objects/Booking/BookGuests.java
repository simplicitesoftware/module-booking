package com.simplicite.objects.Booking;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;

/**
 * Business object BookGuests
 */
public class BookGuests extends ObjectDB {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String preCreate() {
		
		if (isProcessInstance()){
			String demandId = getGrant().getParameter("DEMANDID");
			if (!Tool.isEmpty(demandId)){
				createGuest(getGrant(), demandId, getRowId());
			}	
		} 
		return null;
	}
	
	public void createGuest(Grant g, String demandId, String rowid){
		try {
			ObjectDB o = getGrant().getTmpObject("BookBookingsBookGuests");
			BusinessObjectTool ot = o.getTool();
			ot.getForCreate();
			o.setFieldValue("bookBookingsfk", demandId); 
			o.setFieldValue("bookGuestsId", rowid); 
			ot.validateAndSave();
			
		} catch (Exception e) {
			AppLog.error(e, getGrant());
		}
		
	}
}
