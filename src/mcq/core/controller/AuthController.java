/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mcq.core.Callable;
import mcq.core.db.DBConnection;
import mcq.core.db.DBQuery;
import mcq.core.dto.RegisterDTO;
import mcq.core.exceptions.UserNotFoundException;
import mcq.core.services.AuthService;

/**
 *
 * @author samundra-sage
 */
public class AuthController {

    AuthService service;

    public AuthController() {
        this.service = new AuthService();
    }

    public void register(RegisterDTO registerDTO) {
        try {
            this.service.createUser(registerDTO);
        } catch (SQLException ex) {
            Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void login(String username, String password, Callable callable) throws SQLException, UserNotFoundException {
        this.service.login(username, password, callable);
    }

    
}
