package sistemabancario.menuatm;

import sistemabancario.aberturaconta.classes.AcEmail;
import sistemabancario.aberturaconta.classes.AcPin;
import sistemabancario.aberturaconta.classes.AcSexo;
import sistemabancario.bancodadossimulacao.BancoDadosNomePin;
import sistemabancario.classesuniversais.ClUAtributos;
import sistemabancario.login.LoginPrincipal;
import sistemabancario.login.classes.LoginEmail;
import sistemabancario.login.classes.LoginPin;
import sistemabancario.movimentos.Levantamentos;
import sistemabancario.movimentos.Transferencias;
import sistemabancario.movimentos.VerSaldoConta;
import sistemabancario.paginainicial.PaginaInicial;

public class MenuAtm extends ClUAtributos {

    void menuAtm() {
        LoginPrincipal loginPrincipal = new LoginPrincipal();
        loginPrincipal.loginPrincipal();
    }

    public void menuAtmStart() {
        if ((LoginEmail.getEmail().equals(BancoDadosNomePin.getEmail()) && LoginPin.getPin() == BancoDadosNomePin.getPin())
                || LoginEmail.getEmail().equals(AcEmail.getEmail()) && LoginPin.getPin() == AcPin.getPinNovo()) {

            do {
                try {
                    System.out.println("---------------------- M E N U  A T M ----------------------");

                    if (LoginEmail.getEmail().equals(BancoDadosNomePin.getEmail())) {

                        if (BancoDadosNomePin.getSexo() == 2) {
                            System.out.println("Bem-vinda " + BancoDadosNomePin.getNome() + "! Faça uma operação.");

                        } else {
                            System.out.println("Bem-vindo " + BancoDadosNomePin.getNome() + "! Faça uma operação.");
                        }

                    } else if (LoginEmail.getEmail().equals(AcEmail.getEmail())) {

                        if (AcSexo.getEscolhaSexo() == 2) {
                            System.out.println("Bem-vinda " + AcEmail.getNome() + "! Faça uma operação.");

                        } else {
                            System.out.println("Bem-vindo " + AcEmail.getNome() + "! Faça uma operação.");
                        }

                    }
                    System.out.println("[1] para levantar");
                    System.out.println("[2] para transferir");
                    System.out.println("[3] para consultar o saldo");
                    System.out.println("[4] para voltar a página inicial");
                    setEscolher(scanner.nextInt());

                    if (getEscolher() != 1 && getEscolher() != 2 && getEscolher() != 3 && getEscolher() != 4) {
                        System.out.println("Entrada inválida, escolhe uma opção entre [1], [2], [3], e [4]");
                    }

                    switch (getEscolher()) {

                        case 1:
                            Levantamentos levantamentos = new Levantamentos();
                            levantamentos.mLevantamentos();
                            break;

                        case 2:
                            Transferencias transferencias = new Transferencias();
                            transferencias.mTransferencias();
                            break;

                        case 3:
                            VerSaldoConta verSaldoConta = new VerSaldoConta();
                            verSaldoConta.verSaldoConta();
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
                    menuAtmStart();
                    break;
                }
            } while (getEscolher() != 1 && getEscolher() != 2 && getEscolher() != 3 && getEscolher() != 4);
        }
    }
}
