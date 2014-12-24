package com.example.notetakingapp;

import com.example.notetakingapp.data.NoteItem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class EditNoteActivity extends Activity {

	private NoteItem note;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_note);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		

		Intent i = this.getIntent();
		note = NoteItem.getNew();
		note.setKey(i.getStringExtra("key"));
		note.setText(i.getStringExtra("text"));

		EditText et = (EditText) findViewById(R.id.note_text);
		et.setText(note.getText());
		
		et.setSelection(note.getText().length());


	}
	private void saveAndFinish(){
		
		EditText et = (EditText) findViewById(R.id.note_text);
		String noteText = et.getText().toString();
		Intent i = new Intent();
		
		String emptystr = noteText.trim();
		
		if(emptystr.isEmpty())
		{
			finish();
			Toast toast = Toast.makeText(getApplicationContext(), "emply note",Toast.LENGTH_LONG);
			toast.show();
		}
		else
		{
			
			i.putExtra("key", note.getKey());
			i.putExtra("text", noteText);
			setResult(RESULT_OK, i);
			finish();
		}
	

	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if(item.getItemId() == android.R.id.home){
			saveAndFinish();
			
		}
		return false;
		
		
		}
	
		@Override
		public void onBackPressed() {
			
			
		saveAndFinish();
	
	
	}

}
