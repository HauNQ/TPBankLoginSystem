/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.Locale;
import responsitory.LoginRepo;
import view.Menu;

/**
 *
 * @author Nguyen Quang Hau
 */
public class LoginProgramimng extends Menu<String>{
    private LoginRepo loginRepo;

    public LoginProgramimng() {
        super("Login Program",new String[]{"Vietnamese.","English.","Exit."});
        loginRepo = new LoginRepo();
    }
    
    
    @Override
    public void excute(int n) {
        switch (n) {
            case 1 -> loginRepo.operate(new Locale("vi", "VN"));
            case 2 -> loginRepo.operate(Locale.US);
        }
    }
    
}
