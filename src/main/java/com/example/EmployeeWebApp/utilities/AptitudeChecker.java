package com.example.EmployeeWebApp.utilities;

public class AptitudeChecker {
    public static int calculateScore(String[] s) {
        int totalcorrectanswer = 0;
        String[] realanswer = {"30", "12", "720", "8", "48"};
        for (int i = 0; i < 5; i++) {
            if (s[i] != null && s[i].equals(realanswer[i])) {
                totalcorrectanswer = totalcorrectanswer + 1;
            }
        }
        return totalcorrectanswer;
    }
}
