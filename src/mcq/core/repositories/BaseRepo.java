/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mcq.core.interfaces.Repository;
import java.sql.SQLException;
import mcq.core.interfaces.HasTableName;
import mcq.core.services.DBConnected;
import mcq.core.services.QueryBuilder;

/**
 *
 * @author samundra-sage
 */
abstract class BaseRepo extends DBConnected implements Repository {

    public abstract String getTableName();

    @Override
    public ResultSet find(String[] selection, String[][] clause) throws SQLException {
        String query = this.queryBuilder.select(selection)
                .from(this.getTableName())
                .where(clause)
                .getQuery();
        return this.dbq.execQuery(query);
    }

    public ResultSet find(String[][] clause) throws SQLException {
        String query = this.queryBuilder.select(new String[]{"*"})
                .from(this.getTableName())
                .where(clause)
                .getQuery();
        return this.dbq.execQuery(query);
    }

    @Override
    public ResultSet all() throws SQLException {
        return this.dbq.execQuery(this.queryBuilder
                .select(new String[]{"*"})
                .from(this.getTableName())
                .getQuery());
    }

    @Override
    public int deleteById(int id) throws SQLException {
        return this.dbq.updateQuery(this.queryBuilder.delete(this.getTableName())
                .whereRaw("id='" + id + "'")
                .getQuery());
    }

    @Override
    public ResultSet findOne(String[][] clause) throws SQLException {
        String query = this.queryBuilder.select(new String[]{"*"})
                .from(this.getTableName())
                .where(clause)
                .getQuery();
        PreparedStatement ps = this.dbConnection.getConnection().prepareStatement(query);
        ps.setMaxRows(1);
        return ps.executeQuery(query);
    }

    @Override
    public ResultSet findOne(String[] selection, String[][] clause) throws SQLException {
        String query = this.queryBuilder.select(selection)
                .from(this.getTableName())
                .where(clause)
                .getQuery();
        PreparedStatement ps = this.dbConnection.getConnection().prepareStatement(query);
        ps.setMaxRows(1);
        return ps.executeQuery(query);
    }

    @Override
    public int create(String[][] columnVals) throws SQLException {
        String query = this.queryBuilder.insert(this.getTableName(), columnVals).getQuery();
        System.out.println(query);
        return this.dbq.updateQuery(query);
    }

    public int update(String[][] columnVals, String[][] whereClause) throws SQLException {
        String query = this.queryBuilder.update(this.getTableName()).set(columnVals)
                .where(whereClause)
                .getQuery();
        return this.dbq.updateQuery(query);
    }

}
