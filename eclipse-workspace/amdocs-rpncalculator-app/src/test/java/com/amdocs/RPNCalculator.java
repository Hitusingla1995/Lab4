package com.amdocs;

import java.lang.invoke.MethodHandleProxies;
import java.util.Stack;

public class RPNCalculator {

	private Stack<Double>numberStack;
	private double firstNumber, secondNumber, result;
	
	public RPNCalculator() {
		numberStack = new Stack<Double>();
		firstNumber = secondNumber = result = 0.0;
	}
	
	
	
	public double calculate(String rpnMathExpression) {
		
		String[] rpnTokens= rpnMathExpression.split(" ");
		
		IMathOperation mathOperation= null;
		
		for(String token : rpnTokens) {
			
			if(isMathOperator(token)) {
				mathOperation = MathFactory.getObject(token);
				extractInputs();
				result = mathOperation.calculate(firstNumber,secondNumber);
				numberStack.push(result);
			}  
			
			else {
				numberStack.push(Double.parseDouble(token));
			}
				
		}
		return numberStack.pop();
	}

	private void extractInputs() {
		
		secondNumber = numberStack.pop();
		firstNumber = numberStack.pop();
		
		
	}



	private boolean isMathOperator(String mathBinaryOperator) {
		
		String mathOperators="+-*/";
		
		return mathOperators.contains(mathBinaryOperator);
	}

	private void divide() {
		extractInputs();
		result= firstNumber / secondNumber;
		
		numberStack.push(result);
	}

	private void multiply() {
		extractInputs();
		secondNumber = numberStack.pop();
		firstNumber = numberStack.pop();
		result= firstNumber * secondNumber;
		
		numberStack.push(result);
	}

	private void subtract() {
		extractInputs();
		secondNumber = numberStack.pop();
		firstNumber = numberStack.pop();
		result= firstNumber - secondNumber;
		
		numberStack.push(result);
	}

	private void add() {
		extractInputs();
		secondNumber = numberStack.pop();
		firstNumber = numberStack.pop();
		result= firstNumber +secondNumber;
		
		numberStack.push(result);
	}

	
	
}
