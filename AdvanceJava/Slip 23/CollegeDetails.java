import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CollegeDetails extends JFrame {
    private JTable table;

    public CollegeDetails() {
        setTitle("College Details");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create table model with column names
        String[] columns = {"CID", "CName", "Address", "Year"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        // Add data to table model
        model.addRow(new Object[]{1, "ABC College", "123 Main St", 2022});
        model.addRow(new Object[]{2, "XYZ College", "456 Elm St", 2023});

        // Create JTable with model
        table = new JTable(model);

        // Add table to JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CollegeDetails());
    }
}
