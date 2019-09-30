package sistemabancario.aberturaconta.classes;

public class AcNomeApelido extends AcAtributos {

    public void acNomeApelido() {

        do {
            try {
                System.out.println("Qual é o teu nome?");
                setNome(scanner.nextLine().strip());
                assert (getNome().matches("[a-zA-Z- ]+") && getNome().length() > 2);

                System.out.println("Qual é o teu apelido?");
                setApelido(scanner.nextLine().strip());
                assert (getApelido().matches("[a-zA-Z- ]+") && getApelido().length() > 2);

            } catch (AssertionError error) {
                System.out.println("Ops! Entrada inválida, números e caracteres " +
                        "especiais não são permitidos.");
                System.out.println("O nome ou apelido deve ter no mínimo 3 letras.");
            }

        } while (!getNome().matches("[a-zA-Z- ]+") || !getApelido().matches("[a-zA-Z- ]+")
                || getNome().length() <= 2 || getApelido().length() <= 2);

    }
}
