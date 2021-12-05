
package com.java.web.service;

import com.java.web.config.DatabaseConfig;
import com.java.web.dao.CostumerDao;
import com.java.web.domain.Costumer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CostumerService implements CostumerDao{

    Connection conn;

    protected void connect() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DatabaseConfig.url, DatabaseConfig.username, DatabaseConfig.password);
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex);
        }
    }
    
    @Override
    public boolean daftar(Costumer costumer) {
        try {
            connect();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CostumerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean login(Costumer costumer) {
        return false;
    }
    
}
