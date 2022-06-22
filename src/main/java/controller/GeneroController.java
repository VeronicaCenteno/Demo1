package controller;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Genero.GeneroDao;
import model.Genero.GeneroVo;

public class GeneroController extends HttpServlet {

    GeneroVo r=new GeneroVo();
    GeneroDao rd=new GeneroDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String a=req.getParameter("accion");
        System.out.println(a);
            switch(a){
                case "registrar":
                registrar(req,resp);
                break;
                case "visualizar":
                visualizar(req,resp);
                break;
                case "eliminar":
                eliminar(req,resp);
                break;
                case "est":
                estado(req,resp);
                break;
                case "editar":
                editar(req,resp);
                break;
    }
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String a=req.getParameter("accion");
        System.out.println(a);

        switch(a){
            case "add":
                add(req,resp);
            break;
            case "Editar":
                edit(req,resp);
            break;
        }
    }
//----------------------------------------------//
    //visualizar
    private void visualizar(HttpServletRequest req, HttpServletResponse resp) {
        GeneroDao rd=new GeneroDao();
        
        try {
            List <GeneroVo> generosList=rd.listar();
            req.setAttribute("generosList", generosList);
            req.getRequestDispatcher("views/Genero/listGenero.jsp").forward(req, resp);//direccion de vista
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }
    
    //----------------------------------------------//
    //registrar
       private void registrar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Genero/addGenero.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }
    //----------------------------------------------//
    //eliminar  
    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id")!=null){
            r.setId(Integer.parseInt(req.getParameter("id")));//Cambiar de string a int
        }
        try {
            rd.eliminar(r.getId());;
            System.out.println("El estado se cambio exitosamente");
            visualizar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }
    }
    //----------------------------------------------//
    //estado
    
    private void estado(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id")!=null){
            r.setId(Integer.parseInt(req.getParameter("id")));//Cambiar de string a int
        }
        if(req.getParameter("estado")!=null){
            r.setEstado(Boolean.parseBoolean(req.getParameter("estado")));//Cambiar de string a boolean
        }

        try {
            rd.estado(r.isEstado(), r.getId());
            System.out.println("El estado se cambio exitosamente");
            visualizar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }
    }

    //----------------------------------------------//
    //editar
    
    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id")!=null){
            r.setId(Integer.parseInt(req.getParameter("id")));//Cambiar de string a int
        }
        try {
            List<GeneroVo> generosList=rd.Listargenero(r.getId());
            req.setAttribute("generosList", generosList);
            req.getRequestDispatcher("views/Genero/editGenero.jsp").forward(req, resp);//direccion de vista
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

        if(req.getParameter("nombre")!=null){
            
            r.setNombre(req.getParameter("nombre"));
        }
        if(req.getParameter("estadoGenero")!=null){
            r.setEstado(true);
        }
        else{
            r.setEstado(false);
        }
        try {
            rd.registrar(r);
            System.out.println("Registro insertado correctamente");
          visualizar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id")!=null){
            r.setId(Integer.parseInt(req.getParameter("id")));//Cambiar de string a int
        }
        if(req.getParameter("nombre")!=null){
            r.setNombre(req.getParameter("nombre"));
        }
        if(req.getParameter("estado")!=null){
            r.setEstado(true);
        }
        else{
            r.setEstado(false);
        }
        try {
            rd.actualizar(r);
            System.out.println("Editar el registro de genero");
            visualizar(req, resp);

        } catch (Exception e) {
            System.out.println("Error al editar del registro "+e.getMessage().toString());
        }
    }
}
