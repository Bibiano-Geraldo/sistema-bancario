package sistemabancario.bancodadossimulacao;

import sistemabancario.aberturaconta.classes.AcEmail;
import sistemabancario.login.classes.LoginEmail;
import sistemabancario.movimentos.Depositos;
import sistemabancario.movimentos.Levantamentos;
import sistemabancario.movimentos.Transferencias;

public class BancoDadosSaldo {
    private static double saldo;

    public static double getSaldo() {
        setSaldo();
        return BancoDadosSaldo.saldo;
    }

    private static void setSaldo() {

        if (LoginEmail.getEmail().equals(BancoDadosNomePin.getEmail())) {

            BancoDadosSaldo.saldo = 4500 - Levantamentos.getConfirmarLevantamento()
                    - Transferencias.getConfirmarTransferencia() + Transferencias.getTransferenciaAc()
                    + Depositos.getDeposito();

        } else if (LoginEmail.getEmail().equals(AcEmail.getEmail())) {

            BancoDadosSaldo.saldo = 2000 - Levantamentos.getConfirmarLevantamentoAc()
                    - Transferencias.getConfirmarTransferenciaAc()
                    + Transferencias.getTransferencia()
                    + Depositos.getDepositoAc();
        }
    }
}
