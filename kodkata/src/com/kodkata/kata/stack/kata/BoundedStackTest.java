package com.kodkata.kata.stack.kata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BoundedStackTest {

	// EOF (End Of Fun)
	// Özcan Acar

	private Stack stack = StackFactory.make(2);

	@Test
	public void new_stack_is_empty() throws Exception {
		assertTrue(stack.isEmpty());
	}

	@Test
	public void after_one_push_stack_size_should_be_one() throws Exception {
		push(1);
		assertEquals(1, stack.getSize());
	}

	@Test
	public void after_one_push_and_one_pop_stack_size_should_be_zero()
			throws Exception {
		push(1);
		pop();
		assertTrue(stack.isEmpty());
	}

	@Test(expected = BoundedStack.Overflow.class)
	public void when_pushed_past_limit_stack_overflows() throws Exception {
		Stack stack = StackFactory.make(1);
		stack.push(1);
		stack.push(2);
	}

	@Test(expected = BoundedStack.Underflow.class)
	public void when_empty_stack_popped_stack_underflows() throws Exception {
		pop();
	}

	@Test
	public void when_one_is_pushed_one_is_popped() throws Exception {
		push(1);
		assertEquals(1, pop());
	}

	@Test
	public void when_one_and_two_are_pushed_two_and_one_are_popped()
			throws Exception {

		push(1);
		push(2);
		assertEquals(2, pop());
		assertEquals(1, pop());
	}

	private int pop() {
		return stack.pop();
	}

	@Test(expected = BoundedStack.IllegalCapacity.class)
	public void when_creating_stack_with_negativ_size_stack_should_throw_illegal_capacity()
			throws Exception {
		StackFactory.make(-1);
	}

	@Test(expected = BoundedStack.Overflow.class)
	public void when_stack_created_with_zero_capacity_any_push_should_overlow()
			throws Exception {
		StackFactory.make(0).push(1);
	}

	@Test
	public void when_one_is_pushed_one_is_on_top() throws Exception {
		push(1);
		assertEquals(1, stack.top());

	}

	@Test(expected = Stack.Empty.class)
	public void when_stack_is_empty_top_throws_empty() throws Exception {
		stack.top();

	}

	private void push(int element) {
		stack.push(element);
	}

	@Test(expected = Stack.Empty.class)
	public void when_zero_capacity_stack_top_throws_empty() throws Exception {
		StackFactory.make(0).top();
	}

	@Test
	public void given_stack_with_one_and_two_pushed_find_one() throws Exception {
		push(1);
		push(2);
		assertEquals(1, stack.find(1).intValue());
		assertEquals(0, stack.find(2).intValue());
	}

	@Test
	public void given_stack_with_no_two_find_two_should_return_null()
			throws Exception {
		assertEquals(null, stack.find(2));

	}

}
