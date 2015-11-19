package th.or.plastics.pithnb024.pithtraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //พื้นที่ที่ไว้ให้การศตัวแปร EXPLICIT
    private Button aboutMEButton;
    private ListView trafficListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Manager ( Bind widget เป็นการผูก widget ต้องทำเสมอ ผูกกับตัวแปร)
        bindWidget();// ใส่วงเล็บตัวแปร

        //ไว้ใช้ควบคุมปุ่ม Button Controller
        buttonController();

    }//Main method end ;

    private void buttonController() { //OnClickListener กดคลิกแล้วทำงานเลย
         aboutMEButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) { //(View v)(ประเภทตัวแปร ตัวแปร)

                 //sound
                 MediaPlayer buttonMediaPlayer = MediaPlayer.create(getBaseContext(),R.raw.dog); //getBaseContext อยู่ที่เดียวกับมัน
                 buttonMediaPlayer.start();
                 //internet to webview
                 Intent objIntent = new Intent(Intent.ACTION_VIEW);
                 objIntent.setData(Uri.parse("https://youtu.be/Jy35oa5oFoY"));
                 startActivity(objIntent);
             }// event
         });
    }

    private void bindWidget() {

        aboutMEButton = (Button) findViewById(R.id.button);//เป็นการผูกตัวแปรเข้าหากัน
        trafficListView = (ListView) findViewById(R.id.listView);

    }

} //Main Class
