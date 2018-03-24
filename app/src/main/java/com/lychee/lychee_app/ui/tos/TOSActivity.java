package com.lychee.lychee_app.ui.tos;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lychee.lychee_app.R;
import com.lychee.lychee_app.databinding.ActivityTosBinding;
import com.lychee.lychee_app.ui.main.MainActivity;


/**
 *  이용약관 페이지
 */
public class TOSActivity extends AppCompatActivity {
    ActivityTosBinding tosBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tos);

        tosBinding = DataBindingUtil.setContentView(this, R.layout.activity_tos);

        init();
    }

    public void init() {
        tosBinding.tosCheckboxall.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Checked(v); // 체크되었을 때 동작코드
            }
        });

    }

    public void tosNext(View view) {
        if (tosBinding.tosCheckbox1.isChecked() == true &&
                tosBinding.tosCheckbox2.isChecked() == true &&
                tosBinding.tosCheckbox3.isChecked() == true &&
                tosBinding.tosCheckbox4.isChecked() == true) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void Checked(View view) {
        tosBinding.tosCheckbox1.setChecked(true);
        tosBinding.tosCheckbox2.setChecked(true);
        tosBinding.tosCheckbox3.setChecked(true);
        tosBinding.tosCheckbox4.setChecked(true);
        tosBinding.tosCheckbox5.setChecked(true);
    }
}