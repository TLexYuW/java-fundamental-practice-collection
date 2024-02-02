package com.lex.practice.jackson.bidirectional_relationships.custom_serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.lex.practice.jackson.bidirectional_relationships.custom_deserializer.ItemCDSL;

import java.io.IOException;
import java.util.List;

/**
 * @author : Lex Yu
 */
public class CustomListSerializer extends StdSerializer<List<ItemCDSL>> {
	protected CustomListSerializer(Class<List<ItemCDSL>> t) {
		super(t);
	}

	@Override
	public void serialize(List<ItemCDSL> itemCDSLS, JsonGenerator jsonGenerator,
	                      SerializerProvider serializerProvider) throws IOException {
		// implementation
	}
}
