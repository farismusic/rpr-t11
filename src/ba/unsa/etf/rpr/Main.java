package ba.unsa.etf.rpr;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {

            GeografijaDAO dao = GeografijaDAO.getInstance();
            Grad nepoznat = dao.glavniGrad("Bosna i Hercegovina");
            Grad bech = dao.glavniGrad("Austrija");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("greska");
        }
    }
}
