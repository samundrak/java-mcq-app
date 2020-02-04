/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import mcq.core.interfaces.Repository;
import mcq.core.repositories.SubjectRepository;
import mcq.core.repositories.UserRepo;

/**
 *
 * @author samundra-sage
 */
public class User {

    Repository repo;

    public User() {
        this.repo = new UserRepo();
    }

    public ResultSet find(String[][] clause) throws SQLException {
        return this.repo.find(clause);
    }

    public int update(int userId, String username, String password) throws SQLException {
        return this.repo.update(new String[][]{{"username", username}, {"password", password}}, new String[][]{{"id", "=", userId + ""}});
    }
}
