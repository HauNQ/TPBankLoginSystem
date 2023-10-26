/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import model.User;

/**
 *
 * @author Nguyen Quang Hau
 */
public class UserDao implements IUserDao {
    private static UserDao instance;
    
    public static UserDao getInstance(){
       if(instance == null){
           synchronized (UserDao.class) {
               if(instance == null) instance = new UserDao();
           }
       }
       return instance;
    }
   

    @Override
    public boolean insert(User user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(User user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User selectUserByAccAndPassword(String accNum, String password) {
        User selectedUser = null;
        try {
            Connection conn = JDBCUtill.getConnection();
            String selectStr = "select * from TPBankUser where accountNumber=? and passwordU=?";
            PreparedStatement st = conn.prepareStatement(selectStr);
            st.setString(1, accNum);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String sId = rs.getString(1);
                String sAccNum = rs.getString(2);
                String sPassword = rs.getString(3);
                String sCapcha = rs.getString(4);
                selectedUser = new User(sAccNum, sPassword, sCapcha);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return selectedUser;
    }

    @Override
    public List<User> selectAll(User user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(User user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
