package com.abeldevelop.architecture.library.common.mapper.pagination;

import org.springframework.data.domain.Sort;

import com.abeldevelop.architecture.library.common.domain.pagination.in.SortDirection;
import com.abeldevelop.architecture.library.common.domain.pagination.in.SortIn;

public interface SortMapper<T> {

	public SortIn map(T enumSort);
	
	public default Sort map(SortIn sortIn) {
        if(sortIn.getDirection().getType().equals(SortDirection.ASC.getType())) {
            return Sort.by(sortIn.getColumn()).ascending();
        } else {
            return Sort.by(sortIn.getColumn()).descending();
        }
    }
}
