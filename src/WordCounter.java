import java.util.*;

public class WordCounter {

    private String content;
    private ArrayList<String> words;
    private Map<String, Integer> wordCounter = new HashMap<String, Integer>();
    private Integer counter = 0;

    public WordCounter(String text) {
        this.content = text;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    void counterIncrement(){
        this.counter++;
    }

    public void killerChars(){
        this.setContent(this.getContent().replaceAll("[@#$%^&*()_+=,.!?:;-]", " "));
    }

    public void wordsArrayCreator(){
        this.words = new ArrayList<>(Arrays.asList(getContent().toLowerCase().split(" ")));
        this.words.removeIf(i -> i.length() < 1);
    }

    public void wordsCounterDictionaryCreator(){
        for(String word : this.words){
            this.wordCounter.merge(word, 1 ,Integer::sum);
            counterIncrement();
        }
    }

    //Następująca funckja nie jest mojego autorstwa
    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }


        return sortedMap;
    }

    public void displayInformation(){
        System.out.println("Razem słów: "+this.counter);
        this.wordCounter = sortByValue(wordCounter);
        this.wordCounter.forEach((k,v) -> System.out.println(k+"\t\t"+v));
    }

}
