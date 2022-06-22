package model.Cancion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;

public class CancionDao {
    /* Atributos para realizar operaciones sobre la BD */
    Connection con; 
    PreparedStatement ps; 
    ResultSet rs;
    String sql=null;
    int r; 

    public int registrar(CancionVo Cancion) throws SQLException{
        sql="INSERT INTO cancion(nombreCancion,fechaGrabacion,duracionCancion,estadoCancion) values(?,?,?,?)";
        try{
            con=Conexion.conectar(); 
            ps=con.prepareStatement(sql); 
            System.out.println(ps);
            ps.setString(1, Cancion.getNombreCancion());
            ps.setString(2, Cancion.getFechaGrabacion());
            ps.setString(3, Cancion.getDuracionCancion());
            ps.setBoolean(4, Cancion.isEstadoCancion());
            System.out.println(ps);
            ps.executeUpdate(); 
            ps.close();
            System.out.println("Se registró la Cancion correctamente");

        }catch(Exception e){
            System.out.println("Error en el registro "+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return r;
    }

    public List<CancionVo> listarcan() throws SQLException{
        List<CancionVo> Cancion=new ArrayList<>();
        sql="SELECT * FROM cancion";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                CancionVo can=new CancionVo();

                can.setIdCancion(rs.getInt("idCancion"));
                can.setNombreCancion(rs.getString("nombreCancion"));
                can.setFechaGrabacion(rs.getString("fechaGrabacion"));
                can.setDuracionCancion(rs.getString("duracionCancion"));
                can.setEstadoCancion(rs.getBoolean("estadoCancion"));

                Cancion.add(can);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return Cancion;
    }

    

    public void eliminar(int idCancion) throws SQLException {
        sql="DELETE FROM cancion WHERE idCancion="+idCancion;
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

    public void estado(Boolean estadoCancion, int idCancion) throws SQLException {
        sql="UPDATE cancion SET estadoCancion="+estadoCancion+" WHERE idCancion="+idCancion;//variable para el sql
        try{
            con=Conexion.conectar(); 
            ps=con.prepareStatement(sql); 
            System.out.println(ps);
            ps.executeUpdate(); 
            ps.close(); 
            System.out.println("Se cambio el estado a "+estadoCancion+" correctamente");
            
        }catch(Exception e){
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }

        finally{
            con.close();
        }
    }

    public List<CancionVo> ListarCancion(int idCancion) throws SQLException {
        List<CancionVo> Cancion=new ArrayList<>();
        sql="SELECT * FROM cancion WHERE idCancion="+idCancion;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){

                CancionVo can=new CancionVo();

                can.setIdCancion(rs.getInt("idCancion"));
                can.setNombreCancion(rs.getString("nombreCancion"));
                can.setFechaGrabacion(rs.getString("fechaGrabacion"));
                can.setDuracionCancion(rs.getString("duracionCancion"));
                can.setEstadoCancion(rs.getBoolean("estadoCancion"));

                Cancion.add(can);
            }
            ps.close();
            System.out.println("consulta exitosa a cancion especifico");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());//Error
        }
        finally{
            con.close();
        }

        return Cancion;
    }

    public int actualizar(CancionVo Cancion) throws SQLException {
        sql="UPDATE cancion SET nombreCancion=?,fechaGrabacion=?,duracionCancion=?,estadoCancion=? WHERE idCancion=?";//variable para el sql

        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
          
            ps.setString(1, Cancion.getNombreCancion());
            ps.setString(2, Cancion.getFechaGrabacion());
            ps.setString(3, Cancion.getDuracionCancion());
            ps.setBoolean(4, Cancion.isEstadoCancion());
            ps.setInt(5, Cancion.getIdCancion());
            
            System.out.println(ps);
            ps.executeUpdate(); 
            ps.close(); 
            System.out.println("Se edito el cancion correctamente");

            
        }catch(Exception e){
            System.out.println("Error al editar "+e.getMessage().toString());
        }

        finally{
            con.close();
        }
        return r;
    }

    
}
