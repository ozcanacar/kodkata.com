package com.kodkata.kata.stack.kata;

public class BoundedStack implements Stack {

	private boolean empty = true;
	private int size;
	private int capacity;
	private int elements[];

	protected BoundedStack(int capacity) {
		if (capacity < 0)
			throw new IllegalCapacity();
		this.capacity = capacity;
		this.elements = new int[capacity];
	}

	@Override
	public boolean isEmpty() {
		return empty;
	}

	@Override
	public void push(int element) {
		if (size == capacity)
			throw new Overflow();
		this.elements[size++] = element;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public int pop() {
		if (empty())
			throw new Underflow();
		return elements[--size];

	}

	private boolean empty() {
		return size == 0;
	}

	@Override
	public int top() {
		if (empty())
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
