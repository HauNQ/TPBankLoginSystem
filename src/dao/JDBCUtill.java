/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;

/**
 *
 * @author Nguyen Quang Hau
 */
public class JDBCUtill {

    public static Connection getConnection() throws ClassNotFoundException {
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://ACERNITRO5\\SQLEXPRESS:1433;"
                + "database=TPBankDatabase;"
                + "user=sa;"
                + "password=112233;"
                + "encrypt=false;"
                + "trustServerCertificate=false;"
                + "loginTimeout=30;";
        Statement stm = null;
        try {
            Connection conn = DriverManager.getConnection(connectionUrl);
            if (conn != null) {
                return conn;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        try {
            Connection conn = JDBCUtill.getConnection();
            String selectStr = "select * from TPBankUser where accountNumber=? and passwordU=?";
            PreparedStatement st = conn.prepareStatement(selectStr);
            st.setString(1, "9922450001");
            st.setString(2, "cuShin555");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String accNum = rs.getString(2);
                String password = rs.getString(3);
                String capcha = rs.getString(4);
                System.out.println(id + ":" + accNum + ":" + password + ":" + capcha);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
