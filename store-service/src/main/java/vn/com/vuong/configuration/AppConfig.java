package vn.com.vuong.configuration;

import java.util.List;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;
import vn.com.vuong.converter.CustomFormHttpMessageConvert;
import vn.com.vuong.converter.CustomStringHttpMessageConvert;
import vn.com.vuong.converter.MyMappingJacksonHttpMessageConverter;

@Slf4j
@Configuration
@EnableWebMvc
@EnableCaching
//@EnableAspectJAutoProxy
public class AppConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		log.debug("ResourceHandlerRegistry Init");
		registry.addResourceHandler("/resources/**").addResourceLocations("/", "/resources/");
	}

	// @Bean
	// public CacheManager cacheManager() {
	// return new EhCacheCacheManager();
	// }

	@Bean
	public CacheManager getEhCacheManager() {
		log.info("CacheManager Init");
		CacheManager cacheManager = new EhCacheCacheManager(getEhCacheFactory().getObject());
		return cacheManager;
	}

	@Bean
	public EhCacheManagerFactoryBean getEhCacheFactory() {
		log.info("EhCacheManagerFactoryBean Init");
		EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
		factoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		factoryBean.setShared(true);
		return factoryBean;
	}

	// @Bean(name = "viewResolver")
	// public InternalResourceViewResolver viewResolver() {
	// logger.info("Init ViewResolve");
	// InternalResourceViewResolver viewResolver = new
	// InternalResourceViewResolver();
	// viewResolver.setPrefix("/WEB-INF/pages/views/");
	// viewResolver.setSuffix(".jsp");
	// viewResolver.setOrder(1);
	// return viewResolver;
	// }

	// @Bean
	// public TilesConfigurer tilesConfigurer() {
	// log.info("TilesConfigurer Init");
	// TilesConfigurer tilesConfigurer = new TilesConfigurer();
	// tilesConfigurer.setDefinitions("/WEB-INF/pages/tiles.xml");
	// tilesConfigurer.setCheckRefresh(true);
	// return tilesConfigurer;
	// }

	// @Override
	// public void configureViewResolvers(ViewResolverRegistry registry) {
	// TilesViewResolver viewResolver = new TilesViewResolver();
	// registry.viewResolver(viewResolver);
	// }

	@Bean(name = "messageSource")
	public ResourceBundleMessageSource messageSource() {
		log.info("ResourceBundleMessageSource Init");
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("message");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	// @Bean(name = "localeResolver")
	// public CookieLocaleResolver localeResolver() {
	// log.info("CookieLocaleResolver Init");
	// CookieLocaleResolver localeResolver = new CookieLocaleResolver();
	// localeResolver.setDefaultLocale(new Locale("vi"));
	// localeResolver.setCookieName("myAppLocaleCookie");
	// localeResolver.setCookieMaxAge(3600);
	// return localeResolver;
	// }

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		log.info("CommonsMultipartResolver Init");
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(20971520);
		multipartResolver.setMaxInMemorySize(1048576);
		return multipartResolver;
	}

	// @Bean(name = "propertyPlaceholderConfigurer")
	// public PropertyPlaceholderConfigurer PlaceholderConfigurerSupport() {
	// log.info("PropertyPlaceholderConfigurer Init");
	// PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new
	// PropertyPlaceholderConfigurer();
	// return propertyPlaceholderConfigurer;
	// }

	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		return placeholderConfigurer;
	}

	// @Override
	// public void addInterceptors(InterceptorRegistry registry) {
	// log.info("InterceptorRegistry Init");
	// LocaleChangeInterceptor localeChangeInterceptor = new
	// LocaleChangeInterceptor();
	// localeChangeInterceptor.setParamName("lang");
	// registry.addInterceptor(localeChangeInterceptor);
	// }

	// @Override
	// public void configureDefaultServletHandling(DefaultServletHandlerConfigurer
	// configurer) {
	// configurer.enable();
	// }

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new MyMappingJacksonHttpMessageConverter());
		converters.add(new CustomStringHttpMessageConvert());
		converters.add(new CustomFormHttpMessageConvert());
	}
}
