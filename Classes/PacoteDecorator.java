public abstract class PacoteDecorator implements Assinatura {
    protected Assinatura assinatura;

    public PacoteDecorator(Assinatura assinatura) {
        this.assinatura = assinatura;
    }

    @Override
    public String getDescricao() {
        return assinatura.getDescricao();
    }

    @Override
    public double getPreco() {
        return assinatura.getPreco();
    }
}