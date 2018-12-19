package ba.unsa.etf.rpr;

public class Drzava {

    private int id;
    private String naziv;
    private Grad glavniGrad;

    public void setGlavniGrad(Grad sarajevo) {
        glavniGrad = sarajevo;
    }

    public int getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public Grad getGlavniGrad() {
        return glavniGrad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
