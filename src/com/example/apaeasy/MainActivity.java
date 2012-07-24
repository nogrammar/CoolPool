package com.example.apaeasy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

	List<Player> playerList = new LinkedList<Player>();
	ArrayAdapter<Player> dataAdapter;
	Game theGame = null; 
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Create a sample game to test the back-end before the match abstraction is done...
		ConcreteNineBallScoringSystem nineBall = new ConcreteNineBallScoringSystem();
		Queue<Player> playerQueue = new LinkedList<Player>();
		theGame = new Game(nineBall,playerQueue);
		
		dataAdapter = new ArrayAdapter<Player>(this,android.R.layout.simple_spinner_item, playerList);
		Spinner playerSpinner = (Spinner) findViewById(R.id.spinner1);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		playerSpinner.setAdapter(dataAdapter);

		final Button addPlayerButton = (Button) findViewById(R.id.addPlayer);
		addPlayerButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// AddPlayer button pressed.  So add a player.
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
				// Find the Spinner which contains the list of players
				Spinner addPlayerSpinner = (Spinner) findViewById(R.id.spinner1);
				Player value = new Player(input.getText().toString(),theGame);
				dataAdapter.add(value);
				dataAdapter.notifyDataSetChanged();
				addPlayerSpinner.setAdapter(dataAdapter);
			}
		});

		alert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
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
