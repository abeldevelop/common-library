package com.abeldevelop.architecture.library.common.domain.pagination.in;

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
public class PaginationAndSortIn {

	private PaginationIn pagination;
	private SortIn sort;

}