/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import mcq.core.db.DBConnection;
import mcq.core.db.DBQuery;
import mcq.core.services.Session;
import mcq.views.AdminDashboard;
import mcq.views.Login;
import mcq.views.Register;

/**
 *
 * @author samundra-sage
 */
public class MCQ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            DBConnection dBConnection = DBConnection.getInstance();
            Session session = Session.getInstance();
            dBConnection.connect("jdbc:mysql://localhost:3308/mcq?zeroDateTimeBehavior=convertToNull", "root", "root");
            new Login().show();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MCQ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MCQ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
