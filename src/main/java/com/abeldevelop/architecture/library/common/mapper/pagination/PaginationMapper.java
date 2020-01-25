package com.abeldevelop.architecture.library.common.mapper.pagination;

import java.util.Arrays;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.common.config.property.ErrorCodeArchitectureProperties;
import com.abeldevelop.architecture.library.common.domain.pagination.in.PaginationIn;
import com.abeldevelop.architecture.library.common.domain.pagination.out.PaginationOut;
import com.abeldevelop.architecture.library.common.dto.pagination.PaginationResponseResource;
import com.abeldevelop.architecture.library.common.exception.client.BadRequestException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PaginationMapper {

	private static final Integer DEFAULT_PAGE_NUMBER = 0;
	private static final Integer DEFAULT_PAGE_SIZE = 10;
	private static final Integer MIN_PAGE = 1;
	private static final Integer MIN_PAGE_SIZE = 1;
	private static final Integer ADD_NUMBER_TO_PAGE = 1;
	private static final Integer SUBTRACT_NUMBER_TO_PAGE = 1;

	private final ErrorCodeArchitectureProperties errorCodeArchitectureProperties;

	public PaginationIn map(Integer page, Integer size) {
		return PaginationIn.builder().page(validatePageIn(page)).size(validateSizeIn(size)).build();
	}

	public PaginationResponseResource map(PaginationOut paginationResponse) {
		return PaginationResponseResource.builder()
				.page(paginationResponse.getPage() + ADD_NUMBER_TO_PAGE)
				.size(paginationResponse.getSize())
				.numberOfElements(paginationResponse.getNumberOfElements())
				.totalPages(calculateTotalPages(paginationResponse.getTotalElements(), paginationResponse.getSize()))
				.totalElements(paginationResponse.getTotalElements())
				.first(calculateIsFirstPage(paginationResponse.getPage() + ADD_NUMBER_TO_PAGE))
				.last(calculateIsLastPage(paginationResponse.getTotalElements(), paginationResponse.getSize(), paginationResponse.getPage() + ADD_NUMBER_TO_PAGE))
				.build();
	}

	public PaginationOut mapPageToPaginationOut(@SuppressWarnings("rawtypes") Page page) {
		return PaginationOut.builder()
				.page(page.getNumber())
				.size(page.getSize())
				.numberOfElements(page.getNumberOfElements())
				.totalElements(page.getTotalElements())
				.build();
	}

	private Integer validatePageIn(Integer page) {
		if (page == null) {
			return DEFAULT_PAGE_NUMBER;
		} else if (page.intValue() < MIN_PAGE) {
			throw new BadRequestException(errorCodeArchitectureProperties.getPaginationMinPageError(), Arrays.asList(MIN_PAGE));
		} else {
			return page - SUBTRACT_NUMBER_TO_PAGE;
		}
	}

	private Integer validateSizeIn(Integer size) {
		if (size == null) {
			return DEFAULT_PAGE_SIZE;
		} else if (size.intValue() < MIN_PAGE_SIZE) {
			throw new BadRequestException(errorCodeArchitectureProperties.getPaginationMinSizeError(), Arrays.asList(MIN_PAGE_SIZE));
		} else {
			return size;
		}
	}

	private int calculateTotalPages(long totalElements, int size) {
		return (int) Math.ceil((double) totalElements / (double) size);
	}

	private boolean calculateIsFirstPage(int page) {
		return MIN_PAGE == page;
	}

	private boolean calculateIsLastPage(long totalElements, int size, int page) {
		return (calculateTotalPages(totalElements, size) == page);
	}
}