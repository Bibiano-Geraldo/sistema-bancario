package sistemabancario.menubalcao;

import sistemabancario.aberturaconta.AcPrincipal;

import sistemabancario.classesuniversais.ClUAtributos;
import sistemabancario.movimentos.Depositos;
import sistemabancario.paginainicial.PaginaInicial;
import sistemabancario.recuperaçãodopin.PinRecover;

public class MenuBalcao extends ClUAtributos {

    public void menuBalcao() {

        do {
            try {
                System.out.println("----------------- B A L C A O  D E  A T E N D I M E N T O ----------------");

                System.out.println("OQUE DESEJA FAZER?");
                System.out.println("[1] abrir uma conta bancária");
                System.out.println("[2] efectuar depósitos");
                System.out.println("[3] recuperar o PIN");
                System.out.println("[4] para voltar a página inicial");
                setEscolher(scanner.nextInt());

                if (getEscolher() != 1 && getEscolher() != 2 && getEscolher() != 3 && getEscolher() != 4) {
                    System.out.println("Entrada inválida, escolhe uma opção entre [1], [2], [3], e [4]");
                }

                switch (getEscolher()) {

                    case 1:
                        AcPrincipal acPrincipal = new AcPrincipal();
                        acPrincipal.acPrincipal();
                        break;

                    case 2:
                        Depositos depositos = new Depositos();
                        depositos.mDeposito();
                        break;

                    case 3:
                        PinRecover pinRecover = new PinRecover();
                        pinRecover.pinRecover();
                        break;

                    case 4:
                        PaginaInicial paginaInicial = new PaginaInicial();
                        paginaInicial.paginaInicial();
                        break;
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida, apenas dígitos numéricos são permitidos.");
                System.out.println("DICA: Escolhe uma opção entre [1], [2], [3], e [4]");
                scanner.nextLine();
                menuBalcao();
                break;
            }
        } while (getEscolher() != 1 && getEscolher() != 2 && getEscolher() != 3 && getEscolher() != 4);
    }
}
