package sistemabancario.bancodadossimulacao;

import sistemabancario.aberturaconta.classes.AcEmail;
import sistemabancario.login.classes.LoginEmail;
import sistemabancario.movimentos.Depositos;
import sistemabancario.movimentos.Levantamentos;
import sistemabancario.movimentos.Transferencias;

import java.text.NumberFormat;
import java.util.Locale;

public class BancoDadosSaldo {
    private static String saldo;
    private static double valor;

    public static String getSaldo() {
        setSaldo();
        return BancoDadosSaldo.saldo;
    }

    private static void setSaldo() {
        Locale locale = new Locale("", "MZ");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        numberFormat.setMaximumFractionDigits(2);

        if (LoginEmail.getEmail().equals(BancoDadosNomePin.getEmail())) {

            BancoDadosSaldo.saldo = numberFormat.format(getValor());

        } else if (LoginEmail.getEmail().equals(AcEmail.getEmail())) {

            BancoDadosSaldo.saldo = numberFormat.format(getValor());
        }
    }

    public static double getValor() {
        setValor();
        return valor;
    }

    private static void setValor() {

        if (LoginEmail.getEmail().equals(BancoDadosNomePin.getEmail())) {

            BancoDadosSaldo.valor = Depositos.getConfirmarDeposito()
                    + Transferencias.getConfirmarTransferenciaAc()
                    - Levantamentos.getConfirmarLevantamento()
                    - Transferencias.getConfirmarTransferencia();

        } else if (LoginEmail.getEmail().equals(AcEmail.getEmail())) {

            BancoDadosSaldo.valor = Depositos.getConfirmarDepositoAc()
                    + Transferencias.getConfirmarTransferencia()
                    - Levantamentos.getConfirmarLevantamentoAc()
                    - Transferencias.getConfirmarTransferenciaAc();
        }
    }
}
