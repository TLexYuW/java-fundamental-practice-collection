package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lex.practice.jackson.bidirectional_relationships._json_identity_info.ItemJII;
import com.lex.practice.jackson.bidirectional_relationships._json_identity_info.UserJII;
import com.lex.practice.jackson.bidirectional_relationships._json_ignore.ItemJI;
import com.lex.practice.jackson.bidirectional_relationships._json_ignore.UserJI;
import com.lex.practice.jackson.bidirectional_relationships._json_view.ItemJV;
import com.lex.practice.jackson.bidirectional_relationships._json_view.UserJV;
import com.lex.practice.jackson.bidirectional_relationships._json_view.Views;
import com.lex.practice.jackson.bidirectional_relationships.relation_exception.ItemTE;
import com.lex.practice.jackson.bidirectional_relationships.relation_exception.UserTE;
import com.lex.practice.jackson.bidirectional_relationships.jmr_jbr_annotations.eg1.ItemJBR;
import com.lex.practice.jackson.bidirectional_relationships.jmr_jbr_annotations.eg1.UserJMR;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author : Lex Yu
 */
public class JacksonTest {

	@Test
	@DisplayName("Given Bidirectional Relation When Serializing Then Exception")
	public void bidirectional_relation_test()
			throws JsonProcessingException {

		UserTE user = new UserTE(1, "John");
		ItemTE item = new ItemTE(2, "book", user);
		List<ItemTE> itemList = new ArrayList<>();
		itemList.add(item);
		user.setUserItems(itemList);

		assertThatThrownBy(() -> new ObjectMapper().writeValueAsString(item))
				.isInstanceOf(JsonMappingException.class);
	}

	@Test
	@DisplayName("Given Bidirectional Relation When Serializing With JMR, JBR Annotations")
	public void bidirectional_relation_test_with_jmr_jbr_annotation() throws JsonProcessingException {

		String expect_result = """
				{"id":2,"itemName":"book"}""";

		UserJMR userJMR = new UserJMR(1, "John");
		ItemJBR itemJBR = new ItemJBR(2, "book", userJMR);
		List<ItemJBR> itemList = new ArrayList<>();
		itemList.add(itemJBR);
		userJMR.setUserItems(itemList);

		String result = new ObjectMapper().writeValueAsString(itemJBR);
		System.out.println(result);

		assertThat(result).isEqualTo(expect_result);

		final String itemJson = new ObjectMapper().writeValueAsString(itemJBR);
		final String userJson = new ObjectMapper().writeValueAsString(userJMR);
		// The serialized Item object doesnt contain a reference to the User object.
		System.out.println("item json = " + itemJson);
		System.out.println("user json = " + userJson);
		/*
		{"id":2,"itemName":"book"}
		{"id":1,"name":"John","userItems":[{"id":2,"itemName":"book"}]}
		 */

		assertThat(itemJson).contains("book");
		assertThat(itemJson).doesNotContain("John");
		assertThat(userJson).contains("John").contains("userItems").contains("book");
	}

	@Test
	@DisplayName("Given Bidirectional Relation When Serializing With JII Annotation")
	public void bidirectional_relation_test_with_jii_annotation() throws JsonProcessingException {

		String expect_result = """
				{"id":2,"itemName":"book","owner":{"id":1,"name":"John","userItems":[2]}}""";

		UserJII userJII = new UserJII(1, "John");
		ItemJII itemJII = new ItemJII(2, "book", userJII);
		userJII.addItem(itemJII);

		final String userJson = new ObjectMapper().writeValueAsString(userJII);
		final String itemJson = new ObjectMapper().writeValueAsString(itemJII);
		System.out.println("item json = " + itemJson);
		// {"id":2,"itemName":"book","owner":{"id":1,"name":"John","userItems":[2]}}
		System.out.println("user json = " + userJson);
		// {"id":1,"name":"John","userItems":[{"id":2,"itemName":"book","owner":1}]}

		assertThat(itemJson).contains("book");
		assertThat(itemJson).contains("John");
		assertThat(itemJson).contains("userItems");

		assertThat(itemJson).isEqualTo(expect_result);
	}

	@Test
	@DisplayName("Given Bidirectional Relation When Serializing With JsonIgnore Annotation")
	public void bidirectional_relation_test_with_ji_annotation() throws JsonProcessingException {

		String expect_result = """
				{"id":2,"itemName":"book","owner":{"id":1,"name":"John"}}""";

		UserJI userJI = new UserJI(1, "John");
		ItemJI itemJI = new ItemJI(2, "book", userJI);
		userJI.addItem(itemJI);

		final String userJson = new ObjectMapper().writeValueAsString(userJI);
		final String itemJson = new ObjectMapper().writeValueAsString(itemJI);
		System.out.println("item json = " + itemJson);
		// {"id":2,"itemName":"book","owner":{"id":1,"name":"John"}}
		System.out.println("user json = " + userJson);
		// {"id":1,"name":"John"}

		assertThat(itemJson).contains("book");
		assertThat(itemJson).contains("John");
		assertThat(itemJson).doesNotContain("userItems");

		assertThat(itemJson).isEqualTo(expect_result);
	}

	@Test
	@DisplayName("Given Bidirectional Relation When Serializing With JsonView Annotation")
	public void bidirectional_relation_test_with_jv_annotation() throws JsonProcessingException {

		String expect_result = """
				{"id":2,"itemName":"book","owner":{"id":1,"name":"John"}}""";

		UserJV userJV = new UserJV(1, "John");
		ItemJV itemJV = new ItemJV(2, "book", userJV);
		userJV.addItem(itemJV);

		String itemJson = new ObjectMapper().writerWithView(Views.Public.class)
				.writeValueAsString(itemJV);
		String userJson = new ObjectMapper().writerWithView(Views.Public.class)
				.writeValueAsString(userJV);
		System.out.println("item json = " + itemJson);
		// {"id":2,"itemName":"book","owner":{"id":1,"name":"John"}}
		System.out.println("user json = " + userJson);
		// {"id":1,"name":"John"}

//		String itemJsonInternal = new ObjectMapper().writerWithView(Views.Internal.class)
//				.writeValueAsString(itemJV);
//		String userJsonInternal = new ObjectMapper().writerWithView(Views.Internal.class)
//				.writeValueAsString(userJV);

//		System.out.println(itemJsonInternal);
//		System.out.println(userJsonInternal);

		assertThat(itemJson).contains("book");
		assertThat(itemJson).contains("John");
		assertThat(itemJson).doesNotContain("userItems");

		assertThat(itemJson).isEqualTo(expect_result);
	}

	@Test
	@DisplayName("Given Bidirectional Relation When Serializing With Internal JsonView Annotation")
	public void bidirectional_relation_test_with_jv_annotation_internal() {


		UserJV userJV = new UserJV(1, "John");
		ItemJV itemJV = new ItemJV(2, "book", userJV);
		userJV.addItem(itemJV);

		assertThatThrownBy(() -> new ObjectMapper().writerWithView(Views.Internal.class)
				.writeValueAsString(itemJV))
				.isInstanceOf(JsonMappingException.class);

		assertThatThrownBy(() -> new ObjectMapper().writerWithView(Views.Internal.class)
				.writeValueAsString(userJV))
				.isInstanceOf(JsonMappingException.class);
	}
}
