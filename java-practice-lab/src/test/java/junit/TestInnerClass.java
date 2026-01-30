package junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Lex Yu
 */
@DisplayName("Outer class")
public class TestInnerClass {
	Stack<Object> stack;

	@Test
	@DisplayName("Init new Stack() method")
	void Init() {
		new Stack<>();
	}

	@Nested
	@DisplayName("When new inner class")
	class WhenNew {
		@BeforeEach
		void createNewStack() {
			stack = new Stack<>();
		}

		@Test
		@DisplayName("is empty method")
		void isEmpty() {
			assertTrue(stack.isEmpty());
		}

		@Test
		@DisplayName("throws exception when popped method")
		void throwsExceptionWhenPopped() {
			assertThrows(EmptyStackException.class, stack::pop);
		}

		@Test
		@DisplayName("throws exception when peeked method")
		void throwsExceptionWhenPeeked() {
			assertThrows(EmptyStackException.class, stack::peek);
		}

		@Nested
		@DisplayName("After pushing an element")
		class AfterPushing {
			String element = "element";

			@BeforeEach
			@DisplayName("Pushing an element")
			void pushAnElement() {

			}

			@Test
			@DisplayName("It is no longer empty")
			void isNotEmpty() {
				assertFalse(stack.isEmpty());
			}

			@Test
			@DisplayName("Returns the element when popped and is empty")
			void returnElementWhenPopped() {
				assertEquals(element, stack.pop());
				assertTrue(stack.isEmpty());
			}

			@Test
			@DisplayName("Returns the element when peeked but remains not empty")
			void returnElementWhenPeeked() {
				assertEquals(element, stack.peek());
				assertFalse(stack.isEmpty());
			}
		}
	}
}
