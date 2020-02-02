/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author samundra-sage
 */
public class QueryBuilder {

    private String query = "";

    public QueryBuilder select(String[] selections) {
        this.reset();
        this.query += "select " + String.join(", ", selections);
        return this;
    }

    public QueryBuilder from(String[] tables) {
        this.query += " from " + String.join(",", tables);
        return this;
    }

    public QueryBuilder from(String table) {
        this.query += " from " + table;
        return this;
    }

    public QueryBuilder whereRaw(String raw) {
        this.query += " where " + raw;
        return this;
    }

    public QueryBuilder where(String clause) {
        if (!this.query.endsWith("where")) {
            this.query += " where ";
        }

        this.query += clause;
        return this;
    }

    public QueryBuilder andWhere(String clause) {
        this.query += " and " + clause + ",";
        return this;
    }

    public QueryBuilder where(String[][] clause) {
        this.query += " where ";
        String[] wheres = new String[clause.length];

        for (int i = 0; i < clause.length; i++) {
            wheres[i] = clause[i][0] + clause[i][1] + "'" + clause[i][2] + "'";
        }
        this.query += "" + String.join(" and ", (String[]) wheres);
        return this;
    }

    public String getQuery() {
        return this.query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public QueryBuilder insert(String table, String[][] columnsVals) {
        this.reset();
        this.query += "insert into " + table;
        String[] columns = new String[columnsVals.length];
        String[] values = new String[columnsVals.length];

        for (int i = 0; i < columnsVals.length; i++) {
            columns[i] = columnsVals[i][0];
            values[i] = "'" + columnsVals[i][1] + "'";
        }
        this.query += "(" + String.join(",", columns) + ")";
        this.query += " values(" + String.join(",", values) + ")";

        return this;
    }

    public QueryBuilder update(String table) {
        this.reset();
        this.query = "update " + table;
        return this;
    }

    public QueryBuilder delete(String table) {
        this.reset();
        this.query = "delete from " + table;
        return this;
    }

    public QueryBuilder set(String[][] values) {
        this.query += " set ";
        String[] sets = new String[values.length];

        for (int i = 0; i < values.length; i++) {
            sets[i] = values[i][0] + "=" + "'" + values[i][1] + "'";
        }

        this.query += String.join(",", sets);
        return this;
    }

    public QueryBuilder reset() {
        this.query = "";
        return this;
    }

//    public static void main(String[] s) {
//        QueryBuilder qb = new QueryBuilder();
//
////        qb.select(new String[]{"id", "name"}).from("users").where(new String[][]{{"id", "=", "3"}, {"name", "=", "2"}});
////        qb.insert("users", new String[][]{{"2", "1"}});
////        qb.update("users").set(new String[][]{{"name","samundra"}}).where(new String[][]{{"id","=","1"}});
//        qb.delete("users").where(new String[][]{{"id", "=", "1"}});
//
//        System.out.println(qb.query);
//    }
}
