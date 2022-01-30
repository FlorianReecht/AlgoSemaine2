import jdk.internal.util.xml.impl.Pair;
import jdk.nashorn.internal.objects.NativeInt32Array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Semaine2 {
    public static void main(String[] args) {
        Semaine2 s = new Semaine2();
        int[][] pascal=s.Exercice7(7);
        for(int i=0;i<pascal.length;i++){
            System.out.println(" ");
            for(int j=0;j<pascal[i].length;j++){
                System.out.print(pascal[i][j]+" ");
            }
        }
    }

    public int Exercice1(int x, int y) {
        int retour = 0;
        String _X = Integer.toBinaryString(x);
        String _Y = Integer.toBinaryString(y);
        int minLongueur = Math.min(_X.length(), _Y.length());
        for (int i = 0; i < minLongueur; i++) {
            if (_X.charAt(i) == _Y.charAt(i)) {
                retour++;

            }
        }
        return retour;
    }

    //Longest common prefix
    public String Exercice2(List<String> words) {
        String retour = "";
        boolean condition = true;
        int charIndex = 0;
        if (words.size() != 0) {
            while (condition) {
                char currentChar = words.get(0).charAt(charIndex);
                for (int i = 0; i < words.size(); i++) {
                    if (words.get(i).charAt(charIndex) != currentChar) {
                        condition = false;
                    }
                }
                if (condition) {
                    retour += currentChar;
                    charIndex++;
                }
            }
        }
        return retour;

    }

    public int Exercice3(double n) {
        return (int) Math.round(Math.pow(n, 0.5));
    }

    public int Exercice4(String mot) {
        int retour = 0, currentSuite = 0;
        char[] motInChar = mot.toCharArray();
        Arrays.sort(motInChar);
        for (int i = 0; i < motInChar.length; i++) {
            if (motInChar[i] == motInChar[i + 1]) {
                currentSuite++;
            }
            //fin d'une suite
            else {
                if (retour < currentSuite) {
                    retour = currentSuite;
                }
                currentSuite = 1;
            }

        }
        //si la chaine se termine sur une suite on regarde la dernière suite
        if (retour < currentSuite) {
            retour = currentSuite;
        }
        return retour;
    }

    public ArrayList<Integer> Exercice5(ArrayList<Integer> nombres) {
        ArrayList<Integer> retour = new ArrayList<Integer>(Collections.nCopies(nombres.size(), 0));
        Collections.sort(nombres);
        int currentIndex = 0;
        for (int i = 0; i < nombres.size() - 1; i += 2) {

            retour.set(i, nombres.get(nombres.size() - 1 - currentIndex));
            retour.set(i + 1, nombres.get(currentIndex));
            currentIndex++;
        }
        if (nombres.size() % 2 != 0) {
            retour.set(retour.size() - 1, nombres.get(nombres.size() / 2));
        }
        return retour;
    }

    public boolean Exercice6(ArrayList<Integer> numbers) {
        boolean retour = true;
        for (int i = 0; i < numbers.size(); i++) {
            int cond1 = 2 * i + 1;
            int cond2 = 2 * i + 2;
            //is in bound
            if (cond1 < numbers.size() && cond2 < numbers.size()) {
                if (numbers.get(i) < numbers.get(cond1) || numbers.get(i) < numbers.get(cond2)) {
                    retour = false;
                }

            } else {
                retour = false;
            }
        }
        return retour;
    }

    //Triangle de Pascal en  de O de N**2 à refaire en O N.
    public int[][] Exercice7(int k) {
        int[][] retour = new int[k][];
        retour[0]= new int[1];
        retour[0][0]=1;
        for (int i = 1; i < k; i++) {
            retour[i] = new int[i +1];
            for(int j=0;j<retour[i].length;j++){
                int audessus=j<retour[i-1].length?retour[i-1][j]:0;
                int agauche=j-1<0?0:retour[i-1][j-1];
                retour[i][j]=audessus+agauche;
            }
        }
        return retour;

    }

    public boolean IsAnagram(String s1, String s2) {//Fonction pour reconnaitre les anagrammes dans l'exercice 8
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        String sorted = new String(c1);
        String sorted2 = new String(c2);
        return sorted.equals(sorted2) ? true : false;
    }

    public String[][] Exercice8(List<String> mots) {
        String[][] retour=new String[mots.size()][mots.size()];
        for(int k=0;k< mots.size();k++){
            boolean place=false;
            String mot=mots.get(k);
            for(int i=0;i<mots.size();i++) {
                String first=retour[i][0];
                if (first == null) {
                    retour[i][0] = mot;
                    place=true;
                    break;
                }
                else{
                    System.out.println("no null");
                    if(IsAnagram(first,mot)){
                        for(int j=0;j<retour[i].length;j++){
                            if(retour[i][j]==null){
                                retour[i][j]=mot;
                                place=true;
                                break;
                            }
                        }
                    }

                }
                if (place){
                    break;
                }
            }

        }
        //Affichage
        for(int i=0;i< retour.length;i++){
            System.out.println("");
            for(int j=0;j<retour[i].length;j++){
                System.out.print(retour[i][j]+"  ");
            }
        }
        return  retour;

    }

    public Tuple Exercice9(int dividende, int diviseur) throws IllegalArgumentException{
        if(diviseur==0){
            throw new IllegalArgumentException("Division par 0 ");
        }
        else {//N'arrivant pas à import la classe tuple j'ai créer ma propre classe
            return  new Tuple(dividende/diviseur,dividende%diviseur);
        }
    }
    public ArrayList<Character> Exercice10(ArrayList<Character> chars) {
        int Rnumbers = 0;
        int Gnumbers = 0;
        int Bnumbers = 0;
        int currentIndex=0;
        for (Character c : chars) {
            if (c == 'R') {
                Rnumbers++;
            }
            if (c == 'G') {
                Gnumbers++;
            }
            if (c == 'B') {
                Bnumbers++;
            }
        }
        while (Rnumbers>0){
            chars.set(currentIndex,'R');
            currentIndex++;
            Rnumbers--;
        }
        while (Gnumbers>0){
            chars.set(currentIndex,'R');
            currentIndex++;
            Gnumbers--;
        }
        while (Bnumbers>0){
            chars.set(currentIndex,'R');
            currentIndex++;
            Bnumbers--;
        }
        return chars;
    }

    public boolean Exercice11(Character[][] plateau){
        boolean echec=false;
        int iRoi=0;
        int jRoi=0;
        //On commence par récupérer la position du roi
        for(int i=0;i<plateau.length;i++){
            for(int j=0;j<plateau[i].length;j++){
                if(plateau[i][j]=='K'){
                    iRoi=i;
                    jRoi=j;
                }
            }
        }
        //Pour chacune des cases non null on regarde si elles mettent le roi en échec
        for(int i=0;i< plateau.length;i++){
            for(int j=0;j<plateau[i].length;j++){
                boolean cheminvide=true;
                Character currentPiece=plateau[i][j];//La pièce qu'on étudie
                if(currentPiece=='R'||currentPiece=='Q'){//Tour et Reine Ligne/Colonne
                    if(i==iRoi){//On regarde sur la ligne
                        for(int k=Math.min(i,iRoi);i<Math.max(i,iRoi);k++){
                            if(plateau[k][j]!=null){
                                cheminvide=false;
                            }
                        }
                        if(cheminvide){
                            echec=true;
                        }
                    }
                    if(j==jRoi){//On regarde sur la colonne
                        for(int k=Math.min(j,jRoi);i<Math.max(j,jRoi);k++){
                            if(plateau[i][k]!=null){
                                cheminvide=false;
                            }
                        }
                        if(cheminvide){
                            echec=true;
                        }
                    }
                }
                double difColonne =iRoi-i;
                double difLigne=jRoi-j;
                if(currentPiece=='B'||currentPiece=='Q'){//Fou et reine Diagonale
                    if(((int)difLigne==difLigne)&&((int)difLigne==(int)difColonne)){//ils sont sur une même diagonale on regarde pour le chemin vide.
                        for(int k=0;k<Math.abs(difColonne);k++){
                            if(plateau[difColonne>0?i+k:i-k][difLigne>0?j+k:j-k]!=null){//je check uniquement les cases entre le fou et le roi
                                cheminvide=false;
                            }
                        }
                        if(cheminvide){
                            echec=true;
                        }
                    }
                }
                if(currentPiece=='N')//Cavalier on check les 8 cases
                {
                    int j1=j+1;
                    int j2=j+2;
                    int j3=j-1;
                    int j4=j-2;

                    int i1=i+1;
                    int i2=1+2;
                    int i3=i-1;
                    int i4=i-2;
                    if(j1<8&&i2<8&&j1==jRoi&&i2==iRoi){
                        echec=true;
                    }
                    if(j1<8&&i4>=0&&j1==jRoi&&i4==iRoi){
                        echec=true;
                    }
                    if(j2<8&&i1<8&&j2==jRoi&&i1==iRoi){
                        echec=true;
                    }
                    if(j2<8&&i3<8&&j2==jRoi&&i3==iRoi){
                        echec=true;
                    }
                    if(j3<8&&i2<8&&j3==jRoi&&i2==iRoi){
                        echec=true;
                    }
                    if(j3<8&&i4<8&&j3==jRoi&&i4==iRoi){
                        echec=true;
                    }
                    if(j4<8&&i1<8&&j4==jRoi&&i1==iRoi){
                        echec=true;
                    }
                    if(j4<8&&i3<8&&j4==jRoi&&i3==iRoi){
                        echec=true;
                    }


                }
                if(currentPiece=='P'){//Pion on check les deux diagonales avant
                    int j1=j+1;
                    int j2=j-1;
                    int i1=i+1;
                    if(j1==jRoi&&i1==iRoi){
                        echec=true;
                    }
                    if(j2==jRoi&&i1==iRoi){
                        echec=true;
                    }



                }
            }
        }
        return echec;
    }
}







