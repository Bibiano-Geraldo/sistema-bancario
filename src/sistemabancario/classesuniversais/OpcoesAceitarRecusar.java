package sistemabancario.classesuniversais;

public class OpcoesAceitarRecusar extends ClUAtributos {

    public void aceitarOuRecusar() {

        do {
            try {
                System.out.println("[1] aceitar");
                System.out.println("[2] recusar");
                setEscolher(scanner.nextInt());

                if (getEscolher() != 1 && getEscolher() != 2) {
                    System.out.println("Entrada inválida, escolhe uma opção entre [1] e [2]");
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida, apenas dígitos numéricos são permitidos.");
                System.out.println("DICA: Escolhe uma opção entre [1] e [2]");
                scanner.nextLine();
                aceitarOuRecusar();
                break;
            }

        } while (getEscolher() != 1 && getEscolher() != 2);
    }
}
