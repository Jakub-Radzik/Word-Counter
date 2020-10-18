import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Wprowadź swój text: ");
        WordCounter text = new WordCounter(s.nextLine());
        text.killerChars();
        text.wordsArrayCreator();
        text.wordsCounterDictionaryCreator();
        text.displayInformation();
    }
}
