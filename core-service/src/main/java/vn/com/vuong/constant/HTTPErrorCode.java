package vn.com.vuong.constant;

import java.util.HashMap;
import java.util.Map;


/**
 * Định nghĩa các mã lỗi chung cho các lỗi thông dụng
 * 
 * @author Bui Vuong
 *
 */
public class HTTPErrorCode {
	
	public static class Message {
		public static final String INVALID_PARAMETER = "Invalid Parameter";
		public static final String ERROR = "Error";
		public static final String NOT_FOUND = "Data Not Found";
		public static final String EXIST = "Data Exist";
		public static final String SERVER_ERROR = "An Error Server Orcus";
	}
	
	public static final int INVALID_PARAMETER = -10;
	public static final int ERROR = -20; 
	public static final int NOT_FOUND = -30; 
	public static final int EXIST = -40; 
	public static final int SERVER_ERROR = -50; 
	
	private static Map<Integer, String> messageError = new HashMap<Integer, String>();
	
	static {
		messageError.put(INVALID_PARAMETER, Message.INVALID_PARAMETER);
		messageError.put(ERROR, Message.ERROR);
		messageError.put(NOT_FOUND, Message.NOT_FOUND);
		messageError.put(EXIST, Message.EXIST);
		messageError.put(SERVER_ERROR, Message.SERVER_ERROR);
	}
	
	public static String getMessage(int code) {
		return messageError.getOrDefault(code, Message.ERROR);
	}
}
