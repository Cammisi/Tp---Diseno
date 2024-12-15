
package InterfazGrafica;

public class Impresora extends javax.swing.JFrame {
    
    private ListadoReservasDia rPorDia;
    private ListadoReservasCurso rPorCurso;
    
    public Impresora() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opcionImpresion = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        horizontal = new javax.swing.JRadioButton();
        automatica = new javax.swing.JRadioButton();
        vertical = new javax.swing.JRadioButton();
        imprimir = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OPCIONES DE IMPRESION");
        setMaximumSize(new java.awt.Dimension(830, 600));
        setMinimumSize(new java.awt.Dimension(830, 600));

        jPanel1.setBackground(new java.awt.Color(242, 240, 235));
        jPanel1.setMaximumSize(new java.awt.Dimension(830, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(830, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(242, 240, 235));
        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("IMPRESORA: (*)");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 150, 30));

        jLabel2.setBackground(new java.awt.Color(242, 240, 235));
        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("COPIAS: (*)");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 120, 20));

        jComboBox1.setBackground(new java.awt.Color(242, 240, 235));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 130, 20));
        jPanel1.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 50, -1));

        jPanel2.setBackground(new java.awt.Color(242, 240, 235));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(242, 240, 235));
        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("DISPOSICION:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 150, 30));

        horizontal.setBackground(new java.awt.Color(242, 240, 235));
        opcionImpresion.add(horizontal);
        horizontal.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        horizontal.setForeground(new java.awt.Color(0, 0, 0));
        horizontal.setText("HORIZONTAL");
        horizontal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        horizontal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        horizontal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        horizontal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horizontalActionPerformed(evt);
            }
        });
        jPanel2.add(horizontal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 110, 40));

        automatica.setBackground(new java.awt.Color(242, 240, 235));
        opcionImpresion.add(automatica);
        automatica.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        automatica.setForeground(new java.awt.Color(0, 0, 0));
        automatica.setText("AUTOMATICA");
        automatica.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        automatica.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        automatica.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        automatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                automaticaActionPerformed(evt);
            }
        });
        jPanel2.add(automatica, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 110, 40));

        vertical.setBackground(new java.awt.Color(242, 240, 235));
        opcionImpresion.add(vertical);
        vertical.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        vertical.setForeground(new java.awt.Color(0, 0, 0));
        vertical.setText("VERTICAL");
        vertical.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        vertical.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vertical.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        vertical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verticalActionPerformed(evt);
            }
        });
        jPanel2.add(vertical, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 80, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 470, 190));

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

    }//GEN-LAST:event_imprimirActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        if(rPorDia==null){
        rPorCurso.setVisible(true);
        }else{
        rPorDia.setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void horizontalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horizontalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horizontalActionPerformed

    private void automaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_automaticaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_automaticaActionPerformed

    private void verticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verticalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verticalActionPerformed
    
    public void setListadoReservasDia(ListadoReservasDia rPorDia){
        this.rPorDia = rPorDia;
    }
    
    public void setListadoReservasCurso(ListadoReservasCurso rPorCurso){
        this.rPorCurso = rPorCurso;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton automatica;
    private javax.swing.JButton cancelar;
    private javax.swing.JRadioButton horizontal;
    private javax.swing.JButton imprimir;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.ButtonGroup opcionImpresion;
    private javax.swing.JRadioButton vertical;
    // End of variables declaration//GEN-END:variables
}
