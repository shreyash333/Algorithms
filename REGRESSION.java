import java.util.*;

public class REGRESSION {

    static ArrayList<Float> Xdata = new ArrayList<>();
    static ArrayList<Float> YData = new ArrayList<>();
    static Float result1;
    static Float result2;
    static int n;
    static Float pred;

    public static void main(String args[]) {
        Scanner scr = new Scanner(System.in);
        /* Accepting number of elements */
        System.out.print("\n");
        System.out.println("Enter the number of Coordinates : ");
        n = scr.nextInt();
        System.out.print("\n");
        System.out.println("Enter the X Coordinates seprated with ',' (Do not put space in between) : ");
        String xinput;
        xinput = scr.next();
        List<String> xcord = Arrays.asList(xinput.split(","));
        for (int i = 1; i < xcord.size(); i++) {
            Xdata.add(Float.parseFloat(xcord.get(i)));
        }
        System.out.print("\n");
        System.out.println("Enter the Y Coordinates seprated with ',' (Do not put space in between) : ");
        String yinput;
        yinput = scr.next();
        List<String> ycord = Arrays.asList(yinput.split(","));
        for (int i = 1; i < ycord.size(); i++) {
            YData.add(Float.parseFloat(ycord.get(i)));
        }

        System.out.print("\n");
        System.out.println("Enter the value x-coordinate (float) for prediction : ");
        pred = scr.nextFloat();
        Float prediction = predictValue(pred);
        System.out.print("\n");
        System.out.println("Predicted value (y=mx+c) : ");
        System.out.print(prediction);

    }

    public static Float predictValue(Float inputValue) {
        Float X1 = Xdata.get(0);
        Float Y1 = YData.get(0);
        Float Xmean = getXMean(Xdata);
        Float Ymean = getYMean(YData);
        Float lineSlope = getLineSlope(Xmean, Ymean, X1, Y1);
        Float YIntercept = getYIntercept(Xmean, Ymean, lineSlope);
        Float prediction = (lineSlope * inputValue) + YIntercept;
        return prediction;
    }

    public static Float getLineSlope(Float Xmean, Float Ymean, Float X1, Float Y1) {
        float num1 = X1 - Xmean;
        float num2 = Y1 - Ymean;
        float denom = (X1 - Xmean) * (X1 - Xmean);
        return (num1 * num2) / denom;
    }

    public static float getYIntercept(Float Xmean, Float Ymean, Float lineSlope) {
        return Ymean - (lineSlope * Xmean);
    }

    public static Float getXMean(ArrayList<Float> Xdata) {
        result1 = 0.0f;
        for (Integer i = 0; i < Xdata.size(); i++) {
            result1 = result1 + Xdata.get(i);
        }
        return result1;
    }

    public static Float getYMean(ArrayList<Float> Ydata) {
        result2 = 0.0f;
        for (Integer i = 0; i < Ydata.size(); i++) {
            result2 = result2 + Ydata.get(i);
        }
        return result2;
    }

}