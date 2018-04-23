package Servidor;

import java.net.Socket;
import Servidor.Sala;
import Servidor.Usuario;
import Servidor.Salas;

public class TratadorDeConexao extends Thread
{
    protected Sala                  sala;
    //protected ListaOrdenada<String> nick=new ListaOrdenada<String>();
    protected Usuario               usuario;
    protected boolean               fim=false;

    public void pare ()
    {
        this.fim=true;
    }

    public void run ()
    {
        while (!fim)
        {
          /* ListaOrdenada<String> nicksAtuais = this.salas.getNicks();
           ListaOrdenada<String> entrou = nicksAtuais.menos(this.nick);
           ListaOrdenada<String> saiu   = this.nick.menos(nicksAtuais);
           // para cada string s da lista entrou
           // this.usuario.envia("+") e this.usuario.envia(s)
           // para cada string s da lista saiu
           // this.usuario.envia("-") e this.usuario.envia(s)

           // receber de this.usuario 1 comando do protocolo
           // com complementos (pode ser "SAI", se usuario quer
           // sair, "MSG"+"DESTINATARIO"+"TEXTO" se quer mandar
           // mensagem, ou "MSG"+"REMENTENTE"+"TEXTO"

           // tratar o "SAI" (parar a thread e tirar da sala) ou
           // (destinatario pode ser 1 especifico ou TODOS) e
           if (destinatario.equals("TODOS"))
               // loop para mandar para cada nick i em nicksAtuais
               Usuario usr = this.sala.getUsuario (nicksAtuais[i]);
               usr.envia("msg"); // as letras M, S e G
               usr.envia(nick do remetente);
               usr.envia(texto da mensagem);
           else
               Usuario usr = this.sala.getUsuario (destinatario);
               usr.envia("msg"); // as letras M, S e G
               usr.envia(nick do remetente);
               usr.envia(texto da mensagem);*/
        }
    }

    public TratadorDeConexao (Salas salas, Socket conexao)
    {
        /*String[] nomesSalas = salas.getNomesSalas();
        //this.usuario = new Usuario (nomesSalas, conexao);
        // construtor de usuario instancia BufferedReader e PrintWriter
        // e interage com o usuario atraves deles para obter o nick
        // e a sala (mande as salas para ele escolher)

        String nomeSala = this.usuario.getNomeSala();
        this.sala       = salas.getSala (nomeSala);
        this.sala.entra (this.usuario);*/ 
    }
}