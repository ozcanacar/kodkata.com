package com.kodkata.kata.stack.done;

public class BoundedStack implements Stack {

	int size = 0;
	int capacity = 0;
	private int elements[];

	public static Stack makeWithCapacity(int i) {
		if (i < 0)
			throw new IllegalCapacity();

		if (i == 0)
			return new ZeroCapacityStack();

		return new BoundedStack(i);
	}
	private BoundedStack(int i) {
		this.capacity = i;
		elements = new int[this.capacity];
	}

	@Override
	public boolean isEmpty() {
		return empty();
	}
	private boolean empty() {
		return size == 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void push(int i) {
		if (size == capacity)
			throw new Overflow();;
		this.elements[size++] = i;

	}

	@Override
	public int pop() {
		if (empty())
			throw new Underflow();
		return elements[--size];

	}

	@Override
	public int top() {
		if (isEmpty())
			throw new Empty();
		return elements[size - 1];
	}
	@Override
	public Integer find(int element) {
		for (int i = size - 1; i >= 0; i--)
			if (elements[i] == element)
				return (size - 1) - i;
		return null;

	}
}
