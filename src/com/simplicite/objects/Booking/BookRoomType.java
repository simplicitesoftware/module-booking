package com.simplicite.objects.Booking;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;
import com.simplicite.commons.Booking.BookCommon;
/**
 * Business object BookRoomType
 */
public class BookRoomType extends ObjectDB {
	private static final long serialVersionUID = 1L;
	
		@Override
	public List<String> postValidate() {
		List<String> msgs = new ArrayList<>();
		if (isNew()|| isCopied())
		   setFieldValue("bookRoomtypCode", BookCommon.getNumber(getGrant(),"RTYP","book_room_type", "book_roomtyp_code"));
		
		return msgs;
	}
}
