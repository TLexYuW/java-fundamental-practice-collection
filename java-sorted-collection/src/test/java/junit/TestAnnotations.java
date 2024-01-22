package junit;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

/**
 * @author : Lex Yu
 */
@DisplayName("JUnit5 Annotations Test")
public class TestAnnotations {
	@DisplayName("Test @DisplayName - 1")
	@Test
	public void testDisplayName1(){
		System.out.println(12345);
	}

	@Disabled
	@DisplayName("Test @DisplayName - 2")
	@Test
	public void testDisplayName2(){
		System.out.println(678910);
	}

	@BeforeEach
	public void testBeforeEach(){
		System.out.println("@BeforeEach Start -----------");
	}
	@AfterEach
	public void testAfterEach(){
		System.out.println("@AfterEach Start -----------");
	}
	@BeforeAll
	public static void testBeforeAll(){
		System.out.println("@BeforeAll Start -----------");
	}
	@AfterAll
	public static void testAfterAll(){
		System.out.println("@AfterAll Start -----------");
	}

	@DisplayName("Test @Timeout Annotation")
	@Timeout(value = 4000, unit = TimeUnit.MILLISECONDS)
	@Test
	public void testTimeout() throws InterruptedException {
		System.out.println("Before Sleep");
		Thread.sleep(3000);
		System.out.println("Wake up");
	}

	@DisplayName("Test @RepeatedTest Annotation")
	@RepeatedTest(5)
	public void testRepeatedTest(){
		System.out.println("?");
	}

}
