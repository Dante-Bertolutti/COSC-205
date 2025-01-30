import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MainGui extends JFrame {
    private User activeUser;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainGui() {
        // Set up main frame
        setTitle("Gains R us");
        setSize(300, 300); // Larger size for the dashboard
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centers the window
        
        // Create the main panel with CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add login panel to main panel
        mainPanel.add(createLoginPanel(), "LoginPanel");

        // Add main panel to frame
        add(mainPanel);
        setVisible(true);
        
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setForeground(Color.WHITE);
           }

    // Create login panel
    	private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        
        //add space above welcomeLabel
        loginPanel.add(Box.createVerticalStrut(50)); // Adds 50px space

        // Welcome message
        JLabel welcomeLabel = new JLabel("Gains R Us", SwingConstants.CENTER);
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginPanel.add(welcomeLabel);

        // MAKE welcome label white
        welcomeLabel.setForeground(Color.WHITE);
        
        //Change font and sizing of welcomeLabel
        Font welcomeFont = new Font("Serif", Font.BOLD, 24); // Font(name, style, size)
        welcomeLabel.setFont(welcomeFont);
        // Add vertical space
        loginPanel.add(Box.createVerticalStrut(55));

        // Login and create account buttons
        JButton loginButton = new JButton("Login");
        JButton createButton = new JButton("Create Account");

        //color change
        createButton.setBackground(Color.WHITE);
        createButton.setForeground(Color.BLACK);

        loginButton.setBackground(Color.WHITE);
        loginButton.setForeground(Color.BLACK);

        //change panel color
        loginPanel.setBackground(Color.BLACK);
        loginPanel.setForeground(Color.WHITE);
        
        // Set preferred size for buttons
        loginButton.setPreferredSize(new Dimension(150, 30));
        createButton.setPreferredSize(new Dimension(150, 30));

        // Center buttons horizontally
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        createButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginPanel.add(loginButton);
        loginPanel.add(Box.createVerticalStrut(10));
        loginPanel.add(createButton);

        // Add action listeners to buttons
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to create account panel
                mainPanel.add(createAccountPanel(), "CreateAccountPanel");
                cardLayout.show(mainPanel, "CreateAccountPanel");
            }
        });

        return loginPanel;
    }

    // Create account creation panel
    private JPanel createAccountPanel() {
        JPanel accountPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Labels and fields for account creation
        JLabel nameLabel = new JLabel("Enter your name:");
        JTextField nameField = new JTextField(15);
        JLabel caloriesLabel = new JLabel("Set maintenance calories:");
        JTextField caloriesField = new JTextField(15);
        JButton submitButton = new JButton("Submit");
        
        //Change color
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
 
        // Add name label and field
        gbc.gridx = 0;
        gbc.gridy = 0;
        accountPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        accountPanel.add(nameField, gbc);

        // Add calories label and field
        gbc.gridx = 0;
        gbc.gridy = 1;
        accountPanel.add(caloriesLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        accountPanel.add(caloriesField, gbc);

        // Add submit button
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        accountPanel.add(submitButton, gbc);

        // Handle submit button click
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String caloriesText = caloriesField.getText().trim();

                if (name.isEmpty() || caloriesText.isEmpty()) {
                    JOptionPane.showMessageDialog(MainGui.this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int maintenanceCalories = Integer.parseInt(caloriesText);
                    User newUser = new User();
                    newUser.setName(name);
                    newUser.setMaintenanceCalories(maintenanceCalories);
                    User.saveUser(newUser);

                    JOptionPane.showMessageDialog(MainGui.this, "Account created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    // Switch back to login panel
                    cardLayout.show(mainPanel, "LoginPanel");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainGui.this, "Please enter a valid number for maintenance calories.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        return accountPanel;
    }

    // Handle login
    private void handleLogin() {
        String username = JOptionPane.showInputDialog(this, "Enter your name:");
        if (username == null || username.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(username + ".ser"))) {
            activeUser = (User) ois.readObject();
            JOptionPane.showMessageDialog(this, "Welcome " + activeUser.getName(), "Login Successful", JOptionPane.INFORMATION_MESSAGE);

            // Switch to the dashboard panel
            mainPanel.add(createDashboardPanel(), "DashboardPanel");
            cardLayout.show(mainPanel, "DashboardPanel");
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "User does not exist. Would you like to create an account?", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Create dashboard panel
    private JPanel createDashboardPanel() {
        JPanel dashboardPanel = new JPanel(new BorderLayout());

        // Create a tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Add tabs
        tabbedPane.addTab("Workout", createWorkoutPanel());
        tabbedPane.addTab("Goal", createGoalPanel());
        tabbedPane.addTab("Food", createFoodPanel());
        tabbedPane.addTab("Exercise", createExercisePanel());

        // Add tabbed pane to dashboard panel
        dashboardPanel.add(tabbedPane, BorderLayout.CENTER);

        //color to GUI
        tabbedPane.setBackground(Color.BLACK);
        tabbedPane.setForeground(Color.WHITE);
        return dashboardPanel;
    }

    // Create workout panel
    private JPanel createWorkoutPanel() {
        JPanel workoutPanel = new JPanel();
        workoutPanel.setPreferredSize(new Dimension(200, 100));
        workoutPanel.add(Box.createVerticalStrut(230)); 
        JButton workoutButton = new JButton("Click to Log Workout");
       
        //Color to Button
        workoutButton.setBackground(Color.BLACK);
        workoutButton.setForeground(Color.WHITE);
        
        // Add Click Listener
        workoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Workout.createWorkout(activeUser);
            }
        });
        
        workoutPanel.add(workoutButton);
        
            return workoutPanel;
    }

    // Create goal panel
    private JPanel createGoalPanel() {
        JPanel goalPanel = new JPanel();
        goalPanel.setLayout(new BoxLayout(goalPanel, BoxLayout.Y_AXIS));

        // Title for the Goal Panel
        JLabel titleLabel = new JLabel("Goal Management");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        goalPanel.add(titleLabel);

        // Add vertical space
        goalPanel.add(Box.createVerticalStrut(20));

        // Input fields for goal creation
        JTextField titleField = new JTextField(15);
        JTextField weightField = new JTextField(15);
        JTextField caloriesField = new JTextField(15);
        JTextField endDateField = new JTextField(15);

        // Labels for input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 5, 5));
        inputPanel.add(new JLabel("Goal Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Target Weight:"));
        inputPanel.add(weightField);
        inputPanel.add(new JLabel("Target Calories:"));
        inputPanel.add(caloriesField);
        inputPanel.add(new JLabel("End Date (yyyy-MM-dd):"));
        inputPanel.add(endDateField);

        // Center the input panel
        inputPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        goalPanel.add(inputPanel);

        // Add vertical space
        goalPanel.add(Box.createVerticalStrut(20));

        // Button to submit the goal
        JButton submitButton = new JButton("Submit Goal");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.setPreferredSize(new Dimension(150, 30)); // Same size as other buttons

        //Color to button
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
       
        // Action listener for the button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText().trim();
                String weightText = weightField.getText().trim();
                String caloriesText = caloriesField.getText().trim();
                String endDateText = endDateField.getText().trim();

                if (title.isEmpty() || weightText.isEmpty() || caloriesText.isEmpty() || endDateText.isEmpty()) {
                    JOptionPane.showMessageDialog(MainGui.this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int weight = Integer.parseInt(weightText);
                    int calories = Integer.parseInt(caloriesText);
                    java.util.Date utilEndDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateText);
                    java.sql.Date sqlEndDate = new java.sql.Date(utilEndDate.getTime());

                    Goal newGoal = new Goal(sqlEndDate, title, false, weight, calories);

                    // Save goal to active user
                    activeUser.addGoal(newGoal); // Add a method in your User class to add a goal

                    JOptionPane.showMessageDialog(MainGui.this, "Goal created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    // Clear the fields after adding goal
                    titleField.setText("");
                    weightField.setText("");
                    caloriesField.setText("");
                    endDateField.setText("");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainGui.this, "Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(MainGui.this, "Please enter a valid date.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        goalPanel.add(submitButton);

        return goalPanel;
    }

    // Create food panel
    private JPanel createFoodPanel() {
        JPanel foodPanel = new JPanel();
        foodPanel.setLayout(new BoxLayout(foodPanel, BoxLayout.Y_AXIS));

        // Title for the Food Panel
        JLabel titleLabel = new JLabel("Food Management");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        foodPanel.add(titleLabel);

        // Add vertical space
        foodPanel.add(Box.createVerticalStrut(20));

        // Input fields for food details
        JTextField nameField = new JTextField(15);
        JTextField idField = new JTextField(15);
        JTextField caloriesField = new JTextField(15);
        JTextField proteinField = new JTextField(15);

        // Labels for input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 5, 5));
        inputPanel.add(new JLabel("Food Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Food ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Calories:"));
        inputPanel.add(caloriesField);
        inputPanel.add(new JLabel("Protein:"));
        inputPanel.add(proteinField);

        // Center the input panel
        inputPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        foodPanel.add(inputPanel);

        // Add vertical space
        foodPanel.add(Box.createVerticalStrut(20));

        // Button to submit the food
        JButton addFoodButton = new JButton("Add Food");
        addFoodButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addFoodButton.setPreferredSize(new Dimension(150, 30)); // Same size as Goal button

        //Color to GUI
        addFoodButton.setBackground(Color.BLACK);
        addFoodButton.setForeground(Color.WHITE);
        
        // Action listener for the button
        addFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validate the fields and create a new Food object
                String name = nameField.getText().trim();
                String idText = idField.getText().trim();
                String caloriesText = caloriesField.getText().trim();
                String proteinText = proteinField.getText().trim();

                if (name.isEmpty() || idText.isEmpty() || caloriesText.isEmpty() || proteinText.isEmpty()) {
                    JOptionPane.showMessageDialog(MainGui.this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int id = Integer.parseInt(idText);
                    int calories = Integer.parseInt(caloriesText);
                    int protein = Integer.parseInt(proteinText);

                    Food newFood = new Food(name, id, calories, protein);

                    // Add the food to some list 
                    JOptionPane.showMessageDialog(MainGui.this, "Food added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    // Clear the fields after adding food
                    nameField.setText("");
                    idField.setText("");
                    caloriesField.setText("");
                    proteinField.setText("");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainGui.this, "Please enter valid numbers for ID, Calories, and Protein.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        foodPanel.add(addFoodButton);

        return foodPanel;
  
    }

    // Create exercise panel
    private JPanel createExercisePanel() {
        JPanel exercisePanel = new JPanel();
        exercisePanel.setLayout(new BoxLayout(exercisePanel, BoxLayout.Y_AXIS));

        // Title for the Exercise Panel
        JLabel titleLabel = new JLabel("Exercise Management");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        exercisePanel.add(titleLabel);

        // Add vertical space
        exercisePanel.add(Box.createVerticalStrut(20));

        // Input fields for exercise details
        JTextField nameField = new JTextField(15);
        JTextField caloriesBurnedField = new JTextField(15);

        // Labels for input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2, 5, 20));
        inputPanel.add(new JLabel("Exercise Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Calories Burned:"));
        inputPanel.add(caloriesBurnedField);

        // Center the input panel
        inputPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        exercisePanel.add(inputPanel);

        // Add vertical space
        exercisePanel.add(Box.createVerticalStrut(20));

        // Button to submit the exercise
        JButton addExerciseButton = new JButton("Add Exercise");
        addExerciseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addExerciseButton.setPreferredSize(new Dimension(150, 30)); // Same size as Goal button

        //CHANGE COLOR
        addExerciseButton.setBackground(Color.BLACK);
        addExerciseButton.setForeground(Color.WHITE);
        
        // Action listener for the button
        addExerciseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText().trim();
                    double caloriesBurned = Double.parseDouble(caloriesBurnedField.getText().trim());

                    // Create a new Exercise object (replace with your Exercise class logic)
                    // Exercise exercise = new StrengthExercise(name, caloriesBurned);
                    // exerciseList.add(exercise);

                    JOptionPane.showMessageDialog(MainGui.this, "Exercise added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    // Clear the fields after adding exercise
                    nameField.setText("");
                    caloriesBurnedField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainGui.this, "Please enter a valid number for Calories Burned.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        exercisePanel.add(addExerciseButton);

        return exercisePanel;
    }

    public static void main(String[] args) {
        // Run the GUI on the event dispatch thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGui();
            }
        });
    }
}
