package sistemabancario.aberturaconta;

import sistemabancario.aberturaconta.classes.*;

public class AcPrincipal {
    private AcNomeApelido acNomeApelido = new AcNomeApelido();
    private AcSexo acSexo = new AcSexo();
    private AcDataNascimento acDataNascimento = new AcDataNascimento();
    private AcEmail acEmail = new AcEmail();
    private AcPin acPin = new AcPin();
    private AcMensagemFinal acMensagemFinal = new AcMensagemFinal();

    public void acPrincipal() {
        acNomeApelido.acNomeApelido();
        acSexo.acSexo();
        acDataNascimento.acDataNascimento();
        acEmail.acEmail();
        acPin.acPin();
        acMensagemFinal.acMensagemFinal();
    }
}
