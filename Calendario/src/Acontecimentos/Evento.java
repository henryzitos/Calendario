package Acontecimentos;

public class Evento {
    private int idE, idBase, dia, mes, ano, diaFim, mesFim, anoFim, horaInicio, horaFim, minutoInicio, minutoFim;
    private String nome, dataInicio, dataFim, horarioInicio, horarioFim;

    public Evento(String nome, int dia, int mes, int ano, int diaFim, int mesFim, int anoFim, int horaInicio, int minutoInicio, int horaFim, int minutoFim) {
        this.idE = idBase;
        this.nome = nome;
        this.dia = dia;
        this.diaFim = diaFim;
        this.mes = mes;
        this.mesFim = mesFim;
        this.ano = ano;
        this.anoFim = anoFim;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.minutoInicio = minutoInicio;
        this.minutoFim = minutoFim;

        if (dia > 0 && dia < 10) {
            if (mes > 0 && mes < 10) {
                this.dataInicio = "0" + dia + "/" + "0" + mes + "/" + ano;
            }
            else {
                this.dataInicio = "0" + dia + "/" + mes + "/" + ano;
            }
        } else {
            if (mes > 0 && mes < 10) {
                this.dataInicio = dia + "/" + "0" + mes + "/" + ano;
            }
            else {
                this.dataInicio = dia + "/" + mes + "/" + ano;
            }
        }
        if (dia > 0 && dia < 10) {
            if (mes > 0 && mes < 10) {
                this.dataFim = "0" + dia + "/" + "0" + mes + "/" + ano;
            }
            else {
                this.dataFim = "0" + dia + "/" + mes + "/" + ano;
            }
        } else {
            if (mes > 0 && mes < 10) {
                this.dataFim = dia + "/" + "0" + mes + "/" + ano;
            }
            else {
                this.dataFim = dia + "/" + mes + "/" + ano;
            }
        }
        this.horarioFim = horaFim + "h" + minutoFim;
        idBase++;
    }

    public String getNome() {
        return nome;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public String getHorarioFim() {
        return horarioFim;
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

    public int getDiaFim() {
        return diaFim;
    }

    public void setDiaFim(int diaFim) {
        this.diaFim = diaFim;
    }

    public int getMesFim() {
        return mesFim;
    }

    public void setMesFim(int mesFim) {
        this.mesFim = mesFim;
    }

    public int getAnoFim() {
        return anoFim;
    }

    public void setAnoFim(int anoFim) {
        this.anoFim = anoFim;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(int horaFim) {
        this.horaFim = horaFim;
    }

    public int getMinutoInicio() {
        return minutoInicio;
    }

    public void setMinutoInicio(int minutoInicio) {
        this.minutoInicio = minutoInicio;
    }

    public int getMinutoFim() {
        return minutoFim;
    }

    public void setMinutoFim(int minutoFim) {
        this.minutoFim = minutoFim;
    }
}
