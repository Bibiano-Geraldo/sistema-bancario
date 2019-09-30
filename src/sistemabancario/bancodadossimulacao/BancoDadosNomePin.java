package sistemabancario.bancodadossimulacao;

import sistemabancario.aberturaconta.classes.AcPin;
import sistemabancario.recuperaçãodopin.PinRecover;

public class BancoDadosNomePin {
    private static int pin;

    public static String getNome() {
        return "Bibiano Geraldo".toUpperCase();
    }

    public static String getApelido() {
        return "Mangue".toUpperCase();
    }

    public static String getEmail() {
        return "Bibiano@java.com".toUpperCase();
    }

    public static int getSexo() {
        return 1; // 1 masculino, 2 femenino
    }

    public static int getPin() {
        setPin();
        return pin;
    }

    private static void setPin() {

        if (PinRecover.getEmail().equals(getEmail())
                && PinRecover.getNomeCompleto().equals(getNome().
                concat(" " + getApelido()))) {

            setPin(AcPin.getPinNovo());

        } else {
            BancoDadosNomePin.pin = 2525;
        }
    }

    private static void setPin(int pin) {
        BancoDadosNomePin.pin = pin;
    }

}
