/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vtu;
import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class MainMenu extends javax.swing.JFrame {
String n,u,s,r,t,p;
    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        setPreferredSize(new java.awt.Dimension(400, 200));

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel2.setText("V.T.U. Results");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Enter your USN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     try
     {
         UserAgent userAgent = new UserAgent();
  //File file =new File("C:\\Users\\Admin\\Desktop\\example.txt");
  //BufferedWriter output=new BufferedWriter(new FileWriter(file));
  //create new userAgent (headless browser).
  userAgent.visit("http://results.vtu.ac.in"); 
  userAgent.doc.apply(jTextField1.getText());
  userAgent.doc.submit("SUBMIT");
  Element creds= userAgent.doc.findFirst("<TD width=\"513\">");
  Element ele=creds.findEvery("<b>");
  Element ele1=ele.getElement(0);
  String name="Name : "+ele1.innerHTML().substring(0, ele1.innerHTML().indexOf("(")-1);
  String usn="USN : "+ele1.innerHTML().substring(ele1.innerHTML().indexOf("(")+1,ele1.innerHTML().length()-2);
  String sem=(ele.getElement(1)).innerHTML()+(ele.getElement(2)).innerHTML();
  String result=(ele.getElement(3)).innerHTML();
  result=result.substring(0, result.indexOf(":")+1)+result.substring(result.indexOf(";")+7, result.length()-1);
  result=result.trim();
  Element table=creds.findEvery("<table>");
  Element total=(table.getElement(2)).findEach("<td>");
  String marks=(total.getElement(3)).innerHTML();
  marks=marks.substring(0,marks.indexOf("&nbsp")-1);
  /* Element sname=subjects.findEvery("<i>");
  Element marks=subjects.findEvery("<td>");
  String[] s={(sname.getElement(0)).innerHTML(),(sname.getElement(1)).innerHTML(),
      (sname.getElement(2)).innerHTML(),
      (sname.getElement(3)).innerHTML(),(sname.getElement(4)).innerHTML(),
      (sname.getElement(5)).innerHTML(),(sname.getElement(6)).innerHTML(),(sname.getElement(7)).innerHTML()};
  String[] m={(marks.getElement(3)).innerHTML()};*/
  double per=0;
  DecimalFormat df=new DecimalFormat("##.##");
  
  marks=marks.trim();
  int m=Integer.parseInt(marks);
  int semester=Integer.parseInt((ele.getElement(2)).innerHTML());
  if(semester==1 || semester==2)
   {
       per=(m/775.0)*100;
   }
  else
  {
      per=(m/900.0)*100;
  }
  n=name;
  u=usn;
  s=sem;
  r=result;
  t=marks;
  p=Double.toString(per);
   System.out.println(n);
    
}
catch(JauntException e ){         //if an HTTP/connection error occurs, handle JauntException.
  System.err.println(e);
}
     jButton1.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
          ResultPage f= new ResultPage(n,u,s,r,t,p);
          f.setVisible(true);
          
          
         }
     });
       /* catch(IOException e)
        {
            System.err.println(e);
        }*/
        // TODO code applica
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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
