package org.example;

public class RecursiveSyntax {

    static final String[] conjunction = {"and", "or", "but", "because"};

    static final String[] proper_noun = {"Fred", "Jane", "Richard Nixon", "Miss America"};

    static final String[] common_noun = {"man", "woman", "fish", "elephant", "unicorn"};

    static final String[] determiner = {"a", "the", "every", "some"};

    static final String[] adjective = {"big", "tiny", "pretty", "bald"};

    static final String[] intransitive_verb = {"runs", "jumps", "talks", "sleeps"};

    static final String[] transitive_verb = {"loves", "hates", "sees", "knows", "looks for", "finds"};

    public static void main(String[] args) {
        while (true) {
            randomSentence();
            System.out.println(".\n\n");
            try {
                Thread.sleep(3000); // every 3 seconds to change to the next clause
            } catch (InterruptedException e) {

            }
        }
    }

    static void randomSentence() {  // Generating randomSentence
        randomNounPhrase();    // A sentence starts with a noun, then a verb follows
        randomVerbPhrase();
        if (Math.random() > 0.70) {   // 30% of the sentence will continue with other clauses to complete the sentence
            System.out.print(" " + randomItem(conjunction));
            randomSentence();
        }
    }

    static String randomItem(String[] listOfStrings) {
        return listOfStrings[(int) (Math.random() * listOfStrings.length)];
    }


    static void randomNounPhrase() {   // Generating randomNounPhrase
        if (Math.random() > 0.70)
            System.out.println(" " + randomItem(proper_noun));
        else {
            System.out.println(" " + randomItem(determiner));
            if (Math.random() > 0.5) // 50% will continue to the next clause
                System.out.println(" " + randomItem(adjective) + ".");
            System.out.println(" " + randomItem(common_noun));
            if (Math.random() > 0.5) {
                System.out.println("who");  //"who" can be added with the method randomVerbPhrase
                randomVerbPhrase();
            }
        }
    }

    static void randomVerbPhrase() {  // Generating randomVerbPhrase
        if (Math.random() > 0.77)
            System.out.println(" " + randomItem(intransitive_verb));
        else if (Math.random() > 0.50) {
            System.out.println(" " + randomItem(transitive_verb));
        } else if (Math.random() > 0.20)
            System.out.println("is" + randomItem(transitive_verb));

    }

}


