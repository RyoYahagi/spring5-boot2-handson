package com.example.persistence.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jdbc.repository.config.JdbcConfiguration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

// TODO 1-08 Java Configであることを示すアノテーションを付加する
@Configuration
// @Repositoryで定義したリポジトリクラスのパッケージ名を指定する
@ComponentScan(basePackages = "com.example.persistence.repository.impl")
// TODO 1-09 CrudRepositoryを継承したインタフェースのパッケージ名を指定する
@EnableJdbcRepositories(basePackages = "com.example.persistence.repository")
// TODO 1-10 JdbcConfigurationを継承する
public class JdbcConfig extends JdbcConfiguration{

    // 引数でDataSourceのBeanを受け取る
    // TODO 1-11 Beanであることを示すアノテーションを付加する
	@Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        // コンストラクタでDataSourceを受け取る
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
