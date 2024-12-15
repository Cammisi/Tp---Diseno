
package InterfazGrafica;

import Dtos.BedelDTO;
import Gestores.GestorBedel;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class EliminarBedel extends javax.swing.JFrame {
    
    private MenuAdministrador mAdm;
    private GestorBedel gBedel;
    private String[] datosBedel1 = new String[4];
    
    public EliminarBedel() {
        initComponents();
        
        gBedel = new GestorBedel();
    }
    
    public EliminarBedel(String[] datosBedel,MenuAdministrador mAdm1){
        initComponents();
        
        mAdm = mAdm1;
        gBedel = new GestorBedel();
        
        datosBedel1=datosBedel;
        apellido.setText(datosBedel[0]);
        nombre.setText(datosBedel[1]);
        turno.setText(datosBedel[2]);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        apellido = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        turno = new javax.swing.JTextField();
        eliminar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(830, 600));
        setMinimumSize(new java.awt.Dimension(830, 600));

        jPanel1.setBackground(new java.awt.Color(242, 240, 235));
        jPanel1.setMaximumSize(new java.awt.Dimension(830, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(830, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(242, 240, 235));
        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("APELLIDO: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        jLabel9.setBackground(new java.awt.Color(242, 240, 235));
        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("NOMBRE: ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, -1, -1));

        jLabel10.setBackground(new java.awt.Color(242, 240, 235));
        jLabel10.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("TURNO: ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, -1, -1));

        apellido.setEditable(false);
        apellido.setBackground(new java.awt.Color(242, 240, 235));
        apellido.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        apellido.setForeground(new java.awt.Color(153, 153, 153));
        apellido.setText("XXXXXXXXXXXXXXXXXXX");
        apellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoActionPerformed(evt);
            }
        });
        jPanel1.add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 155, 150, 30));

        nombre.setEditable(false);
        nombre.setBackground(new java.awt.Color(242, 240, 235));
        nombre.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        nombre.setForeground(new java.awt.Color(153, 153, 153));
        nombre.setText("XXXXXXXXXXXXXXXXX");
        nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 245, 150, 30));

        turno.setEditable(false);
        turno.setBackground(new java.awt.Color(242, 240, 235));
        turno.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        turno.setForeground(new java.awt.Color(153, 153, 153));
        turno.setText("XXXXXXXXXXXXXXXXX");
        turno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        turno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turnoActionPerformed(evt);
            }
        });
        jPanel1.add(turno, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 150, 30));

        eliminar.setBackground(new java.awt.Color(242, 240, 235));
        eliminar.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        eliminar.setForeground(new java.awt.Color(0, 0, 0));
        eliminar.setText("ELIMINAR");
        eliminar.setAlignmentY(0.0F);
        eliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 550, 130, 30));

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

    private void apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void turnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_turnoActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
       if(mensajeAdvertencia()==1){
           BedelDTO bedelBorrar = new BedelDTO(datosBedel1[1],datosBedel1[0],datosBedel1[2],datosBedel1[3]);
           try{
                gBedel.eliminarBedel(bedelBorrar);
                mensajeExito();
            }catch (SQLException ex) {
                mensajeFracasoBd();
            } catch (ClassNotFoundException ex) {
                mensajeFracasoBd();
            }
       }
       cancelarActionPerformed(evt);
    }//GEN-LAST:event_eliminarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        BuscarBedel bBedel = new BuscarBedel();
        bBedel.setMenuAdministrador(mAdm);
        bBedel.setVisible(true);
        bBedel.setLocationRelativeTo(null);
        bBedel.setResizable(false);
        this.setVisible(false);

    }//GEN-LAST:event_cancelarActionPerformed

     public void mensajeExito(){
        UIManager.put("OptionPane.background", new Color(242,240,235));
        //UIManager.put("Panel.background", new Color(242,240,235));
        UIManager.put("OptionPane.messageFont", new Font("Bahnschirift",Font.BOLD,14));
        JOptionPane.showMessageDialog(null, "EL BEDEL SE ELIMINO CORRECTAMENTE.","",
            JOptionPane.PLAIN_MESSAGE, getIcon("/aceptar.png",32,32));
    }
     
    public void mensajeFracasoBd(){
        UIManager.put("OptionPane.background", new Color(242,240,235));
        //UIManager.put("Panel.background", new Color(242,240,235));
        UIManager.put("OptionPane.messageFont", new Font("Bahnschirift",Font.BOLD,14));
        JOptionPane.showMessageDialog(null, "LO SENTIMOS, HUBO UN ERROR EN LA BASE DE DATOS Y NO SE PUDO ELIMINAR EL BEDEL.","¡ALGO SALIO MAL!",
                JOptionPane.PLAIN_MESSAGE, getIcon("/cancelar.png",32,32));
    }
    
    public int mensajeAdvertencia(){
        Object[] opciones = {"NO","SI"};
        UIManager.put("OptionPane.background", new Color(242,240,235));
        UIManager.put("OptionPane.messageFont", new Font("Bahnschirift",Font.BOLD,14));
        int seleccion = JOptionPane.showOptionDialog(null, "ESTAS SEGURO DE ELIMINAR ESTE BEDEL?","ADVERTENCIA",JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, getIcon("/warning.png",32,32),opciones,opciones[1]);
        return seleccion;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField turno;
    // End of variables declaration//GEN-END:variables

    private Icon getIcon(String ruta, int w, int h) {
        return new ImageIcon(new ImageIcon(getClass().getResource(ruta))
                .getImage().getScaledInstance(w, h, 0));
    }
}
