package ua.com.alevel.form;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import ua.com.alevel.entity.Task;
import ua.com.alevel.service.TaskService;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.*;

public class MainScreen extends JFrame {
    private JPanel mainPanel;
    private JPanel panelWithTasks;
    private JLabel invitationLabel;
    private JButton goToSelectedTaskButton;
    private JComboBox<String> selectionTaskComboBox;
    private JLabel taskDescriptionLabel;
    private JPanel taskPanel;
    private JTextField inputTextField;
    private JLabel taskResultLabel;
    private JLabel currentTaskDescriptionLabel;
    private JButton resultButton;
    private JButton comeBackButton;
    private JButton clearResultButton;
    Map<Task, TaskService> tasks;
    private TaskService currentTaskService;

    public MainScreen(String title, Map<Task, TaskService> tasks) {
        super(title);
        this.tasks = tasks;
        this.panelWithTasks.setVisible(true);
        this.taskPanel.setVisible(false);
        initTaskComboBox(tasks.keySet());
        listenComponents();
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    private void initTaskComboBox(Set<Task> tasks) {
        tasks.stream()
                .sorted(Comparator.comparing(Task::getId))
                .forEach(task -> {
                    if (task.getId() == 0) this.taskDescriptionLabel.setText(task.getDescription());
                    this.selectionTaskComboBox.addItem(task.getName());
                });
    }

    private void listenComponents() {
        this.selectionTaskComboBox.addActionListener(e -> {
            String selectedTaskName = (String) selectionTaskComboBox.getSelectedItem();
            Task currentTask = getCurrentTaskByName(selectedTaskName).get();
            taskDescriptionLabel.setText(currentTask.getDescription());
        });
        goToSelectedTaskButton.addActionListener(e -> {
            getCurrentTaskByName((String) this.selectionTaskComboBox.getSelectedItem()).ifPresent(task -> {
                this.panelWithTasks.setVisible(false);
                this.taskPanel.setVisible(true);
                currentTaskDescriptionLabel.setText(task.getDescription());
                this.currentTaskService = this.tasks.get(task);
            });
        });
        resultButton.addActionListener(e -> {
            String result = this.currentTaskService.getSolutionForTaskByString(this.inputTextField.getText());
            this.taskResultLabel.setText(result);
        });
        comeBackButton.addActionListener(e -> {
            this.currentTaskService = null;
            this.inputTextField.setText("");
            this.currentTaskDescriptionLabel.setText("");
            this.taskResultLabel.setText("");
            this.panelWithTasks.setVisible(true);
            this.taskPanel.setVisible(false);
        });
        clearResultButton.addActionListener(e -> {
            this.taskResultLabel.setText("");
        });
    }

    public Optional<Task> getCurrentTaskByName(String taskName) {
        return this.tasks.keySet()
                .stream()
                .filter(task -> task.getName().equals(taskName))
                .findFirst();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.setMinimumSize(new Dimension(-1, -1));
        mainPanel.setPreferredSize(new Dimension(700, 500));
        mainPanel.setRequestFocusEnabled(true);
        taskPanel = new JPanel();
        taskPanel.setLayout(new GridLayoutManager(3, 2, new Insets(20, 20, 20, 20), -1, -1));
        taskPanel.setVisible(true);
        mainPanel.add(taskPanel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        currentTaskDescriptionLabel = new JLabel();
        currentTaskDescriptionLabel.setText("");
        taskPanel.add(currentTaskDescriptionLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        inputTextField = new JTextField();
        taskPanel.add(inputTextField, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        taskResultLabel = new JLabel();
        taskResultLabel.setText("");
        taskPanel.add(taskResultLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        resultButton = new JButton();
        resultButton.setText("Get Result");
        taskPanel.add(resultButton, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comeBackButton = new JButton();
        comeBackButton.setText("Come Back");
        taskPanel.add(comeBackButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        clearResultButton = new JButton();
        clearResultButton.setText("Clear Result");
        taskPanel.add(clearResultButton, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panelWithTasks = new JPanel();
        panelWithTasks.setLayout(new GridLayoutManager(4, 1, new Insets(20, 20, 20, 20), -1, -1));
        panelWithTasks.setEnabled(true);
        panelWithTasks.setMinimumSize(new Dimension(500, 300));
        panelWithTasks.setVisible(true);
        mainPanel.add(panelWithTasks, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(344, 344), null, 0, false));
        invitationLabel = new JLabel();
        invitationLabel.setBackground(new Color(-8785263));
        Font invitationLabelFont = this.$$$getFont$$$("Berlin Sans FB Demi", Font.PLAIN, 36, invitationLabel.getFont());
        if (invitationLabelFont != null) invitationLabel.setFont(invitationLabelFont);
        invitationLabel.setForeground(new Color(-904627));
        invitationLabel.setText("Hello and Welcome");
        panelWithTasks.add(invitationLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 50), null, null, 0, false));
        goToSelectedTaskButton = new JButton();
        goToSelectedTaskButton.setText("Go to");
        panelWithTasks.add(goToSelectedTaskButton, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        taskDescriptionLabel = new JLabel();
        taskDescriptionLabel.setEnabled(true);
        taskDescriptionLabel.setFocusable(true);
        taskDescriptionLabel.setHorizontalTextPosition(11);
        taskDescriptionLabel.setInheritsPopupMenu(true);
        taskDescriptionLabel.setText("");
        taskDescriptionLabel.setVisible(true);
        panelWithTasks.add(taskDescriptionLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        selectionTaskComboBox = new JComboBox();
        selectionTaskComboBox.setToolTipText("");
        panelWithTasks.add(selectionTaskComboBox, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(300, 20), null, null, 0, false));
        taskDescriptionLabel.setLabelFor(selectionTaskComboBox);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}
