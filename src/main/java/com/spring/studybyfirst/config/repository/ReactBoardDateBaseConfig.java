package com.spring.studybyfirst.config.repository;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mariadb.jdbc.Driver;
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
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.spring.studybyfirst.repository.reactBoard", sqlSessionFactoryRef = "reactBoardSqlSessionFactory")
@EnableTransactionManagement
public class ReactBoardDateBaseConfig {
    private String taskNamePrefix;


    @Value("${spring.react.datasource.url}")
    private String url;

    @Value("${spring.react.datasource.username}")
    private String userName;

    @Value("${spring.react.datasource.password}")
    private String password;

    @Value("${spring.react.datasource.driver-class-name}")
    private String driverClassName;


    @Bean(name="reactBoardDataSource")
    public DataSource reactBoardDataSource() throws ClassNotFoundException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        //dataSource.setDriverClass((Class<Driver>)Class.forName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy"));
        dataSource.setDriverClass(Driver.class);
        dataSource.setUrl("jdbc:mysql://woolta.com:3306/ReactBoard?useUnicode=true&characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("as455748");

        return dataSource;
    }

    @Bean(name = "reactBoardSqlSessionFactory")
    public SqlSessionFactory reactBoardSqlSessionFactory(
            @Qualifier("reactBoardDataSource") DataSource reactBoardDataSource,
            ApplicationContext applicationContext
    ) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(reactBoardDataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:sql/reactBoard/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "reactBoardSqlSessionTemplate")
    public SqlSessionTemplate reactBoardSqlSessionTemplate(SqlSessionFactory reactBoardSqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(reactBoardSqlSessionFactory);
    }
}
