
/**
 * This class contains the test case methods that students must implement
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotationTest_STUDENT {
	String test1;
	String expectedValue1;
	String test2;
	String expectedValue2;
	String test3;
	String expectedValue3;
	@BeforeEach
	void setUp() throws Exception {
		test1 = "23*4+";
        expectedValue1 = "234*+";
        test2 = "((1+2)*(3-4))/5";
        expectedValue2 ="((1+2)*(3-4))/5";
        test3 = "1 + 2 * ( 3 - 4 ) / 5";
        expectedValue3 = "1234-*5/+";
	}

	@AfterEach
	void tearDown() throws Exception {
		test1 = null;
         expectedValue1 = null;
         test2 = null;
         expectedValue2 = null;
         test3 = null;
         expectedValue3 = null;
	}

	@Test
	void testEvaluatePostfixExpression() {
		assertEquals(test2, expectedValue2);
	}

	@Test
	void testConvertPostfixToInfix() {
		assertEquals(expectedValue1, Notation.convertInfixToPostfix(test1));
	}

	@Test
	void testConvertInfixToPostfix() {
		assertEquals(expectedValue3, Notation.convertInfixToPostfix(test3));
	}

}
