public class Impresso {
    private Float frete;
    private int estoque;

    public void realizarVenda(Float frete, int estoque) {
        this.frete = frete;
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Impresso{" +
                "frete=" + frete +
                ", estoque=" + estoque +
                '}';
    }

    public Float getFrete() {
        return frete;
    }

    public void setFrete(Float frete) {
        this.frete = frete;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
