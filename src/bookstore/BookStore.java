/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import dao.DaoBook;
import entities.Book;
import java.sql.Connection;
import java.sql.Date;
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
                while (choix != 5) {
                    System.out.println("1- insert a new book ");
                    System.out.println("2- list books ");
                    System.out.println("3- modify a book ");
                    System.out.println("4- delete a book ");
                    System.out.println("5- exit ");
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
                        case 3:
                                  Scanner scid = new Scanner(System.in);
                            System.out.println("Enter the id of the book: ");
                            int id = scid.nextInt();
                            Scanner scid1 = new Scanner(System.in);
                            System.out.println(" enter the title : ");
                            String Title = scid1.nextLine();
                            System.out.println(" Enter the price : ");
                            double Price = Double.parseDouble(scid1.nextLine());
                            System.out.println(" Enter the author : ");
                            String Author = scid1.nextLine();
                            System.out.println(" Enter the release Date  : ");
                            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                            java.util.Date date2 = sdf1.parse(scid1.nextLine());
                            Date releaseDate = new java.sql.Date(date2.getTime());
                            DaoBook.modifyBook(id, Title, Price, Author, releaseDate, conn);
                            break;
                        case 4: 
                             Scanner scannerid = new Scanner(System.in);
                        System.out.print("Enter the id of the book: ");
                        int id1 = scannerid.nextInt();
                        DaoBook.deleteBook(id1, conn);
                        break;
                        default:
                            System.out.print("your choice is incorrect ! ");
                            break;
                    }
                }
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
                conn.close();
            }
        } catch (SQLException Se) {
            System.out.println(Se);
        }
        /**
         * *************************
         */

    }

}
