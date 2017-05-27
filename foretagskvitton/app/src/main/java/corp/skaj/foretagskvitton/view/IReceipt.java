package corp.skaj.foretagskvitton.view;

import android.net.Uri;
import android.widget.ImageView;
import android.widget.Spinner;

public interface IReceipt extends IFAB {

    void bindImage(ImageView clickableImage, Uri uri);

    void bindSpinner(final Spinner spinnerToBind, final AbstractFragment fragment, final Spinner spinnerToChange);
}