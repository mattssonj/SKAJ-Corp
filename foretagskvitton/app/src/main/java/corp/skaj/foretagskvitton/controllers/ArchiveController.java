package corp.skaj.foretagskvitton.controllers;

import android.content.Context;
import java.util.List;

import corp.skaj.foretagskvitton.R;

import corp.skaj.foretagskvitton.model.Company;
import corp.skaj.foretagskvitton.model.Employee;
import corp.skaj.foretagskvitton.model.Purchase;
import corp.skaj.foretagskvitton.model.Receipt;

public class ArchiveController {
    private Context mContext;
    private List<Receipt> receipts;
    private List<Company> companies;
    private DataHolder dataHolder = (DataHolder)mContext.getApplicationContext();



    private void getAllReceipts (){
        companies = dataHolder.getUser().getCompanies();
        for (int i = 0; i < companies.size(); i++) {
            List<Employee> employees = companies.get(i).getEmployees();
            for (int j = 0; j < employees.size(); i++) {
                List<Purchase> purchases = employees.get(j).getPurchases();
                for (int k = 0; k < purchases.size(); k++) {
                     receipts.add(purchases.get(k).getReceipt());
                }
            }
        }
}

}