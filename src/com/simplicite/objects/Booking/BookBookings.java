package com.simplicite.objects.Booking;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;
import java.util.Map;

import org.junit.Test;
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
		if (Tool.diffDate(getFieldValue("bookBookbookingsStartDate"), getFieldValue("bookBookbookingsEndDate")) <=0)
			msgs.add(Message.formatError("BOOK_ERROR_DATE", null, "bookBookbookingsEndDate"));
		return msgs;
	}
	
	/** Hook override: send notification to customer after booking creation */
	@Override
	public String postCreate() {
		if(!isBatchInstance()){
			try {
					MailTool mail = new MailTool(getGrant());
					mail.addRcpt(getFieldValue("bookBookusersEmail"));
					mail.setSubject("Demande de réservation reçue/ Booking creation");
					String body = HTMLTool.getResourceHTMLContent(this, "TEMPLATE_MAIL");
					body =  body.replace("[TITLE]", getFieldValue("usr_title"));
					body =  body.replace("[LASTNAME]", getFieldValue("usr_last_name"));
					body =  body.replace("[FIRSTNAME]", getFieldValue("usr_first_name"));
					body =  body.replace("[DATE]", getFieldValue("bookBookbookingsDate"));
					body =  body.replace("[HOUR]", getFieldValue("bookBookbookingsHour").substring(5));
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
