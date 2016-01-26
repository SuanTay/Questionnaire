package fr.limos.questionnaire;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by taysuan on 26/01/2016.
 */
public class SectionLayout extends LinearLayout {
    public SectionLayout(Context context) {
        super(context);
        //Section
        setOrientation(LinearLayout.HORIZONTAL);
        //parametre master
        LayoutParams paramsMasterLayout = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        //set des parametre
        setLayoutParams(paramsMasterLayout);
        //test Section
        TextView tvSection = new TextView(context);
        tvSection.setText("Section");

        //parametre section
        LayoutParams paramstvSection = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        tvSection.setLayoutParams(paramstvSection);
        addView(tvSection);

        //ajouter Questionlayout
        QuestionLayout questionlayout = new QuestionLayout(context);
        Log.w("addView:", "questionlayout");
        addView(questionlayout);
    }
}