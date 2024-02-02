package com.lex.practice.jackson.bidirectional_relationships.custom_deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.List;

/**
 * @author : Lex Yu
 */
public class CustomListDeserializer extends StdDeserializer<List<ItemCDSL>> {

	protected CustomListDeserializer(Class vc) {
		super(vc);
	}

	@Override
	public List<ItemCDSL> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JacksonException {
		return null;
	}
}
