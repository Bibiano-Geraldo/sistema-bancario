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

public class Transferencias extends mAtributos {
    private PerguntaDesejaRectificar pDr = new PerguntaDesejaRectificar();
    private OpcoesAceitarRecusar oAR = new OpcoesAceitarRecusar();

    public void mTransferencias() {

        do {
            try {
                // inserindo o montante a transferir
                if ((LoginPin.getPin() == BancoDadosNomePin.getPin()
                        && LoginEmail.getEmail().equals(BancoDadosNomePin.getEmail()))) {
                    System.out.println("Quanto quer transferir?");
                    setTransferencia(scanner.nextDouble());
                }

                if ((LoginPin.getPin() == AcPin.getPinNovo()
                        && LoginEmail.getEmail().equals(AcEmail.getEmail()))) {
                    System.out.println("Quanto quer transferir?");
                    setTransferenciaAc(scanner.nextDouble());
                }

                if ((LoginPin.getPin() == BancoDadosNomePin.getPin()
                        && LoginEmail.getEmail().equals(BancoDadosNomePin.getEmail()))
                        || (LoginPin.getPin() == AcPin.getPinNovo()
                        && LoginEmail.getEmail().equals(AcEmail.getEmail()))) {

                    if (getTransferencia() < 10 && getTransferenciaAc() < 10) {
                        setTransferencia(0);
                        setTransferenciaAc(0);
                        System.out.println("Montante não disponível, deve transferir no mínimo 10 meticais.");
                        pDr.desejaRecificar();

                        if (PerguntaDesejaRectificar.getEscolher() == 2) {
                            MenuAtm menuAtm = new MenuAtm();
                            menuAtm.menuAtmStart();
                            break;
                        }

                    } else if (BancoDadosSaldo.getSaldo() < getTransferencia()
                            && BancoDadosSaldo.getSaldo() < getTransferenciaAc()) {
                        System.out.println("Conta sem saldo suficiente para esta operação");
                        pDr.desejaRecificar();

                        if (PerguntaDesejaRectificar.getEscolher() == 2) {
                            MenuAtm menuAtm = new MenuAtm();
                            menuAtm.menuAtmStart();
                            break;
                        }

                    } else {

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

                                    if (getEmailTransferir().equals(BancoDadosNomePin.getEmail())) {
                                        System.out.println("Estimado(a) cliente, foi registado uma transferência no valor de " +
                                                getTransferenciaAc() + " MZN,");
                                        System.out.println("Em " + DataHoraSistema.getDataPadrao() + ", as "
                                                + DataHoraSistema.getHoraPadrao() + " para " + BancoDadosNomePin.getNome() +
                                                " " + BancoDadosNomePin.getApelido() + ", " + getEmailTransferir() + ".");

                                    } else if (getEmailTransferir().equals(AcEmail.getEmail())) {
                                        System.out.println("Estimado(a) cliente, foi registado uma transferência no valor de " +
                                                getTransferencia() + " MZN,");
                                        System.out.println("Em " + DataHoraSistema.getDataPadrao() + ", as "
                                                + DataHoraSistema.getHoraPadrao() + " para " + AcEmail.getNome() +
                                                " " + AcEmail.getApelido() + ", " + getEmailTransferir() + ".");
                                    }

                                    System.out.println("Saldo disponível: " + BancoDadosSaldo.getSaldo() + " MZN");

                                    for (int i = 0; i < 4; i++) {
                                        try {
                                            Thread.sleep(1000);
                                        } catch (Exception ignored) {

                                        }
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

            } catch (Exception e) {
                System.out.println("Entrada inválida, apenas dígitos numéricos são permitidos.");
                scanner.nextLine();
                mTransferencias();
                break;

            }
        } while (((getTransferencia() < 10 && getTransferenciaAc() < 10)
                || (BancoDadosSaldo.getSaldo() < getTransferencia()
                && BancoDadosSaldo.getSaldo() < getTransferenciaAc()))
                && PerguntaDesejaRectificar.getEscolher() == 1);
    }
}