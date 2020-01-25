package com.abeldevelop.architecture.library.common.domain.pagination.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class PaginationOut {

	private int page;
	private int size;
	private int numberOfElements;
	private long totalElements;

}