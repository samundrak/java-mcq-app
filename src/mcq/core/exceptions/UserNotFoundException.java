/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.exceptions;

/**
 *
 * @author samundra-sage
 */
public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("Unable to find the user");
    }
}
