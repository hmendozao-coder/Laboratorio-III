/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
/**
 *
 * @author Usuario
 */
public class FrmMemoria extends javax.swing.JFrame {
    
 ArrayList<NodoMemoria> memoria;

    int contadorProcesos = 0;

    public FrmMemoria() {

        initComponents();

        memoria = new ArrayList<>();

        generarMemoria();

        actualizarMemoria();
    }

    private void generarMemoria() {

        Random r = new Random();

        for (int i = 1; i <= 6; i++) {

            int tamaño = r.nextInt(120) + 10;

            memoria.add(new NodoMemoria(i, tamaño));
        }
    }

    private void actualizarMemoria() {

        txtArea.setText("");

        int usada = 0;
        int libre = 0;

        for (NodoMemoria n : memoria) {

            txtArea.append(n.toString() + "\n");

            if (n.isOcupado()) {

                usada += n.getTamaño();

            } else {

                libre += n.getTamaño();
            }
        }

        lblDisponible.setText("Memoria disponible: " + libre + " MB");

        lblUso.setText("Memoria en uso: " + usada + " MB");

        lblProcesos.setText("Total de procesos: " + contadorProcesos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtEspacio = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        lblDisponible = new javax.swing.JLabel();
        lblUso = new javax.swing.JLabel();
        lblProcesos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Memoria Dinamica");

        jLabel1.setText("Espacio (MB):");

        btnAgregar.setText("Agregar");

        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtArea.setColumns(20);
        txtArea.setRows(5);

        jScrollPane1.setViewportView(txtArea);

        lblDisponible.setText("Memoria disponible:");

        lblUso.setText("Memoria en uso:");

        lblProcesos.setText("Total de procesos:");

        javax.swing.GroupLayout layout =
                new javax.swing.GroupLayout(getContentPane());

        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)

                .addGroup(layout.createParallelGroup(
                        javax.swing.GroupLayout.Alignment.LEADING)

                    .addComponent(jScrollPane1,
                            javax.swing.GroupLayout.PREFERRED_SIZE,
                            350,
                            javax.swing.GroupLayout.PREFERRED_SIZE)

                    .addGroup(layout.createSequentialGroup()

                        .addComponent(jLabel1)

                        .addGap(18, 18, 18)

                        .addComponent(txtEspacio,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                100,
                                javax.swing.GroupLayout.PREFERRED_SIZE)

                        .addGap(18, 18, 18)

                        .addComponent(btnAgregar))

                    .addComponent(lblDisponible)
                    .addComponent(lblUso)
                    .addComponent(lblProcesos))

                .addContainerGap(25, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

            .addGroup(layout.createSequentialGroup()

                .addGap(20, 20, 20)

                .addComponent(lblDisponible)

                .addGap(10, 10, 10)

                .addGroup(layout.createParallelGroup(
                        javax.swing.GroupLayout.Alignment.BASELINE)

                    .addComponent(jLabel1)
                    .addComponent(txtEspacio,
                            javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE)

                    .addComponent(btnAgregar))

                .addGap(18, 18, 18)

                .addComponent(lblProcesos)

                .addGap(10, 10, 10)

                .addComponent(lblUso)

                .addGap(18, 18, 18)

                .addComponent(jScrollPane1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        180,
                        javax.swing.GroupLayout.PREFERRED_SIZE)

                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();

        setLocationRelativeTo(null);
    }

    // </editor-fold>

    private void btnAgregarActionPerformed(
            java.awt.event.ActionEvent evt) {

        if (txtEspacio.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese un tamaño");

            return;
        }

        int tamaño = Integer.parseInt(txtEspacio.getText());

        boolean asignado = false;

        for (NodoMemoria n : memoria) {

            if (!n.isOcupado()
                    && n.getTamaño() >= tamaño) {

                contadorProcesos++;

                n.asignarProceso(
                        "P" + contadorProcesos);

                asignado = true;

                break;
            }
        }

        if (!asignado) {

            JOptionPane.showMessageDialog(
                    this,
                    "No existe espacio suficiente");
        }

        actualizarMemoria();

        txtEspacio.setText("");
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new FrmMemoria().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton btnAgregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDisponible;
    private javax.swing.JLabel lblProcesos;
    private javax.swing.JLabel lblUso;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtEspacio;
}
