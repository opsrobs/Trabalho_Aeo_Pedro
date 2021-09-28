package com.company;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Utils {
    ArraysRandons randons = new ArraysRandons();
    ArrayList<Usuario> usuarios = new ArrayList<>();

    public void addUsuarios(String nome, Date data, String email, String fone,ArrayList<Atendimento> atendimentos){
        this.usuarios.add(new Usuario(nome,data,email,fone, atendimentos));
    }

    //métodos randomicos
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

    public int tamanhoUuarios(){
        return this.usuarios.size();
    }
    public int tamanhoAtendimentos(){
        int atendimentos=0;
        for (Usuario usuario : this.usuarios) {
            atendimentos = usuario.getAtendimentos().size();
        }
        return atendimentos;
    }

    public String limiteLista(int tam){
        String nome;
        if (this.tamanhoUuarios()==tam || this.tamanhoAtendimentos()==tam){
            nome="fim";
        }else
            nome=this.random(randons.nomes());
        return nome;
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
    public int opcaoMenu(){
        return Integer.parseInt(JOptionPane.showInputDialog(this.separador() +"\n"+
                "1.Um relatório de todos os usuários contendo todos os seus dados mais a quantidade de solicitações;\n" +
                "2.Um relatório de todos os usuários com seus respectivos atendimentos;\n" +
                "3.Um relatório com as solicitação do suporte e quantos dias demorou para efetuar o atendimento;\n" +
                "4.Um relatório com as solicitação do suporte cujo atendimento demorou mais de dois dias;\n" +
                "5.Qual a média de dias para se efetuar um atendimento"+"\n"+this.separador()));
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

    public float qtdAtendimentos(){
        float qtd=0;
        for (Usuario usuario : this.usuarios) {
            for (Atendimento atendimento: usuario.getAtendimentos()) {
                qtd += usuario.getAtendimentos().size();
            }
        }
        return qtd;
    }

    public String dadosUsuario(){
        StringBuilder dados= new StringBuilder();
        for (Usuario usuario : this.usuarios) {
            int tam = 0;
            for (Atendimento atendimento: usuario.getAtendimentos()) {
                tam = usuario.getAtendimentos().size();
            }
            dados.append(usuario).append(" ").append(tam).append(this.msgQtd(tam)).append("\n");
        }
        return dados.toString();
    }

//    Um relatório de todos os usuários com seus respectivos atendimentos;

    public String usuario(){
        StringBuilder relatorio= new StringBuilder();
        for (Usuario u : usuarios){
            relatorio.append(u.toString()).append(u.getAtendimentos());
        }
        return relatorio.toString();
    }

//    Um relatório com as solicitação do suporte e quantos dias demorou para efetuar o atendimento;

    public Date dataSolicitacao(){
        Date dataSolicitacao=new Date();
        for (Usuario usuario : this.usuarios) {
            for (int j = 0; j < usuario.getAtendimentos().size(); j++) {
                dataSolicitacao = usuario.getAtendimentos().get(j).getSolicitacao().getDate();
            }
        }
        return dataSolicitacao;
    }
    public Date dataAtendimento(){
        Date dataAtendimento=new Date();
        for (Usuario usuario : this.usuarios) {
            for (int j = 0; j < usuario.getAtendimentos().size(); j++) {
                dataAtendimento = usuario.getAtendimentos().get(j).
                        getDataDeAtentimento();
            }
        }
        return dataAtendimento;
    }

    public String relatorioDemoraAtendimento(){
        StringBuilder relatorio= new StringBuilder();
        Date dataSolicitacao, dataAtendimento;
        long dia;
        for (Usuario usuario : this.usuarios) {
            for (int j = 0; j < usuario.getAtendimentos().size(); j++) {
                dataSolicitacao = usuario.getAtendimentos().get(j).getSolicitacao().getDate();
                dataAtendimento = usuario.getAtendimentos().get(j).getDataDeAtentimento();
                dia = convert(dataAtendimento) - convert(dataSolicitacao);
                relatorio.append(usuario.getAtendimentos().get(j).getSolicitacao()).append(" ").append(dia).append(" Dias");
            }
        }
        return relatorio.toString();
    }



    public long convert(@NotNull Date data){
        return TimeUnit.DAYS.convert((data.getTime()),TimeUnit.MILLISECONDS);
    }

    public boolean tempo(long atendimento, long solicitacao){
        return atendimento - solicitacao >2;
    }

    public String relatorioTempoAtendimento(){
        StringBuilder relatorio= new StringBuilder();
        Date dataSolicitacao, dataAtendimento;
        for (Usuario usuario : this.usuarios) {
            for (int j = 0; j < usuario.getAtendimentos().size(); j++) {
                dataSolicitacao = usuario.getAtendimentos().get(j).getSolicitacao().getDate();
                dataAtendimento = usuario.getAtendimentos().get(j).getDataDeAtentimento();
                if (tempo(convert(dataAtendimento), convert(dataSolicitacao))) {
                    relatorio.append(usuario.getAtendimentos().get(j).getSolicitacao().toString());
                }
            }
        }
        return relatorio.toString();
    }

    public float totalDias(){
        long dia=0;
        for (Usuario usuario : this.usuarios) {
            for (int j = 0; j < usuario.getAtendimentos().size(); j++) {
                dia += convert(usuario.getAtendimentos().get(j).getDataDeAtentimento());
            }
        }
        return Float.parseFloat(String.valueOf(dia));
    }

    public float diasSolicitacao(){
        long dia=0;
        for (Usuario usuario : this.usuarios) {
            for (int j = 0; j < usuario.getAtendimentos().size(); j++) {
                dia += convert(usuario.getAtendimentos().get(j).getSolicitacao().getDate());
            }
        }
        return Float.parseFloat(String.valueOf(dia));
    }

    public float diasParaAtendimento(){
        return this.totalDias()-this.diasSolicitacao();
    }

    public double mediaDiaAtendimento(){
        return this.diasParaAtendimento()/ this.qtdAtendimentos();
    }
    public int maiorEmail(){
        int email=15;
        for (Usuario usuario : this.usuarios) {
            if (usuario.getEmail().length() > email) {
                email = usuario.getEmail().length();
            }
        }
        return email;
    }

    public String separador(){
        StringBuilder sep= new StringBuilder("###############");
        for (int i = 0; i <= this.maiorEmail(); i++) {
            sep.append("#");
        }
     return sep.toString();
    }

    public void menu(int op){
        if (this.tamanhoUuarios()<1){
            JOptionPane.showMessageDialog(null,"Não há informações a serem apresentadas. Tente novamente!!\n" +
                    "(ESTE PROGRAMA GERA DADOS AUTOMATICAMENTE)");
        }else

        do {
            switch (op){
                case 1: JOptionPane.showMessageDialog(null,this.dadosUsuario()+"\n"+ this.separador());
                    break;
                case 2: JOptionPane.showMessageDialog(null,this.usuario()+"\n"+this.separador());
                    break;
                case 3: JOptionPane.showMessageDialog(null,this.relatorioDemoraAtendimento()+"\n"+this.separador());
                    break;
                case 4: JOptionPane.showMessageDialog(null,this.relatorioTempoAtendimento()+"\n"+this.separador());
                    break;
                case 5:JOptionPane.showMessageDialog(null, "A média de dias para atendimento foi de: \n" +
                        this.mediaDiaAtendimento());
            }
        }while (op>5);


    }
}
