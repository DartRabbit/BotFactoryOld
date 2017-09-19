package com.botfactory.factory.config;



import com.botfactory.factory.repository.datajpa.CrudUserRepository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.DIALECT;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = CrudUserRepository.class,
        entityManagerFactoryRef = "configureEntityManagerFactory")
public class JpaConfig implements TransactionManagementConfigurer{

    @Value("${dataSource.driverClassName}")
    private String driver;
    @Value("${dataSource.url}")
    private String url;
    @Value("${dataSource.username}")
    private String username;
    @Value("${dataSource.password}")
    private String password;
    @Value("${hibernate.dialect}")
    private String dialect;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;
    @Value("${hibernate.db-init}")
    private String db_init;
    @Value("${hibernate.db-populate}")
    private String db_populate;
    @Value("${hibernate.show-sql}")
    private String show_sql;

    @Bean
    public HikariDataSource configureDataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);

        HikariDataSource dataSource = new HikariDataSource(config);

        Resource initSchema = new ClassPathResource(db_init);
        Resource initData = new ClassPathResource(db_populate);
        DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema, initData);
        DatabasePopulatorUtils.execute(databasePopulator, dataSource);

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean configureEntityManagerFactory() {

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(configureDataSource());
        entityManagerFactoryBean.setPackagesToScan("com.botfactory.factory");
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProperties = new Properties();
        jpaProperties.put(DIALECT, dialect);
        jpaProperties.put(Environment.SHOW_SQL, show_sql);
        jpaProperties.put(Environment.HBM2DDL_AUTO, hbm2ddlAuto);
        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }

    @Bean("transactionManager")
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new JpaTransactionManager();
    }
}
