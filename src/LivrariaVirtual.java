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
                sc.nextLine();

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

        int totalLivrosDisponiveis = 0;
        for (int i = 0; i < numImpressos; i++) {
            totalLivrosDisponiveis += impressos[i].getEstoque();
        }

        totalLivrosDisponiveis += numEletronicos;

        if (qtdLivros > totalLivrosDisponiveis) {
            System.out.println("Quantidade de livros solicitada maior que o estoque disponível");
            return;
        }

        Venda venda = new Venda(qtdLivros, cliente);

        for (int i = 0; i < qtdLivros; i++) {
            System.out.println((i + 1) + "º Livro");
            System.out.println("Escolha o tipo de livro:\n1 - Impresso\n2 - Eletrônico");
            int tipo = sc.nextInt();
            sc.nextLine();

            if (tipo != 1 && tipo != 2) {
                System.out.println("Opção inválida.");
                i--;
                continue;
            }

            boolean livroAdicionado = false;

            if (tipo == 1) {
                listarLivrosImpressos();
                System.out.println("Escolha o índice do livro impresso: ");
                int indice = sc.nextInt() - 1;
                sc.nextLine();

                if (indice >= 0 && indice < numImpressos) {
                    Impresso livroEscolhido = impressos[indice];
                    if (livroEscolhido.getEstoque() <= 0) {
                        System.out.println("Estoque do livro impresso está esgotado.");
                        i--;
                        continue;
                    }
                    venda.addLivro(livroEscolhido, i);
                    livroEscolhido.atualizarEstoque();
                    livroAdicionado = true;
                } else {
                    System.out.println("Índice inválido.");
                }
            } else if (tipo == 2) {
                listarLivrosEletronicos();
                System.out.println("Escolha o índice do livro eletrônico: ");
                int indice = sc.nextInt() - 1;
                sc.nextLine();

                if (indice >= 0 && indice < numEletronicos) {
                    venda.addLivro(eletronicos[indice], i);
                    livroAdicionado = true;
                } else {
                    System.out.println("Índice inválido");
                }
            } else {
                System.out.println("Opção inválida.");
                i--;
                continue;
            }

            if (!livroAdicionado) {
                System.out.println("Erro ao adicionar o livro. Venda não realizada.");
                return;
            }
        }

        vendas[numVendas] = venda;
        numVendas++;
        venda.listarLivros();
        System.out.println("Venda Realizada com Sucesso!");
    }


    public void listarLivrosImpressos() {
        if (numImpressos == 0) {
            System.out.println("\nNenhum livro impresso");
        } else {
            System.out.print("\n===== Livros Impressos =====\n");
            for (int i = 0; i < numImpressos; i++) {
                System.out.println("Livro " + (i + 1) + ":");
                System.out.println(impressos[i].toString());
                System.out.println("-----------------------------\n");
            }
        }
    }

    public void listarLivrosEletronicos() {
        if (numEletronicos == 0) {
            System.out.println("\nNenhum livro eletrônico");
        } else {
            System.out.println("\n===== Livros Eletrônicos =====\n");
            for (int i = 0; i < numEletronicos; i++) {
                System.out.println("Livro " + (i + 1) + ":");
                System.out.println(eletronicos[i].toString());
                System.out.println("-----------------------------\n");
            }
        }
    }

    private void listarLivros() {
        if (numImpressos == 0 && numEletronicos == 0) {
            System.out.println("\nNenhum Livro Cadastrado");
        } else {
            System.out.println("\n===== Listagem de Livros =====");
            if (numImpressos > 0) {
                listarLivrosImpressos();
            }

            if (numEletronicos > 0) {
                listarLivrosEletronicos();
            }

            System.out.println("\n===== ====== =====\n");
        }
    }

    private void listarVendas() {
        if (numVendas == 0) {
            System.out.println("Nenhuma Venda Realizada!");
        } else {
            System.out.println("\n===== Lista de Vendas =====\n");
            for (int i = 0; i < numVendas; i++) {
                Venda venda = vendas[i];
                System.out.println("--------------------------------");
                System.out.println("Venda " + (i + 1) + ":");
                venda.listarLivros();
                System.out.println("Cliente: " + venda.getCliente());
                System.out.println("Valor: R$ " + venda.getValor());
                System.out.println("--------------------------------\n");
            }
            System.out.println("===== ====== =====\n");
        }
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
                    switch (opListar) {
                        case 1:
                            livraria.listarLivrosImpressos();
                            break;
                        case 2:
                            livraria.listarLivrosEletronicos();
                            break;
                        case 3:
                            livraria.listarLivros();
                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
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
