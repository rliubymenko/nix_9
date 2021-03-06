package ua.com.alevel.controller;

import ua.com.alevel.entity.Car;
import ua.com.alevel.entity.Owner;
import ua.com.alevel.service.CarService;
import ua.com.alevel.service.OwnerService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class MainControllerForm extends javax.swing.JFrame {

    private final CarService carService;
    private final OwnerService ownerService;
    private Map<Integer, UUID> rowNumberWithOwnerUuid;
    private Map<Integer, UUID> rowNumberWithCarUuid;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JLabel brandLabel;
    private javax.swing.JTextField brandTextField;
    private javax.swing.JPanel carPanel;
    private javax.swing.JTable carTable;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JButton deleteCarButton;
    private javax.swing.JButton deleteOwnerButton;
    private javax.swing.JLabel fullNameLabel;
    private javax.swing.JTextField fullNameText;
    private javax.swing.JTextField fullNameTextField;
    private javax.swing.JButton insertCarButton;
    private javax.swing.JButton insertOwnerButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel modelLabel;
    private javax.swing.JTextField modelTextField;
    private javax.swing.JComboBox<String> ownerFullNameComboBox;
    private javax.swing.JLabel ownerFullNameLabel;
    private javax.swing.JPanel ownerPanel;
    private javax.swing.JTable ownerTable;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JTextField phoneNumberTextField;
    private javax.swing.JButton resetCarButton;
    private javax.swing.JButton resetOwnerButton;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JButton updateCarButton;
    private javax.swing.JButton updateOwnerButton;
    private javax.swing.JLabel yearLabel;

    public MainControllerForm(CarService carService, OwnerService ownerService, String title) {
        super(title);
        this.carService = carService;
        this.ownerService = ownerService;
        initComponents();
        showOwners();
        showCars();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fullNameTextField = new javax.swing.JTextField();
        tabbedPane = new javax.swing.JTabbedPane();
        ownerPanel = new javax.swing.JPanel();
        phoneNumberTextField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        insertOwnerButton = new javax.swing.JButton();
        resetOwnerButton = new javax.swing.JButton();
        updateOwnerButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ownerTable = new javax.swing.JTable();
        deleteOwnerButton = new javax.swing.JButton();
        fullNameLabel = new javax.swing.JLabel();
        phoneNumberLabel = new javax.swing.JLabel();
        fullNameText = new javax.swing.JTextField();
        carPanel = new javax.swing.JPanel();
        modelTextField = new javax.swing.JTextField();
        yearLabel = new javax.swing.JLabel();
        insertCarButton = new javax.swing.JButton();
        resetCarButton = new javax.swing.JButton();
        updateCarButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        carTable = new javax.swing.JTable();
        deleteCarButton = new javax.swing.JButton();
        brandLabel = new javax.swing.JLabel();
        modelLabel = new javax.swing.JLabel();
        brandTextField = new javax.swing.JTextField();
        ownerFullNameComboBox = new javax.swing.JComboBox<>();
        ownerFullNameLabel = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabbedPaneStateChanged(evt);
            }
        });

        addressLabel.setText("Address");

        insertOwnerButton.setText("Insert");
        insertOwnerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertOwnerButtonActionPerformed(evt);
            }
        });

        resetOwnerButton.setText("Reset");
        resetOwnerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetOwnerButtonActionPerformed(evt);
            }
        });

        updateOwnerButton.setText("Update");
        updateOwnerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateOwnerButtonActionPerformed(evt);
            }
        });

        ownerTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Full name", "Phone number", "Adress"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        ownerTable.getTableHeader().setReorderingAllowed(false);
        ownerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ownerTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ownerTable);

        deleteOwnerButton.setText("Delete");
        deleteOwnerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOwnerButtonActionPerformed(evt);
            }
        });

        fullNameLabel.setText("Full name");

        phoneNumberLabel.setText("Phone number");

        javax.swing.GroupLayout ownerPanelLayout = new javax.swing.GroupLayout(ownerPanel);
        ownerPanel.setLayout(ownerPanelLayout);
        ownerPanelLayout.setHorizontalGroup(
                ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ownerPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(ownerPanelLayout.createSequentialGroup()
                                                .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(phoneNumberLabel)
                                                        .addComponent(addressLabel)
                                                        .addComponent(fullNameLabel))
                                                .addGap(72, 72, 72))
                                        .addGroup(ownerPanelLayout.createSequentialGroup()
                                                .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(phoneNumberTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                                        .addComponent(addressTextField)
                                                        .addComponent(fullNameText)
                                                        .addGroup(ownerPanelLayout.createSequentialGroup()
                                                                .addGap(13, 13, 13)
                                                                .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(deleteOwnerButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(resetOwnerButton, javax.swing.GroupLayout.Alignment.TRAILING))
                                                                .addGap(26, 26, 26)
                                                                .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(updateOwnerButton)
                                                                        .addComponent(insertOwnerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ownerPanelLayout.setVerticalGroup(
                ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ownerPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(fullNameLabel)
                                .addGap(18, 18, 18)
                                .addComponent(fullNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(phoneNumberLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(phoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(addressLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(resetOwnerButton)
                                        .addComponent(updateOwnerButton))
                                .addGap(32, 32, 32)
                                .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(deleteOwnerButton)
                                        .addComponent(insertOwnerButton))
                                .addGap(35, 35, 35))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Owner", ownerPanel);

        yearLabel.setText("Year");

        insertCarButton.setText("Insert");
        insertCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertCarButtonActionPerformed(evt);
            }
        });

        resetCarButton.setText("Reset");
        resetCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetCarButtonActionPerformed(evt);
            }
        });

        updateCarButton.setText("Update");
        updateCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCarButtonActionPerformed(evt);
            }
        });

        carTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Brand", "Model", "Year", "Owner full name"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        carTable.getTableHeader().setReorderingAllowed(false);
        carTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(carTable);

        deleteCarButton.setText("Delete");
        deleteCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCarButtonActionPerformed(evt);
            }
        });

        brandLabel.setText("Brand");

        modelLabel.setText("Model");

        ownerFullNameLabel.setText("Owner full name");

        javax.swing.GroupLayout carPanelLayout = new javax.swing.GroupLayout(carPanel);
        carPanel.setLayout(carPanelLayout);
        carPanelLayout.setHorizontalGroup(
                carPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(carPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(carPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(carPanelLayout.createSequentialGroup()
                                                .addGroup(carPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(modelLabel)
                                                        .addComponent(yearLabel)
                                                        .addComponent(brandLabel))
                                                .addGap(72, 72, 72))
                                        .addGroup(carPanelLayout.createSequentialGroup()
                                                .addGroup(carPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(modelTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                                        .addComponent(brandTextField)
                                                        .addGroup(carPanelLayout.createSequentialGroup()
                                                                .addGroup(carPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(ownerFullNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(ownerFullNameLabel)
                                                                        .addGroup(carPanelLayout.createSequentialGroup()
                                                                                .addGap(13, 13, 13)
                                                                                .addGroup(carPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(deleteCarButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(resetCarButton, javax.swing.GroupLayout.Alignment.TRAILING))
                                                                                .addGap(26, 26, 26)
                                                                                .addGroup(carPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(updateCarButton)
                                                                                        .addComponent(insertCarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        carPanelLayout.setVerticalGroup(
                carPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(brandLabel)
                                .addGap(18, 18, 18)
                                .addComponent(brandTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(modelLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(modelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(yearLabel)
                                .addGap(18, 18, 18)
                                .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(ownerFullNameLabel)
                                .addGap(18, 18, 18)
                                .addComponent(ownerFullNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(carPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(resetCarButton)
                                        .addComponent(updateCarButton))
                                .addGap(32, 32, 32)
                                .addGroup(carPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(deleteCarButton)
                                        .addComponent(insertCarButton))
                                .addGap(35, 35, 35))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Car", carPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ownerTableMouseClicked(java.awt.event.MouseEvent evt) {
        int i = ownerTable.getSelectedRow();
        TableModel model = ownerTable.getModel();
        fullNameText.setText(model.getValueAt(i, 0).toString());
        phoneNumberTextField.setText(model.getValueAt(i, 1).toString());
        addressTextField.setText(model.getValueAt(i, 2).toString());
    }

    private void carTableMouseClicked(java.awt.event.MouseEvent evt) {
        int i = carTable.getSelectedRow();
        TableModel model = carTable.getModel();
        brandTextField.setText(model.getValueAt(i, 0).toString());
        modelTextField.setText(model.getValueAt(i, 1).toString());
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(i, 2).toString());
            dateChooser.setDate(date);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something went wrong");
        }
        ownerFullNameComboBox.setSelectedItem(model.getValueAt(i, 3).toString());
    }

    private void insertCarButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Car car = new Car();
        car.setUuid(UUID.randomUUID());
        if (checkExistingCarFields() && ownerFullNameComboBox.getSelectedItem() != null) {
            String selectedFullName = (String) ownerFullNameComboBox.getSelectedItem();
            car.setOwnerUuid(getOwnerUuidByFullName(selectedFullName));
            car.setBrand(brandTextField.getText());
            car.setModel(modelTextField.getText());
            car.setYear(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dateChooser.getDate())));
            carService.create(car);
            DefaultTableModel model = (DefaultTableModel) carTable.getModel();
            model.setRowCount(0);
            showCars();
        } else {
            JOptionPane.showMessageDialog(null, "Input data is incomplete or not valid");
        }
    }

    private void insertOwnerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Owner owner = new Owner();
        owner.setUuid(UUID.randomUUID());
        Pattern phoneNumberPattern = Pattern.compile("^\\+?3?8?(0\\d{9})$");
        Matcher phoneNumberMatcher = phoneNumberPattern.matcher(phoneNumberTextField.getText());
        if (phoneNumberMatcher.matches()) {
            if (checkExistingOwnerFields()) {
                owner.setFullName(fullNameText.getText());
                owner.setAddress(addressTextField.getText());
                owner.setPhoneNumber(phoneNumberTextField.getText());
                ownerService.create(owner);
                DefaultTableModel model = (DefaultTableModel) ownerTable.getModel();
                model.setRowCount(0);
                showOwners();
            } else {
                JOptionPane.showMessageDialog(null, "Input data is incomplete or not valid");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Wrong format for entering phone number; Right: +380---------");
        }
    }

    private void resetCarButtonActionPerformed(java.awt.event.ActionEvent evt) {
        brandTextField.setText("");
        modelTextField.setText("");
        dateChooser.setDate(null);
        ownerFullNameComboBox.setSelectedItem(null);
    }

    private void resetOwnerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        fullNameText.setText("");
        phoneNumberTextField.setText("");
        addressTextField.setText("");
    }

    private void updateOwnerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int row = ownerTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Select a row from the table to perform the update");
        } else {
            Pattern phoneNumberPattern = Pattern.compile("^\\+?3?8?(0\\d{9})$");
            Matcher phoneNumberMatcher = phoneNumberPattern.matcher(phoneNumberTextField.getText());
            if (phoneNumberMatcher.matches()) {
                if (checkExistingOwnerFields()) {
                    UUID ownerUuid = rowNumberWithOwnerUuid.get(row);
                    Owner owner = ownerService.findByUuid(ownerUuid);
                    owner.setFullName(fullNameText.getText());
                    owner.setPhoneNumber(phoneNumberTextField.getText());
                    owner.setAddress(addressTextField.getText());
                    ownerService.update(owner);
                    DefaultTableModel ownerModel = (DefaultTableModel) ownerTable.getModel();
                    DefaultTableModel carModel = (DefaultTableModel) carTable.getModel();
                    ownerModel.setRowCount(0);
                    carModel.setRowCount(0);
                    showOwners();
                    showCars();
                } else {
                    JOptionPane.showMessageDialog(null, "Input data is incomplete or not valid");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Wrong format for entering phone number; Right: +380---------");
            }
        }
    }

    private void updateCarButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int row = carTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Select a row from the table to perform the update");
        } else if (checkExistingCarFields()) {
            UUID carUuid = rowNumberWithCarUuid.get(row);
            Car car = carService.findByUuid(carUuid);
            String selectedFullName = (String) ownerFullNameComboBox.getSelectedItem();
            car.setOwnerUuid(getOwnerUuidByFullName(selectedFullName));
            car.setBrand(brandTextField.getText());
            car.setModel(modelTextField.getText());
            car.setYear(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dateChooser.getDate())));
            carService.update(car);
            DefaultTableModel model = (DefaultTableModel) carTable.getModel();
            model.setRowCount(0);
            showCars();
        } else {
            JOptionPane.showMessageDialog(null, "Input data is incomplete or not valid");
        }
    }

    private void deleteCarButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int row = carTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Select a row from the table to perform the delete");
        } else {
            UUID carUuid = rowNumberWithCarUuid.get(row);
            carService.delete(carUuid);
            DefaultTableModel model = (DefaultTableModel) carTable.getModel();
            model.setRowCount(0);
            showCars();
        }
    }

    private void deleteOwnerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int row = ownerTable.getSelectedRow();
        int isConfirmed = JOptionPane.showConfirmDialog(null, "Warning! When the owner is deleted, his cars will also be deleted");
        if (isConfirmed == 0) {
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Select a row from the table to perform the delete");
            } else {
                UUID ownerUuid = rowNumberWithOwnerUuid.get(row);
                ownerService.delete(ownerUuid);
                DefaultTableModel ownerModel = (DefaultTableModel) ownerTable.getModel();
                DefaultTableModel carModel = (DefaultTableModel) carTable.getModel();
                ownerModel.setRowCount(0);
                carModel.setRowCount(0);
                showOwners();
                showCars();
            }
        }
    }

    private void tabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {
        Owner[] owners = ownerService.findAll();
        ownerFullNameComboBox.removeAllItems();
        if (owners.length != 0) {
            Arrays.stream(owners)
                    .map(Owner::getFullName)
                    .forEach(fullName -> ownerFullNameComboBox.addItem(fullName));
            ownerFullNameComboBox.setSelectedItem(null);
        }
    }

    private void showOwners() {
        Owner[] owners = ownerService.findAll();
        DefaultTableModel model = (DefaultTableModel) ownerTable.getModel();
        Object[] row = new Object[3];
        rowNumberWithOwnerUuid = new LinkedHashMap<>();
        for (int i = 0; i < owners.length; i++) {
            row[0] = owners[i].getFullName();
            row[1] = owners[i].getPhoneNumber();
            row[2] = owners[i].getAddress();
            rowNumberWithOwnerUuid.put(i, owners[i].getUuid());
            model.addRow(row);
        }
    }

    private void showCars() {
        Car[] cars = carService.findAll();
        DefaultTableModel model = (DefaultTableModel) carTable.getModel();
        Object[] row = new Object[4];
        rowNumberWithCarUuid = new LinkedHashMap<>();
        for (int i = 0; i < cars.length; i++) {
            row[0] = cars[i].getBrand();
            row[1] = cars[i].getModel();
            row[2] = cars[i].getYear().toString();
            row[3] = ownerService.findByUuid(cars[i].getOwnerUuid()).getFullName();
            rowNumberWithCarUuid.put(i, cars[i].getUuid());
            model.addRow(row);
        }
    }

    private boolean checkExistingOwnerFields() {
        return Stream.of(
                fullNameText.getText(),
                phoneNumberTextField.getText(),
                addressTextField.getText()
        ).noneMatch(String::isBlank);
    }

    private boolean checkExistingCarFields() {
        if (dateChooser.getDate() == null) {
            return false;
        }
        return Stream.of(
                brandTextField.getText(),
                modelTextField.getText()
        ).noneMatch(String::isBlank);
    }

    private UUID getOwnerUuidByFullName(String fullName) {
        Owner[] owners = ownerService.findAll();
        return Arrays.stream(owners)
                .filter(owner -> owner.getFullName().equals(fullName))
                .map(Owner::getUuid)
                .findFirst()
                .get();
    }
}
