package sistemabancario.recuperaçãodopin;

import sistemabancario.paginainicial.PaginaInicial;

class PrMensagemFinal {

    void prMensagemFinal() {
        System.out.println("PIN redefinido com sucesso, reiniciando o sistema!");

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
