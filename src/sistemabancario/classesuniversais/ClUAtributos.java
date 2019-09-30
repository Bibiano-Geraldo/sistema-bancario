package sistemabancario.classesuniversais;

import java.util.Scanner;

public class ClUAtributos {
    private static int escolher;
    public Scanner scanner = new Scanner(System.in);

    public static int getEscolher() {
        return escolher;
    }

    protected static void setEscolher(int escolher) {
        ClUAtributos.escolher = escolher;
    }
}
