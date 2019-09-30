package sistemabancario.aberturaconta.classes;


public class AcDataNascimento extends AcAtributos {

    public void acDataNascimento() {

        // DEFININDO O ANO DE NASCIMENTO
        do {
            try {
                System.out.println("Digite o ano de nascimento:");
                setAnoUsuario(scanner.nextInt());

                if ((getAnoActual() - getAnoUsuario()) < 18) {
                    System.out.println("Ops! Abertura de conta não permitida a menores de 18 anos.");
                }

                if (getAnoUsuario() <= 0) {
                    System.out.println("Ano inválido, tente novamente.");
                }

                if (Integer.toString(getAnoUsuario()).length() != 4) {
                    System.out.println("Entrada inválida, o ano deve ter 4 dígitos e sem delimitador.");
                    scanner.nextLine();
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida, apenas dígitos numéricos são permitidos.");
                scanner.nextLine();
            }

        } while ((getAnoActual() - getAnoUsuario()) < 18 || Integer.toString(getAnoUsuario()).length() != 4
                || getAnoUsuario() <= 0);

        // DEFININDO O MES DE NASCIMENTO
        do {
            try {
                System.out.println("Digite o mês de nascimento:");
                setMesUsuario(scanner.nextInt());

                if (getMesUsuario() <= 0 || getMesUsuario() > 12) {
                    System.out.println("Mês inválido, tente novamente.");
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida, apenas dígitos numéricos são permitidos.");
                scanner.nextLine();
            }

        } while (getMesUsuario() <= 0 || getMesUsuario() > 12);

        // DEFININDO O DIA DE NASCIMENTO
        do {
            try {
                System.out.println("Digite o dia de nascimento:");
                setDiaUsuario(scanner.nextInt());

                if (getDiaUsuario() <= 0 || getDiaUsuario() > 31) {
                    System.out.println("Dia inválido, tente novamente.");
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida, apenas dígitos numéricos são permitidos.");
                scanner.nextLine();
            }

        } while (getDiaUsuario() <= 0 || getDiaUsuario() > 31);
    }
}
