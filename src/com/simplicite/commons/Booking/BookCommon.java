package com.simplicite.commons.Booking;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;

/**
 * Shared code BookCommon
 */
public class BookCommon implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	public static String getNumber(Grant g, String suffixe, String table, String attr){
		String query="select max("+attr+") from "+table;
		String max = g.simpleQuery(query);
		AppLog.info("message"+ query + max.length(), g);
		int n = max.length()>0 ? Integer.parseInt(max.substring(suffixe.length())) : 0;
		AppLog.info("message"+ n , g);
		return Tool.format(suffixe+"%03d", n+1);
	}	
}
