public class Pagamento {
    public String cpfPaciente;
    public String nomeProfissional;
    public String data;
    public String tipoPagamento; // "dinheiro", "cartao", "convenio"
    public double valorBase;
    public double desconto;
    public double multa;
    public double valorFinal;
    public int parcelas;


    public Pagamento() {
        this.parcelas = 1;
    }

    public Pagamento(String cpfPaciente, double valor, String tipoPagamento) {
        this.cpfPaciente = cpfPaciente;
        this.valorBase = valor;
        this.valorFinal = valor;
        this.tipoPagamento = tipoPagamento;
        this.parcelas = 1;
    }

    public Pagamento(String cpfPaciente, double valor, String tipoPagamento, int parcelas) {
        this.cpfPaciente = cpfPaciente;
        this.valorBase = valor;
        this.valorFinal = valor;
        this.tipoPagamento = tipoPagamento;
        this.parcelas = parcelas;
    }

    public Pagamento(String cpfPaciente, String nomeProfissional, String data,
                     double valor, String tipoPagamento, int parcelas) {
        this.cpfPaciente = cpfPaciente;
        this.nomeProfissional = nomeProfissional;
        this.data = data;
        this.valorBase = valor;
        this.valorFinal = valor;
        this.tipoPagamento = tipoPagamento;
        this.parcelas = parcelas;
    }


    public double calcular(double valorBase) {
        this.valorBase = valorBase;
        this.valorFinal = valorBase;
        if (this.valorFinal < 0) this.valorFinal = 0;
        return this.valorFinal;
    }

    //DESCONTO
    public double calcular(double valorBase, String tipoConsulta, boolean temConvenio) {
        this.valorBase = valorBase;
        double total = valorBase;
        if (tipoConsulta != null && tipoConsulta.equalsIgnoreCase("retorno")) {
            total = total - (valorBase * 0.20);
        }
        if (temConvenio) {
            total = total - (valorBase * 0.40);
        }
        this.desconto = valorBase - total;
        this.valorFinal = total;
        if (this.valorFinal < 0) this.valorFinal = 0;
        return this.valorFinal;
    }

    // Com desconto e multa pendente
    public double calcular(double valorBase, String tipoConsulta, boolean temConvenio, double multaPendente) {
        double v = calcular(valorBase, tipoConsulta, temConvenio);
        this.multa = multaPendente;
        this.valorFinal = v + multaPendente;
        if (this.valorFinal < 0) this.valorFinal = 0;
        return this.valorFinal;
    }

    public boolean validarParcelas() {
        if (parcelas < 1) return false;
        if (parcelas > 1 && !"cartao".equalsIgnoreCase(tipoPagamento)) return false;
        if (parcelas > 3) return false;
        return true;
    }

    public double valorParcela() {
        if (parcelas <= 0) return valorFinal;
        return valorFinal / parcelas;
    }

    public void exibir() {
        System.out.println("---------------------------------------------");
        System.out.println("Paciente CPF:  " + cpfPaciente);
        if (nomeProfissional != null) System.out.println("Profissional:  " + nomeProfissional);
        if (data != null)             System.out.println("Data:          " + data);
        System.out.println("Valor base:    R$ " + valorBase);
        if (desconto > 0) System.out.println("Desconto:      R$ " + desconto);
        if (multa > 0)    System.out.println("Multa:         R$ " + multa);
        System.out.println("Valor final:   R$ " + valorFinal);
        System.out.println("Tipo:          " + tipoPagamento);
        System.out.println("Parcelas:      " + parcelas + "x de R$ " + valorParcela());
    }
}
