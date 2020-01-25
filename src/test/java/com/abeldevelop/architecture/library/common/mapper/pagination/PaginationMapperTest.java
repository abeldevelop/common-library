package com.abeldevelop.architecture.library.common.mapper.pagination;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.abeldevelop.architecture.library.common.domain.pagination.in.PaginationIn;
import com.abeldevelop.architecture.library.common.domain.pagination.out.PaginationOut;
import com.abeldevelop.architecture.library.common.dto.pagination.PaginationResponseResource;
import com.abeldevelop.architecture.library.common.exception.client.BadRequestException;

public class PaginationMapperTest {

	private PaginationMapper paginationMapper;
	
	@BeforeEach
	public void setUp() {
		paginationMapper = new PaginationMapper();
	}
	
	@Test
	public void test_mapToPaginationIn_ok() {
		
		PaginationIn expected = PaginationIn.builder().page(0).size(1).build();
				
		PaginationIn actual = paginationMapper.map(1, 1);
		
		assertEquals(expected, actual);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_mapToPaginationIn_pageIsNull() {
		
		PaginationIn expected = PaginationIn.builder().page(0).size(1).build();
				
		PaginationIn actual = paginationMapper.map(null, 1);
		
		assertEquals(expected, actual);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_mapToPaginationIn_pageIsNotValid() {
		assertThrows(BadRequestException.class, () -> paginationMapper.map(0, 1));
	}
	
	@Test
	public void test_mapToPaginationIn_sizeIsNull() {
		
		PaginationIn expected = PaginationIn.builder().page(0).size(10).build();
				
		PaginationIn actual = paginationMapper.map(1, null);
		
		assertEquals(expected, actual);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_mapToPaginationIn_sizeIsNotValid() {
		assertThrows(BadRequestException.class, () -> paginationMapper.map(1, 0));
	}
	
	@Test
	public void test_mapToPaginationOut_ok() {
		
		PaginationOut paginationOut = PaginationOut.builder()
				.page(0)
				.size(10)
				.numberOfElements(3)
				.totalElements(10)
				.build();
		
		PaginationResponseResource expected = PaginationResponseResource.builder()
				.page(1)
				.size(10)
				.numberOfElements(3)
				.totalPages(1)
				.totalElements(10L)
				.first(true)
				.last(true)
			.build();;
				
		PaginationResponseResource actual = paginationMapper.map(paginationOut);
		
		assertEquals(expected.getPage(), actual.getPage());
		assertEquals(expected.getSize(), actual.getSize());
		assertEquals(expected.getNumberOfElements(), actual.getNumberOfElements());
		assertEquals(expected.getTotalPages(), actual.getTotalPages());
		assertEquals(expected.getTotalElements(), actual.getTotalElements());
		assertEquals(expected.getFirst(), actual.getFirst());
		assertEquals(expected.getLast(), actual.getLast());
	}
	
	@Test
	public void test02_mapToPaginationOut_ok() {
		
		PaginationOut paginationOut = PaginationOut.builder()
				.page(1)
				.size(10)
				.numberOfElements(10)
				.totalElements(30)
				.build();
		
		PaginationResponseResource expected = PaginationResponseResource.builder()
				.page(2)
				.size(10)
				.numberOfElements(10)
				.totalPages(3)
				.totalElements(30L)
				.first(false)
				.last(false)
			.build();;
				
		PaginationResponseResource actual = paginationMapper.map(paginationOut);
		
		assertEquals(expected.getPage(), actual.getPage());
		assertEquals(expected.getSize(), actual.getSize());
		assertEquals(expected.getNumberOfElements(), actual.getNumberOfElements());
		assertEquals(expected.getTotalPages(), actual.getTotalPages());
		assertEquals(expected.getTotalElements(), actual.getTotalElements());
		assertEquals(expected.getFirst(), actual.getFirst());
		assertEquals(expected.getLast(), actual.getLast());
	}
	
	@Test
	public void test_mapPageToPaginationOut_ok() {
		
		PaginationOut expected = PaginationOut.builder().page(0).size(10).numberOfElements(0).totalElements(3).build();
		Page<String> page = new PageImpl<String>(new ArrayList<>(), PageRequest.of(0, 10), 3);
		PaginationOut actual = paginationMapper.mapPageToPaginationOut(page);
		
		assertEquals(expected, actual);
	}
}
