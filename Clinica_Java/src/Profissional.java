// Classe Profissional - sem herança, tudo público.
public class Profissional {
    public String nome;
    public String especialidade; // "clinica geral", "fisioterapia", "psicologia", "nutricao"
    public String registro;
    public double valorConsulta;
    public String[] diasAtendimento; // array com tamanho fixo
    public int qtdDias;              // variavel contadora

    // ---------- SOBRECARGA DE CONSTRUTORES (4) ----------
    public Profissional() {
        this.diasAtendimento = new String[7];
        this.qtdDias = 0;
    }

    public Profissional(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.diasAtendimento = new String[7];
        this.qtdDias = 0;
    }

    public Profissional(String nome, String especialidade, String registro, double valorConsulta) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.registro = registro;
        this.valorConsulta = valorConsulta;
        this.diasAtendimento = new String[7];
        this.qtdDias = 0;
    }

    public Profissional(String nome, String especialidade, String registro,
                        double valorConsulta, String[] dias, int qtd) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.registro = registro;
        this.valorConsulta = valorConsulta;
        this.diasAtendimento = new String[7];
        this.qtdDias = 0;
        int i = 0;
        while (i < qtd && i < 7) {
            this.diasAtendimento[this.qtdDias] = dias[i];
            this.qtdDias = this.qtdDias + 1;
            i = i + 1;
        }
    }

    // ---------- SOBRECARGA DE MÉTODOS ----------
    public void atualizar(String registro, double valorConsulta) {
        this.registro = registro;
        this.valorConsulta = valorConsulta;
    }

    public void atualizar(String registro, double valorConsulta, String[] dias, int qtd) {
        this.registro = registro;
        this.valorConsulta = valorConsulta;
        this.qtdDias = 0;
        int i = 0;
        while (i < qtd && i < 7) {
            this.diasAtendimento[this.qtdDias] = dias[i];
            this.qtdDias = this.qtdDias + 1;
            i = i + 1;
        }
    }

    public boolean atendeNoDia(String dia) {
        int i = 0;
        while (i < qtdDias) {
            if (diasAtendimento[i].equalsIgnoreCase(dia)) {
                return true;
            }
            i = i + 1;
        }
        return false;
    }

    public boolean atendeNoDia(String dia, boolean exigirValor) {
        if (exigirValor && this.valorConsulta <= 0) {
            return false;
        }
        return atendeNoDia(dia);
    }

    public void exibir() {
        System.out.println("---------------------------------------------");
        System.out.println("Nome:          " + nome);
        System.out.println("Especialidade: " + especialidade);
        System.out.println("Registro:      " + (registro != null ? registro : "(nao informado)"));
        System.out.println("Valor:         " + (valorConsulta > 0 ? "R$ " + valorConsulta : "(nao definido)"));
        System.out.print("Dias:          ");
        if (qtdDias == 0) {
            System.out.println("(nao definidos)");
        } else {
            int i = 0;
            while (i < qtdDias) {
                System.out.print(diasAtendimento[i]);
                if (i < qtdDias - 1) System.out.print(", ");
                i = i + 1;
            }
            System.out.println();
        }
    }
}
