
package com.dawang;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.lang.reflect.Method;


public class NativeInformix {


    public static void main(String[] args) throws ClassNotFoundException,NoSuchMethodException, IllegalAccessException,InvocationTargetException, SQLException{

        String driver = "com.informix.jdbc.IfxDriver";

        String url = "jdbc:informix-sqli://10.27.10.105:65535/tpch:INFORMIXSERVER=informix";
        String user = "tpch";
        String password = "tpch";

        Connection conn = null;
        Connection connection = null;
        Class.forName(driver);
        connection = DriverManager.getConnection(url, user, password);
        Statement stmt = connection.createStatement();
        //String sql_a = "select a11.O_ORDERKEY  O_ORDERKEY, TODAY  WJXBFS1, (a11.O_ORDERDATE + 2.0 UNITS DAY)  WJXBFS2 from ORDERS a11 where a11.O_ORDERKEY < 20 into temp ZZMD00 with no log ";
        String sql_a = "drop table ff_test";
        String sql= "select * from DataMartTest";
        PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(sql);
        //pstmt.setQueryTimeout(-1);
        //stmt.setQueryTimeout(-1);
        int result = stmt.executeUpdate(sql_a);
        System.out.println(result);
        ResultSet rs = pstmt.executeQuery();
        int col = rs.getMetaData().getColumnCount();
        while (rs.next()){
            for (int i=1;i<=col;i++) {
                System.out.print(rs.getString(i)+'\t');

            }
            System.out.print("\n");
        }

    }


}
