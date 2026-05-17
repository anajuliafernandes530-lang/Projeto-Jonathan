public class Paciente {
    public String nome;
    public String cpf;
    public int idade;
    public String telefone;
    public String convenio;
    public boolean ativo;
    public double multaPendente;

    public Paciente() {
        this.ativo = true;
        this.multaPendente = 0.0;
    }

    public Paciente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.ativo = true;
        this.multaPendente = 0.0;
    }

    public Paciente(String nome, String cpf, int idade, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
        this.ativo = true;
        this.multaPendente = 0.0;
    }

    public Paciente(String nome, String cpf, int idade, String telefone, String convenio) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
        this.convenio = convenio;
        this.ativo = true;
        this.multaPendente = 0.0;
    }

    public void complementar(int idade, String telefone) {
        this.idade = idade;
        this.telefone = telefone;
    }

    public void complementar(int idade, String telefone, String convenio) {
        this.idade = idade;
        this.telefone = telefone;
        this.convenio = convenio;
    }

    public void complementar(String convenio) {
        this.convenio = convenio;
    }

    public void desativar() {
        this.ativo = false;
    }

    public void exibir() {
        System.out.println("---------------------------------------------");
        System.out.println("Nome:      " + nome);
        System.out.println("CPF:       " + cpf);
        System.out.println("Idade:     " + (idade > 0 ? idade : "(nao informada)"));
        System.out.println("Telefone:  " + (telefone != null ? telefone : "(nao informado)"));
        System.out.println("Convenio:  " + (convenio != null ? convenio : "(sem convenio)"));
        System.out.println("Status:    " + (ativo ? "ATIVO" : "INATIVO"));
        if (multaPendente > 0) {
            System.out.println("Multa pendente: R$ " + multaPendente);
        }
    }
}
