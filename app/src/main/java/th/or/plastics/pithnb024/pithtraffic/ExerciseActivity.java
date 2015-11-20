package th.or.plastics.pithnb024.pithtraffic;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ExerciseActivity extends AppCompatActivity {

    //Explicit
    private TextView questionTextView;
    private ImageView questionImageView;
    private RadioGroup choiceRadioGroup;
    private RadioButton choice1RadioButton,choice2RadioButton,
            choice3RadioButton,choice4RadioButton;

    private int radioAnInt,timesAnInt,scoreAnInt;//ตั้งค่า 1 2 3 4 ตอบคำถาม timesAnInt is มีกี่ข้อ
    //scoreAnInt คิดคะแนน


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        bindWidget();

        radioController();

    }//Main Method

    private void radioController() {
        choiceRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        radioAnInt = 1; // value
                        break;
                    case R.id.radioButton2:
                        radioAnInt = 2;
                        break;
                    case R.id.radioButton3:
                        radioAnInt = 3;
                        break;
                    case R.id.radioButton4:
                        radioAnInt = 4;
                        break;
                    default:
                        radioAnInt = 0;
                        break;
                }//switch
            }
        });
    }

    private void bindWidget() {
        questionTextView = (TextView) findViewById(R.id.txtQuestion);
        questionImageView = (ImageView) findViewById(R.id.imvQuestion);
        choiceRadioGroup = (RadioGroup) findViewById(R.id.ragChoice);
        choice1RadioButton = (RadioButton) findViewById(R.id.radioButton);
        choice2RadioButton = (RadioButton) findViewById(R.id.radioButton2);
        choice3RadioButton = (RadioButton) findViewById(R.id.radioButton3);
        choice4RadioButton = (RadioButton) findViewById(R.id.radioButton4);
    }

    public  void clickAnswer(View view) {
        //check Zero ว่ามีค่าไหม
        if (radioAnInt == 0) {
            Toast.makeText(ExerciseActivity.this,"Pleases Check Choice",Toast.LENGTH_SHORT).show();
            //true Alert
        } else {

            checkScore(); // ตรวจสอบคำตอบว่าถูกหรือเปล่า
            //false and have Answer
            if (timesAnInt == 4) { //ครบ4ข้อหรือยัง
                //สร้างโชว์คะแนน
                scoreDialog();

                //true
            } else {
                //false

                changeView();
                timesAnInt += 1; // ไม่เท่าให้บวก1
            }//if2

        }//if1


    }//clickAnswer

    private void checkScore() {
        // คิดคะแนน
        int[] intTrue = {1, 2, 3, 4, 1}; // นี้คือคำตอบที่ถูกต้อง ยัดคำตอบไปเลย
        if (radioAnInt == intTrue[timesAnInt]) {
            scoreAnInt += 1;
        }
    }

    private void changeView() {
        String[] strQuestion = new String[5];
        strQuestion[0] = "1. What is this";
        strQuestion[1] = "2. What is this";
        strQuestion[2] = "3. What is this";
        strQuestion[3] = "4. What is this";
        strQuestion[4] = "5. What is this";
        questionTextView.setText(strQuestion[timesAnInt+1]);

        int[] intImage = new int[5];
        intImage[0] = R.drawable.traffic_01;
        intImage[1] = R.drawable.traffic_02;
        intImage[2] = R.drawable.traffic_03;
        intImage[3] = R.drawable.traffic_04;
        intImage[4] = R.drawable.traffic_05;
        questionImageView.setImageResource(intImage[timesAnInt+1]);

        int[] intChoice = new int[5];
        intChoice[0] = R.array.times1;
        intChoice[1] = R.array.times2;
        intChoice[2] = R.array.times3;
        intChoice[3] = R.array.times4;
        intChoice[4] = R.array.times5;

        String[] strChoice = getResources().getStringArray(intChoice[timesAnInt + 1]);
        choice1RadioButton.setText(strChoice[0]);
        choice2RadioButton.setText(strChoice[1]);
        choice3RadioButton.setText(strChoice[2]);
        choice4RadioButton.setText(strChoice[3]);




    }

    private void scoreDialog() {
        AlertDialog.Builder objBuilder = new AlertDialog.Builder(this); //icon show need 48*48
        objBuilder.setIcon(R.drawable.icon_myaccount);
        objBuilder.setTitle("Score");
        objBuilder.setMessage("Score="+ Integer.toString(scoreAnInt));
        objBuilder.setCancelable(false);
        objBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            //ถ้าคลิกโอเค ไปหน้าแรกของเรา
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(ExerciseActivity.this, MainActivity.class));
                dialog.dismiss();
            }
        });
        objBuilder.show();
    }
}//Main Class
