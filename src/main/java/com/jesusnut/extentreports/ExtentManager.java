package com.jesusnut.extentreports;

import com.aventstack.extentreports.ExtentTest;

//Implementation of thread local class for Extent Test Object's thread Safety during parallel execution

public final class ExtentManager {

	private ExtentManager() {

	}

	private static ThreadLocal<ExtentTest> exTest = new ThreadLocal<ExtentTest>();

	 static ExtentTest getExtentTest() {

		return exTest.get();

	}

	 static void setExtentTest(ExtentTest test) {

		exTest.set(test);
	}

}
