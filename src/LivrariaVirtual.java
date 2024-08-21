import java.util.Scanner;

public class LivrariaVirtual {
    private static final int MAX_IMPRESSOS = 10;
    private static final int MAX_ELETRONICOS = 20;
    private static final int MAX_VENDAS = 50;

    private Impresso[] impressos = new Impresso[MAX_IMPRESSOS];
    private Eletronico [] eletronicos = new Eletronico[MAX_ELETRONICOS];
    private Venda [] vendas = new Venda[MAX_VENDAS];

    private int numImpressos = 0;
    private int numEletronicos = 0;
    private int numVendas = 0;

    public void cadastrarLivro() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o tipo de livro que será cadastrado:\n1 - Impresso\n2 - Eletrônico\n3 - Ambos");
        int tipo = sc.nextInt();

        if (tipo == 1) {
            if (numImpressos < MAX_IMPRESSOS) {
                System.out.print("Digite o título: \n");
                System.out.print("Digite o nome do autor: \n");
                System.out.print("Digite a editora: \n");
                System.out.print("Digite a frete: \n");
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
