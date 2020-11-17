/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author hamza jedidi
 */
public class commande {
     int id;
    String Book ;
    int idClient;
    double price ;
    Date dateC;

    public void setId(int id) {
        this.id = id;
    }

    public void setIdBook(String idBook) {
        this.Book = idBook;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDateC(Date dateC) {
        this.dateC = dateC;
    }

    public int getId() {
        return id;
    }

    public String getIdBook() {
        return Book;
    }

    public int getIdClient() {
        return idClient;
    }

    public double getPrice() {
        return price;
    }

    public Date getDateC() {
        return dateC;
    }
    
}
