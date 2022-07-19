package com.simplicite.objects.Booking;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;
import com.simplicite.util.tools.JUnitTool;

/**
 * Business object BookBookings
 */
public class BookBookings extends ObjectDB {
	private static final long serialVersionUID = 1L;
	
	/** Hook override: error if the start date is greater than the end date  */
	@Override
	public List<String> postValidate() {
		List<String> msgs = new ArrayList<>();
		if (Tool.diffDate(getFieldValue("bookBookingsStartDate"), getFieldValue("bookBookingsEndDate")) <=0)
			msgs.add(Message.formatError("BOOK_ERROR_DATE", null, "bookBookingsEndDate"));
		return msgs;
	}
	
	/** Hook override: send notification to customer after booking creation */
	@Override
	public String postCreate() {
		if(!isBatchInstance()){
			try {
					MailTool mail = new MailTool(getGrant());
					mail.addRcpt(getFieldValue("bookUserEmail"));
					mail.setSubject("Demande de réservation reçue/ Booking creation");
					String body = HTMLTool.getResourceHTMLContent(this, "TEMPLATE_MAIL");
					body =  body.replace("[TITLE]", getFieldValue("usr_title"));
					body =  body.replace("[LASTNAME]", getFieldValue("usr_last_name"));
					body =  body.replace("[FIRSTNAME]", getFieldValue("usr_first_name"));
					body =  body.replace("[DATE]", getFieldValue("bookBookingsDate"));
					body =  body.replace("[HOUR]", getFieldValue("bookBookingsHour"));
					mail.setBody(body); 
					mail.send();
			} catch (Exception e) {
					AppLog.warning("Error sending notification to customer", e, getGrant());
			}
		}
		return super.postCreate();
	}
	
	@Override
	public String unitTests() {
    	return new JUnitTool(getGrant()).run("com.simplicite.tests.Booking.BookingTest");
	}
}
