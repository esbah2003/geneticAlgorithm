package GENE;

/** This program is Genetic Algorithm
 *
 * @author Esbah Majoka
 * Student Number: 7357981
 * @version 3.0 (March 10th )                                                        */

public class MyGene implements Genome, AlphabetInterface { // implementing Genome and Alphabet interface methods

    String DNA;

    public MyGene(String s) {
        for (int i = 0; i < s.length(); i++) {
            if(!validLetter(s.charAt(i))){
                throw new UsageException(); // throwing exception
            }

        }
        DNA = s;
    }//constructor

    public String toString(){
        return DNA;
    }//toString

    public boolean validLetter( char c ) {
        return c == alphabet[0] || c == alphabet[1] || c == alphabet[2] || c == alphabet[3] ;
    }

    @Override
    public int Card() {
        return DNA.length();
    }

    @Override
    public Genome Clone() {
        return new MyGene(DNA);
    }

    @Override
    public Genome ConCat(Genome g) {
        return new MyGene(DNA + g.toString());
    }

    @Override
    public boolean Equal(Genome g) {
        return DNA.equals(g.toString());
    }

    @Override
    public Genome Mutate(double p) { //Mutating
        int a;
        String s = "";
        for (int i = 0; i < Card(); i++) {
            if(p >= Math.random()){
                s += DNA.charAt(i);
            }
            else{
                a = (int)(Math.random() * 4);
                while( alphabet[a] == DNA.charAt(i) ){
                    a = (int)(Math.random() * 4);

                }
                s += alphabet[a];
            }
        }
        return new MyGene(s);
    }

    @Override
    public Genome OnePointCrossOver(Genome g, int i) { //Onepoint cross-over method
        String s = "";
        if( Card() == g.Card() && i >= 0 && i < Card() ){
            for (int j = 0; j < Card(); j++) {
                if( j > i ){
                    s += g.toString().charAt(j);
                }
                else {
                    s += DNA.charAt(j);
                }
            }
        }
        else{
            throw new UsageException(); // throw and catch usageException
        }
        return new MyGene(s);
    }

    @Override
    public Genome TwoPointCrossOver(Genome g, int i, int j) { //Twopoints cross-over method
        String s = "";
        if( Card() == g.Card() && i >= 0 && i < Card() && j > i && j < Card() ){
            for (int k = 0; k < Card(); k++) {
                if( k >= i && k <= j ){
                    s += g.toString().charAt(k);
                }
                else {
                    s += DNA.charAt(k);
                }
            }
        }
        else{
            throw new UsageException(); // throw and catch usageException
        }
        return new MyGene(s);
    }

    @Override
    public Genome Inversion() { //inversion method
        String s = "";
        for (int i = Card() - 1; i >= 0 ; i--) {
            s += DNA.charAt(i);
        }
        return new MyGene(s);
    }
}

