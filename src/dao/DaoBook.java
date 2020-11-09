/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Book;
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


public class DaoBook {

    public DateFormat dateFormat;
    java.util.Date date;

    public static void addBook(Book book, Connection conn) throws ParseException {
     

        PreparedStatement stat;

        try {
            stat = conn.prepareStatement("insert into book " + " (title,price, author,releaseDate)" + " values (?, ? ,?,?)");
            stat.setString(1, book.getTitle());
            stat.setDouble(2, book.getPrice());
            stat.setString(3, book.getAuthor());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse(book.getReleaseDate().toString());
            stat.setDate(4, (new java.sql.Date(date.getTime())));
            stat.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoBook.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.print("seccusfuly! \n");

    }

    public static List<Book> listBook(Connection conn) {
        try {
            String requete = "SELECT * FROM book";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(requete);

            boolean counter = result.next();
            List<Book> listbooks = new ArrayList();
            while (counter) {

                Book newbook = new Book();
                newbook.setId(result.getInt("id"));
                newbook.setTitle(result.getString("title"));
                newbook.setPrice(result.getDouble("price"));
                newbook.setAuthor(result.getString("author"));
                Date date = result.getDate("releaseDate");
                newbook.setReleaseDate(date);
                listbooks.add(newbook);
                counter = result.next();
            }
            result.close();
            return listbooks;
        } catch (SQLException e) {
            System.out.println("vermegalternant.MyProg.Insert()" + e);
            return null;
        }

    }
}