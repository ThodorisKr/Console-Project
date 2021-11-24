package gr.peoplecert.bootcamp.utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.Scanner;

import static java.util.Objects.isNull;

public class Utils {
    public static LocalDate validate(String input) {
        try {
            LocalDate ld = LocalDate.parse(input);
            return ld;
        } catch (Exception e) {
            System.out.println("Invalid date");
        }
        return null;
    }

    public static LocalDate getValidDate(String message) {
        Scanner sc = new Scanner(System.in);
        LocalDate inputDate = null;
        while (isNull(inputDate)) {
            try {
                System.out.println(message + " (yyyy-mm-dd)");
                inputDate = LocalDate.parse(extractValidString());
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date.");
            }
        }
        return inputDate;
    }

    public static double extractDoubleInRange(Double startInclusive, Double endInclusive) {
        Scanner sc = new Scanner(System.in);
        Double value = null;
        while (Objects.isNull(value)) {
            String doubleInput = extractValidString();
            try {
                value = Double.parseDouble(doubleInput);
                if (value.compareTo(startInclusive) < 0 || value.compareTo(endInclusive) > 0) {
                    throw new Exception("INPUT IS NOT WITHIN RANGE: [" + startInclusive + ", " + endInclusive + "]");
                }
            } catch (NumberFormatException e) {
                System.out.println("INVALID INPUT");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                value = null;
            }
        }
        return value;
    }

    public static String extractValidString() {
        Scanner sc = new Scanner(System.in);
        String value = null;
        while (Objects.isNull(value)) {
            value = sc.nextLine();
            if (value.trim().isEmpty()) {
                System.out.println("INPUT MUST NOT BE BLANK");
                value = null;
            }
        }
        return value;
    }
}
