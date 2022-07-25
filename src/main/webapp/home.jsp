
<%@page import="beans.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hotel</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    </head>
    <body>
        
        <jsp:include page="navbar.jsp"/>
        
    
    <!--Seccion Casa-->

    <section class="  d-flex flex-wrap align-content-around justify-content-center mt-9">
        <div class="row container rounded-R py-5 px-5 jumbotron-R shadow">
            <h1 class="col-sm-12 display-2 "><strong>Hotel PANDO</strong></h1>
            <div class="col-lg-6 display-5">
                <div><p>Experimente el lujo de nuestro hotel frente al mar</p></div>
            </div>
        </div>
    </section>
    
    <jsp:include page="divBuscar.jsp"/>
    <!--Seccion Departamento-->

    <section class="d-flex flex-wrap align-content-center justify-content-center">
        <div class="row  container">
            <h1 class="col-sm-12 display-1 "><strong>Servicios</strong></h1>
            <div class="col-sm-12 row mx-auto">
            <div class="col-md-3 border border-R shadow-lg rounded-R my-5 mx-auto py-4 Ser_icon">
                <div class="text-center svg serv1"></div>
                <div class="text-center text-color1"><p>Wi-Fi</p></div>
            </div>
            <div class="col-md-3 border border-R shadow-lg rounded-R my-5 mx-auto py-4 Ser_icon">
                <div class="text-center svg serv2"></div>
                <div class="text-center text-color1"><p>Piscina</p></div>
            </div>
            <div class="col-md-3 border border-R shadow-lg rounded-R my-5 mx-auto py-4 Ser_icon">
                <div class="text-center svg serv3"></div>
                <div class="text-center text-color1"><p>Cena</p></div>
            </div>
            </div>
            
            <div class="col-sm-12 row mx-auto">
            <div class="col-md-3 border border-R shadow-lg rounded-R my-5 mx-auto py-4 Ser_icon">
                <div class="text-center svg serv4"></div>
                <div class="text-center text-color1"><p>Eventos</p></div>
            </div>
            
            <div class="col-md-3 border border-R shadow-lg rounded-R my-5 mx-auto py-4 Ser_icon">
                <div class="text-center svg serv5"></div>
                <div class="text-center text-color1"><p>GYM</p></div>
            </div>
            
            <div class="col-md-3 border border-R shadow-lg rounded-R my-5 mx-auto py-4 Ser_icon">
                <div class="text-center svg serv6"></div>
                <div class="text-center text-color1"><p>Desayuno</p></div>
            </div>
            </div>
            
        </div>
    </section>

        
    
    
    <jsp:include page="footer.jsp"/>
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</html>