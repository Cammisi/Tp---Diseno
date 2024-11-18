
package InterfazGrafica;

public class RegistrarReservaEsporadica extends javax.swing.JFrame {

    private MenuBedel mBedel;
    
    public RegistrarReservaEsporadica() {
        initComponents();
    }

    public void setMenuBedel(MenuBedel mBedel){
        this.mBedel = mBedel;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        email = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        horarioInicio = new javax.swing.JLabel();
        horaInicio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        duracion = new javax.swing.JTextField();
        indicacionHora = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tipoAula = new javax.swing.JComboBox<>();
        docente = new javax.swing.JComboBox<>();
        catedra = new javax.swing.JComboBox<>();
        cantAlumnos = new javax.swing.JTextField();
        buscarAula = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        cancelar = new javax.swing.JButton();
        confirmar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU BEDEL | REGISTRAR RESERVA ESPORADICA");
        setMinimumSize(new java.awt.Dimension(830, 600));

        jPanel1.setBackground(new java.awt.Color(242, 240, 235));
        jPanel1.setMinimumSize(new java.awt.Dimension(830, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(242, 240, 235));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        email.setBackground(new java.awt.Color(242, 240, 235));
        email.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        email.setForeground(new java.awt.Color(153, 153, 153));
        email.setText("Escribe aquí...");
        email.setToolTipText("");
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailKeyPressed(evt);
            }
        });
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 265, 130, 30));

        jLabel9.setBackground(new java.awt.Color(242, 240, 235));
        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("NOMBRE DE CATEDRA: (*)");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, -1, -1));

        jPanel3.setBackground(new java.awt.Color(242, 240, 235));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("DIA QUE SE DICTA (*): ");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 14, 201, -1));

        horarioInicio.setBackground(new java.awt.Color(242, 240, 235));
        horarioInicio.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        horarioInicio.setForeground(new java.awt.Color(0, 0, 0));
        horarioInicio.setText("HORARIO DE INICIO:(*)");
        jPanel3.add(horarioInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        horaInicio.setBackground(new java.awt.Color(242, 240, 235));
        horaInicio.setForeground(new java.awt.Color(153, 153, 153));
        horaInicio.setText("HH:MM");
        horaInicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        horaInicio.setCaretColor(new java.awt.Color(242, 240, 235));
        horaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horaInicioActionPerformed(evt);
            }
        });
        horaInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                horaInicioKeyPressed(evt);
            }
        });
        jPanel3.add(horaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 80, 20));

        jLabel8.setBackground(new java.awt.Color(242, 240, 235));
        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("DURACION:(*)");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, -1, -1));

        duracion.setBackground(new java.awt.Color(242, 240, 235));
        duracion.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        duracion.setForeground(new java.awt.Color(153, 153, 153));
        duracion.setText("Escribe aquí...");
        duracion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        duracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duracionActionPerformed(evt);
            }
        });
        duracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                duracionKeyPressed(evt);
            }
        });
        jPanel3.add(duracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 130, 20));

        indicacionHora.setBackground(new java.awt.Color(242, 240, 235));
        indicacionHora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exclamacion (2).png"))); // NOI18N
        indicacionHora.setToolTipText("<html>\n<head>\n<style> \n.infoContraseña{backgorund:white;color:black;}\n</style>\n<body>\n<h4 class=\"infoContraseña\">LA HORA INGRESADA DEBE CUMPLIR CON EL FORMATE HH:MM </h4>\n</body>\n</html>\n\n\n\n");
        indicacionHora.setBorder(null);
        indicacionHora.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                indicacionHoraMouseMoved(evt);
            }
        });
        indicacionHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indicacionHoraActionPerformed(evt);
            }
        });
        jPanel3.add(indicacionHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 95, 40, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 790, 130));

        jLabel11.setBackground(new java.awt.Color(242, 240, 235));
        jLabel11.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("CANTIDAD DE ALUMNOS: (*)");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel12.setBackground(new java.awt.Color(242, 240, 235));
        jLabel12.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("DOCENTE: (*)");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel13.setBackground(new java.awt.Color(242, 240, 235));
        jLabel13.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("E-MAIL: (*)");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jLabel14.setBackground(new java.awt.Color(242, 240, 235));
        jLabel14.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("TIPO DE AULA: (*)");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, -1, -1));

        tipoAula.setBackground(new java.awt.Color(242, 240, 235));
        tipoAula.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        tipoAula.setForeground(new java.awt.Color(153, 153, 153));
        tipoAula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "MULTIMEDIA", "INFORMATICA", "SIN RECURSOS" }));
        tipoAula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        tipoAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoAulaActionPerformed(evt);
            }
        });
        jPanel2.add(tipoAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 205, 130, 30));

        docente.setBackground(new java.awt.Color(242, 240, 235));
        docente.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        docente.setForeground(new java.awt.Color(153, 153, 153));
        docente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", " " }));
        docente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        docente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docenteActionPerformed(evt);
            }
        });
        jPanel2.add(docente, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 205, 130, 30));

        catedra.setBackground(new java.awt.Color(242, 240, 235));
        catedra.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        catedra.setForeground(new java.awt.Color(153, 153, 153));
        catedra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", " " }));
        catedra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        catedra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catedraActionPerformed(evt);
            }
        });
        jPanel2.add(catedra, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 145, 130, 30));

        cantAlumnos.setBackground(new java.awt.Color(242, 240, 235));
        cantAlumnos.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        cantAlumnos.setForeground(new java.awt.Color(153, 153, 153));
        cantAlumnos.setText("Escribe aquí...");
        cantAlumnos.setToolTipText("");
        cantAlumnos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cantAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantAlumnosActionPerformed(evt);
            }
        });
        cantAlumnos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cantAlumnosKeyPressed(evt);
            }
        });
        jPanel2.add(cantAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 145, 130, 30));

        buscarAula.setBackground(new java.awt.Color(242, 240, 235));
        buscarAula.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        buscarAula.setForeground(new java.awt.Color(0, 0, 0));
        buscarAula.setText("BUSCAR AULA");
        buscarAula.setAlignmentY(0.0F);
        buscarAula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        buscarAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarAulaActionPerformed(evt);
            }
        });
        jPanel2.add(buscarAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 480, 140, 30));

        jPanel4.setBackground(new java.awt.Color(242, 240, 235));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 530, 120));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 810, 520));

        cancelar.setBackground(new java.awt.Color(242, 240, 235));
        cancelar.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cancelar.setForeground(new java.awt.Color(0, 0, 0));
        cancelar.setText("CANCELAR");
        cancelar.setAlignmentY(0.0F);
        cancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 550, 130, 30));

        confirmar1.setBackground(new java.awt.Color(242, 240, 235));
        confirmar1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        confirmar1.setForeground(new java.awt.Color(0, 0, 0));
        confirmar1.setText("CONFIRMAR");
        confirmar1.setAlignmentY(0.0F);
        confirmar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        confirmar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmar1ActionPerformed(evt);
            }
        });
        jPanel1.add(confirmar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 550, 130, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyPressed
        if(email.getText().equals("Escribe aquí...")){
            email.setText("");
        }
    }//GEN-LAST:event_emailKeyPressed

    private void horaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horaInicioActionPerformed

    private void horaInicioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_horaInicioKeyPressed
        if(horaInicio.getText().equals("HH:MM")){
            horaInicio.setText("");
        }
    }//GEN-LAST:event_horaInicioKeyPressed

    private void duracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duracionActionPerformed

    private void duracionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_duracionKeyPressed
        if(duracion.getText().equals("Escribe aquí...")){
            duracion.setText("");
        }
    }//GEN-LAST:event_duracionKeyPressed

    private void tipoAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoAulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoAulaActionPerformed

    private void docenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_docenteActionPerformed

    private void catedraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catedraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_catedraActionPerformed

    private void cantAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantAlumnosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantAlumnosActionPerformed

    private void cantAlumnosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantAlumnosKeyPressed
        if(cantAlumnos.getText().equals("Escribe aquí...")){
            cantAlumnos.setText("");
        }
    }//GEN-LAST:event_cantAlumnosKeyPressed

    private void buscarAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarAulaActionPerformed
        ProgresoPopup popup = new ProgresoPopup(this);
        popup.iniciarSimulacion(); 
        popup.setVisible(true); 
        
        AulasDisponibles aDisponibles = new AulasDisponibles();
        aDisponibles.setRegistrarReservaEsporadica(this);
        aDisponibles.setVisible(true);
        aDisponibles.setLocationRelativeTo(null);
        aDisponibles.setResizable(false);
        this.setVisible(false);
    }//GEN-LAST:event_buscarAulaActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        mBedel.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void confirmar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmar1ActionPerformed

    private void indicacionHoraMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_indicacionHoraMouseMoved
        //infoContraseña.createToolTip();
        //infoContraseña.setToolTipText("LA CONTRASEÑA DEBE CONTENER AL MENOS 8 CARACTERES, ENTRE ELLOS AL MENOS UNA MAYUSCULA Y UN NUMERO");
    }//GEN-LAST:event_indicacionHoraMouseMoved

    private void indicacionHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indicacionHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_indicacionHoraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarAula;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField cantAlumnos;
    private javax.swing.JComboBox<String> catedra;
    private javax.swing.JButton confirmar1;
    private javax.swing.JComboBox<String> docente;
    private javax.swing.JTextField duracion;
    private javax.swing.JTextField email;
    private javax.swing.JTextField horaInicio;
    private javax.swing.JLabel horarioInicio;
    private javax.swing.JButton indicacionHora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JComboBox<String> tipoAula;
    // End of variables declaration//GEN-END:variables
}
