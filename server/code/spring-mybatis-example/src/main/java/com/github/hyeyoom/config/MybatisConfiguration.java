package com.github.hyeyoom.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "com.github.hyeyoom.repository")
public class MybatisConfiguration {
	
	private final static String MAPPER_CLASS_PATH
		= "classpath*:mapper/**/*.xml";

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource datasource) throws Exception {
		final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(datasource);
		sqlSessionFactoryBean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources(MAPPER_CLASS_PATH)
		);
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
