package de.szenarios.matrixrechner.calc;

import android.view.ViewGroup;

public class Calculator {
    private final VMartrix martrix;
    public Calculator(VMartrix martrix){
            this.martrix = martrix;

            equalNumbers();
            System.out.println(getMartrix().toString());
    }


    public void subStract(){
        martrix.setA2(subRow(martrix.getA2(), martrix.getA1()));
        martrix.setA3(subRow(martrix.getA3(), martrix.getA1()));
    }

    public void equalNumbers(){
        calcColum(0);
        calcSingleRaw( 3, 1);
    }

    public VMartrix calcColum(int r){
        // Row Calcen
        calcSingleRaw(2, r);
        calcSingleRaw(3, r);
        return martrix;
    }

    public VMartrix calcSingleRaw(int row, int r){
        Double[] secRow = null;

        if(row == 1)
            secRow = martrix.getA2();
        else
            secRow = martrix.getA3();

        if(secRow[r] == 0)
            return martrix;
        double dif = secRow[r] / (row == 0 ? martrix.getA1() : martrix.getA2())[r];

        Double[] eqRow = null;
        if(row == 1)
            martrix.setA2(multiRow(martrix.getA2(), dif));
        else
            martrix.setA3(multiRow(martrix.getA3(), dif));


        return  martrix;
    }
    public Double[] multiRow(Double[] row, double multiplikator){
        Double[] end = new Double[row.length];
        for(int i = 0; i < row.length; i++)
            end[i] = row[i] * multiplikator;

        return row;
    }

    public Double[] subRow(Double[] row, Double[] subRow){
        Double[] end = new Double[row.length];
        for(int i = 0; i < row.length; i++)
            end[i] = row[i] - subRow[i];

        return row;
    }

    public Double[] adRow(Double[] row, Double[] subRow){
        Double[] end = new Double[row.length];
        for(int i = 0; i < row.length; i++)
            end[i] = row[i] + subRow[i];

        return row;
    }

    public VMartrix getMartrix() {
        return martrix;
    }
}
