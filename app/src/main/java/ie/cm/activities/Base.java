package ie.cm.activities;

import java.util.ArrayList;

import ie.cm.models.Coffee;
import ie.cm.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Base extends AppCompatActivity {

	protected static ArrayList<Coffee> coffeeList = new ArrayList<Coffee>();

	protected void goToActivity(Activity current,
								Class<? extends Activity> activityClass,
								Bundle bundle) {
		Intent newActivity = new Intent(current, activityClass);

		if (bundle != null) newActivity.putExtras(bundle);

		current.startActivity(newActivity);
	}

	public void openInfoDialog(Activity current) {
		Dialog dialog = new Dialog(current);
		dialog.setTitle("About CoffeeMate");
		dialog.setContentView(R.layout.info);

		TextView currentVersion = (TextView) dialog
				.findViewById(R.id.versionTextView);
		currentVersion.setText("1.0.0");

		dialog.setCancelable(true);
		dialog.setCanceledOnTouchOutside(true);
		dialog.show();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}
	public void menuInfo(MenuItem m) {
		openInfoDialog(this); }
	public void menuHelp(MenuItem m) {
		 goToActivity(this, Help.class, null);
	}
	public void menuHome(MenuItem m) {
		goToActivity(this, Home.class, null); }
}
