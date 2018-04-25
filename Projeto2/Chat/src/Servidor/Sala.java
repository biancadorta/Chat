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
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         public ListaOrdenada<String> getNicks   ()            throws Exception {}
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
  
}