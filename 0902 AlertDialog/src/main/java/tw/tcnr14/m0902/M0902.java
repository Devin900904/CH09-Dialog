package tw.tcnr14.m0902;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class M0902 extends AppCompatActivity implements View.OnClickListener {

    private Button b001,b002;
    private TextView t001;
    final String[] ListStr = {"張三", "李四", "王五", "陳六", "呂七", "宋八",
    "如果選擇項目太多", "Android也會", "自動的可以拖曳喔！～",
    "123","456"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0902);
        setupViewcomponent();
    }

    private void setupViewcomponent() {
        b001 =(Button)findViewById(R.id.m0902_b001);
        b002 =(Button)findViewById(R.id.m0902_b002);
        t001 =(TextView)findViewById(R.id.m0902_t001);
        b001.setOnClickListener(this);
        b002.setOnClickListener(this);


    }
  private DialogInterface.OnClickListener alt01on =new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
             switch (which){
                 case -1:
                     t001.setText(getString(R.string.m0902_t001) +
                             getString(R.string.m0902_b001) +
                             getString(R.string.m0902_click) + " [" +
                             getString(R.string.m0902_positive) + "] " +
                             getString(R.string.m0902_button));
                     break;

                 case -2:
                     t001.setText(getString(R.string.m0902_t001) +
                             getString(R.string.m0902_b001) +
                             getString(R.string.m0902_click) + " [" +
                             getString(R.string.m0902_negative) + "] " +
                             getString(R.string.m0902_button));
                     break;

                 case -3:
                     t001.setText(getString(R.string.m0902_t001) +
                             getString(R.string.m0902_b001) +
                             getString(R.string.m0902_click) + " [" +
                             getString(R.string.m0902_neutral) + "] " +
                             getString(R.string.m0902_button));
                     break;
             }
      }
  };
    @Override
    public void onClick(View v) {
        t001.setText("");
        switch (v.getId()){
            case R.id.m0902_b001:

                MyAlertDialog myAltDlg =new MyAlertDialog(this);
                myAltDlg.setTitle(getString(R.string.m0902_title));
                myAltDlg.setCancelable(false);
                myAltDlg.setMessage(getString(R.string.m0902_click)+getString(R.string.m0902_b001));
                myAltDlg.setIcon(android.R.drawable.btn_star);

                 //positive 是
                myAltDlg.setButton(DialogInterface.BUTTON_POSITIVE,getString(R.string.m0902_positive),alt01on);   //[ if依樣有三種選擇
                // negative 否
                myAltDlg.setButton(DialogInterface.BUTTON_NEGATIVE,getString(R.string.m0902_negative),alt01on);
                //neutral 取消
                myAltDlg.setButton(DialogInterface.BUTTON_NEUTRAL,getString(R.string.m0902_neutral),alt01on);
                myAltDlg.show();
                break;
            case R.id.m0902_b002:
                AlertDialog.Builder altDlgBIdr =new AlertDialog.Builder(this);
                altDlgBIdr.setTitle(getString(R.string.m0902_title));
                altDlgBIdr.setIcon(android.R.drawable.btn_star);
                altDlgBIdr.setCancelable(false);

                //--------------------監聽內容-----------------------
                altDlgBIdr.setItems(ListStr, new DialogInterface.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "select:" + ListStr[which], Toast.LENGTH_SHORT).show();
                        //--可進行不同的處理方法
                        t001.setText(getString(R.string.m0902_t001) +
                                getString(R.string.m0902_b002) + "\n" +
                                getString(R.string.m0902_click) + " " + ListStr[which]);
                    }
                });
                altDlgBIdr.setPositiveButton(getString(R.string.m0902_positive), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        t001.setText(getString(R.string.m0902_t001) +
                                getString(R.string.m0902_b002) +
                                getString(R.string.m0902_click) + " [" +
                                getString(R.string.m0902_positive) + "] " +
                                getString(R.string.m0902_button));
                    }
                });
                altDlgBIdr.setNegativeButton(getString(R.string.m0902_negative), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        t001.setText(getString(R.string.m0902_t001) +
                                getString(R.string.m0902_b002) +
                                getString(R.string.m0902_click) + " [" +
                                getString(R.string.m0902_negative) + "] " +
                                getString(R.string.m0902_button));

                    }
                });
                altDlgBIdr.setNeutralButton(getString(R.string.m0902_neutral), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        t001.setText(getString(R.string.m0902_t001) +
                                getString(R.string.m0902_b002) +
                                getString(R.string.m0902_click) + " [" +
                                getString(R.string.m0902_neutral) + "] " +
                                getString(R.string.m0902_button));
                    }
                });
                altDlgBIdr.show();
                break;

        }
    }
}