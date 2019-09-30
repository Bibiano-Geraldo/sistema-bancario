package sistemabancario.aberturaconta.classes;

import java.util.Calendar;
import java.util.Scanner;

class AcAtributos {
    private static String nome = "fugindo do null1";
    private static String apelido = "fugindo do null1";
    private static byte escolhaSexo;
    private static int anoUsuario;
    private static int diaUsuario;
    private static int mesUsuario;
    private static String email = "fugindo do null1";
    private static int pinNovo;
    private static int confirmPin;
    private Calendar calendar = Calendar.getInstance();
    private int anoActual = calendar.get(Calendar.YEAR);
    Scanner scanner = new Scanner(System.in);

    public static String getNome() {
        return nome.toUpperCase();
    }

    static void setNome(String nome) {
        AcAtributos.nome = nome;
    }

    public static String getApelido() {
        return apelido.toUpperCase();
    }

    static void setApelido(String apelido) {
        AcAtributos.apelido = apelido;
    }

    public static byte getEscolhaSexo() {
        return escolhaSexo;
    }

    static void setEscolhaSexo(byte escolha) {
        AcAtributos.escolhaSexo = escolha;
    }

    int getAnoActual() {
        return anoActual;
    }

    static int getAnoUsuario() {
        return anoUsuario;
    }

    static void setAnoUsuario(int anoUsuario) {
        AcAtributos.anoUsuario = anoUsuario;
    }

    static int getDiaUsuario() {
        return diaUsuario;
    }

    static void setDiaUsuario(int diaUsuario) {
        AcAtributos.diaUsuario = diaUsuario;
    }

    static int getMesUsuario() {
        return mesUsuario;
    }

    static void setMesUsuario(int mesUsuario) {
        AcAtributos.mesUsuario = mesUsuario;
    }

    public static String getEmail() {
        return email.toUpperCase();
    }

    static void setEmail(String email) {
        AcAtributos.email = email;
    }

    public static int getPinNovo() {
        return pinNovo;
    }

    static void setPinNovo(int pinNovo) {
        AcAtributos.pinNovo = pinNovo;
    }

    static int getConfirmPin() {
        return confirmPin;
    }

    static void setConfirmPin(int confirmPin) {
        AcAtributos.confirmPin = confirmPin;
    }
}
