package com.simplicite.objects.Booking;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.commons.Booking.BookCommon;
/**
 * Business object BookRoomEquipment
 */
public class BookRoomEquipment extends ObjectDB {
	private static final long serialVersionUID = 1L;
	
		@Override
	public List<String> postValidate() {
		List<String> msgs = new ArrayList<>();
		if (!isBatchInstance() && (isNew()|| isCopied()))
		   setFieldValue("bookEquCode", BookCommon.getNumber(getGrant(),"REQU","book_room_equipment", "book_equ_code"));
		
		return msgs;
	}
}
