package com.jesusnut.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.jesusnut.annotations.FrameworkAnnotation;
import com.jesusnut.apibuilders.RequestBuilder;
import com.jesusnut.enums.Category;
import com.jesusnut.extentreports.ExtentLogger;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetTests {

	@FrameworkAnnotation(category = { Category.REGRESSION })
	@Test(enabled = true, description = "Test to get details of the employees in the database.")

	public void getEmployeeDetails() {

		RequestSpecification requestSpecification = RequestBuilder.buildRequestForGetCalls();

		Response response = requestSpecification.get("/employees");

		// to print on console

		response.prettyPrint();

		// to log request without request body (as GET methods dont have request body)

		ExtentLogger.logRequest(requestSpecification);

		// to log response in extent report

		ExtentLogger.logResponse(response);

		Assertions.assertThat(response.jsonPath().getList("$").size()).isGreaterThan(2);
		Assertions.assertThat(response.getStatusCode()).isEqualTo(200);

	}

	@FrameworkAnnotation(category = { Category.REGRESSION })
	@Test(enabled = true, description = "Test to get details of the first employee in the database.")

	public void getSpecificEmployeeDetail() {

		RequestSpecification requestSpecification = RequestBuilder.buildRequestForGetCalls().pathParam("id", 1);

		Response response = requestSpecification.get("/employees/{id}");
		// to print on console

		response.prettyPrint();

		// to log request without request body (as GET methods dont have request body)

		ExtentLogger.logRequest(requestSpecification);

		// to log response in extent report

		ExtentLogger.logResponse(response);

		Assertions.assertThat(response.jsonPath().getString("first_name")).as("Validating first name")
				.isEqualTo("Ankushe");
		Assertions.assertThat(response.jsonPath().getString("last_name")).as("Validating second name")
				.isEqualTo("babu");
		Assertions.assertThat(response.getStatusCode()).isEqualTo(200);

	}

}
