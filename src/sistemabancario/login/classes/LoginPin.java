package sistemabancario.login.classes;

import sistemabancario.aberturaconta.classes.AcEmail;
import sistemabancario.bancodadossimulacao.BancoDadosNomePin;
import sistemabancario.paginainicial.PaginaInicial;

public class LoginPin extends LoginAtributos {

    public void loginPin() {
        if ((getEmail().equals(BancoDadosNomePin.getEmail()) || getEmail().equals(AcEmail.getEmail()))) {
            int countPin = 0;

            do {
                try {
                    System.out.println("Digite o teu PIN:");
                    setPin(scanner.nextInt());

                    assert (Integer.toString(getPin()).length() == 4
                            && ((getPin() == BancoDadosNomePin.getPin() && getEmail().equals(BancoDadosNomePin.getEmail()))
                            || (getPin() == AcEmail.getPinNovo() && getEmail().equals(AcEmail.getEmail()))));

                } catch (Exception e) {
                    System.out.println("Entrada inválida, apenas dígitos numéricos são permitidos.");

                    if (countPin == 0) {
                        System.out.println("Pin inválido, após duas tentativas sem sucesso" +
                                " a tua conta será bloqueada!");

                    }
                    if (countPin == 1) {
                        System.out.println("Pin inválido, após uma tentativa sem sucesso" +
                                " a tua conta será bloqueada!");

                    }
                    if (countPin == 2) {
                        System.out.println("Conta Bloqueada, contacte o teu gestor!");
                    }

                    scanner.nextLine();

                } catch (AssertionError ae) {
                    if (countPin == 0) {
                        System.out.println("Pin inválido, após duas tentativas sem sucesso" +
                                " a tua conta será bloqueada!");

                    }
                    if (countPin == 1) {
                        System.out.println("Pin inválido, após uma tentativa sem sucesso" +
                                " a tua conta será bloqueada!");

                    }
                    if (countPin == 2) {
                        System.out.println("Conta Bloqueada, contacte o teu gestor!");

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

            } while ((countPin++ < 2
                    && (getPin() != BancoDadosNomePin.getPin() && getEmail().equals(BancoDadosNomePin.getEmail()))
                    || (getPin() != AcEmail.getPinNovo() && getEmail().equals(AcEmail.getEmail()))));
        }
    }
}
