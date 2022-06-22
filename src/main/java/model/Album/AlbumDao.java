package model.Album;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;

public class AlbumDao {
     /* Atributos para realizar operaciones sobre la BD */
     Connection con; 
     PreparedStatement ps; 
     ResultSet rs;
     String sql=null;
     int r; 
 
     public int registrar(AlbumVo Album) throws SQLException{
         sql="INSERT INTO album(nombreAlbum,anoPublicacion,estadoAlbum)values(?,?,?)";
         try{
             con=Conexion.conectar(); 
             ps=con.prepareStatement(sql); 
             System.out.println(ps);
             ps.setString(1, Album.getNombreAlbum());
             ps.setString(2, Album.getAnoPublicacion());
             ps.setBoolean(3, Album.isEstadoAlbum ());
             System.out.println(ps);
             ps.executeUpdate(); 
             ps.close();
             System.out.println("Se registró el Album correctamente");
 
         }catch(Exception e){
             System.out.println("Error en el regisro "+e.getMessage().toString());
         }
         finally{
             con.close();
         }
         return r;
     }
 
     public List<AlbumVo> listarAlbum() throws SQLException{
         List<AlbumVo> Album=new ArrayList<>();
         sql="SELECT * FROM album WHERE idAlbum";
         try {
             con=Conexion.conectar();
             ps=con.prepareStatement(sql);
             System.out.println(ps);
             rs=ps.executeQuery(sql);
             while(rs.next()){

                AlbumVo rAl=new AlbumVo();
 
                rAl.setIdAlbum(rs.getInt("idAlbum"));
                rAl.setNombreAlbum(rs.getString("nombreAlbum"));
                rAl.setAnoPublicacion(rs.getString("anoPublicacion"));
                rAl.setEstadoAlbum(rs.getBoolean("estadoAlbum"));
 
                 Album.add(rAl);
             }
             ps.close();
             System.out.println("consulta exitosa");
         } catch (Exception e) {
             System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
         }
         finally{
             con.close();
         }
         return Album;
     }
 
     
 
     public void eliminar(int idAlbum) throws SQLException {
         sql="DELETE FROM album WHERE idAlbum="+idAlbum;
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
 
     public void estado(Boolean estadoAlbum, int idAlbum) throws SQLException {
         sql="UPDATE album SET estadoAlbum="+estadoAlbum+" WHERE idAlbum="+idAlbum;//variable para el sql
         try{
             con=Conexion.conectar(); 
             ps=con.prepareStatement(sql); 
             System.out.println(ps);
             ps.executeUpdate(); 
             ps.close(); 
             System.out.println("Se cambio el estado a "+estadoAlbum+" correctamente");
             
         }catch(Exception e){
             System.out.println("Error en el cambio de estado "+e.getMessage().toString());
         }
 
         finally{
             con.close();
         }
     }
 
     public List<AlbumVo> ListarAlbum(int idAlbum) throws SQLException {
         List<AlbumVo> Album=new ArrayList<>();
         sql="SELECT * FROM album WHERE idAlbum="+idAlbum;
         try {
             con=Conexion.conectar();
             ps=con.prepareStatement(sql);
             rs=ps.executeQuery(sql);
             while(rs.next()){
                AlbumVo rAl=new AlbumVo();
 
                rAl.setIdAlbum(rs.getInt("idAlbum"));
                rAl.setNombreAlbum(rs.getString("nombreAlbum"));
                rAl.setAnoPublicacion(rs.getString("anoPublicacion"));
                rAl.setEstadoAlbum(rs.getBoolean("estadoAlbum"));
                 Album.add(rAl);
             }
             ps.close();
             System.out.println("consulta exitosa a genero especifico");
         } catch (Exception e) {
             System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());//Error
         }
         finally{
             con.close();
         }
 
         return Album;
     }
     public int actualizar(AlbumVo Album) throws SQLException {
         sql="UPDATE album SET nombreAlbum=?,anoPublicacion=?,estadoAlbum=? WHERE idAlbum=?";//variable para el sql
 
         try{
             con=Conexion.conectar();
             ps=con.prepareStatement(sql);
             System.out.println(ps);
        
             ps.setString(1, Album.getNombreAlbum());
             ps.setString(2, Album.getAnoPublicacion());
             ps.setBoolean(3, Album.isEstadoAlbum());
             ps.setInt(4, Album.getIdAlbum());
             
             System.out.println(ps);
             ps.executeUpdate(); 
             ps.close(); 
             System.out.println("Se edito el album correctamente");
 
             
         }catch(Exception e){
             System.out.println("Error al editar "+e.getMessage().toString());
         }
 
         finally{
             con.close();
         }
         return r;
     }
}
