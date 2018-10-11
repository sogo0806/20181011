import javax.naming.NamingEnumeration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameMain5 extends JFrame {
    private JTextArea jtext = new JTextArea(null,"",15,10);
    private JTextArea jtext2 = new JTextArea(null,"",15,10);
    private JScrollPane jsp = new JScrollPane(jtext);
    private JScrollPane jsp2 = new JScrollPane(jtext2);
    private String in[] = {"DES","CAESA","AES","XOR"};
    private JComboBox jcom = new JComboBox<String>(in);
    private JRadioButton jrb = new JRadioButton("Encrpy");
    private JRadioButton jrb2 = new JRadioButton("Decrpy");
    private Container cp;
    private JPanel jpe = new JPanel(new GridLayout(1,1,3,3));
    private JPanel jpw = new JPanel(new GridLayout(1,1,3,3));
    private JPanel jpc = new JPanel(new GridLayout(9,1,3,3));
    private JButton jbt = new JButton("Close");
    private JButton jbt2 = new JButton("Run");
    private JButton jbt3 = new JButton("Exit");
    private JLabel jlb = new JLabel("Method");
    private JLabel jlb2 = new JLabel("Password");
    private JTextField jtf = new JTextField();
    ButtonGroup but = new ButtonGroup();
    FrameMain3 ad;
    public FrameMain5(FrameMain3 af){
        ad = af;
        init();
    }
    public void init(){
        this.setBounds(100,100,500,700);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                ad.setVisible(true);
            }
        });
        this.setLayout(null);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(jpe,BorderLayout.EAST);
        cp.add(jpc,BorderLayout.CENTER);
        cp.add(jpw,BorderLayout.WEST);
        jpe.add(jsp);
        jpw.add(jsp2);
        jpc.add(jlb);
        jpc.add(jcom);
        jpc.add(jlb2);
        jpc.add(jtf);
        jpc.add(jrb);
        jpc.add(jrb2);
        but.add(jrb);
        but.add(jrb2);
        jpc.add(jbt);
        jpc.add(jbt2);
        jpc.add(jbt3);



        jbt2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jrb.isSelected()){

                    switch (jcom.getSelectedIndex()){
                        case 0:
                            break;

                        case 1:
                            int key = Integer.parseInt(jtf.getText());
                            int datalength = jtext2.getText().length();
                            char data[] = jtext2.getText().toCharArray();
                            for (int i = 0 ; i < datalength ; i++){
                                data [i] = (char)(data[i]+key);
                            }
                            jtext.setText(new String(data));
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                }
                else if(jrb2.isSelected()) {
                    switch (jcom.getSelectedIndex()){
                        case 0:
                            break;

                        case 1:
                            int key = Integer.parseInt(jtf.getText());
                            int datalength = jtext.getText().length();
                            char data[] = jtext.getText().toCharArray();
                            for (int i = 0 ; i < datalength ; i++){
                                data [i] = (char)(data[i]-key);
                            }
                            jtext2.setText(new String(data));
                            break;
                    }
                }

            }
        });

    }

}
