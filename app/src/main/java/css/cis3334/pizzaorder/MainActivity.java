package css.cis3334.pizzaorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements updateViewInterface {

    RadioButton rbSmall;
    RadioButton rbMedium;
    RadioButton rbLarge;
    CheckBox chkbxCheese;
    CheckBox chkbxDelivery;
    TextView txtTotal;
    TextView txtStatus;
    PizzaOrderInterface pizzaOrderSystem;
    Spinner spinnerToppings;
    String strSize;
    String topping;
    boolean cheese = false;
    boolean delivery = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbSmall = (RadioButton) findViewById(R.id.radioButtonSmall);
        rbMedium = (RadioButton) findViewById(R.id.radioButtonMedium);
        rbLarge = (RadioButton) findViewById(R.id.radioButtonLarge);

        chkbxCheese = (CheckBox) findViewById(R.id.checkBoxCheese);
        chkbxDelivery = (CheckBox) findViewById(R.id.checkBoxDeluvery);

        txtTotal = (TextView) findViewById(R.id.textViewTotal);
        txtStatus = (TextView) findViewById(R.id.textViewStatus);
        spinnerToppings = (Spinner) findViewById(R.id.spinnerToppings);

        pizzaOrderSystem = new PizzaOrder(this);
    }

    @Override
    public void updateView(String orderStatus) {
        txtStatus.setText("Order Status " + orderStatus);
    }

    public void onClickOrder(View view) {

        if (rbSmall.isChecked()) {
            strSize = "small";
        } else if (rbMedium.isChecked()) {
            strSize = "medium";
        } else if (rbLarge.isChecked()){
            strSize = "large";
        } else {
            txtStatus.setText("Please select a pizza");
        }

        if (chkbxCheese.isChecked()) {
            cheese = true;
        }

        if (chkbxDelivery.isChecked()) {
            delivery = true;
        }

        topping = spinnerToppings.getSelectedItem().toString();

        String orderDescription = pizzaOrderSystem.OrderPizza(topping, strSize, cheese, delivery);

        //display a pop up message for a long period of time
        Toast.makeText(getApplicationContext(), "You have ordered a "+ orderDescription, Toast.LENGTH_LONG).show();
        txtTotal.setText("Total Due: " + pizzaOrderSystem.getTotalBill().toString());
    }


}
