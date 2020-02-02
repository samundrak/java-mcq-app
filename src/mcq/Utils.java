package mcq;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author samundra-sage
 */
public class Utils {

    public static ArrayList<String[]> resultSetToCollection(ResultSet rs, String value) throws SQLException {
        ArrayList<String[]> ar = new ArrayList<>();
        while (rs.next()) {
            ar.add(new String[]{rs.getString("id"), rs.getString(value)});
        }
        return ar;
    }

}
