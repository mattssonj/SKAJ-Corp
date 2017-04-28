package corp.skaj.foretagskvitton.services;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ReceiptScanner {
    private List<String> listOfStrings;
    private double totalCost;

    // Checks that the string starts with the current year in ex. 17 or 2017.
    private boolean correctFirstNum(String date) {
        return date.substring(0, 2).equals((String.valueOf(Calendar.YEAR).substring(1, 3))) ||
                date.equals(String.valueOf(Calendar.YEAR));
    }

    // Checks that the size is correct format, either 170218 or 2017-05-03.
    private boolean correctLength(String date) {
        return date.length() <= 10 || date.length() >= 6;
    }

    private List<Double> findAllDoubles(List<String> listOfStrings) {
        List<Double> listOfDoubles = new ArrayList<>();
        double temp = 0;
        for (int i = 0; i < listOfStrings.size(); i++) {
            if (listOfStrings.get(i).contains(",")) {
                temp = Double.parseDouble(listOfStrings.get(i));
                listOfDoubles.add(temp);
            }
        }
        return listOfDoubles;
    }

    private double findBiggestDouble(List<Double> listOfDoubles) {
        double biggestDouble = 0;
        for (int i = 0; i < listOfDoubles.size() - 1; i++) {
            if (listOfDoubles.get(i) > listOfDoubles.get(i + 1)) {
                biggestDouble = listOfDoubles.get(i);
            }
        }
        return biggestDouble;
    }

    private boolean checkIfTotalBeforeAmount() {
        for (int i = 0; i < listOfStrings.size(); i++) {
            if (listOfStrings.get(i).equals("Total") || listOfStrings.get(i).equals("Totalt")) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfSekAfter() {
        for (int i = 0; i < listOfStrings.size(); i++) {
            if (listOfStrings.get(i).equals("SEK")) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfKrAfter() {
        for (int i = 0; i < listOfStrings.size(); i++) {
            if (listOfStrings.get(i).equals("kr") || listOfStrings.get(i).equals("Kr")) {
                return true;
            }
        }
        return false;
    }

    public void getTotalCost(List<String> listOfStrings) {
        this.listOfStrings = listOfStrings;
        List<Double> listOfDoubles = findAllDoubles(listOfStrings);
        totalCost = findBiggestDouble(listOfDoubles);
        if (totalCost == 0) {

        }
    }

    public String getDate(List<String> listOfStrings) { // Gjorde ändring här, vet inte om det var korrekt? // Joakim
        for (int i = 0; i < listOfStrings.size(); i++) {
            if (correctFirstNum(listOfStrings.get(i).substring(0, 3)) && correctLength(listOfStrings.get(i))) {
                return listOfStrings.get(i);
            }
        }
        return Calendar.getInstance().getTime().toString();
    }

    public void getProducts() {
    }

    public void getCardNumber() {
    }

}