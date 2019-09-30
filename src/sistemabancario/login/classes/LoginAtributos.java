package sistemabancario.login.classes;

import java.util.Scanner;

public class LoginAtributos {
    private static String email = "fugindo do null2";
    private static int pin;
    Scanner scanner = new Scanner(System.in);

    public static String getEmail() {
        return email.toUpperCase();
    }

    static void setEmail(String email) {
        LoginAtributos.email = email;
    }

    public static int getPin() {
        return pin;
    }

    static void setPin(int pin) {
        LoginAtributos.pin = pin;
    }
}
