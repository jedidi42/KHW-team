/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;

import java.util.*;

import entities.Book;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author waelk
 */
public class DaoBook {

    public static void addBook(Book book) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "");
 try {
        String sql = "insert into book "
                + " (title, price, author, releaseDate)" + " values (?, ?, ?, ?)";
        PreparedStatement myStmt = conn.prepareStatement(sql);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date  date = sdf.parse(book.getReleaseDate().toString());

            myStmt.setString(1, book.getTitle());
            myStmt.setDouble(2, book.getPrice());
            myStmt.setString(3, book.getAuthor());
            myStmt.setDate(4, (new java.sql.Date(date.getTime())));
            myStmt.executeUpdate();
        } catch (ParseException ex) {
            Logger.getLogger(DaoBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
