package ie.cm.activities;

import ie.cm.models.Coffee;
import ie.cm.R;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class Add extends Base implements
		OnClickListener {

	private String 		coffeeName, coffeeShop;
	private double 		coffeePrice, ratingValue;
	private EditText 	name, shop, price;
	private RatingBar 	ratingBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);

		Button saveButton = (Button) findViewById(R.id.saveCoffeeBtn);
		name = (EditText) findViewById(R.id.nameEditText);
		shop = (EditText) findViewById(R.id.shopEditText);
		price = (EditText) findViewById(R.id.priceEditText);
		ratingBar = (RatingBar) findViewById(R.id.coffeeRatingBar);
		saveButton.setOnClickListener(this);
	}

	public void onClick(View v) {
		
		coffeeName = name.getText().toString();
		coffeeShop = shop.getText().toString();
		try {
			coffeePrice = Double.parseDouble(price.getText().toString());
		} catch (NumberFormatException e) {
			coffeePrice = 0.0;
		}
		ratingValue = ratingBar.getRating();

		if ((coffeeName.length() > 0) && (coffeeShop.length() > 0)
				&& (price.length() > 0)) {
			Coffee c = new Coffee(coffeeName, coffeeShop, ratingValue,
					coffeePrice, false);

			coffeeList.add(c);
			goToActivity(this,Home.class, null);
		} else
			Toast.makeText(
					this,
					"You must Enter Something for "
							+ "\'Name\', \'Shop\' and \'Price\'",
					Toast.LENGTH_SHORT).show();
	}
}
