package controller;


import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cancion.CancionDao;
import model.Cancion.CancionVo;

public class CancionController extends HttpServlet {
     CancionDao c =new CancionDao();
     CancionVo can =new CancionVo();

     @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         System.out.println("Entró al DoGet");
         String a=req.getParameter("accioncancion");
         System.out.println(a);
             switch(a){
                 case "registrarCan":
                 registrarCancion(req,resp);
                 break;
                 case "visualizarCan":
                 visualizarCan(req,resp);
                 break;
                 case "eliminarCan":
                 eliminarCancion(req,resp);
                 break;
                 case "estadoCan":
                 estadoCancion(req,resp);
                 break;
                 case "editarCancion":
                 editarCancion(req,resp);
                 break;
     }
     
 }
 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     System.out.println("Entró al DoPost");
     String a=req.getParameter("accioncancion");
     System.out.println(a);

     switch(a){
         case "addCancion":
         add(req,resp);
         break;
         case "EditarCan":
             editCancion(req,resp);
         break;
     }
 }

//----------------------------------------------//
    //visualizar
    private void visualizarCan(HttpServletRequest req, HttpServletResponse resp) {
        CancionDao c = new CancionDao();
        try {
            List <CancionVo> cancionlist=c.listarcan();
            req.setAttribute("cancionlist", cancionlist);
            req.getRequestDispatcher("views/Cancion/ListCancion.jsp").forward(req, resp);//direccion de vista
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }
    //----------------------------------------------//
    //registrar
    private void registrarCancion(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Cancion/AddCancion.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }

    //----------------------------------------------//
    //editar

    private void editarCancion(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idCancion")!=null){
            can.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));//Cambiar de string a int
        }
        try {
            List<CancionVo> cancionlist=c.ListarCancion(can.getIdCancion());
            req.setAttribute("cancionlist", cancionlist);
            req.getRequestDispatcher("views/Cancion/EditCancion.jsp").forward(req, resp);//direccion de vista
            System.out.println("Datos listados correctamente para la edicion");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }
 //----------------------------------------------//
    //estado

    private void estadoCancion(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idCancion")!=null){
        can.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));//Cambiar de string a int
        }
        if(req.getParameter("estadoCancion")!=null){
            can.setEstadoCancion(Boolean.parseBoolean(req.getParameter("estadoCancion")));//Cambiar de string a boolean
        }

        try {
            c.estado(can.isEstadoCancion(), can.getIdCancion());
            System.out.println("El estado se cambio exitosamente");
            visualizarCan(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }
    }


    //----------------------------------------------//
    //eliminar  
        private void eliminarCancion(HttpServletRequest req, HttpServletResponse resp) {
            if(req.getParameter("idCancion")!=null){
                can.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));//Cambiar de string a int
            }
            try {
                c.eliminar(can.getIdCancion());;
                System.out.println("El estado se cambio exitosamente");
                visualizarCan(req, resp);
            } catch (Exception e) {
                System.out.println("Error en el cambio de estado "+e.getMessage().toString());
            }
    }
    
    

//-------------------------------------------------------------------------------------------//
//Metodos del DoPost
//-------------------------------------------------------------------------------------------//

private void add(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("nombreCancion")!=null){
            
        can.setNombreCancion(req.getParameter("nombreCancion"));
    } 
     if(req.getParameter("fechaGrabacion")!=null){
            
        can.setFechaGrabacion(req.getParameter("fechaGrabacion"));
    }  
    if(req.getParameter("duracionCancion")!=null){
            
        can.setDuracionCancion(req.getParameter("duracionCancion"));
    }

    if(req.getParameter("estadoCancion")!=null){
        can.setEstadoCancion(true);
    }
    else{
        can.setEstadoCancion(false);
    }
    try {
        c.registrar(can);
        System.out.println("Registro insertado correctamente");
        visualizarCan(req, resp);
    } catch (Exception e) {
        System.out.println("Error en la inserción del registro "+e.getMessage().toString());
    }
}    
    private void editCancion(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("idCancion")!=null){
            can.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));//Cambiar de string a int
        }
        if(req.getParameter("nombreCancion")!=null){
            can.setNombreCancion(req.getParameter("nombreCancion"));
        }
        if(req.getParameter("fechaGrabacion")!=null){
            can.setFechaGrabacion(req.getParameter("fechaGrabacion"));
        }
        if(req.getParameter("duracionCancion")!=null){
            can.setDuracionCancion(req.getParameter("duracionCancion"));
        }
        if(req.getParameter("estadoCancion")!=null){
            can.setEstadoCancion(true);
        }
        else{
            can.setEstadoCancion(false);
        }
        try {
            c.actualizar(can);
            System.out.println("Editar el registro de cancion");
            visualizarCan(req, resp);

        } catch (Exception e) {
            System.out.println("Error al editar del registro "+e.getMessage().toString());
        }
    }
}
