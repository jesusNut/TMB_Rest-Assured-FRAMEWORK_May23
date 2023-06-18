package com.jesusnut.constants;

import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.jesusnut.config.ConfigFactory;
import com.jesusnut.utils.DateTimeUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access=AccessLevel.PRIVATE)
public final class FrameworkConstants {

	// Constants related to *** ACROSS FRAMEWORK ***

	private static final String WORKING_DIRECTORY_PATH = System.getProperty("user.dir");
	public static final String FRAMEWORK_EXCEPTION_GENERIC_MESSAGE = "JESUSNUT REST ASSURED API TESTING FRAMEWORK [Powered by TMB] :";

	// Constants related to *** FOLDER TO KEEP REQUEST JSONs & to STORE RESPONSE
	// JSONs ***

	public static final String REQUEST_JSON_FOLDER_PATH = WORKING_DIRECTORY_PATH + "/src/test/resources/RequestJsons/";
	public static final String RESPONSE_JSON_FOLDER_PATH = WORKING_DIRECTORY_PATH + "/output/";
	
	// Constants related to *** ICONS ***

		public static final String BOLD_START = "<b>";
		public static final String BOLD_END = "</b>";
		
		public static final String ICON_SMILEY_PASS = "<i class=\"fa fa-graduation-cap\" aria-hidden=\"true\" style=\"font-size:20px;color:#7AE81D\"></i>";
		public static final String ICON_SMILEY_SKIP = "<i class=\"fa fa-fast-forward\" aria-hidden=\"true\" style='font-size:20px'></i>";
		public static final String ICON_SMILEY_FAIL = "<i class=\"fa fa-bug\" aria-hidden=\"true\" style=\"font-size:20px;color:#ff5722\"></i>";
		

	// Constants related to *** EXCEL DATA SHEET for DATA DRIVEN TESTING ***

	public static final String DATAEXCEL_LOCATION = WORKING_DIRECTORY_PATH + "/src/test/resources/excel/";
	public static final String DATAEXCEL_WORKBOOK_NAME = "testdata";
	public static final String DATAEXCEL_DATASHEET_NAME = "iterationData";
	public static final String DATAEXCEL_RUNMANAGERSHEET_NAME = "runManager";

	// Constants related to *** EXTENT REPORT ***

	private static String extentReportFilePath = "";
	public static final String FRAMEWORK_EXTENTREPORT_DOCUMENT_TITLE = "JesusNut RestAssured Framework Result";
	public static final String FRAMEWORK_EXTENTREPORT_NAME = "JesusNut RestAssured Framework Results";
	public static final ViewName[] FRAMEWORK_EXTENTREPORT_VIEWING_ORDER = new ViewName[] { ViewName.DASHBOARD,
			ViewName.TEST, ViewName.CATEGORY, ViewName.AUTHOR, ViewName.DEVICE, ViewName.LOG };
	public static final String FRAMEWORK_EXTENT_LOGO_PATH = "url('file:///D:/WORKSPACE/SELENIUM_OWN/TMB_Selenium-FRAMEWORK_July22/src/main/resources/extentCustomizationResources/TMB.png')";
	private static final String EXTENTREPORTOUTPUT_FOLDER = WORKING_DIRECTORY_PATH + "/extent-test-output";

	/**
	 * Returns Extent Report path.
	 * 
	 * @return Extent Report path in String format.
	 * @see FrameworkConstants#createExtentReportPath()
	 */

	public static String getExtentReportPath() {

		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = createExtentReportPath();
		}
		return extentReportFilePath;
	}

	/**
	 * Creates Extent Report Path based on overrideReports property as provided by
	 * user through
	 * {@link com.jesusnut.config.ConfigFactory#hasOverrideReports()}<br>
	 * 
	 * @return Extent Report Path in String format.
	 * @see FrameworkConstants#getExtentReportPath()
	 */

	private static String createExtentReportPath() {

		if (!ConfigFactory.hasOverrideReports()) {
			String finalDateTimeFormat = DateTimeUtils.getLocalDateTime();
			return EXTENTREPORTOUTPUT_FOLDER + "/" + finalDateTimeFormat + "_" + "index.html";
		}

		else {
			return EXTENTREPORTOUTPUT_FOLDER + "/index.html";
		}

	}

}
