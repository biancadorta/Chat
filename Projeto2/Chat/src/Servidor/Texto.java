package Servidor;

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
	
	public String remetente()
	{
		return this.nickRemetente;
	}

	public String destinatario()
	{
		return this.nickDestinatario;
	}

	public String Mensagem()
	{
		return this.texto;
	}
	//getters and setters
	
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		
		if(this == obj)
			return true;
		
		if(!(obj instanceof Texto))
			return false;
		
		Texto txt = (Texto)obj;
		
		if(!(this.nickRemetente == txt.nickRemetente))
			return false;
		
		if(!(this.nickDestinatario == txt.nickDestinatario))
			return false;
		
		if(!(this.texto == txt.texto))
			return false;
		
		return true;		
	}
	
}
