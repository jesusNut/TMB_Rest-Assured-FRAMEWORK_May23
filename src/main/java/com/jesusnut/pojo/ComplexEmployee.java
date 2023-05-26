package com.jesusnut.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@JsonInclude(value = Include.NON_DEFAULT)
@JsonPropertyOrder(value = {"id","first_name","last_name","email","job","marks","favfood"})
@AllArgsConstructor

public class ComplexEmployee {

	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private List<String> job;
	private List<MarksForComplexEmployee> marks;
	private FavfoodForComplexEmployee favfood;

}
