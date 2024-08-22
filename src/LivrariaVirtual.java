import java.util.Locale;
import java.util.Scanner;

public class LivrariaVirtual {
    private static final int MAX_IMPRESSOS = 10;
    private static final int MAX_ELETRONICOS = 20;
    private static final int MAX_VENDAS = 50;

    private Impresso[] impressos;
    private Eletronico[] eletronicos;
    private Venda[] vendas;
    private int numImpressos;
    private int numEletronicos;
    private int numVendas;

    public LivrariaVirtual() {
        this.impressos = new Impresso[MAX_IMPRESSOS];
        this.eletronicos = new Eletronico[MAX_ELETRONICOS];
        this.vendas = new Venda[MAX_VENDAS];
        this.numImpressos = 0;
        this.numEletronicos = 0;
        this.numVendas = 0;
    }

    public int getNumImpressos() {
        return numImpressos;
    }

    public void setNumImpressos(int numImpressos) {
        this.numImpressos = numImpressos;
    }

    public int getNumEletronicos() {
        return numEletronicos;
    }

    public void setNumEletronicos(int numEletronicos) {
        this.numEletronicos = numEletronicos;
    }

    public int getNumVendas() {
        return numVendas;
    }

    public void setNumVendas(int numVendas) {
        this.numVendas = numVendas;
    }

    public void cadastrarLivro() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nDigite o tipo de livro que será cadastrado:\n1 - Impresso\n2 - Eletrônico\n3 - Ambos");
        int tipo = sc.nextInt();
        sc.nextLine();

        if (tipo != 1 && tipo != 2 && tipo != 3) System.out.println("Opção Inválida");

        if (tipo == 1 || tipo == 3) {
            if (numImpressos >= MAX_IMPRESSOS) {
                System.out.println("Limite de livros impressos atingido!");
            } else {
                System.out.println("\nAdicione os dados do livro Impresso:");
                System.out.print("Digite o título: ");
                String titulo = sc.nextLine();
                System.out.print("Digite o nome do(s) autor(es): ");
                String autor = sc.nextLine();
                System.out.print("Digite a editora: ");
                String editora = sc.nextLine();
                System.out.print("Digite o preço do livro: ");
                float preco = sc.nextFloat();
                System.out.print("Digite o frete: ");
                float frete = sc.nextFloat();
                System.out.print("Digite a quantidade em estoque: ");
                int estoque = sc.nextInt();
                sc.nextLine();

                Impresso imp = new Impresso(titulo, autor, editora, preco, frete, estoque);
                impressos[numImpressos++] = imp;
                System.out.println("Livro Impresso Cadastrado!");
            }
        }

        if (tipo == 2 || tipo == 3) {
            if (numEletronicos >= MAX_ELETRONICOS) {
                System.out.println("Limite de livros eletrônicos atingido!");
            } else {
                System.out.println("\nAdicione os dados do livro Eletrônico:");
                System.out.print("Digite o título: ");
                String titulo = sc.nextLine();
                System.out.print("Digite o nome do(s) autor(es): ");
                String autor = sc.nextLine();
                System.out.print("Digite a editora: ");
                String editora = sc.nextLine();
                System.out.print("Digite o preço do livro: ");
                float preco = sc.nextFloat();
                System.out.print("Digite o tamanho do livro em KB: ");
                int tamanho = sc.nextInt();

                Eletronico eletronico = new Eletronico(titulo, autor, editora, preco, tamanho);
                eletronicos[numEletronicos++] = eletronico;
                System.out.println("Livro Eletrônico Cadastrado!");
            }
        }
    }

    public void realizarVenda() {

    }

    public void listarLivrosImpressos() {

    }

    public void listarLivrosEletronicos() {

    }

    private void listarLivros() {
    }

    private void listarVendas() {
    }

    @Override
    public String toString() {
        return "LivrariaVirtual{" +
                "numImpressos=" + numImpressos +
                ", numEletronicos=" + numEletronicos +
                ", numVendas=" + numVendas +
                '}';
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        LivrariaVirtual livraria = new LivrariaVirtual();
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\nMenu");
            System.out.println("1 - Cadastrar Livro: ");
            System.out.println("2 - Realizar Venda: ");
            System.out.println("3 - Listar livros: ");
            System.out.println("4 - Listar vendas: ");
            System.out.println("5 - Sair do programa: ");
            System.out.print("Digite uma opção: ");
            op = sc.nextInt();

            switch(op) {
                case 1:
                    livraria.cadastrarLivro();
                    break;
                case 2:
                    livraria.realizarVenda();
                    break;
                case 3:
                    livraria.listarLivros();
                    break;
                case 4:
                    livraria.listarVendas();
                    break;
                case 5:
                    System.out.println("Programa encerrado");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        } while (op != 5);

        sc.close();
    }
}
