package com.abbhasin.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class InfixExpressionEvaluator {

	private final List<Character> chars;
	private final Stack<Integer> stackOfOperands = new Stack<Integer>();
	private final Stack<Character> stackOfOperators = new Stack<Character>();
	List<Character> postfix = new ArrayList<>();
	private static final Map<Character, Integer> operatorPrecedence = new HashMap<>();
	static {
		operatorPrecedence.put('+', 1);
		operatorPrecedence.put('-', 1);
		operatorPrecedence.put('*', 2);
		operatorPrecedence.put('/', 2);
		operatorPrecedence.put('%', 2);
	}

	public InfixExpressionEvaluator(List<Character> chars) {
		this.chars = chars;
	}

	public int getValue() {
		for (Character c : chars) {
			System.out.println("zzzzzz start operands: " + stackOfOperands);
			System.out.println("zzzzzz start  opertors: " + stackOfOperators);
			if (isOperator(c)) {
				if (stackOfOperators.isEmpty()) {
					stackOfOperators.push(c);
					continue;
				}
				if (checkPrecedence(stackOfOperators.peek(), c) >= 0) {
					while (!stackOfOperators.isEmpty() && checkPrecedence(stackOfOperators.peek(), c) >= 0) {
						Character operator = stackOfOperators.pop();
						postfix.add(operator);
						Integer firstOperand = stackOfOperands.pop();
						Integer secondOperand = stackOfOperands.pop();
						stackOfOperands.push(applyExpression(operator, secondOperand, firstOperand));						
					}
					stackOfOperators.push(c);
				} else {
					stackOfOperators.push(c);					
				}

			} else {
				stackOfOperands.push(c - '0');
				postfix.add(c);
			}
		}
		System.out.println("zzzzzz operands: " + stackOfOperands);
		System.out.println("zzzzzz opertors: " + stackOfOperators);
		while (!stackOfOperators.isEmpty()) {
			Character operator = stackOfOperators.pop();
			postfix.add(operator);
			Integer firstOperand = stackOfOperands.pop();
			Integer secondOperand = stackOfOperands.pop();
			stackOfOperands.push(applyExpression(operator, secondOperand, firstOperand));
		}
		System.out.println("zzzzzz  2 operands: " + stackOfOperands);
		System.out.println("zzzzzz  postfix: " + postfix);
		
		return stackOfOperands.pop();

	}
	
	public List<Character> getPostFixExpression(){
		getValue();
		return postfix;
	}

	private int applyExpression(Character operator, int c1, int c2) {
		switch (operator) {
		case '+':
			return c1 + c2;
		case '*':
			return c1 * c2;
		case '/':
			return c1 / c2;
		case '-':
			return c1 - c2;
		}
		throw new RuntimeException("unable to find operator");
	}

	private boolean isOperator(Character c) {
		return operatorPrecedence.keySet().contains(c);
	}

	private int checkPrecedence(Character c1, Character c2) {
		return operatorPrecedence.get(c1) - operatorPrecedence.get(c2);
	}

}
