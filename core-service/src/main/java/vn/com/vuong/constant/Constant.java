package vn.com.vuong.constant;

public class Constant {

	public static final class Time {
		public static final long A_MINUTE = 60 * 1000;
		public static final long A_SECOND = 1000L;
		public static final long FIVE_MINUTES = 5 * A_MINUTE;
		public static final long AN_HOUR = 60 * A_MINUTE;
		public static final long A_DAY = 24 * AN_HOUR;
		public static final long A_MONTH = A_DAY * 30;
		public static final long A_YEAR = A_DAY * 365;
		public static final long JST_TIME_RAW_OFF_SET = 9 * AN_HOUR;
		public static final long THREE_DAY = 24L * AN_HOUR * 3;
		public static final long FOUR_DAY = 24L * AN_HOUR * 4;
		public static final int JavaDate_StartYear = 1900;
	}

	public static final class FormateDate {
		public static final String DD_MM_YYYY = "dd/MM/yyyy";
		public static final String DD_MM_YYYY_HH_MM_SS = "dd/MM/yyyy HH:mm:ss";
	}


	public static final class Role {
		public static final String ROLE_PREFIX = "ROLE_";
	}

	public static final class Semester {
		public static final int FIRST = 1;
		public static final int SECOND = 2;
	}

	public static final class User {
		public static final String USERNAME = "username";
		public static final String PASSWORD = "password";
	}

	public static final class JWT {
		public static final String CLAIM_KEY_ACCOUNT = "sub";
		public static final String CLAIM_KEY_AUDIENCE = "audience";
		public static final String CLAIM_KEY_CREATED = "created";
		public static final String CLAIM_KEY_EXPIRED = "exp";
		public static final String AUDIENCE_UNKNOWN = "unknown";
		public static final String AUDIENCE_WEB = "web";
		public static final String AUDIENCE_MOBILE = "mobile";
		public static final String AUDIENCE_TABLET = "tablet";
		public static final String TOKEN_PREFIX = "Bearer";
		public static final String TOKEN_HEADER = "Authorization";
		public static final String SECRET = "HOMETAGOS";
		public static final Long EXPIRATION = Time.FIVE_MINUTES;
	}

	public static final class Common {
		public static final String SPACE = " ";
		public static final String EMPTY = "";
		public static final int DEFAULT_PAGE = 0;
		public static final int DEFAULT_SIZE = 10;
	}
	
	public static final class Method {
		public static final String OPTIONS = "OPTIONS";
	}
	
	public static class TriggerType {
		public static final int SIMPLE_TRIGGER = 0;
		public static final int CRON_TRIGGER = 1;
	}
}
