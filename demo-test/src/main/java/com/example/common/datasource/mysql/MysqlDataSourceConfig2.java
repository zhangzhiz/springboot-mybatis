package com.example.common.datasource.mysql;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;

/**
 *
 */

@Configuration
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = "com.example.othersource.*.dao", markerInterface = MybatisMapper.class, sqlSessionFactoryRef = "secondSqlSessionFactory")
//@DependsOn("mybatisConfig")
public class MysqlDataSourceConfig2 implements EnvironmentAware {

    private final Logger LOGGER = LoggerFactory.getLogger(MysqlDataSourceConfig2.class);

    private RelaxedPropertyResolver mybatisPropertyResolver;

    /**
     * 获取配置信息
     * @param environment
     */
    @Override
    public void setEnvironment(Environment environment) {
        mybatisPropertyResolver = new RelaxedPropertyResolver(environment,"mybatis.");
    }

    @Value("${spring.datasource2.driverClassName}")
    private String driver;

    @Value("${spring.datasource2.url}")
    private String url;

    @Value("${spring.datasource2.username}")
    private String username;

    @Value("${spring.datasource2.password}")
    private String password;

    @Bean(name = "secondMysqlDatasource")
    public DataSource secondMysqlDatasource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "secondTransactionManager")
    public DataSourceTransactionManager rdsTransactionManager() {
        return new DataSourceTransactionManager(secondMysqlDatasource());
    }

    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("secondMysqlDatasource") DataSource datasource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        //添加mybatis配置文件
        PathMatchingResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        bean.setConfigLocation(resourceResolver.getResource(mybatisPropertyResolver.getProperty("config-location")));
        try {
            bean.setMapperLocations(resourceResolver.getResources(mybatisPropertyResolver.getProperty("mapper2-locations")));
            return bean.getObject();
        } catch (IOException e) {
            LOGGER.error("获取mapper资源出现异常",e);
            throw new RuntimeException("获取mapper资源出现异常",e);
        } catch (Exception e){
            LOGGER.error("初始化sqlSessionFactory时出现异常",e);
            throw new RuntimeException("初始化sqlSessionFactory时出现异常",e);
        }
    }

//    @Bean(name = "secondSqlSessionFactory")
//    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("secondSqlSessionFactory")SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }

}

