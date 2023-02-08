package main.exception;

public class SystemException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final transient SystemErro erro;

    public SystemException() {
        super();
        erro = new SystemErro(null, null);
    }

    public SystemException(final String mensagem, final Throwable causa) {
        super(mensagem, causa);
        erro = new SystemErro(mensagem, causa.getStackTrace());
    }

    public SystemException(final String mensagem) {
        this(mensagem, mensagem);
    }

    public SystemException(final String mensagem, final Object detalhe) {
        super(mensagem);
        erro = new SystemErro(mensagem, detalhe);
    }

    public SystemErro getErro() {
        return erro;
    }

    @Override
    public String toString() {
        return String.format("AluguelException [erro=%s]", erro);
    }

}