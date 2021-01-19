/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checker;
import java.util.Random;

import static checker.Checker.ini;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.System.exit;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author kaun_meet
 */
public class maine extends javax.swing.JFrame {

    /**
     * Creates new form maine
     */
    public maine() {
        initComponents();
    }

    class myj extends JPanel {

        public void paint(Graphics g) {

            if (ini.remminus == 0) {
                exit(0);
            }
            if (ini.remone == 0) {
                exit(0);
            }
            int i, j, k, l;
            int maxx = 400;
            int maxy = 400;
            int n = 8;
            int dx = (maxx) / (n);

            int dy = (maxy) / (n);

            // draw no possible move
            int player1 = 0, player2 = 0;
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (ini.board.get(i).get(j) == 1 || ini.board.get(i).get(j) == 2) {
                        if (ini.movepossible(i, j) != 0) {
                            player1++;

                        }

                    }

                    if (ini.board.get(i).get(j) == -1 || ini.board.get(i).get(j) == -2) {
                        if (ini.movepossible(i, j) != 0) {
                            player2++;
                        }
                    }
                }
            }

            if (player1 == 0 && player2 == 0) {

                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "No moves possible");
                exit(0);

            }

            if (ini.chance >= 1 && player1 == 0) {
                ini.chance = -1;
            } else if (ini.chance <= -1 && player2 == 0) {
                ini.chance = 1;
            }

            System.out.println("meetai");

            Graphics2D g1 = (Graphics2D) g;

            g1.setColor(Color.BLACK);

            for (i = 0; i <= n + 1; i++) {
                g1.drawLine(0, dy * i, maxx, dy * i);

                g1.drawLine(dx * i, 0, dx * i, maxy);
            }
            if (ini.acquired == 1) {
                System.out.println("choosed");

                int xcor = ini.acqx;
                int ycor = ini.acqy;

                g1.setColor(Color.yellow);

                int x1, x2, y1, y2;

                y1 = (xcor) * (dy);
                y2 = y1 + dy;

                x1 = (ycor) * (dx);
                x2 = x1 + dx;

                g1.drawLine(x1, y1, x2, y1);
                g1.drawLine(x1, y1, x1, y2);
                g1.drawLine(x1, y2, x2, y2);
                g1.drawLine(x2, y1, x2, y2);

//                g1.fillOval(xx, yy, ddx, ddy);
                i = xcor;
                j = ycor;

                int xx, yy;
                xx = (j * dx) + (dx / 4);
                yy = (i * dy) + (dy / 4);

                int ddx = dx * 7;
                ddx = ddx / 10;

                int ddy = dy * 7;
                ddy = ddy / 10;

//                ddx+=10;
//                ddy+=10;
//                g1.setColor(Color.blue);
//                g1.fillOval(0,0,dx,dy);
                int gdx = dx / 10;
                int gdy = dy / 10;

//                g1.setColor(Color.yellow);
//                g1.fillOval(xx, yy, ddx, ddy);
//                
            }

            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    int xx, yy;
                    xx = (j * dx) + (dx / 4);
                    yy = (i * dy) + (dy / 4);

                    int ddx = dx * 7;
                    ddx = ddx / 10;

                    int ddy = dy * 7;
                    ddy = ddy / 10;

                    if (ini.board.get(i).get(j) == 0) {

                    } else if (ini.board.get(i).get(j) == 1) {
                        g1.setColor(Color.red);

                        g1.fillOval(xx, yy, ddx, ddy);

                    } else if (ini.board.get(i).get(j) == -1) {
                        g1.setColor(Color.blue);
//                        g1.fillOval(xx, yy, WIDTH, HEIGHT);
//                        g1.fillColor(Color.blue);
                        g1.fillOval(xx, yy, ddx, ddy);
                    } else if (ini.board.get(i).get(j) == 2) {
                        g1.setColor(Color.red);

//                        g1.drawLine(xx, yy,xx+ ddx, yy+ddy);
                        g1.fillRect(xx - 4, yy - 4, ddx, ddy);

                    } else if (ini.board.get(i).get(j) == -2) {

                        g1.setColor(Color.blue);
                        g1.fillRect(xx - 4, yy - 4, ddx, ddy);

//                        g1.fillOvals(xx, yy, ddx, ddy);
                    }

                }
            }
        }

