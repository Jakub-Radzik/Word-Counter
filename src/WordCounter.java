import java.util.*;
import java.util.function.Function;

public class WordCounter {

    private static int counter = 0;

    static void counterIncrement(){
        counter++;
    }

    public Integer getCounter() {
        return this.counter;
    }

    public static Function<String, String> killerChars = (txt) -> {
        return txt.replaceAll("[@#$%^&*()_+=,.!?:;-]", " ");
    };

    public static ArrayList<String> wordsArrayCreator(String text){
        ArrayList<String> words = new ArrayList<>(Arrays.asList(text.toLowerCase().split(" ")));
        words.removeIf(i -> i.length() < 1);
        return words;
    }

    public static Map<String,Integer> wordsCounterDictionaryCreator(ArrayList<String> words){
        Map<String, Integer> wordCounter = new HashMap<String, Integer>();
        for(String word : words){
            wordCounter.merge(word, 1 ,Integer::sum);
            counterIncrement();
        }
        return wordCounter;
    }

    //Następująca funckja nie jest mojego autorstwa
    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }


        return sortedMap;
    }

    public static Map<String, Integer> wordStatsDictionary(String text){
        text = killerChars.apply(text);
        ArrayList<String> words = wordsArrayCreator(text);
        Map<String, Integer> wordCounter = wordsCounterDictionaryCreator(words);
        wordCounter = sortByValue(wordCounter);
        return wordCounter;
    }

}
