package com.abeldevelop.architecture.library.common.domain.pagination.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@AllArgsConstructor(staticName = "of")
@Getter
@EqualsAndHashCode
@ToString
public class SortIn {

	private SortDirection direction;
	private String column;

}