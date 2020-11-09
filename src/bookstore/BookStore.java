/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import classes.Utility;
import java.util.Scanner;

/**
 *
 * @author chaym
 */
public class BookStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the quantity of books : ");
        int qte = scanner.nextInt();

        System.out.print("ENter the price of a book : ");
        double prixU = scanner.nextInt();
        double result = Utility.CalculateTotalPrice(qte, prixU);
        System.out.print("the total price is = "+result);
    }

}
