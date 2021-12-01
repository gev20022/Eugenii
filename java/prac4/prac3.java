import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class prac3  extends JFrame
{
    static long realCount = 0;
    static long milanCount = 0;

    static String milan = "AC Milan";
    static String real  = "Real Madrid";
    JButton milanButton = new JButton(milan);
    JButton realButton = new JButton(real);
    JLabel result = new JLabel("Result 0 X 0");
    JLabel lastScorer = new JLabel("Last scorer: N/A");
    JLabel winner = new JLabel("Winner : DRAW");
    Font font = new Font("Times new roman",Font.BOLD,50);

    JPanel[] pnl = new JPanel[5];
    private JPanel panel1;

    prac3()
    {
        super("Real vs Milan");
        setLayout(new GridLayout(5, 1));
        setSize(800,800);
        for(int i = 0; i < pnl.length; i++) {
            pnl[i] = new JPanel();
            add(pnl[i]);
            pnl[i].setLayout(new FlowLayout());
        }
        result.setFont(font);
        lastScorer.setFont(font);
        winner.setFont(font);
        realButton.setFont(font);
        milanButton.setFont(font);
        pnl[0].add(result);
        pnl[1].add(lastScorer);
        pnl[2].add(winner);
        pnl[3].add(realButton);
        pnl[4].add(milanButton);
        setVisible(true);
        milanButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                milanGoal();
            }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        });

        realButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                realGoal();
            }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        });
    }

    public void realGoal(){
        realCount++;
        reDrawStats();
        setLastScorer(real);
    }

    public void milanGoal(){
        milanCount++;
        reDrawStats();
        setLastScorer(milan);
    }

    public void reDrawStats(){
        result.setText(realCount + " X " + milanCount);
        if(milanCount == realCount)
            winner.setText("DRAW");
        else if( milanCount > realCount)
            setWinner(milan);
        else
            setWinner(real);

    }

    public void setLastScorer(String scorer){
        lastScorer.setText("LAST SCORER : " + scorer);
    }

    public void setWinner(String winner){
        this.winner.setText("WINNER : " + winner);
    }

    public static void main(String[]args)
    {
        new prac3();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}