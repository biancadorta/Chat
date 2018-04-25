package Servidor;

import java.io.*;
import java.net.*;

public class Usuario
{
    protected String         nomeSala;
    protected String         nick;
    protected Socket         conexao;
    protected ObjectInputStream receptor;
    protected ObjectOutputStream  transmissor; 
    protected Texto text;
    
    
    public Usuario (String[] nomSl, Socket conexao1) throws Exception {
    	if(nomSl.equals("") || conexao1.equals(""))
    		throw new Exception("Valores invalidos(class Usuario)");
    	
    	//this.nomeSala = nomSl;
    	this.conexao = conexao1;
    	
    	// construtor de usuario instancia ObjectOutputStream e ObjectinputStream
    	this.receptor    = new ObjectInputStream(this.conexao.getInputStream());
    	this.transmissor = new ObjectOutputStream(this.conexao.getOutputStream());
    	
    	this.transmissor.writeObject(nomSl);
    	this.nomeSala = (String)receptor.readObject();
    	this.nick     = (String)receptor.readObject();
    	   	
    	// interage atraves deles com o usuario para enviar a lista de
        // salas e obter a sala onde o usuario quer entrar, bem como o
        // seu nick, inicializando this.nomeSala e this.nick   	
    }   
    
    // metodos para desconectar

    // recebe do usuario, usando this.receptor    
    public Object recebe () throws ClassNotFoundException, IOException {
    	return (Object)this.receptor.readObject();
    }

    // envia para o usuario, usando this.transmissor
    public void   envia  (Serializable s) throws Exception {  //teria que enviar um Texto
    	//Colocar Serializable para nao dar excecao, teoricamente seria como Object
    	if(s.equals(""))
    		throw new Exception("String invalida");
    	
    	this.transmissor.writeObject(s);
    }

    // metodos obrigatorios
    // getters para nomeSala e nick
    public String getNomeSala() {
		return nomeSala;
	}
	
	public String getNick() {
		return nick;
	}

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