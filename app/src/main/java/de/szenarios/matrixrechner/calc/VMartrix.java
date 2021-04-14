package de.szenarios.matrixrechner.calc;

import android.content.SyncStatusObserver;
import android.widget.TextView;

import de.szenarios.matrixrechner.Actions.ActionListener;
import de.szenarios.matrixrechner.MainActivity;
import de.szenarios.matrixrechner.R;

/**
 * Eine Custom Martrix
 */
public class VMartrix {
    private Double[] a1;
    private Double[] a2;
    private Double[] a3;

    public VMartrix(Double[] a1, Double[] a2, Double[] a3){
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
    }

    public static VMartrix getInstance(MainActivity activity) {
        try {
            Double[] row1 = new Double[]{getContet(activity, R.id.editA11), getContet(activity, R.id.editA12), getContet(activity, R.id.editA13), getContet(activity, R.id.editA14)};
            Double[] row2 = new Double[]{getContet(activity, R.id.editA21), getContet(activity, R.id.editA22), getContet(activity, R.id.editA23), getContet(activity, R.id.editA24)};
            Double[] row3 = new Double[]{getContet(activity, R.id.editA31), getContet(activity, R.id.editA32), getContet(activity, R.id.editA33), getContet(activity, R.id.editA34)   };
            return new VMartrix(row1, row2, row3);
        } catch (Exception e){
            return null;
        }
    }


    /**
     * Gibt eine Zahl aus einem Lain Text wieder.
     * @param activity Die {@link MainActivity} wo das Plain Text Objekt Liegt
     * @param id Die ID von dem Plain Text
     * @return Den Integer oder Null
     * @throws Exception Wird geworfen wenn in den Pfeld nicht nur eine Zahl steht.
     */
    private static Double getContet(MainActivity activity, Integer id) throws NumberFormatException {
        TextView text = activity.findViewById(id);
        return Double.parseDouble(String.valueOf(text.getText()));
    }


    public Double[] getA1() {
        return a1;
    }

    public Double[] getA2() {
        return a2;
    }

    public Double[] getA3() {
        return a3;
    }

    public void setA1(Double[] a1) {
        this.a1 = a1;
    }

    public void setA2(Double[] a2) {
        this.a2 = a2;
    }

    public void setA3(Double[] a3) {
        this.a3 = a3;
    }


    public String toString(){
        return lineToString(a1) + "\n" + lineToString(a2) + "\n" + lineToString(a3);
    }
    public String lineToString(Double[] doubles){
        String line = "(";
        for(int i = 0; i < doubles.length-1; i++)
            line = line + doubles[i] + " ";

        line = line + " | " + doubles[doubles.length -1]+")";
        return line;
    }

    public void tauschIundII() {
        Double[] I = getA1();
        Double[] II = getA2();

        this.a1 = II;
        this.a2 = I;
    }
    public void tauschIIundIII() {
        Double[] II = getA2();
        Double[] III = getA3();

        this.a2 = III;
        this.a3 = II;
    }
}
