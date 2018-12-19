package ba.unsa.etf.rpr;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {

            GeografijaDAO dao = GeografijaDAO.getInstance();
            Grad bech = dao.glavniGrad("Austrija");
            System.out.println(bech.getId() + bech.getNaziv() + bech.getBrojStanovnika());


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("greska");
        }
    }

    public static String ispisiGradove() {
        return "";
    }
}
