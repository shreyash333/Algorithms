import java.util.*;

public class Hits {
    public static void main(String args[]) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the size of Square matrix ");
        int n = scr.nextInt();
        int MatrixA[][] = new int[n][n];
        int MatrixATrans[][] = new int[n][n];
        int simpleh[] = new int[n];
        int hub1[] = new int[n];
        double hub2[] = new double[n];
        int auth1[] = new int[n];
        double auth2[] = new double[n];
        int toph1 = 0;
        int topa1 = 0;
        int toph2 = 0;
        int topa2 = 0;

        System.out.println("Enter the elements of the matrix");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                MatrixA[i][j] = scr.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                MatrixATrans[i][j] = MatrixA[j][i];

        for (int i = 0; i < n; i++)
            simpleh[i] = 1;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum = sum + (MatrixATrans[i][j] * simpleh[i]);
            }
            auth1[i] = sum;
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum = sum + (MatrixA[i][j] * auth1[i]);
            }
            hub1[i] = sum;
        }

        int high1 = 0;
        int high2 = 0;
        for (int i = 0; i < n; i++) {
            if (hub1[i] > hub1[high1])
                high1 = i;
            if (auth1[i] > auth1[high2])
                high2 = i;
        }
        topa1 = high2;
        toph1 = high1;

        int hubtotal = 0;
        int authtotal = 0;
        for (int i = 0; i < n; i++) {
            hubtotal = hubtotal + hub1[i] * hub1[i];
            authtotal = authtotal + auth1[i] * auth1[i];
        }

        double modhub = Math.sqrt(hubtotal);
        double modauth = Math.sqrt(authtotal);

        for (int i = 0; i < n; i++) {
            hub2[i] = hub1[i] / modhub;
            auth2[i] = auth1[i] / modauth;
        }

        int high21 = 0;
        int high22 = 0;
        for (int i = 0; i < n; i++) {
            if (hub2[i] > hub2[high21])
                high21 = i;
            if (auth2[i] > auth2[high22])
                high22 = i;
        }
        topa2 = high22;
        toph2 = high21;

        ////////////////////////////////////////////// Printing
        ////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////////////////////

        System.out.println();
        System.out.println();
        System.out.println("Entered Matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(MatrixA[i][j] + "  ");
            System.out.println();
        }

        System.out.println();
        System.out.println("Transpose Matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(MatrixATrans[i][j] + "  ");
            System.out.println();
        }
        System.out.println();
        System.out.println("For k = 1");
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print("Node " + Integer.toString(i + 1));
            System.out.print("\tHub " + Integer.toString(hub1[i]));
            System.out.print("\tAuthority " + Integer.toString(auth1[i]));
            System.out.println();
        }
        System.out.println(
                "Top Hub : Node " + Integer.toString(toph1 + 1) + " : Value : " + Integer.toString(hub1[toph1]));
        System.out.println(
                "Top Authority : Node " + Integer.toString(topa1 + 1) + " : Value : " + Integer.toString(auth1[topa1]));

        System.out.println();
        System.out.println("For k = 2");
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print("Node " + Integer.toString(i + 1));
            System.out.print("\tHub " + String.format("%.4f", hub2[i]));
            System.out.print("\tAuthority " + String.format("%.4f", auth2[i]));
            System.out.println();
        }
        System.out.println(
                "Top Hub : Node " + Integer.toString(toph2 + 1) + " : Value : " + String.format("%.4f", hub2[toph2]));
        System.out.println("Top Authority : Node " + Integer.toString(topa2 + 1) + " : Value : "
                + String.format("%.4f", auth2[topa2]));
    }

}
