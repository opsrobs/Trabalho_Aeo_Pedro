package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {
    private String nome;
    private Date data;
    private String email;
    private String fone;
    private ArrayList<Atendimento> atendimentos = new ArrayList<>();

    public Usuario(String nome, Date data, String email, String fone, ArrayList<Atendimento> atendimentos) {
        this.nome = nome;
        this.data = data;
        this.email = email;
        this.fone = fone;
        this.atendimentos = atendimentos;
    }
    public Usuario() {

    }

    public void adicinorAtendimentos(Atendimento atendimento, int tamLista){
        if(atendimentos.size()<= tamLista) {
            this.atendimentos.add(atendimento);
        }
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

    public ArrayList<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(ArrayList<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

    public Usuario(String nome, Date data, String email, String fone) {

        this.nome = nome;
        this.data = data;
        this.email = email;
        this.fone = fone;
    }

    @Override
    public String toString() {
        return "\n----------------------" +
                "\nUsuario: " +nome +
                "\nData: " + data +
                "\nEmail: " + email +
                "\nFone: " + fone;
    }
}
