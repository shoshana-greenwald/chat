/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientchat;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.OutputStream;
import static java.lang.Integer.parseInt;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author user1
 */
public class NewJFrameClient extends javax.swing.JFrame {

    private String UserName;//   �� �������
    private Client ChatClient; // ���� �������
    Boolean x = true; // ����� ������ �������

    public NewJFrameClient() {
        //����� ����
        initComponents();
        setResizable(false);//�� ���� ������ ����
        setLocationRelativeTo(null);//����� �����
        setTitle("Client");
        setSize(315, 410);
        getContentPane().setBackground(Color.WHITE);//��� ���
        sendChat.setEnabled(false);
        UserText.setEnabled(false);
        warrningMessage.setVisible(false);
        UserInput.requestFocus();


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        UserInput = new javax.swing.JTextField();
        label1 = new java.awt.Label();
        UserText = new javax.swing.JTextField();
        label2 = new java.awt.Label();
        sendChat = new java.awt.Button();
        ChatBox = new java.awt.TextArea();
        connectToServer = new java.awt.Button();
        warrningMessage = new java.awt.Label();
        userPic = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clientchat/user-pic.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeTheWindow(evt);
            }
        });

        UserInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UserInputKeyPressed(evt);
            }
        });

        label1.setBackground(new java.awt.Color(255, 255, 255));
        label1.setForeground(new java.awt.Color(255, 102, 51));
        label1.setText("your name:");

        UserText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UserTextKeyPressed(evt);
            }
        });

        label2.setBackground(new java.awt.Color(255, 255, 255));
        label2.setForeground(new java.awt.Color(255, 102, 51));
        label2.setText("your message:");

        sendChat.setLabel("send");
        sendChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendChatActionPerformed(evt);
            }
        });

        ChatBox.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N

        connectToServer.setLabel("connect");
        connectToServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectToServerActionPerformed(evt);
            }
        });

        warrningMessage.setBackground(new java.awt.Color(255, 255, 255));
        warrningMessage.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        warrningMessage.setForeground(new java.awt.Color(255, 0, 0));
        warrningMessage.setText("the name has to be without --- \":\" ");

        userPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clientchat/user-pic.jpg"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clientchat/user-send.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(warrningMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(userPic)
                                .addGap(150, 150, 150))))
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(UserInput, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(UserText, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(sendChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(connectToServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(ChatBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(ChatBox, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(UserText)
                        .addComponent(sendChat, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UserInput, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(connectToServer, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(userPic)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(warrningMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendChatActionPerformed
        if (!UserText.getText().equals("")) {   //�� �� ������ �� ����-���� 
            ChatClient._sendChatActionPerformed(UserText.getText());
        }
    }//GEN-LAST:event_sendChatActionPerformed

    private void UserTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UserTextKeyPressed
        //����� ���� ����� 
        if (evt.getKeyCode() == 10) {
            if (!UserText.getText().equals("")) {
                ChatClient._sendChatActionPerformed(UserText.getText());
            }
        }
    }//GEN-LAST:event_UserTextKeyPressed

    private void connectToServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectToServerActionPerformed
        _connectToServerActionPerformed();
    }//GEN-LAST:event_connectToServerActionPerformed

    private void UserInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UserInputKeyPressed
        //����� ���� ����� 
        if (evt.getKeyCode() == 10) {
            _connectToServerActionPerformed();
        }
    }//GEN-LAST:event_UserInputKeyPressed

    private void closeTheWindow(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeTheWindow
        if (!x) {
            x = true;
            ChatClient._sendChatActionPerformed("quit");
        }
    }//GEN-LAST:event_closeTheWindow

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
            java.util.logging.Logger.getLogger(NewJFrameClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrameClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrameClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrameClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrameClient().setVisible(true);
            }
        });
    }

    private void _connectToServerActionPerformed() {  //������ ������ �� ������  

        //  ����� �� �� ��������    =':'
        if (UserInput.getText().contains(":")) {
            warrningMessage.setVisible(true);
            pack();
        } else {

            
            //��� ���� ��� ������ �� �����    
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            x = false;
            
            
            ChatClient = new Client();
            ChatClient.start();//run

            //����� ����
            sendChat.setEnabled(true);
            UserText.setEnabled(true);

            userPic.setVisible(false);
            connectToServer.setVisible(false);
            UserInput.setVisible(false);
            label1.setVisible(false);
            warrningMessage.setVisible(false);

            UserText.requestFocus();

            setSize(315, 350);
        }
    }

    public class Client extends Thread {

        private static final int PORT = 9999;// ����� ��� ����� �������
        private ByteBuffer ReadBuffer;//����� ������ ���
        private ByteBuffer writeBuffer;//����� ������ ���
        private SocketChannel SChan;    //�����
        private Selector ReadSelector;// ����� ������ ����� ������ ������� ������ ������� ���� ���� ����
        private CharsetDecoder asciiDecoder;//�����//����� ��� ���� ����
        int id;//code

        public Client() {
            ReadBuffer = ByteBuffer.allocateDirect(300);// ������ ���� �� ������ ������� ������ ������ �����
            writeBuffer = ByteBuffer.allocateDirect(300);
            asciiDecoder = Charset.forName("US-ASCII").newDecoder();//�����
        }

        public void run() {
            UserName = UserInput.getText();
            Connect("DESKTOP-49VMUKQ");// ������� ���� ��������
            while (true) {
                ReadMassage();
                try {
                    Thread.sleep(30);
                } catch (InterruptedException ie) {
                }
            }
        }

        public void Connect(String hostname) {
            try {
                System.out.println("try connecting to server...   " + hostname);
                ReadSelector = Selector.open();// ����� �������
                InetAddress addr = InetAddress.getByName(hostname);// ������ ����� �� ����� ����� 
                SChan = SocketChannel.open(new InetSocketAddress(addr, PORT));//����� �����
                SChan.configureBlocking(false);//non-blocking duplex mode//it will be placed non-blocking mode ����� ���� ���� �� ����
                //����� ��������

                //register
                //���� ���� �� �� ������� ����� ������ ���� �����
                //ReadSelector
                //������� ���� ���� ���� �� ������
                //SelectionKey.OP_READ 
                //����� ������ ���� ����� ������// Operation-set bit for read operations.
                SChan.register(ReadSelector, SelectionKey.OP_READ, new StringBuffer());//����� �������

                System.out.println("success!!!!!!!!!!! connecting to server " + hostname);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void _sendChatActionPerformed(String m) { //����� ��� ��� ������  //����� ������ �� ����
            if (ChatClient != null) {
                System.out.println(m);//����
                ChatClient.SendMassage(m);//����� ������
                UserText.setText("");//����� �����
            }
        }

        //����� �����
        public void SendMassage(String messg) {
            prepareBuffer(UserName + " says: " + messg);//����� ������ ����
            channelWrite(SChan);//����� ������ ������ �� ���� ����
        }

        public void prepareBuffer(String massg) {

            writeBuffer.clear();
            //used to clear this buffer. The position is set to zero, the limit is set to the capacity, and the mark is discarded. Invoke this method before using a sequence of channel-read or put operations to fill this buffer.
            //This method does not actually erase the data in the buffer, but it is named as if it did

            writeBuffer.put(massg.getBytes());
            writeBuffer.putChar('\n');
            //���� �� ������ ����

            writeBuffer.flip();
            //used to flip this buffer. The limit is set to the current position and then the position is set to zero.
        }

        public void channelWrite(SocketChannel client) {
            long num = 0;
            long len = writeBuffer.remaining();
            //used to return the number of elements between the current position and the limit.

            while (num != len) {
                try {
                    num += SChan.write(writeBuffer);
                    //���� ����� ������ ���� ���
                    //����� ������� �� ������  ����� �����  ������ ����� �� ��� ������ �� ���� �� ��� ����  ���� ��� ���� �� ����  ����  �� ���� ����� ���� ���� ��� ������� ����� �� ��� ���� 

                    Thread.sleep(5);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (InterruptedException ex) {

                }

            }
            writeBuffer.rewind();
            //����� ��� ����� ����� �� ���� ���  ������ ����� ���� ������ ����  ���� ���� �� ���� ��� �� ������ ����� �� ���� ����
        }

        public void ReadMassage() {

            try {

                ReadSelector.selectNow();//���� ������� ���� ������ ���

                //The selected-key set is the set of keys 
                //such that each key's channel was detected to be ready for at least one of the operations identified in 
                //the key's interest set during a prior selection operation. This set is returned by the selectedKeys method. 
                //The selected-key set is always a subset of the key set.
                Set readyKeys = ReadSelector.selectedKeys();// ���� �� ��� ������
                //the selected registered keys

                Iterator i = readyKeys.iterator();

                while (i.hasNext()) {

                    SelectionKey key = (SelectionKey) i.next();
                    i.remove();
                    // The items of this table won't be cleared by selector(that means, even if we call selector.select() again, it won't clear the existing items)
                    //That's why we have to invoke iter.remove() when we got the key from selection table. If not, we will get the key again and again by selector.selectedKeys() even if it's not ready to use.

                    //Returns the channel for which this key was created.
                    SocketChannel channel = (SocketChannel) key.channel();//����� �����
                    //schan ����� ��� ��

                    ReadBuffer.clear();
                    //used to clear this buffer. The position is set to zero, the limit is set to the capacity, and the mark is discarded. Invoke this method before using a sequence of channel-read or put operations to fill this buffer.
                    //This method does not actually erase the data in the buffer, but it is named as if it did

                    //���� ��� �� ���� ����� ���� �� ���� ��� ���� �����
                    //���� ���� �� ���� ���� �� ���� ����� ���� ���� ��� ������� ��� ����� ���� �� ����
                    //����� ���� ���� ������� 
                    long nbytes = channel.read(ReadBuffer);

                    if (nbytes == -1) {// -1 �� ����� ���� �����
                        ChatBox.append("You logged out !------\n");
                        channel.close();//����� �����
                        
                        if (x) {
                            System.exit(1);// �� ������ ��� �� �����
                        }
                        x = true;
                        setDefaultCloseOperation(EXIT_ON_CLOSE);
                        UserText.setEnabled(false);
                        sendChat.setEnabled(false);
                        ChatBox.setEnabled(false);
                        stop();  //����� ����
                        
                    } else {

                        StringBuffer sb = (StringBuffer) key.attachment();//������ ���
                        //������ �� �������� ������� ����� ��

                        ReadBuffer.flip();
                        //used to flip this buffer. The limit is set to the current position and then the position is set to zero.

                        String str = asciiDecoder.decode(ReadBuffer).toString();
                        sb.append(str);
                        ReadBuffer.clear();
                        String line = sb.toString();

                        if ((line.indexOf("\n") != -1) || (line.indexOf("\r") != -1)) {
                            line = line.trim();//���� ������ ������� �����

                            if (line.startsWith("client id")) { //����� ���� ��� �� ���
                                System.out.println("##########" + line);
                                String[] words = line.split(":");
                                id = parseInt(words[1]);//����� ���� ����� ��� ��

                                ChatClient.SendMassage("user id:" + id + ":" + UserName);//����� �� ����� ����
                                ChatBox.append(" server : welcome " + UserName + "!\n Note :To exit from server write 'quit' .\n");

                            } else { //���� �� ����� ����� ���� ����
                                ChatBox.append("> " + line);
                                ChatBox.append("" + '\n');
                            }
                            sb.delete(0, sb.length());//StringBuffer ����� �
                        }
                    }
                }
            } catch (IOException ioe) {
            } catch (Exception e) {
            }
        }
    }

    
//    class ReadThread extends Thread {
//
//        public void run() {
//            ChatClient.ReadMassage();
//       }
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextArea ChatBox;
    private javax.swing.JTextField UserInput;
    private javax.swing.JTextField UserText;
    private java.awt.Button connectToServer;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Button sendChat;
    private javax.swing.JLabel userPic;
    private java.awt.Label warrningMessage;
    // End of variables declaration//GEN-END:variables
}
