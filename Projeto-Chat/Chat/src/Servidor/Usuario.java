package Servidor;

import java.io.*;
import java.net.*;

public class Usuario
{
    protected String         nomeSala;
    protected String         nick;
    protected Socket         conexao;
    protected BufferedReader receptor;
    protected PrintWriter    transmissor;

    // construtor de usuario instancia BufferedReader e PrintWriter, 
    // interage atraves deles com o usuario para enviar a lista de
    // salas e obter a sala onde o usuario quer entrar, bem como o
    // seu nick, inicializando this.sala e this.nick
    
    public Usuario (String nomSl, Socket conexao) throws Exception {
    	
    }

    // getters para nomeSala e nick
    // metodos para desconectar

    // recebe do usuario, usando this.receptor
    
    //public String recebe () {}

    // envia para o usuario, usando this.transmissor
    public void   envia  (String s) throws Exception {}

    // metodos obrigatorios
    
    public void setNick(String n) throws Exception
    { 
    	if(n.equals(""))
    		throw new Exception("Parametro do nick invalido");
    	
    	this.nick = n;
    	
    }
    public String nickUsuario()
    {
    	return this.nick;
    }
}