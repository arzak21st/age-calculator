package dev.arzak21st.agecalculator.views;

import dev.arzak21st.agecalculator.controllers.IOController;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class InputView extends JFrame {

    IOController ioController = new IOController();

    public InputView() {

        initComponents();
        setDateChooserPreperties(birthDateChooser);
        setActionListeners(calculateButton);
    }

    private void setDateChooserPreperties(JDateChooser dateChooser) {

        JTextField dateField = ((JTextField) dateChooser.getDateEditor().getUiComponent()); // Cast JDateChooser to JTextField
        dateField.setEditable(false); // Disable editing
        dateField.setBackground(new Color(255, 255, 255)); // Change the background color
        dateField.setHorizontalAlignment(JTextField.CENTER); // Center the value
        //dateField.setText("2020-01-01");

        dateChooser.getCalendarButton().setPreferredSize(new Dimension(50, 50)); // Change the size of the date chooser button
        dateChooser.setDate(new Date()); // Set date to the current date
    }

    private void setActionListeners(JButton button) {

        button.addActionListener((evt) -> {

            JTextField birthDateField = ((JTextField) birthDateChooser.getDateEditor().getUiComponent());
            String birthDate = birthDateField.getText();
            ioController.getAge(birthDate, InputView.this);
        });
    }

    /* ==================== IDE Generated Code ==================== */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        panel = new javax.swing.JPanel();
        calculateButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        birthDateLabel = new javax.swing.JLabel();
        birthDateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Age Calculator");
        setResizable(false);

        calculateButton.setFont(new java.awt.Font("Dialog", 1, 21)); // NOI18N
        calculateButton.setText("Calculate Age");

        titleLabel.setFont(new java.awt.Font("Dialog", 1, 31)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Age Calculator");

        birthDateLabel.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        birthDateLabel.setText("Birth date:");

        birthDateChooser.setForeground(new java.awt.Color(255, 255, 255));
        birthDateChooser.setDateFormatString("yyyy-MM-dd");
        birthDateChooser.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        birthDateChooser.setMaxSelectableDate(new Date());
        birthDateChooser.setMinSelectableDate(new java.util.Date(-2208986980000L));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(birthDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(calculateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(birthDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(birthDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(birthDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        birthDateChooser.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public com.toedter.calendar.JDateChooser birthDateChooser;
    public javax.swing.JLabel birthDateLabel;
    public javax.swing.JButton calculateButton;
    public com.toedter.calendar.JDateChooser jDateChooser1;
    public javax.swing.JPanel panel;
    public javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
