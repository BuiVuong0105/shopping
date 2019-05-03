package vn.com.vuong.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
@Getter
public class Config {
	
	@Value("${datasource.sampleapp.url}")
	private String url;
	
	@Value("${datasource.sampleapp.username}")
	private String username;
	
	@Value("${datasource.sampleapp.password}")
	private String password;
	
	@Value("${datasource.sampleapp.driver-class-name}")
	private String driverClassName;
	
	@Value("${datasource.sampleapp.defaultSchema}")
	private String defaultSchema;
	
	@Value("${datasource.sampleapp.initialSize}")
	private Integer initialSize;
	
	@Value("${datasource.sampleapp.maxTotal}")
	private Integer maxTotal;
	
	@Value("${datasource.sampleapp.maxIdle}")
	private Integer maxIdle;
	
	@Value("${datasource.sampleapp.minIdle}")
	private Integer minIdle;
	
	@Value("${datasource.sampleapp.maxWait}")
	private Integer maxWait;
	
	@Value("${hibernate.sampleapp.dialect}")
	private String dialect;
	
	@Value("${hibernate.sampleapp.show_sql}")
	private boolean showSQL;
	
	@Value("${hibernate.sampleapp.enable_lazy_load_no_trans}")
	private boolean lazyLoad;
	
	@Value("${hibernate.sampleapp.connection.useUnicode}")
	private boolean useUniCode;
	
	@Value("${hibernate.sampleapp.connection.characterEncoding}")
	private String endCoding;
	
	@Value("${hibernate.sampleapp.connection.charSet}")
	private String charset;
	
}
