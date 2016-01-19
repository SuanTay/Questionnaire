package fr.limos.questionnaire;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by taysuan on 18/01/2016.
 */
public class Main extends Activity implements View.OnClickListener {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Creating a new RelativeLayout
      /*  RelativeLayout masterrl = new RelativeLayout(this);

        // Defining the RelativeLayout layout parameters.
        // In this case I want to fill its parent
        RelativeLayout.LayoutParams masterrlp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.FILL_PARENT);
        masterrlp.addRule(RelativeLayout.ALIGN_PARENT_START);


        LinearLayout llSection = new LinearLayout(this);
        LinearLayout.LayoutParams paramllSection = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        llSection.setOrientation(LinearLayout.VERTICAL);


        // Creating a new TextView SECtion
        TextView tvsection = new TextView(this);
        tvsection.setText("Section");

        // Setting the parameters on the TextView
        tvsection.setLayoutParams(paramllSection);

        LinearLayout llQuestion = new LinearLayout(this);
        LinearLayout.LayoutParams paramllQuestion = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        llQuestion.setOrientation(LinearLayout.VERTICAL);

        // Creating a new TextView SECtion
        TextView tvquestion = new TextView(this);
        tvquestion.setText("question?");

        // Setting the parameters on the TextVie
        tvsection.setLayoutParams(paramllQuestion);

        // Adding the TextView to the RelativeLayout as a child
        masterrl.addView(tvsection);
// Adding the TextView to the RelativeLayout as a child
        masterrl.addView(tvquestion);


        // Setting the RelativeLayout as our content view
        setContentView(masterrl, masterrlp);*/
        buildUI();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://fr.limos.questionnaire/http/host/path")
        );

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction2 = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://fr.limos.questionnaire/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction2);
    }

    @Override
    public void onStop() {
        super.onStop();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction2 = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://fr.limos.questionnaire/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction2);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://fr.limos.questionnaire/http/host/path")
        );

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.disconnect();
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
        int i1=1;
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
        Toast toast = Toast.makeText(this, "You clicked button "+v.getId()+" " + v.getTag(), Toast.LENGTH_LONG);
        toast.show();

        // get the parent layout and remove the clicked button
        LinearLayout parentLayout = (LinearLayout) v.getParent();
        parentLayout.removeView(v);
    }
}
