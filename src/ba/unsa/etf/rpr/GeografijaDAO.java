package ba.unsa.etf.rpr;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static sun.management.jmxremote.ConnectorBootstrap.initialize;

public class GeografijaDAO {
    private static GeografijaDAO instance = null;
    private Connection konekcija;
    private String url;
    private Statement stmt;
    private ResultSet result;
    private PreparedStatement ps;
    private PreparedStatement brisi;

    private static void initialize() throws SQLException {
        instance = new GeografijaDAO();
    }

    private GeografijaDAO() throws SQLException {
        konekcija = DriverManager.getConnection("jdbc:sqlite:baza");
        Statement stmt = konekcija.createStatement();
        //ps = konekcija.prepareStatement("SELECT g.naziv FROM drzava d, grad g WHERE d.glavni_grad = ?");
        //brisi = konekcija.prepareStatement("DELETE FROM drzava d, grad g WHERE drzava = ? AND d.id = g.drzava");
    }

    public static GeografijaDAO getInstance() throws SQLException {
        if (instance == null) initialize();
        return instance;
    }

    public static void removeInstance() {
        instance = null;
    }

    String glavniGrad(String drzava) throws SQLException {
        //ps.setString(1, drzava);
        //result = ps.executeQuery();
        ResultSet result = stmt.executeQuery("SELECT g.naziv FROM drzava d, grad g WHERE d.glavni_grad = g.id");
        Grad grad = new Grad();
        //if (!result.next()) return null;
        grad.setGlavni(result.getString(1));
        return result.getString(1);
    }

    void obrisiDrzavu(String drzava) throws SQLException {
        brisi.setString(1, drzava);
        Integer brojObrisanih = brisi.executeUpdate();
    }

    ArrayList<Grad> gradovi() throws SQLException {
        ArrayList<Grad> gradovi = new ArrayList<>();
        ResultSet result = stmt.executeQuery("SELECT naziv FROM grad");
        while(result.next()){
            Grad grad = new Grad();
            grad.setNaziv(result.getString(1));
            gradovi.add(grad);
        }
        return gradovi;
    }


    public void dodajDrzavu(Drzava bih) {

    }

    public void dodajGrad(Grad sarajevo) {

    }

    public Drzava nadjiDrzavu(String francuska) {
        return new Drzava();
    }

    public void izmijeniGrad(Grad bech) {

    }
}
