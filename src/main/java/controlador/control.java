package controlador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import dao.*;
import beans.*;
import javax.servlet.http.HttpSession;

@MultipartConfig
public class control extends HttpServlet {

    Negocio obj = new Negocio();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //opc==2 esta reservado para evaluar si se agrego inmueble
        int opc = Integer.parseInt(request.getParameter("op"));
        if (opc==6) pagAddItem(request, response);
        if (opc==7) GuardarInmuebles(request, response);
        if (opc==8) delPersonal(request, response);
        if (opc==9) delParejas(request, response);
        if (opc==10) delDoble(request, response);
        if (opc==13) searchInmueble(request, response);
        //UPDATE
        if (opc==14) editarPersonal(request,response);
        if (opc==15) actualizaPersonal(request,response);
        if (opc==16) editarParejas(request,response);
        if (opc==17) actualizaParejas(request,response);
        if (opc==20) editarDoble(request,response);
        if (opc==21) actualizaDoble(request,response);
        /*
        */
        //Registrar
        if (opc==24) registrar(request,response);
        if (opc==25) login(request,response);
        if (opc==26) cerrarSesion(request,response);
        if (opc==27) comprar(request,response);
    }
    //Actualiza datos de una Personal
    protected void editarPersonal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idinmu=Integer.parseInt(request.getParameter("id"));
        request.setAttribute("dato", obj.buscaInmu(idinmu));
        String pag="/updateItem.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void actualizaPersonal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Personal c=new Personal();
        c.setIdInmu(Integer.parseInt(request.getParameter("coda")));
        c.setTitulo(request.getParameter("titulo"));
        c.setDescrip(request.getParameter("direccion"));
//        c.setArea(Double.parseDouble(request.getParameter("area")));
//        c.setDescrip(request.getParameter("descripcion"));
        c.setPrecio(Double.parseDouble(request.getParameter("precio")));
        c.setPiso(Integer.parseInt(request.getParameter("tipo")));
//        c.setEstado(Integer.parseInt(request.getParameter("estado")));
        c.setNumhab(Integer.parseInt(request.getParameter("numhabitaciones")));
//        c.setNumbanio(Integer.parseInt(request.getParameter("numbanos")));
//        c.setNumgarage(Integer.parseInt(request.getParameter("numestaciona")));
//        c.setAniocost(Integer.parseInt(request.getParameter("anioconstruccion")));
        
        String imageDefault=request.getParameter("imageDefault");
        Part archivo = request.getPart("imagen");
        if (archivo.getSize() > 0) {
            String imagen = GuardarArchivo(archivo, Imagen(c.getIdInmu()));

            c.setImg(imagen);
        } else {
            c.setImg(imageDefault);
        }
        obj.Actua_Personal(c);
        response.sendRedirect("dashboard.jsp");
    }
    //Actualiza los datos de un Parejas
    protected void editarParejas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idinmu=Integer.parseInt(request.getParameter("id"));
        request.setAttribute("dato", obj.buscaParejas(idinmu));
        String pag="/updateDepa.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void actualizaParejas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Parejas d=new Parejas();
        d.setIdInmu(Integer.parseInt(request.getParameter("coda")));
        d.setTitulo(request.getParameter("titulo"));
//        d.setDireccion(request.getParameter("direccion"));
//        d.setArea(Double.parseDouble(request.getParameter("area")));
        d.setDescrip(request.getParameter("descripcion"));
        d.setPrecio(Double.parseDouble(request.getParameter("precio")));
        d.setTipo(Integer.parseInt(request.getParameter("tipo")));
//        d.setEstado(Integer.parseInt(request.getParameter("estado")));
        d.setNumhab(Integer.parseInt(request.getParameter("numhabitaciones")));
