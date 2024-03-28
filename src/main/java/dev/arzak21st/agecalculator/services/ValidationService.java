package dev.arzak21st.agecalculator.services;

public class ValidationService {

    public boolean validateDate(String birthDate) {

        String dateFormat = "\\d{4}-\\d{2}-\\d{2}";
        if(birthDate.matches(dateFormat)) {
            return true;
        }
        return false;
    }
}
