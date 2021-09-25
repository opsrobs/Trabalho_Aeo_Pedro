package com.company;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Solicitacao {
    private Date date;
    private String hora;
    private String solitacao;

    public Solicitacao(Date date, String hora, String solitacao) {
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getSolitacao() {
        return solitacao;
    }

    public void setSolitacao(String solitacao) {
        this.solitacao = solitacao;
    }

    @Override
    public String toString() {
        return "Solicitacao: " +
                "\n\tData: " + date +
                "\n\tHora: " + hora +
                "\n\tSolitacao: " + solitacao;
    }
}
