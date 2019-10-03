package sistemabancario.movimentos;

import java.util.Scanner;

public class mAtributos {
    private static double levantamentos;
    private static double levantamentosAc;
    private static double confirmarLevantamento;
    private static double confirmarLevantamentoAc;
    private static double transferencia;
    private static double transferenciaAc;
    private static double confirmarTransferencia;
    private static double confirmarTransferenciaAc;
    private static double deposito;
    private static double depositoAc;
    private static double confirmarDeposito;
    private static double confirmarDepositoAc;
    private static String emailTransferir = "fugindo do null";
    private static String emailDepositar = "fugindo do null";
    Scanner scanner = new Scanner(System.in);

    static double getLevantamentos() {
        return levantamentos;
    }

    static void setLevantamentos(double levantamentos) {
        mAtributos.levantamentos = levantamentos;
    }

    public static double getConfirmarLevantamentoAc() {
        return confirmarLevantamentoAc;
    }

    static void setConfirmarLevantamentoAc(double confirmarLevantamentoAc) {
        mAtributos.confirmarLevantamentoAc = confirmarLevantamentoAc;
    }

    public static double getConfirmarLevantamento() {
        return confirmarLevantamento;
    }

    static void setConfirmarLevantamento(double confirmarLevantamento) {
        mAtributos.confirmarLevantamento = confirmarLevantamento;
    }

    static double getTransferencia() {
        return transferencia;
    }

    static void setTransferencia(double transferencia) {
        mAtributos.transferencia = transferencia;
    }

    public static double getConfirmarTransferencia() {
        return confirmarTransferencia;
    }

    static void setConfirmarTransferencia(double confirmarTransferencia) {
        mAtributos.confirmarTransferencia = confirmarTransferencia;
    }

    static String getEmailTransferir() {
        return emailTransferir.toUpperCase();
    }

    static void setEmailTransferir(String emailTransferir) {
        mAtributos.emailTransferir = emailTransferir;
    }

    static double getDeposito() {
        return deposito;
    }

    static void setDeposito(double deposito) {
        mAtributos.deposito = deposito;
    }

    public static double getConfirmarDeposito() {
        return confirmarDeposito;
    }

    static void setConfirmarDeposito(double confirmarDeposito) {
        mAtributos.confirmarDeposito = confirmarDeposito;
    }

    public static double getConfirmarTransferenciaAc() {
        return confirmarTransferenciaAc;
    }

    static void setConfirmarTransferenciaAc(double confirmarTransferenciaAc) {
        mAtributos.confirmarTransferenciaAc = confirmarTransferenciaAc;
    }

    public static double getConfirmarDepositoAc() {
        return confirmarDepositoAc;
    }

    static void setConfirmarDepositoAc(double confirmarDepositoAc) {
        mAtributos.confirmarDepositoAc = confirmarDepositoAc;
    }

    static String getEmailDepositar() {
        return emailDepositar.toUpperCase();
    }

    static void setEmailDepositar(String emailDepositar) {
        mAtributos.emailDepositar = emailDepositar;
    }

    static double getLevantamentosAc() {
        return levantamentosAc;
    }

    static void setLevantamentosAc(double levantamentosAc) {
        mAtributos.levantamentosAc = levantamentosAc;
    }

    static double getTransferenciaAc() {
        return transferenciaAc;
    }

    static void setTransferenciaAc(double transferenciaAc) {
        mAtributos.transferenciaAc = transferenciaAc;
    }

    static double getDepositoAc() {
        return depositoAc;
    }

    static void setDepositoAc(double depositoAc) {
        mAtributos.depositoAc = depositoAc;
    }
}
