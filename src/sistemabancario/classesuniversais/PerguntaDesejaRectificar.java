package sistemabancario.classesuniversais;

public class PerguntaDesejaRectificar extends ClUAtributos {

    public void desejaRecificar() {

        do {
            try {
                System.out.println("Deseja Rectificar?");
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
                desejaRecificar();
                break;
            }

        } while (getEscolher() != 1 && getEscolher() != 2);
    }
}
