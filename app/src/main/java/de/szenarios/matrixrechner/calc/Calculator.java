package de.szenarios.matrixrechner.calc;

import android.content.SyncStatusObserver;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public List<String> logList;
    private final VMartrix martrix;
    public Calculator(VMartrix martrix){
            this.martrix = martrix;
            this.logList = new ArrayList<>();

            System.out.println("Normal");
            System.out.println(getMartrix().toString());

            System.out.println("Step 1");
            equalThirdFristLines();
            System.out.println(getMartrix().toString());


            System.out.println("Step 2");
            equalSecendFristLines();
            System.out.println(getMartrix().toString());

            System.out.println("Step 3");
            equalSecendSecendLines();
            System.out.println(getMartrix().toString());

            System.out.println("Step 4");
            getWerte();
            System.out.println(getMartrix().toString());
    }

    public void equalSecendFristLines() {
        if(martrix.getA2()[0] != 0)
            if(martrix.getA1()[0] < martrix.getA2()[0]) {
                log("I <-> II");
                martrix.tauschIundII();
                equalSecendFristLines();
            } else {
                log("", "(II * (-"+(martrix.getA1()[0] +" : "+ martrix.getA2()[0])+")) + I", "");
                martrix.setA2(adRow(multiRow(martrix.getA2(), -(martrix.getA1()[0] / martrix.getA2()[0])), martrix.getA1()));
            }
        else
            log("A2.1 == 0");
    }
    public void equalThirdFristLines() {
        System.out.println((martrix.getA3()[0] != 0));
        if(martrix.getA3()[0] != 0)
            if(martrix.getA2()[0] < martrix.getA3()[0]) {
                log("II <-> III");
                martrix.tauschIIundIII();
                equalThirdFristLines();
            } else {
                log("", "", "(III * (-"+(martrix.getA2()[0] +" : "+ martrix.getA3()[0])+")) + II");
                martrix.setA3(adRow(multiRow(martrix.getA3(), -(martrix.getA2()[0] / martrix.getA3()[0])), martrix.getA2()));

            }
        else
            log("A3.1 == 0");
    }


    public void equalSecendSecendLines() {
        System.out.println((martrix.getA3()[1] != 0));
        if(martrix.getA3()[1] != 0) {
            if(martrix.getA2()[1] < martrix.getA3()[1]) {
                log("II <-> III");
                martrix.tauschIIundIII();
                equalSecendSecendLines();
            } else {
                log("", "", "(III * -("+(martrix.getA2()[1] +" : "+ martrix.getA3()[1])+")) + II");
                martrix.setA3(adRow(multiRow(martrix.getA3(), -(martrix.getA2()[1] / martrix.getA3()[1])), martrix.getA2()));
            }
        } else {
            log("A3.2 = 0 ");
        }

   }


   public void getWerte() {

        double x3 = martrix.getA3()[3] / martrix.getA3()[2];

        double x2 = (martrix.getA2()[3] - (martrix.getA2()[2] * x3)) / martrix.getA2()[1];

        double x1 = (martrix.getA1()[3] - ((martrix.getA1()[2] * x3) + (martrix.getA1()[1]* x2))) / martrix.getA1()[0];


        Double[] I = new Double[]{1.0, 0.0 , 0.0, x1};
        Double[] II = new Double[]{0.0, 1.0 , 0.0, x2};
        Double[] III = new Double[]{0.0, 0.0 , 1.0, x3};

        martrix.setA1(I);
        martrix.setA2(II);
        martrix.setA3(III);
        log("x3 & x2 -> I   x1 = " + x1, "x3 -> II    x2 = " + x2, "A3.4 / A3.3    x3 = " + x3);

   }


    public Double[] multiRow(Double[] row, double multiplikator){
        Double[] end = new Double[row.length];
        for(int i = 0; i < row.length; i++)
            end[i] = row[i] * multiplikator;

        return end;
    }

    public Double[] subRow(Double[] row, Double[] subRow){
        Double[] end = new Double[row.length];
        for(int i = 0; i < row.length; i++)
            end[i] = row[i] - subRow[i];

        return end;
    }

    public Double[] adRow(Double[] row, Double[] subRow){
        Double[] end = new Double[row.length];
        for(int i = 0; i < row.length; i++)
            end[i] = row[i] + subRow[i];

        return end;
    }

    public VMartrix getMartrix() {
        return martrix;
    }

    public void log(String txt){
        logList.add(txt);
    }
    public void log(String a, String b, String c){
            String log = "";
            log = log + martrix.lineToString(martrix.getA1()) + " | " +a + "\n";
            log = log + martrix.lineToString(martrix.getA2()) + " | " +b + "\n";
            log = log + martrix.lineToString(martrix.getA3()) + " | " +c + "\n";
            logList.add(log);
    }

}
