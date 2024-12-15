
package InterfazGrafica;

import Clases.Aula;
import Dtos.ReservaEDTO;
import Gestores.GestorAula;
import Gestores.GestorExterno;
import Gestores.GestorReserva;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

public class RegistrarReservaEsporadica extends javax.swing.JFrame {

    private MenuBedel mBedel;
    private GestorExterno gExterno;
    private GestorAula gAula;
    private GestorReserva gReserva;
    private Aula aula;
    private String bedel;
    private ArrayList<ReservaEDTO> reservasNoConfirmadas = new ArrayList<>();

    public RegistrarReservaEsporadica(String usuario){
        initComponents();
        this.bedel=usuario;
        gAula = new GestorAula();
        gExterno = new  GestorExterno();
        gReserva = new GestorReserva();
        
        ArrayList<String> dni = new ArrayList<>();
        dni = gExterno.obtenerDocentes();
        
        for (String i : dni) {
            docente.addItem(i);
        }
        
        ArrayList<String> catedras = new ArrayList<>();
        catedras = gExterno.obtenerCatedras();
        
        for (String i : catedras) {
            catedra.addItem(i);
        }
        
        centrarColumnas();
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla.setRowSelectionAllowed(true); 
        tabla.setColumnSelectionAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.getColumnModel().getColumn(1).setCellRenderer(new ActionCellRenderer());
        
    }

    public void setMenuBedel(MenuBedel mBedel){
        this.mBedel = mBedel;
    }
    
