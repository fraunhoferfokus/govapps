package de.fraunhofer.fokus.movepla;

/*
 * #%L
 * govapps_data
 * $Id: Constants.java 566 2014-11-13 15:22:01Z sma $
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


/**
 * @author Brian Wing Shun Chan
 */
public class Constants {

	// target OS
	public static final int ANDROID = 1;
	public static final int IOS     = 2;
	public static final int WINDOWS = 3;

	
	// min target OS version
	public static final int ANDROID_1_0   = 1;
	public static final int ANDROID_1_1   = 2;
	public static final int ANDROID_1_5   = 3;	// Cupcake
	public static final int ANDROID_1_6   = 4;	// Donut
	public static final int ANDROID_2_0   = 5;	// �clair
	public static final int ANDROID_2_1   = 7;	// �clair
	public static final int ANDROID_2_2   = 8;	// Froyo
	public static final int ANDROID_2_2_1 = 8;	// Froyo
	public static final int ANDROID_2_2_2 = 8;	// Froyo
	public static final int ANDROID_2_3   = 9;	// Gingerbread
	public static final int ANDROID_2_3_1 = 9;	// Gingerbread
	public static final int ANDROID_2_3_2 = 9;	// Gingerbread
	public static final int ANDROID_2_3_3 = 10;	// Gingerbread
	public static final int ANDROID_2_3_4 = 10;	// Gingerbread
	public static final int ANDROID_2_3_5 = 10;	// Gingerbread
	public static final int ANDROID_2_3_6 = 10;	// Gingerbread
	public static final int ANDROID_2_3_7 = 10;	// Gingerbread
	public static final int ANDROID_3_0   = 11;	// Honeycomb
	public static final int ANDROID_3_1   = 12;	// Honeycomb
	public static final int ANDROID_3_2   = 13;	// Honeycomb
	public static final int ANDROID_3_2_1 = 13;	// Honeycomb
	public static final int ANDROID_4_0   = 14;	// Ice Cream Sandwich
	public static final int ANDROID_4_0_1 = 14;	// Ice Cream Sandwich
	public static final int ANDROID_4_0_2 = 14;	// Ice Cream Sandwich
	public static final int ANDROID_4_0_3 = 15;	// Ice Cream Sandwich
	public static final int ANDROID_4_0_4 = 15;	// Ice Cream Sandwich
	public static final int ANDROID_4_1   = 16;	// Jelly Bean
	public static final int ANDROID_4_1_1 = 16;	// Jelly Bean

//	public static final int ANDROID_4_2   = 17;	// Key lime pie

	public static final int IOS_1_0   = 21;	
	public static final int IOS_1_1_3 = 2113;	
	public static final int IOS_2_0   = 22;	
	public static final int IOS_2_1   = 221;	
	public static final int IOS_3_0   = 230;	
	public static final int IOS_3_1   = 231;	
	public static final int IOS_3_2   = 232;	
	public static final int IOS_4_2   = 242;	
	public static final int IOS_4_3   = 243;	
	public static final int IOS_5_1   = 251;	
	public static final int IOS_6_0   = 260;	
	
	public static final int Windows_7_0_7004_0   = 7070040;   // Windows Phone 7 	
	public static final int Windows_7_0_7008_0   = 7070080;   // PreNoDo 
	public static final int Windows_7_0_7390_0   = 7073900;   // NoDo
	public static final int Windows_7_0_7392_0   = 7073920;   // 
	public static final int Windows_7_0_7403_0   = 7074030;   // 
	public static final int Windows_7_10_7720_68 = 710772068; // Mango / Windows Phone 7.5
	public static final int Windows_7_10_7740_16 = 710774016; // 
	public static final int Windows_7_10_8107_79 = 710810779; // 
	public static final int Windows_7_10_8112_7  = 71081127;  // 
	public static final int Windows_7_10_8773_98 = 710877398; // Tango / Windows Phone 7.5 Refresh 
	 	
		
	// Application life-cycle STATUS	
	public static final int APPLICATION_STATUS_SUBMITTED   = 1;	
	public static final int APPLICATION_STATUS_DELETED     = 2;	
	public static final int APPLICATION_STATUS_RESUBMITTED = 3;	
	public static final int APPLICATION_STATUS_REJECTED    = -1;	
	public static final int APPLICATION_STATUS_VERIFIED_AND_RESUBMITTED   = -3;
	public static final int APPLICATION_STATUS_VERIFIED    = 4;
	public static final int APPLICATION_STATUS_CERTIFIED   = 5;
	public static final int APPLICATION_STATUS_OLD_VERIFIED   = 6;
	
	
	// user roles
	public static final String APP_DEVELOPER     = "Anwendung_entwickler";
	public static final String FORM_DEVELOPER    = "Anwendung_entwickler_form";
	public static final String CONTENT_PROVIDER  = "Anwendung_redakteur";
	public static final String PLATFORM_ADMIN    = "Anwendung_admin";

	// Link types
	public static final int SOURCE_CODE    				= 1;
	public static final int TARGET_LINK				  	= 2;
	public static final int BINARY_CODE    				= 3;
	public static final int APPLICATION_HOME_PAGE   	= 4;
	public static final int DEVELOPER_HOME_PAGE    		= 5;
	public static final int LEGAL_DETAILS_HOME_PAGE  	= 6;
	public static final int OPENDATA				  	= 7;
	

	// app use open data
	public static final int USE_OPEN_DATA  				= 1;

}
