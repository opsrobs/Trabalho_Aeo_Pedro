package com.company;



import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Utils {
    ArrayList<Usuario> usuarios = new ArrayList<>();

    public void addUsuarios(String nome, Date data, String email, String fone){
        this.usuarios.add(new Usuario(nome,data,email,fone));
    }
    public String random(String[] randomize){
        Random random = new Random();
        int index = random.nextInt(randomize.length);
        return randomize[index];
    }

    public int randomN(int[] randomize){
        Random random = new Random();
        int index = random.nextInt(randomize.length);
        return randomize[index];
    }

    public String getNome(){
        return JOptionPane.showInputDialog("Informe o nome do usuario");
    }
    public String getData(){
        return JOptionPane.showInputDialog("Informe a data [DD/MM/AAAA]: ");
    }
    public String getEmail(){
        return JOptionPane.showInputDialog("Informe o email!");
    }
    public String getTelefone(){
        return JOptionPane.showInputDialog("Informe o telefone[xx-xxxxx-xxxx]");
    }


    public Date converterData(String d){
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date();
        boolean dataValida;
        do{

            try {
                data= dataFormatada.parse(d);
                dataValida=true;
            }
            catch (Exception e)
            {
                dataValida=false;
            }
        }
        while (!dataValida);
        return data;
    }

    public String converterHora(){
        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("hh:mm:ss");
        String hora = "";
        boolean dataValida;
        do{

            try {
                hora= dataFormatada.format(LocalDateTime.now());
                dataValida=true;
            }
            catch (Exception e)
            {
                dataValida=false;
            }
        }
        while (!dataValida);
        return hora;
    }

    //utilitarios atendimento

    public String condicaoAtentimento(int condicao){

        String status="";
        do{
            switch (condicao){
                case 1: status="Atendido";
                break;
                case 2: status="Em analise";
                break;
                case 3: status="Recusado";
                break;
            }
        }while (condicao>3);
            return status;

    }

    public int getStatusAteatimento(){
        return Integer.parseInt(JOptionPane.showInputDialog("Informe a condicção do atendimento:" +
                "\n[1]Atendido\n" +
                "[2]Em analise\n" +
                "[3]Recusado."));

    }
    //utilitarios Solicitacao

    public Date getHoraLocal(){
        return Calendar.getInstance().getTime();

    }

    public String getDescricaoSolicitacao(){
        return JOptionPane.showInputDialog("INforme a descrição de sua solicitação!!");
    }

//    Um relatório de todos os usuários contendo todos os seus dados mais a quantidade de solicitações;
    public String msgQtd(int qtd){
        if (qtd <= 0){
            return " Sem solicitações!";
        }else if (qtd ==1){
            return " Solicitação!";
        }
        else
        return " Solicitações!";
    }


    public String dadosUsuario(){
        String dados="";
        for (int i = 0; i < this.usuarios.size(); i++) {
            int cont=usuarios.get(i).qtd(i);

            dados+=usuarios.toString()+" " +this.msgQtd(cont);

        }
        return dados;
    }

}
