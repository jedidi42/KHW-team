package entities;

import java.util.*;


public class Book {
    int id;
    String title ;
    String author ;
    double price ;
    Date releaseDate;
    String coverPic ;

    public void setCoverPic(String coverPic) {
        this.coverPic = coverPic;
    }

    public String getCoverPic() {
        return coverPic;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

   

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

 

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", releaseDate=" + releaseDate + '}';
    }

    
    
   
    
    
    
    
}