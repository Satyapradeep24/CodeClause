package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Hospital Information System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton patientButton = new JButton("Manage Patients");
        JButton doctorButton = new JButton("Manage Doctors");
        JButton appointmentButton = new JButton("Manage Appointments");
        JButton exitButton = new JButton("Exit");

        // Add buttons to the frame
        add(patientButton);
        add(doctorButton);
        add(appointmentButton);
        add(exitButton);

        // Open Patient Form
        patientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PatientForm();
            }
        });

        // Open Doctor Form
        doctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DoctorForm();
            }
        });

        // Open Appointment Form
        appointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AppointmentForm();
            }
        });

        // Exit Application
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