    public void guardarReserva(Aula aula){
        ReservaEDTO reserva = new ReservaEDTO();
        int cant = Integer.parseInt(cantAlumnos.getText());
        int dur = Integer.parseInt(duracion.getText());
        Date fecha = dia.getDate();
        String horaString = horaInicio.getText();
        String horaCompleta = horaString + ":00";
        Time hora = Time.valueOf(horaCompleta);

        reserva.setAula(aula);
        reserva.setCantidadAlumnos(cant);
        reserva.setCatedra((String)catedra.getSelectedItem());
        reserva.setDia(fecha);
        reserva.setDocente((String)docente.getSelectedItem());
        reserva.setDuracion(dur);
        reserva.setEmail(email.getText());
        reserva.setHoraInicio(hora);
        reserva.setTipoAula((String)tipoAula.getSelectedItem());
        reserva.setBedel(bedel);
        reservasNoConfirmadas.add(reserva);
        limpiarDatosReserva();
        actualizarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        email = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        horarioInicio = new javax.swing.JLabel();
        horaInicio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        duracion = new javax.swing.JTextField();
        indicacionHora = new javax.swing.JButton();
        dia = new com.toedter.calendar.JDateChooser();
        vacioDuracion = new javax.swing.JLabel();
        vacioHora = new javax.swing.JLabel();
        vacioFecha = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        vacioAlumnos = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tipoAula = new javax.swing.JComboBox<>();
        docente = new javax.swing.JComboBox<>();
        catedra = new javax.swing.JComboBox<>();
        cantAlumnos = new javax.swing.JTextField();
        buscarAula = new javax.swing.JButton();
        vacioDocente = new javax.swing.JLabel();
        vacioEmail = new javax.swing.JLabel();
        vacioCatedra = new javax.swing.JLabel();
        vacioAula = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        cancelar = new javax.swing.JButton();
        confirmar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU BEDEL | REGISTRAR RESERVA ESPORADICA");
        setMinimumSize(new java.awt.Dimension(830, 600));

        jPanel1.setBackground(new java.awt.Color(242, 240, 235));
        jPanel1.setMinimumSize(new java.awt.Dimension(830, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(242, 240, 235));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        email.setBackground(new java.awt.Color(242, 240, 235));
        email.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        email.setForeground(new java.awt.Color(153, 153, 153));
        email.setText("Escribe aquí...");
        email.setToolTipText("");
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailKeyPressed(evt);
            }
        });
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 265, 130, 30));

        jLabel9.setBackground(new java.awt.Color(242, 240, 235));
        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("NOMBRE DE CATEDRA: (*)");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, -1, -1));

        jPanel3.setBackground(new java.awt.Color(242, 240, 235));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("DIA A UTILIZAR (*): ");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 201, -1));

        horarioInicio.setBackground(new java.awt.Color(242, 240, 235));
        horarioInicio.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        horarioInicio.setForeground(new java.awt.Color(0, 0, 0));
        horarioInicio.setText("HORARIO DE INICIO:(*)");
        jPanel3.add(horarioInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        horaInicio.setBackground(new java.awt.Color(242, 240, 235));
        horaInicio.setForeground(new java.awt.Color(153, 153, 153));
        horaInicio.setText("HH:MM");
        horaInicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        horaInicio.setCaretColor(new java.awt.Color(242, 240, 235));
        horaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horaInicioActionPerformed(evt);
            }
        });
        horaInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                horaInicioKeyPressed(evt);
            }
        });
        jPanel3.add(horaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 80, 20));

        jLabel8.setBackground(new java.awt.Color(242, 240, 235));
        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("DURACION:(*)");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, -1, -1));

        duracion.setBackground(new java.awt.Color(242, 240, 235));
        duracion.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        duracion.setForeground(new java.awt.Color(153, 153, 153));
        duracion.setText("Escribe aquí...");
        duracion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        duracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duracionActionPerformed(evt);
            }
        });
        duracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                duracionKeyPressed(evt);
            }
        });
        jPanel3.add(duracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 130, 20));

        indicacionHora.setBackground(new java.awt.Color(242, 240, 235));
        indicacionHora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exclamacion (2).png"))); // NOI18N
        indicacionHora.setToolTipText("<html>\n<head>\n<style> \n.infoContraseña{backgorund:white;color:black;}\n</style>\n<body>\n<h4 class=\"infoContraseña\">LA HORA INGRESADA DEBE CUMPLIR CON EL FORMATO HH:MM </h4>\n</body>\n</html>\n\n\n\n");
        indicacionHora.setBorder(null);
        indicacionHora.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                indicacionHoraMouseMoved(evt);
            }
        });
        indicacionHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indicacionHoraActionPerformed(evt);
            }
        });
        jPanel3.add(indicacionHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 85, 40, 30));
        jPanel3.add(dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 110, -1));

        vacioDuracion.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vacioDuracion.setForeground(new java.awt.Color(255, 0, 0));
        vacioDuracion.setToolTipText("");
        jPanel3.add(vacioDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 240, 20));

        vacioHora.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vacioHora.setForeground(new java.awt.Color(255, 0, 0));
        vacioHora.setToolTipText("");
        jPanel3.add(vacioHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 350, 20));

        vacioFecha.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vacioFecha.setForeground(new java.awt.Color(255, 0, 0));
        vacioFecha.setToolTipText("");
        jPanel3.add(vacioFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 310, 20));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 790, 130));

        jLabel11.setBackground(new java.awt.Color(242, 240, 235));
        jLabel11.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("CANTIDAD DE ALUMNOS: (*)");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        vacioAlumnos.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vacioAlumnos.setForeground(new java.awt.Color(255, 0, 0));
        vacioAlumnos.setToolTipText("");
        jPanel2.add(vacioAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 310, 20));

        jLabel12.setBackground(new java.awt.Color(242, 240, 235));
        jLabel12.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("DOCENTE: (*)");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel13.setBackground(new java.awt.Color(242, 240, 235));
        jLabel13.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("E-MAIL: (*)");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jLabel14.setBackground(new java.awt.Color(242, 240, 235));
        jLabel14.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("TIPO DE AULA: (*)");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, -1, -1));

        tipoAula.setBackground(new java.awt.Color(242, 240, 235));
        tipoAula.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tipoAula.setForeground(new java.awt.Color(153, 153, 153));
        tipoAula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "MULTIMEDIOS", "INFORMATICA", "SIN RECURSOS" }));
        tipoAula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        tipoAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoAulaActionPerformed(evt);
            }
        });
        jPanel2.add(tipoAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 205, 140, 30));

        docente.setBackground(new java.awt.Color(242, 240, 235));
        docente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        docente.setForeground(new java.awt.Color(153, 153, 153));
        docente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        docente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        docente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docenteActionPerformed(evt);
            }
        });
        jPanel2.add(docente, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 205, 130, 30));

        catedra.setBackground(new java.awt.Color(242, 240, 235));
        catedra.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        catedra.setForeground(new java.awt.Color(153, 153, 153));
        catedra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        catedra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        catedra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catedraActionPerformed(evt);
            }
        });
        jPanel2.add(catedra, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 145, 140, 30));

        cantAlumnos.setBackground(new java.awt.Color(242, 240, 235));
        cantAlumnos.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        cantAlumnos.setForeground(new java.awt.Color(153, 153, 153));
        cantAlumnos.setText("Escribe aquí...");
        cantAlumnos.setToolTipText("");
        cantAlumnos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cantAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantAlumnosActionPerformed(evt);
            }
        });
        cantAlumnos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cantAlumnosKeyPressed(evt);
            }
        });
        jPanel2.add(cantAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 145, 130, 30));

        buscarAula.setBackground(new java.awt.Color(242, 240, 235));
        buscarAula.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        buscarAula.setForeground(new java.awt.Color(0, 0, 0));
        buscarAula.setText("BUSCAR AULA");
        buscarAula.setAlignmentY(0.0F);
        buscarAula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        buscarAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarAulaActionPerformed(evt);
            }
        });
        jPanel2.add(buscarAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 480, 140, 30));

        vacioDocente.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vacioDocente.setForeground(new java.awt.Color(255, 0, 0));
        vacioDocente.setToolTipText("");
        jPanel2.add(vacioDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 200, 20));

        vacioEmail.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vacioEmail.setForeground(new java.awt.Color(255, 0, 0));
        vacioEmail.setToolTipText("");
        jPanel2.add(vacioEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 310, 20));

        vacioCatedra.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vacioCatedra.setForeground(new java.awt.Color(255, 0, 0));
        vacioCatedra.setToolTipText("");
        jPanel2.add(vacioCatedra, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 200, 20));

        vacioAula.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vacioAula.setForeground(new java.awt.Color(255, 0, 0));
        vacioAula.setToolTipText("");
        jPanel2.add(vacioAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, 200, 20));

        jPanel4.setBackground(new java.awt.Color(242, 240, 235));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        tabla.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setRowHeight(40);
        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setPreferredWidth(600);
        }

        jPanel4.add(jScrollPane1);

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 630, 130));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 810, 520));

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

        confirmar1.setBackground(new java.awt.Color(242, 240, 235));
        confirmar1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        confirmar1.setForeground(new java.awt.Color(0, 0, 0));
        confirmar1.setText("CONFIRMAR");
        confirmar1.setAlignmentY(0.0F);
        confirmar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        confirmar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmar1ActionPerformed(evt);
            }
        });
        jPanel1.add(confirmar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 550, 130, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyPressed
        if(email.getText().equals("Escribe aquí...")){
            email.setText("");
        }
    }//GEN-LAST:event_emailKeyPressed

    private void horaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horaInicioActionPerformed

    private void horaInicioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_horaInicioKeyPressed
        if(horaInicio.getText().equals("HH:MM")){
            horaInicio.setText("");
        }
    }//GEN-LAST:event_horaInicioKeyPressed

    private void duracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duracionActionPerformed

    private void duracionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_duracionKeyPressed
        if(duracion.getText().equals("Escribe aquí...")){
            duracion.setText("");
        }
    }//GEN-LAST:event_duracionKeyPressed

    private void tipoAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoAulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoAulaActionPerformed

    private void docenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_docenteActionPerformed

    private void catedraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catedraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_catedraActionPerformed

    private void cantAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantAlumnosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantAlumnosActionPerformed

    private void cantAlumnosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantAlumnosKeyPressed
        if(cantAlumnos.getText().equals("Escribe aquí...")){
            cantAlumnos.setText("");
        }
    }//GEN-LAST:event_cantAlumnosKeyPressed

    private void buscarAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarAulaActionPerformed
        limpiarLabels();
        Date fecha = dia.getDate();
        Date hoy= eliminarHora(new Date());
        
        boolean flag = true;
        boolean campoVacioFecha = false;
        boolean campoVacioHora = false;
        boolean campoVacioDuracion = false;
        boolean campoVacioAlumnos = false;   
        boolean campoVacioEmail = false;
        
        ArrayList<String> datos = new ArrayList();
        datos.add(horaInicio.getText());
        datos.add(duracion.getText());       
        datos.add(cantAlumnos.getText());
        datos.add((String)docente.getSelectedItem());
        datos.add(email.getText());
        datos.add((String)catedra.getSelectedItem());
        datos.add((String)tipoAula.getSelectedItem());
        
        if(fecha==null){
            campoVacioFecha = true;
            flag=false;
            vacioFecha.setText("ESTE CAMPO ES OBLIGATORIO");
        }
        
        for(ReservaEDTO i : reservasNoConfirmadas){
            if(i.getDia().getTime() == fecha.getTime()){
                mensajeErrorMismoDia();
                flag=false;
            }
        }
        
        for(int i=0;i<7;i++){
           if(!validarVacio(datos.get(i))){
                flag=false;
                switch(i){
                    case 0:
                    vacioHora.setText("ESTE CAMPO ES OBLIGATORIO");
                    campoVacioHora = true;
                    break;
                    case 1:
                    vacioDuracion.setText("ESTE CAMPO ES OBLIGATORIO");
                    campoVacioDuracion = true;
                    break;
                    case 2:
                    vacioAlumnos.setText("ESTE CAMPO ES OBLIGATORIO");
                    campoVacioAlumnos = true;
                    break;
                    case 3:
                    vacioDocente.setText("ESTE CAMPO ES OBLIGATORIO");
                    break;
                    case 4:
                    vacioEmail.setText("ESTE CAMPO ES OBLIGATORIO");
                    campoVacioEmail = true;
                    break;
                    case 5:
                    vacioCatedra.setText("ESTE CAMPO ES OBLIGATORIO");
                    break;
                    case 6:
                    vacioAula.setText("ESTE CAMPO ES OBLIGATORIO");
                    break;
                }
           }
        }
        if(!campoVacioFecha){
            if(fecha.before(hoy)){
                flag = false;
                vacioFecha.setText("LA FECHA DEBE SER POSTERIOR AL DÍA DE HOY");
            }       
        }
         
        if(!campoVacioHora){  
            if(horaInicio.getText().length()==5){
            if(!validarHora(horaInicio.getText()) ){
                flag = false;
                vacioHora.setText("LA HORA INGRESADA NO RESPETA EL FORMATO HH:MM");
            }else{
                if(fecha.compareTo(hoy)==0){
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                    LocalTime horaIngresadaTime = LocalTime.parse(horaInicio.getText(), formatter);
                    LocalTime horaActual = LocalTime.now();
                    if(!horaIngresadaTime.isAfter(horaActual)){
                       flag=false;
                       vacioHora.setText("LA HORA DE INICIO DEBE SER POSTERIOR O IGUAL A LA ACTUAL");
                   } 
                }
                }
            }else {
                vacioHora.setText("LA HORA INGRESADA NO RESPETA EL FORMATO HH:MM");
                flag = false;
            }
        }
        
        if(!campoVacioDuracion){
            int dur = Integer.parseInt(duracion.getText());
            if(!((dur%30==0) && dur!=0)){
                flag = false;
                vacioDuracion.setText("LA DURACION DEBE SER MULTIPLO DE 30");
            }
        }
        
        if(!campoVacioAlumnos){
            if(!cantAlumnos.getText().matches("[0-9]+")){
                flag = false;
                vacioAlumnos.setText("SOLO SE PUEDEN INGRESAR NUMEROS");
            }else{
            int cant = Integer.parseInt(cantAlumnos.getText());
            if(cant<1){
                flag = false;
                vacioAlumnos.setText("LA CANTIDAD DEBE SER MAYOR A 0");
            }
            }
        }
        
        if(!campoVacioEmail){  
            if(!esEmailValido(email.getText())){
                flag = false;
                vacioEmail.setText("DEBE CUMPLIR EL FORMATO: XXXX@XXXX.XXX");
            }
        }
        
        if(flag){
            
            try{
                int cap = gAula.obtenerMaxCapacidad((String)tipoAula.getSelectedItem());
                int cant = Integer.parseInt(cantAlumnos.getText()); 
                if(cant>cap){
                    ProgresoPopup popup = new ProgresoPopup(this);
                    popup.iniciarSimulacion();
                    popup.setVisible(true);
                    mensajeErrorCapacidad();
                    flag=false;
                }         
            }catch (SQLException ex) {
                flag=false;
                System.out.println("asd");
                mensajeErrorBd();
            }catch (ClassNotFoundException ex) {
                flag=false;
                mensajeErrorBd();
                System.out.println("asd111");
            }  
        }
        
        
        if(flag){
            ArrayList lista = new ArrayList<>();
            GestorAula gestorAula = new GestorAula();
            try {
                lista =  gestorAula.obtenerDisponibilidadAulas(fecha,horaInicio.getText(),duracion.getText(),cantAlumnos.getText(),(String)docente.getSelectedItem(),email.getText(),(String)catedra.getSelectedItem(),(String)tipoAula.getSelectedItem());
                ProgresoPopup popup = new ProgresoPopup(this);
                popup.iniciarSimulacion();
                popup.setVisible(true);

                if(lista.getFirst() instanceof  Aula){ 
                    AulasDisponibles aDisponibles = new AulasDisponibles(lista,fecha);
                    aDisponibles.setRegistrarReservaEsporadica(this);
                    aDisponibles.setVisible(true);
                    aDisponibles.setLocationRelativeTo(null);
                    aDisponibles.setResizable(false);
                    this.setVisible(false);  
                }else{
                    AulasSolapadas aSolapadas = new AulasSolapadas(lista);
                    aSolapadas.setRegistrarReservaEsporadica(this);
                    aSolapadas.setVisible(true);
                    aSolapadas.setLocationRelativeTo(null);
                    aSolapadas.setResizable(false);
                    this.setVisible(false);  
                }
            }catch (SQLException ex) {
               // Logger.getLogger(GestorReserva.class.getName()).log(Level.SEVERE, null, ex);
                mensajeErrorBd();
            }catch (ClassNotFoundException ex) {
               mensajeErrorBd();
            }  
        }
    }//GEN-LAST:event_buscarAulaActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        mBedel.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void confirmar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmar1ActionPerformed
        boolean retorno = true;
        if(!reservasNoConfirmadas.isEmpty()){
            try {
                retorno = gReserva.registrarReservaEsporadica(reservasNoConfirmadas);
                if(retorno){
                    mensajeExito();
                    limpiarDatosCompletos();
                    this.reservasNoConfirmadas.clear();
                    actualizarTabla();
                }else{
                    mensajeError();
                }
            } catch (SQLException ex) {
                mensajeErrorBd();
            } catch (ClassNotFoundException ex) {
                mensajeErrorBd();
            }
        }else{
            mensajeErrorReservas();
        }
    }//GEN-LAST:event_confirmar1ActionPerformed
   
    public boolean validarVacio(String str){
        boolean flag=true;
        if(str.isBlank() || str.equals("Escribe aquí...") || str.equals("Seleccionar") ||str.equals("HH:MM")){
            flag=false;
        }
       return flag;  
    }
    
    public static boolean validarHora(String hora) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        sdf.setLenient(false); // Desactiva la tolerancia para horas inválidas (e.g., 25:00)
        try {
            sdf.parse(hora); // Intenta analizar el string
            return true;     // Si no lanza excepción, la hora es válida
        } catch (ParseException e) {
            return false;    // Si lanza excepción, la hora es inválida
        }
    }
    public static boolean esEmailValido(String email) {
        // Expresión regular para validar un correo electrónico
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        // Validar el formato usando matches
        return email != null && email.matches(regex);
    }
    
    public static Date eliminarHora(Date fecha){
        return new Date(fecha.getYear(),fecha.getMonth(),fecha.getDate());
    }
    private void indicacionHoraMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_indicacionHoraMouseMoved
        //infoContraseña.createToolTip();
        //infoContraseña.setToolTipText("LA CONTRASEÑA DEBE CONTENER AL MENOS 8 CARACTERES, ENTRE ELLOS AL MENOS UNA MAYUSCULA Y UN NUMERO");
    }//GEN-LAST:event_indicacionHoraMouseMoved

    private void indicacionHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indicacionHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_indicacionHoraActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        // TODO add your handling code here:
        int fila = tabla.rowAtPoint(evt.getPoint());
        int columna = tabla.columnAtPoint(evt.getPoint());
        
        if(columna == 1){
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tabla.getModel();
            model.removeRow(fila);
            
            Iterator<ReservaEDTO> iterador = reservasNoConfirmadas.iterator();
            int i=0;
            while (iterador.hasNext()){
                iterador.next();
                if(i==fila){
                    iterador.remove();
                }
                i++;
            }
            actualizarTabla();
        }
    }//GEN-LAST:event_tablaMouseClicked
    
    public void limpiarLabels(){ 
        vacioFecha.setText("");
        vacioHora.setText("");
        vacioDuracion.setText("");
        vacioAlumnos.setText("");
        vacioEmail.setText("");
        vacioDocente.setText("");
        vacioCatedra.setText("");
        vacioAula.setText("");
    }
    
    public void mensajeExito(){
        UIManager.put("OptionPane.background", new Color(242,240,235));
        //UIManager.put("Panel.background", new Color(242,240,235));
        UIManager.put("OptionPane.messageFont", new Font("Bahnschirift",Font.BOLD,14));
        JOptionPane.showMessageDialog(null, "SE GUARDARON LAS RESERVAS CORRECTAMENTE.","",
            JOptionPane.PLAIN_MESSAGE, getIcon("/aceptar.png",32,32));
    }

    public void mensajeErrorMismoDia(){
        UIManager.put("OptionPane.background", new Color(242,240,235));
        //UIManager.put("Panel.background", new Color(242,240,235));
        UIManager.put("OptionPane.messageFont", new Font("Bahnschirift",Font.BOLD,14));
        JOptionPane.showMessageDialog(null, "EN LA LISTA DE RESERVAS YA HAY UNA RESERVA PARA ESE DIA. CONFIRME E INTENTE NUEVAMENTE.","¡ALGO SALIO MAL!",
                JOptionPane.PLAIN_MESSAGE, getIcon("/cancelar.png",32,32));
    }
    
    public void mensajeErrorCapacidad(){
        UIManager.put("OptionPane.background", new Color(242,240,235));
        //UIManager.put("Panel.background", new Color(242,240,235));
        UIManager.put("OptionPane.messageFont", new Font("Bahnschirift",Font.BOLD,14));
        JOptionPane.showMessageDialog(null, "NO EXISTEN AULAS CON ESA CAPACIDAD.","¡ALGO SALIO MAL!",
                JOptionPane.PLAIN_MESSAGE, getIcon("/cancelar.png",32,32));
    }
    
    
    public void mensajeErrorBd(){
        UIManager.put("OptionPane.background", new Color(242,240,235));
        //UIManager.put("Panel.background", new Color(242,240,235));
        UIManager.put("OptionPane.messageFont", new Font("Bahnschirift",Font.BOLD,14));
        JOptionPane.showMessageDialog(null, "LO SENTIMOS, HUBO UN ERROR EN LA BASE DE DATOS Y NO SE PUDO REGISTRAR LA RESERVA","¡ALGO SALIO MAL!",
                JOptionPane.PLAIN_MESSAGE, getIcon("/cancelar.png",32,32));
    }
    
    public void mensajeErrorReservas(){
        UIManager.put("OptionPane.background", new Color(242,240,235));
        //UIManager.put("Panel.background", new Color(242,240,235));
        UIManager.put("OptionPane.messageFont", new Font("Bahnschirift",Font.BOLD,14));
        JOptionPane.showMessageDialog(null, "NO HAY RESERVAS POR GUARDAR","¡ALGO SALIO MAL!",
                JOptionPane.PLAIN_MESSAGE, getIcon("/cancelar.png",32,32));
    }
    
    public void mensajeError(){
        UIManager.put("OptionPane.background", new Color(242,240,235));
        //UIManager.put("Panel.background", new Color(242,240,235));
        UIManager.put("OptionPane.messageFont", new Font("Bahnschirift",Font.BOLD,14));
        JOptionPane.showMessageDialog(null, "NO SE GUARDARON LAS RESERVAS CORRECTAMENTE","¡ALGO SALIO MAL!",
                JOptionPane.PLAIN_MESSAGE, getIcon("/cancelar.png",32,32));
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
       
    public void limpiarDatosReserva(){
        horaInicio.setText("HH:MM");
        duracion.setText("Escribe aquí...");
        cantAlumnos.setText("Escribe aquí...");
        catedra.setSelectedItem("Seleccionar");
        tipoAula.setSelectedItem("Seleccionar");
        dia.setDate(null);
    }
    
    public void limpiarDatosCompletos(){
        horaInicio.setText("HH:MM");
        docente.setSelectedItem("Seleccionar");
        email.setText("Escribe aquí...");
        duracion.setText("Escribe aquí...");
        cantAlumnos.setText("Escribe aquí...");
        catedra.setSelectedItem("Seleccionar");
        tipoAula.setSelectedItem("Seleccionar");
        dia.setDate(null);
    }
    
    public void actualizarTabla(){
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tabla.getModel();
        Iterator<ReservaEDTO> iterador = reservasNoConfirmadas.iterator();
        model.setRowCount(0);
        while (iterador.hasNext()) {
            ReservaEDTO siguiente = iterador.next();
            int mes = siguiente.getDia().getMonth() + 1;
            int anio = siguiente.getDia().getYear() + 1900;
            String ret = siguiente.getDia().getDate() + "/" + mes + "/" + anio;
            String hora = siguiente.getHoraInicio().getHours() + ":" + siguiente.getHoraInicio().getMinutes();
            if(siguiente.getHoraInicio().getMinutes() == 0){
                hora = hora + "0";
            }
            String datos = "RESERVÓ EL AULA " + siguiente.getAula().getNumero() + " PARA EL DIA " + ret + " EN EL HORARIO " + hora + " HS";

            model.addRow(new Object[]{datos,null}); // Agregar datos y texto del botón
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarAula;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField cantAlumnos;
    private javax.swing.JComboBox<String> catedra;
    private javax.swing.JButton confirmar1;
    private com.toedter.calendar.JDateChooser dia;
    private javax.swing.JComboBox<String> docente;
    private javax.swing.JTextField duracion;
    private javax.swing.JTextField email;
    private javax.swing.JTextField horaInicio;
    private javax.swing.JLabel horarioInicio;
    private javax.swing.JButton indicacionHora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JComboBox<String> tipoAula;
    private javax.swing.JLabel vacioAlumnos;
    private javax.swing.JLabel vacioAula;
    private javax.swing.JLabel vacioCatedra;
    private javax.swing.JLabel vacioDocente;
    private javax.swing.JLabel vacioDuracion;
    private javax.swing.JLabel vacioEmail;
    private javax.swing.JLabel vacioFecha;
    private javax.swing.JLabel vacioHora;
    // End of variables declaration//GEN-END:variables

    private Icon getIcon(String ruta, int w, int h) {
        return new ImageIcon(new ImageIcon(getClass().getResource(ruta))
                .getImage().getScaledInstance(w, h, 0));
    }
    
    private class ActionCellRenderer extends JPanel implements TableCellRenderer {
        URL imageUrl = ActionCellRenderer.class.getResource("/cancelar.png");
        ImageIcon icono = new ImageIcon(imageUrl);
        
        private final JButton deleteButton = new JButton(icono);

        public ActionCellRenderer() {
            setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
            add(deleteButton);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }
}
