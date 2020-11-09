/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import dao.DaoBook;
import entities.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;



public class BookStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "");
            System.out.println(conn);

             Scanner scanner = new Scanner(System.in);


            try {

                int choix = 0;
                while (choix != 3) {
                    System.out.println("1- insert a new book ");
                    System.out.println("2- list books ");
                    System.out.println("3- exit ");
                    System.out.println("Enter your choice plz");
                    Scanner scannerchoix = new Scanner(System.in);
                    choix = scannerchoix.nextInt();
                    switch (choix) {
                        case 1:
                            Book myBook = new Book();
                           
                            System.out.println(" enter the title : ");
                            myBook.setTitle(scanner.nextLine());
                            System.out.println(" Enter the price : ");
                            myBook.setPrice(Double.parseDouble(scanner.nextLine()));
                            System.out.print(" Enter the author : ");
                            myBook.setAuthor(scanner.nextLine());
                            System.out.println(" Enter the release Date  : ");
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            java.util.Date date = sdf.parse(scanner.nextLine());

                            myBook.setReleaseDate(new java.sql.Date(date.getTime()));
                            DaoBook.addBook(myBook, conn);
                            break;
                        case 2:
                            List<Book> myList = DaoBook.listBook(conn);
                            for (Book book : myList) {
                                System.out.println(book.toString());
                            }
                            break;

                        default:
                            System.out.print("your choice is incorrect ! ");
                            break;
                    }
                }
                 conn.close();
            } catch (Exception e) {
                System.out.println(e.getStackTrace()); conn.close();
            }
        } catch (SQLException Se) {
            System.out.println(Se);
        }
        /**
         * *************************
         */

    }

}