package com.kodkata.kata.stack.done;

public class ZeroCapacityStack implements Stack {

	@Override
	public void push(int i) {
		throw new Overflow();

	}

	@Override
	public int pop() {
		throw new Underflow();
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public int top() {
		throw new Empty();
	}

	@Override
	public Integer find(int i) {
		return null;
	}

}
