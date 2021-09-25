package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Atendimento {
    private Usuario usuario;
    private Date dataDeAtentimento;
    private Solicitacao solicitacao;
    private String status;

    public Atendimento(Usuario usuario, Date dataDeAtentimento, Solicitacao solicitacao, String status) {
        this.usuario = usuario;
        this.dataDeAtentimento = dataDeAtentimento;
        this.solicitacao = solicitacao;
        this.status = status;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataDeAtentimento() {
        return dataDeAtentimento;
    }

    public void setDataDeAtentimento(Date dataDeAtentimento) {
        this.dataDeAtentimento = dataDeAtentimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Atendimento: " +
                "\nUsuario: " + usuario +
                "\nData de atentimento: " + dataDeAtentimento +
                "\nSolicitacao: " + solicitacao +
                "\nStatus: " + status;
    }
}
