package View;

import javax.swing.*;

import Model.LibraryModel;

public class MemberDashboard extends JFrame {
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
    // LibraryModel model

    public MemberDashboard(String username) {
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
        this.username = username;
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(960, 560));
        setVisible(true);
        setTitle("Member Dashboard");
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

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("UPDATE");

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setText("DELETE");

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

        jMenu1.setText("Borrow Books");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1.setVisible(true);
                jLabel2.setText("Borrow Books");
                jLabel4.setText("Book ID");
                jTextField1.setText("Book ID");
                jLabel5.setText("MEMBER ID");
                jTextField2.setText("MEMBER ID");
                jLabel6.setText("ISSUE DATE");
                jTextField3.setText("ISSUE DATE(MM/DD/YYYY)");
                jLabel7.setText("RETURN DATE");
                jTextField4.setText("RETURN DATE(MM/DD/YYYY)");
                jLabel8.setVisible(false);
                jTextField5.setVisible(false);
                jLabel9.setVisible(false);
                jTextField6.setVisible(false);
                jButton2.setText("BORROW");
                setTrue();
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Review");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1.setVisible(true);
                setTrue();
                jLabel2.setText("REVIEW");
                jLabel4.setText("ISBN");
                jTextField1.setText("ISBN");
                jLabel5.setText("MEMBER ID");
                jTextField2.setText("MEMBER ID");
                jLabel6.setText("RATING");
                jTextField3.setText("RATING");
                jLabel7.setText("REVIEW");
                jTextField4.setText("REVIEW");
                jLabel8.setText("REVIEW DATE");
                jTextField5.setText("REVIEW DATE(MM/DD/YYYY)");
                jLabel9.setVisible(false);
                jTextField6.setVisible(false);
                jButton2.setText("SUBMIT");

            }
        });
        jMenuBar1.add(jMenu2);

        jMenu9.setText("Sign Out");
        jMenu9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	System.out.println("Signing Out!!!");
            	System.exit(0);
            }
        });
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
        jButton1.setVisible(false);
        jButton2.setVisible(true);
        jButton3.setVisible(false);

    }
}
