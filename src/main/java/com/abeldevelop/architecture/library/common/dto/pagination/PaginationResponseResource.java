package com.abeldevelop.architecture.library.common.dto.pagination;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description = "Resource with pagination information")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PaginationResponseResource {

	@ApiModelProperty(notes = "Number of the page", example = "1", required = true, position = 0)
	@NotNull
	private Integer page;

	@ApiModelProperty(notes = "Number of records per page", example = "10", required = true, position = 1)
	@NotNull
	private Integer size;

	@ApiModelProperty(notes = "Number of records returned", example = "20", required = true, position = 2)
	@NotNull
	private Integer numberOfElements;

	@ApiModelProperty(notes = "Total of pages", example = "5", required = true, position = 3)
	@NotNull
	private Integer totalPages;

	@ApiModelProperty(notes = "Total of elements", example = "100", required = true, position = 4)
	@NotNull
	private Long totalElements;

	@ApiModelProperty(notes = "Indicate if is the first page", example = "true", required = true, position = 5)
	@JsonProperty("isFirst")
	@NotNull
	private Boolean first;

	@ApiModelProperty(notes = "Indicate if is the last page", example = "false", required = true, position = 6)
	@JsonProperty("isLast")
	@NotNull
	private Boolean last;

}