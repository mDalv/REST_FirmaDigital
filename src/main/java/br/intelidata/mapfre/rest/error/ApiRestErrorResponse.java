package br.intelidata.mapfre.rest.error;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiRestErrorResponse {
	private int status;
	private String message;
	private String details;
	private Long timestamp;
	private List<String> errors;
}
