package com.mygit.boot.conf;

import java.sql.SQLException;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.mygit.boot.dao.IFetchDao;

import oracle.jdbc.pool.OracleDataSource;

@Repository
@Configuration
@ConfigurationProperties("spring.datasource")
@EnableJpaRepositories(basePackages={"com.mygit.boot.dao"})
@EntityScan(basePackages={"com.mygit.boot.entity"})
public class TestConf {
	@NotNull
    private String username;
 
    @NotNull
    private String password;
 
    @NotNull
    private String url;
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public void setUrl(String url) {
        this.url = url;
    }

	@Bean
    DataSource dataSource() throws SQLException { 
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setURL(url);
        dataSource.setImplicitCachingEnabled(true);
        dataSource.setFastConnectionFailoverEnabled(true);
        return dataSource;
    }

}
