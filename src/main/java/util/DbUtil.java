package util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
    private static DataSource ds;

    static {
        try {
            Context inContext = new InitialContext();
            ds = (DataSource) inContext.lookup("java:/comp/env/jdbc/myoracle");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void dbClose(Connection con, Statement st, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            dbClose(con, st);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dbClose(Connection con, Statement st) {
        try {
            if (con != null) con.close();
            if (st != null) st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	
}