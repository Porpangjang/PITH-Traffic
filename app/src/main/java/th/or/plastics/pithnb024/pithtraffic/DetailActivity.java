package th.or.plastics.pithnb024.pithtraffic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private TextView titleTextView,detailTextView;
    private ImageView traficImageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //ก่อน
        bindWidget();

        //show view
        showView();



    }//Main Method

    private void showView() {
        //show Title
        String strTitle = getIntent().getStringExtra("Title");
        titleTextView.setText(strTitle);

        //Show Image
        int intImage = getIntent().getIntExtra("Image", R.drawable.traffic_01);
        traficImageView.setImageResource(intImage);

        //show detail ดึงstr ที่อย่ใน xml
        int intIndex = getIntent().getIntExtra("Index", 0);
        String[] strDetail = getResources().getStringArray(R.array.detail); //detail.xml มาแสดงข้อมูล 20ตัว
        detailTextView.setText(strDetail[intIndex]);//ตำแหน่งที่1 มาโชว์



    }

    private void bindWidget() {
        titleTextView = (TextView) findViewById(R.id.txtDetailTitle);
        detailTextView = (TextView) findViewById(R.id.textView);
        traficImageView = (ImageView) findViewById(R.id.imvDetailImage);
    }


} //Main Class
