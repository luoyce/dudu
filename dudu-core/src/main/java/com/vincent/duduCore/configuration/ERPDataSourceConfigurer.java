//package com.vincent.duduCore.configuration;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
//import com.github.pagehelper.PageHelper;
//import com.vincent.duduCore.constant.DuduConstant;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import tk.mybatis.spring.annotation.MapperScan;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@EnableTransactionManagement
//@MapperScan(basePackages = DuduConstant.DATASOURCE_ERP_PACKAGE, sqlSessionFactoryRef = "ERPSqlSessionFactory")
//public class ERPDataSourceConfigurer {
//    @Bean(name = "ERPDataSource")
//    @Qualifier("ERPDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.erp")
//    @Primary
//    public DruidDataSource  ERPDataSource(){
//        return DruidDataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "ERPTransactionManager")
//    @Primary
//    public DataSourceTransactionManager ERPTransactionManager() {
//        return new DataSourceTransactionManager(ERPDataSource());
//    }
//
//    @Bean(name = "ERPSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory ERPSqlSessionFactory(@Qualifier("ERPDataSource") DataSource dataSource) throws Exception {
//        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource);
//        //sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DuduConstant.MAPPER_ERP));
//
//        //配置分页插件，详情请查阅官方文档
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("pageSizeZero", "true");//分页尺寸为0时查询所有纪录不再执行分页
//        properties.setProperty("reasonable", "true");//页码<=0 查询第一页，页码>=总页数查询最后一页
//        properties.setProperty("supportMethodsArguments", "true");//支持通过 Mapper 接口参数来传递分页参数
//        pageHelper.setProperties(properties);
//
//        //添加插件
//        sessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});
//
//        return sessionFactoryBean.getObject();
//    }
//}
