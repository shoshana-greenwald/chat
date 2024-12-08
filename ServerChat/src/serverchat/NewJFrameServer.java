/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//https://www.geeksforgeeks.org/java-nio-bytebuffer-class-in-java/
//https://www.javacodegeeks.com/
//קישורים על החומר
package serverchat;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author user1
 */
public class NewJFrameServer extends javax.swing.JFrame {

    private server ChatServer;//מופע לשרת
    private InetAddress ServerAddress;//כתובת השרת

    public NewJFrameServer() {
        initComponents();
        setTitle("Server");
        setSize(440, 350);
        setResizable(false);//לא ניתן לשנות גודל
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //מיקום בצד ימין למעלה
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - getWidth();
        int y = 0;
        setLocation(x, y);
        setVisible(true);

        ChatServer = new server();
        ChatServer.start();//run
        //readמאזין ל
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        textField1 = new java.awt.TextField();
        jTextField1 = new javax.swing.JTextField();
        popupMenu1 = new java.awt.PopupMenu();
        label1 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        button2 = new java.awt.Button();
        sendBtn = new java.awt.Button();
        ChatBox = new java.awt.TextArea();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        ServerText = new javax.swing.JTextField();

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        textField1.setText("textField1");

        popupMenu1.setLabel("popupMenu1");

        label1.setText("label1");
        label1.getAccessibleContext().setAccessibleName("server history");

        jLabel1.setText("server history");

        jLabel2.setText("chat box");

        button2.setLabel("button2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sendBtn.setLabel("send");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        ChatBox.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N

        label2.setText("chat box");

        label3.setText("server history");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ChatBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ServerText, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChatBox, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(ServerText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed
        ChatServer.SendMassage("  <<Server>>: " + ServerText.getText());//עובר על כל הקליינט ושולח
        ChatBox.append("  <<Server>>: " + ServerText.getText() + '\n');
        ServerText.setText("");
    }//GEN-LAST:event_sendBtnActionPerformed
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(NewJFrameServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrameServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrameServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrameServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrameServer().setVisible(true);
            }
        });
    }

    public class server extends Thread {

        private static final int PORT = 9999;
        private ArrayList<SocketChannel> Clients;//להגדרת לקוחות שיתחברו אליו
        int countClient = 0; // מספר לקוחות
        ArrayList<String> clientsNames;// שמןת הלקוחות
        private ByteBuffer ReadBuffer;  //   כ לחוצק/ק
        private ByteBuffer WriteBuffer;//
        public ServerSocketChannel SSChan;//מאזין//a channel that can listen for incoming TCP connections
        private Selector ReaderSelector;    //רושם מודיע ק/כ
        private CharsetDecoder asciiDecoder;//להפוך ביט לקוד אסקי

        public server() {
            Clients = new ArrayList<SocketChannel>();
            clientsNames = new ArrayList<String>();

            //This method allocates a new direct byte buffer.
            ReadBuffer = ByteBuffer.allocateDirect(300);
            WriteBuffer = ByteBuffer.allocateDirect(300);
            asciiDecoder = Charset.forName("US-ASCII").newDecoder();
        }

        public void InitServer() {
            try {
                SSChan = ServerSocketChannel.open();//Open method is used to open a socket channel for no specified address
                SSChan.configureBlocking(false);//אפשור מקביליות
                ServerAddress = InetAddress.getLocalHost();//It returns the instance of the local host.
                System.out.println(ServerAddress.toString());
                SSChan.socket().bind(new InetSocketAddress(ServerAddress, PORT));
                //socket() ? This method get back a server socket connected with this channel.
                //bind(SocketAddress local) ? This method is used to hold together the socket channel to the local address  
                //which is provided as the parameter to this method.
                ReaderSelector = Selector.open();// יצירת הסלקטור
                ChatBox.setText(ServerAddress.getHostName() + "<Server> Started. \n"); // הדפסה אל עצמו
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        public void run() {
            InitServer();// //איתחול הערוץ והסלקטור
            while (true) {
                acceptNewConnection();//התחברות והוספת לקוחות
                try {
                    ReadMassage();
                } catch (InterruptedException ex) {
                    Logger.getLogger(NewJFrameServer.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

            }
        }

        public void acceptNewConnection() {// פונקציה המאזינה למשתתפים חדשים
            //תפוס את הבקשה הנכנסת וצור לה חיבור
            SocketChannel newClient;
            try {

                while ((newClient = SSChan.accept()) != null) {
                    //accept() ? This method is used to accepts a connection made to this channel’s socket.

                    ChatServer.addClient(newClient);

                    //שליחת מספר לקליינט
                    SendMassage(newClient, "client id :" + countClient);
                    countClient++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        //ברגע שמשתמש מתחבר אחרי שליחת קוד ושם הוא מגיע לפונקציה הזאת
        public void loginClient(SocketChannel newClient, String clientName, int clientID) {
            //הודעה לכולם שהלקוח הספציפי התחבר
            sendBroadcastMessage(newClient, "Connecting... : " + clientName);
            ChatBox.append("Login number: " + clientID + " , client's name : " + clientName + "    IP: " + newClient.socket().getInetAddress() + "\n");
        }

        // כשהשרת זיהה קליינט חדש
        public void addClient(SocketChannel newClient) {
            synchronized (Clients) {
                Clients.add(newClient);//הכנסה למערך הקליינטים
                try {
                    newClient.configureBlocking(false);//אפשרת המקביליות

                    //register
                    //רושם ערוץ זה עם הסלקטור הנתון ומחזיר מפתח בחירה
                    //ReadSelector
                    //הסלקטור איתו אמור ערוץ זה להירשם
                    //SelectionKey.OP_READ 
                    //הסדרה שנקבעה עבור המפתח המתקבל// Operation-set bit for read operations.
                    newClient.register(ReaderSelector, SelectionKey.OP_READ, new StringBuffer());//הרשמה לסלקטור

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        //שליחת ההודעה ללקוח ספציפי
        public void SendMassage(SocketChannel client, String messg) {
            prepareBuffer(messg);//שליחת ההודעה לפבר
            channelWrite(client);//שליחת ההודעה מהערוץ של הבפר ללקוח
        }

        //שליחת הודעה לכולם
        public void SendMassage(String massg) {
            synchronized (Clients) {
                if (Clients.size() > 0) {
                    for (int i = 0; i < Clients.size(); i++) {
                        if (Clients.get(i) == null) {
                            continue;
                        }

                        SocketChannel client = (SocketChannel) Clients.get(i);//SocketChannel- בפונקציית הוספת לקוחות קיבלתי לקוחות מסוג
                        SendMassage(client, massg);//שליחת ההודעה ללקוח ספציפי
                    }
                }
            }
        }

        public void prepareBuffer(String massg) {
            WriteBuffer.clear();
            //used to clear this buffer. The position is set to zero, the limit is set to the capacity, and the mark is discarded. Invoke this method before using a sequence of channel-read or put operations to fill this buffer.
            //This method does not actually erase the data in the buffer, but it is named as if it did

            WriteBuffer.put(massg.getBytes());
            WriteBuffer.putChar('\n');
            //שולח את ההודעה לבפר

            WriteBuffer.flip();//הזזת המצביע לתחילת הקובץ
        }

        public void channelWrite(SocketChannel client) {//מקבל ערוץ ללקוח

            long num = 0;
            long len = WriteBuffer.remaining();
            //used to return the number of elements between the current position and the limit.

            while (num != len) {
                try {
                    num += client.write(WriteBuffer);
                    //מספר הבתים שנכתבו אולי אפס
                    //סוגים מסוימים של ערוצים  בהתאם למצבם  עשויים לכתוב רק חלק מהבתים או אולי אף אחד בכלל  ערוץ שקע במצב לא חוסם  למשל  לא יכול לכתוב יותר בתים ממה שפנויים בערוץ של בפר הפלט 

                    Thread.sleep(5);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (InterruptedException ex) {

                }
            }
            WriteBuffer.rewind();
            //משמשת כדי להריץ אחורה את הבפר הזה  המיקום מוגדר לאפס והסימן נמחק  הפעל שיטה זו לפני רצף של פעולות כתיבה או קבלת ערוץ
        }

        // שליחת הודעה מלקוח ספציפי
        public void sendBroadcastMessage(SocketChannel client, String mesg) {//הלקוח ששלח + הודעה 
            String[] words = mesg.split("says:");
            if (words.length != 1 || mesg.startsWith("Connecting") || mesg.startsWith("Logout")) {
                prepareBuffer(mesg);//שליחת ההודעה לפבר
                for (int i = 0; i < Clients.size(); i++) {
                    if (Clients.get(i) == null) {

                        continue;
                    }
                    SocketChannel channel = (SocketChannel) Clients.get(i);
                    if (channel != client) //שולח הודעות לכולם חוץ מלמי ששלח עצמו
                    {
                        channelWrite(channel);//שליחת ההודעה מהערוץ של הבפר ללקוח  
                    }
                }
            }
            //מי ששלח את ההודעה בעצמו
            if (!mesg.startsWith("Connecting") && !mesg.startsWith("Logout")) {
                SendMassage(client, "> > > I say: " + words[1]);
            }

        }

        //מחיקת קליינט
        public void removeClient(SocketChannel client) throws IOException {
            //שמירה על סינכרון המערך שלא ישלחו הודעות עד שאני מוחקת אותו
            synchronized (Clients) {
                int index = Clients.indexOf(client);
                ChatBox.append("Logout: " + clientsNames.get(index));
                ChatBox.append("" + '\n');
                Clients.set(index, null);//מחיקה מהרשימה

                //הודעה לכולם
                sendBroadcastMessage(client, "Logout: " + clientsNames.get(index));

                client.close();//סגירת הערוץ עם הלקוח

            }

        }

        //קריאת הודעות מהלקוחות
        public void ReadMassage() throws InterruptedException {
            try {

                ReaderSelector.selectNow();//עושה סינכרון לוקח קליינט אחד

                //The selected-key set is the set of keys 
                //such that each key's channel was detected to be ready for at least one of the operations identified in 
                //the key's interest set during a prior selection operation. This set is returned by the selectedKeys method. 
                //The selected-key set is always a subset of the key set.
                Set readkeys = ReaderSelector.selectedKeys();// תפוס על ידי קליינט

                Iterator iter = readkeys.iterator();
                while (iter.hasNext()) {
                    SelectionKey key = (SelectionKey) iter.next();
                    iter.remove();
                    // The items of this table won't be cleared by selector(that means, even if we call selector.select() again, it won't clear the existing items)
                    //That's why we have to invoke iter.remove() when we got the key from selection table. If not, we will get the key again and again by selector.selectedKeys() even if it's not ready to use.

                    //Returns the channel for which this key was created.
                    SocketChannel client = (SocketChannel) key.channel();//חיבור לסרבר

                    //used to clear this buffer. The position is set to zero, the limit is set to the capacity, and the mark is discarded. Invoke this method before using a sequence of channel-read or put operations to fill this buffer.
                    //This method does not actually erase the data in the buffer, but it is named as if it did
                    ReadBuffer.clear();

                    //קורא רצף של בתים מערוץ צאנל זה לתוך בפר הפלט הנתון
                    //ערוץ במצב לא חוסם למשל לא יכול לקרוא יותר בתים ממה שזמינים מיד מערוץ הקלט של הבפר
                    //מחזיר מספר בתים שניקראו 
                    long num = client.read(ReadBuffer);

                    if (num == -1) {// -1 אם הערוץ נסגר מחזיר

                        client.close();//סגירת הערוץ עם הלקוח

                        Clients.remove(client);//מחיקה מהרשימה

                        //הועה לכולם על ההתנתקות
                        sendBroadcastMessage(client, "logout: " + client.socket().getInetAddress());

                    } else {

                        StringBuffer str = (StringBuffer) key.attachment();
                        //מחזירה את ההתקשרות הנוכחית למפתח זה

                        ReadBuffer.flip();//היפוך למצב כתיבה//הזזת המצביע לתחילת הקובץ
                        String data = asciiDecoder.decode(ReadBuffer).toString();
                        ReadBuffer.clear();

                        str.append(data);

                        String line = str.toString();
                        if ((line.indexOf("\n") != -1) || (line.indexOf("\r") != -1)) {
                            line = line.trim();//מבטל רווחים מההתחלה והסוף
                            System.out.println(line);

                            if (line.endsWith("quit")) {
                                removeClient(client);
                            } else {
                                //מבוטל
                                //ChatBox.append(client.socket().getInetAddress() + ": " + line);

                                if (line.contains("user id")) { // קבלת שמו של הלקוח
                                    String[] words = line.split(":");
                                    int clientId = parseInt(words[2]);
                                    String clientName = words[3];
                                    clientsNames.add(clientId, clientName);
                                    //הודעה לכל הלקוחות שיש לקוח חדש
                                    loginClient(Clients.get(clientId), clientName, clientId);

                                } else {
                                    //שליחת הודעה מלקוח 
                                    sendBroadcastMessage(client, line);
                                    ChatBox.append(line);
                                    ChatBox.append("" + '\n');
                                }

                            }
                            str.delete(0, str.length());//StringBuffer ריקון ה

                        }
                    }
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextArea ChatBox;
    private javax.swing.JTextField ServerText;
    private java.awt.Button button2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.PopupMenu popupMenu1;
    private java.awt.Button sendBtn;
    private java.awt.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
