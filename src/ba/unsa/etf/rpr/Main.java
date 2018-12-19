package ba.unsa.etf.rpr;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {

            GeografijaDAO dao = GeografijaDAO.getInstance();
            Drzava francuska = dao.nadjiDrzavu("Francuska");
            Grad grad = new Grad();
            grad.setNaziv("Marseille");
            grad.setBrojStanovnika(869815);
            grad.setDrzava(francuska);
            dao.dodajGrad(grad);

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (NullPointerException e){
            System.out.println("greska");
        }
    }
}
