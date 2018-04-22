package Janela.Cliente;

import java.io.Serializable;

public class Texto implements Serializable{
	private String nickRemetente;
	private String nickDestinatario, texto;
	
	public Texto(String nR, String nD, String txt) throws Exception
	{
		if(nR.equals("") || nD.equals("") || txt.equals(""))
			throw new Exception("Valores invalidos(class Texto)");
		
		this.nickRemetente = nR;
		this.nickDestinatario = nD;
		this.texto            = txt;
	}
	
	//getters and setters
	
	
}
