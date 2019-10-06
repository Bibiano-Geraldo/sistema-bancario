package sistemabancario.aberturaconta.classes;

public class AcEmail extends AcAtributos {

    public void acEmail() {
        String regex = "\\w+[@][a-zA-Z]+([.][a-zA-Z]+)+";
        do {
            try {
                System.out.println("Digite o teu email");
                setEmail(scanner.nextLine());

                assert (getEmail().matches(regex));

            } catch (AssertionError ae) {
                System.out.println("Email inválido, tente novamente.");
            }

        } while (!getEmail().matches(regex));
    }
}
