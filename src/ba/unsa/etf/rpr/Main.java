package ba.unsa.etf.rpr;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            GeografijaDAO dao = GeografijaDAO.getInstance();
            //Grad nepoznat = dao.glavniGrad("Bosna i Hercegovina");
            String bech = dao.glavniGrad("Austrija");
            System.out.println(bech);
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (NullPointerException e){
            System.out.println("greska");
        }
    }
}
