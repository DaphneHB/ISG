/*
 * CGUI.java
 *
 * Created on 15 September 2007, 12:47
 */

package unitsynctest;

import aflobby.CJNAUnitsync;
import aflobby.CUnitSyncJNIBindings;
import aflobby.CUnitSyncJNIVersion;
import java.awt.Color;

/**
 *
 * @author  AF-StandardUsr
 */
public class CGUI extends javax.swing.JFrame {
    
    /** Creates new form CGUI */
    public CGUI() {
        initComponents();
        javax.swing.SwingUtilities.invokeLater (new Runnable () {
            public void run () {
                setLocationRelativeTo(null);
            }
        });
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        Test1 = new javax.swing.JLabel();
        Test2 = new javax.swing.JLabel();
        Test3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Test4 = new javax.swing.JLabel();
        Test5 = new javax.swing.JLabel();
        Test6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Run Tests");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Test1.setText("Test 1 (mingw32)");

        Test2.setText("Test 2 (VS2005)");

        Test3.setText("Test 3 (JNI version bindings mingw32 (SVN only))");

        jLabel1.setText("Click on Run tests to the right.");

        Test4.setText("Test 4 (JNI version Bindings VS2005 (SVN only))");

        Test5.setText("Test 5 (JNA Mingw32)");

        Test6.setText("Test 6 (JNA VS2005)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Test3)
                    .addComponent(Test4)
                    .addComponent(Test2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(Test1)
                    .addComponent(Test5)
                    .addComponent(Test6))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(15, 15, 15)
                .addComponent(Test1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Test2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Test3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Test4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Test5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Test6)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton1.setEnabled(false);
        
        CUnitSyncJNIBindings.LoadUnitSync("unitsync");
        if(CUnitSyncJNIBindings.loaded){
            Test1.setForeground(Color.GREEN);
        }else{
            Test1.setForeground(Color.RED);
        }
        
        CUnitSyncJNIVersion.LoadUnitSync("unitsync");
        if(CUnitSyncJNIVersion.loaded){
            Test3.setForeground(Color.GREEN);
        }else{
            Test3.setForeground(Color.RED);
        }
        
        CUnitSyncJNIBindings.LoadUnitSync("unitsyncvs2005");
        if(CUnitSyncJNIBindings.loaded){
            Test2.setForeground(Color.GREEN);
        }else{
            Test2.setForeground(Color.RED);
        }
        
        CUnitSyncJNIVersion.LoadUnitSync("unitsyncvs2005");
        if(CUnitSyncJNIVersion.loaded){
            Test4.setForeground(Color.GREEN);
        }else{
            Test4.setForeground(Color.RED);
        }
        
        try{
            CJNAUnitsync c1 = CJNAUnitsync.INSTANCE;
            String s = c1.GetSpringVersion();
            Test5.setForeground(Color.GREEN);
            Test5.setText("Test 5 (JNA Mingw32) spring version: "+s);
        } catch (Exception e){
            Test5.setForeground(Color.RED);
            Test5.setText("Test 5 (JNA Mingw32)");
        }
        
        try{
            CJNAUnitsync c1 = CJNAUnitsync.INSTANCE2;
            String s = c1.GetSpringVersion();
            Test6.setForeground(Color.GREEN);
            Test6.setText("Test 6 (JNA VS2005) spring version: "+s);
        } catch (Exception e){
            Test6.setForeground(Color.RED);
            Test6.setText("Test 6 (JNA VS2005)");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CGUI().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Test1;
    private javax.swing.JLabel Test2;
    private javax.swing.JLabel Test3;
    private javax.swing.JLabel Test4;
    private javax.swing.JLabel Test5;
    private javax.swing.JLabel Test6;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    
}
