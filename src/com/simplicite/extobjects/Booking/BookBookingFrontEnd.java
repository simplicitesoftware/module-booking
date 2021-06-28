package com.simplicite.extobjects.Booking;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;
import com.simplicite.webapp.web.BootstrapWebPage;
/**
 * External object BookBookingFrontEnd
 */
public class BookBookingFrontEnd extends ExternalObject {
	private static final long serialVersionUID = 1L;

	/**
	 * Display method
	 * @param params Request parameters
	 */
	@Override
	public Object display(Parameters params) {
		try {
			boolean pub = isPublic();
			setDecoration(!pub);
			String render = getName() + ".render(" + params.toJSONObject().put("bannerURL", HTMLTool.getResourceImageURL(this, "BANNER")).put("pub", pub).toString() + ");";
			if (pub) { 
				BootstrapWebPage wp = new BootstrapWebPage(params.getRoot(), getDisplay());
				wp.setFavicon(HTMLTool.getResourceIconURL(this, "FAVICON"));
				wp.appendAjax(true);
				wp.appendMustache();
				wp.appendJSInclude(HTMLTool.getResourceJSURL(this, "SCRIPT"));
				wp.appendCSSInclude(HTMLTool.getResourceCSSURL(this, "STYLES"));
				wp.append(HTMLTool.getResourceHTMLContent(this, "HTML"));
				wp.setReady(render);
				return wp.toString();
			} else { // Private page version
				addMustache();
				return javascript(render);
			}
		} catch (Exception e) {
			AppLog.error(null, e, getGrant());
			return e.getMessage();
		}
	}
}
