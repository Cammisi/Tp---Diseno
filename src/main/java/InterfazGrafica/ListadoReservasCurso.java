
package InterfazGrafica;

import Dtos.ListaReservaDTO;
import Gestores.GestorReserva;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class ListadoReservasCurso extends javax.swing.JFrame {

    private MenuBedel mBedel;
    private GestorReserva gReserva;
    
    public ListadoReservasCurso() {
        initComponents();
        centrarColumnas();
        gReserva = new GestorReserva();
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setRowSelectionAllowed(true); 
        jTable1.setColumnSelectionAllowed(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        añoLectivo = new javax.swing.JTextField();
        catedra = new javax.swing.JComboBox<>();
        buscarReserva = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cancelar = new javax.swing.JButton();
        imprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU BEDEL | LISTADO DE RESERVAS POR CURSO");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(242, 240, 235));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(242, 240, 235));
        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("AÑO: (*)");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, -1, 30));

        jLabel7.setBackground(new java.awt.Color(242, 240, 235));
        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("TURNO: (*)");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 223, 110, 30));

        jLabel2.setBackground(new java.awt.Color(242, 240, 235));
        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("CATEDRA: (*)");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 40, -1, -1));

        añoLectivo.setBackground(new java.awt.Color(242, 240, 235));
        añoLectivo.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        añoLectivo.setForeground(new java.awt.Color(153, 153, 153));
        añoLectivo.setText("Escribe aquí...");
        añoLectivo.setToolTipText("");
        añoLectivo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        añoLectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añoLectivoActionPerformed(evt);
            }
        });
        añoLectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                añoLectivoKeyPressed(evt);
            }
        });
        jPanel2.add(añoLectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 35, 150, 30));

        catedra.setBackground(new java.awt.Color(242, 240, 235));
        catedra.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        catedra.setForeground(new java.awt.Color(153, 153, 153));
        catedra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "matemtica", "fisica", "quimica", " " }));
        catedra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        catedra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catedraActionPerformed(evt);
            }
        });
        jPanel2.add(catedra, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 35, 150, 30));

        buscarReserva.setBackground(new java.awt.Color(242, 240, 235));
        buscarReserva.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        buscarReserva.setForeground(new java.awt.Color(0, 0, 0));
        buscarReserva.setText("BUSCAR RESERVA");
        buscarReserva.setAlignmentY(0.0F);
        buscarReserva.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        buscarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarReservaActionPerformed(evt);
            }
        });
        jPanel2.add(buscarReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 170, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -20, 960, 150));

        jPanel3.setBackground(new java.awt.Color(242, 240, 235));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBackground(new java.awt.Color(242, 240, 235));
        jTable1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DIA", "HORA DE INICIO", "DURACION", "AULA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(153, 153, 153));
        jTable1.setRowHeight(30);
        jTable1.setRowSelectionAllowed(true);
        jTable1.setSelectionBackground(new java.awt.Color(242, 240, 235));
        jTable1.setSelectionForeground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 770, 380));

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
        jPanel3.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 430, 130, 30));

        imprimir.setBackground(new java.awt.Color(242, 240, 235));
        imprimir.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        imprimir.setForeground(new java.awt.Color(0, 0, 0));
        imprimir.setText("IMPRIMIR");
        imprimir.setAlignmentY(0.0F);
        imprimir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirActionPerformed(evt);
            }
        });
        jPanel3.add(imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, 130, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 830, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setMenuBedel(MenuBedel mBedel){
        this.mBedel = mBedel;
    }
    
    private void añoLectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añoLectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_añoLectivoActionPerformed

    private void añoLectivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_añoLectivoKeyPressed
        if(añoLectivo.getText().equals("Escribe aquí...")){
            añoLectivo.setText("");
        }
    }//GEN-LAST:event_añoLectivoKeyPressed

    private void catedraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catedraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_catedraActionPerformed

    private void buscarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarReservaActionPerformed
        String ano = añoLectivo.getText();
        String materia = (String) catedra.getSelectedItem();
        if( ano.equals("Escribe aquí...") || materia.equals("Seleccionar") ){
            mensajeSeleccionar();
        }else{
            ArrayList<ListaReservaDTO> reservas = gReserva.buscarReservaCurso(ano,materia);
            if(reservas.isEmpty()){
                mensajeFracaso();
            }else{
                cargarDatos(reservas);
            }
        }
    }//GEN-LAST:event_buscarReservaActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        mBedel.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirActionPerformed
        Impresora imprimir = new Impresora();
        imprimir.setListadoReservasCurso(this);
        imprimir.setVisible(true);
        imprimir.setLocationRelativeTo(null);
        imprimir.setResizable(false);
        this.setVisible(false);
    }//GEN-LAST:event_imprimirActionPerformed
    
    public void mensajeSeleccionar(){
        UIManager.put("OptionPane.background", new Color(242,240,235));
        //UIManager.put("Panel.background", new Color(242,240,235));
        UIManager.put("OptionPane.messageFont", new Font("Bahnschirift",Font.BOLD,14));
        JOptionPane.showMessageDialog(null, "SE DEBEN INDICAR LOS CRITERIOS DE BUSQUEDA.","¡ALGO SALIO MAL!",
                JOptionPane.PLAIN_MESSAGE, getIcon("/cancelar.png",32,32));
    }
 
    public void mensajeFracaso(){
        UIManager.put("OptionPane.background", new Color(242,240,235));
        //UIManager.put("Panel.background", new Color(242,240,235));
        UIManager.put("OptionPane.messageFont", new Font("Bahnschirift",Font.BOLD,14));
        JOptionPane.showMessageDialog(null, "ESTA CATEDRA NO RESERVO AULAS EN EL AÑO SELECCIONADO.","¡ALGO SALIO MAL!",
                JOptionPane.PLAIN_MESSAGE, getIcon("/cancelar.png",32,32));
    }
    
    private void centrarColumnas() {
        // Crear un renderizador para centrar el texto
        javax.swing.table.DefaultTableCellRenderer renderer = new javax.swing.table.DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        // Aplicar el renderizador a cada columna de la tabla
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }

    private void cargarDatos(ArrayList<ListaReservaDTO> reservas) {
        // Obtén el modelo de la tabla
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();

        // Limpia las filas existentes en la tabla
        model.setRowCount(0);

        // Agrega cada BedelDTO como una fila en la tabla
        for (ListaReservaDTO reserva : reservas) {
            model.addRow(new Object[]{
                reserva.getDia(), 
                reserva.getHoraInicio(), 
                reserva.getDuracion(), 
                reserva.getNumeroAula()
            });
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField añoLectivo;
    private javax.swing.JButton buscarReserva;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> catedra;
    private javax.swing.JButton imprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private Icon getIcon(String ruta, int w, int h) {
        return new ImageIcon(new ImageIcon(getClass().getResource(ruta))
                .getImage().getScaledInstance(w, h, 0));
    }
}