//            g1.drawLine((sizex * i) / (m), 0, (sizex * i) / (m), sizey);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        myj jPanel1;

        //
        jPanel1 = new myj();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jButton1.setText("AI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked

        System.out.println(evt.getX() + " " + evt.getY());
        int clickx = evt.getX();
        int clicky = evt.getY();

        int i, j, k, l;

        int posx, posy;
        int maxx = 400;
        int maxy = 400;
        int n = 8;
        int dx = (maxx) / (n);

        int dy = (maxy) / (n);

        posy = (clickx) / (dx);
        posx = (clicky) / (dy);
        System.out.println("chance  " + ini.chance + " " + ini.acquired + " " + ini.acqx + " " + ini.acqy + " " + posx + " " + posy);
//  
        if (ini.acquired == 0) {
            if (ini.board.get(posx).get(posy) == ini.chance || ini.board.get(posx).get(posy) == 2 * ini.chance) {
                System.out.println("acquired");

                ini.acqx = posx;
                ini.acqy = posy;

                ini.acquired = 1;
//                ini.chance = -ini.chance;

            }

        } else {
            ini.acquired = 0;

            if (ini.board.get(posx).get(posy) != 0) {
//                ini.chance = -ini.chance;

                System.out.println("not empty");

            } else {

                int chose = ini.board.get(ini.acqx).get(ini.acqy);

                if (chose >= 1) {

                    if ((posx == ini.acqx - 1) && ((posy == ini.acqy + 1) || (posy == ini.acqy - 1))) {

                        if (posx == 0) {
                            ini.board.get(posx).set(posy, 2);

                        } else {
                            ini.board.get(posx).set(posy, chose);

                        }

                        ini.board.get(ini.acqx).set(ini.acqy, 0);

                        ini.chance = -ini.chance;

                    } else {
                        if (posx == ini.acqx - 2) {
                            if (posy == ini.acqy - 2) {
                                if (ini.board.get(ini.acqx - 1).get(ini.acqy - 1) < 0) {

                                    ini.board.get(posx).set(posy, chose);
                                    if (posx == 0) {
                                        ini.board.get(posx).set(posy, 2);

                                    }

                                    ini.board.get(ini.acqx).set(ini.acqy, 0);

                                    ini.board.get(posx + 1).set(posy + 1, 0);

                                    ini.remminus--;

                                    if (ini.remminus == 0) {
                                        JFrame f = new JFrame();
                                        JOptionPane.showMessageDialog(f, "First Player won");

                                    }

                                    ini.chance = -ini.chance;

                                }

                            }
                            if (posy == ini.acqy + 2) {
                                if (ini.board.get(posx + 1).get(posy - 1) < 0) {

                                    ini.board.get(posx).set(posy, chose);
                                    if (posx == 0) {
                                        ini.board.get(posx).set(posy, 2);

                                    }

                                    ini.board.get(ini.acqx).set(ini.acqy, 0);
                                    ini.board.get(posx + 1).set(posy - 1, 0);

                                    ini.chance = -ini.chance;

                                    ini.remminus--;

                                    if (ini.remminus == 0) {
//                                       maine.setVisible(false);
                                        JFrame f = new JFrame();
                                        JOptionPane.showMessageDialog(f, "First Player won");

                                    }

                                }

                            }
                        }
                    }
                    if (chose == 2) {

                        if ((posx == ini.acqx + 1) && ((posy == ini.acqy + 1) || (posy == ini.acqy - 1))) {
                            ini.board.get(posx).set(posy, chose);

                            ini.board.get(ini.acqx).set(ini.acqy, 0);
                            ini.chance = -ini.chance;

                        } else {

                            if (posx == ini.acqx + 2) {
                                if (posy == ini.acqy - 2) {
                                    if (ini.board.get(posx - 1).get(posy + 1) < 0) {
                                        ini.board.get(posx).set(posy, chose);

                                        ini.board.get(ini.acqx).set(ini.acqy, 0);
                                        ini.board.get(posx - 1).set(posy + 1, 0);

                                        ini.chance = -ini.chance;

                                        ini.remminus--;
                                        if (ini.remminus == 0) {
////                                       maine.setVisible(false);
                                            JFrame f = new JFrame();
                                            JOptionPane.showMessageDialog(f, "Second Player won");

                                        }

                                    }

                                }
                                if (posy == ini.acqy + 2) {
                                    if (ini.board.get(posx - 1).get(posy - 1) < 0) {

                                        ini.board.get(posx).set(posy, chose);

                                        ini.board.get(ini.acqx).set(ini.acqy, 0);
                                        ini.board.get(posx - 1).set(posy - 1, 0);

                                        ini.chance = -ini.chance;

                                        ini.remminus--;
                                        if (ini.remminus == 0) {
//                                       maine.setVisible(false);
                                            JFrame f = new JFrame();
                                            JOptionPane.showMessageDialog(f, "Second Player won");
//
                                        }
//
                                    }
//
                                }
                            }
//
                        }

                    }

                }

                if (chose <= -1) {

                    if ((posx == ini.acqx + 1) && ((posy == ini.acqy + 1) || (posy == ini.acqy - 1))) {
                        ini.board.get(posx).set(posy, chose);
                        if (posx == n - 1) {
                            ini.board.get(posx).set(posy, -2);

                        }
                        ini.board.get(ini.acqx).set(ini.acqy, 0);
                        ini.chance = -ini.chance;

                    } else {

                        if (posx == ini.acqx + 2) {
                            if (posy == ini.acqy - 2) {
                                if (ini.board.get(posx - 1).get(posy + 1) > 0) {
                                    ini.board.get(posx).set(posy, chose);
                                    if (posx == n - 1) {
                                        ini.board.get(posx).set(posy, -2);

                                    }

                                    ini.board.get(ini.acqx).set(ini.acqy, 0);
                                    ini.board.get(posx - 1).set(posy + 1, 0);

                                    ini.chance = -ini.chance;

                                    ini.remone--;
                                    if (ini.remone == 0) {
////                                       maine.setVisible(false);
                                        JFrame f = new JFrame();
                                        JOptionPane.showMessageDialog(f, "Second Player won");

                                    }

                                }

                            }
                            if (posy == ini.acqy + 2) {
                                if (ini.board.get(posx - 1).get(posy - 1) > 0) {

                                    ini.board.get(posx).set(posy, chose);
                                    if (posx == n - 1) {
                                        ini.board.get(posx).set(posy, -2);

                                    }

                                    ini.board.get(ini.acqx).set(ini.acqy, 0);
                                    ini.board.get(posx - 1).set(posy - 1, 0);

                                    ini.chance = -ini.chance;

                                    ini.remone--;
                                    if (ini.remone == 0) {
//                                       maine.setVisible(false);
                                        JFrame f = new JFrame();
                                        JOptionPane.showMessageDialog(f, "Second Player won");
//
                                    }
//
                                }
//
                            }
                        }
//
                    }

                    if (chose == -2) {

                        if ((posx == ini.acqx - 1) && ((posy == ini.acqy + 1) || (posy == ini.acqy - 1))) {
                            ini.board.get(posx).set(posy, chose);

                            ini.board.get(ini.acqx).set(ini.acqy, 0);
                            ini.chance = -ini.chance;

                        } else {
                            if (posx == ini.acqx - 2) {
                                if (posy == ini.acqy - 2) {
                                    if (ini.board.get(ini.acqx - 1).get(ini.acqy - 1) > 0) {

                                        ini.board.get(posx).set(posy, chose);

                                        ini.board.get(ini.acqx).set(ini.acqy, 0);

                                        ini.board.get(posx + 1).set(posy + 1, 0);

                                        ini.remone--;

                                        if (ini.remone == 0) {
                                            JFrame f = new JFrame();
                                            JOptionPane.showMessageDialog(f, "First Player won");

                                        }

                                        ini.chance = -ini.chance;

                                    }

                                }
                                if (posy == ini.acqy + 2) {
                                    if (ini.board.get(posx + 1).get(posy - 1) > 0) {

                                        ini.board.get(posx).set(posy, chose);

                                        ini.board.get(ini.acqx).set(ini.acqy, 0);
                                        ini.board.get(posx + 1).set(posy - 1, 0);

                                        ini.chance = -ini.chance;

                                        ini.remone--;

                                        if (ini.remone == 0) {
//                                       maine.setVisible(false);
                                            JFrame f = new JFrame();
                                            JOptionPane.showMessageDialog(f, "First Player won");

                                        }

                                    }

                                }
                            }
                        }

                    }
//
                }

            }
//            repaint();

            if (ini.remone == 0) {
                exit(0);

//            maine.setVisible(false);
            }
            if (ini.remminus == 0) {
                exit(0);
//            maine.setVisible(false);
            }

        } // TODO add your handling code here:

        repaint();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged

//        System.out.println("Dragged ai ");
//
//        if (ini.acquired == 0) {
//
//            if (ini.chance == -1) {
//
//                result chalbhai;
//                compute obj = new compute();
//                chalbhai = obj.nextmove(ini.board, -1, 0);
//
//                ArrayList<Integer> info = chalbhai.data;
//
//                if (info.size() == 0) {
//                    ini.chance = 1;
//
//                } else {
//                    int x1 = info.get(0);
//                    int y1 = info.get(1);
//
//                    int x2 = info.get(2);
//                    int y2 = info.get(3);
//
//                    if (x2 == x1 + 1) {
//
//                        ini.board.get(x2).set(y2, -1);
//                        ini.board.get(x1).set(y1, 0);
//
//                        ini.chance = 1;
//
//                    } else {
//                        if (y2 == y1 + 2) {
//                            ini.board.get(x1).set(y1, 0);
//                            ini.board.get(x1 + 1).set(y1 + 1, 0);
//                            ini.board.get(x1 + 2).set(y1 + 2, -1);
//
//                        } else {
//                            ini.board.get(x1).set(y1, 0);
//                            ini.board.get(x1 + 1).set(y1 - 1, 0);
//                            ini.board.get(x1 + 2).set(y1 - 2, -1);
//
//                        }
//                        ini.chance = 1;
//
//                    }
//                }
//
//            }
//        }
//
//        repaint();
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ini.acquired = 0;
        System.out.println("chance is of" + ini.chance);
        if (ini.chance == -1) {

//            result chalbhai=compute.nextmove(ini.board,-1,0);
            result chalbhai;
            compute obj = new compute();
            chalbhai = obj.nextmove(ini.board, -1, 0);

            ArrayList<Integer> info = chalbhai.data;

            if (info.size() == 0) {
                ini.chance = 1;

            } else {
                int x1 = info.get(0);
                int y1 = info.get(1);
                int n = ini.n;
                int piece = ini.board.get(x1).get(y1);

                int x2 = info.get(2);
                int y2 = info.get(3);

                System.out.println("neet bhai " + x1 + " " + y1 + " " + x2 + " " + y2);

                if (x2 == x1 + 1) {

                    ini.board.get(x2).set(y2, piece);

                    if (x2 == n - 1) {
                        ini.board.get(x2).set(y2, -2);
                    }
                    ini.board.get(x1).set(y1, 0);

                    ini.chance = 1;

                }

                if (x2 == x1 + 2) {
                    if (y2 == y1 + 2) {
                        ini.board.get(x1).set(y1, 0);
                        ini.board.get(x1 + 1).set(y1 + 1, 0);

                        ini.board.get(x1 + 2).set(y1 + 2, -1);

                        if (x2 == n - 1) {
                            ini.board.get(x2).set(y2, -2);
                        }

                    } else {
                        ini.board.get(x1).set(y1, 0);
                        ini.board.get(x1 + 1).set(y1 - 1, 0);
                        ini.board.get(x1 + 2).set(y1 - 2, -1);

                        if (x2 == n - 1) {
                            ini.board.get(x2).set(y2, -2);
                        }

                    }
                    ini.chance = 1;

                }

                if (piece == -2) {

                    if (x2 == x1 - 1) {

                        ini.board.get(x2).set(y2, piece);
                        ini.board.get(x1).set(y1, 0);
//                        if (x2 == 0) {
//                            ini.board.get(x2).set(y2, -2);
//
//                        }

                        ini.chance = 1;

                    }
                    if (x2 == x1 - 2) {
                        if (y2 == y1 + 2) {
                            ini.board.get(x1).set(y1, 0);
                            ini.board.get(x1 - 1).set(y1 + 1, 0);
                            ini.board.get(x1 - 2).set(y1 + 2, piece);

//                            if (x2 == 0) {
//                                ini.board.get(x2).set(y2, 2);
//                            }
                        } else {
                            ini.board.get(x1).set(y1, 0);
                            ini.board.get(x1 - 1).set(y1 - 1, 0);
                            ini.board.get(x1 - 2).set(y1 - 2, piece);
//                            if (x2 == 0) {
//                                ini.board.get(x2).set(y2, 2);
//                            }

                        }
                        ini.chance = 1;

                    }

                }

            }

        } else {

            int n = 8;

            result chalbhai;
            compute obj = new compute();
            chalbhai = obj.nextmove(ini.board, 1, 0);

            ArrayList<Integer> info = chalbhai.data;

            if (info.size() == 0) {
                ini.chance = -1;

            } else {
                int x1 = info.get(0);
                int y1 = info.get(1);

                int x2 = info.get(2);
                int y2 = info.get(3);

                int piece = ini.board.get(x1).get(y1);
                System.out.println("neet bhai " + x1 + " " + y1 + " " + x2 + " " + y2);

                if (x2 == x1 - 1) {

                    ini.board.get(x2).set(y2, piece);
                    ini.board.get(x1).set(y1, 0);
                    if (x2 == 0) {
                        ini.board.get(x2).set(y2, 2);

                    }

                    ini.chance = -1;

                }
                if (x2 == x1 - 2) {
                    if (y2 == y1 + 2) {
                        ini.board.get(x1).set(y1, 0);
                        ini.board.get(x1 - 1).set(y1 + 1, 0);
                        ini.board.get(x1 - 2).set(y1 + 2, piece);

                        if (x2 == 0) {
                            ini.board.get(x2).set(y2, 2);
                        }

                    } else {
                        ini.board.get(x1).set(y1, 0);
                        ini.board.get(x1 - 1).set(y1 - 1, 0);
                        ini.board.get(x1 - 2).set(y1 - 2, piece);
                        if (x2 == 0) {
                            ini.board.get(x2).set(y2, 2);
                        }

                    }
                    ini.chance = -1;

                }

                if (piece == 2) {

                    if (x2 == x1 + 1) {

                        ini.board.get(x2).set(y2, piece);

//                        if (x2 == n - 1) {
//                            ini.board.get(x2).set(y2, -2);
//                        }
                        ini.board.get(x1).set(y1, 0);

                        ini.chance = -1;

                    }

                    if (x2 == x1 + 2) {
                        if (y2 == y1 + 2) {
                            ini.board.get(x1).set(y1, 0);
                            ini.board.get(x1 + 1).set(y1 + 1, 0);

                            ini.board.get(x1 + 2).set(y1 + 2, piece);

//                            if (x2 == n - 1) {
//                                ini.board.get(x2).set(y2, -2);
//                            }
                        } else {
                            ini.board.get(x1).set(y1, 0);
                            ini.board.get(x1 + 1).set(y1 - 1, 0);
                            ini.board.get(x1 + 2).set(y1 - 2, piece);

//                            if (x2 == n - 1) {
//                                ini.board.get(x2).set(y2, -2);
//                            }
                        }
                        ini.chance = -1;

                    }

                }

            }

//            repaint();
//            return;
        }
//        }
        repaint();

        int i, j;
        int n = ini.n;

        int noofpos = 0;
        int noofneg = 0;

        ArrayList<Integer> movesf = new ArrayList<Integer>();
        ArrayList<Integer> movess = new ArrayList<Integer>();

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (ini.board.get(i).get(j) < 0) {
                    movesf.add(i);
                    movess.add(j);
                }
            }
        }

        for (int itt = 0;
                itt < movesf.size();
                itt++) {
            int x = movesf.get(itt);
            int y = movess.get(itt);

            if (x + 1 < n && y > 0) {
                if (ini.board.get(x + 1).get(y - 1) == 0) {
                    noofneg++;
                }
            }
            if (x + 1 < n && y + 1 < n) {
                if (ini.board.get(x + 1).get(y + 1) == 0) {
                    noofneg++;
                }
            }

            if (x + 2 < n && y - 2 >= 0) {
                if (ini.board.get(x + 2).get(y - 2) == 0) {
                    if (ini.board.get(x + 1).get(y - 1) >= 1) {
                        noofneg++;
                    }

                }

            }

            if (x + 2 < n && y + 2 < n) {
                if (ini.board.get(x + 2).get(y + 2) == 0) {
                    if (ini.board.get(x + 1).get(y + 1) >= 1) {
                        noofneg++;
                    }
                }
            }

            if (ini.board.get(x).get(y) == -2) {

                if (x - 1 >= 0 && y > 0) {
                    if (ini.board.get(x - 1).get(y - 1) == 0) {
                        noofneg++;
                    }
                }

                if (x - 1 >= 0 && y + 1 < n) {
                    if (ini.board.get(x - 1).get(y + 1) == 0) {
                        noofneg++;
                    }
                }

                if (x - 2 >=0 && y - 2 >= 0) {
                    if (ini.board.get(x - 2).get(y - 2) == 0) {
                        if (ini.board.get(x - 1).get(y - 1) > 0) {
                            noofneg++;
                        }

                    }

                }

                if (x - 2 >=0 && y + 2 < n) {
                    if (ini.board.get(x - 2).get(y + 2) == 0) {
                        if (ini.board.get(x - 1).get(y + 1) > 0) {
                            noofneg++;
                        }
                    }
                }

            }

        }

        movesf.clear();
        movess.clear();

