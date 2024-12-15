
package InterfazGrafica;

import Clases.Aula;
import Dtos.ReservaPDTO;
import Gestores.GestorAula;
import Gestores.GestorExterno;
import Gestores.GestorReserva;
import static InterfazGrafica.RegistrarReservaEsporadica.esEmailValido;
import static InterfazGrafica.RegistrarReservaEsporadica.validarHora;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

public class RegistrarReservaPeriodica extends javax.swing.JFrame {
    
    private MenuBedel mBedel;
    private GestorExterno gExterno;
    private GestorAula gAula;
    private GestorReserva gReserva;
    private String bedel;
    private ArrayList<ReservaPDTO> reservasNoConfirmadas = new ArrayList<>();
    
    public RegistrarReservaPeriodica(String bedel) {
        initComponents();
        this.bedel=bedel;
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
        
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla.setRowSelectionAllowed(true); 
        tabla.setColumnSelectionAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.getColumnModel().getColumn(1).setCellRenderer(new RegistrarReservaPeriodica.ActionCellRenderer());
    }
    
    public void setMenuBedel(MenuBedel mBedel){
        this.mBedel = mBedel;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoDias = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        email = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lunes = new javax.swing.JRadioButton();
        horarioInicio = new javax.swing.JLabel();
        horaInicio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        duracion = new javax.swing.JTextField();
        martes1 = new javax.swing.JRadioButton();
        sabado = new javax.swing.JRadioButton();
        miercoles = new javax.swing.JRadioButton();
        jueves = new javax.swing.JRadioButton();
        viernes = new javax.swing.JRadioButton();
        indicacionHora = new javax.swing.JButton();
        vacioHora = new javax.swing.JLabel();
        vacioDuracion = new javax.swing.JLabel();
        vacioDia = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tipoAula = new javax.swing.JComboBox<>();
        periodo = new javax.swing.JComboBox<>();
        docente = new javax.swing.JComboBox<>();
        catedra = new javax.swing.JComboBox<>();
        cantAlumnos = new javax.swing.JTextField();
        buscarAula = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        vacioAlumnos = new javax.swing.JLabel();
        vacioDocente = new javax.swing.JLabel();
        vacioCatedra = new javax.swing.JLabel();
        vacioAula = new javax.swing.JLabel();
        vacioEmail = new javax.swing.JLabel();
        vacioPeriodo = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();
        confirmar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU BEDEL | REGISTRAR RESERVA PERIODICA");
        setMaximumSize(new java.awt.Dimension(830, 600));
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
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 315, 130, 30));

        jLabel9.setBackground(new java.awt.Color(242, 240, 235));
        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("NOMBRE DE CATEDRA: (*)");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, -1, -1));

        jPanel3.setBackground(new java.awt.Color(242, 240, 235));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("DIA QUE SE DICTA (*): ");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 201, -1));

        lunes.setBackground(new java.awt.Color(242, 240, 235));
        grupoDias.add(lunes);
        lunes.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        lunes.setForeground(new java.awt.Color(0, 0, 0));
        lunes.setText("LUNES");
        lunes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        lunes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lunes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lunes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lunesActionPerformed(evt);
            }
        });
        jPanel3.add(lunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 70, 40));

        horarioInicio.setBackground(new java.awt.Color(242, 240, 235));
        horarioInicio.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        horarioInicio.setForeground(new java.awt.Color(0, 0, 0));
        horarioInicio.setText("HORARIO DE INICIO:(*)");
        jPanel3.add(horarioInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

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
        jPanel3.add(horaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 80, 20));

        jLabel8.setBackground(new java.awt.Color(242, 240, 235));
        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("DURACION:(*)");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, -1));

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
        jPanel3.add(duracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 130, 20));

        martes1.setBackground(new java.awt.Color(242, 240, 235));
        grupoDias.add(martes1);
        martes1.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        martes1.setForeground(new java.awt.Color(0, 0, 0));
        martes1.setText("MARTES");
        martes1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        martes1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        martes1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        martes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                martes1ActionPerformed(evt);
            }
        });
        jPanel3.add(martes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 70, 40));

        sabado.setBackground(new java.awt.Color(242, 240, 235));
        grupoDias.add(sabado);
        sabado.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        sabado.setForeground(new java.awt.Color(0, 0, 0));
        sabado.setText("SABADO");
        sabado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        sabado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sabado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        sabado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sabadoActionPerformed(evt);
            }
        });
        jPanel3.add(sabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 70, 40));

        miercoles.setBackground(new java.awt.Color(242, 240, 235));
        grupoDias.add(miercoles);
        miercoles.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        miercoles.setForeground(new java.awt.Color(0, 0, 0));
        miercoles.setText("MIERCOLES");
        miercoles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        miercoles.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        miercoles.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        miercoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miercolesActionPerformed(evt);
            }
        });
        jPanel3.add(miercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 100, 40));

        jueves.setBackground(new java.awt.Color(242, 240, 235));
        grupoDias.add(jueves);
        jueves.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jueves.setForeground(new java.awt.Color(0, 0, 0));
        jueves.setText("JUEVES");
        jueves.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jueves.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jueves.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jueves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                juevesActionPerformed(evt);
            }
        });
        jPanel3.add(jueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 70, 40));

        viernes.setBackground(new java.awt.Color(242, 240, 235));
        grupoDias.add(viernes);
        viernes.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        viernes.setForeground(new java.awt.Color(0, 0, 0));
        viernes.setText("VIERNES");
        viernes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        viernes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viernes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        viernes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viernesActionPerformed(evt);
            }
        });
        jPanel3.add(viernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 80, 40));

        indicacionHora.setBackground(new java.awt.Color(242, 240, 235));
        indicacionHora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exclamacion (2).png"))); // NOI18N
        indicacionHora.setToolTipText("<html>\n<head>\n<style> \n.infoContraseña{backgorund:white;color:black;}\n</style>\n<body>\n<h4 class=\"infoContraseña\">LA HORA INGRESADA DEBE CUMPLIR CON EL FORMATE HH:MM </h4>\n</body>\n</html>\n\n\n\n");
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
        jPanel3.add(indicacionHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 85, 40, 30));

        vacioHora.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vacioHora.setForeground(new java.awt.Color(255, 0, 0));
        vacioHora.setToolTipText("");
        jPanel3.add(vacioHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 290, 20));

        vacioDuracion.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vacioDuracion.setForeground(new java.awt.Color(255, 0, 0));
        vacioDuracion.setToolTipText("");
        jPanel3.add(vacioDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 250, 20));

        vacioDia.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vacioDia.setForeground(new java.awt.Color(255, 0, 0));
        vacioDia.setToolTipText("");
        jPanel3.add(vacioDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 200, 20));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 790, 150));

        jLabel10.setBackground(new java.awt.Color(242, 240, 235));
        jLabel10.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("PERIODO: (*)");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel11.setBackground(new java.awt.Color(242, 240, 235));
        jLabel11.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("CANTIDAD DE ALUMNOS: (*)");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel12.setBackground(new java.awt.Color(242, 240, 235));
        jLabel12.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("DOCENTE: (*)");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jLabel13.setBackground(new java.awt.Color(242, 240, 235));
        jLabel13.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("E-MAIL: (*)");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, -1, -1));

        jLabel14.setBackground(new java.awt.Color(242, 240, 235));
        jLabel14.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("TIPO DE AULA: (*)");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, -1, -1));

        tipoAula.setBackground(new java.awt.Color(242, 240, 235));
        tipoAula.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        tipoAula.setForeground(new java.awt.Color(153, 153, 153));
        tipoAula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "MULTIMEDIOS", "INFORMATICA", "SIN RECURSOS" }));
        tipoAula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        tipoAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoAulaActionPerformed(evt);
            }
        });
        jPanel2.add(tipoAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 235, 150, 30));

        periodo.setBackground(new java.awt.Color(242, 240, 235));
        periodo.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        periodo.setForeground(new java.awt.Color(153, 153, 153));
        periodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Primer Cuatrimestre", "Segundo Cuatrimestre", "Anual" }));
        periodo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        periodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                periodoActionPerformed(evt);
            }
        });
        jPanel2.add(periodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 165, 150, 30));

        docente.setBackground(new java.awt.Color(242, 240, 235));
        docente.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        docente.setForeground(new java.awt.Color(153, 153, 153));
        docente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        docente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        docente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docenteActionPerformed(evt);
            }
        });
        jPanel2.add(docente, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 315, -1, 30));

        catedra.setBackground(new java.awt.Color(242, 240, 235));
        catedra.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        catedra.setForeground(new java.awt.Color(153, 153, 153));
        catedra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        catedra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        catedra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catedraActionPerformed(evt);
            }
        });
        jPanel2.add(catedra, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 165, 150, 30));

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
        jPanel2.add(cantAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 235, 130, 30));

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
        jPanel2.add(buscarAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 500, 140, 30));

        jPanel4.setBackground(new java.awt.Color(242, 240, 235));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel4.setRequestFocusEnabled(false);
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        tabla.setFont(new java.awt.Font("Bahnschrift", 0, 11)); // NOI18N
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

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 390, 630, 130));

        vacioAlumnos.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vacioAlumnos.setForeground(new java.awt.Color(255, 0, 0));
        vacioAlumnos.setToolTipText("");
        jPanel2.add(vacioAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 290, 20));

        vacioDocente.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vacioDocente.setForeground(new java.awt.Color(255, 0, 0));
        vacioDocente.setToolTipText("");
        jPanel2.add(vacioDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 200, 20));

        vacioCatedra.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vacioCatedra.setForeground(new java.awt.Color(255, 0, 0));
        vacioCatedra.setToolTipText("");
        jPanel2.add(vacioCatedra, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, 200, 20));

        vacioAula.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vacioAula.setForeground(new java.awt.Color(255, 0, 0));
        vacioAula.setToolTipText("");
        jPanel2.add(vacioAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 270, 200, 20));

        vacioEmail.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vacioEmail.setForeground(new java.awt.Color(255, 0, 0));
        vacioEmail.setToolTipText("");
        jPanel2.add(vacioEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 350, 200, 20));

        vacioPeriodo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vacioPeriodo.setForeground(new java.awt.Color(255, 0, 0));
        vacioPeriodo.setToolTipText("");
        jPanel2.add(vacioPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 200, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 810, 540));

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
        jPanel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 560, 130, 30));

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
        jPanel1.add(confirmar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 560, 130, 30));

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

    public void guardarReserva(Aula aula){
        ReservaPDTO reserva = new ReservaPDTO();
        
        int cant = Integer.parseInt(cantAlumnos.getText());
        int dur = Integer.parseInt(duracion.getText());
        String dia = getSelectedButtonText(grupoDias);
        String horaString = horaInicio.getText();
        String horaCompleta = horaString + ":00";
        Time hora = Time.valueOf(horaCompleta);

        reserva.setAula(aula);
        reserva.setCantidadAlumnos(cant);
        reserva.setCatedra((String)catedra.getSelectedItem());
        reserva.setDia(dia);
        reserva.setDocente((String)docente.getSelectedItem());
        reserva.setPeriodo((String)periodo.getSelectedItem());
        reserva.setDuracion(dur);
        reserva.setEmail(email.getText());
        reserva.setHoraInicio(hora);
        reserva.setTipoAula((String)tipoAula.getSelectedItem());
        reserva.setBedel(bedel);
        reservasNoConfirmadas.add(reserva);
        limpiarDatosReserva();
        actualizarTabla();
    }
    
    private void buscarAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarAulaActionPerformed

        limpiarLabels();

        boolean flag = true;
        boolean campoVacioFecha = false;
        boolean campoVacioHora = false;
        boolean campoVacioDuracion = false;
        boolean campoVacioAlumnos = false;   
        boolean campoVacioEmail = false;
        
        ArrayList<String> datos = new ArrayList();
        datos.add(horaInicio.getText());
        datos.add(duracion.getText());     
        datos.add((String)periodo.getSelectedItem());
        datos.add(cantAlumnos.getText());
        datos.add((String)docente.getSelectedItem());
        datos.add((String)catedra.getSelectedItem());
        datos.add((String)tipoAula.getSelectedItem());
        datos.add(email.getText());
        String dia = getSelectedButtonText(grupoDias);
        String periodo2 = (String)periodo.getSelectedItem();
        
        if(dia == null){
            vacioDia.setText("DEBE SELECCIONAR UN DIA");
            flag = false;
        }
        
        for(ReservaPDTO i : reservasNoConfirmadas){
            if(dia.equals(i.getDia()) && (i.getPeriodo().equals("Anual") || periodo2.equals("Anual"))){
                mensajeErrorMismoDia();
                flag=false;
            }
            if(dia.equals(i.getDia()) && i.getPeriodo().equals(periodo2)){
                mensajeErrorMismoDia();
                flag=false;
            }
        }
        
        for(int i=0;i<8;i++){
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
                    vacioPeriodo.setText("ESTE CAMPO ES OBLIGATORIO");
                    break;
                    case 3:
                    vacioAlumnos.setText("ESTE CAMPO ES OBLIGATORIO");
                    campoVacioAlumnos = true;
                    break;
                    case 4:
                    vacioDocente.setText("ESTE CAMPO ES OBLIGATORIO");
                    break;
                    case 5:
                    vacioCatedra.setText("ESTE CAMPO ES OBLIGATORIO");
                    break;
                    case 6:
                    vacioAula.setText("ESTE CAMPO ES OBLIGATORIO");
                    break;
                    case 7:
                    vacioEmail.setText("ESTE CAMPO ES OBLIGATORIO");
                    campoVacioEmail = true;
                    break;
                }
           }
        }
         
        if(!campoVacioHora){  
            if(horaInicio.getText().length()==5){
                if(!validarHora(horaInicio.getText())){
                    flag = false;
                    vacioHora.setText("LA HORA INGRESADA NO RESPETA EL FORMATO HH:MM");
                }
            }else {
                vacioHora.setText("LA HORA INGRESADA NO RESPETA EL FORMATO HH:MM");
                flag = false;
            }
        }      
        
        if(!campoVacioDuracion){
            int dur = Integer.parseInt(duracion.getText());
            if(!((dur % 30==0) && dur!=0)){
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
                mensajeErrorBd();
            }catch (ClassNotFoundException ex) {
                flag=false;
                mensajeErrorBd();
            }  
        }
        
        if(flag){
            ArrayList lista = new ArrayList<>();
            GestorAula gestorAula = new GestorAula();
            String periodo1 = (String)periodo.getSelectedItem();
             try {
                lista = gestorAula.obtenerDisponibilidadAulas(dia,horaInicio.getText(),duracion.getText(),periodo1,cantAlumnos.getText(),(String)docente.getSelectedItem(),email.getText(),(String)catedra.getSelectedItem(),(String)tipoAula.getSelectedItem());
                ProgresoPopup popup = new ProgresoPopup(this);
                popup.iniciarSimulacion();
                popup.setVisible(true);
                
                if(lista.getFirst() instanceof  Aula){
                    AulasDisponibles aDisponibles = new AulasDisponibles(lista,dia,periodo1);
                    aDisponibles.setRegistrarReservaPeriodica(this);
                    aDisponibles.setVisible(true);
                    aDisponibles.setLocationRelativeTo(null);
                    aDisponibles.setResizable(false);
                    this.setVisible(false);
                }else{
                    AulasSolapadas aSolapadas = new AulasSolapadas(lista);
                    aSolapadas.setRegistrarReservaPeriodica(this);
                    aSolapadas.setVisible(true);
                    aSolapadas.setLocationRelativeTo(null);
                    aSolapadas.setResizable(false);
                    this.setVisible(false);
                }
                
             } catch (SQLException ex) {
                mensajeErrorBd();
             } catch (ClassNotFoundException ex) {
                mensajeErrorBd();
             }  
        }
        
    }//GEN-LAST:event_buscarAulaActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        mBedel.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void lunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lunesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lunesActionPerformed

    private void horaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horaInicioActionPerformed

    private void duracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duracionActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyPressed
        if(email.getText().equals("Escribe aquí...")){
            email.setText("");
        }
    }//GEN-LAST:event_emailKeyPressed

    private void tipoAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoAulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoAulaActionPerformed

    private void periodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_periodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_periodoActionPerformed

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

    private void confirmar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmar1ActionPerformed
        boolean retorno = true;
        if(!reservasNoConfirmadas.isEmpty()){
            try {
                retorno = gReserva.registrarReservaPeriodica(reservasNoConfirmadas);
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

    private void horaInicioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_horaInicioKeyPressed
        if(horaInicio.getText().equals("HH:MM")){
            horaInicio.setText("");
        }
    }//GEN-LAST:event_horaInicioKeyPressed

    private void duracionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_duracionKeyPressed
        if(duracion.getText().equals("Escribe aquí...")){
            duracion.setText("");
        }
    }//GEN-LAST:event_duracionKeyPressed

    private void martes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_martes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_martes1ActionPerformed

    private void sabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sabadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sabadoActionPerformed

    private void miercolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miercolesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miercolesActionPerformed

    private void juevesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_juevesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_juevesActionPerformed

    private void viernesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viernesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viernesActionPerformed

    private void indicacionHoraMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_indicacionHoraMouseMoved
        //infoContraseña.createToolTip();
        //infoContraseña.setToolTipText("LA CONTRASEÑA DEBE CONTENER AL MENOS 8 CARACTERES, ENTRE ELLOS AL MENOS UNA MAYUSCULA Y UN NUMERO");
    }//GEN-LAST:event_indicacionHoraMouseMoved

    private void indicacionHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indicacionHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_indicacionHoraActionPerformed

    
    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int fila = tabla.rowAtPoint(evt.getPoint());
        int columna = tabla.columnAtPoint(evt.getPoint());

        if(columna == 1){
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tabla.getModel();
            model.removeRow(fila);

            Iterator<ReservaPDTO> iterador = reservasNoConfirmadas.iterator();
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
    
    public boolean validarVacio(String str){
        boolean flag=true;
        if(str.isBlank() || str.equals("Escribe aquí...") || str.equals("Seleccionar") ||str.equals("HH:MM")){
            flag=false;
        }
       return flag;  
    }
    
    public static String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null; // Si no hay nada seleccionado
    }
    
    public void limpiarDatosReserva(){
        horaInicio.setText("HH:MM");
        duracion.setText("Escribe aquí...");
        cantAlumnos.setText("Escribe aquí...");
        catedra.setSelectedItem("Seleccionar");
        tipoAula.setSelectedItem("Seleccionar");
        periodo.setSelectedItem("Seleccionar");
        grupoDias.clearSelection();
    }
    
    public void limpiarDatosCompletos(){
        horaInicio.setText("HH:MM");
        docente.setSelectedItem("Seleccionar");
        email.setText("Escribe aquí...");
        duracion.setText("Escribe aquí...");
        cantAlumnos.setText("Escribe aquí...");
        catedra.setSelectedItem("Seleccionar");
        tipoAula.setSelectedItem("Seleccionar");
        periodo.setSelectedItem("Seleccionar");
        grupoDias.clearSelection();
    }
    
    public void limpiarLabels(){
        vacioDia.setText("");
        vacioHora.setText("");
        vacioDuracion.setText("");
        vacioAlumnos.setText("");
        vacioEmail.setText("");
        vacioDocente.setText("");
        vacioCatedra.setText("");
        vacioAula.setText("");
        vacioPeriodo.setText("");
        
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
        JOptionPane.showMessageDialog(null, "EN LA LISTA DE RESERVAS YA HAY RESREVAS PARA ESE DIA EN ESE PERIODO. CONFIRME E INTENTE NUEVAMENTE.","¡ALGO SALIO MAL!",
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
    
    public void actualizarTabla(){
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tabla.getModel();
        Iterator<ReservaPDTO> iterador = reservasNoConfirmadas.iterator();
        model.setRowCount(0);
        while (iterador.hasNext()) {
            ReservaPDTO siguiente = iterador.next();
            String dia = siguiente.getDia();
            String periodo = siguiente.getPeriodo().toUpperCase();
            String hora = siguiente.getHoraInicio().getHours() + ":" + siguiente.getHoraInicio().getMinutes();
            if(siguiente.getHoraInicio().getMinutes() == 0){
                hora = hora + "0";
            }
            String datos = "RESERVÓ EL AULA " + siguiente.getAula().getNumero() + " PARA LOS DIAS " + dia + " EN EL PERIODO " + periodo + "  A LAS " + hora + " HS";

            model.addRow(new Object[]{datos,null}); // Agregar datos y texto del botón
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarAula;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField cantAlumnos;
    private javax.swing.JComboBox<String> catedra;
    private javax.swing.JButton confirmar1;
    private javax.swing.JComboBox<String> docente;
    private javax.swing.JTextField duracion;
    private javax.swing.JTextField email;
    private javax.swing.ButtonGroup grupoDias;
    private javax.swing.JTextField horaInicio;
    private javax.swing.JLabel horarioInicio;
    private javax.swing.JButton indicacionHora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JRadioButton jueves;
    private javax.swing.JRadioButton lunes;
    private javax.swing.JRadioButton martes1;
    private javax.swing.JRadioButton miercoles;
    private javax.swing.JComboBox<String> periodo;
    private javax.swing.JRadioButton sabado;
    private javax.swing.JTable tabla;
    private javax.swing.JComboBox<String> tipoAula;
    private javax.swing.JLabel vacioAlumnos;
    private javax.swing.JLabel vacioAula;
    private javax.swing.JLabel vacioCatedra;
    private javax.swing.JLabel vacioDia;
    private javax.swing.JLabel vacioDocente;
    private javax.swing.JLabel vacioDuracion;
    private javax.swing.JLabel vacioEmail;
    private javax.swing.JLabel vacioHora;
    private javax.swing.JLabel vacioPeriodo;
    private javax.swing.JRadioButton viernes;
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
