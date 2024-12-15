
package InterfazGrafica;

import Dtos.BedelDTO;
import Dtos.ListaReservaDTO;
import Gestores.GestorReserva;
import java.awt.Color;
import java.util.Date;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class ListadoReservasDia extends javax.swing.JFrame {

    private MenuBedel mBedel;
    private GestorReserva gReserva;
    
    public ListadoReservasDia() {
        initComponents();
        
        gReserva = new GestorReserva();
        centrarColumnas();
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.setRowSelectionAllowed(true); 
        jTable2.setColumnSelectionAllowed(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tipoAulas = new javax.swing.JComboBox<>();
        buscarReserva = new javax.swing.JButton();
        fecha = new com.toedter.calendar.JDateChooser();
        imprimir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU BEDEL | LISTADO DE RESERVAS POR DIA ");
        setMaximumSize(new java.awt.Dimension(830, 600));
        setMinimumSize(new java.awt.Dimension(830, 600));

        jPanel1.setBackground(new java.awt.Color(242, 240, 235));
        jPanel1.setMaximumSize(new java.awt.Dimension(830, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(830, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(242, 240, 235));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setPreferredSize(new java.awt.Dimension(745, 253));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(242, 240, 235));
        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("DIA A BUSCAR: (*)");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 19, 166, 29));

        jLabel2.setBackground(new java.awt.Color(242, 240, 235));
        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("TIPO DE AULA:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 19, 132, -1));

        tipoAulas.setBackground(new java.awt.Color(242, 240, 235));
        tipoAulas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tipoAulas.setForeground(new java.awt.Color(0, 0, 0));
        tipoAulas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODAS", "MULTIMEDIOS", "INFORMATICA", "SIN RECURSOS" }));
        tipoAulas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoAulasActionPerformed(evt);
            }
        });
        jPanel2.add(tipoAulas, new org.netbeans.lib.awtextra.AbsoluteConstraints(641, 14, 166, -1));

        buscarReserva.setBackground(new java.awt.Color(242, 240, 235));
        buscarReserva.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        buscarReserva.setForeground(new java.awt.Color(0, 0, 0));
        buscarReserva.setText("BUSCAR RESERVA");
        buscarReserva.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buscarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarReservaActionPerformed(evt);
            }
        });
        jPanel2.add(buscarReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 197, -1));
        jPanel2.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 139));

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
        jPanel1.add(imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 547, 130, 30));

        jTable2.setBackground(new java.awt.Color(242, 240, 235));
        jTable2.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jTable2.setForeground(new java.awt.Color(0, 0, 0));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AULA", "DOCENTE", "CATEDRA", "HORA DE INICIO", "HORA DE FIN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setFocusable(false);
        jTable2.setGridColor(new java.awt.Color(153, 153, 153));
        jTable2.setRowHeight(30);
        jTable2.setSelectionBackground(new java.awt.Color(242, 240, 235));
        jTable2.setSelectionForeground(new java.awt.Color(153, 153, 153));
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 157, 806, 351));

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
        jPanel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(666, 548, 130, 30));

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

    private void imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirActionPerformed
        if(jTable2.getRowCount() != 0){
            Impresora imprimir = new Impresora();
            imprimir.setListadoReservasDia(this);
            imprimir.setVisible(true);
            imprimir.setLocationRelativeTo(null);
            imprimir.setResizable(false);
            this.setVisible(false);
        }else{
            tablaVacia();
        }
    }//GEN-LAST:event_imprimirActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        mBedel.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void tipoAulasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoAulasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoAulasActionPerformed

    private void buscarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarReservaActionPerformed
        String tipoAula=(String)tipoAulas.getSelectedItem();
        Date fecha1 = fecha.getDate();
        if(fecha1==null){
            mensajeErrorFecha();
        }else{
            ArrayList<ListaReservaDTO> reservas = gReserva.buscarReserva(tipoAula,fecha1);
            if(reservas.isEmpty()){
            mensajeFracaso();
            }else{
            cargarDatos(reservas);
            }
        }
    }//GEN-LAST:event_buscarReservaActionPerformed
 
    public void setMenuBedel(MenuBedel mBedel){
        this.mBedel = mBedel;
    }
    
    public void mensajeFracaso(){
        UIManager.put("OptionPane.background", new Color(242,240,235));
        //UIManager.put("Panel.background", new Color(242,240,235));
        UIManager.put("OptionPane.messageFont", new Font("Bahnschirift",Font.BOLD,14));
        JOptionPane.showMessageDialog(null, "PARA EL TIPO DE AULA ELEGIDO NO EXISTEN RESERVAS PARA ESE DIA.","¡ALGO SALIO MAL!",
                JOptionPane.PLAIN_MESSAGE, getIcon("/cancelar.png",32,32));
    }
    
    public void mensajeErrorFecha(){
        UIManager.put("OptionPane.background", new Color(242,240,235));
        //UIManager.put("Panel.background", new Color(242,240,235));
        UIManager.put("OptionPane.messageFont", new Font("Bahnschirift",Font.BOLD,14));
        JOptionPane.showMessageDialog(null, "DEBE INGRESAR UNA FECHA.","¡ALGO SALIO MAL!",
                JOptionPane.PLAIN_MESSAGE, getIcon("/cancelar.png",32,32));
    }
     
    public void tablaVacia(){
        UIManager.put("OptionPane.background", new Color(242,240,235));
        //UIManager.put("Panel.background", new Color(242,240,235));
        UIManager.put("OptionPane.messageFont", new Font("Bahnschirift",Font.BOLD,14));
        JOptionPane.showMessageDialog(null, "NO HAY RESERVAS PARA IMPRIMIR.","¡ALGO SALIO MAL!",
                JOptionPane.PLAIN_MESSAGE, getIcon("/cancelar.png",32,32));
    } 
     
    private void centrarColumnas() {
        // Crear un renderizador para centrar el texto
        javax.swing.table.DefaultTableCellRenderer renderer = new javax.swing.table.DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        // Aplicar el renderizador a cada columna de la tabla
        for (int i = 0; i < jTable2.getColumnCount(); i++) {
            jTable2.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }
     
    private void cargarDatos(ArrayList<ListaReservaDTO> reservas) {
        // Obtén el modelo de la tabla
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable2.getModel();

        // Limpia las filas existentes en la tabla
        model.setRowCount(0);

        // Agrega cada BedelDTO como una fila en la tabla
        for (ListaReservaDTO reserva : reservas) {
            model.addRow(new Object[]{
                reserva.getNumeroAula(), 
                reserva.getDniDocente(), 
                reserva.getNombreActividad(), 
                reserva.getHoraInicio(), 
                reserva.getHoraFin()
            });
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarReserva;
    private javax.swing.JButton cancelar;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JButton imprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox<String> tipoAulas;
    // End of variables declaration//GEN-END:variables

    private Icon getIcon(String ruta, int w, int h) {
        return new ImageIcon(new ImageIcon(getClass().getResource(ruta))
                .getImage().getScaledInstance(w, h, 0));
    }
}
