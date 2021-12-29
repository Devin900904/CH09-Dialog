package tw.tcnr14.m0903;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class M0903 extends AppCompatActivity implements View.OnClickListener {

    private final Handler mHandler =new Handler();
    private Button b001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0903);
        setupcomponent();
    }

    private void setupcomponent() {
        b001 =(Button)findViewById(R.id.m0903_b001);
        b001.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ProgressDialog progDlg =new ProgressDialog(this);
        progDlg.setTitle(getString(R.string.m0903_title));
        progDlg.setMessage(getString(R.string.m0903_message));
        progDlg.setIcon(android.R.drawable.btn_star);
        progDlg.setCancelable(false);
//        progDlg.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progDlg.setMax(100);
        progDlg.show();
        new Thread(){
            @Override
            public void run() {
                super.run();
            }
        };
        new Thread(new Runnable() {
            public void run() {
                Calendar begin = Calendar.getInstance();
                do {
                    Calendar now = Calendar.getInstance();
                    final int iDiffSec = 60 * (now.get(Calendar.MINUTE) - begin.get(Calendar.MINUTE)) +
                            (now.get(Calendar.SECOND) - begin.get(Calendar.SECOND));
//-------------------------------------
                    if (iDiffSec * 2 > 100) {
                        mHandler.post(new Runnable() {
                            public void run() {
                                progDlg.setProgress(100);
                            }
                        });
                        break;
                    }
//-------------------------------------
                    mHandler.post(new Runnable() {
                        public void run() {
                            progDlg.setProgress(iDiffSec * 2); //1,2,4,5
                        }
                    });
//-------------------------------------
                    if ((iDiffSec * 4) < 100){
                        mHandler.post(new Runnable() {
                                          public void run() {
                                              progDlg.setSecondaryProgress(iDiffSec * 4);
                                          }
                                      }
                        );
                    }else{
                        mHandler.post(new Runnable() {
                            public void run() {
                                progDlg.setSecondaryProgress(100);
                            }
                        });
                    }

                } while (true);
                progDlg.cancel();
            }
        }).start();
    }

}