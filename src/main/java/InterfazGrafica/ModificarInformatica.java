
package InterfazGrafica;

import Clases.AulaInformatica;
import Gestores.GestorAula;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class ModificarInformatica extends javax.swing.JFrame {

    private MenuBedel mBedel;
    private GestorAula gAula;
    private AulaInformatica datosAulaI;
    
    public ModificarInformatica() {
        initComponents();
    }

    public ModificarInformatica(MenuBedel mBedel1,String numero){
        initComponents();
        mBedel = mBedel1;
        gAula = new GestorAula();
        datosAulaI = gAula.buscarInformatica(numero);
        
        String nu = String.valueOf(datosAulaI.getNumero());
        numeroAula.setText(nu);
        
        String pi = String.valueOf(datosAulaI.getPiso());
        piso.setText(pi);
        
        int cap = datosAulaI.getCapacidad();
        capacidad.setValue(cap);
        
        int pcs = datosAulaI.getCantidadDePcs();
        PCs.setValue(pcs);
        
        pizarron.setSelectedItem(datosAulaI.getTipoDePizarron());
        
        if(datosAulaI.isCanon()){canon.setSelectedItem("SI");}
        else{canon.setSelectedItem("NO");}
        
        if(datosAulaI.isAireAcondicionado()){aire.setSelectedItem("SI");}
        else{aire.setSelectedItem("NO");}
    }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        numeroAula = new javax.swing.JTextField();
        piso = new javax.swing.JTextField();
        PCs = new javax.swing.JSpinner();
        capacidad = new javax.swing.JSpinner();
        aire = new javax.swing.JComboBox<>();
        pizarron = new javax.swing.JComboBox<>();
        canon = new javax.swing.JComboBox<>();
        confirmar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        capacidad0 = new javax.swing.JLabel();
        cantiPcs = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(830, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(242, 240, 235));
        jPanel2.setMinimumSize(new java.awt.Dimension(830, 600));
        jPanel2.setPreferredSize(new java.awt.Dimension(830, 600));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(242, 240, 235));
        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("CANTIDAD DE PCs: (*)");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        jLabel2.setBackground(new java.awt.Color(242, 240, 235));
        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("TIPO DE PIZARRON: (*)");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 95, -1, -1));

        jLabel3.setBackground(new java.awt.Color(242, 240, 235));
        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("AIRE ACONDICIONADO: (*)");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 305, -1, -1));

        jLabel4.setBackground(new java.awt.Color(242, 240, 235));
        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("CAPACIDAD: (*)");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 305, -1, -1));

        jLabel5.setBackground(new java.awt.Color(242, 240, 235));
        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("NÚMERO DE AULA: (*)");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 95, -1, -1));

        jLabel6.setBackground(new java.awt.Color(242, 240, 235));
        jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("PISO: (*)");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel7.setBackground(new java.awt.Color(242, 240, 235));
        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("CAÑON: (*)");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 193, -1, 30));

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
        jPanel2.add(numeroAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 150, 30));

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
        jPanel2.add(piso, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 150, 30));
        jPanel2.add(PCs, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 150, 30));
        jPanel2.add(capacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 150, 30));

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
        jPanel2.add(aire, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, 150, 30));

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
        jPanel2.add(pizarron, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 150, 30));

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
        jPanel2.add(canon, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 195, 150, 30));

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
        jPanel2.add(confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 515, 130, 30));

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
        jPanel2.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 515, 130, 30));

        capacidad0.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        capacidad0.setForeground(new java.awt.Color(255, 0, 0));
        capacidad0.setToolTipText("");
        jPanel2.add(capacidad0, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 200, 20));

        cantiPcs.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        cantiPcs.setForeground(new java.awt.Color(255, 0, 0));
        cantiPcs.setToolTipText("");
        jPanel2.add(cantiPcs, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, 250, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 600));

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

    private void aireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aireActionPerformed

    private void pizarronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pizarronActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pizarronActionPerformed

    private void canonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_canonActionPerformed

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        boolean flag=true;
        int capacidad1 = (int)capacidad.getValue();
        int pcs = (int)PCs.getValue();
        capacidad0.setText(""); cantiPcs.setText("");
        
        if(capacidad1==0){
            flag=false;
            capacidad0.setText("LA CAPACIDAD DEBE SER MAYOR A 0");
        }
        if(pcs==0){
            flag=false;
            cantiPcs.setText("LA CANTIDAD DE PCS DEBE SER MAYOR A 0");
        }
        if(flag){
            
            int capacidad2 = (int)capacidad.getValue();
            int cantidadPcs = (int)PCs.getValue();
            String pizarra = (String)pizarron.getSelectedItem();
            String canon1 = (String)canon.getSelectedItem();
            String aireAcond = (String)aire.getSelectedItem();
            
            try{
                gAula.modificarInformatica(capacidad2,cantidadPcs,pizarra,canon1,aireAcond,datosAulaI);
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
    private javax.swing.JSpinner PCs;
    private javax.swing.JComboBox<String> aire;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> canon;
    private javax.swing.JLabel cantiPcs;
    private javax.swing.JSpinner capacidad;
    private javax.swing.JLabel capacidad0;
    private javax.swing.JButton confirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField numeroAula;
    private javax.swing.JTextField piso;
    private javax.swing.JComboBox<String> pizarron;
    // End of variables declaration//GEN-END:variables
    private Icon getIcon(String ruta, int w, int h) {
        return new ImageIcon(new ImageIcon(getClass().getResource(ruta))
                .getImage().getScaledInstance(w, h, 0));
    }

}
