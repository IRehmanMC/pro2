import java.util.ArrayList;
/**
 * This class contains the test case methods that students must implement
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyQueueTest_STUDENT {
	private MyQueue<Integer> queue;

	@BeforeEach
	void setUp() throws Exception {
		 queue = new MyQueue<>(5);
	}

	@AfterEach
	void tearDown() throws Exception {
		queue = null;
	}

	@Test
	void testIsEmpty() {
		assertTrue(queue.isEmpty());
	}

	@Test
	void testDequeue() {
		queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, (int) queue.dequeue());
        assertEquals(2, (int) queue.dequeue());
	}

	@Test
	void testSize() {
		assertEquals(0, queue.size());
	}

	@Test
	void testEnqueue() {
		assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        assertEquals(5, queue.size());
	}

	@Test
	void testIsFull() {
        MyQueue<Integer> queue = new MyQueue<>(5);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        queue.fill(list);
        assertEquals(3, queue.size());
        list.add(4);
        list.add(5);
        list.add(6);
	}

	@Test
	void testToString() {
		assertEquals("", queue.toString());
	}

	@Test
	void testToStringString() {
		assertEquals("", queue.toString(","));
	}

	@Test
	void testFill() {
		 ArrayList<Integer> list = new ArrayList<>();
	        list.add(1);
	        list.add(2);
	        list.add(3);
	        queue.fill(list);
	        assertEquals(3, queue.size());
	        assertEquals(1, (int) queue.dequeue());
	        assertEquals(2, (int) queue.dequeue());
	        assertEquals(3, (int) queue.dequeue());
	        ArrayList<Integer> largerList = new ArrayList<>();
	        largerList.add(1);
	        largerList.add(2);
	        largerList.add(3);
	        largerList.add(4);
	        largerList.add(5);
	        largerList.add(6);
	        assertTrue(queue.isEmpty());
	}

}
