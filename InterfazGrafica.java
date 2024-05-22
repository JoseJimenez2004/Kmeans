import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class InterfazGrafica extends JFrame implements ActionListener {
    private JLabel imagenLabel;
    private JButton kmeansButton, cargarButton, salirButton;
    private BufferedImage imagen;

    public InterfazGrafica() {
        // Configuración de la ventana
        setTitle("Interfaz Gráfica");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para la imagen
        imagenLabel = new JLabel();
        imagenLabel.setHorizontalAlignment(JLabel.CENTER);
        add(imagenLabel, BorderLayout.CENTER);

        // Panel para los botones
        JPanel botonesPanel = new JPanel();
        kmeansButton = new JButton("KMeans");
        cargarButton = new JButton("Cargar otra imagen");
        salirButton = new JButton("Salir");

        kmeansButton.addActionListener(this);
        cargarButton.addActionListener(this);
        salirButton.addActionListener(this);

        botonesPanel.add(kmeansButton);
        botonesPanel.add(cargarButton);
        botonesPanel.add(salirButton);
        add(botonesPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == kmeansButton) {
            // Aquí puedes agregar la lógica para el algoritmo KMeans
            JOptionPane.showMessageDialog(this, "Función KMeans aún no implementada", "KMeans", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == cargarButton) {
            // Abrir diálogo para cargar imagen
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showOpenDialog(this);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    imagen = ImageIO.read(file);
                    ImageIcon imageIcon = new ImageIcon(imagen.getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_SMOOTH));
                    imagenLabel.setIcon(imageIcon);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error al cargar la imagen", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getSource() == salirButton) {
            // Salir de la aplicación
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfazGrafica interfaz = new InterfazGrafica();
            interfaz.setVisible(true);
        });
    }
}

