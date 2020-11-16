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
    int idBook ;
    int idClient;
    double price ;
    Date dateC;

    public void setId(int id) {
        this.id = id;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
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

    public int getIdBook() {
        return idBook;
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
