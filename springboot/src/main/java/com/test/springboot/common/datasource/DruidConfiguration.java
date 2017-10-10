package com.test.springboot.common.datasource;

import java.sql.SQLException;
import java.util.Properties;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * Druid 数据池配置
 * 
 * @author chenwenjie
 * @since 2017-10-09
 */
@Configuration
@EnableJpaRepositories(basePackages = DruidConfiguration.BASE_PACKAGE, 
	transactionManagerRef = "transactionManager", entityManagerFactoryRef = "entityManagerFactory")
@EnableTransactionManagement(proxyTargetClass = true)
public class DruidConfiguration {

	/**
	 * 数据源管理路径扫描范围
	 */
	protected static final String BASE_PACKAGE = "com.test.springboot";
	
	/**
	 * 数据库方言(暂时写死为 MySQL)
	 */
	protected static final String DATABASE_DIALOG = "org.hibernate.dialect.MySQLDialect";
	
	/**
	 * 数据源的配置
	 * <p>暂时写死为MySQL 的简单配置
	 * <p>#TODO 后续将加强优化配置存储 和多数据库支持
	 * 
	 * @return
	 * @throws SQLException
	 */
    @Bean(name = "dataSource",initMethod = "init" ,destroyMethod = "close")
    public DruidDataSource druidDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=true");
        dataSource.setMaxActive(100);
        dataSource.setFilters("stat,wall");
        dataSource.setInitialSize(10);
        return dataSource;
    }
    
    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");
        return servletRegistrationBean;
    }

   @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
 
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setDataSource(druidDataSource());
		lcemfb.setJpaVendorAdapter(hibernateJpaVendorAdapter());
		lcemfb.setPackagesToScan(BASE_PACKAGE);

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto", "update");
		jpaProperties.put("hibernate.show_sql", false);
		jpaProperties.put("hibernate.format_sql", false);
		jpaProperties.put("hibernate.ejb.naming_strategy", ImprovedNamingStrategy.class);
		lcemfb.setJpaProperties(jpaProperties);

		return lcemfb;
	}
	
   @Bean(name = "hibernateJpaVendorAdapter")
	public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
		HibernateJpaVendorAdapter hjva = new HibernateJpaVendorAdapter();
		hjva.setDatabasePlatform(DATABASE_DIALOG);
		return hjva;
	}
	
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager() throws Exception {
		JpaTransactionManager jtm = new JpaTransactionManager();
		jtm.setEntityManagerFactory(entityManagerFactory().getObject());
		return jtm;
	}
}
