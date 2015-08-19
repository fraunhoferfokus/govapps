package de.fraunhofer.fokus.movepla.portlets;

/*
 * #%L
 * govapps_data
 * $Id: MailUtil.java 566 2014-11-13 15:22:01Z sma $
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

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.service.CompanyServiceUtil;

public class MailUtil {

	public static void sendInternal(String subject, String body) throws SystemException, AddressException, PortalException {
		sendInternal(subject, body, false);
	}
	
	public static void sendInternal(String subject, String body, boolean isHtml)
			throws SystemException, AddressException, PortalException {
	
		Company cmp = null;
		try {
		  cmp = CompanyServiceUtil.getCompanyByVirtualHost(AppConstants.COMPANY_VIRTUAL_HOST);
		} catch (Throwable t) {
			
		}
		if (cmp != null) {
			long cmpId = cmp.getCompanyId();
			String toStr = PrefsPropsUtil.getString(cmpId,
					PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
			send(toStr, subject, body, isHtml);
		}
	}

	public static void send(String toStr, String subject,
			String body, boolean isHtml) throws SystemException, AddressException, PortalException {

		Company cmp = null;
		try {
		  cmp = CompanyServiceUtil.getCompanyByVirtualHost(AppConstants.COMPANY_VIRTUAL_HOST);
		} catch (Throwable t) {
			
		}
		if (cmp != null) {
			long cmpId = cmp.getCompanyId();
			String fromStr = PrefsPropsUtil.getString(cmpId,
					PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
			InternetAddress from = new InternetAddress(fromStr);
			InternetAddress to = new InternetAddress(toStr);
			if (from != null && to != null && subject != null && body != null) {
				MailMessage message = new MailMessage(from, to, subject, body, isHtml);
				MailServiceUtil.sendEmail(message);
			}
		}

	}

}
