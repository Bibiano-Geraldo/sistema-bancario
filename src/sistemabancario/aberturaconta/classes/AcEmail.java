package sistemabancario.aberturaconta.classes;

public class AcEmail extends AcAtributos {

    public void acEmail() {

        do {
            try {
                System.out.println("Digite o teu email");
                setEmail(scanner.nextLine());

                assert (getEmail().contains("@") && (getEmail().contains(".co".toUpperCase())
                        || getEmail().contains(".com".toUpperCase())
                        || getEmail().contains(".gov".toUpperCase())));

            } catch (AssertionError ae) {
                System.out.println("Email inválido, tente novamente.");

            }

        } while (!getEmail().contains("@") || (!getEmail().contains(".co".toUpperCase())
                && !getEmail().contains(".com".toUpperCase())
                && !getEmail().contains(".gov".toUpperCase())));
    }
}
