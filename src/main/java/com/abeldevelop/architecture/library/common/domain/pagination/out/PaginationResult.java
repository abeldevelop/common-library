package com.abeldevelop.architecture.library.common.domain.pagination.out;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor(staticName = "of")
@Getter
@ToString
public class PaginationResult<T> {

	private PaginationOut pagination;
	private List<T> results;

}