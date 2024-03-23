package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI {
    private JFrame frame;
    private JTextField textField;
    private JTextArea textArea;
    private RegistroVacunas registro;

    public GUI() {
        registro = new RegistroVacunas();
        frame = new JFrame("Registro de vacunas");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }

    public void placeComponents(JPanel panel) {
        panel.setLayout(null);
        JLabel label = new JLabel("Ingrese el CUI:");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);
        textField = new JTextField(20);
        textField.setBounds(100, 20, 165, 25);
        panel.add(textField);
        JButton button = new JButton("Buscar");
        button.setBounds(10, 50, 80, 25);
        panel.add(button);

        String[] columnNames = {"CUI", "Vacuna", "Fecha"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 80, 300, 200);
        panel.add(scrollPane);

        button.addActionListener(e -> {
            String cui = textField.getText();
            Persona persona = registro.obtenerPersona(cui);
            tableModel.setRowCount(0); // Limpia la tabla
            if (persona != null) {
                for (Vacuna vacuna : persona.getVacunas()) {
                    Object[] rowData = {cui, vacuna.getVacuna(), vacuna.getFecha()};
                    tableModel.addRow(rowData);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "No se encontró la persona");
            }
        });
    }

    public static void main(String[] args) {
        new GUI();
    }
}
