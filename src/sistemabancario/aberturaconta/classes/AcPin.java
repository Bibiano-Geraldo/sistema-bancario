package sistemabancario.aberturaconta.classes;

public class AcPin extends AcAtributos {

    public void acPin() {

        do {
            try {
                System.out.println("Criar um PIN:");
                setPinNovo(scanner.nextInt());

                assert (Integer.toString(getPinNovo()).length() == 4 && getPinNovo() > 0);

                System.out.println("Confirmar o PIN:");
                setConfirmPin(scanner.nextInt());

                if (getPinNovo() != getConfirmPin()) {
                    System.out.println("Ops! PIN não combinado, tente novamente.");
                }

                if (getPinNovo() == 1234 && getPinNovo() == getConfirmPin()) {
                    System.out.println("PIN fácil de descobrir, tente outro.");
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida, apenas dígitos numéricos são permitidos.");
                scanner.nextLine();

            } catch (AssertionError ae) {
                System.out.println(getNome() + ", o teu PIN deve ter apenas 4 números positivos.");
            }

        } while (Integer.toString(getPinNovo()).length() != 4 || getPinNovo() != getConfirmPin()
                || getPinNovo() < 0 || getPinNovo() == 1234);
    }
}
