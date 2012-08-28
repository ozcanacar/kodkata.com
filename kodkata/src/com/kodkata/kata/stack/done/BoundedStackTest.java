package com.kodkata.kata.stack.done;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BoundedStackTest {

	private Stack stack = BoundedStack.makeWithCapacity(2);
	@Test
	public void new_stack_is_empty() throws Exception {

		assertTrue(stack.isEmpty());
		assertEquals(0, stack.getSize());

	}
	@Test
	public void after_one_push_stack_size_should_be_one() throws Exception {

		stack.push(1);
		assertEquals(1, stack.getSize());
		assertFalse(stack.isEmpty());
	}
	@Test
	public void after_one_pop_and_one_push_stack_size_should_be_zero()
			throws Exception {

		stack.push(1);
		stack.pop();
		assertEquals(0, stack.getSize());
		assertTrue(stack.isEmpty());
	}

	@Test(expected = BoundedStack.Overflow.class)
	public void when_pushed_past_limit_stack_overflows() throws Exception {
		stack.push(1);
		stack.push(1);
		stack.push(1);

	}

	@Test(expected = BoundedStack.Underflow.class)
	public void when_empty_stack_popped_stack_underflows() throws Exception {
		stack.pop();
	}

	@Test
	public void when_one_is_pushed_one_is_popped() throws Exception {
		stack.push(1);
		assertEquals(1, stack.pop());
	}
	@Test
	public void when_one_and_two_are_pushed_two_and_one_are_popped()
			throws Exception {
		stack.push(1);
		stack.push(2);
		assertEquals(2, stack.pop());
		assertEquals(1, stack.pop());
	}

	@Test(expected = Stack.IllegalCapacity.class)
	public void when_creating_stack_with_negativ_size_stack_should_throw_illegal_capacity()
			throws Exception {
		BoundedStack.makeWithCapacity(-1);
	}

	@Test(expected = Stack.Overflow.class)
	public void when_stack_created_with_zero_capacity_any_push_should_overlow()
			throws Exception {
		Stack stack = BoundedStack.makeWithCapacity(0);
		stack.push(1);
	}

	@Test
	public void when_one_is_pushed_one_is_on_top() throws Exception {
		stack.push(1);
		assertEquals(1, stack.top());
	}

	@Test(expected = Stack.Empty.class)
	public void when_stack_is_empty_top_throws_empty() throws Exception {
		stack.top();
	}

	@Test(expected = Stack.Empty.class)
	public void when_zero_capacity_stack_top_throws_empty() throws Exception {
		Stack stack = BoundedStack.makeWithCapacity(0);
		stack.top();
	}

	@Test
	public void given_stack_with_one_and_two_pushed_find_one() throws Exception {
		stack.push(1);
		stack.push(2);
		assertEquals(1, stack.find(1).intValue());
		assertEquals(0, stack.find(2).intValue());
	}

	@Test
	public void given_stack_with_number_two_find_two_should_return_null()
			throws Exception {
		assertNull(stack.find(2));
	}

}
