package com.hand.multilanguagepackage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hand.multilanguagepackage.R;
import com.hand.multilanguagepackage.philology.StringPhilologyRepositoryFactory2;
import com.jcminarro.philology.Philology;
import com.jcminarro.philology.PhilologyRepositoryFactory;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.main_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(it);
            }
        });


        findViewById(R.id.main_swith_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchLanguage ();
            }
        });

    }

    private void switchLanguage() {
        //这是一种方式应用内手动切换预研 TODO 需要手动刷新所有界面
        PhilologyRepositoryFactory repositoryFactory = new StringPhilologyRepositoryFactory2(getApplicationContext());
        Philology.INSTANCE.init(repositoryFactory);

        //更新语言后，destroy当前页面，重新绘制
        finish();
        Intent it = new Intent(MainActivity.this, MainActivity.class);
        //清空任务栈确保当前打开activit为前台任务栈栈顶
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);

        //TODO 另一种就是下载好资源后，重新启动app
    }
}
