package com.kodkata.kata.stack.done;

public interface Stack {

	public abstract boolean isEmpty();

	public abstract int getSize();

	public abstract void push(int i);

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