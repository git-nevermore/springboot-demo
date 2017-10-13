package com.test.springboot.common.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.test.springboot.common.interceptor.LoginInterceptor;

/**
 * MVC 相关处理配置
 * 
 * @author chenwenjie
 * @since 2017-10-09
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter{

	/**
	 * 视图跳转配置
	 * <p>根据/example 跳转到下面配置的 /views/example.html 页面
	 */
	@Override  
    public void addViewControllers(ViewControllerRegistry registry) {  
		//registry.addViewController("/error").setViewName("error");  				// 自定义错误页面
        registry.addViewController("/user/registry").setViewName("registry");  		// 注册页面
        registry.addViewController("/user/input").setViewName("input");  			// 信息输入页面
        registry.addViewController("/user/info").setViewName("userInfo");  			// 信息中心
    }
	
	/**
	 * 视图存放的位置和默认后缀(@Bean 的配置优先级高于 *.yml 配置)
	 */
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setPrefix("/views/");
		view.setSuffix(".html");
		return view;
	}
	
	/**
	 * 静态资源存放路径
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webapp/**").addResourceLocations("classpath:/");
		super.addResourceHandlers(registry);
	}
	
	/**
	 * 登录权限拦截
	 */
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
        		.excludePathPatterns("/","/login","/registry","/user/registry");
        super.addInterceptors(registry);
    }
}
