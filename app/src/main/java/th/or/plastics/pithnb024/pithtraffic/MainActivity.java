package th.or.plastics.pithnb024.pithtraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        //create listview
        createListView();

    }//Main method end ;

    private void createListView() {

        //Assige icon  แหล่งกำเนิดภาพ
        final int[] intIcon = {R.drawable.traffic_01, R.drawable.traffic_02,
                R.drawable.traffic_03, R.drawable.traffic_04,
                R.drawable.traffic_05, R.drawable.traffic_06,
                R.drawable.traffic_07, R.drawable.traffic_09,
                R.drawable.traffic_09, R.drawable.traffic_10,
                R.drawable.traffic_11, R.drawable.traffic_12,
                R.drawable.traffic_13, R.drawable.traffic_14,
                R.drawable.traffic_15, R.drawable.traffic_16,
                R.drawable.traffic_17, R.drawable.traffic_18,
                R.drawable.traffic_19, R.drawable.traffic_20};

        //Assige title
        final String[] StrTitle = new String[20]; //ให้จำ 20 ตัวเลย
        StrTitle[0] = "ห้ามเลี้ยวซ้าย";
        StrTitle[1] = "ห้ามเลี้ยวขวา";
        StrTitle[2] = "ตรง";
        StrTitle[3] = "เลี้ยวขวา";
        StrTitle[4] = "เลี้ยวซ้าย";
        StrTitle[5] = "ทางออก";
        StrTitle[6] = "ทางเข้า";
        StrTitle[7] = "ทางออก";
        StrTitle[8] = "หยุด";
        StrTitle[9] = "จำกัดความสูง";
        StrTitle[10] = "แยก";
        StrTitle[11] = "ห้ามกลับรถ";
        StrTitle[12] = "ห้ามจอด";
        StrTitle[13] = "รถสวน";
        StrTitle[14] = "ห้ามแซง";
        StrTitle[15] = "ห้ามเข้า";
        StrTitle[16] = "หยุดตรวจ";
        StrTitle[17] = "จำกัดความเร็ว";
        StrTitle[18] = "จำกัดความกว้าง";
        StrTitle[19] = "จำกัดความสูง";

        MyAdapter objMyAdapter = new MyAdapter(MainActivity.this, intIcon, StrTitle);
        trafficListView.setAdapter(objMyAdapter);

        //Active When Click ListView ,setOnItemClickListener is ,position is array[0,..,19]
        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //โยน data ไป อีก หน้า ย้าย Main ไปหา detail
                Intent objIntent = new Intent(MainActivity.this,DetailActivity.class);
                objIntent.putExtra("Title", StrTitle[position]);
                objIntent.putExtra("Image", intIcon[position]);
                objIntent.putExtra("Index", position);
                startActivity(objIntent);
            }//event
        });


    }


    private void buttonController() { //OnClickListener กดคลิกแล้วทำงานเลย
        aboutMEButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //(View v)(ประเภทตัวแปร ตัวแปร)

                //sound
                MediaPlayer buttonMediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.dog); //getBaseContext อยู่ที่เดียวกับมัน
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
