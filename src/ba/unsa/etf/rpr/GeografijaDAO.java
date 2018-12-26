package ba.unsa.etf.rpr;

import javafx.event.ActionEvent;
import net.sf.jasperreports.engine.JRException;

import java.sql.*;
import java.util.ArrayList;


public class GeografijaDAO {
    private static GeografijaDAO instance = null;
    private Connection konekcija;
    private String url;
    private Statement stmt;
    private PreparedStatement ps;
    private PreparedStatement brisi;

    private static void initialize() throws SQLException {
        instance = new GeografijaDAO();
    }

    public GeografijaDAO(GeografijaDAO hehe){
        instance = hehe;
    }

    private GeografijaDAO() throws SQLException {
        konekcija = DriverManager.getConnection("jdbc:sqlite:baza");
        Statement stmt = getKonekcija().createStatement();
        ps = getKonekcija().prepareStatement("SELECT g.naziv FROM drzava d, grad g WHERE d.glavni_grad = ?");
        //brisi = konekcija.prepareStatement("DELETE FROM drzava d, grad g WHERE drzava = ? AND d.id = g.drzava");
    }

    public static GeografijaDAO getInstance() throws SQLException {
        if (instance == null) initialize();
        return instance;
    }

    public static void removeInstance()
    {
        instance = null;
    }


    Grad glavniGrad(String drzavica) throws SQLException, NullPointerException {
        Grad grad = new Grad();
        stmt = getKonekcija().createStatement();
        ps.setString(1, drzavica);
        ResultSet result = ps.executeQuery();
        while( result.next()) {
            grad.setId(result.getInt(1));
            grad.setNaziv(result.getString(2));
            grad.setBrojStanovnika(3);
        }
        return grad;
    }

    void obrisiDrzavu(String drzavica) throws SQLException {
        Statement stmt = getKonekcija().createStatement();
        String upit = "DELETE FROM drzava d, grad g WHERE drzava = " + "'" + drzavica + "'" + "AND d.id = g.drzava";
        ResultSet result = stmt.executeQuery(upit);
    }

    ArrayList<Grad> gradovi() throws SQLException {
        ArrayList<Grad> gradovi = new ArrayList<>();
        Statement stmt = getKonekcija().createStatement();
        String upit = "SELECT naziv FROM grad";
        ResultSet result = stmt.executeQuery(upit);
        while(result.next()){
            Grad grad = new Grad();
            grad.setNaziv(result.getString(1));
            gradovi.add(grad);
        }
        return gradovi;
    }


    public void dodajDrzavu(Drzava bih) throws SQLException {
        Statement stmt = getKonekcija().createStatement();
        String upit = "insert into drzava (id, naziv, glavni_grad) values (" + bih.getId() + "," + " '" + bih.getNaziv() + "' ," + bih.getGlavniGrad().getId() + ")";
        ResultSet result = stmt.executeQuery(upit);
    }

    public void dodajGrad(Grad sarajevo) throws SQLException {
        Statement stmt = getKonekcija().createStatement();
        String upit = "INSERT INTO grad(id, naziv, broj_stanovnika, drzava) VALUES (" + sarajevo.getId() + "," + sarajevo.getNaziv() + "," + sarajevo.getBrojStanovnika() + "," + sarajevo.getDrzava().getId() + ")";
        ResultSet result = stmt.executeQuery(upit);
    }

    public Drzava nadjiDrzavu(String francuska) throws SQLException {
        Statement stmt = getKonekcija().createStatement();
        String upit = "SELECT * FROM drzava WHERE naziv = "+ "'" + francuska + "'";
        ResultSet result = stmt.executeQuery(upit);
        if(!result.next()) return null;
        Drzava drzava = new Drzava();
        drzava.setId(result.getInt(1));
        drzava.setNaziv(francuska);
        return drzava;
    }

    public void izmijeniGrad(Grad bech) throws SQLException {
        Statement stmt = getKonekcija().createStatement();
        String upit1 = "SELECT naziv FROM grad";
    }

    public Connection getKonekcija() {
        return konekcija;
    }

    public void stampajGradove(ActionEvent actionEvent) {
        try {
            new GradoviReport().showReport(instance.getConn());
        } catch (JRException e1) {
            e1.printStackTrace();
        }
    }

    private Connection getConn() {
        return konekcija;
    }
}
