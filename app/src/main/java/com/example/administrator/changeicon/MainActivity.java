package com.example.administrator.changeicon;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ComponentName deFault;
    private ComponentName deFault1;
    private ComponentName deFault2;
    private PackageManager pManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        deFault = new ComponentName(getBaseContext(), BuildConfig.APPLICATION_ID+".MainActivity");
        deFault1 = new ComponentName(getBaseContext(), BuildConfig.APPLICATION_ID+".MainActivity1");
        deFault2 = new ComponentName(getBaseContext(), BuildConfig.APPLICATION_ID+".MainActivity2");
        pManager = getApplicationContext().getPackageManager();
    }

    public void startChangeIcon(View view) {
        switch (view.getId()) {
            case R.id.button1:
                disEnableComponent(deFault);
                disEnableComponent(deFault2);
                enableComponent(deFault1);
                break;
            case R.id.button2:
                disEnableComponent(deFault);
                disEnableComponent(deFault1);
                enableComponent(deFault2);
                break;
            case R.id.button3:
                disEnableComponent(deFault1);
                disEnableComponent(deFault2);
                enableComponent(deFault);
                break;
        }
        finish();
    }

    public void enableComponent(ComponentName componentName) {
        pManager.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }

    public void disEnableComponent(ComponentName componentName) {
        pManager.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }
}