//        ArrayList<Integer> movesf = new ArrayList<Integer>();
//        ArrayList<Integer> movess = new ArrayList<Integer>();
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (ini.board.get(i).get(j) > 0) {
                    movesf.add(i);
                    movess.add(j);
                }
            }
        }

        for (int itt = 0;
                itt < movesf.size();
                itt++) {
            int x = movesf.get(itt);
            int y = movess.get(itt);

            if (x - 1 >= 0 && y > 0) {
                if (ini.board.get(x - 1).get(y - 1) == 0) {
                    noofpos++;
                }
            }

            if (x - 1 >= 0 && y + 1 < n) {
                if (ini.board.get(x - 1).get(y + 1) == 0) {
                    noofpos++;
                }
            }

            if (x - 2 >=0 && y - 2 >= 0) {
                if (ini.board.get(x - 2).get(y - 2) == 0) {
                    if (ini.board.get(x - 1).get(y - 1) < 0) {
                        noofpos++;
                    }

                }

            }

            if (x - 2 >=0 && y + 2 < n) {
                if (ini.board.get(x - 2).get(y + 2) == 0) {
                    if (ini.board.get(x - 1).get(y + 1) < 0) {
                        noofpos++;
                    }
                }
            }

            if (ini.board.get(x).get(y) == 2) {

                if (x + 1 <n && y > 0) {
                    if (ini.board.get(x + 1).get(y - 1) == 0) {
                        noofpos++;
                    }
                }

                if (x + 1 <n && y + 1 < n) {
                    if (ini.board.get(x + 1).get(y + 1) == 0) {
                        noofpos++;
                    }
                }

                if (x + 2 < n && y - 2 >= 0) {
                    if (ini.board.get(x + 2).get(y - 2) == 0) {
                        if (ini.board.get(x + 1).get(y - 1) < 0) {
                            noofpos++;
                        }

                    }

                }

                if (x + 2 < n && y + 2 < n) {
                    if (ini.board.get(x + 2).get(y + 2) == 0) {
                        if (ini.board.get(x + 1).get(y + 1) < 0) {
                            noofpos++;
                        }
                    }
                }

            }

        }

        if (noofneg == 0 && noofpos == 0) {

            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Drawn !!!  No moves possible");

            exit(0);
//            ini.chance = -ini.chance;
        }

        if (noofneg == 0) {
            ini.chance = 1;
        }
        if (noofpos == 0) {
            ini.chance = -1;
        }


    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(maine.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(maine.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(maine.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(maine.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new maine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
