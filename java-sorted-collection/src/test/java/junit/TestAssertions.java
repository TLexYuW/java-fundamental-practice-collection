package junit;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Lex Yu
 */
@DisplayName("JUnit5 Assertions Test")
public class TestAssertions {
	@BeforeEach
	public void testBeforeEach() {
		System.out.println("@BeforeEach Start -----------");
	}

	@AfterEach
	public void testAfterEach() {
		System.out.println("@AfterEach Start -----------");
	}

	@BeforeAll
	public static void testBeforeAll() {
		System.out.println("@BeforeAll Start -----------");
	}

	@AfterAll
	public static void testAfterAll() {
		System.out.println("@AfterAll Start -----------");
	}

	@DisplayName("Test AssertionEquals")
	@Test
	public void testAssertionEquals() {
		int result = plus(3, 5);
		assertEquals(8, result, "Logic went wrong");
		Object o1 = new Object();
		Object o2 = new Object();
		assertSame(o1, o2, "They are not the same");
	}

	private int plus(int x, int y) {
		return x + y;
	}

	@DisplayName("Test AssertSame")
	@Test
	public void testAssertSame() {
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = o1;
		assertSame(o1, o3, "They are the same");
		assertNotSame(o1, o2, "They are not the same");
	}

	@DisplayName("Test ArrayAssertion")
	@Test
	public void testArrayAssertion() {
//		assertArrayEquals(new int[]{1, 2}, new int[]{3, 4}, "Array content not equal");
		assertArrayEquals(new int[]{3,4}, new int[]{3,4}, "Array content not equal");
	}

	@DisplayName("Test AssertAll")
	@Test
	public void testAssertAll() {
		assertAll("test all",
				() -> assertTrue(true),
				() -> assertEquals(10, 10),
				() -> assertNotEquals(new Object(), new ArrayList<>()));
		System.out.println("Success");
	}

	@DisplayName("Test ExceptionAssertions")
	@Test
	public void testExceptionAssertions() {
		assertThrows(ArithmeticException.class, () -> {
			int i = 10 / 2; // assertion will execute
			int j = 10 / 0; // assertion won't execute
		}, "still work?");
	}

	@DisplayName("Test TimeoutAssertions")
	@Test
	public void testTimeoutAssertions() {
		assertTimeout(Duration.ofSeconds(1), () -> Thread.sleep(2000),"Method Timeout");
	}

	@DisplayName("Test fail")
	@Test
	public void testFail() {
		System.out.println(4);
		System.out.println(3);
		fail("LEAVING......");
		System.out.println(2);
		System.out.println(1);
	}

	@DisplayName("Test Assumptions")
	@Test
	public void testAssumptions() {
		Assumptions.assumeTrue(false, "Result is not true");
//		Assumptions.assumeTrue(true, "Result is not true");
		System.out.println("??????");
	}
}
