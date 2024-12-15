
package InterfazGrafica;

import Clases.Aula;
import Dtos.ReservasSolapadasDTO;
import java.util.ArrayList;
import java.util.Iterator;

public class AulasSolapadas extends javax.swing.JFrame {

    private RegistrarReservaEsporadica esporadica;
    private RegistrarReservaPeriodica periodica;
    //private ArrayList<ReservasSolapadasDTO> solapadas = new ArrayList<>();
    
    public AulasSolapadas() {
        initComponents();
    }
    
    public AulasSolapadas(ArrayList<ReservasSolapadasDTO> lista) {
        initComponents();
        //solapadas = lista
        centrarColumnas();
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla.setRowSelectionAllowed(true); 
        tabla.setColumnSelectionAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        cargarDatos(lista); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        cancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(242, 240, 235));
        setMinimumSize(new java.awt.Dimension(830, 600));

        jPanel1.setBackground(new java.awt.Color(242, 240, 235));
        jPanel1.setMinimumSize(new java.awt.Dimension(830, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setBackground(new java.awt.Color(242, 240, 235));
        tabla.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tabla.setForeground(new java.awt.Color(0, 0, 0));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AULA", "NOMBRE DOCENTE", "CATEDRA", "EMAIL CONTACTO", "INICIO RESERVA", "FIN RESERVA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setGridColor(new java.awt.Color(153, 153, 153));
        tabla.setRowHeight(35);
        tabla.setRowSelectionAllowed(false);
        tabla.setSelectionBackground(new java.awt.Color(242, 240, 235));
        tabla.setSelectionForeground(new java.awt.Color(153, 153, 153));
        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabla);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 790, 280));

        cancelar.setBackground(new java.awt.Color(242, 240, 235));
        cancelar.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cancelar.setForeground(new java.awt.Color(0, 0, 0));
        cancelar.setText("VOLVER");
        cancelar.setAlignmentY(0.0F);
        cancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 560, 130, 30));

        jLabel1.setBackground(new java.awt.Color(242, 240, 235));
        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("AULAS QUE SE SUPERPONEN CON EL HORARIO  INDICADO:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 530, 30));

        jLabel2.setBackground(new java.awt.Color(242, 240, 235));
        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("NO EXISTEN AULAS QUE CUMPLAN CON EL CRITERIO INGRESADO");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 600, 70));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/error (1).png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 50, 40));

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

    public void setRegistrarReservaEsporadica(RegistrarReservaEsporadica esporadica){
        this.esporadica = esporadica;
    }
     
     public void setRegistrarReservaPeriodica(RegistrarReservaPeriodica periodica){
        this.periodica = periodica;
    }
    
    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        if(periodica==null){
            esporadica.setVisible(true);
        }else{
            periodica.setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void cargarDatos(ArrayList<ReservasSolapadasDTO> aulas) {
        // Obtén el modelo de la tabla
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tabla.getModel();
         Iterator<ReservasSolapadasDTO> iterador = aulas.iterator();
        // Limpia las filas existentes en la tabla
        model.setRowCount(0);

        // Agrega cada BedelDTO como una fila en la tabla
        while(iterador.hasNext()){
            ReservasSolapadasDTO siguiente = iterador.next();
             model.addRow(new Object[]{
                siguiente.getAula().getNumero(),
                siguiente.getNombreDocente(),
                siguiente.getCatedra(),
                siguiente.getEmail(),
                siguiente.getHoraInicio(),
                siguiente.getHoraFin()
            });
        }
    }
    
    private void centrarColumnas() {
        // Crear un renderizador para centrar el texto
        javax.swing.table.DefaultTableCellRenderer renderer = new javax.swing.table.DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        // Aplicar el renderizador a cada columna de la tabla
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
