package Cliente;

import java.io.Serializable;

//O servidor ou o cliente pode mandar algo versatil, para identificar a quais 
//valores se identificam o comp1,comp2 e comp3 verificaremos o tipo, exemplo,
//caso seja tipo=="Lista_de_Salas", isso diz que os comps correspondem ao remetente
//destinatario e nick do usuario

public class Texto implements Serializable{
	
	private String tipo; //Mensagem
	private Serializable complemento1, complemento2, complemento3;
	
	public Texto( String t, Serializable c1, Serializable c2, Serializable c3) throws Exception
	{
		if( t.equals(""))
			throw new Exception("Valores invalidos(class Texto)");
		
		this.tipo = t;
		this.complemento1 = c1;
		this.complemento2 = c2;
		this.complemento3 = c3;
	}
	
	public Texto(String t, Serializable d) throws Exception 
	{		
		if(t.equals(""))
			throw new Exception("tipo invalido");
		
		this.tipo = t;
		this.complemento1 = d;
		this.complemento2 = null;
		this.complemento3 = null;
	}
	public Serializable getComp1()
	{
		return this.complemento1;
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
		
		if(!(this.tipo == txt.tipo))
			return false;
		
		if(!(this.complemento1 == txt.complemento1))
			return false;
		
		if(!(this.complemento2 == txt.complemento2))
			return false;
		
		if(!(this.complemento3 == txt.complemento3))
			return false;
		
		return true;		
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Serializable getComplemento1() {
		return complemento1;
	}

	public void setComplemento1(Serializable complemento1)throws Exception{
		if(complemento1==null)
			throw new Exception("Comp 1 errado.");
		
		this.complemento1 = complemento1;
	}

	public Serializable getComplemento2() {
		return complemento2;
	}

	public void setComplemento2(Serializable complemento2)throws Exception{
		if(complemento2==null)
			throw new Exception("Comp 2 invalido");
		
		this.complemento2 = complemento2;
	}

	public Serializable getComplemento3() {
		return complemento3;
	}

	public void setComplemento3(Serializable complemento3)throws Exception{
		if(complemento3 == null)
			throw new Exception("Comp 3 invalido");
		
		this.complemento3 = complemento3;
	}
	
}