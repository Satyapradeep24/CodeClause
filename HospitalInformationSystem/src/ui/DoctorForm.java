package ui;

import models.Doctor;
import services.DoctorService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DoctorForm extends JFrame {
    private final DoctorService doctorService;
    private JTextField nameField, specializationField, contactField;
    private JTextArea displayArea;

    public DoctorForm() {
        doctorService = new DoctorService();
        setTitle("Doctor Management");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Specialization:"));
        specializationField = new JTextField();
        inputPanel.add(specializationField);

        inputPanel.add(new JLabel("Contact:"));
        contactField = new JTextField();
        inputPanel.add(contactField);

        JButton addButton = new JButton("Add Doctor");
        inputPanel.add(addButton);

        JButton viewButton = new JButton("View Doctors");
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
                addDoctor();
            }
        });

        // View Button Action
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayDoctors();
            }
        });

        setVisible(true);
    }

    private void addDoctor() {
        String name = nameField.getText();
        String specialization = specializationField.getText();
        String contact = contactField.getText();

        Doctor doctor = new Doctor(0, name, specialization, contact);
        if (doctorService.addDoctor(doctor)) {
            JOptionPane.showMessageDialog(this, "Doctor added successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Error adding doctor!");
        }
    }

    private void displayDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        StringBuilder sb = new StringBuilder();
        for (Doctor d : doctors) {
            sb.append("ID: ").append(d.getId()).append(", Name: ").append(d.getName())
              .append(", Specialization: ").append(d.getSpecialization())
              .append(", Contact: ").append(d.getContact()).append("\n");
        }
        displayArea.setText(sb.toString());
    }
}

