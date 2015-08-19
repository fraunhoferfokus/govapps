package de.fraunhofer.fokus.movepla.portlets;

/*
 * #%L
 * govapps_data
 * $Id: AppScheduler.java 566 2014-11-13 15:22:01Z sma $
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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.service.UserLocalServiceUtil;

import de.fraunhofer.fokus.movepla.model.Application;
import de.fraunhofer.fokus.movepla.service.ApplicationLocalServiceUtil;

public class AppScheduler implements MessageListener {

	private static Log _log = LogFactoryUtil.getLog(AppScheduler.class);

	
	private static final String MAIL_PRE = "Hallo,\n\n" +
			"folgende Eintraege wurden seit der letzten Stunde registriert.\n\n";
	private static final String MAIL_POST = "\n" +
			"Die Eintraege sollten moeglichst umgehend bearbeitet werden!\n" +
			"\n" +
			"Vielen Dank sagt,\n" +
			"Ihr GOVApps System";
	
	public void receive(Message arg0) throws MessageListenerException {
	
		_log.debug("receive() - start");
		
		try {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.HOUR, -1);
			Date time = cal.getTime();
			StringBuffer mailBody = new StringBuffer(MAIL_PRE);
			int apps = 0;
			int currentapps = 0;
			/*
			 * neue apps
			 */
			mailBody.append("\nNeue Apps:\n");
			currentapps = getApps(E_Stati.APPLICATION_STATUS_SUBMITTED, time, mailBody);
			if (currentapps > 0) {
				apps += currentapps;
				currentapps = 0;
			} else
				mailBody.append("\t keine\n");
			/*
			 * geloeschte apps
			 */
			mailBody.append("\nGeloeschte Apps:\n");
			currentapps = getApps(E_Stati.APPLICATION_STATUS_DELETED, time, mailBody);
			if (currentapps > 0) {
				apps += currentapps;
				currentapps = 0;
			} else
				mailBody.append("\t keine\n");
			/*
			 * editierte apps
			 */
			mailBody.append("\nBearbeitete Apps:\n");
			currentapps = getApps(E_Stati.APPLICATION_STATUS_RESUBMITTED, time, mailBody);
			if (currentapps > 0) {
				apps += currentapps;
				currentapps = 0;
			} else
				mailBody.append("\t keine\n");
			
			/*
			 * editierte apps die freigegeben waren
			 */
			mailBody.append("\nneu bearbeitete Apps die freigegeben waren:\n");
			currentapps = getApps(E_Stati.APPLICATION_STATUS_VERIFIED_AND_RESUBMITTED, time, mailBody);
			if (currentapps > 0) {
				apps += currentapps;
				currentapps = 0;
			} else
				mailBody.append("\t keine\n");
			
			if (apps > 0) {
				_log.debug("Sending apps mail ....");
				mailBody.append(MAIL_POST);
				MailUtil.sendInternal("[AppUpdate] "+apps+" anstehende Freigaben", mailBody.toString());
			} else {
				_log.debug("No new apps available!");
			}
		} catch (Throwable e) {
			_log.error("Sending scheduler mail failed!",e);
		}
		_log.debug("receive() - end");
	}
	
	private int getApps(E_Stati status, Date time, StringBuffer buffer) throws SystemException {
		int result = 0;
		List<Application> apps = ApplicationLocalServiceUtil.getApplicationsAfter(status.getIntStatus(), time);
		if (apps != null && apps.size() > 0) {
			StringBuffer appStr = new StringBuffer();
			for (Application app: apps) {
				String name = app.getName();
				Date modified = app.getModifiedDate();
				SimpleDateFormat sdf = new SimpleDateFormat("dd.MM. HH:mm");
				String modStr = sdf.format(modified);
				String mail = null;
				try {
					mail = UserLocalServiceUtil.getUser(app.getUserId()).getEmailAddress();	
				} catch (Throwable t) {
					mail = "N/A";
				}
				appStr.append("\t Name: ").append(name).append(", Zeit: ").append(modStr).append(", Entwickler: ").append(mail).append("\n");
			}
			buffer.append(appStr);
			result = apps.size();
		}
		return result;
	}
}
