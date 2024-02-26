import java.util.ArrayList;
/**
 * This class contains the test case methods that students must implement
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyStackTest_STUDENT {
	private MyStack<Integer> stack;
	@BeforeEach
	void setUp() throws Exception {
		stack = new MyStack<>(5);
	}

	@AfterEach
	void tearDown() throws Exception {
		stack = null;
	}

	@Test
	void testIsEmpty() {
		assertTrue(stack.isEmpty());
	}

	@Test
	void testIsFull() {
		assertFalse(stack.isFull());
	}

	@Test
	void testPop() {
		stack.push(1);
        stack.push(2);
        assertEquals(2, (int) stack.pop());
        assertEquals(1, (int) stack.pop());
	}

	@Test
	void testTop() {
		stack.push(1);
        stack.push(2);
        assertEquals(2, (int) stack.top());
        assertEquals(2, (int) stack.top());
	}

	@Test
	void testSize() {
	    assertEquals(0, stack.size());
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
	}

	@Test
	void testPush() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertEquals(5, stack.size());
	}

	@Test
	void testToString() {
		assertEquals("", stack.toString());
	}

	@Test
	void testToStringString() {
		assertEquals("", stack.toString(","));
	}

	@Test
	void testFill() {
		ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        stack.fill(list);
        assertEquals(3, stack.size());
        assertEquals(3, (int) stack.pop());
        assertEquals(2, (int) stack.pop());
        assertEquals(1, (int) stack.pop());
        ArrayList<Integer> largerList = new ArrayList<>();
        largerList.add(1);
        largerList.add(2);
        largerList.add(3);
        largerList.add(4);
        largerList.add(5);
        largerList.add(6);
        assertTrue(stack.isEmpty());

	}

}
