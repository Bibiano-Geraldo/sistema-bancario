package sistemabancario.movimentos;

import sistemabancario.aberturaconta.classes.AcEmail;
import sistemabancario.bancodadossimulacao.BancoDadosNomePin;
import sistemabancario.classesuniversais.OpcoesAceitarRecusar;
import sistemabancario.classesuniversais.PerguntaDesejaRectificar;
import sistemabancario.datasdosistema.DataHoraSistema;
import sistemabancario.menubalcao.MenuBalcao;
import sistemabancario.paginainicial.PaginaInicial;

import java.text.NumberFormat;
import java.util.Locale;

public class Depositos extends mAtributos {
    private PerguntaDesejaRectificar pDr = new PerguntaDesejaRectificar();
    private OpcoesAceitarRecusar oAR = new OpcoesAceitarRecusar();

    public void mDeposito() {

        do {
            try {
                do {
                    System.out.println("Insira o email do destinatário");
                    setEmailDepositar(scanner.next());

                    if (!getEmailDepositar().equals(BancoDadosNomePin.getEmail())
                            && !getEmailDepositar().equals(AcEmail.getEmail())) {
                        System.out.println("Endereço não encontrado no sistema.");

                        pDr.desejaRecificar();

                        if (PerguntaDesejaRectificar.getEscolher() == 2) {
                            MenuBalcao menuBalcao = new MenuBalcao();
                            menuBalcao.menuBalcao();
                            break;
                        }

                    } else {

                        if (getEmailDepositar().equals(BancoDadosNomePin.getEmail())) {
                            System.out.println("Quanto quer depositar?");
                            setDeposito(scanner.nextDouble());
                        }

                        if (getEmailDepositar().equals(AcEmail.getEmail())) {
                            System.out.println("Quanto quer depositar?");
                            setDepositoAc(scanner.nextDouble());
                        }

                        if (getEmailDepositar().equals(BancoDadosNomePin.getEmail())
                                || getEmailDepositar().equals(AcEmail.getEmail())) {

                            if (getDeposito() < 10 && getDepositoAc() < 10) {
                                setDeposito(0);
                                setDepositoAc(0);
                                System.out.println("Montante não permitido, deve depositar no mínimo 10 meticais.");
                                pDr.desejaRecificar();

                                if (PerguntaDesejaRectificar.getEscolher() == 2) {
                                    MenuBalcao menuBalcao = new MenuBalcao();
                                    menuBalcao.menuBalcao();
                                    break;
                                }
                            }
                        }

                        // finalizando o processo
                        if (getEmailDepositar().equals(BancoDadosNomePin.getEmail())) {
                            setConfirmarDeposito(getConfirmarDeposito() + getDeposito());
                        }

                        if (getEmailDepositar().equals(AcEmail.getEmail())) {
                            setConfirmarDepositoAc(getConfirmarDepositoAc() + getDepositoAc());
                        }

                        System.out.println("Deseja o recibo da transação?");
                        oAR.aceitarOuRecusar();

                        if (OpcoesAceitarRecusar.getEscolher() == 1) {
                            Locale locale = new Locale("", "MZ");
                            NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
                            numberFormat.setMaximumFractionDigits(2);

                            if (getEmailDepositar().equals(BancoDadosNomePin.getEmail())) {

                                System.out.println("Estimado(a) cliente, foi registado um depósito no valor de " +
                                        numberFormat.format(getDeposito()));
                                System.out.println("Em " + DataHoraSistema.getDataPadrao() + ", as "
                                        + DataHoraSistema.getHoraPadrao() + " para " + BancoDadosNomePin.getNome() +
                                        " " + BancoDadosNomePin.getApelido() + ", " + getEmailDepositar() + ".");

                            } else if (getEmailDepositar().equals(AcEmail.getEmail())) {
                                System.out.println("Estimado(a) cliente, foi registado um depósito no valor de " +
                                        numberFormat.format(getDepositoAc()));
                                System.out.println("Em " + DataHoraSistema.getDataPadrao() + ", as "
                                        + DataHoraSistema.getHoraPadrao() + " para " + AcEmail.getNome() +
                                        " " + AcEmail.getApelido() + ", " + getEmailDepositar() + ".");
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
                                MenuBalcao menuBalcao = new MenuBalcao();
                                menuBalcao.menuBalcao();
                                break;

                            } else {
                                PaginaInicial paginaInicial = new PaginaInicial();
                                paginaInicial.paginaInicial();
                                break;
                            }

                        } else {
                            MenuBalcao menuBalcao = new MenuBalcao();
                            menuBalcao.menuBalcao();
                            break;
                        }
                    }
                }
                while (((!getEmailDepositar().equals(BancoDadosNomePin.getEmail())
                        && !getEmailDepositar().equals(AcEmail.getEmail())))
                        && PerguntaDesejaRectificar.getEscolher() == 1);

            } catch (Exception e) {
                System.out.println("Entrada inválida, apenas dígitos numéricos são permitidos.");
                scanner.nextLine();
                mDeposito();
                break;
            }

        } while ((getDeposito() < 10 || getDepositoAc() < 10) && PerguntaDesejaRectificar.getEscolher() == 1);
    }
}