package com.wings.evententries;

import android.content.Intent;
import android.location.Address;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieSyncManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieManager;
import java.nio.Buffer;


public class MainActivity extends AppCompatActivity{
    EditText name,email,contact,college;
    Spinner branch,year,event;
    Button submit,newrec;
    private String[] spinnerbranch;
    private String[] spinneryear;
    private String[] spinnerevent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*this.spinnerbranch = new String[] {
                "Computer Science and Engineering", "Information Technology", "Electronics and Telecommunication Engineering", "Mechanical Engineering",
                "Electrical Engineering","Masters of Computer Application","Civil Engineering","Others"};
        branch = (Spinner) findViewById(R.id.spinner_branch);
        ArrayAdapter<String> adapter_1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, spinnerbranch);
        branch.setAdapter(adapter_1);//branch*/
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Event Entries");

        this.spinnerbranch = new String[] {
                "Computer Science and Engineering", "Information Technology", "Electronics and Telecommunication Engineering", "Mechanical Engineering",
                "ELectrical Engineering","MCA","Civil Engineering","Others"};
        branch = (Spinner) findViewById(R.id.spinner_branch);
        ArrayAdapter<String> adapter_1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, spinnerbranch);
        branch.setAdapter(adapter_1);//branch refined

        this.spinneryear = new String[] {
                "First year","Second year","Third year","Fourth year"};
        year = (Spinner) findViewById(R.id.spinner_year);
        ArrayAdapter<String> adapter_2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, spinneryear);
        year.setAdapter(adapter_2);//year

        this.spinnerevent = new String[] {
                "Web Quest 3.0","Virtual Campus","CodeSprint","Murder Mystery","Code Junkie 2.0",
                "High Tech Fair","Photografia","Treasure Hunt","LAN Gaming-CS","LAN Gaming-MW","LAN Gaming-FIFA","LAN Gaming-SmackDown","LAN Gaming-CrashDay"
                ,"Talent Profile","Pick n' Place","Robo Soccer","Paper Presentation","Robo Race",
                "Encrypto","Bolly Blaster","Spell Ur Brain","Line Follower","Conquer It","Plan Ur Smart City",
                "Paper Bridgemaking","Thedosurf","3D Modelling","Box Cricket"
                ,"C Ladder","Short Film Festival","Hardware Garage","Googler","Energy Contraption"
                };
        event = (Spinner) findViewById(R.id.spinner_ename);
        ArrayAdapter<String> adapter_3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, spinnerevent);
        event.setAdapter(adapter_3);//event

        name=(EditText)findViewById(R.id.editname);
        email=(EditText)findViewById(R.id.editemail);
        contact=(EditText)findViewById(R.id.editcontact);
        college=(EditText)findViewById(R.id.editcollege);
        submit=(Button)findViewById(R.id.submit_but);
        newrec=(Button)findViewById(R.id.button_record);

        ////////////////////////////////////////////////////////////////////////



        ///////////////////////////////////////////////////////////////////////
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CSVWriter writer = null;
//                String file = "entries.txt";

                File folder = new File(Environment.getExternalStorageDirectory() +
                        File.separator + "Entries");
                boolean success = true;
                if (!folder.exists()) {
                    success = folder.mkdir();
                }
                int count=0;

                try
                {
                    String name_store=name.getText().toString();
                    String email_store=email.getText().toString();
                    String contact_store=contact.getText().toString();
                    String college_store=college.getText().toString();
                    String branch_store=branch.getSelectedItem().toString();
                    String year_store=year.getSelectedItem().toString();
                    String event_store=event.getSelectedItem().toString();


                        File entries_serial=new File(Environment.getExternalStorageDirectory().getAbsolutePath() +File.separator+"Entries"+File.separator +"entries_serial.dat");
                        if(success) {
                            try {
                                if(entries_serial.exists()==false){
                                    entries_serial.createNewFile();
                                    FileWriter write=new FileWriter(entries_serial);
                                    String add=String.valueOf(count);
                                    write.append(add);
                                    write.close();
                                }
                                BufferedReader br = new BufferedReader(new FileReader(entries_serial));
                                count=Integer.parseInt(br.readLine())+1;

                                FileWriter write=new FileWriter(entries_serial);
                                String add=String.valueOf(count);
                                write.append(add);
                                write.close();

                                br.close();
                            }
                            catch (IOException e)
                            {
                                Toast.makeText(getApplicationContext(),"Error in Initialisation",Toast.LENGTH_SHORT);
                            }
                        }
                        if(contact_store.length()!=10)
                        {
                            Toast.makeText(getApplicationContext(),"Invalid Contact",Toast.LENGTH_SHORT);
                        }
                        else {
////////////////////////////////////////////////////////////////////////////////////////////////////
//                    USELESS CODE
//                    //
//                    File sdDir = Environment.getExternalStorageDirectory();
//
//
//                    //
//                    FileOutputStream fOut = openFileOutput(sdDir, MODE_WORLD_READABLE);
//
//                    fOut.write(name_store.getBytes());
//                    fOut.close();
//                    try {
//                        File exportDir = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),"entries.txt");
//                        if (exportDir .getParentFile().mkdirs()) {
//                            exportDir .createNewFile();
//                            FileOutputStream fos = new FileOutputStream(exportDir );
//
//                            fos.write(name_store.toString().getBytes());
//                            fos.flush();
//                            fos.close();
//                        }
//                    } catch (Exception e) {
//                        Toast.makeText(getApplicationContext(),"Failed to write to file",Toast.LENGTH_SHORT).show();
//                    }
//                    Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
////////////////////////////////////////////////////////////////////////////////////////////////////
                        File folder_1 = new File(Environment.getExternalStorageDirectory() +
                                File.separator + "Entries");
                        boolean success_1 = true;
                        if (!folder.exists()) {
                            success_1 = folder_1.mkdir();
                        }
                        if (success_1) {
//                        writer = new CSVWriter(new FileWriter(Environment.getExternalStorageDirectory().getAbsolutePath() +File.separator+"Entries"+File.separator +"entries_wings.csv"), ',');
//                        String[] entries = (name_store + "," + email_store + "," + contact_store + "," + college_store + "," + branch_store + "," + year_store + "," + event_store+"\n").split(","); // array of your values
//                        writer.writeNext(entries);//same record is being updated;TODO: CHECK BUG
//                        Toast.makeText(getApplicationContext(), "Record successfully added", Toast.LENGTH_SHORT).show();
//                        writer.close();
                            File entries = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Entries" + File.separator + "entries_wings" + String.valueOf(count) + ".dat");
                            if (entries.exists() == false) {
                                entries.createNewFile();
                            }
                            //TODO:CODE NOT REQUIRED ANYMORE
//                        FileReader read=new FileReader(entries);
//                        Toast.makeText(getApplicationContext(),read.toString(),Toast.LENGTH_SHORT);
//                        BufferedReader br=new BufferedReader(new FileReader(entries));
//                        try
//                        {
//                            StringBuilder sb = new StringBuilder();
//                            String line = br.readLine();
//
//                            while (line != null) {
//                                sb.append(line);
//                                sb.append("\n");
//                                line = br.readLine();
//                            }
//                            Toast.makeText(getApplicationContext(),sb.toString(),Toast.LENGTH_SHORT);
//                        }catch(IOException e){
//                            Toast.makeText(getApplicationContext(),"Failure",Toast.LENGTH_SHORT);
//                        }
//                        finally{
//                            br.close();
//                        }
                            PrintWriter out = new PrintWriter(new FileWriter(entries));
                            out.append(name_store + "," + email_store + "," + contact_store + "," + college_store + "," + branch_store + "," + year_store + "," + event_store + "\n");
                            Toast.makeText(getApplicationContext(), "Record successfully added", Toast.LENGTH_SHORT).show();
                            out.close();
                            } else {
                                Toast.makeText(getApplicationContext(), "Failed to create folder for saving files", Toast.LENGTH_SHORT);
                            }
                        }

                }
                catch (IOException e)
                {
                    Toast.makeText(getApplicationContext(),"Failed to write to file",Toast.LENGTH_SHORT).show();
                }

            }
        });

        newrec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
    }
}
//App Perfectly Working
