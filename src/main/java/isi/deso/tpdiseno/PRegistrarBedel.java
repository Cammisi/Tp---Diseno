
package isi.deso.tpdiseno;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class PRegistrarBedel extends javax.swing.JFrame {

    GestorBedel gestorBedel;
    
    
    
    
    public PRegistrarBedel() {
        initComponents();
        //vacio0.setVisible(false);
        //longitud0.setVisible(false);
        //notDigit0.setVisible(false);
        //notDigit00.setVisible(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        turno = new javax.swing.JComboBox<>();
        usuario = new javax.swing.JTextField();
        apellido = new javax.swing.JTextField();
        cancelar = new javax.swing.JButton();
        confirmar = new javax.swing.JButton();
        infoUsuario = new javax.swing.JButton();
        infoContraseña = new javax.swing.JButton();
        confirmarContraseña = new javax.swing.JPasswordField();
        contraseña = new javax.swing.JPasswordField();
        nombre1 = new javax.swing.JTextField();
        vacio1 = new javax.swing.JLabel();
        vacio0 = new javax.swing.JLabel();
        vacio5 = new javax.swing.JLabel();
        vacio2 = new javax.swing.JLabel();
        vacio3 = new javax.swing.JLabel();
        vacio4 = new javax.swing.JLabel();
        longitud5 = new javax.swing.JLabel();
        longitud0 = new javax.swing.JLabel();
        longitud1 = new javax.swing.JLabel();
        validarUsuario = new javax.swing.JLabel();
        notDigit1 = new javax.swing.JLabel();
        notDigit0 = new javax.swing.JLabel();
        notDigit00 = new javax.swing.JLabel();
        notDigit11 = new javax.swing.JLabel();
        contraseñaLabel = new javax.swing.JLabel();
        confirmarContrasena = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU ADMINISTRADOR | REGISTRAR BEDEL");

        Panel1.setBackground(new java.awt.Color(242, 240, 235));
        Panel1.setPreferredSize(new java.awt.Dimension(830, 600));
        Panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(242, 240, 235));
        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("APELLIDO: (*)");
        Panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 105, -1, -1));

        jLabel2.setBackground(new java.awt.Color(242, 240, 235));
        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("CONTRASEÑA: (*)");
        Panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, -1, -1));

        jLabel3.setBackground(new java.awt.Color(242, 240, 235));
        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("NOMBRE: (*)");
        Panel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 105, -1, -1));

        jLabel4.setBackground(new java.awt.Color(242, 240, 235));
        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("CONFIRMAR ");
        Panel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, -1, 30));

        jLabel7.setBackground(new java.awt.Color(242, 240, 235));
        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("TURNO: (*)");
        Panel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jLabel8.setBackground(new java.awt.Color(242, 240, 235));
        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("USUARIO: (*)");
        Panel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, -1, -1));

        jLabel9.setBackground(new java.awt.Color(242, 240, 235));
        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("CONTRASEÑA: (*)");
        Panel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 335, -1, 30));

        turno.setBackground(new java.awt.Color(242, 240, 235));
        turno.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        turno.setForeground(new java.awt.Color(153, 153, 153));
        turno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Mañana", "Tarde", "Noche" }));
        turno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        turno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                turnoMouseClicked(evt);
            }
        });
        turno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turnoActionPerformed(evt);
            }
        });
        Panel1.add(turno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 225, 150, 30));

        usuario.setBackground(new java.awt.Color(242, 240, 235));
        usuario.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        usuario.setForeground(new java.awt.Color(153, 153, 153));
        usuario.setText("Escribe aquí...");
        usuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usuarioKeyPressed(evt);
            }
        });
        Panel1.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 225, 150, 30));

        apellido.setBackground(new java.awt.Color(242, 240, 235));
        apellido.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        apellido.setForeground(new java.awt.Color(153, 153, 153));
        apellido.setText("Escribe aquí...");
        apellido.setToolTipText("");
        apellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoActionPerformed(evt);
            }
        });
        apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                apellidoKeyPressed(evt);
            }
        });
        Panel1.add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 150, 30));

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
        Panel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 515, 130, 30));

        confirmar.setBackground(new java.awt.Color(242, 240, 235));
        confirmar.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        confirmar.setForeground(new java.awt.Color(0, 0, 0));
        confirmar.setText("CONFIRMAR");
        confirmar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });
        Panel1.add(confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 515, 130, 30));

        infoUsuario.setBackground(new java.awt.Color(242, 240, 235));
        infoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exclamacion (2).png"))); // NOI18N
        infoUsuario.setToolTipText("<html>\n<head>\n<style> \n.infoUsuario{backgorund:white;color:black;}\n</style>\n<body>\n<h4 class=\"infoUsuario\">DEBE CONTENER ENTRE 4 Y 20 CARACTERES (SIN ESPACIOS) CON AL MENOS UN NUMERO Y UNA LETRA</h4>\n</body>\n</html>");
        infoUsuario.setBorder(null);
        Panel1.add(infoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 225, -1, -1));

        infoContraseña.setBackground(new java.awt.Color(242, 240, 235));
        infoContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exclamacion (2).png"))); // NOI18N
        infoContraseña.setToolTipText("<html>\n<head>\n<style> \n.infoContraseña{backgorund:white;color:black;}\n</style>\n<body>\n<h4 class=\"infoContraseña\">DEBE CONTENER ENTRE 8 Y 30 CARACTERES, ENTRE ELLOS AL MENOS UNA MAYUSCULA Y UN NUMERO </h4>\n</body>\n</html>\n\n\n\n");
        infoContraseña.setBorder(null);
        infoContraseña.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                infoContraseñaMouseMoved(evt);
            }
        });
        infoContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoContraseñaActionPerformed(evt);
            }
        });
        Panel1.add(infoContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 40, 40));

        confirmarContraseña.setBackground(new java.awt.Color(242, 240, 235));
        confirmarContraseña.setForeground(new java.awt.Color(153, 153, 153));
        confirmarContraseña.setText("Escribe aquí...");
        confirmarContraseña.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        confirmarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarContraseñaActionPerformed(evt);
            }
        });
        confirmarContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                confirmarContraseñaKeyPressed(evt);
            }
        });
        Panel1.add(confirmarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 335, 150, 30));

        contraseña.setBackground(new java.awt.Color(242, 240, 235));
        contraseña.setForeground(new java.awt.Color(153, 153, 153));
        contraseña.setText("Escribe aquí...");
        contraseña.setToolTipText("");
        contraseña.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseñaActionPerformed(evt);
            }
        });
        contraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contraseñaKeyPressed(evt);
            }
        });
        Panel1.add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 335, 150, 30));

        nombre1.setBackground(new java.awt.Color(242, 240, 235));
        nombre1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        nombre1.setForeground(new java.awt.Color(153, 153, 153));
        nombre1.setText("Escribe aquí...");
        nombre1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        nombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre1ActionPerformed(evt);
            }
        });
        nombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombre1KeyPressed(evt);
            }
        });
        Panel1.add(nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 150, 30));

        vacio1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vacio1.setForeground(new java.awt.Color(255, 0, 0));
        vacio1.setToolTipText("");
        Panel1.add(vacio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 135, 200, 20));

        vacio0.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vacio0.setForeground(new java.awt.Color(255, 0, 0));
        vacio0.setToolTipText("");
        Panel1.add(vacio0, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 135, 200, 20));

        vacio5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vacio5.setForeground(new java.awt.Color(255, 0, 0));
        vacio5.setToolTipText("");
        Panel1.add(vacio5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, 200, 20));

        vacio2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vacio2.setForeground(new java.awt.Color(255, 0, 0));
        vacio2.setToolTipText("");
        Panel1.add(vacio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 200, 20));

        vacio3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vacio3.setForeground(new java.awt.Color(255, 0, 0));
        vacio3.setToolTipText("");
        Panel1.add(vacio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, 200, 20));

        vacio4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vacio4.setForeground(new java.awt.Color(255, 0, 0));
        vacio4.setToolTipText("");
        Panel1.add(vacio4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 200, 20));

        longitud5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        longitud5.setForeground(new java.awt.Color(255, 0, 0));
        Panel1.add(longitud5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, 230, 20));

        longitud0.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        longitud0.setForeground(new java.awt.Color(255, 0, 0));
        Panel1.add(longitud0, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 135, 230, 20));

        longitud1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        longitud1.setForeground(new java.awt.Color(255, 0, 0));
        Panel1.add(longitud1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 135, 230, 20));

        validarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        validarUsuario.setForeground(new java.awt.Color(255, 0, 0));
        Panel1.add(validarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, 230, 20));

        notDigit1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        notDigit1.setForeground(new java.awt.Color(255, 0, 0));
        Panel1.add(notDigit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, 210, 20));

        notDigit0.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        notDigit0.setForeground(new java.awt.Color(255, 0, 0));
        Panel1.add(notDigit0, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 200, 20));

        notDigit00.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        notDigit00.setForeground(new java.awt.Color(255, 0, 0));
        Panel1.add(notDigit00, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 155, 200, 20));

        notDigit11.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        notDigit11.setForeground(new java.awt.Color(255, 0, 0));
        Panel1.add(notDigit11, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 155, 200, 20));

        contraseñaLabel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        contraseñaLabel.setForeground(new java.awt.Color(255, 0, 0));
        Panel1.add(contraseñaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 300, 20));

        confirmarContrasena.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        confirmarContrasena.setForeground(new java.awt.Color(255, 0, 0));
        Panel1.add(confirmarContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, 200, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void turnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_turnoActionPerformed

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioActionPerformed

    private void apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cancelarActionPerformed

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        
        this.limpiarLabels();
        boolean limiteApellido = false;
        boolean limiteNombre = false;
        boolean vacioApellido= false;
        boolean vacioNombre=false;
        boolean vacioUsuario=false;
        boolean vacioContraseña=false;
        boolean vacioConfirmar=false;
        boolean validarDatos=true;
        boolean validarGeneral=false;
        gestorBedel = new GestorBedel();
        ArrayList<String> datos = new ArrayList();
        datos.add(apellido.getText());
        datos.add(nombre1.getText());
        datos.add((String)turno.getSelectedItem());
        datos.add(usuario.getText());
        datos.add(contraseña.getText());
        datos.add(confirmarContraseña.getText());
        
        
        for(int i=0;i<6;i++){
            if(!(gestorBedel.validarVacio(datos.get(i)))){ 
                validarDatos=false;
                switch(i){
                    case 0:
                        vacioApellido=true;
                        vacio0.setText("ESTE CAMPO ES OBLIGATORIO");
                        break;
                    case 1:
                        vacioNombre=true;
                        vacio1.setText("ESTE CAMPO ES OBLIGATORIO");
                        break;
                    case 2:
                        vacio2.setText("ESTE CAMPO ES OBLIGATORIO");
                        break;
                    case 3:
                        vacioUsuario=true;
                        vacio3.setText("ESTE CAMPO ES OBLIGATORIO");
                        break;
                    case 4:
                        vacioContraseña=true;
                        vacio4.setText("ESTE CAMPO ES OBLIGATORIO");
                        break;
                    case 5:
                        vacioConfirmar=true;
                        vacio5.setText("ESTE CAMPO ES OBLIGATORIO");
                        break;
                    }       
            }else{
                if(!(gestorBedel.validarLongitud(datos.get(i),i))){ 
                    validarDatos=false;
                switch(i){
                    case 0:
                        longitud0.setText("EXCEDISTE EL LIMITE DE CARACTERES (100)");
                        limiteApellido = true;
                        break;
                    case 1:
                        longitud1.setText("EXCEDISTE EL LIMITE DE CARACTERES (100)");
                        limiteNombre = true;
                        break;     
                }
            }
        }
}
        if(!vacioApellido){
            if(!gestorBedel.validarNotDigit(apellido.getText())){
                validarDatos=false;
                if(limiteApellido){
                   notDigit00.setText("SOLO SE PUEDEN INGRESAR LETRAS");
                }else{ 
                  notDigit0.setText("SOLO SE PUEDEN INGRESAR LETRAS");
                }
            }
        }
        
        if(!vacioNombre){
            if(!gestorBedel.validarNotDigit(nombre1.getText())){
                validarDatos=false;
                if(limiteNombre){
                    notDigit11.setText("SOLO SE PUEDEN INGRESAR LETRAS");
                }else{ 
                  notDigit1.setText("SOLO SE PUEDEN INGRESAR LETRAS");
                }
             }
        }
        
        if(!vacioContraseña){
            if(!gestorBedel.validarContrasena(contraseña.getText())){
                validarDatos=false;
                contraseñaLabel.setText("NO CUMPLE CON EL CRITERIO");
                vacio5.setText("");
            }else if(!vacioConfirmar){
                if(!gestorBedel.validarConfirmarContrasena(contraseña.getText(), confirmarContraseña.getText())){
                    validarDatos=false;
                     confirmarContrasena.setText("LA CONTRASEÑA NO COINCIDE");
                }
            }      
        }
        
        if(!(gestorBedel.validarCampoUsuario(usuario.getText())) && !vacioUsuario){
            validarDatos=false;
            validarUsuario.setText("NO CUMPLE CON EL CRITERIO");
        }
        
        if(validarDatos){
            try {
                validarGeneral = gestorBedel.validarUsuario(usuario.getText());
            } catch (SQLException ex) {
                Logger.getLogger(PRegistrarBedel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PRegistrarBedel.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            if(validarGeneral){
                String turnoS=(String)turno.getSelectedItem();
                gestorBedel.crearBedel(nombre1.getText(), apellido.getText(),turnoS,usuario.getText(), contraseña.getText());
                mensajeExito();
                limpiarDatosBedel();
                limpiarLabels();
            }else{
                mensajeFracaso();
            }
        }  
    }//GEN-LAST:event_confirmarActionPerformed

    private void apellidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidoKeyPressed
        if(apellido.getText().equals("Escribe aquí...")){
            apellido.setText("");
        }
    }//GEN-LAST:event_apellidoKeyPressed

    private void usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioKeyPressed
        if(usuario.getText().equals("Escribe aquí...")){
            usuario.setText("");
        }
    }//GEN-LAST:event_usuarioKeyPressed

    private void turnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_turnoMouseClicked
       // turno.removeItem("Seleccionar");
    }//GEN-LAST:event_turnoMouseClicked

    private void contraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contraseñaKeyPressed
        if(contraseña.getText().equals("Escribe aquí...")){
            contraseña.setText("");
        }
    }//GEN-LAST:event_contraseñaKeyPressed

    private void confirmarContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmarContraseñaKeyPressed
        if(confirmarContraseña.getText().equals("Escribe aquí...")){
            confirmarContraseña.setText("");
        }
    }//GEN-LAST:event_confirmarContraseñaKeyPressed

    private void confirmarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmarContraseñaActionPerformed

    private void contraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraseñaActionPerformed

    private void infoContraseñaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoContraseñaMouseMoved
      //infoContraseña.createToolTip();
        //infoContraseña.setToolTipText("LA CONTRASEÑA DEBE CONTENER AL MENOS 8 CARACTERES, ENTRE ELLOS AL MENOS UNA MAYUSCULA Y UN NUMERO");
    }//GEN-LAST:event_infoContraseñaMouseMoved

    private void infoContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_infoContraseñaActionPerformed

    private void nombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre1ActionPerformed

    private void nombre1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre1KeyPressed
        if(nombre1.getText().equals("Escribe aquí...")){
            nombre1.setText("");
        }
    }//GEN-LAST:event_nombre1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PRegistrarBedel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PRegistrarBedel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PRegistrarBedel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PRegistrarBedel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PRegistrarBedel().setVisible(true);
            }
        });
    }
    
    public void mensajeExito(){
        UIManager.put("OptionPane.background", new Color(242,240,235));
        //UIManager.put("Panel.background", new Color(242,240,235));
        UIManager.put("OptionPane.messageFont", new Font("Bahnschirift",Font.BOLD,14));
        JOptionPane.showMessageDialog(null, "SE REGISTRO EL BEDEL CORRECTAMENTE.","",
                JOptionPane.PLAIN_MESSAGE, getIcon("/aceptar.png",32,32));
    }
    
    public void mensajeFracaso(){
        UIManager.put("OptionPane.background", new Color(242,240,235));
        //UIManager.put("Panel.background", new Color(242,240,235));
        UIManager.put("OptionPane.messageFont", new Font("Bahnschirift",Font.BOLD,14));
        JOptionPane.showMessageDialog(null, "NO SE PUDO REGISTRAR EL BEDEL.","¡ALGO SALIO MAL!",
                JOptionPane.PLAIN_MESSAGE, getIcon("/cancelar.png",32,32));
    }
    
    public void limpiarDatosBedel(){
        apellido.setText("Escribe aquí...");
        nombre1.setText("Escribe aquí...");
        contraseña.setText("Escribe aquí...");
        confirmarContraseña.setText("Escribe aquí...");
        usuario.setText("Escribe aquí...");
        turno.setSelectedItem("Seleccionar");
       //turno.setSelectedIndex(0);
    }
    
    public void limpiarLabels(){
        vacio0.setText("");
        vacio1.setText("");
        vacio2.setText("");
        vacio3.setText("");
        vacio4.setText("");
        vacio5.setText("");
        longitud0.setText("");
        longitud1.setText("");
        validarUsuario.setText("");
        longitud5.setText("");
        notDigit00.setText("");
        notDigit0.setText("");
        notDigit11.setText("");
        notDigit1.setText("");
        contraseñaLabel.setText("");
        confirmarContrasena.setText("");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel1;
    private javax.swing.JTextField apellido;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton confirmar;
    private javax.swing.JLabel confirmarContrasena;
    private javax.swing.JPasswordField confirmarContraseña;
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JLabel contraseñaLabel;
    private javax.swing.JButton infoContraseña;
    private javax.swing.JButton infoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel longitud0;
    private javax.swing.JLabel longitud1;
    private javax.swing.JLabel longitud5;
    private javax.swing.JTextField nombre1;
    private javax.swing.JLabel notDigit0;
    private javax.swing.JLabel notDigit00;
    private javax.swing.JLabel notDigit1;
    private javax.swing.JLabel notDigit11;
    private javax.swing.JComboBox<String> turno;
    private javax.swing.JTextField usuario;
    private javax.swing.JLabel vacio0;
    private javax.swing.JLabel vacio1;
    private javax.swing.JLabel vacio2;
    private javax.swing.JLabel vacio3;
    private javax.swing.JLabel vacio4;
    private javax.swing.JLabel vacio5;
    private javax.swing.JLabel validarUsuario;
    // End of variables declaration//GEN-END:variables

    private Icon getIcon(String ruta, int w, int h) {
        return new ImageIcon(new ImageIcon(getClass().getResource(ruta))
                .getImage().getScaledInstance(w, h, 0));
    }
}
