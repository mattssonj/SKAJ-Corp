package corp.skaj.foretagskvitton.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 */
public class ReceiptScanner {
    private List<String> listOfStrings;

    /**
     *
     * @param date
     * @return
     */
    // Checks that the string starts with the current year in ex. 17 or 2017.
    private boolean correctFirstNum(String date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        Calendar cal = Calendar.getInstance();
        String year = "2017";
       //String year = dateFormat.format(cal).toString();
        return date.substring(0, 2).equals(year.substring(0, 4)) || date.equals(year);
    }

    /**
     *
     * @param date
     * @return
     */
    // Checks that the size is correct format, either 170218 or 2017-05-03.
    private boolean correctLength(String date) {
        return date.length() <= 10 && date.length() >= 6;
    }

    /**
     *
     * @param listOfStrings
     * @return
     */
    private List<Double> findAllDoubles(List<String> listOfStrings) {
        List<Double> listOfDoubles = new ArrayList<>();
        for (int i = 0; i < listOfStrings.size(); i++) {
            String s = listOfStrings.get(i).replace("," , ".");
            if (s.contains(".")) {
                if(isDouble(s)) {
                    listOfDoubles.add(Double.parseDouble(s));
                }
            } else {
                double totalCost = 0;
                for (int j = 0; j < listOfStrings.size(); j++) {
                    if (checkForText()) {
                        totalCost = checkBeforeAndAfter(i);
                        listOfDoubles.add(totalCost);
                    }
                }
            }
        }
        return listOfDoubles;
    }

    /**
     *
     * @param s
     * @return <code>true</code> if s is a double
     * <code>false</code> otherwise
     */
    public boolean isDouble (String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public boolean isInt(String s) {

    }

    /**
     *
     * @return <code>true</code> if kr or sek is found
     * <code>false</code> otherwise
     */
    private boolean checkForText () {
        for (int i = 0; i < listOfStrings.size(); i++) {
            if (listOfStrings.get(i).toLowerCase().equals("kr")
                        || listOfStrings.get(i).toLowerCase().equals("sek")
                            || listOfStrings.get(i).toLowerCase().equals("total")
                                || listOfStrings.get(i).toLowerCase().equals("totalt")) {
                return true;
            }
        }
        return false;
    }

    public double checkBeforeAndAfter (int index) {
        if (isInt(listOfStrings.get(index - 1)) || isDouble(listOfStrings.get(index - 1))) {
            //vet att det är en double eller int
            //spara den som total cost
            // vill kolla index + 1
            //kolla vilket av de två värdena som är störts
        }
    }

    public String getTotalCost(List<String> listOfStrings) {
        this.listOfStrings = listOfStrings;
        List<Double> listOfDoubles = findAllDoubles(listOfStrings);

        return String.valueOf(Collections.max(listOfDoubles));
        }

    public String getDate(List<String> listOfStrings) {
        for (int i = 0; i < listOfStrings.size(); i++) {
            if (correctFirstNum(listOfStrings.get(i).substring(0, 4)) && correctLength(listOfStrings.get(i))) {
                return listOfStrings.get(i);
            }
        }
        return "2017-04-28";
        //return Calendar.getInstance().getTime().toString();
    }

    public void getProducts(List<String> listOfStrings) {

    }

    public void getCardNumber() {
    }

}