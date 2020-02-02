/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import mcq.core.Callable;
import mcq.core.db.DBConnection;
import mcq.core.db.DBQuery;
import mcq.core.exceptions.UserNotFoundException;
import mcq.core.dto.RegisterDTO;
import mcq.core.dto.UserDto;

/**
 *
 * @author samundra-sage
 */
public class AuthService extends DBConnected {

    String table = "users";

    public void createUser(RegisterDTO dTO) throws SQLException {
        String query = "insert into " + table + "(first_name, last_name, email) values('" + dTO.getFirst_name() + "','" + dTO.getLast_name() + "','" + dTO.getEmail() + "')";
        int update = this.dbq.updateQuery(query);
        System.out.println(update);
    }

    public void login(String username, String password, Callable callback) throws SQLException, UserNotFoundException {
        String query = "select * from users where username='" + username + "' and password='" + password + "'";
        ResultSet rows = this.dbq.execQuery(query);
        if (!rows.first()) {
            throw new UserNotFoundException();
        }

        UserDto user = new UserDto();
        user.setId(rows.getInt("id"));
        user.setEmail(rows.getString("email"));
        user.setFirst_name(rows.getString("first_name"));
        user.setLast_name(rows.getString("last_name"));
        user.setType(rows.getString("role"));
        Session.getInstance().addUser(user);
        callback.run();
    }
}
