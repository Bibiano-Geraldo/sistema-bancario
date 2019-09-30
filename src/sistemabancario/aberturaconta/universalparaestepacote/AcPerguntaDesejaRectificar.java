package sistemabancario.aberturaconta.universalparaestepacote;


public class AcPerguntaDesejaRectificar extends AcUPEPAtributos {

    public void acDesejaRecificar() {

        do {
            try {
                System.out.println("Escolha uma ação?");
                System.out.println("[1] rectificar o email");
                System.out.println("[2] fazer login");
                System.out.println("[3] cancelar o cadastro");
                setEscolher(scanner.nextByte());

                if (getEscolher() != 1 && getEscolher() != 2 && getEscolher() != 3) {
                    System.out.println("Entrada inválida, escolhe uma opção entre [1], [2] e [3]");
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida, apenas dígitos numéricos são permitidos.");
                System.out.println("DICA: Escolhe uma opção entre [1] e [2]");
                scanner.nextLine();
                acDesejaRecificar();
                break;
            }

        } while (getEscolher() != 1 && getEscolher() != 2 && getEscolher() != 3);
    }
}
