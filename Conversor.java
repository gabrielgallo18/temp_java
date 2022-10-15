import java.awt.*;
import java.awt.event.*;
import java.io.Serial;
import javax.swing.*;

public class Conversor extends JFrame {
    private JComboBox entrada, saida;
    private JTextField visores[];

    public Conversor() {
        setTitle("[Conversor]");
        setSize(250, 250);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        iniciarComponentes();
        setVisible(true);
    }

    private void iniciarComponentes() {
        setLayout(new FlowLayout(FlowLayout.CENTER));

        visores = new  JTextField[2];
        for(int i = 0; i < visores.length; i++){
            visores[i] = new JTextField();
            visores[i].setPreferredSize(new Dimension(240,32));
        }

        visores[1].setEditable(false);

        String temperaturas[] = {"Celsius", "Fahrenheit", "Kelvin"};
        entrada = new JComboBox(temperaturas);
        saida = new JComboBox(temperaturas);

        Container c = new Container();
        c.setLayout(new GridLayout(3, 2));

        JButton converte = new JButton("Converter!");
        converte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    float a = Float.parseFloat(visores[0].getText());
                    int b = entrada.getSelectedIndex();
                    int c = saida.getSelectedIndex();
                    if(b == c)
                        visores[1].setText(a + "");

                    /* Celsius */
                    else if(b == 0 && c == 1)
                        visores[1].setText((a * 1.8 + 32) + "");
                    else if(b == 0 && c == 2)
                        visores[1].setText((a + 273.15) + "");

                    /* Fahrenheit */
                    else if(b == 1 && c == 0)
                        visores[1].setText(((a - 32) / 1.8) + "");
                    else if(b == 1 && c == 2)
                        visores[1].setText(((a - 32) / 1.8 + 273.15) + "");

                    /* Kelvin */
                    else if(b == 2 && c == 0)
                        visores[1].setText((a - 273.15) + "");
                    else if(b == 2 && c == 1)
                        visores[1].setText((a - 273.15 - 32)/1.8 + "");

                } catch (NumberFormatException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        c.add(new JLabel("De"));
        c.add(entrada);
        c.add(new JLabel("Para"));
        c.add(saida);

        add(visores[0]);
        add(c);
        add(converte);
        add(visores[1]);
    }
}
