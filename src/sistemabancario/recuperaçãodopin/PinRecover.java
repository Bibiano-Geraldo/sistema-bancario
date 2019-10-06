package sistemabancario.recuperaçãodopin;

import sistemabancario.aberturaconta.classes.AcEmail;
import sistemabancario.aberturaconta.classes.AcPin;
import sistemabancario.bancodadossimulacao.BancoDadosNomePin;
import sistemabancario.classesuniversais.PerguntaDesejaRectificar;
import sistemabancario.login.classes.LoginAtributos;
import sistemabancario.login.classes.LoginPin;
import sistemabancario.menubalcao.MenuBalcao;

import java.util.Scanner;

public class PinRecover{
    private static String email = "fugindo do null";
    private static String nomeCompleto = "fugindo do null";
    private PerguntaDesejaRectificar pDR = new PerguntaDesejaRectificar();
    private Scanner scanner = new Scanner(System.in);

    public void pinRecover() {

        do {
            System.out.println("Insira o teu nome completo:");
            setNomeCompleto(scanner.nextLine());

            if (getNomeCompleto().equals(AcEmail.getNome().concat(" " + AcEmail.getApelido()))
                    || getNomeCompleto().equals(BancoDadosNomePin.getNome().
                    concat(" " + BancoDadosNomePin.getApelido()))) {

                System.out.println("Insira o teu email:");
                setEmail(scanner.nextLine());

                if (getEmail().equals(BancoDadosNomePin.getEmail())
                        && getNomeCompleto().equals(BancoDadosNomePin.getNome().
                        concat(" " + BancoDadosNomePin.getApelido()))) {

                    AcPin acPin = new AcPin();
                    acPin.acPin();

                    LoginPin.setBlock(0);

                    PrMensagemFinal prMensagemFinal = new PrMensagemFinal();
                    prMensagemFinal.prMensagemFinal();

                } else if (getEmail().equals(AcEmail.getEmail())
                        && getNomeCompleto().equals(AcEmail.getNome().
                        concat(" " + AcEmail.getApelido()))) {

                    AcPin acPin = new AcPin();
                    acPin.acPin();

                    LoginPin.setBlockAc(0);

                    PrMensagemFinal prMensagemFinal = new PrMensagemFinal();
                    prMensagemFinal.prMensagemFinal();


                } else {

                    System.out.println("O email " + getEmail() + " não é válido para " + getNomeCompleto() + "!");

                    pDR.desejaRecificar();

                    if (PerguntaDesejaRectificar.getEscolher() == 2) {
                        MenuBalcao menuBalcao = new MenuBalcao();
                        menuBalcao.menuBalcao();
                        break;
                    }
                }

            } else {

                System.out.println("Não encontramos nenhuma conta registada  com este nome.");
                System.out.println("DICA: Para recuperar o teu PIN, deve inserir o mesmo " +
                        "nome que usou para abrir a conta.");

                pDR.desejaRecificar();

                if (PerguntaDesejaRectificar.getEscolher() == 2) {
                    MenuBalcao menuBalcao = new MenuBalcao();
                    menuBalcao.menuBalcao();
                    break;
                }
            }

        } while ((((!getNomeCompleto().equals(AcEmail.getNome().concat(" " + AcEmail.getApelido()))
                || getNomeCompleto().equals(AcEmail.getNome().concat(" " + AcEmail.getApelido())))
                && !getEmail().equals(AcEmail.getEmail()))
                || ((!getNomeCompleto().equals(BancoDadosNomePin.getNome().concat(" " + BancoDadosNomePin.getApelido()))
                || getNomeCompleto().equals(BancoDadosNomePin.getNome().concat(" " + BancoDadosNomePin.getApelido())))
                && !getEmail().equals(BancoDadosNomePin.getEmail())))
                && PerguntaDesejaRectificar.getEscolher() == 1);
    }

    public static String getEmail() {
        return email.toUpperCase();
    }

    private static void setEmail(String email) {
        PinRecover.email = email;
    }

    public static String getNomeCompleto() {
        return nomeCompleto.toUpperCase();
    }

    private static void setNomeCompleto(String nomeCompleto) {
        PinRecover.nomeCompleto = nomeCompleto;
    }

}
