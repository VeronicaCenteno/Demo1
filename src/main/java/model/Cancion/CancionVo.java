package model.Cancion;


public class CancionVo {

     //ATRIBUTOS 
     private int idCancion;
    private String nombreCancion;
    private String fechaGrabacion;
    private String duracionCancion;
    private Boolean estadoCancion;
                    
    //METODO CONSTRUCTOR VACIO
     public CancionVo(){
    }
    //METODO CONSTRUCTOR CON PARAMETROS
    public void AlbumDao(int idCancion,String nombreCancion, String fechaGrabacion, String duracionCancion, Boolean estadoCancion  ){

        this.idCancion= idCancion;
        this.nombreCancion= nombreCancion;
        this.fechaGrabacion= fechaGrabacion;
        this.duracionCancion= duracionCancion;
        this.estadoCancion= estadoCancion;
    }
    
    // GETTERS Y SETTERS 
    public int getIdCancion(){
        return idCancion;
    }

    public void setIdCancion(int idCancion){
        this.idCancion=idCancion;
    }

    public String getNombreCancion(){
        return nombreCancion;

    }

    public void setNombreCancion(String nombreCancion){
        this.nombreCancion=nombreCancion;

    }

    public String getFechaGrabacion(){
        return fechaGrabacion;

    }

    public void setFechaGrabacion(String fechaGrabacion){
        this.fechaGrabacion=fechaGrabacion;

    }
    
    public String getDuracionCancion(){
        return duracionCancion;

    }

    public void setDuracionCancion(String duracionCancion){
        this.duracionCancion=duracionCancion;

    }
    public Boolean isEstadoCancion(){
        return estadoCancion;
    }

    public void setEstadoCancion(Boolean estadoCancion){
        this.estadoCancion=estadoCancion;
    }

}
