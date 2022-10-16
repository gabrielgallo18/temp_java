
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    private JTextField temp;
    private JLabel testeLabel;

    public LoginFrame(){
        setTitle("Converter temperatura");
        setSize(301,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        configurarLayout();
        setVisible(true);
    }

    private void configurarLayout() {
        JPanel painel = new JPanel();

        JRadioButton celsius = new JRadioButton("Celsius");
        JRadioButton kelvin = new JRadioButton("Kelvin");
        JRadioButton fahrenheit = new JRadioButton("Fahrenheit");
        ButtonGroup group = new ButtonGroup();
        group.add(celsius);
        group.add(kelvin);
        group.add(fahrenheit);

        temp = new JTextField();
        temp.setColumns(15);

        JButton botaoCelsius = new JButton("Celsius");
        JButton botaoKelvin = new JButton("Kelvin");
        JButton botaoFahrenheit  = new JButton("Fahrenheit");

        botaoCelsius.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kelvin.isSelected()){
                    Kelvin_Celsius();
                }else if(fahrenheit.isSelected()){
                    Fahrenheit_Celsius();
                }else{
                    Omesmo();
                }
            }
        });
        botaoKelvin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(celsius.isSelected()){
                    Celsius_Kelvin();
                }else if(fahrenheit.isSelected()){
                    Fahrenheit_Kelvin();
                }else{
                    Omesmo();
                }
            }
        });
        botaoFahrenheit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(celsius.isSelected()){
                    Celsius_Fahrenheit();
                }else if(kelvin.isSelected()){
                    Kelvin_Fahrenheit();
                }else{
                    Omesmo();
                }
            }
        });


        testeLabel = new JLabel();
        painel.add(new JLabel("Indique a sua escala de temperatura atual"));
        painel.add(celsius);
        painel.add(kelvin);
        painel.add(fahrenheit);
        painel.add(new JLabel("Indique a escala para qual deseja converter"));
        painel.add(temp);
        
        painel.add(botaoCelsius);
        painel.add(botaoKelvin);
        painel.add(botaoFahrenheit);
        painel.add(testeLabel);
        painel.setBorder(BorderFactory
                        .createCompoundBorder(BorderFactory.createEmptyBorder(20,20,20,20)
                        ,BorderFactory.createTitledBorder("Converter Temperatura")));
        add(painel);
    }

    private void Omesmo() {
        Integer intemp = Integer.parseInt(temp.getText());  
        testeLabel.setText(String.valueOf(intemp));
    }


    private void Kelvin_Celsius() {
        Integer intemp = Integer.parseInt(temp.getText());  
        double resultado = intemp - 273.15;
        testeLabel.setText(String.valueOf(resultado));
    }
    private void Fahrenheit_Celsius() {
        Integer intemp = Integer.parseInt(temp.getText());  
        double resultado = ((intemp - 32) * 5) / 9;
        testeLabel.setText(String.valueOf(resultado));
    }


    private void Celsius_Kelvin() {
        Integer intemp = Integer.parseInt(temp.getText());  
        double resultado = intemp + 273.15;
        testeLabel.setText(String.valueOf(resultado));
    }
    private void Fahrenheit_Kelvin() {
        Integer intemp = Integer.parseInt(temp.getText());  
        double resultado = (((intemp - 32) * 5) / 9) + 273.15;
        testeLabel.setText(String.valueOf(resultado));
    }


    private void Celsius_Fahrenheit() {
        Integer intemp = Integer.parseInt(temp.getText());  
        double resultado = ((intemp * 9) / 5) + 32;
        testeLabel.setText(String.valueOf(resultado));
    }
    private void Kelvin_Fahrenheit() {
        Integer intemp = Integer.parseInt(temp.getText());  
        double resultado = (((intemp - 273.15) * 9) / 5) + 32;
        testeLabel.setText(String.valueOf(resultado));
    }


}
