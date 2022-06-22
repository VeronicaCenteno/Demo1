package model.Genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;

public class GeneroDao {
    /* Atributos para realizar operaciones sobre la BD */
    Connection con; 
    PreparedStatement ps; 
    ResultSet rs;
    String sql=null;
    int r; 

    public int registrar(GeneroVo Genero) throws SQLException{
        sql="INSERT INTO genero(nombreGenero,estadoGenero) values(?,?)";
        try{
            con=Conexion.conectar(); 
            ps=con.prepareStatement(sql); 
            System.out.println(ps);
            ps.setString(1, Genero.getNombre());
            ps.setBoolean(2, Genero.isEstado());
            System.out.println(ps);
            ps.executeUpdate(); 
            ps.close();
            System.out.println("Se registró el Genero correctamente");

        }catch(Exception e){
            System.out.println("Error en el regisro "+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return r;
    }

    public List<GeneroVo> listar() throws SQLException{
        List<GeneroVo> Genero=new ArrayList<>();
        sql="SELECT * FROM genero";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                GeneroVo r=new GeneroVo();

                r.setId(rs.getInt("idGenero"));
                r.setNombre(rs.getString("nombreGenero"));
                r.setEstado(rs.getBoolean("estadoGenero"));

                Genero.add(r);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return Genero;
    }

    

    public void eliminar(int id) throws SQLException {
        sql="DELETE FROM genero WHERE idGenero="+id;
        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se elimino correctamente");
            
        }catch(Exception e){
            System.out.println("Error en la eliminación "+e.getMessage().toString());
        }

        finally{
            con.close();
        }
    }

    public void estado(Boolean estado, int id) throws SQLException {
        sql="UPDATE genero SET estadoGenero="+estado+" WHERE idGenero="+id;//variable para el sql
        try{
            con=Conexion.conectar(); 
            ps=con.prepareStatement(sql); 
            System.out.println(ps);
            ps.executeUpdate(); 
            ps.close(); 
            System.out.println("Se cambio el estado a "+estado+" correctamente");
            
        }catch(Exception e){
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }

        finally{
            con.close();
        }
    }

    public List<GeneroVo> Listargenero(int id) throws SQLException {
        List<GeneroVo> Genero=new ArrayList<>();
        sql="SELECT * FROM genero WHERE idGenero="+id;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                GeneroVo r=new GeneroVo();

                r.setId(rs.getInt("idGenero"));
                r.setNombre(rs.getString("nombreGenero"));
                r.setEstado(rs.getBoolean("estadoGenero"));
                Genero.add(r);
            }
            ps.close();
            System.out.println("consulta exitosa a genero especifico");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());//Error
        }
        finally{
            con.close();
        }

        return Genero;
    }

    public int actualizar(GeneroVo Genero) throws SQLException {
        sql="UPDATE genero SET nombreGenero=?,estadoGenero=? WHERE idGenero=?";//variable para el sql

        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.setString(1, Genero.getNombre());
            ps.setBoolean(2, Genero.isEstado());
            ps.setInt(3, Genero.getId());
            System.out.println(ps);
            ps.executeUpdate(); 
            ps.close(); 
            System.out.println("Se edito el genero correctamente");

            
        }catch(Exception e){
            System.out.println("Error al editar "+e.getMessage().toString());
        }

        finally{
            con.close();
        }
        return r;
    }
}
