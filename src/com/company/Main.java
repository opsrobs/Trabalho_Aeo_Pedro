package com.company;

import java.sql.Time;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
    ArraysRandons aleatorio= new ArraysRandons();
	Utils utils = new Utils();
    Usuario usuario;
    Solicitacao solicitacao= new Solicitacao();

    Atendimento atendimento;


    String nome;
    Date date;
    String email,hora;
    String fone;
    String st;
    String descSolicitacao;

    nome=utils.random(aleatorio.nomes());
    while(!nome.equalsIgnoreCase("Fim")){
        date=utils.converterData(utils.random(aleatorio.datasDeInclusao()));
        email=utils.random(aleatorio.email());
        fone=utils.random(aleatorio.telefone());
        utils.addUsuarios(nome,date,email,fone);

        descSolicitacao=utils.random(aleatorio.descricao());
        while (!descSolicitacao.equalsIgnoreCase("fim")){
            usuario=new Usuario(nome,date,email,fone);
            date=utils.converterData(utils.random(aleatorio.datasDeInclusao()));
            solicitacao = new Solicitacao(date,utils.converterHora(),descSolicitacao);
            hora=utils.converterHora();
            st=utils.condicaoAtentimento(utils.randomN(aleatorio.status()));
            date=utils.converterData(utils.random(aleatorio.datasDeAtendimento()));
            atendimento = new Atendimento(usuario,date,solicitacao ,st);
            usuario.adicinorSolicitacao(date,hora,descSolicitacao);

            descSolicitacao=utils.random(aleatorio.descricao());

        }
        nome=utils.random(aleatorio.nomes());

    }
        System.out.println(utils.dadosUsuario());
        System.out.println(solicitacao.toString());
    }
}
