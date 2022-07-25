
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Buscar Inmueble-->
    <div class="">
        <div class="container bg-buscar rounded-R px-5 py-4 border border-R shadow-lg">
            <h2 class="h2">Buscar habitación</h2>
            <form action="control" method="post" enctype="multipart/form-data">
                <input type="hidden" name="op" value="13">
            <div class="row text-center p-3">
                <div class="col-sm-4">
                    
                    <div class="form-group">
                      <select class="form-control form-control-lg" id="sel1" name="inmu">
                          <option value="1" selected>Personal</option>
                          <option value="2">Parejas</option>
                          <option value="3">Dobles</option>
                      </select>
                    </div> 
                </div>
                <div class="col-sm-4">
                    <div class="form-group">
                      <select class="form-control form-control-lg" id="sel1" name="tipo">
                          <option value="1" selected>Premium</option>
                          <option value="0">Sencilla</option>
                      </select>
                    </div>
                </div>
                <div class="col-sm-4">
                    <button type="submit" class="btn btn-success btn-block btn-lg">Buscar</button>
                </div>
            </div>
            </form>
        </div>
    </div>