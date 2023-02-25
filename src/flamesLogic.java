import java.util.*;

public class flamesLogic {
    //Members
    //Pecaoco, Jules Alfonz R.
    //Magallanes, Shane Michael


    //prints Out input names, scores and interpreted score
    public void printOut(String nOne, String nTwo){
        nOne = reSpace(nOne);
        nTwo = reSpace(nTwo);
        int a = countDiffLetters(nTwo,nOne);
        int b = countDiffLetters(nOne,nTwo);

        System.out.println(nOne+" = "+ a+" : "+ arrayDiffLetters(nTwo,nOne));
        System.out.println(nTwo+" = "+ b+" : "+ arrayDiffLetters(nOne,nTwo));
        System.out.println("FLAMES " +(a+b)+ ": "+conditionFlames(nOne,nTwo));
    }


    //remove space between names
    public  String reSpace(String x){
        return x.replaceAll(" ","").toLowerCase();
    }


    //returns number of different letters of nOne to nTwo vice versa||returns container for array
    public  int countDiffLetters(String nOne, String nTwo){
        int count =0;
        for (int i = 0; i < nTwo.length(); i++) {
            boolean a = true;
            for(int k =0;k<nOne.length();k++){
                if(nOne.charAt(k)==nTwo.charAt(i)){
                    a = false;
                    break;
                }
            }
            if(a) count++;
        }
        return count;
    }


    //returns array of different character of nOne and nTwo vice versa
    public  String arrayDiffLetters(String nOne, String nTwo) {
        char [] notSame = new char[countDiffLetters(nOne,nTwo)];
        int d=0;
        for (int i = 0; i < nTwo.length(); i++) {
            boolean a = true;
            for(int k =0;k<nOne.length();k++){
                if(nOne.charAt(k)==nTwo.charAt(i)){
                    a = false;
                    break;
                }
            }
            if(a) notSame[d++]=nTwo.charAt(i);
        }
        return Arrays.toString(notSame);
    }


    //returns interpreted score
    public String conditionFlames(String nOne, String nTwo){
        nOne = reSpace(nOne);
        nTwo = reSpace(nTwo);
        int countOne = countDiffLetters(nTwo,nOne);
        int countTwo = countDiffLetters(nOne,nTwo);
        int score = countOne+countTwo;

        while(score>6){
            score -= 6;
        }

        String a ="";
        switch (score){
            case 0 -> a = "NOT COMPATIBLE";
            case 1 -> a = "FRIENDS";
            case 2 -> a = "LOVERS";
            case 3 -> a = "ADMIRER";
            case 4 -> a = "MARRIAGE";
            case 5 -> a = "ENEMY";
            case 6 -> a = "SOULMATE";
        }
        return a;
    }

}
