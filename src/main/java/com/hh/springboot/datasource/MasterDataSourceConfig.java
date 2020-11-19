package com.hh.springboot.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 主数据源
 *
 * @author HaoHao
 * @date 2019/3/27下午5:33
 */

//@Configuration
// 指定扫描哪个包的mapper
@MapperScan(basePackages = "com.hh.springboot.mapper.master", sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {

    @Bean("masterDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.master") // 注在@bean 方法也能装备bean
    public DataSource getDateSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("masterSqlSessionFactory")
    @Primary // 优先注入
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mapper/master/*.xml"));
        return bean.getObject();
    }

    @Bean("masterSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
