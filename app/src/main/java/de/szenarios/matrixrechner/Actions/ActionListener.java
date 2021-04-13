package de.szenarios.matrixrechner.Actions;

import android.content.SyncStatusObserver;
import android.view.View;

import de.szenarios.matrixrechner.MainActivity;
import de.szenarios.matrixrechner.calc.Calculator;
import de.szenarios.matrixrechner.calc.VMartrix;

public class ActionListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        if(VMartrix.getInstance(MainActivity.getInstance()) == null){
            System.out.println("Geht net!");
            return;
        }
        System.out.println("Geht");

        VMartrix martrix = VMartrix.getInstance(MainActivity.getInstance());
        Calculator calculator = new Calculator(martrix);

        System.out.println("Done");
        System.out.println(calculator.getMartrix().toString());


    }
}
