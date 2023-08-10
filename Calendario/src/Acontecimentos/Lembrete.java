package Acontecimentos;

public class Lembrete {
    private int idL, idBase, dia, mes, ano, hora, minutos;
    private String nome, data, horario;

    public Lembrete(String nome, int dia, int mes, int ano, int hora, int minutos) {
        this.idL = idBase;
        this.nome = nome;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.hora = hora;
        this.minutos = minutos;
        if (dia > 0 && dia < 10) {
            if (mes > 0 && mes < 10) {
                this.data = "0" + dia + "/" + "0" + mes + "/" + ano;
            }
            else {
                this.data = "0" + dia + "/" + mes + "/" + ano;
            }
        } else {
            if (mes > 0 && mes < 10) {
                this.data = dia + "/" + "0" + mes + "/" + ano;
            }
            else {
                this.data = dia + "/" + mes + "/" + ano;
            }
        }
        this.horario = hora + "h" + minutos;
        idBase++;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
}