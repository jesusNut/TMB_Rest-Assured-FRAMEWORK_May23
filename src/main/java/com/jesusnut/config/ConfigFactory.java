package com.jesusnut.config;

import java.util.Objects;

import com.jesusnut.constants.FrameworkConstants;
import com.jesusnut.exception.FrameworkException;

public final class ConfigFactory {

	private static FrameworkConfig getConfig() {

		return org.aeonbits.owner.ConfigFactory.create(FrameworkConfig.class);

	}

	public static String getBaseURL() {

		String url = getConfig().baseURL();

		if (!((Objects.isNull(url)) || url.isBlank())) {

			return url.trim();
		}

		else {

			throw new FrameworkException(
					FrameworkConstants.FRAMEWORK_EXCEPTION_GENERIC_MESSAGE + "=> Base URL is either null or blank. \n Investigate in System properties/System environment/config.properties files");
		}

	}

	public static boolean hasCustomizedReport() {

		boolean customizedReportValue;

		try {

			customizedReportValue = getConfig().customizedReport();

		} catch (UnsupportedOperationException | NullPointerException e) {

			throw new FrameworkException(
					FrameworkConstants.FRAMEWORK_EXCEPTION_GENERIC_MESSAGE + "=> Please enter correct values [true/false] for [customizedReport] key in System properties/System environment/config.properties files. Entered value is either blank or incorrect OR \n [customizedReport] key provided through System properties/System environment/Config.properties files is either missing/commented out",
					e);

		}
		return customizedReportValue;

	}

	public static boolean hasOverrideReports() {

		boolean overrideReportsValue;

		try {

			overrideReportsValue = getConfig().overrideReports();

		} catch (UnsupportedOperationException | NullPointerException e) {

			throw new FrameworkException(
					FrameworkConstants.FRAMEWORK_EXCEPTION_GENERIC_MESSAGE + "=> Please enter correct values [true/false] for [overrideReports] key in System properties/System environment/config.properties files. Entered value is either blank or incorrect OR \n [overrideReports] key provided through System properties/System environment/Config.properties files is either missing/commented out",
					e);

		}
		return overrideReportsValue;

	}

}
