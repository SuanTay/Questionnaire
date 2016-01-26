package fr.limos.questionnaire;

import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by taysuan on 26/01/2016.
 */
public class QuestionLayout extends LinearLayout {
    
    public QuestionLayout(Context context){
        super(context);
        setOrientation(LinearLayout.HORIZONTAL);
        //parametre Question
        LayoutParams paramsQuestionLayout = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        //set des parametre
        setLayoutParams(paramsQuestionLayout);
        //test Questionnaire
        TextView tvQuestion = new TextView(context);
        tvQuestion.setText("Question ");

        //parametre section
        LayoutParams paramstvQuestionnaire = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        tvQuestion.setLayoutParams(paramstvQuestionnaire);
        addView(tvQuestion);
        Log.w("addView:", "tvQuestion");

    }
}
