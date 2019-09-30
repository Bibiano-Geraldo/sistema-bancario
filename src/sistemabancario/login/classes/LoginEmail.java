package sistemabancario.login.classes;

import sistemabancario.aberturaconta.classes.AcEmail;
import sistemabancario.bancodadossimulacao.BancoDadosNomePin;
import sistemabancario.paginainicial.PaginaInicial;

public class LoginEmail extends LoginAtributos {

    public void loginEmail() {

        int countEmail = 0;
            do {
                try {
                    System.out.println("Digite o teu email");
                    setEmail(scanner.nextLine());

                    assert (getEmail().contains("@") && (getEmail().contains(".co".toUpperCase())
                            || getEmail().contains(".com".toUpperCase())
                            || getEmail().contains(".gov".toUpperCase()))
                            && (getEmail().equals(BancoDadosNomePin.getEmail())
                            || getEmail().equals(AcEmail.getEmail())));

                } catch (AssertionError ae) {
                    if (countEmail == 0) {
                        System.out.println("Email inválido, após duas tentativas sem sucesso, o sistema " +
                                "será cancelado automaticamente!");
                    }

                    if (countEmail == 1) {
                        System.out.println("Email inválido, após uma tentativa sem sucesso, o sistema será " +
                                "cancelado automaticamente!");
                    }

                    if (countEmail == 2) {

                        System.out.println("Cancelando o sistema...!");
                        for (int i = 0; i < 2; i++) {
                            try {
                                Thread.sleep(1000);
                            } catch (Exception ignored) {

                            }
                        }
                        PaginaInicial paginaInicial = new PaginaInicial();
                        paginaInicial.paginaInicial();
                    }
                }

            } while ((!getEmail().contains("@") || (!getEmail().contains(".co".toUpperCase())
                    && !getEmail().contains(".com".toUpperCase())
                    && !getEmail().contains(".gov".toUpperCase()))
                    || (!getEmail().equals(BancoDadosNomePin.getEmail())
                    && !getEmail().equals(AcEmail.getEmail())))
                    && countEmail++ < 2);
    }
}
