package th.or.plastics.pithnb024.pithtraffic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


    }//Main method end ;

    private void bindWidget() {

        aboutMEButton = (Button) findViewById(R.id.button);//เป็นการผูกตัวแปรเข้าหากัน
        trafficListView = (ListView) findViewById(R.id.listView);

    }

} //Main Class
