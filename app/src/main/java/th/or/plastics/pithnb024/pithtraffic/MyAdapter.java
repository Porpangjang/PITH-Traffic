package th.or.plastics.pithnb024.pithtraffic;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pithnb024 on 19/11/2558.
 */
//จัดเรียงของไว้บนงานของเรา
public class MyAdapter extends BaseAdapter{
    //Explicit use android
    //Context กระบวนการถ่ายเท data oop ค่อยๆโยน data ที่ละชุด
    private Context objContext;
    private int[] iconInts;
    private String[] titleStrings;

    public MyAdapter(Context objContext, int[] iconInts, String[] titleStrings) {
        this.objContext = objContext;
        this.iconInts = iconInts;
        this.titleStrings = titleStrings;
    }//constructor

    @Override
    public int getCount() { // นับว่ามี data กี่ตัว
        return titleStrings.length;//ถ้า20 นับให้20 ใส่ตัวแปรเพื่อนับ
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //ทำการเปิด service ให้ ad สร้างเรียกใช้ข้อมูลได้
        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //สร้างตัว show
        View objView = objLayoutInflater.inflate(R.layout.traffic_listview, parent, false);

        //setup icon
        ImageView iconImageView = (ImageView) objView.findViewById(R.id.imvIcon);
        iconImageView.setImageResource(iconInts[position]);

        //setup Title
        TextView titleTextView = (TextView) objView.findViewById(R.id.txtShowTitle);
        titleTextView.setText(titleStrings[position]); //position
        return objView;

    }
}// Main Class
