package com.simplicite.objects.Booking;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.commons.Booking.BookCommon;
/**
 * Business object BookRoom
 */
public class BookRoom extends ObjectDB {
	private static final long serialVersionUID = 1L;
	
	@Override
	public List<String> postValidate() {
		List<String> msgs = new ArrayList<>();
		if (!isBatchInstance() && (isNew()|| isCopied()))
		   setFieldValue("bookRoomCode", BookCommon.getNumber(getGrant(),"ROOM","book_room", "book_room_code"));
		
		return msgs;
	}
	
	
}
