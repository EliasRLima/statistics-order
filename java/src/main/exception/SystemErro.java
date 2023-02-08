package main.exception;

public class SystemErro {

    private String mensagem;
    private Object detalhe;

    public SystemErro() {

    }

    public SystemErro(String mensagem, Object detalhe) {
        this.mensagem = mensagem;
        this.detalhe = detalhe;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Object getDetalhe() {
        return detalhe;
    }

    public void setMensagem(final String mensagem) {
        this.mensagem = mensagem;
    }

    public void setDetalhe(final Object detalhe) {
        this.detalhe = detalhe;
    }

    @Override
    public String toString() {
        return String.format("LivrariaErro [mensagem=%s, detalhe=%s]", mensagem, detalhe);
    }
}
