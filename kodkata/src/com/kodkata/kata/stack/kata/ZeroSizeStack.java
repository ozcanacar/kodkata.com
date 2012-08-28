package com.kodkata.kata.stack.kata;

public class ZeroSizeStack implements Stack {

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public void push(int element) {
		throw new Overflow();

	}
	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public int pop() {
		throw new Underflow();
	}

	@Override
	public int top() {
		throw new Stack.Empty();
	}

	@Override
	public Integer find(int i) {
		return null;
	}
}
