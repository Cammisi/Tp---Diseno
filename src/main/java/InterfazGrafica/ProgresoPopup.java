
package InterfazGrafica;
import javax.swing.JDialog;
import javax.swing.*;
import java.awt.*;

public class ProgresoPopup extends JDialog {
    private JProgressBar progressBar;
    private JLabel porcentajeLabel;

    public ProgresoPopup(Frame owner) {
        super(owner, "Buscando Aulas...", true); // Modal
        setLayout(new BorderLayout());

        // Texto en la parte superior
        JLabel titleLabel = new JLabel("BUSCANDO AULAS...", JLabel.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(titleLabel, BorderLayout.NORTH);

        // Barra de progreso
        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setPreferredSize(new Dimension(300, 15)); // Altura reducida a la mitad
        progressBar.setStringPainted(false); // Oculta el porcentaje predeterminado
        
        // Cambia el color de la barra a verde
        progressBar.setForeground(new Color(34, 139, 34)); // Color verde (puedes ajustarlo)
        
        // Panel personalizado para bordes "redondeados" simulados
        JPanel progressPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.BLACK);
                g2.drawRoundRect(10, 10, getWidth() - 20, getHeight() - 20, 20, 20); // Borde
            }
        };
        progressPanel.setLayout(new BorderLayout());
        progressPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        progressPanel.add(progressBar, BorderLayout.CENTER);

        add(progressPanel, BorderLayout.CENTER);

        // Label para el porcentaje debajo de la barra de progreso
        porcentajeLabel = new JLabel("0%", JLabel.CENTER);
        porcentajeLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(porcentajeLabel, BorderLayout.SOUTH);

        setSize(350, 150);
        setLocationRelativeTo(owner); // Centra el popup respecto a la ventana principal
    }

    // Método para actualizar el progreso
    public void actualizarProgreso(int progreso) {
        progressBar.setValue(progreso);
        porcentajeLabel.setText(progreso + "%");
        if (progreso >= 100) {
            dispose(); // Cierra el popup cuando llega al 100%
        }
    }

    // Método para simular la tarea de progreso
    public void iniciarSimulacion() {
        new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(50); // Simula el tiempo de progreso
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                actualizarProgreso(i);
            }
        }).start();
    }
}
