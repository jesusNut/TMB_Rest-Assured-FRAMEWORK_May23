package com.jesusnut.tests;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.jesusnut.annotations.FrameworkAnnotation;
import com.jesusnut.apibuilders.RequestBuilder;
import com.jesusnut.enums.Category;
import com.jesusnut.extentreports.ExtentLogger;
import com.jesusnut.pojo.ComplexEmployee;
import com.jesusnut.pojo.Employee;
import com.jesusnut.pojo.FavfoodForComplexEmployee;
import com.jesusnut.pojo.MarksForComplexEmployee;
import com.jesusnut.utils.FileReadWriteUtils;
import com.jesusnut.utils.RandomDataUtils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostTests  {

	
	@FrameworkAnnotation(category = { Category.REGRESSION, Category.SMOKE })
	@Test(enabled=true, description = "to create an employee (with POJO named 'Employee.java') in the database")

	// create an employee in DB using POJO (Pojo is with builder)

	public void createSimpleEmployeePOJO() {

		Employee payload = Employee.builder().setFirst_name(RandomDataUtils.getFakeFirstName())
				.setLast_name(RandomDataUtils.getFakeLastName()).setId(RandomDataUtils.getFakeID())
				.setEmail(RandomDataUtils.getFakeEmail()).build();
		

		RequestSpecification requestSpecification = RequestBuilder.buildRequestForPostCalls().body(payload);

		Response response = requestSpecification.post("/employees");

		// to print on console

		response.prettyPrint();

		// to log request in extent report

		ExtentLogger.logRequest(requestSpecification);

		// to log response in extent report

		ExtentLogger.logResponse(response);

		Assertions.assertThat(response.getStatusCode()).isEqualTo(201);

	}

	@FrameworkAnnotation(category = { Category.REGRESSION, Category.SMOKE })
	@Test(enabled=true, description = "to create an employee (skeleton in an external file) in the database & saving response body in a external file")

	// create an employee in DB using json payload coming from external file and
	// save the response in an external file

	public void createEmployeeExternalFile(Method method) {

		String jsonContentInFile = FileReadWriteUtils.readJSONFileAndGetAsString("Employee.json");

		jsonContentInFile = jsonContentInFile.replace("firstName", RandomDataUtils.getFakeFirstName())
				.replace("lastName", RandomDataUtils.getFakeLastName())
				.replace("number", String.valueOf(RandomDataUtils.getFakeID()))
				.replace("emailID", RandomDataUtils.getFakeEmail());

		RequestSpecification requestSpecification = RequestBuilder.buildRequestForPostCalls().body(jsonContentInFile);

		Response response = requestSpecification.post("/employees");

		// to print on console

		response.prettyPrint();

		// to log request in extent report

		ExtentLogger.logRequest(requestSpecification);

		// to log response in extent report

		ExtentLogger.logResponse(response);

		FileReadWriteUtils.storeResponseAsJSONFile(method.getName() + ".json", response);

		Assertions.assertThat(response.getStatusCode()).isEqualTo(201);

	}

	@FrameworkAnnotation(category = { Category.REGRESSION, Category.SMOKE })
	@Test(enabled = true, dataProvider = "getData", dataProviderClass = com.jesusnut.utils.DataProviderUtils.class,
	description = "to create multiple complex employees (with POJO named 'ComplexEmployee.java') in the database driven from excel sheet data.")

	// create multiple complex employee using POJO + data providers

	public void createComplexEmployeesPOJO_DP(Map<String, String> data) {

		// creating payload - FavFood part

		String[] dinner = data.get("dinner").split(",");

		List<String> dinnerList = new ArrayList<String>();

		for (String temp : dinner) {

			dinnerList.add(temp);

		}

		FavfoodForComplexEmployee favFood = new FavfoodForComplexEmployee(data.get("breakfast"), data.get("lunch"),
				dinnerList);

		MarksForComplexEmployee marks1 = new MarksForComplexEmployee(Integer.parseInt(data.get("tamil_marks1")),
				Integer.parseInt(data.get("english_marks1")));

		MarksForComplexEmployee marks2 = new MarksForComplexEmployee(Integer.parseInt(data.get("tamil_marks2")),
				Integer.parseInt(data.get("english_marks2")));

		List<MarksForComplexEmployee> empMarks = new ArrayList<>();

		empMarks.add(marks1);
		empMarks.add(marks2);

		String[] job = data.get("job").split(",");

		List<String> jobList = new ArrayList<String>();

		for (String temp : job) {

			jobList.add(temp);
		}

		ComplexEmployee complexEmployee = new ComplexEmployee(Integer.parseInt(data.get("id")), data.get("first_name"),
				data.get("last_name"), data.get("email"), jobList, empMarks, favFood);

		RequestSpecification requestSpecification = RequestBuilder.buildRequestForPostCalls().body(complexEmployee);
		
		Response response = requestSpecification.post("/employees");
		
		// to print on console

		response.prettyPrint();
		
		// to log request on the console
		
		ExtentLogger.logRequest(requestSpecification);
		
		// to log response on the console
		
		ExtentLogger.logResponse(response);
		
		//assertions
		
		Assertions.assertThat(response.getStatusCode()).isEqualTo(Integer.parseInt(data.get("statusCode")));
		

	}
	
	@FrameworkAnnotation(category = { Category.REGRESSION, Category.SMOKE })
	@Test(enabled = true, dataProvider = "getData", dataProviderClass = com.jesusnut.utils.DataProviderUtils.class
	,description = "to create multiple simple employees (with POJO named 'Employee.java') in the database driven from excel sheet data.")

	// create an employee in DB using POJO (Pojo is with builder)

	public void createSimpleEmployees_POJO_DP(Map<String, String> data) {

		Employee payload = Employee.builder().setFirst_name(data.get("first_name"))
				.setLast_name(data.get("last_name")).setId(Integer.parseInt( data.get("id")))
				.setEmail(data.get("email")).build();

		RequestSpecification requestSpecification = RequestBuilder.buildRequestForPostCalls().body(payload);

		Response response = requestSpecification.post("/employees");

		// to print on console

		response.prettyPrint();

		// to log request in extent report

		ExtentLogger.logRequest(requestSpecification);

		// to log response in extent report

		ExtentLogger.logResponse(response);

		Assertions.assertThat(response.getStatusCode()).isEqualTo(Integer.parseInt(data.get("statusCode")));

	}

}
