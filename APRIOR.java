import java.util.*;

public class APRIOR {
    static int n, p, minsup;
    static Float minconfi;
    static List<List<String>> listOfLists = new ArrayList<List<String>>();
    static List<String> allelements = new ArrayList<String>();
    static List<String> tempallelements = new ArrayList<String>();
    static List<String> temp2allelements = new ArrayList<String>();
    static List<Integer> allcount = new ArrayList<Integer>();
    static List<String> l1elements = new ArrayList<String>();
    static List<Integer> l1count = new ArrayList<Integer>();
    static List<List<String>> c2elements = new ArrayList<List<String>>();
    static List<Integer> c2count = new ArrayList<Integer>();
    static List<List<String>> l2elements = new ArrayList<List<String>>();
    static List<Integer> l2count = new ArrayList<Integer>();
    static List<List<String>> c3elements = new ArrayList<List<String>>();
    static List<Integer> c3count = new ArrayList<Integer>();
    static List<List<String>> l3elements = new ArrayList<List<String>>();
    static List<Integer> l3count = new ArrayList<Integer>();
    static List<List<List<String>>> associationrules = new ArrayList<List<List<String>>>();
    static List<List<String>> strongassociationrules = new ArrayList<List<String>>();
    static List<List<Float>> confidence = new ArrayList<List<Float>>();
    static List<Float> strongconfidence = new ArrayList<Float>();

