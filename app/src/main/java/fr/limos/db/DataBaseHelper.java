package fr.limos.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by taysuan on 22/01/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "chu";

    //  tables name
    private static final String TABLE_PATIENT = "   patient";
    private static final String TABLE_SCHEDULE = "schedule";
    private static final String TABLE_SURVEY = "survey";
    private static final String TABLE_SECTION = "section";
    private static final String TABLE_SIMPL3ESECTION = "simplesection";
    private static final String TABLE_QUESTION = "question";
    private static final String TABLE_SIMPLEQUESTION = "simplequestion";
    private static final String TABLE_CHOICE = "choice";
    private static final String TABLE_ANSWER = "answer";
    private static final String TABLE_RESULT = "result";
    private static final String TABLE_ORDER = "order";

    private static DataBaseHelper instance;

    // Contacts Table Columns names
    public static synchronized DataBaseHelper getHelper(Context context) {
        if (instance == null)
            instance = new DataBaseHelper(context);
        return instance;
    }

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_PATIENT = "create table patient(id_patient int(11) not null, codepatient varchar(7) not null,primary key(id_patient))";
        String CREATE_TABLE_SCHEDULE = "create table `schedule` (" +
                "  `id_schedule` int(11) not null ," +
                "  `startdate` date not null," +
                "  `enddate` date not null," +
                "  `devicestate` varchar(255) default null," +
                "  `wearablestate` varchar(255) default null," +
                "  `internet` varchar(255) default null," +
                "  `version` int(11) not null default '1'," +
                "  `fk_id_patient` int(11) not null," +
                "  `fk_id_survey` int(11) not null," +
                "  primary key (`id_schedule`)" +
                ") ";
        String CREATE_TABLE_SURVEY = "create table `survey` (" +
                "  `id_survey` int(11) not null ," +
                "  `startdate` date not null," +
                "  `enddate` date not null," +
                "  `defaultfrequency` int(11) not null," +
                "  `status` varchar(50) not null ," +
                "  `fk_id_label` int(11) not null," +
                "  primary key (`id_survey`))";
        String CREATE_TABLE_SECTION = "create table `section` (" +
                "  `id_section` int(11) not null ," +
                "  `fk_id_survey` int(11) not null," +
                "  `frenquency` int(11) default null ," +
                "  `ordersection` int(11) not null," +
                "  `fk_id_label` int(11) not null," +
                "  primary key (`id_section`,`fk_id_survey`))";
        String CREATE_TABLE_NORMALSECTION = "create table `normalsection` (" +
                "  `id_section` int(11) not null," +
                "  `fk_id_survey` int(11) not null," +
                "  primary key (`id_section`,`fk_id_survey`)" +
                ")";
        String CREATE_TABLE_QUESTION = "create table `question` (" +
                "  `id_question` int(11) not null ," +
                "  `orderquestion` int(11) not null," +
                "  `fk_id_section` int(11) not null," +
                "  `fk_id_survey` int(11) not null," +
                "  `fk_id_label` int(11) not null," +
                "  `fk_answerid_answer` int(11) default null," +
                "  `fk_answerfk_questionforagreid_questionforagre` int(11) not null," +
                "  `fk_answerfk_choicefk_normalsectionfk_surveyid_survey` int(11) not null," +
                "  `fk_answerfk_choicefk_normalsectionid_section` int(11) not null," +
                "  `fk_answerfk_choiceid_question` int(11) not null," +
                "  primary key (`id_question`,`fk_id_section`,`fk_id_survey`));";
        String CREATE_TABLE_SIMPLEQUESTION = "create table `simplequestion` (" +
                "  `fk_id_question` int(11) not null," +
                "  `fk_id_section` int(11) not null," +
                "  `fk_id_survey` int(11) not null," +
                "  `fk_complexquestionfk_normalsectionfk_surveyid_survey` int(11) default null," +
                "  `fk_complexquestionfk_normalsectionid_section` int(11) default null," +
                "  `fk_complexquestionid_question` int(11) default null," +
                "  primary key (`fk_id_question`,`fk_id_section`,`fk_id_survey`)" +
                ") ";
        String CREATE_TABLE_CHOICE = "create table `choice` (" +
                "  `fk_id_question` int(11) not null," +
                "  `fk_id_survey` int(11) not null," +
                "  `fk_id_section` int(11) not null," +
                "  `multiple` tinyint(1) not null default '0'," +
                "  primary key (`fk_id_question`,`fk_id_section`,`fk_id_survey`)" +
                ") ;";
        String CREATE_TABLE_ANSWER = "create table `answer` (" +
                "  `id_answer` int(11) not null ," +
                "  `orderanswer` int(11) not null," +
                "  `metricforagreg` int(11) default null," +
                "  `fk_id_agregation` int(11) default null," +
                "  `fk_id_questionforagre` int(11) default null," +
                "  `fk_id_survey` int(11) not null," +
                "  `fk_id_section` int(11) not null," +
                "  `fk_id_question` int(11) not null," +
                "  `fk_id_label` int(11) not null," +
                "  primary key (`id_answer`,`fk_id_question`,`fk_id_section`,`fk_id_survey`));";
        String CREATE_TABLE_RESULT = "create table `result` (" +
                "  `id_result` int(11) not null ," +
                "  `fk_id_survey` int(11) not null," +
                "  `fk_id_section` int(11) not null," +
                "  `fk_id_patient` int(11) not null," +
                "  `fk_textid_question` int(11) default null," +
                "  `fk_rankingid_question` int(11) default null," +
                "  `fk_choiceid_question` int(11) default null," +
                "  `fk_id_questionforagre` int(11) default null," +
                "  `fk_id_answer` int(11) default null," +
                "  `currentdate` timestamp not null default current_timestamp," +
                "  `value` varchar(500) not null," +
                "  primary key (`id_result`)" +
                ") ";
        String CREATE_TABLE_LABELCHU = "create table `labelchu` (" +
                "  `id_label` int(11) not null," +
                "  `shortlabel` varchar(50) not null," +
                "  `labelfr` varchar(255) not null," +
                "  `labelen` varchar(255) default null," +
                "  `commentfr` varchar(500) default null," +
                "  `commenten` varchar(500) default null," +
                "  `unitefr` varchar(20) default null," +
                "  `uniteen` varchar(20) default null," +
                "  primary key (`id_label`) )";
        String CREATE_TABLE_ORDER = "create table `order` (" +
                "id_order integer not null PRIMARY KEY   AUTOINCREMENT," +
                "id_survey int(11)not null," +
                "id_section int(11)not null," +
                "id_question int(11)not null," +
                "ordersection int(11)not null," +
                "orderquestion int(11)not null," +
                "frequency int(11)not null);";

        Log.w("creat DB",db.getPath());
        db.execSQL(CREATE_TABLE_PATIENT);
        db.execSQL(CREATE_TABLE_SCHEDULE);
        db.execSQL(CREATE_TABLE_SURVEY);
        db.execSQL(CREATE_TABLE_SECTION);
        db.execSQL(CREATE_TABLE_NORMALSECTION);
        db.execSQL(CREATE_TABLE_QUESTION);
        db.execSQL(CREATE_TABLE_SIMPLEQUESTION);
        db.execSQL(CREATE_TABLE_CHOICE);
        db.execSQL(CREATE_TABLE_ANSWER);
        db.execSQL(CREATE_TABLE_RESULT);
        db.execSQL(CREATE_TABLE_LABELCHU);
        db.execSQL(CREATE_TABLE_ORDER);

        Log.w("Fin CREATION DE LA BASE", db.getPath());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }




}
