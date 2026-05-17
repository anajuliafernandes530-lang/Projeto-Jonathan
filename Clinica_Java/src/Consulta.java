public class Consulta {
    public String cpfPaciente;
    public String nomeProfissional;
    public String especialidade;
    public String data;   // formato "DD/MM/AAAA"
    public String hora;   // formato "HH:MM"
    public String tipo;   // "inicial", "retorno", "avaliacao"
    public String status; // "agendada", "realizada", "cancelada", "remarcada"
    public String motivoCancelamento;
    public String observacoes;
    public String diagnostico;
    public String[] procedimentos; // tamanho fixo 10
    public int qtdProcedimentos;   // contadora
    public double valorCobrado;

    public Consulta() {
        this.procedimentos = new String[10];
        this.qtdProcedimentos = 0;
        this.status = "agendada";
        this.tipo = "inicial";
    }

    public Consulta(String cpfPaciente, String nomeProfissional, String data, String hora) {
        this.cpfPaciente = cpfPaciente;
        this.nomeProfissional = nomeProfissional;
        this.data = data;
        this.hora = hora;
        this.tipo = "inicial";
        this.status = "agendada";
        this.procedimentos = new String[10];
        this.qtdProcedimentos = 0;
    }

    public Consulta(String cpfPaciente, String nomeProfissional, String data, String hora, String tipo) {
        this.cpfPaciente = cpfPaciente;
        this.nomeProfissional = nomeProfissional;
        this.data = data;
        this.hora = hora;
        this.tipo = tipo;
        this.status = "agendada";
        this.procedimentos = new String[10];
        this.qtdProcedimentos = 0;
    }

    public Consulta(String cpfPaciente, String nomeProfissional, String especialidade,
                    String data, String hora, String tipo) {
        this.cpfPaciente = cpfPaciente;
        this.nomeProfissional = nomeProfissional;
        this.especialidade = especialidade;
        this.data = data;
        this.hora = hora;
        this.tipo = tipo;
        this.status = "agendada";
        this.procedimentos = new String[10];
        this.qtdProcedimentos = 0;
    }


    public void registrarAtendimento(String observacoes) {
        this.observacoes = observacoes;
        this.status = "realizada";
    }

    public void registrarAtendimento(String observacoes, String diagnostico) {
        this.observacoes = observacoes;
        this.diagnostico = diagnostico;
        this.status = "realizada";
    }

    public void registrarAtendimento(String observacoes, String diagnostico,
                                     String[] procedimentos, int qtd) {
        this.observacoes = observacoes;
        this.diagnostico = diagnostico;
        int i = 0;
        while (i < qtd && this.qtdProcedimentos < 10) {
            this.procedimentos[this.qtdProcedimentos] = procedimentos[i];
            this.qtdProcedimentos = this.qtdProcedimentos + 1;
            i = i + 1;
        }
        this.status = "realizada";
    }

    public boolean adicionarProcedimento(String procedimento) {
        if (qtdProcedimentos >= 10) return false;
        procedimentos[qtdProcedimentos] = procedimento;
        qtdProcedimentos = qtdProcedimentos + 1;
        return true;
    }

    public void cancelar() {
        this.status = "cancelada";
    }

    public void cancelar(String motivo) {
        this.status = "cancelada";
        this.motivoCancelamento = motivo;
    }

    public void exibir() {
        System.out.println("---------------------------------------------");
        System.out.println("Paciente CPF:  " + cpfPaciente);
        System.out.println("Profissional:  " + nomeProfissional);
        if (especialidade != null) System.out.println("Especialidade: " + especialidade);
        System.out.println("Data/Hora:     " + data + " " + hora);
        System.out.println("Tipo:          " + tipo);
        System.out.println("Status:        " + status);
        if (observacoes != null) System.out.println("Observacoes:   " + observacoes);
        if (diagnostico != null) System.out.println("Diagnostico:   " + diagnostico);
        if (qtdProcedimentos > 0) {
            System.out.println("Procedimentos:");
            int i = 0;
            while (i < qtdProcedimentos) {
                System.out.println("  - " + procedimentos[i]);
                i = i + 1;
            }
        }
        if (motivoCancelamento != null) {
            System.out.println("Motivo cancelamento: " + motivoCancelamento);
        }
    }
}
