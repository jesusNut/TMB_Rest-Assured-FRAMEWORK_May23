package com.jesusnut.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FavfoodForComplexEmployee {
	
	private String breakfast;
    private String lunch;
    private List<String> dinner;

}