    public static void main(String args[]) {
        Scanner scr = new Scanner(System.in);
        /* Accepting number of elements */
        System.out.println("Enter the number of Transistion ");
        n = scr.nextInt();

        /* Accepting elements */
        // System.out.println("Enter " + n + " Transistion: ");
        for (int i = -1; i < n; i++) {
            String input;
            if (i != -1)
                System.out.println("Enter " + i + " Transistion elements: ");
            input = scr.nextLine();
            List<String> words = Arrays.asList(input.split(","));
            listOfLists.add(words);

            // for (int p = 0; p < input.length(); p++) {
            // List<String> ch = new ArrayList<String>();
            // if (input.charAt(i) != ' ' && input.charAt(i) != ',') {
            // ch.add(toString(input.charAt(i)));
            // count++;
            // }
            // listOfLists.add(ch);
            // }

        }
        System.out.println("Enter the Minmum Support Count ");
        minsup = scr.nextInt();

        System.out.println("Enter the Minmum Confidence ");
        minconfi = scr.nextFloat();

      

        for (int x = 0; x < listOfLists.size(); x++) {
            for (int y = 0; y < listOfLists.get(x).size(); y++) {
                if (!(allelements.contains(listOfLists.get(x).get(y)))) {
                    allelements.add(listOfLists.get(x).get(y));
                }
            }
        }

        for (int x = 0; x < allelements.size(); x++) {
            int alcount = 0;
            String search = allelements.get(x);
            for (int z = 0; z < listOfLists.size(); z++) {
                for (int y = 0; y < listOfLists.get(z).size(); y++) {

                    if (listOfLists.get(z).get(y).equals(search)) {
                        alcount++;

                    }
                }
            }
            allcount.add(alcount);
        }

        for (int x = 0; x < allcount.size(); x++) {
            if (allcount.get(x) >= minsup) {
                l1count.add(allcount.get(x));
                l1elements.add(allelements.get(x));
            }
        }

        System.out.print("\nC1 Elements : ");
        for (int x = 0; x < allelements.size(); x++) {
            System.out.print(allelements.get(x) + " ");
        }

        System.out.print("\nC1 Count    : ");
        for (int x = 1; x < allcount.size(); x++) {
            System.out.print(allcount.get(x) + " ");
        }

        System.out.print("\nPrune Stage");

        System.out.print("\nL1 Elements : ");
        for (int x = 0; x < l1elements.size(); x++) {
            System.out.print(l1elements.get(x) + " ");
        }

        System.out.print("\nL1 Count    : ");
        for (int x = 0; x < l1count.size(); x++) {
            System.out.print(l1count.get(x) + " ");
        }

        for (int x = 0; x < l1elements.size(); x++) {
            for (int y = x + 1; y < l1elements.size(); y++) {
                List<String> temp = Arrays.asList(l1elements.get(x), l1elements.get(y));
                c2elements.add(temp);
            }
        }

        for (int x = 0; x < c2elements.size(); x++) {
            int alcount = 0;
            for (int z = 0; z < listOfLists.size(); z++) {
                if (listOfLists.get(z).contains(c2elements.get(x).get(0))
                        && listOfLists.get(z).contains(c2elements.get(x).get(1))) {
                    alcount++;
                }
            }
            c2count.add(alcount);

        }


        System.out.print("\n");
       

        System.out.print("\nC2 Elements : ");
        for (int x = 0; x < c2elements.size(); x++) {
            for (int y = 0; y < c2elements.get(x).size(); y++) {
                System.out.print(c2elements.get(x).get(y));
            }
            System.out.print(" ");
        }

        System.out.print("\nC2 Count    : ");
        for (int x = 0; x < c2count.size(); x++) {
            System.out.print(c2count.get(x) + " ");
        }

        for (int x = 0; x < c2count.size(); x++) {
            if (c2count.get(x) >= minsup) {
                l2count.add(c2count.get(x));
                l2elements.add(c2elements.get(x));
            }
        }
        System.out.print("\nPrune Stage");

        System.out.print("\nL2 Elements : ");
        for (int x = 0; x < l2elements.size(); x++) {
            for (int y = 0; y < l2elements.get(x).size(); y++) {
                System.out.print(l2elements.get(x).get(y));
            }
            System.out.print(" ");
        }

        System.out.print("\nL2 Count    : ");
        for (int x = 0; x < l2count.size(); x++) {
            System.out.print(l2count.get(x) + " ");
        }

        for (int x = 0; x < l2elements.size(); x++) {
            for (int y = 0; y < l2elements.get(x).size(); y++) {
                if (!(tempallelements.contains(l2elements.get(x).get(y)))) {
                    tempallelements.add(l2elements.get(x).get(y));
                }
            }
        }

        for (int x = 0; x < tempallelements.size(); x++) {
            for (int y = x + 1; y < tempallelements.size(); y++) {
                for (int z = y + 1; z < tempallelements.size(); z++) {
                    List<String> temp = Arrays.asList(tempallelements.get(x), tempallelements.get(y),
                            tempallelements.get(z));
                    c3elements.add(temp);
                }

            }
        }
        System.out.print("\n");
        

        System.out.print("\nC3 Elements : ");
        for (int x = 0; x < c3elements.size(); x++) {
            for (int y = 0; y < c3elements.get(x).size(); y++) {
                System.out.print(c3elements.get(x).get(y));
            }
            System.out.print(" ");
        }

        for (int x = 0; x < c3elements.size(); x++) {
            int alcount = 0;
            for (int z = 0; z < listOfLists.size(); z++) {
                if (listOfLists.get(z).contains(c3elements.get(x).get(0))
                        && listOfLists.get(z).contains(c3elements.get(x).get(1))
                        && listOfLists.get(z).contains(c3elements.get(x).get(2))) {
                    alcount++;
                }
            }
            c3count.add(alcount);

        }

        System.out.print("\nC3 Count    : ");
        for (int x = 0; x < c3count.size(); x++) {
            System.out.print(c3count.get(x) + " ");
        }

        for (int x = 0; x < c3count.size(); x++) {
            if (c3count.get(x) >= minsup) {
                l3count.add(c3count.get(x));
                l3elements.add(c3elements.get(x));
            }
        }
        System.out.print("\nPrune Stage");

        System.out.print("\nL3 Elements : ");
        for (int x = 0; x < l3elements.size(); x++) {
            for (int y = 0; y < l3elements.get(x).size(); y++) {
                System.out.print(l3elements.get(x).get(y));
            }
            System.out.print(" ");
        }

        System.out.print("\nL3 Count    : ");
        for (int x = 0; x < l3count.size(); x++) {
            System.out.print(l3count.get(x) + " ");
        }

        for (int x = 0; x < l3elements.size(); x++) {
            List<List<String>> tempresultelements = new ArrayList<List<String>>();
            List<Float> tempresultcount = new ArrayList<Float>();
            int comcount = l3count.get(x);
            for (int y = 0; y < l3elements.get(x).size(); y++) {
                if (!(temp2allelements.contains(l3elements.get(x).get(y)))) {
                    temp2allelements.add(l3elements.get(x).get(y));
                }

            }
            List<String> temp = Arrays.asList(temp2allelements.get(0), temp2allelements.get(1), " => ",
                    temp2allelements.get(2));
            tempresultelements.add(temp);
            int alcount = 0;
            for (int z = 0; z < listOfLists.size(); z++) {
                if (listOfLists.get(z).contains(temp2allelements.get(0))
                        && listOfLists.get(z).contains(temp2allelements.get(1))) {
                    alcount++;
                }
            }
            float confi = (comcount * 100 / alcount);
            tempresultcount.add(confi);
            temp = Arrays.asList(temp2allelements.get(0), temp2allelements.get(2), " => ", temp2allelements.get(1));
            tempresultelements.add(temp);
            alcount = 0;
            for (int z = 0; z < listOfLists.size(); z++) {
                if (listOfLists.get(z).contains(temp2allelements.get(0))
                        && listOfLists.get(z).contains(temp2allelements.get(2))) {
                    alcount++;
                }
            }
            confi = (comcount * 100 / alcount);
            tempresultcount.add(confi);

            temp = Arrays.asList(temp2allelements.get(1), temp2allelements.get(2), " => ", temp2allelements.get(0));
            tempresultelements.add(temp);
            alcount = 0;
            for (int z = 0; z < listOfLists.size(); z++) {
                if (listOfLists.get(z).contains(temp2allelements.get(1))
                        && listOfLists.get(z).contains(temp2allelements.get(2))) {
                    alcount++;
                }
            }
            confi = (comcount * 100 / alcount);
            tempresultcount.add(confi);
            temp = Arrays.asList(temp2allelements.get(0), " => ", temp2allelements.get(1), temp2allelements.get(2));
            tempresultelements.add(temp);
            alcount = 0;
            for (int z = 0; z < listOfLists.size(); z++) {
                if (listOfLists.get(z).contains(temp2allelements.get(0))) {

                    alcount++;
                }
            }
            confi = (comcount * 100 / alcount);
            tempresultcount.add(confi);
            temp = Arrays.asList(temp2allelements.get(1), " => ", temp2allelements.get(0), temp2allelements.get(2));
            tempresultelements.add(temp);
            alcount = 0;
            for (int z = 0; z < listOfLists.size(); z++) {
                if (listOfLists.get(z).contains(temp2allelements.get(1))) {
                    alcount++;
                }
            }
            confi = (comcount * 100 / alcount);
            tempresultcount.add(confi);
            temp = Arrays.asList(temp2allelements.get(2), " => ", temp2allelements.get(0), temp2allelements.get(1));
            tempresultelements.add(temp);
            alcount = 0;
            for (int z = 0; z < listOfLists.size(); z++) {
                if (listOfLists.get(z).contains(temp2allelements.get(2))) {
                    alcount++;
                }
            }
            confi = (comcount * 100 / alcount);
            tempresultcount.add(confi);

            associationrules.add(tempresultelements);
            confidence.add(tempresultcount);

        }


        System.out.print("\n\nAssociation Rules      Confidence \n");
        for (int x = 0; x < associationrules.size(); x++) {
            for (int y = 0; y < associationrules.get(x).size(); y++) {
                for (int z = 0; z < associationrules.get(x).get(y).size(); z++) {
                    System.out.print(associationrules.get(x).get(y).get(z));
                }
                System.out.print("                   ");
                System.out.print(confidence.get(x).get(y));
                System.out.print("\n");

            }

        }

        for (int x = 0; x < confidence.size(); x++) {
            for (int y = 0; y < confidence.get(x).size(); y++) {
                if (confidence.get(x).get(y) >= minconfi) {
                    strongconfidence.add(confidence.get(x).get(y));
                    strongassociationrules.add(associationrules.get(x).get(y));
                }
            }

        }
        System.out.print("\n**Strong Association Rules**");
        System.out.print("\nAssociation Rules      Confidence \n");
        for (int x = 0; x < strongassociationrules.size(); x++) {
            for (int y = 0; y < strongassociationrules.get(x).size(); y++) {
                System.out.print(strongassociationrules.get(x).get(y));
            }
            System.out.print("                   ");
            System.out.print(strongconfidence.get(x));
            System.out.print("\n");

        }

        // System.out.print("\nConfidence : \n");
        // for (int x = 0; x < confidence.size(); x++) {
        // for (int y = 0; y < confidence.get(x).size(); y++) {
        // System.out.print(confidence.get(x).get(y));
        // System.out.print(" ");
        // }
        // System.out.print("\n");
        //
        // }

        // for (int x = 0; x < c2elements.size(); x++){
        //
        // int alcount = 0;
        // for (int y = 0; y < c2elements.get(x).size(); y++){
        //
        // String search = c2elements.get(x).get(y);
        // for (int z = 0; z < listOfLists.size(); z++) {
        // Boolean check = true;
        // for (int w = 0; w < listOfLists.get(z).size(); w++) {
        // if (!(listOfLists.get(z).get(w).equals(search))) {
        // System.out.print(search + "\n not exist ");
        // check = false;
        // }
        // }
        // if(check == true){
        // alcount++;
        // }
        // }
        // c2count.add(alcount);
        // System.out.print("\nAdd Count ");
        //
        //
        // }
        // }

        // for (int x = 1; x < listOfLists.size(); x++){
        // System.out.println("\nTransaction Id : " + (x-1) + " ");
        // for (int y = 0; y < listOfLists.get(x).size(); y++){
        //
        // System.out.print(listOfLists.get(x).get(y));
        //
        // }
        // }
        // System.out.print(d);
    }

}
