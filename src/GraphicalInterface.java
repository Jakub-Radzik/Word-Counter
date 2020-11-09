import javax.swing.*;
import java.awt.event.*;
import java.util.Map;

public class GraphicalInterface {
    private JFrame frame;
    private JTextArea text;
    private JScrollPane scrollForText;
    private JButton showWordStats;
    private JLabel charStats;
    private JLabel wordStats;

    public String getTextContent() {
        return text.getText();
    }

    public void setCharStatisticsContent(String txt) {
        this.charStats.setText(txt);
    }
    public void setWordStatisticsContent(String txt) {
        this.wordStats.setText(txt);
    }

    GraphicalInterface(){
        frame = new JFrame("Word Counter");
        text = new JTextArea(10,20);
        scrollForText = new JScrollPane(text);
        charStats = new JLabel();
        wordStats = new JLabel();
        showWordStats = new JButton("Word statistics");

        text.addKeyListener(new KeyTyped());
        showWordStats.addActionListener(new ButtonClicked());
        frame.addWindowListener(new WindowClose());

        scrollForText.setBounds(10,10,280,300);
        wordStats.setBounds(10,320,280,50);
        charStats.setBounds(10,340,280,50);
        showWordStats.setBounds(10,400,150,30);

        wordStats.setText("Start typing...");
        scrollForText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollForText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        text.setLineWrap(true);

        frame.add(scrollForText);
        frame.add(charStats);
        frame.add(wordStats);
        frame.add(showWordStats);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(320,500);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    class KeyTyped implements KeyListener {

        int textLength;
        int wordCount;

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            textLength = getTextContent().length();
            wordCount = getTextContent().split(" ").length;

            setWordStatisticsContent("Words: " + wordCount);
            setCharStatisticsContent("Characters: " + textLength);
        }
    }
    class ButtonClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder information = new StringBuilder();
            information.append("Word count:\n");
            Map<String, Integer> wordCounter = WordCounter.wordStatsDictionary(getTextContent());
            wordCounter.forEach((k,v) -> information.append(k).append(" : ").append(v).append("\n"));
            JOptionPane.showMessageDialog(frame, information);
        }
    }
    class WindowClose extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            int a=JOptionPane.showConfirmDialog(frame,"Are you sure?");
            if(a==JOptionPane.YES_OPTION){
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        }
    }
}


