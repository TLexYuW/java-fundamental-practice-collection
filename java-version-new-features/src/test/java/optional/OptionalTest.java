package optional;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Lex Yu
 */
public class OptionalTest {
	public String getMyDefault() {
		System.out.println("Getting Default Value");
		return "Default Value";
	}
	@Test
	public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
		String text = null;

		String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
		assertEquals("Default Value", defaultText);

		defaultText = Optional.ofNullable(text).orElse(getMyDefault());
		assertEquals("Default Value", defaultText);
	}

	@Test
	public void whenOrElseGetAndOrElseDiffer_thenCorrect() {
		String text = "Text present";

		System.out.println("Using orElseGet:");
		String defaultText
				= Optional.ofNullable(text).orElseGet(this::getMyDefault);
		assertEquals("Text present", defaultText);

		System.out.println("Using orElse:");
		defaultText = Optional.ofNullable(text).orElse(getMyDefault());
		assertEquals("Text present", defaultText);
	}

	@Test()
	public void whenNoArgOrElseThrowWorks_thenCorrect() {
		String nullName = null;
		assertThrows(NoSuchElementException.class, () -> Optional.ofNullable(nullName).orElseThrow());
	}
	@Test
	public void givenOptional_whenGetsValue_thenCorrect() {
		Optional<String> opt = Optional.of("Hello World");
		String name = opt.get();
		assertEquals("Hello World", name);
	}

	@Test
	public void givenOptionalWithNull_whenGetThrowsException_thenCorrect() {
		Optional<String> opt = Optional.ofNullable(null);

		assertThrows(NoSuchElementException.class, () -> opt.get());
	}

	@Test
	public void whenOptionalFilterWorks_thenCorrect() {
		Integer year = 2016;
		Optional<Integer> yearOptional = Optional.of(year);
		boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
		assertTrue(is2016);
		boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
		assertFalse(is2017);
	}


}
