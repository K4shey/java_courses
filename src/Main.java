import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main implements ActionListener {


    JButton button;

    public static void main(String[] args) throws IOException  {

        Main mainClass = new Main();
        mainClass.go();


//        int primitive = 5;
//        int[] array1 = {5};
//        String[] array2 = {"hello"};
//        StringBuilder sb = new StringBuilder();
//        myFunc(primitive, array1, array2, sb);
//        System.out.println("primitive = " + primitive);
//        System.out.println("array1 = " + Arrays.toString(array1));
//        System.out.println("array2 = " + Arrays.toString(array2));
//        System.out.println("sb = " + sb);

//        int i = 1;
//        while (i <=8) {
//            if ((i % 2) == 0)
//                continue;
//            System.out.println(i);
//            i++;
//        }
//        Scanner sc = new Scanner(System.in);
//        Double total = 0.0;
//        sc.useLocale(Locale.ENGLISH);
//        while (sc.hasNext()) {
//            try {
//                  total = total + sc.nextDouble();
//            } catch (InputMismatchException e) {
//                sc.next();
//            }
//        }
//        System.out.printf("%.6f", total);
//        String name = "kUKURUZO"; //new Scanner(System.in).nextLine();
//        System.out.println("Hello, " + name);


    }

    private  void go(){

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("Click me");
        button.addActionListener(this);

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.setSize(300,300);
        frame.setVisible(true);

    }

    private static void myFunc(int primitive, int [] array1, String[] array2, StringBuilder sb){
        primitive = 14;
        array1[0] = 23;
        array2[0] = "Bye-bye";
        sb.append("test");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (button.getText() == "Click me") {
            button.setText("I've been clicked!");
        } else if (button.getText() == "I've been clicked!") {
            button.setText("Click me");
        }

    }
}
