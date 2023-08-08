package Acontecimentos;

public class Tarefa {
    private int dia, mes, ano;
    private String nome, descricao, data;

    public Tarefa(String nome, int dia, int mes, int ano) {
        this.nome = nome;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.descricao = descricao;
        this.data = dia + "/" + mes + "/" + ano;
    }

    public String getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
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
