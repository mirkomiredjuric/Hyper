package com.hyper.employee;

import com.hyper.employee.dao.BaseRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.hyper.employee", repositoryBaseClass = BaseRepositoryImpl.class)
public class JpaConfiguration {
}
