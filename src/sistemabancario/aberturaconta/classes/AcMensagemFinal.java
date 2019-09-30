package sistemabancario.aberturaconta.classes;

import sistemabancario.aberturaconta.universalparaestepacote.AcPerguntaDesejaRectificar;
import sistemabancario.bancodadossimulacao.BancoDadosNomePin;
import sistemabancario.classesuniversais.PerguntaDesejaRectificar;
import sistemabancario.login.LoginPrincipal;
import sistemabancario.menuatm.MenuAtmPrincipal;
import sistemabancario.paginainicial.PaginaInicial;

public class AcMensagemFinal {

    public void acMensagemFinal() {
        AcPerguntaDesejaRectificar AcpDR = new AcPerguntaDesejaRectificar();

        System.out.println(AcNomeApelido.getNome() + ", aguarde um pouco enquanto " +
                "analisamos os teus dados, não vai demorar!");

        for (int i = 0; i < 7; i++) {

            try {
                Thread.sleep(1000);

            } catch (Exception ignored) {
            }
        }

        if (AcEmail.getEmail().equals(BancoDadosNomePin.getEmail())) {

            do {
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Encontramos um problema, o email " + AcEmail.getEmail() +
                        " já está registado!");
                AcpDR.acDesejaRecificar();

                switch (AcPerguntaDesejaRectificar.getEscolher()) {

                    case 1:
                        AcEmail acEmail = new AcEmail();
                        acEmail.acEmail();

                        if (AcEmail.getEmail().equals(BancoDadosNomePin.getEmail())) {
                            acMensagemFinal();
                        }
                        break;

                    case 2:
                        AcEmail.setEmail(""); //PARA INVALIDAR O EMAIL SALVO NA MEMORIA
                        MenuAtmPrincipal menuAtmPrincipal = new MenuAtmPrincipal();
                        menuAtmPrincipal.menuAtmPrincipal();
                        break;

                    case 3:
                        AcEmail.setEmail(""); //PARA INVALIDAR O EMAIL SALVO NA MEMORIA
                        System.out.println("Cancelando o cadastro!");

                        for (int i = 0; i < 1; i++) {

                            try {
                                Thread.sleep(1000);

                            } catch (Exception ignored) {
                            }
                        }
                        PaginaInicial paginaInicial = new PaginaInicial();
                        paginaInicial.paginaInicial();
                        break;
                }
            } while (AcEmail.getEmail().equals(BancoDadosNomePin.getEmail()) && PerguntaDesejaRectificar.getEscolher() == 1);
        }

        if (!AcEmail.getEmail().equals(BancoDadosNomePin.getEmail())
                && AcPerguntaDesejaRectificar.getEscolher() != 2
                && AcPerguntaDesejaRectificar.getEscolher() != 3) {

            if (AcSexo.getEscolhaSexo() == 1) {
                System.out.println("Conta criada com sucesso, seja bem-vindo "
                        + AcNomeApelido.getNome() + " " + AcNomeApelido.getApelido() + "!");

            } else {
                System.out.println("Conta criada com sucesso, seja bem-vinda "
                        + AcNomeApelido.getNome() + " " + AcNomeApelido.getApelido() + "!");
            }

            for (int i = 0; i < 2; i++) {

                try {
                    Thread.sleep(1000);

                } catch (Exception ignored) {
                }
            }
            PaginaInicial paginaInicial = new PaginaInicial();
            paginaInicial.paginaInicial();
        }
    }
}
