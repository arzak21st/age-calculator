package dev.arzak21st.agecalculator.views;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class OutputView extends JFrame {

    public OutputView() {
        initComponents();
    }

    public void setAge(String[] ageInDifferentUnits) {

        setMessage();
        setAge(ageInDifferentUnits[0], ageInYearsLabel);
        setAge(ageInDifferentUnits[1], ageInMonthsLabel);
        setAge(ageInDifferentUnits[2], ageInDaysLabel);
        setAge(ageInDifferentUnits[3], ageInHoursLabel);
        setAge(ageInDifferentUnits[4], ageInMinutesLabel);
        setAge(ageInDifferentUnits[5], ageInSecondsLabel);
    }

    private void setMessage() {

        String message
                = "<html>"
                + "<center>"
                + "Considering you were born at:" + "<br>"
                + "<b style=\"color: #00FA9A;\">00:00:00AM" + "</b>" + "<br>"
                + "Your age is:"
                + "</center>"
                + "</html>";
        messageLabel.setText(message);
    }

    private void setAge(String age, JLabel ageLabel) {

        String message
                = "<html>"
                + "<center>"
                + "<b style=\"color: #00FA9A;\">" + age + "</b>"
                + "</center>"
                + "</html>";
        ageLabel.setText(message);
    }

    /* ==================== IDE Generated Code ==================== */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        messageLabel = new javax.swing.JLabel();
        ageInYearsLabel = new javax.swing.JLabel();
        ageInMonthsLabel = new javax.swing.JLabel();
        ageInDaysLabel = new javax.swing.JLabel();
        ageInHoursLabel = new javax.swing.JLabel();
        ageInMinutesLabel = new javax.swing.JLabel();
        ageInSecondsLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Age Calculator");
        setResizable(false);

        titleLabel.setFont(new java.awt.Font("Dialog", 1, 31)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Result");

        messageLabel.setFont(new java.awt.Font("Dialog", 1, 31)); // NOI18N
        messageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        messageLabel.setText("Message");
        messageLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        ageInYearsLabel.setFont(new java.awt.Font("Dialog", 1, 31)); // NOI18N
        ageInYearsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ageInYearsLabel.setText("Age in years");
        ageInYearsLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        ageInMonthsLabel.setFont(new java.awt.Font("Dialog", 1, 31)); // NOI18N
        ageInMonthsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ageInMonthsLabel.setText("Age in months");
        ageInMonthsLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        ageInDaysLabel.setFont(new java.awt.Font("Dialog", 1, 31)); // NOI18N
        ageInDaysLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ageInDaysLabel.setText("Age in days");
        ageInDaysLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        ageInHoursLabel.setFont(new java.awt.Font("Dialog", 1, 31)); // NOI18N
        ageInHoursLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ageInHoursLabel.setText("Age in hours");
        ageInHoursLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        ageInMinutesLabel.setFont(new java.awt.Font("Dialog", 1, 31)); // NOI18N
        ageInMinutesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ageInMinutesLabel.setText("Age in minutes");
        ageInMinutesLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        ageInSecondsLabel.setFont(new java.awt.Font("Dialog", 1, 31)); // NOI18N
        ageInSecondsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ageInSecondsLabel.setText("Age in seconds");
        ageInSecondsLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE)
                    .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE)
                    .addComponent(ageInYearsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE)
                    .addComponent(ageInMonthsLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE)
                    .addComponent(ageInDaysLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE)
                    .addComponent(ageInHoursLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE)
                    .addComponent(ageInMinutesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE)
                    .addComponent(ageInSecondsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ageInYearsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ageInMonthsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ageInDaysLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ageInHoursLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ageInMinutesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ageInSecondsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
    public javax.swing.JLabel ageInDaysLabel;
    public javax.swing.JLabel ageInHoursLabel;
    public javax.swing.JLabel ageInMinutesLabel;
    public javax.swing.JLabel ageInMonthsLabel;
    public javax.swing.JLabel ageInSecondsLabel;
    public javax.swing.JLabel ageInYearsLabel;
    public javax.swing.JLabel messageLabel;
    public javax.swing.JPanel panel;
    public javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
