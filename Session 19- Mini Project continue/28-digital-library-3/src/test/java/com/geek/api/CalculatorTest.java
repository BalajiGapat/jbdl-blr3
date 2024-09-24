package com.geek.api;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
class CalculatorTest {
	private static Calculator c;
	@BeforeEach
	public void init() {
		System.out.println("init");
	//	c=new Calculator();
	}
	@BeforeAll
	public static void beforeAll() {
		System.out.println("Before All");
		c= new Calculator();
	}
	@Test
	@DisplayName("Testing ADD")
	public void testAdd() {
		assertEquals(10, c.add(5, 5));
	}
	@Test
	@DisplayName("Testing DIFF")
	public void testDiff() {
		assertEquals(5, c.diff(10, 5));
	}
	@ParameterizedTest
	@CsvSource({"5,5,10","4,5,9","7,7,14","10,6,16","8,8,16"})
	public void testWithCSV(int x,int y, int result) {
		assertEquals(result, c.add(x, y));
	}
	@ParameterizedTest
	@CsvFileSource(files = "test.csv",numLinesToSkip = 1)
	public void testWithCSVFile(int x,int y, int result) {
		assertEquals(result, c.add(x, y));
	}
	@Test
	public void testDivSuccess() {
		assertEquals(10, c.div(20, 2));
	}
	@Test
	public void testDivFailure() {
		Exception e=
		assertThrows(RuntimeException.class,
				()->c.div(10,0));
		assertEquals("Cant divide by Zero", e.getMessage());
	}
}
