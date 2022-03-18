package com.simplicite.workflows.Booking;

import com.simplicite.bpm.*;
import com.simplicite.util.*;

/**
 * Process BookingCreation
 */
public class BookingCreation extends Processus {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void postValidate(ActivityFile context) {
		String step = context.getActivity().getStep();
		
		if ("BC-BOOKING".equals(step)){
			DataFile df = context.getDataFile("Field", "row_id", false);
			if (df==null) return;
			getGrant().setParameter("DEMANDID",df.getValue(0));
				
		}else if ("BC-GUESTS".equals(step)){
			context.setDataFile("Field", "row_id", ObjectField.DEFAULT_ROW_ID);
			
		}
	}
}
