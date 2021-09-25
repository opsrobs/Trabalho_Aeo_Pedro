package com.company;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
	Utils utils = new Utils();
    Usuario usuario;
    Atendimento atendimento;

    String nome;
    Date date;
    String email,d;
    String fone;
    String st;

    nome=utils.getNome();
    while(!nome.equalsIgnoreCase("Fim")){
        date=utils.converterData(utils.getData());
        email=utils.getEmail();
        fone=utils.getTelefone();

        usuario= new Usuario(nome,date,email,fone);
        date=utils.converterData(utils.getData());
        st=utils.condicaoAtentimento(utils.getStatusAteatimento());

        atendimento = new Atendimento(usuario,date,st);

    }
    }
}
