public class PacoteCartaoPlatinum extends PacoteDecorator {
    public PacoteCartaoPlatinum(Assinatura assinatura) {
        super(assinatura);
    }

    @Override
    public String getDescricao() {
        return assinatura.getDescricao() + "\n+ Pacote 4: Cartão de crédito Platinum";
    }

    @Override
    public double getPreco() {
        return assinatura.getPreco() + 49.99;
    }
}