package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Atendimento {
    private Date dataDeAtentimento;
    private String status;
    private Solicitacao solicitacao;

    public Atendimento(Date dataDeAtentimento, String status, Solicitacao solicitacao) {

        this.dataDeAtentimento = dataDeAtentimento;
        this.status = status;
        this.solicitacao = solicitacao;
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

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }
        @Override
    public String toString() {
        return "Atendimento: " +
                "\n\tData de atentimento: " + dataDeAtentimento +
                "\n\tSolicitacao: " + solicitacao +
                "\n\tStatus: " + status;
    }
}
