package com.example.tania.testquizzapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**import com.example.android.managementquizz.R;*/

import com.example.tania.testquizzapp.R;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int totalCount;
    int totalCountFeedback;
    int totalCountRadioButton;
    int totalCountGig;
    int totalCountGoals;
    int totalValue;
    int totalValueGig;
    int totalValueGoals;
    boolean hasanswer1 = false;
    boolean hasanswer2 = false;
    boolean hasanswer3 = false;
    boolean hasanswerGig1 = false;
    boolean hasanswerGig2 = false;
    boolean hasanswerGig3 = false;
    boolean hasanswerGoals1 = false;
    boolean hasanswerGoals2 = false;
    boolean hasanswerGoals3 = false;
    boolean feedbackAnswered = false;
    boolean gigAnswered = false;
    boolean goalsAnswered = false;
    boolean radioAnswered = false;
    boolean checkedQuestionOne = false;
    boolean checkedQuestionGoals = false;
    boolean checkedQuestionGig = false;
    boolean checkedRadioButton = false;
    boolean freeTextAnswered = false;
    int questionOne = 0;
    String textFeedback = "";
    String textFeedbackGig = "";
    String textFeedbackGoals = "";
    String textFeedbackNoAnswers = "Please answer all of the questions.";
    String answerRadioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView myImage = (ImageView) findViewById(R.id.management_quizz);
        myImage.setAlpha(20);
        //value: [0-255]. Where 0 is fully transparent and 255 is fully opaque.
    }


    /**
     * This method displays what happens, when the radio buttons are clicked.
     */
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        checkedRadioButton = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_yes:
                if (checkedRadioButton) {
                    // This answer is right
                    answerRadioButton = "This is correct. The 10h rule applies to all employees by law.";
                    totalCountRadioButton = 1;
                    radioAnswered = true;
                }
                break;
            case R.id.radio_no:
                if (checkedRadioButton)
                    // This answer is wrong
                    answerRadioButton = "Wrong, the 10h rule applies to all employees by law.";
                totalCountRadioButton = 0;
                radioAnswered = true;
                break;
        }
        Log.v("in radioBox", "" + totalCountRadioButton);
    }

    /**
     * this method checks input for Feedback questions
     */
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        int valuechecked;
        int questionOne1 = 0;
        int questionOne2 = 0;
        int questionOne3 = 0;

        checkedQuestionOne = ((CheckBox) view).isChecked();
        if (checkedQuestionOne) {
            valuechecked = 1;
            questionOne = 1;
        } else {
            valuechecked = 0;
            questionOne = 0;
            textFeedback = "Please check  one box! \n";
            Log.v("checkedQuestionOne", "valuechecked" + valuechecked);
        }

        /** which boxes are checked? */
        CheckBox checkBoxFeedback = (CheckBox) findViewById(R.id.checkbox_criticism);
        hasanswer1 = checkBoxFeedback.isChecked();
        if (hasanswer1) valuechecked = 1;
        else valuechecked = 0;
        Log.v("hasanswer1", "hasanswer1" + valuechecked);
        if (hasanswer1) {
            questionOne1 = 1;
            Log.v("hasanswer1", "questionOne1" + questionOne1);
        }
        checkBoxFeedback = findViewById(R.id.checkbox_request);
        hasanswer2 = checkBoxFeedback.isChecked();
        if (hasanswer2) {
            questionOne2 = 2;
            Log.v("hasanswer2", "questionOne2" + questionOne2);
        }

        checkBoxFeedback = findViewById(R.id.checkbox_judgmental);
        hasanswer3 = checkBoxFeedback.isChecked();
        if (hasanswer3) {
            questionOne3 = 5;
            Log.v("hasanswer3", "questionOne3" + questionOne3);
        }
        totalValue = questionOne1 + questionOne2 + questionOne3;
        Log.v("totalValue", "is " + totalValue);


        /** is the first box checked? i.e. feedback is used for criticism */
        /**
         * CheckBox checkBoxFeedback = (CheckBox) findViewById(R.id.checkbox_criticism);
         * hasanswer1 = checkBoxFeedback.isChecked();
         */
        String str = String.valueOf(hasanswer1);


        switch (totalValue)

        {
            case 0:
                textFeedback = "Please check at least one box!";
                totalCountFeedback = 0;
                break;
            case 1:
                textFeedback = "Incorrect, if feedback is only used to criticise, it will not be asked for.";
                break;
            case 2:
                textFeedback = "Correct, the person asking for feedback can also specify the area they would like to be given feedback in.";
                totalCountFeedback = 1;
                break;
            case 3:
                textFeedback = "Checkbox one is incorrect,if feedback is only used to criticise it will not be asked for. \n Checkbox 2 is correct, the person asking for feedback can also specify the area they would like to be given feedback in.";
                totalCountFeedback = 1;
                break;
            case 5:
                textFeedback = "That is correct, feedback is best, when it only describes and does not grade.";
                totalCountFeedback = 1;
                break;
            case 6:
                textFeedback = " Checkbox one is incorrect,if feedback is only used to criticise it will not be asked for.\n Checkbox three is correct, feedback is best, when it only describes and does not grade.";
                totalCountFeedback = 1;
                break;
            case 7:
                textFeedback = " Both answers are correct, the person asking for feedback can also specify the area they would like to be given feedback in. Feedback is best, when it only describes and does not grade.";
                totalCountFeedback = 2;
                break;
            case 8:
                textFeedback = " Checkbox one is incorrect,if feedback is only used to criticise it will not be asked for.\n Checkbox two and three are correct, \nfeedback is best, when it only describes and does not grade.";
                totalCountFeedback = 2;
                break;
        }

    }

    /**
     * This method compiles the answer for the feedback question of the quizz
     * depending on the right answers and collects them in String textFeedback.
     */

    public void submitOrder1(View view) {

        Context context = getApplicationContext();
        Log.v("in submitOrder1", "checkedQuestionOne= " + checkedQuestionOne);
        if (hasanswer1 || hasanswer2 || hasanswer3) {

            Toast.makeText(context, textFeedback, Toast.LENGTH_LONG).show();
            feedbackAnswered = true;
        } else {
            textFeedback = "Please check at least one box!!";
            Toast.makeText(context, textFeedback, Toast.LENGTH_LONG).show();
            textFeedback = "";
            feedbackAnswered = false;
        }
        if (hasanswer1) Log.v("in submitOrder1", "hasanswer1= " + hasanswer1);


    }

    /**
     * This method compiles the answer for the Gig Economy question of the quizz
     * depending on the right answers and collects them in String textFeedback.
     */

    public void submitOrder3(View view) {


        Context context = getApplicationContext();
        Log.v("in submitOrder3", "checkedQuestionOne= " + checkedQuestionOne);
        if (hasanswerGig1 || hasanswerGig2 || hasanswerGig3) {

            Toast.makeText(context, textFeedbackGig, Toast.LENGTH_LONG).show();
            gigAnswered = true;
        } else {
            textFeedbackGig = "Please check at least one box!!";
            Toast.makeText(context, textFeedbackGig, Toast.LENGTH_LONG).show();
            textFeedbackGig = "";
            gigAnswered = false;
        }
        if (hasanswerGig1) Log.v("in submitOrder3", "hasanswerGig1= " + hasanswerGig1);


    }


    /**
     * This method shows a toast upon pressing the submit button and displays the score for the radio button question
     */

    public void submitOrder2(View view) {
        String summaryText2 = "";
        summaryText2 = answerRadioButton;
        Context context = getApplicationContext();
        Toast.makeText(context, summaryText2, Toast.LENGTH_LONG).show();


    }


    /**
     * this method checks input for Gig Economy questions
     */
    public void onCheckboxClickedGig(View view) {
        // Is the view now checked?
        int valuechecked;
        int questionOne1 = 0;
        int questionOne2 = 0;
        int questionOne3 = 0;

        checkedQuestionGig = ((CheckBox) view).isChecked();
        if (!checkedQuestionGig) {
            valuechecked = 0;
            textFeedbackGig = "Please check on GIG one box! \n";
            Log.v("checkedQuestionOneGig", "valuechecked" + valuechecked);
        }

        /** which boxes are checked? */
        CheckBox checkBoxGig = (CheckBox) findViewById(R.id.checkbox_right_answer);
        hasanswerGig1 = checkBoxGig.isChecked();
        if (hasanswerGig1) valuechecked = 1;
        else valuechecked = 0;
        Log.v("hasanswergig1", "hasanswergig1" + valuechecked);
        if (hasanswerGig1) {
            questionOne1 = 1;
            Log.v("hasanswergig1", "questionGigOne1" + questionOne1);
        }
        checkBoxGig = findViewById(R.id.checkbox_gadgets);
        hasanswerGig2 = checkBoxGig.isChecked();
        if (hasanswerGig2) {
            questionOne2 = 3;
            Log.v("hasanswerGig2", "questionGigOne2" + questionOne2);
        }

        checkBoxGig = findViewById(R.id.checkbox_freelance_artist);
        hasanswerGig3 = checkBoxGig.isChecked();
        if (hasanswerGig3) {
            questionOne3 = 5;
            Log.v("hasanswerGig3", "questionGigOne3" + questionOne3);
        }
        totalValueGig = questionOne1 + questionOne2 + questionOne3;
        Log.v("totalValueGig", "is " + totalValueGig);


        switch (totalValueGig)

        {
            case 0:
                textFeedbackGig = "nothing checked, ";
                break;
            case 1:
                textFeedbackGig = "Correct, gig economy refers to the way jobs will be assigned in future.";
                totalCountGig = 1;
                break;
            case 3:
                textFeedbackGig = "Incorrect, gig economy has nothing to do with gimmicks.";
                totalCountGig = 0;
                break;
            case 5:
                textFeedbackGig = "Incorrect, gigs are not to be confused with gig economy.";
                totalCountGig = 0;
                break;
            default:
                textFeedbackGig = "You have checked more than one box, please clear all but one boxes";


        }
    }

    /**
     * This method compiles the answer for the goals-related questions of the quizz
     * depending on the right answers and collects them in String textFeedbackGoals.
     */

    public void submitOrder4(View view) {

        Context context = getApplicationContext();
        Log.v("in submitOrder4", "checkedQuestionOne= " + checkedQuestionGoals);
        Log.v("in submitOrder4", "totalCountGoals= " + totalCountGoals);
        if (hasanswerGoals1 || hasanswerGoals2 || hasanswerGoals3) {

            Toast.makeText(context, textFeedbackGoals, Toast.LENGTH_LONG).show();
            goalsAnswered = true;
        } else {
            textFeedbackGoals = "Please check at least one box!!";
            Toast.makeText(context, textFeedbackGoals, Toast.LENGTH_LONG).show();
            textFeedbackGoals = "";
            goalsAnswered = false;
        }


    }


    /**
     * this method checks input for goals-related questions
     */
    public void onCheckboxClickedGoals(View view) {
        // Is the view now checked?
        int valuechecked;
        int questionOne1 = 0;
        int questionOne2 = 0;
        int questionOne3 = 0;

        checkedQuestionGoals = ((CheckBox) view).isChecked();
        if (!checkedQuestionGoals) {
            valuechecked = 0;
            textFeedbackGoals = "Please check on Goals one box! \n";
            Log.v("checkedQuestionOneGoals", "valuechecked" + valuechecked);
        }

        /** which boxes are checked? */
        CheckBox checkBoxGoals = (CheckBox) findViewById(R.id.checkbox_the_right_answer);
        hasanswerGoals1 = checkBoxGoals.isChecked();
        if (hasanswerGoals1) {
            questionOne1 = 1;
            Log.v("hasanswergoals1", "questionGoalsOne1" + questionOne1);
        }
        checkBoxGoals = findViewById(R.id.checkbox_vague);
        hasanswerGoals2 = checkBoxGoals.isChecked();
        if (hasanswerGoals2) {
            questionOne2 = 3;
            Log.v("hasanswerGoals2", "questionGoalsOne2" + questionOne2);
        }

        checkBoxGoals = findViewById(R.id.checkbox_no_goals);
        hasanswerGoals3 = checkBoxGoals.isChecked();
        if (hasanswerGoals3) {
            questionOne3 = 5;
            Log.v("hasanswerGoals3", "questionGoalsOne3" + questionOne3);
        }
        totalValueGoals = questionOne1 + questionOne2 + questionOne3;
        Log.v("totalValueGoals", "is " + totalValueGoals);


        switch (totalValueGoals)

        {
            case 0:
                textFeedbackGoals = "nothing checked, ";
                break;
            case 1:
                textFeedbackGoals = "Correct, ";
                totalCountGoals = 1;
                break;
            case 3:
                textFeedbackGoals = "Incorrect, goals must be measurable.";
                totalCountGoals = 0;
                break;
            case 5:
                textFeedbackGoals = "Incorrect, leading by objectives requires setting goals.";
                totalCountGoals = 0;
                break;
            default:
                textFeedbackGoals = "You have checked more than one box, please clear all but one boxes";


        }
        Log.v("oncheckboxclickedgoals", "totalCountGoals= " + totalCountGoals);
    }


    /**
     * This method compiles the answer for the feedback question of the quizz
     * depending on the right answers and collects them in String textFeedback.
     */

    public void submitOrder(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        Editable nameEditable = nameField.getText();
        String favourite = nameEditable.toString();
        String summaryText = "";
        if (TextUtils.isEmpty(favourite)) {
            summaryText = "please type in the text field";
            Context context = getApplicationContext();
            Toast.makeText(context, summaryText, Toast.LENGTH_LONG).show();
            freeTextAnswered = false;
            return;
        } else {
            freeTextAnswered = true;
            Log.v("favourite", "=" + favourite);
        }


        Context context = getApplicationContext();
        if (feedbackAnswered && gigAnswered && goalsAnswered && radioAnswered && freeTextAnswered) {
            totalCount = totalCountFeedback + totalCountRadioButton + totalCountGig + totalCountGoals;
            summaryText = "Thank you for completing the quiz. You have reached " + totalCount + " of 5 points";

            Log.v("Total score is", "totalCount" + totalCount);
            Log.v("TotalCountFeedback", " " + totalCountFeedback);
            Log.v("TotalCountRadioButton", " " + totalCountRadioButton);
            Log.v("TotalValueGig", " " + totalCountGig);
            Log.v("TotalCountGoals", " " + totalCountGoals);
            totalCount = 0;
            Toast.makeText(context, summaryText, Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(context, textFeedbackNoAnswers, Toast.LENGTH_LONG).show();
            totalCount = 0;
        }


    }


}
