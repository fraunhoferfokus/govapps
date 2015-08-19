package de.fraunhofer.fokus.movepla.portlets;

/*
 * #%L
 * govapps_data
 * $Id: E_Stati.java 566 2014-11-13 15:22:01Z sma $
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


public enum E_Stati {

	APPLICATION_STATUS_SUBMITTED("APPLICATION_STATUS_SUBMITTED", 1),
	APPLICATION_STATUS_DELETED("APPLICATION_STATUS_DELETED", 2),
	APPLICATION_STATUS_RESUBMITTED("APPLICATION_STATUS_RESUBMITTED", 3),
	APPLICATION_STATUS_VERIFIED_AND_RESUBMITTED("APPLICATION_STATUS_VERIFIED_AND_RESUBMITTED", -3),	
	APPLICATION_STATUS_REJECTED("APPLICATION_STATUS_REJECTED", -1),
	APPLICATION_STATUS_VERIFIED("APPLICATION_STATUS_VERIFIED", 4),	
	APPLICATION_STATUS_CERTIFIED("APPLICATION_STATUS_CERTIFIED", 5),
	APPLICATION_STATUS_OLD_VERIFIED("APPLICATION_STATUS_OLD_VERIFIED", 6);
	
	private String m_strStatus;
	private int    m_intStatus;
	
	private E_Stati(String strStatus, int intStatus) {
		m_strStatus = strStatus;
		m_intStatus = intStatus;
	}
	

	public String getStrStatus() {
		return m_strStatus;
	}
	
	public int getIntStatus() {
		return m_intStatus;
	}
}
