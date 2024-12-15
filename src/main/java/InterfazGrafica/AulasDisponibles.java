
package InterfazGrafica;

import Clases.Aula;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class AulasDisponibles extends javax.swing.JFrame {
    private RegistrarReservaEsporadica esporadica;
    private RegistrarReservaPeriodica periodica;
    private ArrayList<Aula> aulas = new ArrayList<>();
    
    
    public AulasDisponibles() {
        initComponents();
    }

    public AulasDisponibles(ArrayList<Aula> lista,Date fecha){
        initComponents();
        aulas=lista;
        
        
        int mes = fecha.getMonth()+1;
        int anio = fecha.getYear()+1900;
        String muestra = "SELECCIONE EL AULA PARA EL DÍA: "+ fecha.getDate() + "/" +  mes + "/" +anio;
        
    
        dia.setText(muestra);
        centrarColumnas();
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        cargarDatos(lista);        
    }
    
    public AulasDisponibles(ArrayList<Aula> lista,String dia1,String periodo1){
        initComponents();
        aulas=lista;
        
        
        String dia2 = dia1.toUpperCase();
        String periodo2 = periodo1.toUpperCase();
        
        if(periodo2.equals("ANUAL")){
            String muestra = "SELECCIONE EL AULA PARA LOS DIAS " + dia2 + " DEL PERIODO " + periodo2;
            anual.setText(muestra);
        }else{
            String muestra = "SELECCIONE EL AULA PARA LOS DIAS " + dia2 + " DEL " + periodo2;
            cuatrimestre.setText(muestra);
        }
            
        
        
        centrarColumnas();
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        cargarDatos(lista);
    }
   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        confirmar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        cuatrimestre = new javax.swing.JLabel();
        dia = new javax.swing.JLabel();
        anual = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REGISTRAR RESERVA | AULAS DISPONIBLES");
        setMaximumSize(new java.awt.Dimension(830, 600));
        setMinimumSize(new java.awt.Dimension(830, 600));

        jPanel1.setBackground(new java.awt.Color(242, 240, 235));
        jPanel1.setMinimumSize(new java.awt.Dimension(830, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(830, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setBackground(new java.awt.Color(242, 240, 235));
        tabla.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tabla.setForeground(new java.awt.Color(0, 0, 0));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AULA", "UBICACION", "CAPACIDAD", "CARACTERISTICAS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setFocusable(false);
        tabla.setGridColor(new java.awt.Color(153, 153, 153));
        tabla.setRowHeight(35);
        tabla.setSelectionBackground(new java.awt.Color(242, 240, 235));
        tabla.setSelectionForeground(new java.awt.Color(153, 153, 153));
        jScrollPane2.setViewportView(tabla);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 790, 340));

        confirmar.setBackground(new java.awt.Color(242, 240, 235));
        confirmar.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        confirmar.setForeground(new java.awt.Color(0, 0, 0));
        confirmar.setText("CONFIRMAR");
        confirmar.setAlignmentY(0.0F);
        confirmar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });
        jPanel1.add(confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 560, 130, 30));

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
        jPanel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 560, 130, 30));

        cuatrimestre.setBackground(new java.awt.Color(242, 240, 235));
        cuatrimestre.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cuatrimestre.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(cuatrimestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 780, 30));

        dia.setBackground(new java.awt.Color(242, 240, 235));
        dia.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        dia.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 100, 550, 30));

        anual.setBackground(new java.awt.Color(242, 240, 235));
        anual.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        anual.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(anual, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 780, 30));

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
     
    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        int fila = tabla.getSelectedRow();
        
        if(fila!=-1){

            for(Aula i: aulas){

                if(i.getNumero() ==  (int)tabla.getValueAt(fila, 0)){
                   
                    if(periodica== null){
                        esporadica.guardarReserva(i);
                        esporadica.setVisible(true);
                        esporadica.setLocationRelativeTo(null);
                        esporadica.setResizable(false);
                        this.setVisible(false);
                    }else{
                        periodica.guardarReserva(i);
                        periodica.setVisible(true);
                        periodica.setLocationRelativeTo(null);
                        periodica.setResizable(false);
                        this.setVisible(false);   
                    }
 
                }
                
            }
   
        }else{
            mensajeNoSelecciona();
        }
    }//GEN-LAST:event_confirmarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
      if(periodica==null){
        esporadica.setVisible(true);
      }else{
        periodica.setVisible(true);
      }
      this.setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void cargarDatos(ArrayList<Aula> aulas) {
        // Obtén el modelo de la tabla
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tabla.getModel();
         Iterator<Aula> iterador = aulas.iterator();
        // Limpia las filas existentes en la tabla
        model.setRowCount(0);

        // Agrega cada BedelDTO como una fila en la tabla
        
        int i=0;
        while(iterador.hasNext() && i<3){
            Aula siguiente = iterador.next();
            String piso = "Piso " + siguiente.getPiso();
             model.addRow(new Object[]{
                siguiente.getNumero(), 
                piso,
                siguiente.getCapacidad(),
                siguiente.getDescripcion()
            });
            i++;
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
    
    public void mensajeNoSelecciona(){
        UIManager.put("OptionPane.background", new Color(242,240,235));
        //UIManager.put("Panel.background", new Color(242,240,235));
        UIManager.put("OptionPane.messageFont", new Font("Bahnschirift",Font.BOLD,14));
        JOptionPane.showMessageDialog(null, "SELECCIONE UNA TUPLA PARA ELIMINAR.","¡ALGO SALIO MAL!",
                JOptionPane.PLAIN_MESSAGE, getIcon("/cancelar.png",32,32));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anual;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton confirmar;
    private javax.swing.JLabel cuatrimestre;
    private javax.swing.JLabel dia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
    
    private Icon getIcon(String ruta, int w, int h) {
        return new ImageIcon(new ImageIcon(getClass().getResource(ruta))
                .getImage().getScaledInstance(w, h, 0));
    }
}
