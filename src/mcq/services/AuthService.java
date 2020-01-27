/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.services;

import java.sql.SQLException;
import mcq.core.db.DBConnection;
import mcq.core.db.DBQuery;
import mcq.dto.RegisterDTO;

/**
 *
 * @author samundra-sage
 */
public class AuthService {

    String table = "users";
    DBConnection dbConnection;
    DBQuery dbq;

    public AuthService() {
        this.dbConnection = DBConnection.getInstance();
        this.dbq = new DBQuery(this.dbConnection.getConnection());

    }

    public void createUser(RegisterDTO dTO) throws SQLException {
        String query = "insert into " + table + "(first_name, last_name, email, username, password) values('" + dTO.getFirst_name() + "','" + dTO.getLast_name() + "','" + dTO.getEmail() + "','" + dTO.getUsername() + "','" + dTO.getPassword() + "')";
        int update = this.dbq.updateQuery(query);
        System.out.println(update);
    }
}
