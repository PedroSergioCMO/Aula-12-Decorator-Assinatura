public class PacoteMultiDispositivo extends PacoteDecorator {
    public PacoteMultiDispositivo(Assinatura assinatura) {
        super(assinatura);
    }

    @Override
    public String getDescricao() {
        return assinatura.getDescricao() + "\n+ Pacote 1: Assistir vídeos em vários dispositivos";
    }

    @Override
    public double getPreco() {
        return assinatura.getPreco() + 19.99;
    }
}