package com.simplicite.objects.Booking;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;

/**
 * Business object BookBookings
 */
public class BookBookings extends ObjectDB {
	private static final long serialVersionUID = 1L;
	
	@Override
	public List<String> postValidate() {
		List<String> msgs = new ArrayList<>();
		if (Tool.diffDate(getFieldValue("bookBookbookingsStartDate"), getFieldValue("bookBookbookingsEndDate")) <=0)
				msgs.add(Message.formatError("BOOK_ERROR_DATE", null, "bookBookbookingsEndDate"));
		return msgs;
	}
}
