package sistemabancario.login.classes;

import sistemabancario.aberturaconta.classes.AcEmail;
import sistemabancario.bancodadossimulacao.BancoDadosNomePin;

public class LoginPin extends LoginAtributos {

    public void loginPin() {

        if (((getEmail().equals(BancoDadosNomePin.getEmail()) || getEmail().equals(AcEmail.getEmail())))) {
            int countPin = 0;

            do {
                try {
                    if (getEmail().equals(BancoDadosNomePin.getEmail()) && getBlock() >= 2) {
                        countPin = getBlock();
                        System.out.println("Conta bloqueada, vá ao balcão de atendimento para recuperar O PIN!");
                        for (int i = 0; i < 3; i++) {

                            try {
                                Thread.sleep(1000);

                            } catch (Exception ignored) {

                            }
                        }
                        paginaInicial.paginaInicial();
                        break;

                    } else if (getEmail().equals(AcEmail.getEmail()) && getBlockAc() >= 2) {
                        countPin = getBlockAc();
                        System.out.println("Conta bloqueada, vá ao balcão de atendimento para recuperar O PIN!");

                        for (int i = 0; i < 3; i++) {

                            try {
                                Thread.sleep(1000);

                            } catch (Exception ignored) {
                            }
                        }
                        paginaInicial.paginaInicial();
                        break;
                    }

                    if (getEmail().equals(BancoDadosNomePin.getEmail())) {
                        setBlock(countPin);

                    } else {
                        setBlockAc(countPin);
                    }

                    System.out.println("Digite o teu PIN:");
                    setPin(scanner.nextInt());

                    assert (Integer.toString(getPin()).length() == 4
                            && ((getPin() == BancoDadosNomePin.getPin() && getEmail().equals(BancoDadosNomePin.getEmail()))
                            || (getPin() == AcEmail.getPinNovo() && getEmail().equals(AcEmail.getEmail()))));

                } catch (Exception e) {
                    if (countPin<2) {
                        System.out.println("Entrada inválida, apenas dígitos numéricos são permitidos.");

                        if (countPin == 0) {
                            System.out.println("Pin inválido, após duas tentativas sem sucesso" +
                                    " a tua conta será bloqueada!");

                        }
                        if (countPin == 1) {
                            System.out.println("Pin inválido, após uma tentativa sem sucesso" +
                                    " a tua conta será bloqueada!");

                        }
                    }
                    if (countPin == 2) {
                        System.out.println("Conta Bloqueada, contacte o teu gestor!");
                        for (int i = 0; i < 2; i++) {

                            try {
                                Thread.sleep(1000);

                            } catch (Exception ignored) {

                            }
                        }
                        paginaInicial.paginaInicial();
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
                        paginaInicial.paginaInicial();
                        break;
                    }
                }
            } while ((countPin++ < 2
                    && (getPin() != BancoDadosNomePin.getPin() && getEmail().equals(BancoDadosNomePin.getEmail()))
                    || (getPin() != AcEmail.getPinNovo() && getEmail().equals(AcEmail.getEmail()))));
        }
    }
}
