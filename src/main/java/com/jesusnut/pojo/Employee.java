package com.jesusnut.pojo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "set")
public class Employee {
	
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	

}
