package com.te.springbootmockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ListTest {

	private List<String> mock = mock(List.class);

	@Test
	public void list_basicTest() {
		when(mock.get(0)).thenReturn("Hi");
		assertEquals("Hi", mock.get(0));
	}
	
	@Test
	public void list_onAnyIndex() {
		
	when(mock.get(anyInt())).thenReturn("Hi");
	assertEquals("Hi", mock.get(10));
	}
	
	@Test
	public void list_multipleReturn() {
		when(mock.size()).thenReturn(0).thenReturn(10);
		assertEquals(0,mock.size());
		assertEquals(10,mock.size());
		assertEquals(10,mock.size());
	}
	
	@Test
	public void list_timesCalled() {
		String val = mock.get(0);
		
		verify(mock, times(1)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atMostOnce()).get(anyInt());
		verify(mock, atMost(1)).get(anyInt());
	}
	
	@Test
	public void list_neverCall() {
		
		verify(mock,never()).get(anyInt());
	}
}