package com.jesusnut.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RandomDataUtils {

	public static int getFakeID() {

		return FakerUtils.getFakeID(10, 10000);

	}

	public static String getFakeFirstName() {

		return FakerUtils.getFakeFirstName();

	}

	public static String getFakeLastName() {

		return FakerUtils.getFakeLastName();

	}

	public static String getFakeEmail() {

		return FakerUtils.getFakeEmail();

	}

}
