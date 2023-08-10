package Acontecimentos;

public class Tarefa {
    private int idT, idBase, dia, mes, ano;
    private String nome, data;

    public Tarefa(String nome, int dia, int mes, int ano) {
        this.idT = idBase;
        this.nome = nome;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
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
        idBase++;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
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
}
