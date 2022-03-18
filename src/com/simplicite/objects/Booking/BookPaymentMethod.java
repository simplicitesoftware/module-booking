package com.simplicite.objects.Booking;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.commons.Booking.BookCommon;
/**
 * Business object BookPaymentMethod
 */
public class BookPaymentMethod extends ObjectDB {
	private static final long serialVersionUID = 1L;
	
		@Override
	public List<String> postValidate() {
		List<String> msgs = new ArrayList<>();
		if (isNew()|| isCopied())
		   setFieldValue("bookPaymCode", BookCommon.getNumber(getGrant(),"PAYM","book_payment_method", "book_paym_code"));
		
		return msgs;
	}
	
}
