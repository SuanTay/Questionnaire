package fr.limos.questionnaire;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.limos.WS.FillDB;
import fr.limos.db.DataBaseHelper;
import fr.limos.db.dao.AnswerHome;
import fr.limos.db.dao.LabelHome;
import fr.limos.db.dao.OrderHome;
import fr.limos.db.dao.PatientHome;
import fr.limos.db.dao.QuestionHome;
import fr.limos.db.dao.SectionHome;
import fr.limos.db.dao.SurveyHome;
import fr.limos.db.entities.Answer;
import fr.limos.db.entities.Order;
import fr.limos.db.entities.Patient;
import fr.limos.db.entities.Question;
import fr.limos.db.entities.Section;
import fr.limos.db.entities.Survey;


/**
 * Created by taysuan on 18/01/2016.
 */
public class Main extends Activity implements View.OnClickListener {

 public static int i = 0;
    final Context context = this;


    Button bValider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //creation si pas creer ?
        DataBaseHelper db = new DataBaseHelper(this);
        //Future WS
        FillDB fb = new FillDB(this);
        fb.dellAll();
        fb.addAll();
        //le patient
        //PatientHome ph=new PatientHome(this);
        Patient thisPatient = new Patient();
        thisPatient.setIdPatient(1);
        thisPatient.setCodepatient("sua.tay");

        //Next Question or Next Section
        next(thisPatient);
    }


    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();
    }

    void build2(final Context context, final Patient thispatient,Survey survey, Section section, Question question, final List<Answer> answerList) {

      final   LabelHome lh = new LabelHome(this);


        LinearLayout masterlayout = new LinearLayout(this);
        masterlayout.setOrientation(LinearLayout.VERTICAL);
        masterlayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        //texte Section
        TextView txtQuestionnaire = new TextView(this);
        txtQuestionnaire.setText(lh.getLabelFromInt(survey.getLabel()).getLabelfr());
        LinearLayout.LayoutParams par = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
       // par.weight = 0.1f;
        txtQuestionnaire.setLayoutParams(par);
        //txtQuestionnaire.setBackgroundColor(Color.YELLOW);

        masterlayout.addView(txtQuestionnaire);

        //texte Section
        TextView txtSection = new TextView(this);

        txtSection.setText(lh.getLabelFromInt(section.getLabel()).getLabelfr());
        LinearLayout.LayoutParams parSec = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
       // parSec.weight = 0.1f;
        txtSection.setLayoutParams(parSec);
       // txtSection.setBackgroundColor(Color.DKGRAY);

        masterlayout.addView(txtSection);
        //texte question
        TextView txtQuestion = new TextView(this);

        txtQuestion.setText(lh.getLabelFromInt(question.getLabel()).getLabelfr());
        LinearLayout.LayoutParams parQue = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //parQue.weight = 0.3f;
        txtQuestion.setLayoutParams(parQue);
        //txtQuestion.setBackgroundColor(Color.RED);
        masterlayout.addView(txtQuestion);

        //reponse
       final RadioGroup rg = new RadioGroup(this);
        int k = 0;

        LinearLayout.LayoutParams parRep1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
       // parRep1.weight = 0.1f;

        for (Answer answer : answerList) {
            k++;
            Log.w("conut answer", k + "");
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(lh.getLabelFromInt(answer.getLabel()).getLabelfr());
            radioButton.setId(k);
            radioButton.setLayoutParams(parRep1);
            rg.addView(radioButton);
        }
        //add  Radio Group
        masterlayout.addView(rg);

        bValider = new Button(this);


        bValider.setText("Valider");
        LinearLayout.LayoutParams parValider = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
       // parValider.weight = 0.1f;
        bValider.setLayoutParams(parValider);
        bValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next(thispatient);

                int selected_id=rg.getCheckedRadioButtonId();
                Log.w("selected",selected_id+"");
                Answer answerResult= new Answer();
                answerResult= answerList.get(selected_id-1);
                AnswerHome ah = new AnswerHome(context);
                ah.save(answerResult,thispatient);

                Log.w("Cliked id",lh.getLabelFromInt(answerResult.getLabel()).getLabelfr());
            }
        });
        masterlayout.addView(bValider);
        setContentView(masterlayout, masterlayout.getLayoutParams());

    }
    void builfin(){
        TextView txtMerci = new TextView(this);
        txtMerci.setText("Merci!");
        setContentView(txtMerci);
    }

    public void next(Patient thispatient) {

        i++;



        Log.w("order", "1 order"+i);
        OrderHome oh = new OrderHome(this);
        Order order = new Order();
        order = oh.getOrderFromInt(i);
        //fin questionnaire
        if (order==null) {
            builfin();

        }
        Log.w("survey", "survey");
        //moteur
        //1 Questionnaire
        Log.w("1 Questionnaire", "1 Questionnaire");
        SurveyHome surh = new SurveyHome(this);
        Survey survey = new Survey();
        survey = surh.getSurveyFromId(order.getId_survey());
        Log.w("section", "section");
        //1 Section
        SectionHome sh = new SectionHome(this);
        Section section = new Section();
        section = sh.getSectionFromId(order.getId_section());
        Log.w("question", "question");

        //1 question
        QuestionHome qh = new QuestionHome(this);
        Question question = new Question();
        question = qh.getQuestionFromId(order.getId_question());

        Log.w("answerlist", "answerlist");
        //les reponses possible
        AnswerHome ah = new AnswerHome(this);
        List<Answer> answerList = new ArrayList<Answer>();
        answerList = ah.getForQuestion(question.getId_question());
        //affichage
        build2(this,thispatient, survey, section, question, answerList);
    }

    @Override
    public void onClick(View v) {

    }



    public int getI() {
        return i;
    }

    public void setI(int i) {
        Main.i = i;
    }
}
