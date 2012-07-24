package com.example.apaeasy;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug.ExportedProperty;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity {

	List<Player> playerList = new ArrayList<Player>();

	List<String> test = new ArrayList<String>();	
	ArrayAdapter<String> dataAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, test);
		Spinner playerSpinner = (Spinner) findViewById(R.id.spinner1);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		playerSpinner.setAdapter(dataAdapter);

		final Button addPlayerButton = (Button) findViewById(R.id.addPlayer);
		addPlayerButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				addPlayer();
			}
		});
	}

	public final void addPlayer() {
		// Add a player...
		AlertDialog.Builder alert = new AlertDialog.Builder(this);

		alert.setTitle("Add a Player");
		alert.setMessage("Player Name:");

		// Set an EditText view to get user input
		final EditText input = new EditText(this);
		alert.setView(input);

		alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				Spinner addPlayerSpinner = (Spinner) findViewById(R.id.spinner1);
				String value = input.getText().toString();
				dataAdapter.add(value);
				dataAdapter.notifyDataSetChanged();
				addPlayerSpinner.setAdapter(dataAdapter);
			}
		});

		alert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// Canceled.
					}
				});

		alert.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
