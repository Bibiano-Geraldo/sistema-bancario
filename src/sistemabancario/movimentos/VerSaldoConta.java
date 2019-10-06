package sistemabancario.movimentos;

import sistemabancario.aberturaconta.classes.AcPin;
import sistemabancario.bancodadossimulacao.BancoDadosNomePin;
import sistemabancario.bancodadossimulacao.BancoDadosSaldo;
import sistemabancario.login.classes.LoginPin;
import sistemabancario.menuatm.MenuAtm;

public class VerSaldoConta {

    public void verSaldoConta() {
        if (BancoDadosNomePin.getPin() == LoginPin.getPin() || AcPin.getPinNovo() == LoginPin.getPin())
            System.out.println("Saldo disponível: " + BancoDadosSaldo.getSaldo());

        for (int i = 0; i < 2; i++) {

            try {
                Thread.sleep(1000);

            } catch (Exception ignored) {

            }
        }
        MenuAtm menuAtm = new MenuAtm();
        menuAtm.menuAtmStart();
    }
}
