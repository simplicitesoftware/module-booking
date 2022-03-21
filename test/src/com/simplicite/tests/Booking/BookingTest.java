package com.simplicite.tests.Booking;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import org.junit.Test;
import com.simplicite.util.*;

/**
 * Demo unit tests
 */
public class BookingTest {
	/** Date test */
	@Test
	public void testDiffDate() {
		try {
				assertTrue(Tool.compareDate("2021-06-11", "2021-06-01")>0);
				assertFalse(Tool.compareDate("2021-06-01", "2021-06-11")>0);
		} catch (Exception e) {
				fail(e.getMessage());
		}	
	}
}
