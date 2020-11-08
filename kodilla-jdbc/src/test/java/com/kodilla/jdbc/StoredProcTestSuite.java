package com.kodilla.jdbc;

import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class StoredProcTestSuite {

    DbManager dbManager;
    Statement statement;

    @Before
    public void init() throws SQLException{
        dbManager = DbManager.getInstance();
        statement = dbManager.getConnection().createStatement();
    }

    @Test
    public void testUpdateVipLevels() throws SQLException {
        //Given
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL = \"Note set \"";
        statement.executeUpdate(sqlUpdate);
        //When
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement.execute(sqlProcedureCall);
        //Then
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL = \"Not Set\"";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
    }

    @Test
    public void testUpdateBestsellers() throws SQLException{
        //GIVEN
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER = \"0\"";
        statement.executeUpdate(sqlUpdate);
        //When
        String sqlCallProcedure = "CALL UpdateBestsellers()";
        statement.execute(sqlCallProcedure);
        //Then
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER =\"1\"";
        ResultSet resultSet = statement.executeQuery(sqlCheckTable);
        int howMany = - 1;
        if (resultSet.next()) {
            howMany = resultSet.getInt("HOW_MANY");
        }
        assertEquals(1,howMany);
    }
}
