package sistemabancario.aberturaconta.classes;

public class AcSexo extends AcAtributos {

    public void acSexo() {

        do {
            try {
                System.out.println("Selecione o teu sexo:");
                System.out.println("[1] para Masculino");
                System.out.println("[2] para Femenino");
                setEscolhaSexo(scanner.nextByte());

                if (getEscolhaSexo() != 1 && getEscolhaSexo() != 2) {
                    System.out.println("Entrada inválida, escolhe uma opção entre [1] e [2]");
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida, apenas dígitos numéricos são permitidos.");
                scanner.nextLine();
            }

        } while (getEscolhaSexo() != 1 && getEscolhaSexo() != 2 );
    }
}
