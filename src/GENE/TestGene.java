package GENE;

import BasicIO.ASCIIDisplayer;
/** This program is Genetic Algorithm
 *
 * @author Esbah Majoka
 * Student Number: 7357981
 * @version 3.0 (March 10th )                                                        */

public class TestGene {


    public TestGene() {
        ASCIIDisplayer display = new ASCIIDisplayer(); //new displayer


        Genome a, b, c;

        // These are statements

        display.writeLine("              Genetic Algorithm        \n ");
        display.writeLine("TEST HARNESS for MyGene class : \n\n" +
                "Testing Instantiation --> \n" +
                "Trying {\n" +
                "   a = new MyGene(\"abdgabdg\");\n" +
                "   b = new MyGene(\"aaaa\");\n" +
                "   c = new MyGene(\"abcdefg\");\n" +
                "}");
        /*      Testing                                                           */
        // Here we are instantiating a, b, and c for Exception
        a = new MyGene("");// Verifies that no exceptions are occurred
        b = new MyGene("");
        c = new MyGene("");
        try {
            a = new MyGene("abdgabdg");
            b = new MyGene("aaaa");
            c = new MyGene("abcdefg");
        } catch (UsageException e) {
            display.writeLine("\n  Invalid character was entered. Valid characters are {'a', 'b', 'd', 'g'}. Displaying valid Genomes.\n");
        }
        display.writeLine(" Results:\n" +
                "a: " + a + "\n" +
                "b: " + b + "\n" +
                "c: " + c + "\n" );

        /*      Here it is testing Card & Concat                                                           */
        display.writeLine("\nTesting Cardinalities, Concatenation, and Comparisons \n");
        display.writeLine("The current cardinalities are    a: " + a.Card() + ", b: " + b.Card() + ", c: " + c.Card() + "\n");
        display.writeLine("Trying {\n" +
                "   a = a.ConCat(c);\n" +
                "   c = c.ConCat(b);\n" +
                "   b = b.ConCat(a);\n" +
                "}\n");
        a = a.ConCat(c);
        c = c.ConCat(b);
        b = b.ConCat(a);
        display.writeLine("The current cardinalities are    a: " + a.Card() + ", b: " + b.Card() + ", c: " + c.Card());
        display.writeLine(" Results:\n" +
                "a: " + a + "\n" +
                "b: " + b + "\n" +
                "c: " + c + "\n\n" +
                "a.Equal(a)? " + a.Equal(a) + "\n" +
                "b.Equal(a)? " + b.Equal(a) + "\n" +
                "c.Equal(c.Clone())? " + c.Equal(c.Clone()) + "\n" +
                "c.Equal(new MyGene(\"aaaa\"))? " + c.Equal(new MyGene("aaaa")));

        /*      Here mutation is being tested                                                     */
        display.writeLine("\nTesting Mutate..\n");
        display.writeLine("Currently Trying {\n" +
                "   a = a.Mutate(1.01);\n" +
                "   b = b.Mutate(-0.01);\n" +
                "   c = c.Mutate(0.5);\n" +
                "}");
        a = a.Mutate(1.01);
        b = b.Mutate(-0.01);
        c = c.Mutate(0.5);
        display.writeLine(" Results:\n" +
                "a: " + a + "\n" +
                "b: " + b + "\n" +
                "c: " + c.toString());

        /*     Here it is testing OnePointCrossOver                                                           */
        display.writeLine("\nTesting OnePointCrossOver..\n");
        display.writeLine("Trying {\n" +
                "   a = new MyGene(\"aaaa\");\n" +
                "   b = new MyGene(\"bbbb\");\n" +
                "   c = new MyGene(\"dddd\");\n" +
                "   a = a.OnePointCrossOver(b, 1);\n" +
                "   b = b.OnePointCrossOver(c, 0);\n" +
                "   c = c.OnePointCrossOver(a, 3);\n" +
                "}");
        a = new MyGene("aaaa");
        b = new MyGene("bbbb");
        c = new MyGene("dddd");
        a = a.OnePointCrossOver(b, 1);
        b = b.OnePointCrossOver(c, 0);
        c = c.OnePointCrossOver(a, 3);
        display.writeLine(" Results:\n" +
                "a: " + a + "\n" +
                "b: " + b + "\n" +
                "c: " + c + "\n");

        display.writeLine("Trying {\n" +
                "   a = a.OnePointCrossOver(new MyGene(\"a\"), 1);\n" +
                "   b = b.OnePointCrossOver(b, 5);\n" +
                "   c = c.OnePointCrossOver(c, -1);\n" +
                "}");
        try {
            a = a.OnePointCrossOver(new MyGene("a"), 1);
            b = b.OnePointCrossOver(b, 5);
            c = c.OnePointCrossOver(c, -1);
        } catch (UsageException e) {
            display.writeLine("  The invalid index or Genome with non-matching cardinalities was entered. Currently, no operation was performed.");
        }
        display.writeLine(" Results:\n" +
                "a: " + a + "\n" +
                "b: " + b + "\n" +
                "c: " + c + "\n");

        /*      Here it is testing TwoPointCrossOver                                                           */
        display.writeLine("Testing TwoPointCrossOver..\n");
        display.writeLine("Trying {\n" +
                "   a = new MyGene(\"aaaa\");\n" +
                "   b = new MyGene(\"bbbb\");\n" +
                "   c = new MyGene(\"dddd\");\n" +
                "   a = a.TwoPointCrossOver(b, 1, 2);\n" +
                "   b = b.TwoPointCrossOver(c, 1, 2);\n" +
                "   c = c.TwoPointCrossOver(a, 1, 2);\n" +
                "}");
        a = new MyGene("aaaa");
        b = new MyGene("bbbb");
        c = new MyGene("dddd");
        a = a.TwoPointCrossOver(b, 1, 2);
        b = b.TwoPointCrossOver(c, 1, 2);
        c = c.TwoPointCrossOver(a, 1, 2);
        display.writeLine(" Results:\n" +
                "a: " + a + "\n" +
                "b: " + b + "\n" +
                "c: " + c + "\n");
        display.writeLine("Trying {\n" +
                "   a = a.ConCat(a).ConCat(a);\n" +
                "   b = b.ConCat(b);\n" +
                "" +
                "   a = a.TwoPointCrossOver(b, 1, 2);\n" +
                "   b = b.TwoPointCrossOver(c, 1, 2);\n" +
                "   c = c.TwoPointCrossOver(a, 1, 2);\n" +
                "}");
        a = a.TwoPointCrossOver(b, 1, 2);
        b = b.TwoPointCrossOver(c, 1, 2);
        c = c.TwoPointCrossOver(a, 1, 2);
        display.writeLine(" Results:\n" +
                "a: " + a + "\n" +
                "b: " + b + "\n" +
                "c: " + c + "\n");

        display.writeLine(" Testing inversion");
        a = new MyGene("aabbgg");
        a = a.Inversion();
        display.writeLine("a : " + a.toString());
    }


    public static void main(String[] args) {
        new TestGene();
    }
}