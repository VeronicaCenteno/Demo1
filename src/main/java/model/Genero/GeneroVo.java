package model.Genero;

public class GeneroVo {
     
    //ATRIBUTOS
    private int id;
    private String nombre;
    private Boolean estado;

    //METODO CONSTRUCTOR VACIO
    public GeneroVo(){
    }

        //METODO CONSTRUCTOR CON PARAMETROS
    public GeneroVo(int id,String nombre, Boolean estado){
        this.id=id;
        this.nombre=nombre;
        this.estado=estado;
    }

    // GETTERS Y SETTERS 
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getNombre(){
        return nombre;

    }

    public void setNombre(String nombre){
        this.nombre=nombre;

    }

    public Boolean isEstado(){
        return estado;
    }

    public void setEstado(Boolean estado){
        this.estado=estado;
    }
}
