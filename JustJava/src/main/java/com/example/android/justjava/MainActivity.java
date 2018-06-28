/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */

package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view)
    {
        //display(quantity);
        //displayPrice(quantity*5);

        CheckBox cb = (CheckBox) findViewById(R.id.checkbox);
        String priceMessage = "";
        TextView tv = (TextView) this.findViewById(R.id.editText);
        priceMessage += tv.getText() ;
        priceMessage += "\nQuantity " + quantity ;

        if(cb.isChecked())
        {
            long price = (quantity*7);
            NumberFormat.getCurrencyInstance().format(price);
            priceMessage += "\nWhipped Cream Added\nTotal:" + price + getString(R.string.thankyou);
        }
        else
        {
            priceMessage += "\nWithout Whipped Cream\nTotal:$" + (quantity*5) + getString(R.string.thankyou);
        }


        //displayMessage(priceMessage);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_TEXT,priceMessage);
        intent.putExtra(Intent.EXTRA_SUBJECT,"Just Java Order for " + tv.getText());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        return;
    }

    public void increment(View view)
    {
        if(quantity >= 100)
            return;

        quantity++;
        display(quantity);
       //displayPrice(quantity*5);
        return;
    }

    public void decrement(View view)
    {
        if(quantity <= 1)
            return;

        quantity--;
        display(quantity);
        //displayPrice(quantity*5);
        return;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
        return;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        /*TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
        */return;
    }
}
