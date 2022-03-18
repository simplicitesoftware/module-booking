package com.simplicite.objects.Booking;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;
import com.simplicite.commons.Booking.BookCommon;
/**
 * Business object BookRoomService
 */
public class BookRoomService extends ObjectDB {
	private static final long serialVersionUID = 1L;
	
	@Override
	public List<String> postValidate() {
		List<String> msgs = new ArrayList<>();
		if (isNew()|| isCopied())
		   setFieldValue("bookRservCode", BookCommon.getNumber(getGrant(),"RSERV","book_room_service", "book_rserv_code"));
		
		return msgs;
	}
}
