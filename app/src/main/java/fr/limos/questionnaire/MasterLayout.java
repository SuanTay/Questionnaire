package fr.limos.questionnaire;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by taysuan on 26/01/2016.
 */
public class MasterLayout extends LinearLayout  {


    public MasterLayout(Context context) {
        super(context);
        setOrientation(LinearLayout.HORIZONTAL);
        //parametre master
        LayoutParams paramsMasterLayout = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        //set des parametre
        setLayoutParams(paramsMasterLayout);
        //test Questionnaire
        TextView tvQuestionnaire = new TextView(context);
        tvQuestionnaire.setText("Survey");

        //parametre section
        LayoutParams paramstvQuestionnaire = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        tvQuestionnaire.setLayoutParams(paramstvQuestionnaire);
        addView(tvQuestionnaire);

        //ajouter Sectionlayout
        SectionLayout sectionlayout = new SectionLayout(context);
        Log.w("addView:", "sectionlayout");
        addView(sectionlayout);


    }


}
