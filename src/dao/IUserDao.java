/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.User;

/**
 *
 * @author Nguyen Quang Hau
 */
public interface IUserDao {

    boolean insert(User user);

    boolean delete(User user);

    User selectUserByAccAndPassword(String accNum, String password);

    List<User> selectAll(User user);

    boolean update(User user);

}
