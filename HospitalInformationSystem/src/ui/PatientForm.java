package ui;

import models.Patient;
import services.PatientService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PatientForm extends JFrame {
    private final PatientService patientService;
    private JTextField nameField, ageField, genderField, contactField;
    private JTextArea displayArea;

    public PatientForm() {
        patientService = new PatientService();
        setTitle("Patient Management");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("Gender:"));
        genderField = new JTextField();
        inputPanel.add(genderField);

        inputPanel.add(new JLabel("Contact:"));
        contactField = new JTextField();
        inputPanel.add(contactField);

        JButton addButton = new JButton("Add Patient");
        inputPanel.add(addButton);

        JButton viewButton = new JButton("View Patients");
        inputPanel.add(viewButton);

        add(inputPanel, BorderLayout.NORTH);

        // Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Add Button Action
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPatient();
            }
        });

        // View Button Action
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPatients();
            }
        });

        setVisible(true);
    }

    private void addPatient() {
        String name = nameField.getText();
        int age;
        try {
            age = Integer.parseInt(ageField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid age!");
            return;
        }
        String gender = genderField.getText();
        String contact = contactField.getText();

        Patient patient = new Patient(0, name, age, gender, contact, null);
        if (patientService.addPatient(patient)) {
            JOptionPane.showMessageDialog(this, "Patient added successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Error adding patient!");
        }
    }

    private void displayPatients() {
        List<Patient> patients = patientService.getAllPatients();
        StringBuilder sb = new StringBuilder();
        for (Patient p : patients) {
            sb.append("ID: ").append(p.getId()).append(", Name: ").append(p.getName())
              .append(", Age: ").append(p.getAge()).append(", Gender: ").append(p.getGender())
              .append(", Contact: ").append(p.getContact()).append("\n");
        }
        displayArea.setText(sb.toString());
    }
}
