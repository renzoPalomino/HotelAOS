package dao;

import java.sql.*;
import util.MySQLConexion;
import beans.*;
import java.util.ArrayList;
import java.util.List;

public class Negocio {

    public int IdInmueble() {
        int nro = 0;
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select ifnull(max(idinmu),0)+1 from inmueble";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                nro = rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return nro;
    }

    

    public int GuardarDobles(Inmueble obj) {
        int res = 0;
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "{call insert_oficina(?,?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, obj.getIdInmueble());
            cs.setString(2, obj.getTitulo());
            cs.setString(3, obj.getDireccion());
            cs.setDouble(4, obj.getArea());
            cs.setString(5, obj.getDescripcion());
            cs.setDouble(6, obj.getPrecio());
            cs.setInt(7, obj.getTipo());
            cs.setInt(8, obj.getNumBanio());
            cs.setInt(9, obj.getNumGarage());
            cs.setInt(10, obj.getAnioConst());
            cs.setString(11, obj.getImg());
            res = cs.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return res;
    }

    

    public int GuardarParejas(Inmueble obj) {
        int res = 0;
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "{call insert_departamento(?,?,?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, obj.getIdInmueble());
            cs.setString(2, obj.getTitulo());
            cs.setString(3, obj.getDireccion());
            cs.setDouble(4, obj.getArea());
            cs.setString(5, obj.getDescripcion());
            cs.setDouble(6, obj.getPrecio());
            cs.setInt(7, obj.getTipo());
            cs.setInt(8, obj.getNumHab());
            cs.setInt(9, obj.getNumBanio());
            cs.setInt(10, obj.getNumGarage());
            cs.setInt(11, obj.getAnioConst());
            cs.setString(12, obj.getImg());
            res = cs.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return res;
    }

      public int GuardarPersonal(Inmueble obj) {
        int res = 0;
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "{call insert_casa(?,?,?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, obj.getIdInmueble());
            cs.setString(2, obj.getTitulo());
            cs.setString(3, obj.getDireccion());
            cs.setDouble(4, obj.getArea());
            cs.setString(5, obj.getDescripcion());
            cs.setDouble(6, obj.getPrecio());
            cs.setInt(7, obj.getTipo());
            cs.setInt(8, obj.getNumHab());
            cs.setInt(9, obj.getNumBanio());
            cs.setInt(10, obj.getNumGarage());
            cs.setInt(11, obj.getAnioConst());
            cs.setString(12, obj.getImg());
            res = cs.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return res;
    }
      
