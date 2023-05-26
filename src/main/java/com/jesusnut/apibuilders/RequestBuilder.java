package com.jesusnut.apibuilders;

import static io.restassured.RestAssured.given;

import com.jesusnut.config.ConfigFactory;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RequestBuilder {

	public static RequestSpecification buildRequestForGetCalls() {

		return given().log().all().baseUri(ConfigFactory.getBaseURL());

	}

	public static RequestSpecification buildRequestForPostCalls() {

		return given().log().all().baseUri(ConfigFactory.getBaseURL()).contentType(ContentType.JSON);

	}
	
	public static RequestSpecification buildRequestForDeleteCalls() {

		return given().log().all().baseUri(ConfigFactory.getBaseURL());

	}

}