//        d.setNumbanio(Integer.parseInt(request.getParameter("numbanos")));
//        d.setNumgarage(Integer.parseInt(request.getParameter("numestaciona")));
//        d.setAniocost(Integer.parseInt(request.getParameter("anioconstruccion")));
        
        String imageDefault=request.getParameter("imageDefault");
        Part archivo = request.getPart("imagen");
        if (archivo.getSize() > 0) {
            String imagen = GuardarArchivo(archivo, Imagen(d.getIdInmu()));

            d.setImg(imagen);
        } else {
            d.setImg(imageDefault);
        }
        obj.Actua_Parejas(d);
        response.sendRedirect("dashboard.jsp");
    }
    
    //Actualiza los datos de una Dobles
    protected void editarDoble(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idinmu=Integer.parseInt(request.getParameter("id"));
        request.setAttribute("dato", obj.buscaDobles(idinmu));
        String pag="/updateOfi.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void actualizaDoble(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Dobles o=new Dobles();
        o.setIdInmu(Integer.parseInt(request.getParameter("coda")));
        o.setTitulo(request.getParameter("titulo"));
//        o.setDireccion(request.getParameter("direccion"));
//        o.setArea(Double.parseDouble(request.getParameter("area")));
        o.setDescrip(request.getParameter("descripcion"));
        o.setPrecio(Double.parseDouble(request.getParameter("precio")));
        o.setTipo(Integer.parseInt(request.getParameter("tipo")));
//        o.setEstado(Integer.parseInt(request.getParameter("estado")));
//        o.setNumbanio(Integer.parseInt(request.getParameter("numbanos")));
//        o.setNumgarage(Integer.parseInt(request.getParameter("numestaciona")));
//        o.setAniocost(Integer.parseInt(request.getParameter("anioconstruccion")));
        
        String imageDefault=request.getParameter("imageDefault");
        Part archivo = request.getPart("imagen");
        if (archivo.getSize() > 0) {
            String imagen = GuardarArchivo(archivo, Imagen(o.getIdInmu()));

            o.setImg(imagen);
        } else {
            o.setImg(imageDefault);
        }
        obj.Actua_Dobles(o);
        response.sendRedirect("dashboard.jsp");
    }
    
    protected void GuardarInmuebles(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        int operacion = Integer.parseInt(request.getParameter("operacion"));
        Part archivo = request.getPart("imagen");

        //Inmuebles
        Inmueble objIn = new Inmueble();
        objIn.setIdInmueble(obj.IdInmueble());
        objIn.setTitulo(request.getParameter("titulo").trim());
        objIn.setDireccion(request.getParameter("direccion").trim());
        objIn.setArea(Double.parseDouble(request.getParameter("area").trim()));
        objIn.setDescripcion(request.getParameter("descrip").trim());
        objIn.setPrecio(Double.parseDouble(request.getParameter("precio").trim()));
        objIn.setPiso(Integer.parseInt(request.getParameter("tipo_venta").trim()));

        if (archivo.getSize() > 0) {
            String imagen = GuardarArchivo(archivo, Imagen(objIn.getIdInmueble()));

            objIn.setImg(imagen);
        } else {
            objIn.setImg("");
        }

        int res = 0;

        if (operacion == 1) {
            objIn.setNumBanio(Integer.parseInt(request.getParameter("numBanio")));
            objIn.setNumGarage(Integer.parseInt(request.getParameter("numGarage")));
            objIn.setAnioConst(Integer.parseInt(request.getParameter("anioConst")));
            objIn.setNumHab(Integer.parseInt(request.getParameter("numHab")));

            res = obj.GuardarPersonal(objIn);

        } else if (operacion == 2) {
            objIn.setNumBanio(Integer.parseInt(request.getParameter("numBanio")));
            objIn.setNumGarage(Integer.parseInt(request.getParameter("numGarage")));
            objIn.setAnioConst(Integer.parseInt(request.getParameter("anioConst")));
            objIn.setNumHab(Integer.parseInt(request.getParameter("numHab")));

            res = obj.GuardarParejas(objIn);

        } else if (operacion == 3) {
            objIn.setNumBanio(Integer.parseInt(request.getParameter("numBanio")));
            objIn.setNumGarage(Integer.parseInt(request.getParameter("numGarage")));
            objIn.setAnioConst(Integer.parseInt(request.getParameter("anioConst")));

            res = obj.GuardarDobles(objIn);
        } 

        response.sendRedirect("addItem.jsp?opcion=" + res);
    }

    public String RutaAbsoluta() {
        String ubicacion = getServletContext().getRealPath("");
        String ruta = "src\\main\\webapp\\img\\inmuebles\\";

        return ubicacion.substring(0, ubicacion.indexOf("target")) + ruta;
    }

    public String GuardarArchivo(Part archivoPart, String nombreArchivo) {
        try {
            String ruta = RutaAbsoluta();
            File archivo = new File(ruta);
            archivo.mkdirs();

            Path path = Paths.get(ruta + nombreArchivo);
            archivo = new File(path.toAbsolutePath().toString());
            archivo.toPath();

            InputStream input = archivoPart.getInputStream();
            Files.copy(input, archivo.toPath(), StandardCopyOption.REPLACE_EXISTING);

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return nombreArchivo;
    }

    public String Imagen(int id) {
        return String.format("img-%04d", id) + ".jpg";
    }

    //redireccionar pag añadir inmueble 
     protected void pagAddItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pag="/addItem.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
          }
     
     //Eliminar Personal 
    protected void delPersonal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cod = Integer.parseInt(request.getParameter("id")); //recibe el codigo del inmueble
        obj.delPersonal(cod);
        response.sendRedirect("dashboard.jsp");
    }
    
     //Eliminar Parejas 
    protected void delParejas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cod = Integer.parseInt(request.getParameter("id")); //recibe el codigo del inmueble
        obj.delParejas(cod);
        response.sendRedirect("dashboard.jsp");
    }
    
     //Eliminar Dobles
    protected void delDoble(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cod = Integer.parseInt(request.getParameter("id")); //recibe el codigo del inmueble
        obj.delDobles(cod);
        response.sendRedirect("dashboard.jsp");
    }
    
     
    
    protected void searchInmueble(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int inmu=Integer.parseInt(request.getParameter("inmu"));
        int tipo=Integer.parseInt(request.getParameter("tipo"));
        request.setAttribute("dato", obj.searchInmueble(inmu,tipo));
        String pag="/searchResult.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    
    
    protected void registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente cli = new Cliente();
        
        cli.setNomcli(request.getParameter("firstname"));
        cli.setApecli(request.getParameter("lastname"));
        cli.setEmailcli(request.getParameter("email"));
        cli.setCelcli(request.getParameter("phone"));
        cli.setPasscli(request.getParameter("password"));
        obj.Registrar(cli);
        response.sendRedirect("login.jsp");
    }
    
    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses=request.getSession();
        int nivel=2;//0=admin, 1=user
        String email= request.getParameter("email").trim();
        String psw= request.getParameter("password").trim();
         Cliente cli=obj.busCli(email);
         
         if(cli==null){
          request.setAttribute("dato", "Usuario no existe");
      }else{
          if(cli.getPasscli().equals(psw)){
              ses.setAttribute("cliente", cli);
              nivel=cli.getNivel();
          }else{
            request.setAttribute("dato", "Clave incorrecta");  
          }
          
      }
         
      if(nivel==2){
          request.getRequestDispatcher("login.jsp").forward(request, response);
      }else{
          if(nivel==0){
              response.sendRedirect("adminpage.jsp");
          }else{
              response.sendRedirect("home.jsp");
          }
      }
        
    }
    
    protected void cerrarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses=request.getSession();
        ses.invalidate();
        response.sendRedirect("home.jsp");
    }
    
    protected void comprar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idcli=Integer.parseInt(request.getParameter("idcli"));
        int idinmu=Integer.parseInt(request.getParameter("idinmu"));
        double total=Double.parseDouble(request.getParameter("total"));
        obj.compra(idcli, idinmu, total);
        response.sendRedirect("compraExitosa.jsp");
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
