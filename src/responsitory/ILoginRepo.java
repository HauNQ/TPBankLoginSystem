/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package responsitory;

import java.util.Locale;

/**
 *
 * @author Nguyen Quang Hau
 */
public interface ILoginRepo {

    void changeLanguage();

    boolean checkAccountNumber(String accNum);

    boolean checkThePassword(String password);

    String generateACapchaCode();

    boolean checkACapchaCode(String capcha,String tempCapcha);

    void operate(Locale locale);
}
