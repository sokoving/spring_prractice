package com.spring.practice.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.spring.practice")
public class DataBaseConfig {
    // 접속정보 객체 빈 등록 (DataSource 객체)
    @Bean
    public DataSource dataSource() {
        // 커넥션 풀: 데이터베이스 연결 객체를 모아둔 곳
        HikariConfig config = new HikariConfig();
        config.setUsername("spring4");
        config.setPassword("1234");
        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
        config.setDriverClassName("oracle.jdbc.driver.OracleDriver");

        return new HikariDataSource(config);

    }
}