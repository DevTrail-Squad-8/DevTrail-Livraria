public class Venda {

    private static int numVendas = 0;
    private int numero;
    private String cliente;
    private float valor;
    private Livro[] livros;

    public Venda(int tamanho, String cliente) {
        this.livros = new Livro[tamanho];
        this.cliente = cliente;
        this.valor = 0;
        numVendas++;
        this.numero = numVendas;
    }

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
        if (index >= 0 && index < livros.length && livros[index] == null) {
            livros[index] = l;
            valor += l.getPreco();

            if (l instanceof Impresso) {
                valor += ((Impresso) l).getFrete();
            }
        } else {
            System.out.println("Erro");
        }
    }


    public void listarLivros() {
        System.out.println("Venda n° " + numero);
        for (int i = 0; i < livros.length; i++) {
            if (livros[i] != null) {
                System.out.println("Livro " + (i + 1) + ":");
                System.out.println(livros[i].toString());
                System.out.println("-----------------------------");
            }
        }
        System.out.println("Valor total da venda: R$ " + valor);
    }

}
