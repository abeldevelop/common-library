package com.abeldevelop.architecture.library.common.validation;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.common.constant.ErrorPaginationCodeMessageConstants;
import com.abeldevelop.architecture.library.common.dto.pagination.PaginationResponseResource;
import com.abeldevelop.architecture.library.common.exception.server.ValidationResponseException;
import com.abeldevelop.architecture.library.common.factory.validation.ValidationResource;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PaginationResponseResourceValidation implements ValidationResource {


	@Override
	public boolean areYouTheElement(String elementName) {
		return PaginationResponseResource.class.getCanonicalName().equals(elementName);
	}

	@Override
	public void validate(Object toValidate) {
		if (toValidate == null) {
			throw new ValidationResponseException(ErrorPaginationCodeMessageConstants.PAGINATION_RESPONSE_RESOURCE_NOT_NULL);
		}
		PaginationResponseResource paginationResponseResource = (PaginationResponseResource) toValidate;
		validatePage(paginationResponseResource);
		validateSize(paginationResponseResource);
		validateNumberOfElements(paginationResponseResource);
		validateTotalPages(paginationResponseResource);
		validateTotalElements(paginationResponseResource);
		validateFirst(paginationResponseResource);
		validateLast(paginationResponseResource);
	}

	private void validatePage(PaginationResponseResource paginationResponseResource) {
		if (paginationResponseResource.getPage() == null) {
			throw new ValidationResponseException(ErrorPaginationCodeMessageConstants.PAGINATION_PAGE_NOT_NULL);
		}
	}

	private void validateSize(PaginationResponseResource paginationResponseResource) {
		if (paginationResponseResource.getSize() == null) {
			throw new ValidationResponseException(ErrorPaginationCodeMessageConstants.PAGINATION_SIZE_NOT_NULL);
		}
	}

	private void validateNumberOfElements(PaginationResponseResource paginationResponseResource) {
		if (paginationResponseResource.getNumberOfElements() == null) {
			throw new ValidationResponseException(ErrorPaginationCodeMessageConstants.PAGINATION_NUMBER_OF_ELEMENTS_NOT_NULL);
		}
	}

	private void validateTotalPages(PaginationResponseResource paginationResponseResource) {
		if (paginationResponseResource.getTotalPages() == null) {
			throw new ValidationResponseException(ErrorPaginationCodeMessageConstants.PAGINATION_TOTAL_PAGES_NOT_NULL);
		}
	}

	private void validateTotalElements(PaginationResponseResource paginationResponseResource) {
		if (paginationResponseResource.getTotalElements() == null) {
			throw new ValidationResponseException(ErrorPaginationCodeMessageConstants.PAGINATION_TOTAL_ELEMENTS_NOT_NULL);
		}
	}

	private void validateFirst(PaginationResponseResource paginationResponseResource) {
		if (paginationResponseResource.getFirst() == null) {
			throw new ValidationResponseException(ErrorPaginationCodeMessageConstants.PAGINATION_FIRST_NOT_NULL);
		}
	}

	private void validateLast(PaginationResponseResource paginationResponseResource) {
		if (paginationResponseResource.getLast() == null) {
			throw new ValidationResponseException(ErrorPaginationCodeMessageConstants.PAGINATION_LAST_NOT_NULL);
		}
	}
}