/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mcq.core.interfaces.Repository;
import mcq.core.repositories.SubjectRepository;

/**
 *
 * @author samundra-sage
 */
public class Subject extends DBConnected {
    
    Repository repo;
    
    public Subject() {
        super();
        this.repo = new SubjectRepository();
    }
    
    public int addSubject(String name) throws SQLException {
        String query = "insert into subjects(`name`) values('" + name + "')";
        return this.dbq.updateQuery(query);
    }
    
    public ResultSet all() throws SQLException {
        return this.repo.all();
    }
    
    public int deleteById(int id) throws SQLException {
        return this.repo.deleteById(id);
    }
    
    public ResultSet getSubjectIdByName(String id) throws SQLException {
        ResultSet rs = this.repo.findOne(new String[][]{{"name", "=", id + ""}});
        
        return rs;
    }
    
    public ResultSet getSubjectById(int id) throws SQLException {
        return this.dbq.execQuery(this.queryBuilder.select(new String[]{"id"})
                .from("users")
                .whereRaw("id='" + id + "'")
                .getQuery());
    }
    
    public int updateSubjectById(int subjectId, String subject) throws SQLException {
        return this.dbq.updateQuery("update subjects set name='" + subject + "' where id=" + subjectId);
        
    }
}
