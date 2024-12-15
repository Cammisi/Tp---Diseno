
package InterfazGrafica;

import Clases.AulaMultimedios;
import Gestores.GestorAula;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class ModificarMultimedios extends javax.swing.JFrame {
    
    private MenuBedel mBedel;
    private GestorAula gAula;
    private AulaMultimedios datosAulaM;
    
    public ModificarMultimedios() {
        initComponents();
    }

    public ModificarMultimedios(MenuBedel mBedel1,String numero){
        initComponents();
        
        
        mBedel = mBedel1;
        gAula = new GestorAula();
        datosAulaM = gAula.buscarMultimedios(numero);
        
        String nu = String.valueOf(datosAulaM.getNumero());
        numeroAula.setText(nu);
        
        String pi = String.valueOf(datosAulaM.getPiso());
        piso.setText(pi);
        
        int cap = datosAulaM.getCapacidad();
        capacidad.setValue(cap);
        
        if(datosAulaM.isComputadora()){computadora.setSelectedItem("SI");}
        else{computadora.setSelectedItem("NO");}
        
        if(datosAulaM.isVentiladores()){ventiladores.setSelectedItem("SI");}
        else{ventiladores.setSelectedItem("NO");}
        
        pizarron.setSelectedItem(datosAulaM.getTipoDePizarron());
                
        if(datosAulaM.isCanon()){canon.setSelectedItem("SI");}
        else{canon.setSelectedItem("NO");}
        
        if(datosAulaM.isAireAcondicionado()){aire.setSelectedItem("SI");}
        else{aire.setSelectedItem("NO");}
        
        if(datosAulaM.isTelevisor()){televisor.setSelectedItem("SI");}
        else{televisor.setSelectedItem("NO");}
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        numeroAula = new javax.swing.JTextField();
        piso = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        capacidad = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        pizarron = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        canon = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        computadora = new javax.swing.JComboBox<>();
        confirmar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        televisor = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        aire = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        ventiladores = new javax.swing.JComboBox<>();
        capacidad0 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(830, 600));
        setMinimumSize(new java.awt.Dimension(830, 600));

        jPanel1.setBackground(new java.awt.Color(242, 240, 235));
        jPanel1.setMaximumSize(new java.awt.Dimension(830, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(830, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(830, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(242, 240, 235));
        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("NÚMERO DE AULA: (*)");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 75, -1, -1));

        jLabel6.setBackground(new java.awt.Color(242, 240, 235));
        jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("PISO: (*)");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 175, -1, -1));

        numeroAula.setEditable(false);
        numeroAula.setBackground(new java.awt.Color(242, 240, 235));
        numeroAula.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        numeroAula.setForeground(new java.awt.Color(153, 153, 153));
        numeroAula.setText("Escribe aquí...");
        numeroAula.setToolTipText("");
        numeroAula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        numeroAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroAulaActionPerformed(evt);
            }
        });
        numeroAula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                numeroAulaKeyPressed(evt);
            }
        });
        jPanel1.add(numeroAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 150, 30));

        piso.setEditable(false);
        piso.setBackground(new java.awt.Color(242, 240, 235));
        piso.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        piso.setForeground(new java.awt.Color(153, 153, 153));
        piso.setText("Escribe aquí...");
        piso.setToolTipText("");
        piso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        piso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pisoActionPerformed(evt);
            }
        });
        piso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pisoKeyPressed(evt);
            }
        });
        jPanel1.add(piso, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 150, 30));

        jLabel4.setBackground(new java.awt.Color(242, 240, 235));
        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("CAPACIDAD: (*)");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));
        jPanel1.add(capacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 275, 150, 30));

        jLabel2.setBackground(new java.awt.Color(242, 240, 235));
        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("TIPO DE PIZARRON: (*)");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 75, -1, -1));

        pizarron.setBackground(new java.awt.Color(242, 240, 235));
        pizarron.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        pizarron.setForeground(new java.awt.Color(153, 153, 153));
        pizarron.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "bueno", "Tinta", "Tiza" }));
        pizarron.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        pizarron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pizarronActionPerformed(evt);
            }
        });
        jPanel1.add(pizarron, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 150, 30));

        jLabel7.setBackground(new java.awt.Color(242, 240, 235));
        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("CAÑON: (*)");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 175, -1, 30));

        canon.setBackground(new java.awt.Color(242, 240, 235));
        canon.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        canon.setForeground(new java.awt.Color(153, 153, 153));
        canon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        canon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        canon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canonActionPerformed(evt);
            }
        });
        jPanel1.add(canon, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, 150, 30));

        jLabel1.setBackground(new java.awt.Color(242, 240, 235));
        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("COMPUTADORA: (*)");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 385, -1, -1));

        jLabel3.setBackground(new java.awt.Color(242, 240, 235));
        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("TELEVISOR: (*)");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 385, -1, -1));

        computadora.setBackground(new java.awt.Color(242, 240, 235));
        computadora.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        computadora.setForeground(new java.awt.Color(153, 153, 153));
        computadora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        computadora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        computadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                computadoraActionPerformed(evt);
            }
        });
        jPanel1.add(computadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 150, 30));

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
        jPanel1.add(confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 515, 130, 30));

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
        jPanel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 515, 130, 30));

        televisor.setBackground(new java.awt.Color(242, 240, 235));
        televisor.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        televisor.setForeground(new java.awt.Color(153, 153, 153));
        televisor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        televisor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        televisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                televisorActionPerformed(evt);
            }
        });
        jPanel1.add(televisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 380, 150, 30));

        jLabel8.setBackground(new java.awt.Color(242, 240, 235));
        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("AIRE ACONDICIONADO: (*)");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, -1, -1));

        aire.setBackground(new java.awt.Color(242, 240, 235));
        aire.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        aire.setForeground(new java.awt.Color(153, 153, 153));
        aire.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        aire.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        aire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aireActionPerformed(evt);
            }
        });
        jPanel1.add(aire, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 275, 150, 30));

        jLabel9.setBackground(new java.awt.Color(242, 240, 235));
        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("VENTILADORES: (*)");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, -1));

        ventiladores.setBackground(new java.awt.Color(242, 240, 235));
        ventiladores.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        ventiladores.setForeground(new java.awt.Color(153, 153, 153));
        ventiladores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        ventiladores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ventiladores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventiladoresActionPerformed(evt);
            }
        });
        jPanel1.add(ventiladores, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 465, 150, 30));

        capacidad0.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        capacidad0.setForeground(new java.awt.Color(255, 0, 0));
        capacidad0.setToolTipText("");
        jPanel1.add(capacidad0, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 200, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void numeroAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroAulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroAulaActionPerformed

    private void numeroAulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroAulaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroAulaKeyPressed

    private void pisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pisoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pisoActionPerformed

    private void pisoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pisoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_pisoKeyPressed

    private void pizarronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pizarronActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pizarronActionPerformed

    private void canonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_canonActionPerformed

    private void computadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_computadoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_computadoraActionPerformed

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        int capacidad1 = (int)capacidad.getValue();
        capacidad0.setText("");
        if(capacidad1==0){
            capacidad0.setText("LA CAPACIDAD DEBE SER MAYOR A 0");
        }else{ 
            //int numero1 = Integer.parseInt(numeroAula.getText());
            int capacidad2 = (int)capacidad.getValue();
            String compu = (String)computadora.getSelectedItem();
            String venti = (String)ventiladores.getSelectedItem();
            String pizarra = (String)pizarron.getSelectedItem();
            String canon1 = (String)canon.getSelectedItem();
            String aireAcond = (String)aire.getSelectedItem();
            String tele = (String)televisor.getSelectedItem();

            try{
                gAula.modificarMultimedios(capacidad2,compu,venti,pizarra,canon1,aireAcond,tele,datosAulaM);
                mensajeExito();
                
                BuscarAula bAula = new BuscarAula();
                bAula.setMenuBedel(mBedel);
                bAula.setVisible(true);
                bAula.setLocationRelativeTo(null);
                bAula.setResizable(false);
                this.setVisible(false);
                
            }catch (SQLException ex) {
                mensajeFracaso();   
            } catch (ClassNotFoundException ex) {
                mensajeFracaso();
            } 
        }
    }//GEN-LAST:event_confirmarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        if(mensajeAdvertencia()==1){
            BuscarAula bAula = new BuscarAula();
            bAula.setMenuBedel(mBedel);
            bAula.setVisible(true);
            bAula.setLocationRelativeTo(null);
            bAula.setResizable(false);
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_cancelarActionPerformed

    private void televisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_televisorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_televisorActionPerformed

    private void aireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aireActionPerformed

    private void ventiladoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventiladoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ventiladoresActionPerformed

    public void mensajeExito(){
        UIManager.put("OptionPane.background", new Color(242,240,235));
        //UIManager.put("Panel.background", new Color(242,240,235));
        UIManager.put("OptionPane.messageFont", new Font("Bahnschirift",Font.BOLD,14));
        JOptionPane.showMessageDialog(null, "SE MODIFICO EL AULA CORRECTAMENTE.","",
            JOptionPane.PLAIN_MESSAGE, getIcon("/aceptar.png",32,32));
    }
    
    public void mensajeFracaso(){
        UIManager.put("OptionPane.background", new Color(242,240,235));
        //UIManager.put("Panel.background", new Color(242,240,235));
        UIManager.put("OptionPane.messageFont", new Font("Bahnschirift",Font.BOLD,14));
        JOptionPane.showMessageDialog(null, "NO SE PUDO MODIFICAR EL AULA.","¡ALGO SALIO MAL!",
                JOptionPane.PLAIN_MESSAGE, getIcon("/cancelar.png",32,32));
    }
    
    public int mensajeAdvertencia(){
        Object[] opciones = {"NO","SI"};
        UIManager.put("OptionPane.background", new Color(242,240,235));
        UIManager.put("OptionPane.messageFont", new Font("Bahnschirift",Font.BOLD,14));
        int seleccion = JOptionPane.showOptionDialog(null, "ESTAS SEGURO DE CANCELAR LA MODIFICACION?","ADVERTENCIA",JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, getIcon("/warning.png",32,32),opciones,opciones[1]);
        return seleccion;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> aire;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> canon;
    private javax.swing.JSpinner capacidad;
    private javax.swing.JLabel capacidad0;
    private javax.swing.JComboBox<String> computadora;
    private javax.swing.JButton confirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField numeroAula;
    private javax.swing.JTextField piso;
    private javax.swing.JComboBox<String> pizarron;
    private javax.swing.JComboBox<String> televisor;
    private javax.swing.JComboBox<String> ventiladores;
    // End of variables declaration//GEN-END:variables

    private Icon getIcon(String ruta, int w, int h) {
        return new ImageIcon(new ImageIcon(getClass().getResource(ruta))
                .getImage().getScaledInstance(w, h, 0));
    }
}
