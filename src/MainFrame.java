import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame{
    private JPanel jpn = new JPanel(new GridLayout(3,3));
    private Container cp;
    private JTextField jtf = new JTextField();
    private JButton jbtns[] = new JButton[9];
    private LoginFrame loginFrame;
    public MainFrame(LoginFrame login){
        loginFrame=login;
        init();
    }
    public void init(){
        this.setBounds(100,100,400,500);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(5,5));
        cp.add(jtf,BorderLayout.NORTH);
        cp.add(jpn,BorderLayout.CENTER);
        jtf.setEditable(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loginFrame.setVisible(true);
            }
        });
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        for(int i=0;i<9;i++){
            jbtns[i]=new JButton(Integer.toString(i));
            jpn.add(jbtns[i]);
            jbtns[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tmpButton = (JButton) e.getSource();
                    jtf.setText(jtf.getText()+ tmpButton.getText());
                }
            });
        }
    }
}
