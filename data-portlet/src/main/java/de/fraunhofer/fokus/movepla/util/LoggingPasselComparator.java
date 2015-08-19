package de.fraunhofer.fokus.movepla.util;

/*
 * #%L
 * govapps_data
 * $Id: LoggingPasselComparator.java 566 2014-11-13 15:22:01Z sma $
 * %%
 * Copyright (C) 2013 - 2014 Fraunhofer FOKUS / CC ÖFIT
 * %%
 * Copyright (c) 2,013, Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT 
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 
 * 1) Redistributions of source code must retain the above copyright notice, 
 *    this list of conditions and the following disclaimer.
 * 
 * 2) Redistributions in binary form must reproduce the above copyright notice, 
 *    this list of conditions and the following disclaimer in the documentation 
 *    and/or other materials provided with the distribution.
 * 
 * 3) All advertising materials mentioning features or use of this software must 
 *    display the following acknowledgement: 
 *    This product includes software developed by Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT.
 * 
 * 4) Neither the name of the organization nor the names of its contributors may 
 *    be used to endorse or promote products derived from this software without 
 *    specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY COPYRIGHT HOLDER ''AS IS'' AND ANY EXPRESS OR 
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF 
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
 * IN NO EVENT SHALL 
 * Fraunhofer FOKUS, Kompetenzzentrum Oeffentliche IT 
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) 
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT 
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import de.fraunhofer.fokus.movepla.model.Logging;

public class LoggingPasselComparator extends OrderByComparator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1400936894736104435L;
	private static Log _log = LogFactoryUtil.getLog(LoggingPasselComparator.class);
	public static String ORDER_BY_DESC = "status DESC";
	public static String ORDER_BY_ASC = "status ASC";
	
	private boolean _asc = false;
	
	
	
	public LoggingPasselComparator() {
	   this(false);
	}

	public LoggingPasselComparator(boolean asc) {
	  _asc  = asc;
//      _log.debug("_asc: "+ _asc);
	}
	
	
	@Override
	public int compare(Object obj1, Object obj2) {

		Logging instance1 = (Logging) obj1;
		Logging instance2 = (Logging) obj2;
	
		int value = -1;
		if (instance1.getPassel() == instance2.getPassel()) {
			value = 0;
		}
		if (instance1.getPassel() > instance2.getPassel()) {
			value = 1;
		}

		if(_asc) {
		    return value;
		} else {
			return -value;
		}
	 }


	public String getOrderBy() {
		if (_asc) {
			return ORDER_BY_ASC;
		} else {
			return ORDER_BY_DESC;
		}
	}	
}
