import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainGUI extends JFrame {

    private JTextField nameField, idField, totalHoursField;
    private JTextField subjectNameField, subjectHoursField, subjectGradeField;
    private JTextArea displayArea;

    private ArrayList<String> subjectNames = new ArrayList<>();
    private ArrayList<Integer> creditHours = new ArrayList<>();
    private ArrayList<Double> grades = new ArrayList<>();

    public MainGUI() {
    	setForeground(new Color(64, 0, 64));

        setTitle("Student GPA Calculator");
        setSize(750, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // === Student Info ===
        JPanel topPanel = new JPanel();
        topPanel.setBounds(0, 0, 736, 88);
        topPanel.setBorder(BorderFactory.createTitledBorder("Student Info"));

        nameField = new JTextField();
        nameField.setBounds(232, 15, 359, 19);
        idField = new JTextField();
        idField.setBounds(232, 39, 359, 19);
        totalHoursField = new JTextField();
        totalHoursField.setBounds(232, 63, 359, 19);
        topPanel.setLayout(null);

        JLabel label = new JLabel("Student Name:");
        label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label.setBounds(37, 15, 102, 19);
        topPanel.add(label);
        topPanel.add(nameField);
        JLabel label_1 = new JLabel("Student ID:");
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_1.setBounds(37, 39, 102, 19);
        topPanel.add(label_1);
        topPanel.add(idField);
        JLabel label_2 = new JLabel("Total Registered Hours:");
        label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_2.setBounds(37, 63, 185, 19);
        topPanel.add(label_2);
        topPanel.add(totalHoursField);

        getContentPane().add(topPanel);

        // === Subject Panel ===
        JPanel subjectPanel = new JPanel();
        subjectPanel.setBounds(0, 88, 191, 444);
        subjectPanel.setBorder(BorderFactory.createTitledBorder("Add Subject"));

        subjectNameField = new JTextField();
        subjectNameField.setBounds(98, 15, 87, 102);
        subjectHoursField = new JTextField();
        subjectHoursField.setBounds(98, 122, 87, 102);
        subjectGradeField = new JTextField();
        subjectGradeField.setBounds(98, 229, 87, 102);

        JButton addSubjectBtn = new JButton("Add Subject");
        addSubjectBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        addSubjectBtn.setBounds(6, 353, 175, 70);
        subjectPanel.setLayout(null);

        JLabel label_3 = new JLabel("Subject Name:");
        label_3.setForeground(new Color(0, 0, 0));
        label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
        label_3.setBounds(6, 15, 87, 102);
        subjectPanel.add(label_3);
        subjectPanel.add(subjectNameField);
        JLabel label_4 = new JLabel("Credit Hours:");
        label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
        label_4.setBounds(6, 122, 87, 102);
        subjectPanel.add(label_4);
        subjectPanel.add(subjectHoursField);
        JLabel label_5 = new JLabel("Grade (0-100):");
        label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
        label_5.setBounds(6, 229, 87, 102);
        subjectPanel.add(label_5);
        subjectPanel.add(subjectGradeField);
        subjectPanel.add(addSubjectBtn);

        // نحطه على الشمال
        getContentPane().add(subjectPanel);

        // === Display ===
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(191, 88, 545, 444);
        getContentPane().add(scrollPane);

        // === Bottom Panel ===
        JButton calcBtn = new JButton("Calculate GPA");
        calcBtn.setFont(new Font("Tahoma", Font.BOLD, 10));
        calcBtn.setBounds(241, 5, 174, 21);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBounds(0, 532, 736, 31);
        bottomPanel.setLayout(null);
        bottomPanel.add(calcBtn);
        getContentPane().add(bottomPanel);

        // === Add Subject Action ===
        addSubjectBtn.addActionListener(e -> {
            try {
                String subjectName = subjectNameField.getText();
                int hours = Integer.parseInt(subjectHoursField.getText());
                double grade = Double.parseDouble(subjectGradeField.getText());

                subjectNames.add(subjectName);
                creditHours.add(hours);
                grades.add(grade);

                displayArea.append("Added: " + subjectName + " | Hours: " + hours + " | Grade: " + grade + "\n");

                subjectNameField.setText("");
                subjectHoursField.setText("");
                subjectGradeField.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Input!");
            }
        });

        // === Calculate GPA ===
        calcBtn.addActionListener(e -> {
            if (creditHours.size() == 0) {
                JOptionPane.showMessageDialog(this, "Add at least one subject!");
                return;
            }

            try {
                String name = nameField.getText();
                int id = Integer.parseInt(idField.getText());
                int totalHours = Integer.parseInt(totalHoursField.getText());

                double gpa = GPA_Calculator.calculateGPA(creditHours, grades);

                displayArea.append("\n==============================\n");
                displayArea.append("Student Name: " + name + "\n");
                displayArea.append("ID: " + id + "\n");
                displayArea.append("Total Hours: " + totalHours + "\n");
                displayArea.append("Final GPA: " + String.format("%.2f", gpa) + "\n");
                displayArea.append("==============================\n\n");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Check your inputs!");
            }
        });
    }

    public static void main(String[] args) {
        new MainGUI().setVisible(true);
    }
}
