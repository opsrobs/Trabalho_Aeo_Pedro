package com.company;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
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
        SimpleDateFormat dataFormatada = new SimpleDateFormat(")dd/MM/yyyy");
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
        return Integer.parseInt(JOptionPane.showInputDialog("Informe a condicção do atendimento:\n[1]atendido\n[2]Em analise\n [3]Recusado."));
    }
}
