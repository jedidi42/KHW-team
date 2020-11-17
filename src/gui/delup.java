package gui;
import java.awt.Graphics;  
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import entities.Book;




public class delup extends javax.swing.JFrame {
	Connection con;
    Statement st;
    ArrayList<Book> books = new ArrayList<>();
	
	public delup () {
	    
		initComponents();
        fetch();
	}
	
	 private void initComponents() {
		 txttitle = new javax.swing.JTextField();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        txtauthor = new javax.swing.JTextField();
	        txtprice = new javax.swing.JTextField();
	        jLabel3 = new javax.swing.JLabel();
	        txtdate = new javax.swing.JTextField();
	        jLabel4 = new javax.swing.JLabel();
	        
	        jScrollPane1 = new javax.swing.JScrollPane();
	        tblBooks = new javax.swing.JTable();
	        btnSave = new javax.swing.JButton();
	        btnUpdate = new javax.swing.JButton();
	        btnDelete1 = new javax.swing.JButton();
	        jLabel4 = new javax.swing.JLabel();
	        
	        
	        
	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        setTitle("BOOKSTORE");
	        setResizable(false);
	        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        jLabel1.setText("TITLE");

	        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        jLabel2.setText("AUTHOR");

	        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        jLabel3.setText("PRICE");
	        
	        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        jLabel4.setText("DATE");
	        
	        tblBooks.setModel(new javax.swing.table.DefaultTableModel(
	                new Object [][] {

	                },new String [] {
	                        "title", "author", "price","date"
	                }
	            ) {
	                boolean[] canEdit = new boolean [] {
	                    false, false, false , false
	                };

	                public boolean isCellEditable(int rowIndex, int columnIndex) {
	                    return canEdit [columnIndex];
	                }
	            });
	        
	        
	        tblBooks.setCellSelectionEnabled(true);
	        tblBooks.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                tblBooksMouseClicked(evt);
	            }
	        });
	        jScrollPane1.setViewportView(tblBooks);
	        if (tblBooks.getColumnModel().getColumnCount() > 0) {
	        	tblBooks.getColumnModel().getColumn(2).setResizable(false);
	        }
	        
	        
	        btnSave.setText("Save");
	        btnSave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
	        btnSave.setIconTextGap(0);
	        btnSave.setInheritsPopupMenu(true);
	        btnSave.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                btnSaveActionPerformed(evt);
	            }
	        });

	        btnUpdate.setText("Update");
	        btnUpdate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
	        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	              //  btnUpdateActionPerformed(evt);
	            }
	        });

	        btnDelete1.setText("Delete");
	        btnDelete1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
	        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	               // btnDelete1ActionPerformed(evt);
	            }
	        });
	        
	      
	        jLabel5.setText("BOOKSTORE");
	        
	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addGap(18, 18, 18)
	                                .addComponent(txttitle, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(txtauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(27, 27, 27)
	                        .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	            .addGroup(layout.createSequentialGroup()
	                .addGap(218, 218, 218)
	                .addComponent(jLabel4)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(txttitle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGap(30, 30, 30)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(txtauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGap(30, 30, 30)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGap(39, 39, 39)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(29, Short.MAX_VALUE))
	        );

	        pack();
	        setLocationRelativeTo(null);
	    }// </
	  //set the values of a row to the textfields
	    private void tblBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentsMouseClicked
	        // TODO add your handling code here:
	        int i = tblBooks.getSelectedRow();
	        TableModel model = tblBooks.getModel();
	        txttitle.setText(model.getValueAt(i, 0).toString());
	        txtauthor.setText(model.getValueAt(i, 1).toString());
	        txtprice.setText(model.getValueAt(i, 2).toString());
	    }//GEN-LAST:event_tblStudentsMouseClicked
	 
	 private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
	        // TODO add your handling code here:
	        String title = txttitle.getText().trim();
	        String author = txtauthor.getText().trim();
	        double price = txtprice.getAlignmentY();
	        
	        if (!title.isEmpty() && !author.isEmpty() && !(price==0.0)) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver");
	                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "");
	                String sql = "select * from book";
	                st = con.createStatement();
	                ResultSet rs = st.executeQuery(sql);
	                if (!rs.first()) {
	                    saveUser(title, author, price);
	                    DefaultTableModel model = (DefaultTableModel) tblBooks.getModel();
	                    Object[] row = new Object[4];
	                    row[0] = title;
	                    row[1] = author;
	                    row[2] = price;
	                    model.addRow(row);
	                } else {
	                    alert("Please provide a different id number", "Similar id found");
	                }

	                clear();
	            } catch (SQLException | ClassNotFoundException ex) {
	                Logger.getLogger(delup.class.getName()).log(Level.SEVERE, null, ex);
	            } finally {
	                try {
	                    con.close();
	                    st.close();
	                } catch (SQLException ex) {
	                    Logger.getLogger(delup.class.getName()).log(Level.SEVERE, null, ex);
	                }
	            }
	        } //        else if (!id.matches("^[0-9]{8}$")) {
	        //            alert("please provide a valid id number", "Wrong id");
	        //        } 
	        else {
	            alert("please fill in all the details");
	        }
	    }//GEN-LAST:event_btnSaveActionPerformed
	        
	 //method to save user to the db
	    public void saveUser(String title, String author, double price) {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "");
	            String sql = "INSERT INTO `book`(`title`, `author`, `price`) "
	                    + "VALUES ('" + title + "','" + author + "','" + price + "')";
	            st = con.createStatement();
	            st.execute(sql);
	        } catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(delup.class.getName()).log(Level.SEVERE, null, ex);
	        }
//	        fetch();
	    }
	 
	 
	 
	  //method to show an info alert
	    public void alert(String msg) {
	        JOptionPane.showMessageDialog(rootPane, msg);
	    }

	    //method to show an error alert
	    public void alert(String msg, String title) {
	        JOptionPane.showMessageDialog(rootPane, msg, title, JOptionPane.ERROR_MESSAGE);
	    }

	    private void clear() {
	        txttitle.setText("");
	        txtauthor.setText("");
	        txtprice.setText("");
	    }
	    
	    
	    
	    private void fetch() {
	        books.clear();
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "");
	            String sql = "select * from book";
	            st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	            while (rs.next()) {
	                Book b = new Book();
	                books.add(b);
	            }
	            DefaultTableModel model = (DefaultTableModel) tblBooks.getModel();
	            for (Book user : books) {

	                Object[] row = new Object[4];
	                row[0] = user.getTitle();
	                row[1] = user.getAuthor();
	                row[2] = user.getPrice();

	                model.addRow(row);
	            }

	        } catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(delup.class.getName()).log(Level.SEVERE, null, ex);
	        }}
	    
	    
	    
	// Variables declaration - do not modify//GEN-BEGIN:variables
	    private javax.swing.JButton btnDelete1;
	    private javax.swing.JButton btnSave;
	    private javax.swing.JButton btnUpdate;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JLabel jLabel5;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JTable tblBooks;
	    private javax.swing.JTextField txttitle;
	    private javax.swing.JTextField txtprice;
	    private javax.swing.JTextField txtdate;
	    private javax.swing.JTextField txtauthor;
	    // End of variables declaration//GEN-END:variables	
}
