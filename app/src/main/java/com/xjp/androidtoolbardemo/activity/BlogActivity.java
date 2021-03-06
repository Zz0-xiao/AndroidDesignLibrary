package com.xjp.androidtoolbardemo.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ZoomButton;

import com.xjp.androidtoolbardemo.R;

/**
 * Description:
 * User: xjp
 * Date: 2015/6/17
 * Time: 18:47
 */

public class BlogActivity extends BaseActivity {

    private TextInputLayout inputLayout1;
    private TextInputLayout inputLayout2;
    private EditText member;
    private EditText password;
    private Toolbar toolbar;

    @Override
    protected void init() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_blog;
    }

    @Override
    protected void initView() {

        toolbar = findView(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//显示返回按钮
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("登录");


        inputLayout1 = findView(R.id.textInputLayout1);
        member = inputLayout1.getEditText();
        member.setText("CSDN废墟的树");
        member.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 8) {
                    inputLayout1.setErrorEnabled(true);
                    inputLayout1.setError("账户名不能超过8个字符");
                } else {
                    inputLayout1.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        inputLayout2 = findView(R.id.textInputLayout2);
        password = inputLayout2.getEditText();
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 6) {
                    inputLayout2.setErrorEnabled(true);
                    inputLayout2.setError("密码不能超过6个字符");
                } else {
                    inputLayout2.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void login(View view) {

        String mb = member.getText().toString().trim();
        String ps = password.getText().toString().trim();

        if (mb.length() > 0 && mb.length() < 9) {
            if (ps.length() == 6) {
                Uri u = Uri.parse("http://blog.csdn.net/feiduclear_up");
                Intent it = new Intent(Intent.ACTION_VIEW,u);
                startActivity(it);
            } else {
                Snackbar.make(view, "请输入6位数的密码", Snackbar.LENGTH_SHORT).show();
            }
        } else {
            Snackbar.make(view, "请输入正确的账号", Snackbar.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)////返回案件点击事件
    {
        if(item.getItemId() == android.R.id.home)
        {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
