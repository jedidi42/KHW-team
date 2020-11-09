/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;




import entities.Book;

import java.time.LocalDate;
import static java.time.LocalDate.from;
import java.time.ZoneId;

        /**
 *
 * @author waelk
 */
public class DaoBook {

  

    public static void addBook(Book book) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "");

        String sql = "insert into book "
                + " (title, price, author, releaseDate)" + " values (?, ?, ?, ?)";
        PreparedStatement myStmt = conn.prepareStatement(sql);
        myStmt.setString(1, book.getTitle());
        myStmt.setDouble(2, book.getPrice());
        myStmt.setString(3, book.getAuthor());
        myStmt.setDate(4,  book.getReleaseDate());
        myStmt.executeUpdate();
    }

}
