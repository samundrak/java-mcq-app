/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author samundra-sage
 */
public class DBQuery {

    private Connection connection;

    public DBQuery(Connection connection) {
        this.connection = connection;
    }

    public ResultSet execQuery(String query) throws SQLException {
        Statement statement = this.connection.createStatement();
        return statement.executeQuery(query);
    }
    
    public int updateQuery(String query) throws SQLException {
        Statement statement = this.connection.createStatement();
        return statement.executeUpdate(query);
    }
}
