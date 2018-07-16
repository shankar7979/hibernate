package org.com.bean;

import org.com.dao.StudentDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class StudentConfig {
	
	@Bean(initMethod="studentInit")
	public StudentDao getStudentDao(){
		StudentDao dao=new StudentDao();
		
		dao.setDs(getSpringDs());
		return dao;
	}
	
	@Bean
	public DriverManagerDataSource getSpringDs(){
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setUrl("jdbc:oracle:thin:@10.113.17.58:1521:appsdb01");
		ds.setPassword("java1629");
		ds.setUsername("java1629");
		ds.setDriverClassName("oracle.jdbc.OracleDriver");
				
		return ds;
	}	
}
