package sistemabancario.login.classes;

import sistemabancario.paginainicial.PaginaInicial;

import java.util.Scanner;

public class LoginAtributos {
    private static String email = "fugindo do null2";
    private static int pin;
    private static int block;
    private static int blockAc;
    protected PaginaInicial paginaInicial = new PaginaInicial();
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


    static int getBlock() {
        return block;
    }

    public static void setBlock(int block) {
        LoginAtributos.block = block;
    }

    static int getBlockAc() {
        return blockAc;
    }

    public static void setBlockAc(int blockAc) {
        LoginAtributos.blockAc = blockAc;
    }
}
