package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class HorseRace {
        JFrame frame;
        JProgressBar h1 = new JProgressBar(0,100);
        JProgressBar h2 = new JProgressBar(0,100);
        JProgressBar h3 = new JProgressBar(0,100);
        JProgressBar h4 = new JProgressBar(0,100);
        JProgressBar h5 = new JProgressBar(0,100);
        JLabel msg = new JLabel("Let's go!!!");

        boolean isWinner = false;
        boolean runRaceButton = false;
        boolean resetRaceButton = false;

        public synchronized void finish(int i){// i == 100;
            isWinner = true;
            if(i == 1){
                msg.setText("Red is winner" );
            }
            if(i == 2){
                msg.setText("Blue is winner" );
            }
            if(i == 3){
                msg.setText("Green is winner" );
            }
            if(i == 4){
                msg.setText("Yellow is winner" );
            }
            if(i == 5){
                msg.setText("Black is winner" );
            }

        }

        public static void main(String[] args) {
            EventQueue.invokeLater(() -> {
                try{
                    HorseRace window = new HorseRace();
                    window.frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }
    public HorseRace(){
            initialize();
    }
    public void initialize(){
            frame = new JFrame();
            frame.setBounds(100, 100, 598, 430);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(null);

            h1.setStringPainted(true);
            h1.setForeground(Color.red);
            h1.setBounds(150, 129, 259, 14);
            frame.getContentPane().add(h1);

            h2.setStringPainted(true);
            h2.setForeground(Color.BLUE);
            h2.setBounds(150, 159, 259, 14);
            frame.getContentPane().add(h2);

            h3.setStringPainted(true);
            h3.setForeground(Color.green);
            h3.setBounds(150, 189, 259, 14);
            frame.getContentPane().add(h3);

            h4.setStringPainted(true);
            h4.setForeground(Color.orange);
            h4.setBounds(150, 219, 259, 14);
            frame.getContentPane().add(h4);

            h5.setStringPainted(true);
            h5.setForeground(Color.black);
            h5.setBounds(150, 249, 259, 14);
            frame.getContentPane().add(h5);

            msg.setBounds(85, 100, 410, 14);
            msg.setVisible(false);
            frame.getContentPane().add(msg);
            msg.setVisible(true);

            JButton btnStart = new JButton("Run Race");
            btnStart.setFont(new Font("Tahoma", Font.PLAIN, 18));
            btnStart.addActionListener(new RunRace());
            btnStart.setBounds(50, 287, 155, 40);
            frame.getContentPane().add(btnStart);

            JButton btnReset = new JButton("Reset");
            btnReset.setFont(new Font("Tahoma", Font.PLAIN, 18));
            btnReset.addActionListener(new ResetRace());
            btnReset.setBounds(220, 287, 155, 40);
            frame.getContentPane().add(btnReset);

            JButton btnQuit = new JButton("Quit");
            btnQuit.setFont(new Font("Tahoma", Font.PLAIN, 18));
            btnQuit.addActionListener(new QuitProgram());
            btnQuit.setBounds(390, 287, 155, 40);
            frame.getContentPane().add(btnQuit);
    }
    class RunRace implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!runRaceButton) {// nút run == true thì mới nhấn được, khi nhấn nút reset thì runRaceButton = true
                isWinner = false;
                runRaceButton = true;
                resetRaceButton = false;
                H1 h1 = new H1();
                h1.start();

                H2 h2 = new H2();
                h2.start();

                H3 h3 = new H3();
                h3.start();

                H4 h4 = new H4();
                h4.start();

                H5 h5 = new H5();
                h5.start();
            }

        }
    }
    class ResetRace implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!resetRaceButton){
                    if(!isWinner){
                        isWinner = true;
                    }else {
                        isWinner = true;
                        runRaceButton = false;
                        resetRaceButton = true;
                        msg.setText("Let's go!!!");
                        h1.setValue(0);
                        h2.setValue(0);
                        h3.setValue(0);
                        h4.setValue(0);
                        h5.setValue(0);
                    }
                }


            }
        }
    class QuitProgram implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    class H1 extends Thread{
        @Override
        public void run() {
            for(int i = 0; i<= 100 ; i++){
                if(isWinner){
                    break;
                }
                h1.setValue(i);
                h1.repaint();
                if(i == 100){
                    finish(1);
                }
                try {
                    Thread.sleep(Math.abs(UUID.randomUUID().getMostSignificantBits()) % 60);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    class H2 extends Thread{
        @Override
        public void run() {
            for(int i = 0; i<= 100 ; i++){
                if(isWinner){
                    break;
                }
                h2.setValue(i);
                h2.repaint();
                if(i == 100){
                    finish(2);
                }
                try {
                    Thread.sleep(Math.abs(UUID.randomUUID().getMostSignificantBits()) % 60);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    class H3 extends Thread{
        @Override
        public void run() {
            for(int i = 0; i<= 100 ; i++){
                if(isWinner){
                    break;
                }
                h3.setValue(i);
                h3.repaint();
                if(i == 100){
                    finish(3);
                }
                try {
                    Thread.sleep(Math.abs(UUID.randomUUID().getMostSignificantBits()) % 60);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    class H4 extends Thread{
        @Override
        public void run() {
            for(int i = 0; i<= 100 ; i++){
                if(isWinner){
                    break;
                }
                h4.setValue(i);
                h4.repaint();
                if(i == 100){
                    finish(4);
                }
                try {
                    Thread.sleep(Math.abs(UUID.randomUUID().getMostSignificantBits()) % 60);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    class H5 extends Thread{
        @Override
        public void run() {
            for(int i = 0; i<= 100 ; i++){
                if(isWinner){
                    break;
                }
                h5.setValue(i);
                h5.repaint();
                if(i == 100){
                    finish(5);
                }
                try {
                    Thread.sleep(Math.abs(UUID.randomUUID().getMostSignificantBits()) % 60);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
