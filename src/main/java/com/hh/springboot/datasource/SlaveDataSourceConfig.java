package com.hh.springboot.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 从数据源
 *
 * @author HaoHao
 * @date 2019/3/27下午5:33
 */

//@Configuration
// 指定扫描哪个包的mapper
@MapperScan(basePackages = "com.hh.springboot.mapper.slave", sqlSessionFactoryRef = "slaveSqlSessionFactory")
public class SlaveDataSourceConfig {

    @Bean("slaveDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.slave") // 注在@bean 方法也能装备bean
    public DataSource getDateSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("slaveSqlSessionFactory")
    @Primary // 优先注入
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("slaveDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mapper/slave/*.xml"));
        return bean.getObject();
    }

    @Bean("slaveSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("slaveSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
