package com.geek.test;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.geek.Calculator;

public class CalculatorTest {
	@Test
	public void testAdd() {
		Calculator c= new Calculator();
		int expected=25;
		assertEquals(expected, c.add(20,5));
	}
}
