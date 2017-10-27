package com.kataponcoe.inputbiodata;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity implements OnClickListener, OnCheckedChangeListener {

    EditText fieldnama,fieldemail;
    Button tomboltampil;
    RadioGroup groupjk;
    RadioButton radiolk, radiopr;
    CheckBox cekboxjava, cekboxsa, cekboxnet;
    TextView outputnama, outputemail, outputjk, outputahli;
    String jk, ahli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        fieldemail = (EditText)findViewById(R.id.fieldemail);
        fieldnama = (EditText)findViewById(R.id.fieldnama);
        tomboltampil = (Button)findViewById(R.id.tomboltampil);
        groupjk = (RadioGroup)findViewById(R.id.groupjk);
        cekboxjava = (CheckBox)findViewById(R.id.cekboxjava);
        cekboxsa = (CheckBox)findViewById(R.id.cekboxsa);
        cekboxnet = (CheckBox)findViewById(R.id.cekboxnet);
        outputnama =(TextView)findViewById(R.id.outputnama);
        outputemail =(TextView)findViewById(R.id.outputemail);
        outputahli = (TextView)findViewById(R.id.outputahli);
        outputjk = (TextView)findViewById(R.id.outputjk);
       
        tomboltampil.setOnClickListener(this);
        groupjk.setOnCheckedChangeListener(this);       
       
    }

    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 0, 0, R.string.about);
		return super.onCreateOptionsMenu(menu);
		}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
			switch(item.getItemId()){
				case 0:
					tentangAplikasi();
					break;
				}return true;
	}
	
	private void tentangAplikasi(){
		new AlertDialog.Builder(this)
			.setTitle(R.string.about)
			.setMessage(R.string.tentang_isi)
			.setPositiveButton("OK",new DialogInterface.OnClickListener(){	
				public void onClick(DialogInterface dialoginterface, int i){}
				}) .show();
			}

    @Override
    public void onClick(View klik) {
        // TODO Auto-generated method stub
   
        outputnama.setText("Nama Anda : "+fieldnama.getText());
        outputemail.setText("Email Anda : "+fieldemail.getText());
        if (cekboxjava.isChecked() && cekboxnet.isChecked() && cekboxsa.isChecked()){
            outputahli.setText("Keahlian Anda : Rekaysa Perangkat Lunak, Teknik Komputer dan Jaringan & Multimedia");
        }else if(cekboxjava.isChecked() && cekboxnet.isChecked()){
                outputahli.setText("Keahlian Anda : Rekayasa Perangakat Lunak & Teknik Komputer dan Jaringan");
        }else if(cekboxjava.isChecked() && cekboxsa.isChecked()){
            outputahli.setText("Keahlian Anda : Rekayasa Perangkat Lunak & Multimedia");
        }else if(cekboxnet.isChecked() && cekboxsa.isChecked()){
            outputahli.setText("Keahlian Anda : Teknik Komputer dan Jaringan & Multimedia");
        }else if(cekboxjava.isChecked()){
            outputahli.setText("Keahlian Anda : Rekayasa Perangkat Lunak");
        }else if(cekboxnet.isChecked()){
            outputahli.setText("Keahlian Anda : Teknik Komputer dan Jaringan");           
        }else if(cekboxsa.isChecked()){
            outputahli.setText("Keahlian Anda : Multimedia");
        }else{
            outputahli.setText("Keahlian Anda : ");
           
        }
        outputjk.setText(jk);
        fieldnama.setText("");
        fieldemail.setText("");
        cekboxjava.setChecked(false);
        cekboxsa.setChecked(false);
        cekboxnet.setChecked(false);
        groupjk.clearCheck();
    }
   
    @Override
    public void onCheckedChanged(RadioGroup group, int check) {
        // TODO Auto-generated method stub
        if(check==R.id.radiolk){
            jk="Jenis Kelamin : Laki-Laki";
           
        }else if(check==R.id.radiopr){
                jk="Jenis Kelamin : Perempuan";
               
        }else{
            jk="Jenis Kelamin :";
        }
       
    }

}