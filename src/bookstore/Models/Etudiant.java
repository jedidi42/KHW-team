/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Models;

/**
 *
 * @author waelk
 */
public class Etudiant {
    int id;
    String fname;
    String lastname;
    String email;
      public int getId() {
    return id;
  }
         public String getfname() {
    return fname;
  }
      public String getlastname() {
    return lastname;
  }
     public String getemail() {
    return email;
  }
    public void setId(int c) {
    this.id = c;
  }
      public void setfname(String c) {
    this.fname = c;
  }
      public void setlastname(String b) {
    this.lastname = b;
  }
       public void setemail(String d) {
    this.email = d;
  }
}
