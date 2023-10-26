/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory;

import dao.JDBCUtill;
import dao.UserDao;
import java.util.Scanner;
import model.User;
import java.sql.*;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Quang Hau
 */
public class LoginRepo implements ILoginRepo {

    private ResourceBundle rb;
    private User user;

    public LoginRepo() {
        user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void changeLanguage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean checkAccountNumber(String accNum) {
        if (accNum.matches("\\d{10}")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkThePassword(String password) {
        if (password.matches("[0-9a-zA-Z]{8,31}") && !password.matches("\\d{" + password.length() + "}") && !password.matches("[a-zA-Z]{" + password.length() + "}")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String generateACapchaCode() {
        Random rd = new Random();
        String saltChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder(6);
        while (sb.length() < 6) {
            sb.append(saltChar.charAt(rd.nextInt(0, saltChar.length() - 1)));
        }
        return sb.toString();
    }

    @Override
    public boolean checkACapchaCode(String capcha, String tempCapcha) {
        return capcha.equals(tempCapcha);
    }

    @Override
    public void operate(Locale locale) {
        Scanner sc = new Scanner(System.in);
        rb = ResourceBundle.getBundle("resource", locale);
        
        String accNum = "";
        String password = "";
        String capcha = "";

        while (true) {
            System.out.print(rb.getString("EnterAccountNumber"));
            accNum = sc.nextLine();
            if (checkAccountNumber(accNum)) {
                break;
            } else {
                System.err.println(rb.getString("InputtingAccNumErr"));
            }
        }

        while (true) {
            System.out.print(rb.getString("EnterPassword"));
            password = sc.nextLine();
            if (checkThePassword(password)) {
                break;
            } else {
                System.err.println(rb.getString("InputtingPWErr"));
            }
        }

        while (true) {
            String tempCapcha = generateACapchaCode();
            System.out.println(rb.getString("EnterCapcha")+"" + tempCapcha);
            System.out.print(rb.getString("EnterAboveCapcha"));
            capcha = sc.nextLine();
            if (checkACapchaCode(capcha, tempCapcha)) {
                break;
            } else {
                System.err.println(rb.getString("InputtingCapchaErr"));
            }
        }

        // check if the user is existing on database
        if (UserDao.getInstance().selectUserByAccAndPassword(accNum, password) != null) {
            System.out.println(rb.getString("LoginSucessStatus"));
        } else {
            System.err.println(rb.getString("LoginFailureStatus"));
        }
    }

    public static void main(String[] args) {
        LoginRepo loginRepo = new LoginRepo();
        Scanner sc = new Scanner(System.in);
        
//        Locale locale = Locale.US;
Locale locale = new Locale("vi", "VN");
        ResourceBundle rb = ResourceBundle.getBundle("resource",locale);
        System.out.println(locale.getLanguage());
        System.out.println(locale.getCountry());
        System.out.println(rb.getString("EnterAccountNumber"));
    }

}
