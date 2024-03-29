package Servidor;

public class Sala
{
    protected String                    nome;
    protected int                       qtdUsuarios=0;
	protected ListaDesordenada<Usuario> usuarios;

    public void entra(Usuario usr) throws Exception {
    	if(usr == null)
    		throw new Exception("Usuario invalido");
    	
    	//Pensar que um usuario na sua instancia fica-se estabelecido a sala que quer entrar;
    	//Alem disso tem seu socket, tal nick e etc..
    	usuarios.insiraNoFim(usr);
    	qtdUsuarios++;
   }
    
    public Sala(String n, int i) throws Exception
    {
    	if(n.equals("") || n == null)
    		throw new Exception("Parametro invalido");
    	
    	this.nome = n;
    	this.qtdUsuarios = i;
    	usuarios = new ListaDesordenada<Usuario>();
    }
    //Mudei de ListaOrdenada para um vetor de String
    public String[] getNicks() throws Exception {
    	
    	
    	String[] nicks = new String[qtdUsuarios];
    	
    	//Usuar o metodo getInfo que retorna os nicks
    	if(qtdUsuarios > 0) {
    		for(int i = 0; i<= qtdUsuarios-1; i++)
    		{
    			Usuario u = usuarios.getInfo(i);
    			nicks[i] = u.getNick();
    		}    	
    		return nicks;    
    	}
    	else
    		return null; //Nao ha o que retornar
    }
    /**
     * @return
     * @throws Exception
     */
    public Usuario getUsuario(String nick)throws Exception
    {
    	if(nick == null)
    			throw new Exception("Nick invalido :/");
    			
    	if(nick.equals(""))
    		throw new Exception("Nick de usuario invalido"); 	    	  	
    	
    	//percorrer a lista e ver se tem um usuario com este nick;
    	//usar qtdUsuarios para fazer o loop, e mandar como parametro o i do for
    	
    	for(int i = 0; i <= qtdUsuarios-1; i++)
    	{
    		Usuario u = usuarios.getInfo(i);
    			if (u.getNick().equals(nick)){
    				return u;
    			}			
    	}
    	
    	//Caso chegue aqui nao tem um usuario com o nick passado
    	return null;  	    	
    }
    
    // metodos para enviar mensagem para um usuario
    // especifico e metodos para enviar mensagens
    // abertas 
    public void enviarMsgPrivate(Texto t) throws Exception
    {   //Qual sera o parametro? objeto da classe texto, que tem o nick do remetente e a msg
    	//Usar o metodo da lista que retorna o usuario a partir do nick
    	//Identificar na lista onde esta o usuario a ser enviada a msg
    	//e com isso acessar seu objectoutputStream para enviar a mensagem a ele    	
    	if(t == null)
    		throw new Exception("Parametro invalido");
    	
    	//if(t.getTipo().equals("Mensagem privada")){
    		String nickRemetente = (String)t.getComplemento1();
    		
    		for(int i =0; i <= qtdUsuarios-1; i++)
    		{
    			Usuario u  = usuarios.getInfo(i); //vai retornar um usuario, em cada percorrida da lista
    											  //talvez de erro no for da lista
    			
    			if(u.getNick().equals(nickRemetente)) //Achei o usuario e agora mando a mensagem a ele
    			{
    				u.transmissor.writeObject(t.getComplemento2());
    				return;
    			}
    		} 
    		//Se chegar aqui deu erro
    		System.out.println("Erro em enviar mensagem privada.");	
    	//}	
    }
    
    
    public void enviarMsgPublic(Texto s) throws Exception
    {
    	if(s==null)
    		throw new Exception("Parametro invalido, para enviar mensagem particular");
    	
    	//Continuar do mesmo modo que a anterior, porem com a diferenca de que 
    	//mandarei para varios usuarios
    	
    	for(int i=0; i<= qtdUsuarios-1; i++)
    	{
    		Usuario u = usuarios.getInfo(i);
    		u.transmissor.writeObject(s.getComplemento1());
    	}    	
    	
    }

	public String getNome() {
		return nome;
	}
	
	public int getQtdUsuarios() {
		return qtdUsuarios;
	}    
     
}