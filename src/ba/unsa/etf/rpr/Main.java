package ba.unsa.etf.rpr;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Gradovi su:\n" + ispisiGradove());
        //glavniGrad();
        String url = "jdbc:sqlite:baza";
        String upit = "SELECT naziv FROM drzava d, grad g WHERE d.glavni_grad = g.id";
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(upit);

            while(result.next()) {
                String naziv = result.getString(1);
                System.out.println (naziv);
            }
        }catch (SQLException e){
            System.out.println("nema");
        }
    }
}
