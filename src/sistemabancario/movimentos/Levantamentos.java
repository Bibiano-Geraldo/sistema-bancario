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

public class Levantamentos extends mAtributos {
    private PerguntaDesejaRectificar pDr = new PerguntaDesejaRectificar();
    private OpcoesAceitarRecusar oAR = new OpcoesAceitarRecusar();

    public void mLevantamentos() {
        do {
            try {
                if ((LoginPin.getPin() == BancoDadosNomePin.getPin()
                        && LoginEmail.getEmail().equals(BancoDadosNomePin.getEmail()))) {

                    System.out.println("Quanto deseja levantar?");
                    setLevantamentos(scanner.nextDouble());
                }

                if ((LoginPin.getPin() == AcPin.getPinNovo()
                        && LoginEmail.getEmail().equals(AcEmail.getEmail()))) {

                    System.out.println("Quanto deseja levantar?");
                    setLevantamentosAc(scanner.nextDouble());
                }

                if ((LoginPin.getPin() == BancoDadosNomePin.getPin()
                        && LoginEmail.getEmail().equals(BancoDadosNomePin.getEmail()))
                        || (LoginPin.getPin() == AcPin.getPinNovo()
                        && LoginEmail.getEmail().equals(AcEmail.getEmail()))) {

                    if (getLevantamentos() < 100 && getLevantamentosAc() < 100) {

                        System.out.println("Montante não disponível, deve levantar no mínimo 100 meticais.");
                        pDr.desejaRecificar();

                        if (PerguntaDesejaRectificar.getEscolher() == 2) {
                            MenuAtm menuAtm = new MenuAtm();
                            menuAtm.menuAtmStart();
                            break;
                        }

                    } else if (getLevantamentosAc() < 100 && getLevantamentos() < 100) {

                        System.out.println("Montante não disponível, deve levantar no mínimo 100 meticais.");
                        pDr.desejaRecificar();

                        if (PerguntaDesejaRectificar.getEscolher() == 2) {
                            MenuAtm menuAtm = new MenuAtm();
                            menuAtm.menuAtmStart();
                            break;
                        }

                    } else if (BancoDadosSaldo.getSaldo() < getLevantamentos()
                            || getLevantamentos() % 100 != 0) {

                        if (getLevantamentos() % 100 != 0) {

                            System.out.println("Motante não disponível, Apenas notas de 100, 200, 500 e, 1000 meticais " +
                                    "estão disponíveis.");

                        } else {
                            System.out.println("Conta sem saldo suficiente para esta operação");
                        }

                        pDr.desejaRecificar();

                        if (PerguntaDesejaRectificar.getEscolher() == 2) {

                            MenuAtm menuAtm = new MenuAtm();
                            menuAtm.menuAtmStart();
                            break;
                        }

                    } else if (BancoDadosSaldo.getSaldo() < getLevantamentosAc()
                            || getLevantamentosAc() % 100 != 0) {

                        if (getLevantamentosAc() % 100 != 0) {

                            System.out.println("Motante não disponível, Apenas notas de 100, 200, 500 e, 1000 meticais " +
                                    "estão disponíveis.");

                        } else {
                            System.out.println("Conta sem saldo suficiente para esta operação");
                        }

                        pDr.desejaRecificar();

                        if (PerguntaDesejaRectificar.getEscolher() == 2) {

                            MenuAtm menuAtm = new MenuAtm();
                            menuAtm.menuAtmStart();
                            break;
                        }

                    } else if (getLevantamentos() > 5000) {
                        setLevantamentos(0);

                        System.out.println("Montante não disponível, deve levantar no máximo 5000 meticais P/dia.");
                        pDr.desejaRecificar();

                        if (PerguntaDesejaRectificar.getEscolher() == 2) {

                            MenuAtm menuAtm = new MenuAtm();
                            menuAtm.menuAtmStart();
                            break;
                        }

                    } else if (getLevantamentosAc() > 5000) {
                        setLevantamentosAc(0);

                        System.out.println("Montante não disponível, deve levantar no máximo 5000 meticais P/dia.");
                        pDr.desejaRecificar();

                        if (PerguntaDesejaRectificar.getEscolher() == 2) {

                            MenuAtm menuAtm = new MenuAtm();
                            menuAtm.menuAtmStart();
                            break;
                        }


                    } else {

                        if ((LoginPin.getPin() == BancoDadosNomePin.getPin()
                                && LoginEmail.getEmail().equals(BancoDadosNomePin.getEmail()))) {
                            setConfirmarLevantamento(getConfirmarLevantamento() + getLevantamentos());
                        }

                        if ((LoginPin.getPin() == AcPin.getPinNovo()
                                && LoginEmail.getEmail().equals(AcEmail.getEmail()))) {
                            setConfirmarLevantamentoAc(getConfirmarLevantamentoAc() + getLevantamentosAc());
                        }

                        System.out.println("Deseja o recibo da transação?");
                        oAR.aceitarOuRecusar();

                        if (OpcoesAceitarRecusar.getEscolher() == 1) {

                            if (LoginPin.getEmail().equals(BancoDadosNomePin.getEmail())) {

                                System.out.println("Estimado(a) cliente, foi registado um levantamento no valor de " +
                                        getLevantamentos() + " MZN,");
                                System.out.println("Em " + DataHoraSistema.getDataPadrao() + ", as "
                                        + DataHoraSistema.getHoraPadrao() + " através do email " + LoginEmail.getEmail() + ".");
                                System.out.println("Saldo disponível: " + BancoDadosSaldo.getSaldo() + " MZN");

                            } else if (LoginPin.getEmail().equals(AcEmail.getEmail())) {

                                System.out.println("Estimado(a) cliente, foi registado um levantamento no valor de " +
                                        getLevantamentosAc() + " MZN,");
                                System.out.println("Em " + DataHoraSistema.getDataPadrao() + ", as "
                                        + DataHoraSistema.getHoraPadrao() + " através do email " + LoginEmail.getEmail() + ".");
                                System.out.println("Saldo disponível: " + BancoDadosSaldo.getSaldo() + " MZN");

                            }
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
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida, apenas dígitos numéricos são permitidos, " +
                        "tente novamente:");
                scanner.nextLine();
                mLevantamentos();
                break;
            }

        } while ((((getLevantamentos() < 100 && getLevantamentosAc() < 100)
                || (getLevantamentos() > 5000 || getLevantamentosAc() > 5000)
                || (BancoDadosSaldo.getSaldo() < getLevantamentos()
                || BancoDadosSaldo.getSaldo() < getLevantamentosAc()))
                || (getLevantamentosAc() % 100 != 0 || getLevantamentos() % 100 != 0))
                && PerguntaDesejaRectificar.getEscolher() == 1);
    }
}
