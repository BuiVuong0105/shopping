package vn.com.vuong.converter;

import java.io.IOException;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.StringHttpMessageConverter;

public class CustomStringHttpMessageConvert extends StringHttpMessageConverter {
	@Override
	protected String readInternal(Class<? extends String> clazz, HttpInputMessage inputMessage) throws IOException {
		return super.readInternal(clazz, inputMessage);
	}
}
