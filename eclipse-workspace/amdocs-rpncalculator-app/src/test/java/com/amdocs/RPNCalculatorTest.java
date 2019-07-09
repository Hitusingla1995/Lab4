package com.amdocs;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RPNCalculatorTest {
	
	RPNCalculator rpnCalculator = new RPNCalculator();

	@Test
	public void testSimpleAddition() {

		

		double actualResult = rpnCalculator.calculate("10 12 +");
		double expectedResult = 22.0;

		assertEquals(expectedResult, actualResult, 0.0001);

		actualResult = rpnCalculator.calculate("100 12 +");
		expectedResult = 112.0;

		assertEquals(expectedResult, actualResult, 0.0001);

	}
	
	@Test
	public void testSimpleSubtraction() {

		

		double actualResult = rpnCalculator.calculate("10 12 -");
		double expectedResult = -2.0;

		assertEquals(expectedResult, actualResult, 0.0001);

		actualResult = rpnCalculator.calculate("100 12 -");
		expectedResult = 88.0;

		assertEquals(expectedResult, actualResult, 0.0001);

	}
	
	@Test
	public void testSimpleMultiply() {

		

		double actualResult = rpnCalculator.calculate("10 12 *");
		double expectedResult = 120.0;

		assertEquals(expectedResult, actualResult, 0.0001);

		actualResult = rpnCalculator.calculate("100 12 *");
		expectedResult = 1200.0;

		assertEquals(expectedResult, actualResult, 0.0001);

	}
	
	
	@Test
	public void testSimpleDivision() {

		

		double actualResult = rpnCalculator.calculate("100 5 /");
		double expectedResult = 20.0;

		assertEquals(expectedResult, actualResult, 0.0001);

	}
	
	@Test 
	public void testComplexExpression() {
		

		double actualResult = rpnCalculator.calculate("10 2 + 100 5 / *");
		double expectedResult = 240.0;

		assertEquals(expectedResult, actualResult, 0.0001);
	}
	
	

}
