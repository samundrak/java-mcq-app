/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author samundra-sage
 */
public class SubjectRepository extends BaseRepo {

    @Override
    public String getTableName() {
        return "subjects";
    }

   

}
