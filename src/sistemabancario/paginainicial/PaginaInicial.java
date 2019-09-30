package sistemabancario.paginainicial;

import sistemabancario.classesuniversais.ClUAtributos;
import sistemabancario.menuatm.MenuAtmPrincipal;
import sistemabancario.menubalcao.MenuBalcao;

public class PaginaInicial extends ClUAtributos {

    public void paginaInicial() {

        do {
            try {
                System.out.println("---------------------- P A G I N A  I N I C I A L ----------------------");
                System.out.println("ONDE DESEJA IR?");
                System.out.println("[1] para o ATM");
                System.out.println("[2] para o balcão de atendimento");
                System.out.println("[3] para sair do sistema");
                setEscolher(scanner.nextInt());

                if (getEscolher() != 1 && getEscolher() != 2 && getEscolher() != 3) {
                    System.out.println("Entrada inválida, escolhe uma opção entre [1], [2] e [3]");
                }

                switch (getEscolher()) {

                    case 1:
                        MenuAtmPrincipal menuAtmPrincipal = new MenuAtmPrincipal();
                        menuAtmPrincipal.menuAtmPrincipal();
                        break;

                    case 2:
                        MenuBalcao menuBalcao = new MenuBalcao();
                        menuBalcao.menuBalcao();
                        break;

                    case 3:
                        System.out.println("Saíndo do sistema, OBRIGADO!");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida, apenas dígitos numéricos são permitidos.");
                System.out.println("DICA: Escolhe uma opção entre [1], [2] e [3]");
                scanner.nextLine();
                paginaInicial();
                break;
            }
        } while (getEscolher() != 1 && getEscolher() != 2 && getEscolher() != 3);
    }
}
