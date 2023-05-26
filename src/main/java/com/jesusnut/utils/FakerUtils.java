package com.jesusnut.utils;

import com.github.javafaker.Faker;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PRIVATE)
public final class FakerUtils {

	// implementing Faker Utils via singleton + Facade (RandomUtils)

	private static Faker FAKER = null;

	static synchronized Faker getFakerInstance() {

		if (FAKER == null) {

			FAKER = new Faker();
		}

		return FAKER;

	}

	static int getFakeID(int startValue, int endValue) {

		return getFakerInstance().number().numberBetween(startValue, endValue);
	}

	static String getFakeFirstName() {

		return getFakerInstance().name().firstName();

	}

	static String getFakeLastName() {

		return getFakerInstance().name().firstName();

	}

	static String getFakeEmail() {

		return getFakerInstance().internet().emailAddress();

	}

}
