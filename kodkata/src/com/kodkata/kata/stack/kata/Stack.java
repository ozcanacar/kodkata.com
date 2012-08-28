package com.kodkata.kata.stack.kata;

public interface Stack {

	public abstract boolean isEmpty();

	public abstract void push(int element);

	public abstract int getSize();

	public abstract int pop();

	public abstract int top();

	public abstract Integer find(int i);

	public static class Overflow extends RuntimeException {

	}

	public static class Underflow extends RuntimeException {

	}

	public static class IllegalCapacity extends RuntimeException {

	}

	public static class Empty extends RuntimeException {

	}

}