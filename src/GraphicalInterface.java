import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GraphicalInterface {
    private JFrame frame;
    private JTextArea text;
    private JScrollPane scrollForText;
    private JButton showWordStats;
    private JLabel statistics;

    public String getTextContent() {
        return text.getText();
    }

    public JLabel getStatistics() {
        return statistics;
    }

    public void setStatisticsContent(String txt) {
        this.statistics.setText(txt);
    }

    GraphicalInterface(){
        frame = new JFrame("Word Counter");
        text = new JTextArea(10,20);
        scrollForText = new JScrollPane(text);
        statistics = new JLabel();
        showWordStats = new JButton("Word statistics");

        text.addKeyListener(new KeyTyped());

        scrollForText.setBounds(10,10,280,300);
        statistics.setBounds(10,320,280,50);
        showWordStats.setBounds(10,380,150,30);

        statistics.setText("Start typing...");
        scrollForText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollForText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        text.setLineWrap(true);

        frame.add(scrollForText);
        frame.add(statistics);
        frame.add(showWordStats);
        frame.setLayout(null);
        frame.setSize(320,500);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    class KeyTyped implements KeyListener {

        int textLength;
        int wordCount;
        int spaceCount;

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            textLength = getTextContent().length();
            setStatisticsContent("Znaków: " + textLength);
        }
    }
}


