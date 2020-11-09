import javax.swing.*;

public class GraphicalInterface {
    JFrame frame;
    JTextArea text;
    JScrollPane scrollForText;
    JLabel statistics;

    GraphicalInterface(){
        frame = new JFrame("Word Counter");
        text = new JTextArea(10,20);
        scrollForText = new JScrollPane(text);
        statistics = new JLabel();


        scrollForText.setBounds(10,10,280,300);
        statistics.setBounds(10,320,280,50);

        statistics.setText("Start typing...");
        scrollForText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollForText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        text.setLineWrap(true);

        frame.add(scrollForText);
        frame.add(statistics);
        frame.setLayout(null);
        frame.setSize(320,500);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
