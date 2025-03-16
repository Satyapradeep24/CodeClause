package ui;

import models.Appointment;
import services.AppointmentService;
import services.DoctorService;
import services.PatientService;
import models.Doctor;
import models.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AppointmentForm extends JFrame {
    private final AppointmentService appointmentService;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private JComboBox<String> patientDropdown, doctorDropdown, timeSlotDropdown;
    private JTextField dateField;
    private JTextArea displayArea;

    public AppointmentForm() {
        appointmentService = new AppointmentService();
        patientService = new PatientService();
        doctorService = new DoctorService();

        setTitle("Appointment Management");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        
        inputPanel.add(new JLabel("Select Patient:"));
        patientDropdown = new JComboBox<>();
        loadPatients();
        inputPanel.add(patientDropdown);

        inputPanel.add(new JLabel("Select Doctor:"));
        doctorDropdown = new JComboBox<>();
        loadDoctors();
        inputPanel.add(doctorDropdown);

        inputPanel.add(new JLabel("Date (YYYY-MM-DD):"));
        dateField = new JTextField();
        inputPanel.add(dateField);

        inputPanel.add(new JLabel("Select Time Slot:"));
        timeSlotDropdown = new JComboBox<>(new String[]{"09:00 AM", "12:00 PM", "03:00 PM"});
        inputPanel.add(timeSlotDropdown);

        JButton bookButton = new JButton("Book Appointment");
        inputPanel.add(bookButton);

        JButton viewButton = new JButton("View Appointments");
        inputPanel.add(viewButton);

        add(inputPanel, BorderLayout.NORTH);

        // Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Book Button Action
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookAppointment();
            }
        });

        // View Button Action
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAppointments();
            }
        });

        setVisible(true);
    }

    private void loadPatients() {
        List<Patient> patients = patientService.getAllPatients();
        for (Patient p : patients) {
            patientDropdown.addItem(p.getId() + " - " + p.getName());
        }
    }

    private void loadDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        for (Doctor d : doctors) {
            doctorDropdown.addItem(d.getId() + " - " + d.getName());
        }
    }

    private void bookAppointment() {
        try {
            int patientId = Integer.parseInt(patientDropdown.getSelectedItem().toString().split(" - ")[0]);
            int doctorId = Integer.parseInt(doctorDropdown.getSelectedItem().toString().split(" - ")[0]);
            LocalDate date = LocalDate.parse(dateField.getText());
            LocalTime time = LocalTime.parse(timeSlotDropdown.getSelectedItem().toString().replace(" AM", "").replace(" PM", ""));

            Appointment appointment = new Appointment(0, patientId, doctorId, date, time, "Scheduled");
            if (appointmentService.addAppointment(appointment)) {
                JOptionPane.showMessageDialog(this, "Appointment booked successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Error booking appointment!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please check your values.");
        }
    }

    private void displayAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        StringBuilder sb = new StringBuilder();
        for (Appointment a : appointments) {
            sb.append("ID: ").append(a.getId())
              .append(", Patient ID: ").append(a.getPatientId())
              .append(", Doctor ID: ").append(a.getDoctorId())
              .append(", Date: ").append(a.getDate())
              .append(", Time: ").append(a.getTime())
              .append(", Status: ").append(a.getStatus())
              .append("\n");
        }
        displayArea.setText(sb.toString());
    }
}
