/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.tests;

import mcq.core.services.QueryBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

/**
 *
 * @author samundra-sage
 */
public class QueryBuilderTest {

    mcq.core.services.QueryBuilder queryBuilder;

    @Before
    public void setup() {
        this.queryBuilder = new QueryBuilder();
        this.queryBuilder.reset();
    }

    @Test
    public void testInsertQuery() {
        String query = this.queryBuilder.insert("users", new String[][]{{"name", "samundra"}}).getQuery();
        assertEquals(query, "insert into users(name) values('samundra')");
    }

    @Test
    public void testSelectQuery() {
        String query = this.queryBuilder.select(new String[]{"*"})
                .from("users")
                .where(new String[][]{{"id", "=", "1"}, {"age", "<", "12"}})
                .getQuery();
        assertEquals(query, "select * from users where id='1' and age<'12'");
    }

    @Test
    public void testUpdateQuery() {
        String query = this.queryBuilder.update("questions").set(new String[][]{{"name", "samundra"}})
                .where(new String[][]{{"name", "=", "sam"}})
                .getQuery();
        assertEquals(query, "update questions set name='samundra' where name='sam'");

    }

    @Test
    public void testDeleteQuery() {
        String query = this.queryBuilder.delete("users")
                .where(new String[][]{{"name", "=", "sam"}})
                .getQuery();
        assertEquals(query, "delete from users where name='sam'");
    }

}
