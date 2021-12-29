package tw.tcnr14.m0905;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class M0905 extends AppCompatActivity implements View.OnClickListener {

    private Button b001;
    private Dialog mLoginDlg;
    private TextView t001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0905);
        setupcomponent();
    }

    private void setupcomponent() {
        b001 =(Button)findViewById(R.id.m0905_b001);
        b001.setOnClickListener(this);
        t001 =(TextView)findViewById(R.id.m0905_t001);
    }

    @Override
    public void onClick(View v) {
      switch (v.getId()){
          case R.id.m0905_b001:
          t001.setText("");

          mLoginDlg = new Dialog(this);
          mLoginDlg.setTitle(getString(R.string.login));
          mLoginDlg.setCancelable(false);
          mLoginDlg.setContentView(R.layout.login_dlg);  //選擇layout
//            mLoginDlg.setIcon(android.R.drawable.star_big_on);

          Button   loginBtnOK = (Button) mLoginDlg.findViewById(R.id.m0905_btnOK);
          Button   loginBtnCancel = (Button) mLoginDlg.findViewById(R.id.m0905_btnCancel);

          loginBtnOK.setOnClickListener(this);
          loginBtnCancel.setOnClickListener(this);
          mLoginDlg.show();
              break;
          case R.id.m0905_btnOK:
              EditText edtUserName =(EditText) mLoginDlg.findViewById(R.id.edtUserName);
              EditText edtPassword =(EditText) mLoginDlg.findViewById(R.id.edtPassword);
           t001.setText(getString(R.string.m0905_ans)+"\n"+getString(R.string.m0905_t001)+edtUserName.getText().toString()+
                   "\n"+getString(R.string.m0905_t002)+edtPassword.getText().toString()+"\n"+"MD5"+getString(R.string.m0905_t002)
                   +u_md5(edtPassword.getText().toString()));

              mLoginDlg.cancel();

           break;

          case R.id.m0905_btnCancel:
         mLoginDlg.cancel();
      }
    }
    public static String u_md5(String content) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(content.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("NoSuchAlgorithmException", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UnsupportedEncodingException", e);
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) {
                hex.append("0");
            }
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }
//---------------------
}