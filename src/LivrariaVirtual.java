public class LivrariaVirtual {
    private static int MAX_IPRESSOS = 10;
    private static int MAX_ELETRONICOS = 20;
    private static int MAX_VENDAS = 50;
    private int numImpressos;
    private int numEletronicos;
    private int numVendas;

    public void cadastrarLivro(){

    }

    @Override
    public String toString() {
        return "LivrariaVirtual{" +
                "numImpressos=" + numImpressos +
                ", numEletronicos=" + numEletronicos +
                ", numVendas=" + numVendas +
                '}';
    }

    public static int getMaxIpressos() {
        return MAX_IPRESSOS;
    }

    public static void setMaxIpressos(int maxIpressos) {
        MAX_IPRESSOS = maxIpressos;
    }

    public static int getMaxEletronicos() {
        return MAX_ELETRONICOS;
    }

    public static void setMaxEletronicos(int maxEletronicos) {
        MAX_ELETRONICOS = maxEletronicos;
    }

    public static int getMaxVendas() {
        return MAX_VENDAS;
    }

    public static void setMaxVendas(int maxVendas) {
        MAX_VENDAS = maxVendas;
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
}
