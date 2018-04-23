package Cliente;

import java.io.Serializable;

public class Texto implements Serializable {
	
	protected String nickRemetente;
	protected String nickDestinatario, msg;
	
	public Texto(String nR, String nD, String msg) throws Exception
	{
		if(nR.equals("") || nD.equals("") || msg.equals(""))
			throw new Exception("Valor invalido.");
		
		this.nickRemetente    = nR;
		this.nickDestinatario = nD;
		this.msg 			  = msg;			
	}
	
	//Getters and Setters
	
	public String getRemetente()
	{
		return this.nickRemetente;
	}
	
	public String getDestinario()
	{
		return this.nickDestinatario;
	}
	
	public String getMensagem()
	{
		return this.msg;
	}
	
	public void setRemet(String r) throws Exception
	{
		if(r.equals(""))
			throw new Exception("Remetente invalido.");
		
		this.nickRemetente = r; 
	}
	
	public void setDestin(String d) throws Exception
	{
		if(d.equals(""))
			throw new Exception("Destinatario invalido.");
		
		this.nickRemetente = d; 
	}
	
	public void setMsg(String m) throws Exception
	{
		if(m.equals(""))
			throw new Exception("Mensagem invalida.");
		
		this.nickRemetente = m; 
	}
	
	//Metodos obrigatorios
}
