/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class Server extends javax.swing.JFrame {

    private ServerSocket serverSocket;
    private Socket acceptSocket;
    
    private byte[] message;
    
    private PrintStream output;
    private DataOutputStream dataOutput;
    private BufferedReader input;
    private DataInputStream dataInput;
    
    private Scanner scan = new Scanner(System.in);
    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

    /**
     * Creates new form Server
     */
    public Server() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        serverTextArea = new javax.swing.JTextArea();
        serverComboBox = new javax.swing.JComboBox();
        serverTextField = new javax.swing.JTextField();
        serverButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        serverTextArea.setColumns(20);
        serverTextArea.setRows(5);
        jScrollPane1.setViewportView(serverTextArea);

        serverComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        serverButton.setText("OK");
        serverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serverComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serverTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane1, serverButton, serverComboBox, serverTextField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serverComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serverTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serverButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void serverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverButtonActionPerformed
        // TODO add your handling code here:
        if (acceptSocket.isConnected()) {
            if (!"".equals(serverTextField.getText())) {
//            String reply = scan.nextLine();
                String reply = serverTextField.getText();
                output.println(reply);
                serverTextArea.append("Server: " + reply + "\n");
//                System.out.println("Server: " + reply);

                serverTextField.setText("");
            }  
            
            byte[] test = hexStringToByteArray("7805f104");
//            byte[] test = new byte[]{
//                (byte)0x23, (byte)0x23, (byte)0x23
//            };
            try {
//                dataOutput.writeInt(test.length); // write length of the message
                dataOutput.write(test);           // write the message
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_serverButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Server().setVisible(true);
//            }
//        });
        Server server = new Server();
        server.setVisible(true);
        server.run();
    }

    public void run() {
        try {
            serverSocket = new ServerSocket(9999);
            acceptSocket = serverSocket.accept();

            output = new PrintStream(acceptSocket.getOutputStream());
            dataOutput = new DataOutputStream(acceptSocket.getOutputStream());
            input = new BufferedReader(new InputStreamReader(acceptSocket.getInputStream()));
            dataInput = new DataInputStream(acceptSocket.getInputStream());
            
            byte[] test = hexStringToByteArray("7805f104");
            dataOutput.writeInt(test.length); // write length of the message
            dataOutput.write(test);           // write the message
            

            while (acceptSocket.isConnected()) {
//                String message = input.readLine();
//                System.out.println("Client: " + message);
//                serverTextArea.append("Client: " + message + "\n");

//                String reply = scan.nextLine();
//                output.println(reply);
                int length = dataInput.readInt();                    // read length of incoming message
                if(length > 0) {
                    byte[] testMessage = new byte[length];
                    dataInput.readFully(testMessage, 0, testMessage.length); // read the message
                    System.out.println("Byte Aray: " + bytesToHexString(testMessage));
                    serverTextArea.append("Byte Aray: " + bytesToHexString(testMessage) + " length: " + testMessage.length + "\n");
                    
//                    Message message = new Message(testMessage);
//                    System.out.println("Byte 1: " + message.idByte);
//                    System.out.println("Byte 2: " + message.payloadLengthByte);
//                    System.out.println("Byte 3: " + message.messageCodeByte);
                    
                }
            }
            System.out.println("\nDisconnected?\n");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
    
    public static String bytesToHexString(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton serverButton;
    private javax.swing.JComboBox serverComboBox;
    private javax.swing.JTextArea serverTextArea;
    private javax.swing.JTextField serverTextField;
    // End of variables declaration//GEN-END:variables
}
