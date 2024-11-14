
package InterfazGrafica;

public class MenuBedel extends javax.swing.JFrame {

    public MenuBedel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        listadoParaCurso = new javax.swing.JButton();
        rPeriodica = new javax.swing.JButton();
        rEsporadica = new javax.swing.JButton();
        buscarAula = new javax.swing.JButton();
        listadoParaDia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU BEDEL");

        jPanel1.setBackground(new java.awt.Color(242, 240, 235));
        jPanel1.setMaximumSize(new java.awt.Dimension(830, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(830, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(830, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listadoParaCurso.setBackground(new java.awt.Color(242, 240, 235));
        listadoParaCurso.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        listadoParaCurso.setForeground(new java.awt.Color(0, 0, 0));
        listadoParaCurso.setText("LISTADO DE RESERVAS PARA UN CURSO");
        listadoParaCurso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        listadoParaCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listadoParaCursoActionPerformed(evt);
            }
        });
        jPanel1.add(listadoParaCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 500, 70));

        rPeriodica.setBackground(new java.awt.Color(242, 240, 235));
        rPeriodica.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        rPeriodica.setForeground(new java.awt.Color(0, 0, 0));
        rPeriodica.setText("REGISTRAR RESERVA PERIODICA");
        rPeriodica.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        rPeriodica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rPeriodicaActionPerformed(evt);
            }
        });
        jPanel1.add(rPeriodica, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 500, 70));

        rEsporadica.setBackground(new java.awt.Color(242, 240, 235));
        rEsporadica.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        rEsporadica.setForeground(new java.awt.Color(0, 0, 0));
        rEsporadica.setText("REGISTRAR RESERVA ESPORADICA");
        rEsporadica.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        rEsporadica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rEsporadicaActionPerformed(evt);
            }
        });
        jPanel1.add(rEsporadica, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 500, 70));

        buscarAula.setBackground(new java.awt.Color(242, 240, 235));
        buscarAula.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        buscarAula.setForeground(new java.awt.Color(0, 0, 0));
        buscarAula.setText("BUSCAR AULA");
        buscarAula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buscarAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarAulaActionPerformed(evt);
            }
        });
        jPanel1.add(buscarAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 500, 70));

        listadoParaDia.setBackground(new java.awt.Color(242, 240, 235));
        listadoParaDia.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        listadoParaDia.setForeground(new java.awt.Color(0, 0, 0));
        listadoParaDia.setText("LISTADO DE RESERVAS PARA UN DIA ESPECIFICO");
        listadoParaDia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        listadoParaDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listadoParaDiaActionPerformed(evt);
            }
        });
        jPanel1.add(listadoParaDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 500, 70));

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

    private void listadoParaCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listadoParaCursoActionPerformed
        ListadoReservasCurso rPorCurso = new ListadoReservasCurso();
        rPorCurso.setMenuBedel(this);
        rPorCurso.setVisible(true);
        rPorCurso.setLocationRelativeTo(null);
        rPorCurso.setResizable(false);
        this.setVisible(false);
    }//GEN-LAST:event_listadoParaCursoActionPerformed

    private void rPeriodicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rPeriodicaActionPerformed
        RegistrarReservaPeriodica rPeriodica = new RegistrarReservaPeriodica();
        rPeriodica.setMenuBedel(this);
        rPeriodica.setVisible(true);
        rPeriodica.setLocationRelativeTo(null);
        rPeriodica.setResizable(false);
        this.setVisible(false);
    }//GEN-LAST:event_rPeriodicaActionPerformed

    private void rEsporadicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rEsporadicaActionPerformed
        RegistrarReservaEsporadica rEsporadica = new RegistrarReservaEsporadica();
        rEsporadica.setMenuBedel(this);
        rEsporadica.setVisible(true);
        rEsporadica.setLocationRelativeTo(null);
        rEsporadica.setResizable(false);
        this.setVisible(false);
    }//GEN-LAST:event_rEsporadicaActionPerformed

    private void buscarAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarAulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarAulaActionPerformed

    private void listadoParaDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listadoParaDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listadoParaDiaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarAula;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton listadoParaCurso;
    private javax.swing.JButton listadoParaDia;
    private javax.swing.JButton rEsporadica;
    private javax.swing.JButton rPeriodica;
    // End of variables declaration//GEN-END:variables
}
