package fr.limos.questionnaire;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import fr.limos.Handlers.DatabaseHandler;
import fr.limos.entities.Labelchu;
import fr.limos.util.DownloadDatabase;

/**
 * Created by taysuan on 18/01/2016.
 */
public class Main extends Activity implements View.OnClickListener {

    String downloadUrl = "http://localhost:8080/chu/Download/";
    String fileName = "chulite.sqlite3";
    String folder = "abcd";

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Database2Handler db2 = new Database2Handler(this);
//savoir ou est le lieu de téléchargement public
        Log.w("public download",Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString());


        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db2.addContact(new Contact("Ravi", "9100000000"));
        db2.addContact(new Contact("Srinivas", "9199999999"));
        db2.addContact(new Contact("Tommy", "9522222222"));
        db2.addContact(new Contact("Karthik", "9533333333"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");

        List<Contact>  contacts = db2.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
            Toast toast=Toast.makeText(this,log,Toast.LENGTH_LONG);
        }
        Log.d("Database Name: ", db2.getDatabaseName());
        //copy File




        //DownloadDatabase db2=new DownloadDatabase();
        //db2.DownloadDatabase(downloadUrl, folder, fileName);
        //Toast toast = Toast.makeText(this, "Les données sont télechargées" , Toast.LENGTH_LONG);
        //toast.show();
       // -----------------------
        String PACKAGE_NAME = getApplication().getPackageName();
        Log.w("Env package name", PACKAGE_NAME);

        File root = Environment.getDataDirectory();
        File downloadpublic=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        Log.w("Environement path", root.toString());
        File localdir = new File(root.getAbsolutePath() + "/data/" + PACKAGE_NAME + "/databases/chulite.sqlite3");
        File dowDB = new File (downloadpublic.getAbsolutePath()+"/chulite.sqlite3");
        DownloadDatabase.copyFile(dowDB,localdir);

        Log.w("absolute path", localdir.toString());
        if (localdir.exists() == false) Log.d("path Existe: ", "false");
        else Log.d("path Existe: ", "true");
        //-----------------------
//initialisation
     /*   File file = new File("/data/data/fr.limos.questionnaire/databases/");
        if (file.exists()) {
            final String command = "chmod 777 /data/data/fr.limos.questionnaire/";
            try {
                Process p = Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
                Log.w("Chomd","Failed");
            }
            boolean result = file.setExecutable(true);

            Log.e("intailisation", "trpb67, RESULT IS " + result);
        }
*/
        DatabaseHandler db = new DatabaseHandler(this);
// Reading all contacts
        Log.d("Reading: ", "Reading count..");
       int count = db.getLabelchusCount();
      Log.d("Nombre de label :", count + " ");
      List<Labelchu> labelchus = db.getAllLabelchus();

        for (Labelchu la : labelchus) {
            String log = "Id: " + la.getIdLabel() + "Short label " + la.getShortlabel() + " ,Labelfr: " + la.getLabelfr();
            // Writing Contacts to log
            Log.d("From Sqlite: ", log);
        }
        //buildUI();


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //Permission granted.
                    //Continue with writing files...
                }
                else{
                    //Permission denied.
                }
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();
    }


    void buildUI() {
        LinearLayout masterLayout = new LinearLayout(this);
        masterLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams paramsMasterLayout = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        masterLayout.setLayoutParams(paramsMasterLayout);
//Questionnaire
        TextView tvSection = new TextView(this);
        tvSection.setText("Survey");
        LinearLayout.LayoutParams paramsSectionLayout = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        tvSection.setLayoutParams(paramsSectionLayout);
        masterLayout.addView(tvSection);
//Section
        TextView tvQuestion = new TextView(this);
        tvQuestion.setText("Section 1");

        LinearLayout.LayoutParams paramsQuestionLayout = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        tvQuestion.setLayoutParams(paramsQuestionLayout);
        masterLayout.addView(tvQuestion);
//Question
        LinearLayout linearLayout_119 = new LinearLayout(this);
        linearLayout_119.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layout_140 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayout_119.setLayoutParams(layout_140);

        TextView textView_52 = new TextView(this);
        textView_52.setText("Q1");

        LinearLayout.LayoutParams layout_97 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        textView_52.setLayoutParams(layout_97);
        linearLayout_119.addView(textView_52);

        Button btncheck1 = new Button(this);
        btncheck1.setTag("aaa");
        btncheck1.setId(View.generateViewId());
        btncheck1.setOnClickListener(this);
        btncheck1.setText("Check");
        LinearLayout.LayoutParams layout_650 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        btncheck1.setLayoutParams(layout_650);
        linearLayout_119.addView(btncheck1);
        masterLayout.addView(linearLayout_119);
        //Question

        LinearLayout linearLayout_561 = new LinearLayout(this);
        linearLayout_561.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layout_483 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayout_561.setLayoutParams(layout_483);

        TextView textView_651 = new TextView(this);
        textView_651.setText("Q2");

        LinearLayout.LayoutParams layout_851 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        textView_651.setLayoutParams(layout_851);
        linearLayout_561.addView(textView_651);

        Button btncheck2 = new Button(this);
        int i1 = 1;
        btncheck2.setTag("bbb");
        btncheck2.setId(View.generateViewId());
        btncheck2.setText("Check");

        btncheck2.setOnClickListener(this);


        LinearLayout.LayoutParams layout_701 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        btncheck2.setLayoutParams(layout_701);
        linearLayout_561.addView(btncheck2);
        masterLayout.addView(linearLayout_561);
        //Question

        LinearLayout linearLayout_786 = new LinearLayout(this);
        linearLayout_786.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layout_629 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayout_786.setLayoutParams(layout_629);

        TextView textView_503 = new TextView(this);
        textView_503.setText("Q3");

        LinearLayout.LayoutParams layout_863 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        textView_503.setLayoutParams(layout_863);
        linearLayout_786.addView(textView_503);

        Button btncheck3 = new Button(this);

        btncheck3.setText("Check");
        btncheck3.setTag("ccc");
        btncheck3.setId(View.generateViewId());
        btncheck3.setOnClickListener(this);
        LinearLayout.LayoutParams layout_928 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        btncheck3.setLayoutParams(layout_928);
        linearLayout_786.addView(btncheck3);
        masterLayout.addView(linearLayout_786);
// fin Question
        TextView textView_381 = new TextView(this);
        textView_381.setText("Fin question");

        LinearLayout.LayoutParams paramsLayoutNext = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        textView_381.setLayoutParams(paramsLayoutNext);
        masterLayout.addView(textView_381);
//button Fin Question
        Button btnNext = new Button(this);

        btnNext.setText("Next");
        btncheck3.setTag("ddd");
        btnNext.setId(View.generateViewId());
        btnNext.setOnClickListener(this);
        LinearLayout.LayoutParams paramsNext = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        btnNext.setLayoutParams(paramsNext);
        masterLayout.addView(btnNext);

//
        setContentView(masterLayout, paramsMasterLayout);
    }


    @Override
    public void onClick(View v) {
        // show a message with the button's ID
        Toast toast = Toast.makeText(this, "You clicked button " + v.getId() + " " + v.getTag(), Toast.LENGTH_LONG);
        toast.show();

        // get the parent layout and remove the clicked button
        LinearLayout parentLayout = (LinearLayout) v.getParent();
        parentLayout.removeView(v);
    }
}
