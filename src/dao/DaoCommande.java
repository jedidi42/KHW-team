/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Book;
import entities.commande;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.Date;
import java.util.List;
/**
 *
 * @author hamza jedidi
 */
public class DaoCommande {
    
    java.util.Date date;
    public static void addCommande(commande comm, Connection conn) throws ParseException {
     

        PreparedStatement stat;

        try {
            stat = conn.prepareStatement("insert into commande " + " (dateC,price,idClient,book)" + " values (?, ? ,?,?)");
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse(comm.getDateC().toString());
            stat.setDate(1, (new java.sql.Date(date.getTime())));
            
            stat.setDouble(2, comm.getPrice());
            stat.setInt(3, comm.getIdClient());
            stat.setInt(4, comm.getIdBook());

        
            stat.executeUpdate();
           System.out.print("the purchase is added !");
                        System.out.println("**********************");
        } catch (SQLException ex) {
            Logger.getLogger(DaoBook.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.print("seccusfuly! \n");

    }
    
    
    
        public static List<commande> listCommande(Connection conn) {
        try {
            String requete = "SELECT * FROM book group by idClient";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(requete);

            boolean counter = result.next();
            List<commande> listcommande = new ArrayList();
            while (counter) {

                commande newcom = new commande();
                newcom.setId(result.getInt("id"));
                newcom.setPrice(result.getDouble("price"));
                newcom.setPrice(result.getInt("idClient"));
                newcom.setIdBook(result.getInt("book"));
                Date date = result.getDate("DateC");
                newcom.setDateC(date);
                listcommande.add(newcom);
                counter = result.next();
                System.out.println("**********************");
            }
            result.close();
            return listcommande;
        } catch (SQLException e) {
            System.out.println("vermegalternant.MyProg.Insert()" + e);
            return null;
        }

    }
    
    
    
    
    
    
}
