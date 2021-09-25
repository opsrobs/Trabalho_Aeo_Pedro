package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {
    private String nome;
    private Date data;
    private String email;
    private String fone;
    ArrayList<Solicitacao> solicitacoes = new ArrayList<>();

    public void adicinorSolicitacao(Date date, String hora, String solitacao){
        this.solicitacoes.add(new Solicitacao(date,hora,solitacao));
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

    public int qtd (int index){
        int qtds=0;
        for ( index = 0; index < solicitacoes.size(); index++) {
         qtds++;
        }
        return qtds;
    }

    public ArrayList<Solicitacao> getSolicitacoes() {
        return solicitacoes;
    }



    public Usuario(String nome, Date data, String email, String fone) {

        this.nome = nome;
        this.data = data;
        this.email = email;
        this.fone = fone;
    }

    @Override
    public String toString() {
        return "\nUsuario: " +nome +
                "\nData: " + data +
                "\nEmail: " + email +
                "\nFone: " + fone +
                "\nSolicitacoes: " + solicitacoes.toString()+" ";
    }
}
