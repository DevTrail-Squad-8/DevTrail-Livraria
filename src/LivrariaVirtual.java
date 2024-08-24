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

    Scanner sc = new Scanner(System.in);

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
        if (numVendas >= MAX_VENDAS) {
            System.out.println("Limite de vendas atingido!");
            return;
        }

        System.out.print("Digite o nome do cliente: ");
        String cliente = sc.nextLine();

        System.out.print("Digite a quantidade de livros que o cliente deseja comprar: ");
        int qtdLivros = sc.nextInt();
        sc.nextLine();

        if (qtdLivros <= 0) {
            System.out.println("Quantidade de livros inválida.");
            return;
        }

        Venda venda = new Venda(qtdLivros, cliente);

        for (int i = 0; i < qtdLivros; i++) {
            System.out.println("\n Escolha o tipo de livro:\n1 - Impresso\n2 - Eletrônico.");
            int tipo = sc.nextInt();
            sc.nextLine();

            if (tipo != 1 && tipo != 2) {
                System.out.println("Opção inválida.");
            }

            if (tipo == 1) {
                listarLivrosImpressos();
                System.out.println("Escolha o índice do livro impresso: ");
                int indice = sc.nextInt();
                sc.nextLine();

                if (indice >= 0 && indice < numImpressos) {
                    venda.addLivro(impressos[indice], i);
                    impressos[indice].atualizarEstoque();
                } else {
                    System.out.println("Índice inválido.");
                }
            } else if (tipo == 2) {
                listarLivrosEletronicos();
                System.out.println("Escolha o índice do livro eletrônico: ");

                int indice = sc.nextInt();
                sc.nextLine();

                if (indice >= 0 && indice < numEletronicos) {
                    venda.addLivro(eletronicos[indice], i);
                } else {
                    System.out.println("Índice inválido");
                }
            } else {
                System.out.println("Opção inválida.");
            }
        }
        vendas[numVendas++] = venda;
        System.out.println("Venda realizada com sucesso!");
    }

    public void listarLivrosImpressos() {
        if (numImpressos == 0) {
            System.out.println("\nNenhum livro impresso");
        } else {
            System.out.print("\nLivros Impressos: ");
            System.out.print("---------------------");

            for (int i = 0; i < numImpressos; i++) {
                System.out.println((i)+ 1 + " - " + impressos[i].toString());
            }
        }
    }

    public void listarLivrosEletronicos() {
        if (numEletronicos == 0) {
            System.out.println("\nNenhum livro eletrônico");
        } else {
            System.out.println("\nLivros Eletrônicos: ");
            System.out.println("\n---------------------\n");

            for (int i = 0; i < numEletronicos; i++) {
                System.out.println((i)+ 1 + " - " + eletronicos[i].toString());
            }
        }
    }

    private void listarLivros() {
        if (numImpressos == 0 && numEletronicos == 0) {
            System.out.println("\nNenhum Livro Cadastrado");
        }

        if (numImpressos > 0) {
            listarLivrosImpressos();
        }

        if (numEletronicos > 0) {
            listarLivrosImpressos();
        }
    }

    private void listarVendas() {
        if (numVendas == 0) {
            System.out.println("Nenhuma Venda feita");
        } else {
            for (int i = 0; i < numVendas; i++) {
                Venda Venda = vendas[i];
                System.out.println("\n--------------------------------\n");
                vendas[i].listarLivros();
                System.out.println("Cliente: " + Venda.getCliente());
                System.out.println("\n--------------------------------\n");
            }
        }
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

        System.out.println("       .--.                   .---.");
        System.out.println("   .---|__|           .-.     |~~~|");
        System.out.println(".--|===|--|_          |_|     |~~~|--.");
        System.out.println("|  |===|  |'\\     .---!~|  .--|   |--|");
        System.out.println("|%%|   |  |.'\\    |===| |--|%%|   |  |");
        System.out.println("|%%|   |  |\\.'\\   |   | |__|  |   |  |");
        System.out.println("|  |   |  | \\  \\  |===| |==|  |   |  |");
        System.out.println("|  |   |__|  \\.'\\ |   |_|__|  |~~~|__|");
        System.out.println("|  |===|--|   \\.'\\|===|~|--|%%|~~~|--|");
        System.out.println("^--^---'--^    `-'`---^-^--^--^---'--'");

        do {
            System.out.println("\nMenu");
            System.out.println("1 - Cadastrar Livro: ");
            System.out.println("2 - Realizar Venda: ");
            System.out.println("3 - Listar livros: ");
            System.out.println("4 - Listar vendas: ");
            System.out.println("5 - Sair do programa: ");
            System.out.print("Digite uma opção: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    livraria.cadastrarLivro();
                    break;
                case 2:
                    livraria.realizarVenda();
                    break;
                case 3:
                    System.out.println(
                            "\nDigite a opção:\n" +
                            "1 - Listar Livros Impressos:\n" +
                            "2 - Listar Livros Eletrônicos:\n" +
                            "3 - Listar Todos os Livros:");
                    int opListar = sc.nextInt();
                    if (opListar == 1) {
                        livraria.listarLivrosImpressos();
                    } else if (opListar == 2) {
                        livraria.listarLivrosEletronicos();
                    } else if (opListar == 3) {
                        livraria.listarLivros();
                    } else {
                        System.out.println("Opção inválida");
                    }
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
