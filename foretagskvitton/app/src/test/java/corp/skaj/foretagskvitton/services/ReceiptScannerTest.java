package corp.skaj.foretagskvitton.services;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mattsson on 2017-04-27.
 */
public class ReceiptScannerTest {

    ReceiptScanner receiptScanner = new ReceiptScanner();
    List<String> list;
    List <String> listOfDoubles;

    @Before
    public void setup(){
        list = new ArrayList<>();
        list.add("fjweiofeiw");
        list.add("20423423");
        list.add("020 023 423");
        list.add("216-04-28");
        list.add("16-04-28");
        list.add("2017234223423422");
        list.add("2017-04-27");

        listOfDoubles = new ArrayList<>();
        listOfDoubles.add("90,95");
        listOfDoubles.add("hej");
        listOfDoubles.add("299,00");
        listOfDoubles.add("12,90");
        listOfDoubles.add("8,95");
        listOfDoubles.add("skajcorp");
        listOfDoubles.add("hitta doris");
        listOfDoubles.add("50");
        listOfDoubles.add("5,95");
        listOfDoubles.add("20,00");
    }

    @Test
    public void testDateFilter(){
        String testdate = "2017-04-27";
        String methodDate = receiptScanner.getDate(list);
        assertEquals(testdate, methodDate);
        assertEquals(testdate, receiptScanner.getDate(list));
    }

    @Test
    public void testFindingDouble () {
        String test = receiptScanner.getTotalCost(listOfDoubles);
        assertEquals("299.00", test);
    }
}