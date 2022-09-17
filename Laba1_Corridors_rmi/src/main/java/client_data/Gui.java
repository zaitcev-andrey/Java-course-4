package client_data;

import java.awt.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;
import server_data.ColorEnum;
import server_data.RemoteServerMethods;

/**
 *
 * @author megaa
 */
public class Gui extends javax.swing.JFrame {
    private static RemoteServerMethods stub_gui;
    ColorEnum myColor;
    private boolean gameOver = false;

    private void waitResponce() {
        try {
            while(!gameOver) {
                if(stub_gui.checkOnGameOver()) {
                    gameOver = true;
                    if(myColor == ColorEnum.RED) {
                        if(stub_gui.getRedPoint() > stub_gui.getBlackPoint())
                            jLabel8.setText("Конец игры, вы выиграли!!!");
                        else
                           jLabel8.setText("Конец игры, вы проиграли :("); 
                    }
                    else if(myColor == ColorEnum.BLACK) {
                        if(stub_gui.getBlackPoint() > stub_gui.getRedPoint())
                            jLabel8.setText("Конец игры, вы выиграли!!!");
                        else
                           jLabel8.setText("Конец игры, вы проиграли :(");
                    }
                }
                
                if(stub_gui.turnMove() == myColor)
                    jLabel1.setText("Сейчас ваш ход");
                else
                    jLabel1.setText("Сейчас ход соперника");
                
                if(myColor == ColorEnum.RED) {
                    jLabel6.setText(Integer.toString(stub_gui.getRedPoint()));
                    jLabel7.setText(Integer.toString(stub_gui.getBlackPoint()));
                }
                else if (myColor == ColorEnum.BLACK) {
                    jLabel6.setText(Integer.toString(stub_gui.getBlackPoint()));
                    jLabel7.setText(Integer.toString(stub_gui.getRedPoint()));
                }
                    
                
                if(stub_gui.getLastEdges() != -1) {
                    switch(stub_gui.getLastEdges()) {
                        case 1:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton1.setBackground(Color.RED);
                            else
                                jButton1.setBackground(Color.BLACK);
                            break;
                        case 2:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton2.setBackground(Color.RED);
                            else
                                jButton2.setBackground(Color.BLACK);
                            break;
                        case 3:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton3.setBackground(Color.RED);
                            else
                                jButton3.setBackground(Color.BLACK);
                            break;
                        case 4:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton4.setBackground(Color.RED);
                            else
                                jButton4.setBackground(Color.BLACK);
                            break;
                        case 5:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton5.setBackground(Color.RED);
                            else
                                jButton5.setBackground(Color.BLACK);
                            break;
                        case 6:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton6.setBackground(Color.RED);
                            else
                                jButton6.setBackground(Color.BLACK);
                            break;
                        case 7:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton7.setBackground(Color.RED);
                            else
                                jButton7.setBackground(Color.BLACK);
                            break;
                        case 8:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton8.setBackground(Color.RED);
                            else
                                jButton8.setBackground(Color.BLACK);
                            break;
                        case 9:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton9.setBackground(Color.RED);
                            else
                                jButton9.setBackground(Color.BLACK);
                            break;
                        case 10:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton10.setBackground(Color.RED);
                            else
                                jButton10.setBackground(Color.BLACK);
                            break;
                        case 11:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton11.setBackground(Color.RED);
                            else
                                jButton11.setBackground(Color.BLACK);
                            break;
                        case 12:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton12.setBackground(Color.RED);
                            else
                                jButton12.setBackground(Color.BLACK);
                            break;
                        case 13:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton13.setBackground(Color.RED);
                            else
                                jButton13.setBackground(Color.BLACK);
                            break;
                        case 14:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton14.setBackground(Color.RED);
                            else
                                jButton14.setBackground(Color.BLACK);
                            break;
                        case 15:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton15.setBackground(Color.RED);
                            else
                                jButton15.setBackground(Color.BLACK);
                            break;
                        case 16:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton16.setBackground(Color.RED);
                            else
                                jButton16.setBackground(Color.BLACK);
                            break;
                        case 17:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton17.setBackground(Color.RED);
                            else
                                jButton17.setBackground(Color.BLACK);
                            break;
                        case 18:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton18.setBackground(Color.RED);
                            else
                                jButton18.setBackground(Color.BLACK);
                            break;
                        case 19:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton19.setBackground(Color.RED);
                            else
                                jButton19.setBackground(Color.BLACK);
                            break;
                        case 20:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton20.setBackground(Color.RED);
                            else
                                jButton20.setBackground(Color.BLACK);
                            break;
                        case 21:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton21.setBackground(Color.RED);
                            else
                                jButton21.setBackground(Color.BLACK);
                            break;
                        case 22:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton22.setBackground(Color.RED);
                            else
                                jButton22.setBackground(Color.BLACK);
                            break;
                        case 23:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton23.setBackground(Color.RED);
                            else
                                jButton23.setBackground(Color.BLACK);
                            break;
                        case 24:
                            if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                jButton24.setBackground(Color.RED);
                            else
                                jButton24.setBackground(Color.BLACK);
                    }
                    
                    // теперь покрасим ячейки
                    ArrayList<Integer> listClosedCells = new ArrayList<>();
                    listClosedCells = stub_gui.getNewClosedCells();
                    for(int i = 0; i < listClosedCells.size(); i++) {
                        switch(listClosedCells.get(i)) {
                            case 0:
                                if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                    jPanel2.setBackground(Color.RED);
                                else
                                    jPanel2.setBackground(Color.BLACK);
                                break;
                            case 1:
                                if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                    jPanel3.setBackground(Color.RED);
                                else
                                    jPanel3.setBackground(Color.BLACK);
                                break;
                            case 2:
                                if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                    jPanel4.setBackground(Color.RED);
                                else
                                    jPanel4.setBackground(Color.BLACK);
                                break;
                            case 3:
                                if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                    jPanel5.setBackground(Color.RED);
                                else
                                    jPanel5.setBackground(Color.BLACK);
                                break;
                            case 4:
                                if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                    jPanel6.setBackground(Color.RED);
                                else
                                    jPanel6.setBackground(Color.BLACK);
                                break;
                            case 5:
                                if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                    jPanel7.setBackground(Color.RED);
                                else
                                    jPanel7.setBackground(Color.BLACK);
                                break;
                            case 6:
                                if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                    jPanel8.setBackground(Color.RED);
                                else
                                    jPanel8.setBackground(Color.BLACK);
                                break;
                            case 7:
                                if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                    jPanel9.setBackground(Color.RED);
                                else
                                    jPanel9.setBackground(Color.BLACK);
                                break;
                            case 8:
                                if(((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.BLACK)) ||
                                    ((stub_gui.getLastColor() == ColorEnum.RED) && (stub_gui.turnMove() == ColorEnum.RED)))
                                    jPanel10.setBackground(Color.RED);
                                else
                                    jPanel10.setBackground(Color.BLACK);
                        }
                    }
                }
                
                Thread.sleep(100);
            }
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
    
    public Gui() {
        initComponents();
    }
    
    public Gui(ColorEnum mycolor_, RemoteServerMethods stub_) {
        myColor = mycolor_;
        stub_gui = stub_;
        setTitle("Corridors(" + myColor + ")");
        initComponents();
        
        // Runnable task автоматически удалит поток по окончании
        Runnable task = new Runnable() {
            public void run() {
                waitResponce();
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Коридорчики");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Счёт:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Вы:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Соперник:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("jLabel6");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("jLabel6");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                                .addGap(61, 61, 61)))))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton1.getBackground() != Color.RED && jButton1.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton1.setBackground(Color.RED);
                    else
                        jButton1.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(1); // в параметре 1 так как кнопка номер 1
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn(); // передаём следующий ход другому клиенту
                    else // в случае закрытия ячейки ход продолжается
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton2.getBackground() != Color.RED && jButton2.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton2.setBackground(Color.RED);
                    else
                        jButton2.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(2); // в параметре 2 так как кнопка номер 2
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn();
                    else
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton3.getBackground() != Color.RED && jButton3.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton3.setBackground(Color.RED);
                    else
                        jButton3.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(3);
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn();
                    else
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton4.getBackground() != Color.RED && jButton4.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton4.setBackground(Color.RED);
                    else
                        jButton4.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(4);
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn();
                    else
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton5.getBackground() != Color.RED && jButton5.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton5.setBackground(Color.RED);
                    else
                        jButton5.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(5);
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn();
                    else
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                        

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton6.getBackground() != Color.RED && jButton6.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton6.setBackground(Color.RED);
                    else
                        jButton6.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(6);
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn();
                    else
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                        

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton7.getBackground() != Color.RED && jButton7.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton7.setBackground(Color.RED);
                    else
                        jButton7.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(7);
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn();
                    else
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                        

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton8.getBackground() != Color.RED && jButton8.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton8.setBackground(Color.RED);
                    else
                        jButton8.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(8);
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn();
                    else
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                        

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton9.getBackground() != Color.RED && jButton9.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton9.setBackground(Color.RED);
                    else
                        jButton9.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(9);
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn();
                    else
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                        

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton10.getBackground() != Color.RED && jButton10.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton10.setBackground(Color.RED);
                    else
                        jButton10.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(10);
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn();
                    else
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                         

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton11.getBackground() != Color.RED && jButton11.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton11.setBackground(Color.RED);
                    else
                        jButton11.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(11);
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn();
                    else
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                         

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton12.getBackground() != Color.RED && jButton12.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton12.setBackground(Color.RED);
                    else
                        jButton12.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(12);
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn();
                    else
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                         

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton13.getBackground() != Color.RED && jButton13.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton13.setBackground(Color.RED);
                    else
                        jButton13.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(13);
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn();
                    else
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                         

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton14.getBackground() != Color.RED && jButton14.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton14.setBackground(Color.RED);
                    else
                        jButton14.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(14);
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn();
                    else
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                         

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton15.getBackground() != Color.RED && jButton15.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton15.setBackground(Color.RED);
                    else
                        jButton15.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(15);
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn();
                    else
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                         

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton16.getBackground() != Color.RED && jButton16.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton16.setBackground(Color.RED);
                    else
                        jButton16.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(16);
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn();
                    else
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                         

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton17.getBackground() != Color.RED && jButton17.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton17.setBackground(Color.RED);
                    else
                        jButton17.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(17);
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn();
                    else
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                         

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton18.getBackground() != Color.RED && jButton18.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton18.setBackground(Color.RED);
                    else
                        jButton18.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(18);
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn();
                    else
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                         

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton19.getBackground() != Color.RED && jButton19.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton19.setBackground(Color.RED);
                    else
                        jButton19.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(19);
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn();
                    else
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                         

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton20.getBackground() != Color.RED && jButton20.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton20.setBackground(Color.RED);
                    else
                        jButton20.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(20);
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn();
                    else
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                         

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton21.getBackground() != Color.RED && jButton21.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton21.setBackground(Color.RED);
                    else
                        jButton21.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(21);
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn();
                    else
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                         

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton22.getBackground() != Color.RED && jButton22.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton22.setBackground(Color.RED);
                    else
                        jButton22.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(22);
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn();
                    else
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                         

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton23.getBackground() != Color.RED && jButton23.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton23.setBackground(Color.RED);
                    else
                        jButton23.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(23);
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn();
                    else
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                         

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            if(stub_gui.turnMove() == myColor){
                stub_gui.setLastColor(myColor);
                if(jButton24.getBackground() != Color.RED && jButton24.getBackground() != Color.BLACK) {
                    if(myColor == ColorEnum.RED)
                        jButton24.setBackground(Color.RED);
                    else
                        jButton24.setBackground(Color.BLACK);
                    
                    stub_gui.addEdgeInArr(24);
                    if(!stub_gui.checkClosedCell())
                        stub_gui.changeTurn();
                    else
                        stub_gui.setCheckClosedCellFalse();
                }
                else
                    System.out.println("Это ребро уже покрашено, выберете другое");
            }
            else
                System.out.println("Сейчас не ваш ход");
        } catch(Exception ev) {
            System.err.println("Server exception: " + ev.toString());
            ev.printStackTrace();
        }
    }                                         

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration                   
}
