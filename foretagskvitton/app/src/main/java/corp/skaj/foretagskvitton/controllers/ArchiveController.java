package corp.skaj.foretagskvitton.controllers;

import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import corp.skaj.foretagskvitton.R;
import corp.skaj.foretagskvitton.model.Category;
import corp.skaj.foretagskvitton.model.Comment;
import corp.skaj.foretagskvitton.model.Company;
import corp.skaj.foretagskvitton.model.IData;
import corp.skaj.foretagskvitton.model.Purchase;
import corp.skaj.foretagskvitton.model.Supplier;
import corp.skaj.foretagskvitton.model.User;
import corp.skaj.foretagskvitton.view.ArchiveFragment;
import corp.skaj.foretagskvitton.view.FABCallback;

public class ArchiveController implements FABCallback {
    private ArchiveFragment fragment;
    private String purchaseId;
    private IData dataHandler;

    public ArchiveController(IData dataHandler, String purId, ArchiveFragment fragment) {
        this.dataHandler = dataHandler;
        purchaseId = purId;
        this.fragment = fragment;
    }

    public void updateReceiptData() {
        User user = dataHandler.readData(User.class.getName(), User.class);
        Purchase purchase = dataHandler.getPurchases(user).getPurchase(purchaseId);
        // price 
        purchase.getReceipt().setTotal(fragment.getPrice());
        // category 
        System.out.println(fragment.getCategory().toUpperCase() + "HAHAHAHAH");
        purchase.getReceipt().getProducts().get(0).setCategory(Category.valueOf(fragment.getCategory().toUpperCase()));
        // tax 
        purchase.getReceipt().getProducts().get(0).setTax(fragment.getTax());
        // supplier
        Supplier updatedSupplier = user.getSupplier(fragment.getSupplier());
        purchase.setSupplier(updatedSupplier);
        // payment method 
        purchase.setPurchaseType(selectCorrectPurchase());
        // company 
        Company updatedCompany = user.getCompany(fragment.getCompany());
        user.addCompany(updatedCompany);
        //comments
        purchase.getReceipt().getProducts().get(0).getComments().get(0).setComment(fragment.getComment());
        //date
        /*
        DateFormat newDate = new SimpleDateFormat("yyyy-mm-dd");
        fragment.getDate();
*/
        // saves all changes 
        dataHandler.writeData(User.class.getName(), user);

    }

    private Purchase.PurchaseType selectCorrectPurchase() {
        return fragment.getPurchaseType().equals("Företagskort") ? Purchase.PurchaseType.COMPANY : Purchase.PurchaseType.PRIVATE;
    }

    public void bindButton(final FloatingActionsMenu button) {
        button.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuExpanded() {
                updateReceiptData();
                button.collapse();
                Toast.makeText(fragment.getContext(), fragment.getContext().getString(R.string.archive_save), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMenuCollapsed() {

            }
        });
    }
}