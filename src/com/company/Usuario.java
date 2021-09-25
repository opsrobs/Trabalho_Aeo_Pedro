package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {
    private String nome;
    private Date data;
    private String email;
    private String fone;
    private ArrayList<Solicitacao> solicitacoes = new ArrayList<>();

    public void addSolicitacao(Solicitacao solicitacao){
        this.solicitacoes.add(new Solicitacao());
    }

    public Usuario(String nome, Date data, String email, String fone) {
        this.nome = nome;
        this.data = data;
        this.email = email;
        this.fone = fone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
}
