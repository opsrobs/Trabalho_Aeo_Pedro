package com.company;

import java.sql.Time;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	Utils utils = new Utils();
    Usuario usuario;
    Atendimento atendimento;
    Solicitacao solicitacao;

    String nome;
    Date date;
    String email,d;
    String fone;
    String st;
    String descSolicitacao;

    nome=utils.getNome();
    while(!nome.equalsIgnoreCase("Fim")){
        date=utils.converterData(utils.getData());
        email=utils.getEmail();
        fone=utils.getTelefone();

        usuario= new Usuario(nome,date,email,fone);
        date=utils.converterData(utils.getData());
        descSolicitacao=utils.getDescricaoSolicitacao();

        solicitacao = new Solicitacao(date,utils.getHora(),descSolicitacao);
        usuario.addSolicitacao(solicitacao);

        st=utils.condicaoAtentimento(utils.getStatusAteatimento());

        date=utils.converterData(utils.getData());
        atendimento = new Atendimento(usuario,date,solicitacao ,st);
        nome=utils.getNome();
    }
    }
}
