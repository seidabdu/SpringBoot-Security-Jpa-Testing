package com.ally.exercise.springbootserurityjpatesting.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse implements Serializable {

	@Builder.Default
	private Integer status = 200;

	@Builder.Default
	private boolean isError = false;

}