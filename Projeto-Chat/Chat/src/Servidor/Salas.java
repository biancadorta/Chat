package Servidor;

public class Salas
{
    protected int                    qtd=0;
    //protected ListaDesordenada<Sala> salas;

    public void      novaSala        (String nome) throws Exception {}
    public void      novoUsuario     (String nomSal, String nicUsr) throws Exception {}

/*  public Sala      getSala         (String nome) throws Exception {}
    public String [] getNomesSalas   () throws Exception {}
    public Usuario[] getUsuariosSala (String nomSal) throws Exception {}*/
    public void      getUsuario      (String nomSal, String nicUsr) throws Exception {}

    public void      tiraUsuario     (String nomSal, String nicUsr) throws Exception {}
    public void      fechaSala       (String nome) throws Exception {}

    // metodos obrigatorios, claro
}