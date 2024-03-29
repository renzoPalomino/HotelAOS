
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        
        <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
        <title>Inicia Sesion</title>
    </head>
    <body>
        <%
           String mensaje="", clase="";
           if(request.getAttribute("dato")!=null){
           mensaje=(String)request.getAttribute("dato");
           clase = "alert alert-danger";
           }
         %> 
        <jsp:include page="navbar.jsp"/>
        
        <div class="container d-flex " style="height: 93vh;" >
    <div class="row align-items-center">
        
        <div class="col-md-5 pr-lg-5">
            <lottie-player src="https://assets2.lottiefiles.com/packages/lf20_hzgq1iov.json" background="transparent"  speed="1"  class="img-fluid mb-3 d-md-block" loop autoplay></lottie-player>
            
        </div>

        <!-- Registeration Form -->
        <div class="col-md-7 col-lg-6 ml-auto">
            <h1>Inicia Sesión</h1><br>
            <form action="control" method="post" enctype="multipart/form-data">
                <div class="row">
                    <input type="hidden" name="op" value="25">
                    <!-- Email Address -->
                    <div class="input-group col-lg-12 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-envelope text-muted"></i>
                            </span>
                        </div>
                        <input id="email" type="email" name="email" placeholder="Correo electrónico" class="form-control bg-white border-left-0 border-md">
                    </div>

                    <!-- Password -->
                    <div class="input-group col-lg-12 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-lock text-muted"></i>
                            </span>
                        </div>
                        <input id="password" type="password" name="password" placeholder="Contraseña" class="form-control bg-white border-left-0 border-md">
                    </div>
                    
                    <!-- Msj Error -->
                    <div class="input-group col-lg-12 mb-4">
                        <div class="col-lg-12 <%=clase%>" role="alert"><%=mensaje%></div>
                    </div>

                    <!-- Submit Button -->
                    <div class="form-group col-lg-12 mx-auto mb-0">
                        <button type="submit" class="btn color-primary text-white btn-block py-2" >
                                    <span class="font-weight-bold">Iniciar Sesión</span>
                                </button>
                    </div>
                    

                    <!-- Already Registered -->
                    <div class="text-center w-100 mt-4">
                        <p class="text-muted font-weight-bold">¿Aún no estas registrado? <a href="register.jsp" class="text-primary ml-2">Crea una cuenta</a></p>
                    </div>

                </div>
            </form>
        </div>
    </div>
</div>
        <jsp:include page="footer.jsp"/>
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</html>

