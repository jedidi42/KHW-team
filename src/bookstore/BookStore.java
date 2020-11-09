/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;
import java.sql.*;
import classes.Utility;
import java.util.Scanner;


public class BookStore {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter the quantity of books : ");
//        int qte = scanner.nextInt();
//
//        System.out.print("ENter the price of a book : ");
//        double prixU = scanner.nextInt();
//        double result = Utility.CalculateTotalPrice(qte, prixU);
//        System.out.print("the total price is = "+result);
        
        //connection with data base
        try {
           
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "");
            System.out.println(conn);
            int choix=0;
            while (choix!=3) {
                System.out.println("1- display books ");
                System.out.println("2- insert a new book");
                System.out.println("Enter your choice");
             Scanner scannerchoix = new Scanner(System.in);
                choix = scannerchoix.nextInt();
            }
              } catch (SQLException e) {
            System.out.println(e);
            
        }
            
            
            
            
            
            
    }

}
