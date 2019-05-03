package vn.com.vuong.utils;

import java.io.IOException;
import java.util.Collection;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class JsonUtils {
	private static final ObjectMapper MAPPER = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
			.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
			.setSerializationInclusion(JsonInclude.Include.NON_NULL);

	private JsonUtils() {
	}

	public static String toJson(Object object) {
		String json = "";
		if (object != null) {
			try {
				json = MAPPER.writeValueAsString(object);
			} catch (JsonProcessingException ex) {
				log.error("Error convert object to json", ex);
			}
		}
		return json;
	}

	public static <T> T toObject(String json, TypeReference<T> refer) {
		T t = null;
		if (StringUtils.isEmpty(json)) {
			try {
				t = MAPPER.readValue(json, refer);
			} catch (IOException ex) {
				log.error("To object exception", ex);
			}
		}
		return t;
	}

	public static <T> T toObject(String json, Class<T> type){
		T t = null;
		if (json != null && !json.equals("")) {
			try {
				t = MAPPER.readValue(json, type);
			} catch (IOException ex) {
				log.error("To object exception", ex);
			}
		}
		return t;
	}

	public static <T> T toObject(Object object, Class<T> type){
		T result = null;
		if (object != null) {
			result = MAPPER.convertValue(object, type);
		}
		return result;
	}

	@SuppressWarnings("rawtypes")
	public static <T extends Collection> T toCollection(String json, Class<T> collectionType, Class<?> elememtType) {
		T t = null;
		JavaType type = constructCollectionType(collectionType, elememtType);
		if (json != null && !json.equals("")) {
			try {
				t = MAPPER.readValue(json, type);
			} catch (IOException ex) {
				log.error("To collection exception", ex);
			}
		}
		return t;
	}

	public static JavaType constructCollectionType(
			@SuppressWarnings("rawtypes") Class<? extends Collection> collectionClass, Class<?> elementType) {
		JavaType type = MAPPER.getTypeFactory().constructCollectionType(collectionClass, elementType);
		return type;
	}

	public static JavaType constructCollectionType(Class<? extends Collection<?>> collectionClass,
			JavaType elementType) {
		JavaType type = MAPPER.getTypeFactory().constructCollectionType(collectionClass, elementType);
		return type;
	}

	public static ObjectMapper getInstance() {
		return MAPPER;
	}
}
