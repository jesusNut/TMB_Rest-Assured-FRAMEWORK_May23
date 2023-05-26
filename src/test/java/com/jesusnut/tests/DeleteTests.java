package com.jesusnut.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.jesusnut.annotations.FrameworkAnnotation;
import com.jesusnut.apibuilders.RequestBuilder;
import com.jesusnut.enums.Category;

import io.restassured.response.Response;

public class DeleteTests {

	
	@FrameworkAnnotation(category = { Category.REGRESSION })
	@Test

	public void deleteAnEmployee() {
		
		for(int i = 73; i<75; i++) {
			

		Response response = RequestBuilder.buildRequestForDeleteCalls().pathParam("id", i).delete("/employees/{id}");
		
		response.prettyPrint();

		Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
		
		}
		
		
		
	}

}
