package com.company;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Solicitacao {
    private Date date;
    private Time hora;
    private String solitacao;

    public Solicitacao(Date date, Time hora, String solitacao) {
        this.date = date;
        this.hora = hora;
        this.solitacao = solitacao;
    }
    public Solicitacao() {

    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getSolitacao() {
        return solitacao;
    }

    public void setSolitacao(String solitacao) {
        this.solitacao = solitacao;
    }
}
