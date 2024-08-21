public class Venda {

    private static int numVendas = 0;
    private int numero = numVendas;
    private String cliente;
    private float valor;
    private Livro[] livros;

    public int getNumVendas() {
        return numVendas;
    }

    public void setNumVendas(int numVendas) {
        this.numVendas = numVendas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void addLivro(Livro l, int index) {
        if (index >= 0 && index < livros.length) {
            livros[index] = l;
            valor += l.getPreco();
        }
    }

    public void listarLivros() {
        for (Livro livro : livros) {
            System.out.println(livro.toString());
        }
    }

    @Override
    public String toString() {
        return "Venda{" +
                "numVendas=" + numVendas +
                ", numero=" + numero +
                ", cliente='" + cliente + '\'' +
                ", valor=" + valor +
                '}';
    }
}
