/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.services;

import mcq.core.dto.UserDto;

/**
 *
 * @author samundra-sage
 */
public class Session {

    UserDto user;
    public static Session INSTANCE;

    private Session() {

    }

    public void addUser(UserDto user) {
        this.user = user;
    }

    public static Session getInstance() {
        if (Session.INSTANCE == null) {
            Session.INSTANCE = new Session();
        }

        return Session.INSTANCE;
    }
}
