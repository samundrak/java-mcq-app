/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.services;

import mcq.core.db.DBConnection;
import mcq.core.db.DBQuery;

/**
 *
 * @author samundra-sage
 */
public abstract class DBConnected {

    protected  QueryBuilder queryBuilder;
    protected DBConnection dbConnection;
    protected DBQuery dbq;

    public DBConnected() {
        this.dbConnection = DBConnection.getInstance();
        this.dbq = new DBQuery(this.dbConnection.getConnection());
        this.queryBuilder = new QueryBuilder();
    }
}
