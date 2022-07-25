package beans;

public class Parejas {
    private int idInmu;
    private String titulo;
    private String img;
    private String descrip;
    private double precio;
    private int tipo;
    private int numhab;
    
    public Parejas(){
    }

    public Parejas(int idInmu, String titulo, String img, String descrip, double precio, int tipo, int numhab) {
        this.idInmu = idInmu;
        this.titulo = titulo;
        this.img = img;
        this.descrip = descrip;
        this.precio = precio;
        this.tipo = tipo;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getNumhab() {
        return numhab;
    }

    public void setNumhab(int numhab) {
        this.numhab = numhab;
    }
}