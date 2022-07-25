
package beans;


public class Personal {
    private int idInmu;
    private String titulo;
    private String descrip;
    private String img;
    private double precio;
    private int piso;
    private int numhab;
    
    public Personal(){
    }

    public Personal(int idInmu, String titulo, String descrip, String img, double precio, int piso, int estado, int numhab) {
        this.idInmu = idInmu;
        this.titulo = titulo;
        this.descrip = descrip;
        this.img = img;
        this.precio = precio;
        this.piso = piso;
        this.numhab = numhab;
    }

    

    public int getIdInmu() {
        return idInmu;
    }

    public void setIdInmu(int idInmu) {
        this.idInmu = idInmu;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNumhab() {
        return numhab;
    }

    public void setNumhab(int numhab) {
        this.numhab = numhab;
    }
    
}
