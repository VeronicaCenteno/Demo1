package controller;

import model.Album.AlbumDao;
import model.Album.AlbumVo;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlbumController extends HttpServlet {
    AlbumVo rAl=new AlbumVo();
    AlbumDao rdAl=new AlbumDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String a=req.getParameter("accional");

    
            switch(a){
                case "insertar":
                insertar(req,resp);
                break;
                case "visualizarAl":
                visualizarAl(req,resp);
                break;
                case "eliminarAl":
                eliminarAl(req,resp);
                break;
                case "estado":
                estadoAL(req,resp);
                break;
                case "editarAl":
                editarAl(req,resp);
                break;
    }
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String a=req.getParameter("accional");

        switch(a){
            case "addalbum":
                add(req,resp);
            break;
            case "editar":
                edit(req,resp);
            break;
        }
    }
//----------------------------------------------//
    //visualizar
    private void visualizarAl(HttpServletRequest req, HttpServletResponse resp) {
        AlbumDao rdAl=new AlbumDao();
        
        try {
            List <AlbumVo> albumList=rdAl.listarAlbum();
            req.setAttribute("albumList", albumList);
            req.getRequestDispatcher("views/Album/ListAlbum.jsp").forward(req, resp);//direccion de vista
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }
    
    //----------------------------------------------//
    //registrar
       private void insertar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Album/AddAlbum.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
  
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }
    //----------------------------------------------//
    //eliminar  
    private void eliminarAl(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idAlbum")!=null){
            rAl.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));//Cambiar de string a int
        }
        try {
            rdAl.eliminar(rAl.getIdAlbum());;
            System.out.println("El estado se cambio exitosamente");
            visualizarAl(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }
    }
    //----------------------------------------------//
    //estado
    
    private void estadoAL(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idAlbum")!=null){
            rAl.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));//Cambiar de string a int
        }
        if(req.getParameter("estadoAlbum")!=null){
            rAl.setEstadoAlbum(Boolean.parseBoolean(req.getParameter("estadoAlbum")));//Cambiar de string a boolean
        }
        try {
            rdAl.estado(rAl.isEstadoAlbum(), rAl.getIdAlbum());
            System.out.println("El estado se cambio exitosamente");
            visualizarAl(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }
    }

    //----------------------------------------------//
    //editar
    
    private void editarAl(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idAlbum")!=null){
            rAl.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));//Cambiar de string a int
        }
        try {
            List<AlbumVo> albumList=rdAl.ListarAlbum(rAl.getIdAlbum());
            req.setAttribute("albumList", albumList);
            req.getRequestDispatcher("views/Album/EditAlbum.jsp").forward(req, resp);//direccion de vista
            System.out.println("Datos listados correctamente para la edicion");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }
    
    //----------------------------------------------//

//-------------------------------------------------------------------------------------------//
//Metodos del DoPost
//-------------------------------------------------------------------------------------------//

    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("nombreAlbum")!=null){
            rAl.setNombreAlbum(req.getParameter("nombreAlbum"));
        }
        
        if(req.getParameter("anoPublicacion")!=null){
            rAl.setAnoPublicacion(req.getParameter("anoPublicacion"));
        }

        if(req.getParameter("estadoAlbum")!=null){
            rAl.setEstadoAlbum(true);
        }
        else{
            rAl.setEstadoAlbum(false);
        }
        try {
            rdAl.registrar(rAl);
            System.out.println("Registro insertado correctamente");
            visualizarAl(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idAlbum")!=null){
            rAl.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));//Cambiar de string a int
        }
        if(req.getParameter("nombreAlbum")!=null){
            rAl.setNombreAlbum(req.getParameter("nombreAlbum"));
        }
        if(req.getParameter("anoPublicacion")!=null){
            rAl.setAnoPublicacion(req.getParameter("anoPublicacion"));
        }
        if(req.getParameter("estadoAlbum")!=null){
            rAl.setEstadoAlbum(true);
        }
        else{
            rAl.setEstadoAlbum(false);
        }
        try {
            rdAl.actualizar(rAl);
            System.out.println("Editar el registro de Album");
            visualizarAl(req, resp);
        } catch (Exception e) {
            System.out.println("Error al editar del registro "+e.getMessage().toString());
        }
    }
}
