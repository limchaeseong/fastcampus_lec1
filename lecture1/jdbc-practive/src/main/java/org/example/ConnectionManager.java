package org.example;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class ConnectionManager {

    public static DataSource getDataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setJdbcUrl("jdbc:h2:mem://localhost/~/jdbc-practice;MODE=MySQL;DB_CLOSE_DELAY=-1");
        ds.setUsername("sa");
        ds.setPassword("");

        return ds;
    }
}
