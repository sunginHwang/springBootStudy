package com.spring.studybyfirst.config.repository;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.spring.studybyfirst.repository.mrh", sqlSessionFactoryRef = "mrhSqlSessionFactory")
@EnableTransactionManagement
public class MrHDataBaseConfig {


    @Value("${spring.mrh.datasource.url}")
    private String url;

    @Value("${spring.mrh.datasource.username}")
    private String userName;

    @Value("${spring.mrh.datasource.password}")
    private String password;

    @Value("${spring.mrh.datasource.driver-class-name}")
    private String driverClassName;


    @Bean(name="mrhDataSource")
    @Primary
    public DataSource mrhDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;    }

    @Bean(name = "mrhSqlSessionFactory")
    @Primary
    public SqlSessionFactory mrhSqlSessionFactory(
            @Qualifier("mrhDataSource") DataSource mrhDataSource,
            ApplicationContext applicationContext
    ) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mrhDataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:sql/mrh/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "mhSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate mrhSqlSessionTemplate(SqlSessionFactory mrhSqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(mrhSqlSessionFactory);
    }
}
