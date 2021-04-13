package de.szenarios.matrixrechner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SyncStatusObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import de.szenarios.matrixrechner.Actions.ActionListener;
import de.szenarios.matrixrechner.calc.VMartrix;

public class MainActivity extends AppCompatActivity {
    private static MainActivity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.activity = this;

        final Button halloButton = (Button)findViewById(R.id.button);
        halloButton.setOnClickListener(new ActionListener());



    }
    public static MainActivity getInstance(){
        return activity;
    }
}