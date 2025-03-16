

import ui.MainFrame;
import database.DatabaseConnection;
import javax.swing.*;

public class HospitalSystem {
    public static void main(String[] args) {
        // Ensure database connection is initialized
        DatabaseConnection.getConnection();
        
        // Launch the main UI
        SwingUtilities.invokeLater(() -> new MainFrame());
    }
}
