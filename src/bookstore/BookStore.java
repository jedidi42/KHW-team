/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.util.*;
import java.sql.Date;
import java.util.Scanner;
import entities.Book;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static dao.DaoBook.addBook;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static javax.print.attribute.Size2DSyntax.MM;

public class BookStore {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    private static final DateTimeFormatter PARSE_FORMATTER
            = DateTimeFormatter.ofPattern("uuuu-M-d");

    public static void main(String[] args) throws SQLException, ParseException {

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter the quantity of books : ");
//        int qte = scanner.nextInt();
//
//        System.out.print("ENter the price of a book : ");
//        double prixU = scanner.nextInt();
//        double result = Utility.CalculateTotalPrice(qte, prixU);
//        System.out.print("the total price is = "+result);
        int choix = 0;
        Scanner scanner = new Scanner(System.in);
        while (choix != 3) {
            System.out.println("1- display books ");
            System.out.println("2- insert a new book");
            System.out.println("Enter your choice");
            Scanner scannerchoix = new Scanner(System.in);
            choix = scannerchoix.nextInt();
            if (choix == 2) {
                System.out.println("Enter the book title: ");
                String title = scanner.nextLine();
                System.out.println("Enter th price : ");
                double price = scanner.nextInt();
                System.out.println("Enter the author : ");
                Scanner scanner2 = new Scanner(System.in);
                String author = scanner2.nextLine();
                System.out.println("Please enter the release date (yyyy-mm-dd)");
             
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date date = sdf.parse(scanner2.nextLine());
             
                System.out.println(date);

                Book newbook = new Book(title, author, price, date);
                addBook(newbook);

            }
        }

    }

}
