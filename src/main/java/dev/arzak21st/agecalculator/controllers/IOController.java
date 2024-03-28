package dev.arzak21st.agecalculator.controllers;

import dev.arzak21st.agecalculator.services.CalculationService;
import dev.arzak21st.agecalculator.services.ValidationService;
import dev.arzak21st.agecalculator.utils.ExceptionHandlingUtil;
import dev.arzak21st.agecalculator.views.InputView;
import dev.arzak21st.agecalculator.views.OutputView;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;

public class IOController {

    ValidationService validationService = new ValidationService();
    CalculationService calculationService = new CalculationService();

    public void getAge(String birthDate, InputView inputView) {

        boolean dateIsValid = validationService.validateDate(birthDate);
        if(dateIsValid) {

            // Open the output view
            OutputView outputView = new OutputView();
            outputView.setVisible(true);
            inputView.setEnabled(false);

            // Calculate and display age in the output view
            Thread timerThread = new Thread(() -> {

                while(true) {

                    try {
                        Thread.sleep(1000);
                    }
                    catch(Exception exception) {
                        ExceptionHandlingUtil.getException(exception);
                    }

                    String birthDateTime = birthDate + "T00:00:00"; // For example: 2000-05-21T00:00:00
                    String currentDateTime = LocalDateTime.now().toString();

                    String[] ageInDifferentUnits = calculationService.calculateAgeInDifferentUnits(birthDateTime, currentDateTime);
                    if(ageInDifferentUnits != null) {
                        outputView.setAge(ageInDifferentUnits);
                    }
                    else {
                        break;
                    }
                }
            });
            timerThread.start();

            // Set a listener on closing the output view
            outputView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent windowEvent) {

                    inputView.setEnabled(true);
                    timerThread.stop();
                }
            });
        }
    }
}
