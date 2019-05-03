package vn.com.vuong.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MessageRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int type;
	private String payload;
}
