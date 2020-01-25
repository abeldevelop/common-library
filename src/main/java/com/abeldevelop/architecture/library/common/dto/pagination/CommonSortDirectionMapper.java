package com.abeldevelop.architecture.library.common.dto.pagination;

import com.abeldevelop.architecture.library.common.domain.pagination.in.SortIn;


public interface CommonSortDirectionMapper<T> {

	public SortIn map(T enumSort);

}