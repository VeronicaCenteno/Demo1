<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>CANCION </title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="assets/css/style.css" rel="stylesheet" />
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand" href="index.jsp ">CANCION</a>
                <button class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="#portfolio">Cancion</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="#about">About</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="#contact">Contact</a></li>
                    </ul>
                </div>
            </div>
        </nav>
       <br>
       <br>
        <!-- Portfolio Section-->
        <section class="page-section portfolio" id="portfolio">
            <div class="container">
                <!-- Portfolio Section Heading-->
                <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">Insertar Cancion</h2>
                <!-- Icon Divider-->
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                <form>
                    <table class="table table-bordered">
                        <thead>
                          <tr>
                            <th  style="width: 30%; height: 500%;" scope="col">Id</th>
                            <th style="width: 30%; height: 500%;" scope="col">Nombre</th>
                            <th style="width: 30%; height: 500%;" scope="col">Fecha Grabacion</th>
                            <th style="width: 30%; height: 500%;" scope="col">Duracion Cancion</th>
                            <th  style="width: 30%; height: 500%;" scope="col">Estado </th>
                            <th  style="width: 30%; height: 500%;" scope="col"> Acciones</th>
                          </tr>
                        </thead>
                            <c:forEach var="cancion" items="${cancionlist}"> 
                          <tr>
                            <td>${cancion.getIdCancion()}</td>
                            <td>${cancion.getNombreCancion()} </td>
                            <td>${cancion.getFechaGrabacion()} </td>
                            <td>${cancion.getDuracionCancion()} </td>

                            <c:if test="${cancion.isEstadoCancion()==true}">
                                 <td>
                                     <span>Genero Activo</span>
                                </td> 
                            </c:if>

                            <c:if test="${cancion.isEstadoCancion()==false}">
                                <td>
                                     <span>Genero Inactivo</span>
                                </td> 
                            </c:if>

                        <c:if test="${cancion.isEstadoCancion()==true}">
                            <td>
                            <a href="cancion?accioncancion=estadoCan&idCancion=${cancion.getIdCancion()}&estadoCancion=false">
                                <button type="button"  style="margin: 0em auto 2em; background-color: rgb(85, 85, 85);" class="btn btn-light">
                                    <font color="white"> Inactivar </font>
                                </button>
                            </a>  
                            </td>
                        </c:if>

                        <c:if test="${cancion.isEstadoCancion()==false}">
                            <td>
                            <a href="cancion?accioncancion=estadoCan&idCancion=${cancion.getIdCancion()}&estadoCancion=true">
                                <button type="button"  style="margin: 0em auto 2em;  background-color: rgb(85, 85, 85);" class="btn btn-light">
                                    <font color="white"> Activar </font>
                                </button>
                            </a>
                            </td>
                        </c:if>
                        <td>
                            <a href="cancion?accioncancion=editarCancion&idCancion=${cancion.getIdCancion()}">
                                <button type="button" style="margin: 0em auto 2em;  background-color: rgb(147, 147, 147);" class="btn btn-light" >
                                    Editar
                                </button> </a>

                            <a href="cancion?accioncancion=eliminarCan&idCancion=${cancion.getIdCancion()}">
                                <button type="button" style="margin: 0em auto 2em;  background-color: rgb(147, 147, 147);" class="btn btn-light">
                                    Eliminar
                                </button> 
                            </a>
                        </td>
                    </tr>
                </c:forEach>   
        </table>
    </form>
            <br>
        <!-- Footer-->
        <footer style="  margin-bottom: 80%;"  class="footer ">
            <div class="container">
                <div class="row">
                    <!-- Footer Location-->
                    <div class="col-lg-4 mb-5 mb-lg-0">
                        <h4 class="text-uppercase mb-4">Location</h4>
                        <p class="lead mb-0">
                            2215 John Daniel Drive
                            <br />
                            Clark, MO 65243
                        </p>
                    </div>
                    <!-- Footer Social Icons-->
                    <div class="col-lg-4 mb-5 mb-lg-0">
                        <h4 class="text-uppercase mb-4">Around the Web</h4>
                        <a class="btn btn-outline-light btn-social mx-1" href="#!"><i class="fab fa-fw fa-facebook-f"></i></a>
                        <a class="btn btn-outline-light btn-social mx-1" href="#!"><i class="fab fa-fw fa-twitter"></i></a>
                        <a class="btn btn-outline-light btn-social mx-1" href="#!"><i class="fab fa-fw fa-linkedin-in"></i></a>
                        <a class="btn btn-outline-light btn-social mx-1" href="#!"><i class="fab fa-fw fa-dribbble"></i></a>
                    </div>
                    <!-- Footer About Text-->
                    <div class="col-lg-4">
                        <h4 class="text-uppercase mb-4">About Freelancer</h4>
                        <p class="lead mb-0">
                            Freelance is a free to use, MIT licensed Bootstrap theme created by
                            <a href="http://startbootstrap.com">Start Bootstrap</a>
                            .
                        </p>
                    </div>
                </div>
            </div>

            <div class="copyright py-4 text-center text-white">
                <div class="container"><small>Copyright &copy; Your Website 2022</small></div>
            </div>
        </footer>


        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="../assets/js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>