      //listado de Casas
    public List<Inmueble> listPersonal() {
        List<Inmueble> lis = new ArrayList<>();
        Connection conn = null;
   try {
            conn = MySQLConexion.getConexion();
            String sql = "SELECT * FROM inmueble i NATURAL JOIN casa c where i.idinmu=c.idinmu";
            PreparedStatement st = conn.prepareStatement(sql);
            //st.setString(1, cad);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                Inmueble a = new Inmueble();
                a.setIdInmueble(rs.getInt(1));
                a.setTitulo(rs.getString(2));
                a.setDireccion(rs.getString(3));
                a.setArea(rs.getDouble(4));
                a.setImg(rs.getString(5));
                a.setDescripcion(rs.getString(6));
                a.setPrecio(rs.getDouble(7));
                a.setPiso(rs.getInt(8));
                a.setEstado(rs.getInt(9));
                a.setNumHab(rs.getInt(10));
                a.setNumBanio(rs.getInt(11));
                a.setNumGarage(rs.getInt(12));
                a.setAnioConst(rs.getInt(13));
	        lis.add(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return lis;
    }
    
    //listado de Parejas
    public List<Inmueble> listParejas() {
        List<Inmueble> lis = new ArrayList<>();
        Connection conn = null;
   try {
            conn = MySQLConexion.getConexion();
            String sql = "SELECT i.*, d.* FROM inmueble i NATURAL JOIN departamento d where i.idinmu=d.idinmu";
            PreparedStatement st = conn.prepareStatement(sql);
            //st.setString(1, cad);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                Inmueble b = new Inmueble();
                b.setIdInmueble(rs.getInt(1));
                b.setTitulo(rs.getString(2));
                b.setDireccion(rs.getString(3));
                b.setArea(rs.getDouble(4));
                b.setImg(rs.getString(5));
                b.setDescripcion(rs.getString(6));
                b.setPrecio(rs.getDouble(7));
                b.setPiso(rs.getInt(8));
                b.setEstado(rs.getInt(9));
                b.setNumHab(rs.getInt(10));
                b.setNumBanio(rs.getInt(11));
                b.setNumGarage(rs.getInt(12));
                b.setAnioConst(rs.getInt(13));
	        lis.add(b);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return lis;
    }
    
    //listado de Dobles
    public List<Inmueble> listDobles() {
        List<Inmueble> lis = new ArrayList<>();
        Connection conn = null;
   try {
            conn = MySQLConexion.getConexion();
            String sql = "SELECT i.*, o.* FROM inmueble i NATURAL JOIN oficina o where i.idinmu=o.idinmu";
            PreparedStatement st = conn.prepareStatement(sql);
            //st.setString(1, cad);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                Inmueble c = new Inmueble();
                c.setIdInmueble(rs.getInt(1));
                c.setTitulo(rs.getString(2));
                c.setDireccion(rs.getString(3));
                c.setArea(rs.getDouble(4));
                c.setImg(rs.getString(5));
                c.setDescripcion(rs.getString(6));
                c.setPrecio(rs.getDouble(7));
                c.setPiso(rs.getInt(8));
                c.setEstado(rs.getInt(9));
                c.setNumBanio(rs.getInt(10));
                c.setNumGarage(rs.getInt(11));
                c.setAnioConst(rs.getInt(12));
	        lis.add(c);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return lis;
    }
    
    
    
    //listado de Casas de un cliente
    public List<Inmueble> cliListPersonal(int idcli) {
        List<Inmueble> lis = new ArrayList<>();
        Connection conn = null;
   try {
            conn = MySQLConexion.getConexion();
            String sql = "SELECT * FROM reserva r NATURAL JOIN habitacion h NATURAL JOIN cliente c WHERE r.id_habitacion=h.id and r.id_cliente=c.id and c.id=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, idcli);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                Inmueble a = new Inmueble();
                a.setIdInmueble(rs.getInt(1));
                a.setTitulo(rs.getString(8));
//                a.setDireccion(rs.getString(7));
//                a.setArea(rs.getDouble(8));
                a.setImg(rs.getString(9));
                a.setDescripcion(rs.getString(10));
                a.setPrecio(rs.getDouble(12));
                a.setPiso(rs.getInt(13));
//                a.setEstado(rs.getInt(13));
//                a.setNumHab(rs.getInt(14));
//                a.setNumBanio(rs.getInt(15));
//                a.setNumGarage(rs.getInt(16));
//                a.setAnioConst(rs.getInt(17));
	        lis.add(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return lis;
    }
    
//    //listado de departamentos de un cliente
//    public List<Inmueble> cliListParejas(int idcli) {
//        List<Inmueble> lis = new ArrayList<>();
//        Connection conn = null;
//   try {
//            conn = MySQLConexion.getConexion();
//            String sql = "SELECT * FROM comprainmu com NATURAL JOIN inmueble i NATURAL JOIN departamento d WHERE com.idinmu=i.idinmu and i.idinmu=d.idinmu and com.idcli=?";
//            PreparedStatement st = conn.prepareStatement(sql);
//            st.setInt(1, idcli);
//            ResultSet rs = st.executeQuery();
//            //llenar el arraylist con la clase entidad
//            while (rs.next()) {
//                Inmueble a = new Inmueble();
//                a.setIdInmueble(rs.getInt(1));
//                a.setTitulo(rs.getString(6));
//                a.setDireccion(rs.getString(7));
//                a.setArea(rs.getDouble(8));
//                a.setImg(rs.getString(9));
//                a.setDescripcion(rs.getString(10));
//                a.setPrecio(rs.getDouble(11));
//                a.setPiso(rs.getInt(12));
//                a.setEstado(rs.getInt(13));
//                a.setNumHab(rs.getInt(14));
//                a.setNumBanio(rs.getInt(15));
//                a.setNumGarage(rs.getInt(16));
//                a.setAnioConst(rs.getInt(17));
//	        lis.add(a);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            try {
//
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (Exception e2) {
//            }
//        }
//
//        return lis;
//    }
//    
//    //listado de Dobles
//    public List<Inmueble> cliListDobles(int idcli) {
//        List<Inmueble> lis = new ArrayList<>();
//        Connection conn = null;
//   try {
//            conn = MySQLConexion.getConexion();
//            String sql = "SELECT * FROM comprainmu com NATURAL JOIN inmueble i NATURAL JOIN oficina o WHERE com.idinmu=i.idinmu and i.idinmu=o.idinmu and com.idcli=?";
//            PreparedStatement st = conn.prepareStatement(sql);
//            st.setInt(1, idcli);
//            ResultSet rs = st.executeQuery();
//            //llenar el arraylist con la clase entidad
//            while (rs.next()) {
//                Inmueble a = new Inmueble();
//                a.setIdInmueble(rs.getInt(1));
//                a.setTitulo(rs.getString(6));
//                a.setDireccion(rs.getString(7));
//                a.setArea(rs.getDouble(8));
//                a.setImg(rs.getString(9));
//                a.setDescripcion(rs.getString(10));
//                a.setPrecio(rs.getDouble(11));
//                a.setPiso(rs.getInt(12));
//                a.setEstado(rs.getInt(13));
//                a.setNumBanio(rs.getInt(14));
//                a.setNumGarage(rs.getInt(15));
//                a.setAnioConst(rs.getInt(16));
//	        lis.add(a);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            try {
//
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (Exception e2) {
//            }
//        }
//
//        return lis;
//    }
//    
   
    
    //eliminar una casa
    public void delPersonal(int id){
        int codigo ;
        Connection conn = null;
   try {
            conn = MySQLConexion.getConexion();
            //invocando a un procedure
            String sql = "Delete from casa where idinmu=?";
            //PreparedStatement st2=conn.prepareStatement("insert into alumno(?,?,?,?,?)");
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            
            String sql2 = "Delete from inmueble where idinmu=?";
            PreparedStatement st2 = conn.prepareStatement(sql2);
            st2.setInt(1, id);
            st2.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
       
    }
    
    //eliminar un departamento
    public void delParejas(int id){
        int codigo ;
        Connection conn = null;
   try {
            conn = MySQLConexion.getConexion();
            //invocando a un procedure
            String sql = "Delete from departamento where idinmu=?";
            //PreparedStatement st2=conn.prepareStatement("insert into alumno(?,?,?,?,?)");
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            
            String sql2 = "Delete from inmueble where idinmu=?";
            PreparedStatement st2 = conn.prepareStatement(sql2);
            st2.setInt(1, id);
            st2.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
       
    }
    
    //eliminar una oficina
    public void delDobles(int id){
        int codigo ;
        Connection conn = null;
   try {
            conn = MySQLConexion.getConexion();
            //invocando a un procedure
            String sql = "Delete from oficina where idinmu=?";
            //PreparedStatement st2=conn.prepareStatement("insert into alumno(?,?,?,?,?)");
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            
            String sql2 = "Delete from inmueble where idinmu=?";
            PreparedStatement st2 = conn.prepareStatement(sql2);
            st2.setInt(1, id);
            st2.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
       
    }
    
    
    
    //buscar un inmueble
    public List<Inmueble> searchInmueble(int inmu, int tipo){
        List<Inmueble> lis = new ArrayList<>();

            switch(inmu){
                case 1:
                    lis=searchPersonal(tipo);
                    break;
                case 2:
                    lis=searchParejas(tipo);
                    break;
                case 3:
                    lis=searchDobles(tipo);
                    break;
            }
        return lis;
    }
    
    public List<Inmueble> searchPersonal(int tipo){
        List<Inmueble> lis = new ArrayList<>();
        String sql="";
        PreparedStatement st =null;
        Connection conn = null;
    try {
        conn = MySQLConexion.getConexion();
        sql = "SELECT * from habitacion h NATURAL JOIN tipohabitacion tp WHERE h.id_tipohabitacion=tp.id and tp.nombre='personal' and tp.tipo=?";
            st = conn.prepareStatement(sql);
            st.setInt(1, tipo);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                Inmueble a = new Inmueble();
                a.setIdInmueble(rs.getInt(1));
                a.setTitulo(rs.getString(2));
                a.setDescripcion(rs.getString(4));
                a.setImg(rs.getString(3));
                a.setPrecio(rs.getDouble(6));
                a.setPiso(rs.getInt(7));
                a.setNumHab(rs.getInt(5));
	        lis.add(a);
            }
    } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return lis;
    }
    
    public List<Inmueble> searchParejas(int tipo){
        List<Inmueble> lis = new ArrayList<>();
        String sql="";
        PreparedStatement st =null;
        Connection conn = null;
    try {
        conn = MySQLConexion.getConexion();
        sql = "SELECT * from habitacion h NATURAL JOIN tipohabitacion tp WHERE h.id_tipohabitacion=tp.id and tp.nombre='parejas' and tp.tipo=?";
            st = conn.prepareStatement(sql);
            st.setInt(1, tipo);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                Inmueble a = new Inmueble();
                a.setIdInmueble(rs.getInt(1));
                a.setTitulo(rs.getString(2));
                a.setImg(rs.getString(3));
                a.setDescripcion(rs.getString(4));
                a.setPrecio(rs.getDouble(6));
                a.setPiso(rs.getInt(7));
                a.setNumHab(rs.getInt(5));
	        lis.add(a);
            }
    } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return lis;
    }
    
    public List<Inmueble> searchDobles(int tipo){
        List<Inmueble> lis = new ArrayList<>();
        String sql="";
        PreparedStatement st =null;
        Connection conn = null;
    try {
        conn = MySQLConexion.getConexion();
        sql = "SELECT * from habitacion h NATURAL JOIN tipohabitacion tp WHERE h.id_tipohabitacion=tp.id and tp.nombre='dobles' and tp.tipo=?";
            st = conn.prepareStatement(sql);
            st.setInt(1, tipo);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                Inmueble a = new Inmueble();
                a.setIdInmueble(rs.getInt(1));
                a.setTitulo(rs.getString(2));
                a.setImg(rs.getString(3));
                a.setDescripcion(rs.getString(4));
                a.setPrecio(rs.getDouble(6));
                a.setPiso(rs.getInt(7));
                a.setNumHab(rs.getInt(5));
	        lis.add(a);
            }
    } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return lis;
    }
    
    
    
    
    
    //Actualizar Datos de una Personal
    public Personal buscaInmu(int id) {
        Personal c=null;
        Connection conn = null;
        try {
            conn = MySQLConexion.getConexion();
            String sql = "select * from inmueble i NATURAL JOIN casa c WHERE i.idinmu=c.idinmu and c.idinmu=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                c = new Personal();
//                c.setIdInmu(rs.getInt(1));
//                c.setTitulo(rs.getString(2));
//                c.setDescripcion(rs.getString(3));
//                c.setArea(rs.getDouble(4));
//                c.setImg(rs.getString(5));
//                c.setDescrip(rs.getString(6));
//                c.setPrecio(rs.getDouble(7));
//                c.setPiso(rs.getInt(8));
//                c.setEstado(rs.getInt(9));
//                c.setNumhab(rs.getInt(10));
//                c.setNumbanio(rs.getInt(11));
//                c.setNumgarage(rs.getInt(12));
//                c.setAniocost(rs.getInt(13));
	     }
        }
        catch(Exception ex){ex.printStackTrace();}
        finally{try{if(conn != null){conn.close();}}catch(Exception e2){}}
        return c;
    }
    
    public void Actua_Personal(Personal c){
          Connection conn = null;
        try {
            conn = MySQLConexion.getConexion();
            String sql = "{call update_casa(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement st = conn.prepareCall(sql);
//            st.setInt(1, c.getIdInmu());
//            st.setString(2, c.getTitulo());
//            st.setString(3, c.getDescripcion());
//            st.setDouble(4, c.getArea());
//            st.setString(5, c.getDescrip());
//            st.setDouble(6, c.getPrecio());
//            st.setInt(7, c.getTipo());
//            st.setInt(8, c.getEstado());
//            st.setInt(9, c.getNumhab());
//            st.setInt(10, c.getNumbanio());
//            st.setInt(11, c.getNumgarage());
//            st.setInt(12, c.getAniocost());
//            st.setString(13, c.getImg());
            st.executeUpdate();
        }
        catch (Exception ex) {ex.printStackTrace();}
        finally {try {if(conn != null){conn.close();}}catch (Exception e2){}}
    }
    public Parejas buscaParejas(int id) {
        Parejas d=null;
        Connection conn = null;
        try {
            conn = MySQLConexion.getConexion();
            String sql = "select * from inmueble i NATURAL JOIN departamento d WHERE i.idinmu=d.idinmu and d.idinmu=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                d = new Parejas();
//                d.setIdInmu(rs.getInt(1));
//                d.setTitulo(rs.getString(2));
//                d.setDireccion(rs.getString(3));
//                d.setArea(rs.getDouble(4));
//                d.setImg(rs.getString(5));
//                d.setDescrip(rs.getString(6));
//                d.setPrecio(rs.getDouble(7));
//                d.setTipo(rs.getInt(8));
//                d.setEstado(rs.getInt(9));
//                d.setNumhab(rs.getInt(10));
//                d.setNumbanio(rs.getInt(11));
//                d.setNumgarage(rs.getInt(12));
//                d.setAniocost(rs.getInt(13));
	     }
        }
        catch(Exception ex){ex.printStackTrace();}
        finally{try{if(conn != null){conn.close();}}catch(Exception e2){}}
        return d;
    }
    public void Actua_Parejas(Parejas d){
          Connection conn = null;
        try {
            conn = MySQLConexion.getConexion();
            String sql = "{call update_departamento(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement st = conn.prepareCall(sql);
            st.setInt(1, d.getIdInmu());
            st.setString(2, d.getTitulo());
//            st.setString(3, d.getDireccion());
//            st.setDouble(4, d.getArea());
//            st.setString(5, d.getDescrip());
//            st.setDouble(6, d.getPrecio());
//            st.setInt(7, d.getTipo());
//            st.setInt(8, d.getEstado());
//            st.setInt(9, d.getNumhab());
//            st.setInt(10, d.getNumbanio());
//            st.setInt(11, d.getNumgarage());
//            st.setInt(12, d.getAniocost());
            st.setString(13, d.getImg());
            st.executeUpdate();
        }
        catch (Exception ex) {ex.printStackTrace();}
        finally {try {if(conn != null){conn.close();}}catch (Exception e2){}}
    }
    
    public Dobles buscaDobles(int id) {
        Dobles o=null;
        Connection conn = null;
        try {
            conn = MySQLConexion.getConexion();
            String sql = "select * from inmueble i NATURAL JOIN oficina o WHERE i.idinmu=o.idinmu and o.idinmu=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                o = new Dobles();
                o.setIdInmu(rs.getInt(1));
                o.setTitulo(rs.getString(2));
//                o.setDireccion(rs.getString(3));
//                o.setArea(rs.getDouble(4));
                o.setImg(rs.getString(5));
                o.setDescrip(rs.getString(6));
                o.setPrecio(rs.getDouble(7));
                o.setTipo(rs.getInt(8));
//                o.setEstado(rs.getInt(9));
//                o.setNumbanio(rs.getInt(10));
//                o.setNumgarage(rs.getInt(11));
//                o.setAniocost(rs.getInt(12));
	     }
        }
        catch(Exception ex){ex.printStackTrace();}
        finally{try{if(conn != null){conn.close();}}catch(Exception e2){}}
        return o;
    }
    public void Actua_Dobles(Dobles o){
          Connection conn = null;
        try {
            conn = MySQLConexion.getConexion();
            String sql = "{call update_oficina(?,?,?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement st = conn.prepareCall(sql);
            st.setInt(1, o.getIdInmu());
            st.setString(2, o.getTitulo());
//            st.setString(3, o.getDireccion());
//            st.setDouble(4, o.getArea());
            st.setString(5, o.getDescrip());
            st.setDouble(6, o.getPrecio());
            st.setInt(7, o.getTipo());
//            st.setInt(8, o.getEstado());
//            st.setInt(9, o.getNumbanio());
//            st.setInt(10, o.getNumgarage());
//            st.setInt(11, o.getAniocost());
            st.setString(12, o.getImg());
            st.executeUpdate();
        }
        catch (Exception ex) {ex.printStackTrace();}
        finally {try {if(conn != null){conn.close();}}catch (Exception e2){}}
    }
    
    
    public int numPersonalT(){
        int num=0;
        Connection conn = null;
        try {
            conn = MySQLConexion.getConexion();
            String sql = "SELECT COUNT(*) FROM casa";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return num;
    }
    
    public int numParejasT(){
        int num=0;
        Connection conn = null;
        try {
            conn = MySQLConexion.getConexion();
            String sql = "SELECT COUNT(*) FROM departamento";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return num;
    }
    
    public int numDoblesT(){
        int num=0;
        Connection conn = null;
        try {
            conn = MySQLConexion.getConexion();
            String sql = "SELECT COUNT(*) FROM oficina";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return num;
    }
    
    
    
    public void Registrar(Cliente cli) {
        
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "{call registrarCli(?,?,?,?,?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, cli.getNomcli());
            cs.setString(2, cli.getApecli());
            cs.setString(3, cli.getEmailcli());
            cs.setString(4, cli.getCelcli());
            cs.setString(5, cli.getPasscli());
            cs.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
    }
    
    public Cliente busCli(String email) {
        int nivel=0;//0=admin, 1=user
        Cliente cli=null;
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "SELECT c.id, c.nombre, c.correo, c.password FROM cliente c where c.correo=?";
            //String sql2="SELECT * FROM admin a where a.useradmin=?" ;
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            
//            PreparedStatement st2 = conn.prepareStatement(sql2);
//            st2.setString(1, email);
//            ResultSet rs2 = st2.executeQuery();

            if (rs.next()) {
                
                    cli = new Cliente();
                    cli.setIdcli(rs.getInt(1));
                    cli.setNomcli(rs.getString(2));
                    cli.setEmailcli(rs.getString(3));
                    cli.setPasscli(rs.getString(4));
                    nivel=1;
                    cli.setNivel(nivel);
                           
                
            }
            
//            if(rs2.next()){
//                
//                    cli = new Cliente();
//                    cli.setIdcli(rs2.getInt(1));
//                    cli.setNomcli(rs2.getString(2));
//                    cli.setPasscli(rs2.getString(3));
//                    cli.setNivel(nivel);
//                
//            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return cli;
    }
    
    public void compra(int idcli, int idinmu, double total) {
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "{call insert_compra(?,?,?,?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, idcli);
            cs.setInt(2, idinmu);
            cs.setInt(3, 1);
            cs.setDouble(4, total);
            cs.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
    }
}
