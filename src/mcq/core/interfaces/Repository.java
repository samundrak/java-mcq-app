/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author samundra-sage
 */
public interface Repository {

    public ResultSet all() throws SQLException;

    public int deleteById(int id) throws SQLException;

    public ResultSet findOne(String[][] clause) throws SQLException;
    
    public int create(String[][] columnVals) throws SQLException;
}
