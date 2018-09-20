package com.dawang;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.lang.reflect.Method;


public class MstrInformix {


    public static void main(String[] args) throws ClassNotFoundException,NoSuchMethodException, IllegalAccessException,InvocationTargetException, SQLException{

        String driver = "com.microstrategy.jdbc.informix.InformixDriver";

        String url = "jdbc:microstrategy:informix://10.27.10.105:65535;INFORMIXSERVER=informix;DATABASE=tpch;QueryTimeout=-1";
        String user = "tpch";
        String password = "tpch";

        Connection conn = null;
        Connection connection = null;
        Class.forName(driver);
        connection = DriverManager.getConnection(url, user, password);
        Class extEmbeddedConClazz = Class.forName("com.ddtek.jdbc.extensions.ExtEmbeddedConnection");

        if (extEmbeddedConClazz != null && extEmbeddedConClazz.isInstance(connection)) {
            Object embeddedCon = extEmbeddedConClazz.cast(connection);
            Method method = extEmbeddedConClazz.getMethod("unlock", String.class);
            method.invoke(embeddedCon, "INTERSOLVcLOseDdRivers7h");

            Statement stmt = connection.createStatement();
            String sql = "select * from nation";

            //String sql = "select count(*) from orders";
            //PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(sql);
            //pstmt.setQueryTimeout(-1);
            stmt.setQueryTimeout(-1);
            ResultSet rs = stmt.executeQuery(sql);
            int col = rs.getMetaData().getColumnCount();
            while (rs.next()){
                for (int i=1;i<=col;i++) {
                    System.out.print(rs.getString(i)+'\t');

                }
                System.out.print("\n");
            }

        }


    }
}
