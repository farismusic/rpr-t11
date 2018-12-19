package ba.unsa.etf.rpr;

public class Grad {

    private int id;
    private String naziv;
    private int brojStanovnika;
    private Drzava drzava;



    public String getNaziv() {
        return naziv;
    }

    public Drzava getDrzava() {
        return drzava;
    }

    public void setNaziv(String marseille) {
        naziv = marseille;
    }

    public void setBrojStanovnika(int i) {
        brojStanovnika = i;
    }

    public void setDrzava(Drzava francuska) {
        drzava = francuska;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }

    public void setNaziv() {
        this.naziv = naziv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
