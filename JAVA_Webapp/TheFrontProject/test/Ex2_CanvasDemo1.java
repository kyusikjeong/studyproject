/*
    요약:
    draw 윈도우 위치를 바꾸기 위해 x 변수 선언
    run 메소드 변경
    main 메소드 변경

 */
package ex1;

import java.awt.*;


public class Ex2_CanvasDemo1 extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form Ex2_CanvasDemo1
     */
    private int arcNum;
    private int x; // drawArc 의 객체를 움직임
    
    public Ex2_CanvasDemo1() {      
        initComponents();
    }
    public void setX(int x){
        this.x = x;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvas1 = new java.awt.Canvas(){
            @Override
            public void update(Graphics g) {
                paint(g);
            }

            @Override
            public void paint(Graphics g) {
                g.drawArc(x,100,100,100,0,arcNum);

            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(500, 500));

        canvas1.setBackground(new java.awt.Color(255, 204, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 579, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Ex2_CanvasDemo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ex2_CanvasDemo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ex2_CanvasDemo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ex2_CanvasDemo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Ex2_CanvasDemo1 ref = new Ex2_CanvasDemo1();
        ;/* Create and display the form */
        Thread t1 = new Thread(ref);
        Thread t2 = new Thread(ref);
        //두개의 스레드가 한개의 객체를 참조합니다
        // 원을 두개 만들려고 Ex2_CanvasDemo를 두번 생성하면 창이 두개 뜨게 됩니다.
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ref.setVisible(true);
                 
            }

        });
        t1.start(); //t1 스레드 출발
        try{t1.join();}catch(Exception e){} // 다른 것들이 오지 못하게 막습니다.
        ref.setX(200);// X 값을 200으로 옮깁니다.
        t2.start(); // t2 스레드 출발
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        
        for (int i = 0; i < 361; i += 10) {
            try {
                arcNum = i;
                System.out.println(arcNum);
                Thread.sleep(100);
                canvas1.repaint();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        arcNum = 0; 
        //초기화를 하지 않으면 
        //초기부터 그려진 원이 나타납니다..
        
        }
    }


