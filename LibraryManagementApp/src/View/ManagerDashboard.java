package View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import Model.LibraryModel;

public class ManagerDashboard extends JFrame {
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenu jMenu3;
    private JMenu jMenu5;
    private JMenu jMenu6;
    private JMenu jMenu7;
    private JMenu jMenu8;
    private JMenu jMenu9;
    private JMenuBar jMenuBar1;
    private JPanel jPanel1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JTextField jTextField6;
    private String username;
    LibraryModel model;
    Connection conn;

    public ManagerDashboard(String username, LibraryModel model) {
        this.model = model;
        conn = model.makeConnection();
        jPanel1 = new JPanel();
        jLabel4 = new JLabel();
        jTextField1 = new JTextField();
        jLabel5 = new JLabel();
        jTextField2 = new JTextField();
        jLabel6 = new JLabel();
        jTextField3 = new JTextField();
        jLabel7 = new JLabel();
        jTextField4 = new JTextField();
        jLabel8 = new JLabel();
        jTextField5 = new JTextField();
        jTextField6 = new JTextField();
        jLabel9 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jLabel2 = new JLabel();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenu2 = new JMenu();
        jMenu3 = new JMenu();
        jMenu4 = new JMenu();
        jMenu5 = new JMenu();
        jMenu6 = new JMenu();
        jMenu7 = new JMenu();
        jMenu8 = new JMenu();
        jMenu9 = new JMenu();
        this.username = username;
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(960, 560));
        setVisible(true);
        setTitle("Manager Dashboard");
        setResizable(false);
        jPanel1.setVisible(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("ISBN");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setText("ISBN");
        jTextField1.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("TITLE");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField2.setText("TITLE");
        jTextField2.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("AUTHOR");

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField3.setText("AUTHOR ID");
        jTextField3.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("GENERE");

        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField4.setText("GENERE ID");
        jTextField4.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("PUBLISHER");

        jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField5.setText("PUBLISHER ID");
        jTextField5.setToolTipText("");

        jTextField6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField6.setText("PUBLISHER DATE");
        jTextField6.setToolTipText("");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText(" PUBLISHER DATE");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("ADD");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addButton1();

            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("UPDATE");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateButton2();

            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setText("DELETE");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButton3();
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("BOOKS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(420, 420, 420)
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(225, 225, 225)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel9)
                                                        .addGroup(jPanel1Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel4,
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jLabel5,
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                false)
                                                        .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                202, Short.MAX_VALUE)
                                                        .addComponent(jTextField5,
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField4,
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField3,
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField2,
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField1,
                                                                javax.swing.GroupLayout.Alignment.LEADING)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(278, 278, 278)
                                                .addComponent(jButton1)
                                                .addGap(62, 62, 62)
                                                .addComponent(jButton2)
                                                .addGap(58, 58, 58)
                                                .addComponent(jButton3)))
                                .addContainerGap(332, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel2)
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(59, 59, 59)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3))
                                .addContainerGap(108, Short.MAX_VALUE)));

        jMenu1.setText("Books");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1.setVisible(true);
                jLabel2.setText("Books");
                jLabel4.setText("ISBN");
                jTextField1.setText("ISBN");
                jLabel5.setText("TITLE");
                jTextField2.setText("TITLE");
                jLabel6.setText("AUTHOR");
                jTextField3.setText("AUTHOR ID");
                jLabel7.setText("GENERE");
                jTextField4.setText("GENERE ID");
                jLabel8.setText("PUBLISHER");
                jTextField5.setText("PUBLISHER ID");
                jLabel9.setText(" PUBLISHER DATE");
                jTextField6.setText("PUBLISHER DATE(MM/DD/YYYY)");
                setTrue();
            }
        });
        jMenuBar1.add(jMenu1);

        // add books

        jMenu2.setText("Members");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1.setVisible(true);
                setTrue();
                jLabel2.setText("MEMBERS");
                jLabel4.setText("NAME");
                jTextField1.setText("NAME");
                jLabel5.setText("EMAIL");
                jTextField2.setText("EMAIL");
                jLabel6.setText("ADDRESS");
                jTextField3.setText("ADDRESS");
                jLabel7.setText("PHONE");
                jTextField4.setText("PHONE");
                jLabel8.setText("DATE JOINED");
                jTextField5.setText("DATE JOINED(MM/DD/YYYY)");
                jLabel9.setVisible(false);
                jTextField6.setVisible(false);

            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Reviews");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1.setVisible(true);
                setTrue();
                jLabel2.setText("REVIEWS");
                jLabel4.setText("REVIEW ID");
                jTextField1.setText("REVIEW ID");
                jLabel5.setVisible(false);
                jTextField2.setVisible(false);
                jLabel6.setVisible(false);
                jTextField3.setVisible(false);
                jLabel7.setVisible(false);
                jTextField4.setVisible(false);
                jLabel8.setVisible(false);
                jTextField5.setVisible(false);
                jLabel9.setVisible(false);
                jTextField6.setVisible(false);
                jButton2.setText("SEARCH");
                jButton1.setVisible(false);
                jButton3.setVisible(false);
            }
        });
        jMenuBar1.add(jMenu3);


        jMenu5.setText("Authors");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1.setVisible(true);
                setTrue();
                jLabel2.setText("AUTHORS");
                jLabel4.setText("NAME");
                jTextField1.setText("NAME");
                jLabel5.setText("BIRTH DATE");
                jTextField2.setText("BIRTH DATE");
                jLabel6.setText("NATIONALITY");
                jTextField3.setText("NATIONALITY");
                jLabel7.setVisible(false);
                jTextField4.setVisible(false);
                jLabel8.setVisible(false);
                jTextField5.setVisible(false);
                jLabel9.setVisible(false);
                jTextField6.setVisible(false);
            }
        });
        jMenuBar1.add(jMenu5);

        jMenu6.setText("Generes");
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1.setVisible(true);
                setTrue();
                jLabel2.setText("GENERES");
                jLabel4.setText("NAME");
                jTextField1.setText("NAME");
                jLabel5.setVisible(false);
                jTextField2.setVisible(false);
                jLabel6.setVisible(false);
                jTextField3.setVisible(false);
                jLabel7.setVisible(false);
                jTextField4.setVisible(false);
                jLabel8.setVisible(false);
                jTextField5.setVisible(false);
                jLabel9.setVisible(false);
                jTextField6.setVisible(false);
                jButton2.setVisible(false);
            }
        });
        jMenuBar1.add(jMenu6);

        jMenu7.setText("Publishers");
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1.setVisible(true);
                setTrue();
                jLabel2.setText("PUBLISHERS");
                jLabel4.setText("NAME");
                jTextField1.setText("NAME");
                jLabel5.setText("ADDRESS");
                jTextField2.setText("ADDRESS");
                jLabel6.setVisible(false);
                jTextField3.setVisible(false);
                jLabel7.setVisible(false);
                jTextField4.setVisible(false);
                jLabel8.setVisible(false);
                jTextField5.setVisible(false);
                jLabel9.setVisible(false);
                jTextField6.setVisible(false);
            }
        });
        jMenuBar1.add(jMenu7);

        jMenu8.setText("Employee");
        jMenu8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1.setVisible(true);
                setTrue();
                jLabel2.setText("EMPLOYEE");
                jLabel4.setText("EMPLOYEE ID");
                jTextField1.setText("EMPLOYEE ID");
                jLabel5.setText("NAME");
                jTextField2.setText("NAME");
                jLabel6.setText("POSITION");
                jTextField3.setText("POSITION");
                jLabel7.setText("MANAGER ID");
                jTextField4.setText("MANAGER ID");
                jLabel8.setText("BRANCH ID");
                jTextField5.setText("BRANCH ID");
                jLabel9.setVisible(false);
                jTextField6.setVisible(false);
            }
        });
        jMenuBar1.add(jMenu8);

        jMenu9.setText("Sign Out");
        jMenu9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	System.out.println("Signing Out!!!");
            	System.exit(0);
            }
        });
        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
        setLocationRelativeTo(null);
    }

    // add author
    private void addButton1() {
        if (jButton1.getText().equals("ADD") && jLabel2.getText().equals("AUTHORS")) {
            String authorName = jTextField1.getText();
            String nationality = jTextField3.getText();
            String birthdate_str = jTextField2.getText(); // Replace with your date string
            java.sql.Date birthdate = java.sql.Date.valueOf(birthdate_str);

            try {
                model.addAuthor(conn, authorName, birthdate, nationality);
            } catch (SQLException e) {
                System.out.println("Some issue: " + e.getMessage());
            }
        } else if (jButton1.getText().equals("ADD") && jLabel2.getText().equals("BOOKS")) {
            int book_id = Integer.parseInt(jTextField1.getText());
            String title = jTextField2.getText();
            int authorId = Integer.parseInt(jTextField3.getText()); // Replace with your date string
            java.sql.Date publishedDate = java.sql.Date.valueOf(jTextField6.getText());
            int genreId = Integer.parseInt(jTextField4.getText());
            int publisherId = Integer.parseInt(jTextField5.getText());

            try {
                model.addBook(conn, book_id, title, authorId, genreId, publisherId, publishedDate);
            } catch (SQLException e) {
                System.out.println("Some issue: " + e.getMessage());
            }
        } else if (jButton1.getText().equals("ADD") && jLabel2.getText().equals("MEMBERS")) {
            String name = jTextField1.getText();
            String email = jTextField2.getText();
            String address = jTextField3.getText();// Replace with your date string
            java.sql.Date dateJoined = java.sql.Date.valueOf(jTextField5.getText());
            String phoneNumber = jTextField4.getText();

            try {
                model.addMember(conn, name, email, address, dateJoined, phoneNumber);
            } catch (SQLException e) {
                System.out.println("Some issue: " + e.getMessage());
            }
        } else if (jButton1.getText().equals("ADD") && jLabel2.getText().equals("GENERES")) {
            String name = jTextField1.getText();
            try {
                model.addGeneres(conn, name);
            } catch (SQLException e) {
                System.out.println("Some issue: " + e.getMessage());
            }
        } else if (jButton1.getText().equals("ADD") && jLabel2.getText().equals("PUBLISHERS")) {
            String name = jTextField1.getText();
            String address = jTextField2.getText();
            try {
                model.addPublishers(conn, name, address);
            } catch (SQLException e) {
                System.out.println("Some issue: " + e.getMessage());
            }
        } else if (jButton1.getText().equals("ADD") && jLabel2.getText().equals("EMPLOYEE")) {
            String name = jTextField2.getText();
            String position = jTextField3.getText();
            int managerId = Integer.parseInt(jTextField4.getText());
            int branchId = Integer.parseInt(jTextField5.getText());

            try {
                model.addEmployee(conn, name, position, managerId, branchId);
            } catch (SQLException e) {
                System.out.println("Some issue: " + e.getMessage());
            }
        }
    }

    // updates
    private void updateButton2() {
        if (jButton2.getText().equals("UPDATE") && jLabel2.getText().equals("AUTHORS")) {
            String authorName = jTextField1.getText();
            String nationality = jTextField3.getText();
            String birthdate_str = jTextField2.getText(); // Replace with your date string
            java.sql.Date birthdate = java.sql.Date.valueOf(birthdate_str);

            try {
                model.updateAuthor(conn, authorName, birthdate, nationality);
            } catch (SQLException e) {
                System.out.println("Some issue: " + e.getMessage());
            }
        } else if (jButton2.getText().equals("UPDATE") && jLabel2.getText().equals("BOOKS")) {
            int book_id = Integer.parseInt(jTextField1.getText());
            String title = jTextField2.getText();
            int authorId = Integer.parseInt(jTextField3.getText()); // Replace with your date string
            java.sql.Date publishedDate = java.sql.Date.valueOf(jTextField6.getText());
            int genreId = Integer.parseInt(jTextField4.getText());
            int publisherId = Integer.parseInt(jTextField5.getText());

            try {
                model.updateBook(conn, book_id, title, authorId, genreId, publisherId, publishedDate);
            } catch (SQLException e) {
                System.out.println("Some issue: " + e.getMessage());
            }
        } else if (jButton2.getText().equals("UPDATE") && jLabel2.getText().equals("MEMBERS")) {
            String name = jTextField1.getText();
            String email = jTextField2.getText();
            String address = jTextField3.getText();// Replace with your date string
            java.sql.Date dateJoined = java.sql.Date.valueOf(jTextField5.getText());
            String phoneNumber = jTextField4.getText();

            try {
                int mem_id = getMemberIdByName(conn, name);

                model.updateMember(conn, mem_id, name, email, address, dateJoined, phoneNumber);
            } catch (SQLException e) {
                System.out.println("Some issue: " + e.getMessage());
            }
        } else if (jButton2.getText().equals("UPDATE") && jLabel2.getText().equals("PUBLISHERS")) {
            String name = jTextField1.getText();
            String address = jTextField2.getText();
            try {

                int pub_id = getPublisherIdByName(conn, name);
                model.updatePublishers(conn, pub_id, name, address);
            } catch (SQLException e) {
                System.out.println("Some issue: " + e.getMessage());
            }
        } else if (jButton2.getText().equals("UPDATE") && jLabel2.getText().equals("EMPLOYEE")) {
            String name = jTextField2.getText();
            String position = jTextField3.getText();
            int managerId = Integer.parseInt(jTextField4.getText());
            int branchId = Integer.parseInt(jTextField5.getText());

            try {
                model.updateEmployee(conn, name, position, managerId, branchId);
            } catch (SQLException e) {
                System.out.println("Some issue: " + e.getMessage());
            }
        } else if (jButton2.getText().equals("SEARCH") && jLabel2.getText().equals("REVIEWS")) {
            int reviewId = Integer.parseInt(jTextField1.getText());
            try {
                model.searchReviews(conn, reviewId);
            } catch (SQLException e) {
                System.out.println("Some issue: " + e.getMessage());
            }
        }
    }

    public int getMemberIdByName(Connection conn, String memberName) throws SQLException {
        int memberId = -1; // Default value indicating member not found

        String sql = "SELECT member_id FROM members WHERE member_name = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, memberName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                memberId = rs.getInt("member_id");
            }
        } catch (SQLException e) {
            System.out.println("Error fetching member ID: " + e.getMessage());
        }

        return memberId;
    }

    public int getPublisherIdByName(Connection conn, String publisherName) throws SQLException {
        int publisherId = -1; // Default value indicating publisher not found

        String sql = "SELECT publisher_id FROM publishers WHERE name = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, publisherName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                publisherId = rs.getInt("publisher_id");
            }
        } catch (SQLException e) {
            System.out.println("Error fetching publisher ID: " + e.getMessage());
        }

        return publisherId;
    }

    public void deleteButton3() {
        if (jButton3.getText().equals("DELETE") && jLabel2.getText().equals("AUTHORS")) {
            String authorName = jTextField1.getText();

            try {
                model.deleteAuthor(conn, authorName);
            } catch (SQLException e) {
                System.out.println("Some issue: " + e.getMessage());
            }
        } else if (jButton3.getText().equals("DELETE") && jLabel2.getText().equals("BOOKS")) {
            int book_id = Integer.parseInt(jTextField1.getText());

            try {
                model.deleteBook(conn, book_id);
            } catch (SQLException e) {
                System.out.println("Some issue: " + e.getMessage());
            }
        } else if (jButton3.getText().equals("DELETE") && jLabel2.getText().equals("MEMBERS")) {
            String name = jTextField1.getText();
            try {
                model.deleteMember(conn, name);
            } catch (SQLException e) {
                System.out.println("Some issue: " + e.getMessage());
            }
        } else if (jButton3.getText().equals("DELETE") && jLabel2.getText().equals("PUBLISHERS")) {
            String name = jTextField1.getText();
            try {
                model.deletePublishers(conn, name);
            } catch (SQLException e) {
                System.out.println("Some issue: " + e.getMessage());
            }
        } else if (jButton3.getText().equals("DELETE") && jLabel2.getText().equals("EMPLOYEE")) {
            String name = jTextField2.getText();

            try {
                model.deleteEmployee(conn, name);
            } catch (SQLException e) {
                System.out.println("Some issue: " + e.getMessage());
            }
        }
    }

    // delete author by author_name

    private void setTrue() {
        jLabel2.setVisible(true);
        jLabel4.setVisible(true);
        jTextField1.setVisible(true);
        jLabel5.setVisible(true);
        jTextField2.setVisible(true);
        jLabel6.setVisible(true);
        jTextField3.setVisible(true);
        jLabel7.setVisible(true);
        jTextField4.setVisible(true);
        jLabel8.setVisible(true);
        jTextField5.setVisible(true);
        jLabel9.setVisible(true);
        jTextField6.setVisible(true);
        jButton2.setText("UPDATE");
        jButton1.setVisible(true);
        jButton2.setVisible(true);
        jButton3.setVisible(true);

    }
}
