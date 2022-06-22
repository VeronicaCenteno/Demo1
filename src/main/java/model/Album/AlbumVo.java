package model.Album;

public class AlbumVo {
    //ATRIBUTOS 
    private int idAlbum;
    private String nombreAlbum;
    private String anoPublicacion;
    private Boolean estadoAlbum;

    //METODO CONSTRUCTOR VACIO
    public AlbumVo(){
    }

    //METODO CONSTRUCTOR CON PARAMETROS
    public void AlbumDao(int idAlbum,String nombreAlbum, String anoPublicacion, Boolean estadoAlbum ){

        this.idAlbum= idAlbum;
        this.nombreAlbum= nombreAlbum;
        this.anoPublicacion= anoPublicacion;
        this.estadoAlbum= estadoAlbum;
    }
    
    // GETTERS Y SETTERS 
    public int getIdAlbum(){
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum){
        this.idAlbum=idAlbum;
    }

    public String getNombreAlbum(){
        return nombreAlbum;

    }

    public void setNombreAlbum(String nombreAlbum){
        this.nombreAlbum=nombreAlbum;

    }

    public String getAnoPublicacion(){
        return anoPublicacion;

    }

    public void setAnoPublicacion(String anoPublicacion){
        this.anoPublicacion=anoPublicacion;

    }
    public Boolean isEstadoAlbum(){
        return estadoAlbum;
    }

    public void setEstadoAlbum(Boolean estadoAlbum){
        this.estadoAlbum=estadoAlbum;
    }

}
