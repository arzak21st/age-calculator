package dev.arzak21st.agecalculator.services;

import dev.arzak21st.agecalculator.utils.ExceptionHandlingUtil;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CalculationService {

    public String[] calculateAgeInDifferentUnits(String birthDateTime, String currentDateTime) {

        String[] ageInDifferentUnits = null;

        String ageInMilliseconds = calculateAgeInMilliseconds(birthDateTime, currentDateTime);

        String ageInSeconds = calculateAgeInSeconds(ageInMilliseconds);
        String ageInMinutes = calculateAgeInMinutes(ageInSeconds);
        String ageInHours = calculateAgeInHours(ageInMinutes);

        String ageInDays = calculateAgeInDays(ageInHours);
        String ageInMonths = calculateAgeInMonths(ageInDays, birthDateTime, currentDateTime);
        String ageInYears = calculateAgeInYears(ageInMonths);

        if(ageInMilliseconds != null && ageInSeconds != null && ageInMinutes != null && ageInHours != null && ageInDays != null && ageInMonths != null && ageInYears != null) {
            ageInDifferentUnits = new String[] {ageInYears, ageInMonths, ageInDays, ageInHours, ageInMinutes, ageInSeconds};
        }

        return ageInDifferentUnits;
    }

    private String calculateAgeInMilliseconds(String birthDateTime, String currentDateTime) {

        String ageInMilliseconds = null;

        if(birthDateTime != null && currentDateTime != null) {

            try {

                LocalDateTime startDateTime = LocalDateTime.parse(birthDateTime);
                LocalDateTime endDateTime = LocalDateTime.parse(currentDateTime);

                long timeInMilliseconds = ChronoUnit.MILLIS.between(startDateTime, endDateTime);

                ageInMilliseconds = String.valueOf(timeInMilliseconds) + " millisecond";
            }
            catch(Exception exception) {
                ExceptionHandlingUtil.getException(exception);
            }
        }

        return ageInMilliseconds;
    }

    private String calculateAgeInSeconds(String ageInMilliseconds) {

        String ageInSeconds = null;

        if(ageInMilliseconds != null) {

            long timeInMilliseconds = Long.parseLong(ageInMilliseconds.substring(0, ageInMilliseconds.indexOf(" ")));
            long timeInSeconds = timeInMilliseconds / 1000;

            ageInSeconds = String.valueOf(timeInSeconds) + " second";
        }

        return ageInSeconds;
    }

    private String calculateAgeInMinutes(String ageInSeconds) {

        String ageInMinutes = null;

        if(ageInSeconds != null) {

            long timeInSeconds = Long.parseLong(ageInSeconds.substring(0, ageInSeconds.indexOf(" ")));
            long timeInMinutes = timeInSeconds / 60;
            long remainingTimeInSeconds = timeInSeconds % 60;

            ageInMinutes = String.valueOf(timeInMinutes) + " minute and " + remainingTimeInSeconds + " second";
        }

        return ageInMinutes;
    }

    private String calculateAgeInHours(String ageInMinutes) {

        String ageInHours = null;

        if(ageInMinutes != null) {

            long timeInMinutes = Long.parseLong(ageInMinutes.substring(0, ageInMinutes.indexOf(" ")));
            long timeInHours = timeInMinutes / 60;
            long remainingTimeInMinutes = timeInMinutes % 60;
            String remainingTimeInSeconds = ageInMinutes.substring(ageInMinutes.indexOf(" "));

            ageInHours = String.valueOf(timeInHours) + " hour and " + remainingTimeInMinutes + remainingTimeInSeconds;
        }

        return ageInHours;
    }

    private String calculateAgeInDays(String ageInHours) {

        String ageInDays = null;

        if(ageInHours != null) {

            long timeInHours = Long.parseLong(ageInHours.substring(0, ageInHours.indexOf(" ")));
            long timeInDays = timeInHours / 24;
            long remainingTimeInHours = timeInHours % 24;
            String remainingTimeInMinutes = ageInHours.substring(ageInHours.indexOf(" "));

            ageInDays = String.valueOf(timeInDays) + " day and " + remainingTimeInHours + remainingTimeInMinutes;
        }

        return ageInDays;
    }

    private String calculateAgeInMonths(String ageInDays, String birthDateTime, String currentDateTime) {

        String ageInMonths = null;

        if(ageInDays != null) {

            long timeInDays = Long.parseLong(ageInDays.substring(0, ageInDays.indexOf(" ")));
            String timeInMonths = calculateTimeInMonths(timeInDays, birthDateTime, currentDateTime); // It includes 'remainingTimeInDays'
            String remainingTimeInHours = ageInDays.substring(ageInDays.indexOf(" "));

            ageInMonths = timeInMonths + remainingTimeInHours;
        }

        return ageInMonths;
    }

    private String calculateTimeInMonths(long timeInDays, String birthDateTime, String currentDateTime) {

        int[] leapYearMonths = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 366
        int[] ordinaryYearMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 365

        long days = timeInDays;
        long months = 0;

        int birthYear = Integer.parseInt(birthDateTime.substring(0, birthDateTime.indexOf("-"))); // For example: 2000 from 2000-05-21T00:00:00
        int currentYear = Integer.parseInt(currentDateTime.substring(0, currentDateTime.indexOf("-"))); // For example: 2020 from 2020-05-21T00:00:00

        for(int yearIndex = birthYear; yearIndex <= currentYear; yearIndex++) { // For example: 2000 to 2020

            if((yearIndex % 4 == 0) && (yearIndex % 100 != 0 || yearIndex % 400 == 0)) { // If 'birthYear' is a leap year

                int birthMonth = 1;
                if(yearIndex == birthYear) { // true only for the first iteration since 'yearIndex' is not yet incremented
                    birthMonth = Integer.parseInt(birthDateTime.substring(birthDateTime.indexOf("-") + 1, birthDateTime.lastIndexOf("-"))); // For example: 05 from 2000-05-21T00:00:00
                }

                for(int monthIndex = birthMonth - 1; monthIndex < leapYearMonths.length; monthIndex++) { // For example: 04 (May) to 11 (Dec)

                    if(days >= leapYearMonths[monthIndex]) { // For example: 7305 day is greater than 31 day

                        days = days - leapYearMonths[monthIndex]; // Subtruct the current month days (31) from the total number of days (7305)
                        months = months + 1; // and increment months by 1
                    }
                    else { // For example: 0 day is less than 31 day
                        break;
                    }
                }
            }
            else { // If 'birthYear' is an ordinary year

                int birthMonth = 1;
                if(yearIndex == birthYear) { // true only for the first iteration since 'yearIndex' is not yet incremented
                    birthMonth = Integer.parseInt(birthDateTime.substring(birthDateTime.indexOf("-") + 1, birthDateTime.lastIndexOf("-"))); // For example: 05 from 2000-05-21T00:00:00
                }

                for(int monthIndex = birthMonth - 1; monthIndex < ordinaryYearMonths.length; monthIndex++) { // For example: 04 (May) to 11 (Dec)

                    if(days >= ordinaryYearMonths[monthIndex]) { // For example: 7305 day is greater than 31 day

                        days = days - ordinaryYearMonths[monthIndex]; // Subtruct the current month days (31) from the total number of days (7305)
                        months = months + 1; // and increment months by 1
                    }
                    else { // For example: 0 day is less than 31 day
                        break; // Break out from the loop
                    }
                }
            }
        }

        String timeInMonths = months + " month and " + days; // 'remainingTimeInDays' is indirectly calculated
        return timeInMonths;
    }

    private String calculateAgeInYears(String ageInMonths) {

        String ageInYears = null;

        if(ageInMonths != null) {

            long timeInMonths = Long.parseLong(ageInMonths.substring(0, ageInMonths.indexOf(" ")));
            long timeInYears = timeInMonths / 12;
            long remainingTimeInMonths = timeInMonths % 12;
            String remainingTimeInDays = ageInMonths.substring(ageInMonths.indexOf(" "));

            ageInYears = String.valueOf(timeInYears) + " year and " + remainingTimeInMonths + remainingTimeInDays;
        }

        return ageInYears;
    }
}
