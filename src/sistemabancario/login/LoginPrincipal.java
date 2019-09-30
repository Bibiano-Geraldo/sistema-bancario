package sistemabancario.login;

import sistemabancario.login.classes.LoginEmail;
import sistemabancario.login.classes.LoginPin;

public class LoginPrincipal {

    public void loginPrincipal(){
        LoginEmail loginEmail = new LoginEmail();
        LoginPin loginPin = new LoginPin();
        loginEmail.loginEmail();
        loginPin.loginPin();
    }
}
