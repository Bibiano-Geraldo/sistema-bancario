package sistemabancario.movimentos;

import sistemabancario.aberturaconta.classes.AcEmail;
import sistemabancario.aberturaconta.classes.AcPin;
import sistemabancario.bancodadossimulacao.BancoDadosNomePin;
import sistemabancario.bancodadossimulacao.BancoDadosSaldo;
import sistemabancario.classesuniversais.OpcoesAceitarRecusar;
import sistemabancario.classesuniversais.PerguntaDesejaRectificar;
import sistemabancario.datasdosistema.DataHoraSistema;
import sistemabancario.login.classes.LoginEmail;
import sistemabancario.login.classes.LoginPin;
import sistemabancario.menuatm.MenuAtm;
import sistemabancario.paginainicial.PaginaInicial;

import java.text.NumberFormat;
import java.util.Locale;

public class Transferencias extends mAtributos {
    private PerguntaDesejaRectificar pDr = new PerguntaDesejaRectificar();
    private OpcoesAceitarRecusar oAR = new OpcoesAceitarRecusar();

    public void mTransferencias() {

        // inserindo o montante a transferir
        try {
            if ((LoginPin.getPin() == BancoDadosNomePin.getPin()
                    && LoginEmail.getEmail().equals(BancoDadosNomePin.getEmail()))) {

                do {

                    System.out.println("Quanto quer transferir?");
                    setTransferencia(scanner.nextDouble());

                    if (getTransferencia() < 10) {

                        System.out.println("Montante não disponível, deve transferir no mínimo 10 meticais.");
                        pDr.desejaRecificar();

                        if (PerguntaDesejaRectificar.getEscolher() == 2) {
                            MenuAtm menuAtm = new MenuAtm();
                            menuAtm.menuAtmStart();
                            break;
                        }

                    } else if (BancoDadosSaldo.getValor() < getTransferencia()) {

                        System.out.println("Conta sem saldo suficiente para esta operação");
                        pDr.desejaRecificar();

                        if (PerguntaDesejaRectificar.getEscolher() == 2) {
                            MenuAtm menuAtm = new MenuAtm();
                            menuAtm.menuAtmStart();
                            break;
                        }
                    }

                } while ((getTransferencia() < 10
                        || BancoDadosSaldo.getValor() < getTransferencia())
                        && PerguntaDesejaRectificar.getEscolher() == 1);

            } else if ((LoginPin.getPin() == AcPin.getPinNovo()
                    && LoginEmail.getEmail().equals(AcEmail.getEmail()))) {

                do {
                    System.out.println("Quanto quer transferir?");
                    setTransferenciaAc(scanner.nextDouble());

                    if (getTransferenciaAc() < 10) {

                        System.out.println("Montante não disponível, deve transferir no mínimo 10 meticais.");
                        pDr.desejaRecificar();

                        if (PerguntaDesejaRectificar.getEscolher() == 2) {
                            MenuAtm menuAtm = new MenuAtm();
                            menuAtm.menuAtmStart();
                            break;
                        }

                    } else if (BancoDadosSaldo.getValor() < getTransferenciaAc()) {

                        System.out.println("Conta sem saldo suficiente para esta operação");
                        pDr.desejaRecificar();

                        if (PerguntaDesejaRectificar.getEscolher() == 2) {
                            MenuAtm menuAtm = new MenuAtm();
                            menuAtm.menuAtmStart();
                            break;
                        }
                    }
                } while ((getTransferenciaAc() < 10
                        || BancoDadosSaldo.getValor() < getTransferenciaAc())
                        && PerguntaDesejaRectificar.getEscolher() == 1);
            }

        } catch (Exception e) {
            System.out.println("Entrada inválida, apenas dígitos numéricos são permitidos.");
            scanner.nextLine();
            mTransferencias();
        }

        //inserindo o email do destinatário
        do {
            System.out.println("Insira o email do destinatário");
            setEmailTransferir(scanner.next());

            if (getEmailTransferir().equals(LoginEmail.getEmail())) {
                System.out.println("Não pode transferir valores a si mesmo.");

                pDr.desejaRecificar();

                if (PerguntaDesejaRectificar.getEscolher() == 2) {
                    MenuAtm menuAtm = new MenuAtm();
                    menuAtm.menuAtmStart();
                    break;
                }

            } else if (!getEmailTransferir().equals(BancoDadosNomePin.getEmail())
                    && !getEmailTransferir().equals(AcEmail.getEmail())) {
                System.out.println("Endereço não encontrado no sistema.");

                pDr.desejaRecificar();

                if (PerguntaDesejaRectificar.getEscolher() == 2) {
                    MenuAtm menuAtm = new MenuAtm();
                    menuAtm.menuAtmStart();
                    break;
                }

            } else {

                // finalizando o processo
                if ((LoginPin.getPin() == BancoDadosNomePin.getPin()
                        && LoginEmail.getEmail().equals(BancoDadosNomePin.getEmail()))) {

                    setConfirmarTransferencia(getConfirmarTransferencia() + getTransferencia());
                }

                if ((LoginPin.getPin() == AcPin.getPinNovo()
                        && LoginEmail.getEmail().equals(AcEmail.getEmail()))) {

                    setConfirmarTransferenciaAc(getConfirmarTransferenciaAc() + getTransferenciaAc());
                }

                System.out.println("Deseja o recibo da transação?");
                oAR.aceitarOuRecusar();

                if (OpcoesAceitarRecusar.getEscolher() == 1) {
                    Locale locale = new Locale("", "MZ");
                    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
                    numberFormat.setMaximumFractionDigits(2);

                    if (getEmailTransferir().equals(BancoDadosNomePin.getEmail())) {

                        System.out.println("Estimado(a) cliente, foi registado uma transferência no valor de " +
                                numberFormat.format(getTransferenciaAc()));
                        System.out.println("Em " + DataHoraSistema.getDataPadrao() + ", as "
                                + DataHoraSistema.getHoraPadrao() + " para " + BancoDadosNomePin.getNome() +
                                " " + BancoDadosNomePin.getApelido() + ", " + getEmailTransferir() + ".");

                    } else if (getEmailTransferir().equals(AcEmail.getEmail())) {

                        System.out.println("Estimado(a) cliente, foi registado uma transferência no valor de " +
                                numberFormat.format(getTransferencia()));
                        System.out.println("Em " + DataHoraSistema.getDataPadrao() + ", as "
                                + DataHoraSistema.getHoraPadrao() + " para " + AcEmail.getNome() +
                                " " + AcEmail.getApelido() + ", " + getEmailTransferir() + ".");
                    }

                    System.out.println("Saldo disponível: " + BancoDadosSaldo.getSaldo());

                    setTransferencia(getConfirmarTransferencia());
                    setTransferenciaAc(getConfirmarTransferenciaAc());

                    for (int i = 0; i < 4; i++) {
                        try {
                            Thread.sleep(1000);
                        } catch (Exception ignored) {

                        }
                    }
                    if (getEmailTransferir().equals(LoginEmail.getEmail())) {
                        setConfirmarTransferencia(getTransferencia());

                    } else if (getEmailTransferir().equals(AcEmail.getEmail())) {
                        setConfirmarTransferencia(getTransferencia());
                    }

                    System.out.println("Pretende realizar mais alguma operação?");
                    oAR.aceitarOuRecusar();

                    if (OpcoesAceitarRecusar.getEscolher() == 1) {
                        MenuAtm menuAtm = new MenuAtm();
                        menuAtm.menuAtmStart();
                        break;

                    } else {
                        PaginaInicial paginaInicial = new PaginaInicial();
                        paginaInicial.paginaInicial();
                        break;
                    }

                } else {
                    MenuAtm menuAtm = new MenuAtm();
                    menuAtm.menuAtmStart();
                    break;
                }
            }
        } while ((getEmailTransferir().equals(LoginEmail.getEmail())
                || (!getEmailTransferir().equals(BancoDadosNomePin.getEmail())
                && !getEmailTransferir().equals(AcEmail.getEmail())))
                && PerguntaDesejaRectificar.getEscolher() == 1);
    }
}