package com.crud.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

//<T> represents a class object of specific class type 'T'.


public class APIResponse<T> {
	
	int recordCount;
	T response;
}
