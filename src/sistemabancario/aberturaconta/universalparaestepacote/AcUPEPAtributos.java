package sistemabancario.aberturaconta.universalparaestepacote;

import java.util.Scanner;

public class AcUPEPAtributos {
    private static int escolher;
    Scanner scanner = new Scanner(System.in);

    public static int getEscolher() {
        return escolher;
    }

    static void setEscolher(int escolher) {
        AcUPEPAtributos.escolher = escolher;
    }
}
