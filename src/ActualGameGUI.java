/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.Color;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import java.awt.Insets;
import javax.swing.border.Border;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
/**
 *
 * @author jesper.rudegran
 */
public class ActualGameGUI extends javax.swing.JFrame {

    /**
     * Creates new form ActualGameGUI
     */

    int numberToGuess;
    int amountOfGuesses;
    long startTime;
    long elapsedTime;
    Boolean firstgame = true;
    String fileContent = "";
    int highscoreRating;

    //gör att olika tid och difficulty ger olika poäng och ranka de i highscore list efter det
    public ActualGameGUI() {

        initComponents();


    }

    public void createHighscoreFile() {

        File easyHighscore = new File("easyHighscores.txt");
        File mediumHighscore = new File("mediumHighscores.txt");
        File hardHighscore = new File("hardHighscores.txt");
        File impossibleHighscore = new File("impossibleHighscores.txt");
        try {
            easyHighscore.createNewFile();
            mediumHighscore.createNewFile();
            hardHighscore.createNewFile();
            impossibleHighscore.createNewFile();
            //highscore.createNewFile()) {

        } catch (IOException ex) {
            System.out.println("File already exists.");
        }


        File highscoredata = new File("highscoredata.txt");
        try {
            highscoredata.createNewFile();
        } catch (IOException ex) {

        }

    }
    //ArrayList<String> highScore = new ArrayList<String>();
    //ArrayList<Integer> highScoreData = new ArrayList<Integer>();
    HashMap<String, Integer> playerData = new LinkedHashMap<String, Integer>();
    /*
    public void readHighscoreData() throws FileNotFoundException {
        Scanner s = new Scanner(new File("highscoredata.txt"));
        while (s.hasNext()){
            highScoreData.add(Integer.valueOf(s.next()));
        }
    }

    public void writeHighscoreData() throws IOException {
        FileWriter myWriter = new FileWriter("highscoredata.txt");
        for (int i = 0; i < highScoreData.toArray().length ; i++){
            myWriter.write(highScoreData.get(i));
            myWriter.close();
        }
    }


    public void readHighscore() throws FileNotFoundException {
        Scanner s = new Scanner(new File("highscoredata.txt"));
        while (s.hasNext()){
            highScore.add((s.next()));
        }
        // INTE HUNNIT TESTA "N KAN VARA FEL MED METODEN
    }
    public void writeHighscore(){
        String hst = "";
        for (int i = 0; i < highScore.toArray().length ; i++){
            hst += String.valueOf(highScore.get(i)) + "\n";
            //jTextArea2.setText(hst + String.valueOf(highScore.get(i)) + "\n");
        }
        jTextArea2.setText(hst);
    }
     *///metoder som användes när jag inte använde mig av en hashmap
    //skriver ut hashmapens key
    public void printHashMapKeySet(){
        for (String i : playerData.keySet()) {
            System.out.println("key: " + i);
        }
    }
    //skriver ut hashmapens value
    public void printHashMapValue(){
        for (String i : playerData.keySet()) {
            System.out.println("value: " + playerData.get(i));
        }
    }
    public void writeHighscoreData() throws IOException {
        FileWriter myWriter = new FileWriter(filePath);

        myWriter.write(jTextArea2.getText());
        myWriter.close();

    }
    /*Metoden använder BufferedReader för att läsa highscore-filen rad för rad. För varje rad använder
    * den split metoden på första förekomsten av ":" och om det inte finns ignoreras raden.
    * På detta sätt får jag in det från textfilen och sätter tillbaks det i hashmapen playerData
    * för att vi sedan har datan där för sortering. */
    String filePath;
    public void filePath(String dif){
        switch (dif) {
            case "easy" -> filePath = "easyHighscores.txt";
            case "medium" -> filePath = "mediumHighscores.txt";
            case "hard" ->  filePath = "hardHighscores.txt";
            case "IMPOSSIBLE" -> filePath = "impossibleHighscores.txt";
        }
    }
    public void readHashMap() throws IOException {



        String line;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null)
        {
            String[] parts = line.split(":", 2);
            if (parts.length >= 2)
            {
                String key = parts[0];
                String value = parts[1];
                playerData.put(key, Integer.valueOf(value));
            } else {
                System.out.println("ignoring line: " + line);
            }
        }
/*        String outputText = "";
        for (String key : playerData.keySet())
        {
            System.out.println(key + ":" + playerData.get(key));
            outputText += key + ":" + playerData.get(key) + "\n";
        }
        jTextArea2.setText(outputText);
        reader.close();*/
    }

    /* Jag sorterar hashmappen genom att g;ra en ny map d'r jag sorterar det dess value som 'r en int och g;r det till en linked hash map*/
    Map<String, Integer> sortedMap;
    //Map<String, Integer> sortedMap;
    public void sortHashMap(){
        sortedMap = playerData.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));
        String outputText = "";
        for (String key : sortedMap.keySet())
        {
            System.out.println(key + ":" + sortedMap.get(key));
            outputText += key + ":" + sortedMap.get(key) + "\n";
        }
        jTextArea2.setText(outputText);

    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        guessBtn = new javax.swing.JButton();
        guessAmount = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        guessAmountLabel = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        guessingInput = new javax.swing.JSpinner();
        feedbackArea = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        difficultyLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Make your guess below");

        jButton1.setText("New Difficulty");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Feedback:");

        guessBtn.setText("Guess");
        guessBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessBtnActionPerformed(evt);
            }
        });

        guessAmount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        guessAmount.setForeground(new java.awt.Color(255, 255, 255));
        guessAmount.setText("Guess amount:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Highscores");

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(71, 71, 71));
        jTextArea2.setColumns(20);
        jTextArea2.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea2.setRows(5);
        jTextArea2.setToolTipText("");
        jTextArea2.setFocusable(false);
        jTextArea2.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(jTextArea2);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Difficulty:");

        guessAmountLabel.setForeground(new java.awt.Color(255, 255, 255));
        guessAmountLabel.setText("guessamount");

        jButton2.setText("New Game");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        feedbackArea.setEditable(false);
        feedbackArea.setBackground(new java.awt.Color(51, 51, 51));
        feedbackArea.setForeground(new java.awt.Color(255, 255, 255));
        feedbackArea.setText(" ");
        feedbackArea.setBorder(null);
        feedbackArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feedbackAreaActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name | Time | Guesses");

        difficultyLabel.setForeground(new java.awt.Color(255, 255, 255));
        difficultyLabel.setText("jLabel5");

        jPanel4.setBackground(new java.awt.Color(153, 255, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Elapsed Time:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(feedbackArea, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(guessBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(guessAmount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(guessAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(difficultyLabel))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jLabel6)))
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(395, 395, 395))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(guessingInput, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guessBtn)
                    .addComponent(guessingInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(feedbackArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guessAmount)
                    .addComponent(guessAmountLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(difficultyLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void feedbackAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feedbackAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_feedbackAreaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        amountOfGuesses = 0;
        guessAmountLabel.setText("0");
        Random random = new Random();
        if(difficultyLabel.getText() == "easy"){
            numberToGuess = random.nextInt(1,2);
        } else if(difficultyLabel.getText() == "medium"){
            numberToGuess = random.nextInt(1,101);

        } else if(difficultyLabel.getText() == "hard"){
            numberToGuess = random.nextInt(1,1001);
        } else if(difficultyLabel.getText() == "IMPOSSIBLE"){
            numberToGuess = random.nextInt(1,10001);
        }
        feedbackArea.setText("Good luck!");
        startTime = System.currentTimeMillis();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void guessBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guessBtnActionPerformed
        int inputValue = (int) guessingInput.getValue();
        if (inputValue > numberToGuess){
            feedbackArea.setText("You are too high!");
            amountOfGuesses += 1;
            guessAmountLabel.setText(Integer.toString(amountOfGuesses));
        }else if(inputValue < numberToGuess){
            feedbackArea.setText("You are too low!");
            amountOfGuesses += 1;
            guessAmountLabel.setText(Integer.toString(amountOfGuesses));
        }else{
            
            elapsedTime = ((System.currentTimeMillis() - startTime)/1000)%60;

            feedbackArea.setText("You are correct! Congratulations");
            String name = JOptionPane.showInputDialog(this, "Enter your name:");
            amountOfGuesses += 1;
            guessAmountLabel.setText(Integer.toString(amountOfGuesses));
            
            
            //String[] outpt = data.split("\\|");
            // do a highscore data file and read in values here

            //readHighscore();
            //highScore.add(amountOfGuesses + name.getText());
            //System.out.println(highScoreData);
            //highScoreData.add(amountOfGuesses);
            //System.out.println(highScoreData);
            //System.out.println("hashmap" + playerData);
            playerData.put(name + " | "+elapsedTime + "s" + " | Guesses", amountOfGuesses);
            //readHashMap();
            sortHashMap();
            try {
                writeHighscoreData();
            } catch (IOException ex) {
                Logger.getLogger(ActualGameGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            //writeHighscoreData();
            printHashMapValue();
            printHashMapKeySet();
            System.out.println(sortedMap.getClass());
            //sortHashMap();
            //writeHighscoreData(); fixa denna s[ den skirver t fil korrekt
            //writeHighscore();

            //System.out.println(highScore);
            //for (int i = 0; i < highScore.toArray().length ; i++)
            //    jTextArea2.setText(data + i);
            // System.out.println(highScore.get(i));

            //System.out.println(Arrays.toString(outpt));
            //jTextArea2.setText("");
            //readFile("highscores.txt");
            //jTextArea2.setText(data + "nytt highscore");

            /*FileWriter myWriter;
            String outputtext = "";
            try {
                ArrayList<String> highscore = new ArrayList<>();
                highscore.add(amountOfGuesses + name.getText());
                //fileContent += name.getText() + " | " + amountOfGuesses +"\n";
                myWriter = new FileWriter("highscores.txt");
                Scanner scan = new Scanner("highscores.txt");
                for (String str : highscore) {
                    fileContent += str + "\n" ;
                }
                System.out.println(fileContent);
                myWriter.write(fileContent);
                myWriter.close();
                readFile("highscores.txt");
            } catch (IOException ex) {
                Logger.getLogger(ActualGameGUI.class.getName()).log(Level.SEVERE, null, ex);
            }*/

            //sätt highscore
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_guessBtnActionPerformed
    Boolean generateNumber = false;
    public void generateNumber(){
        
        
        
    }
    String data = "";
    public void readFile(String fileName){
        //data = "";
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                data += myReader.nextLine() + "\n";
                //System.out.println(data);
            }
            jTextArea2.setText(data);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
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
            java.util.logging.Logger.getLogger(ActualGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActualGameGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel difficultyLabel;
    public javax.swing.JTextField feedbackArea;
    private javax.swing.JLabel guessAmount;
    private javax.swing.JLabel guessAmountLabel;
    private javax.swing.JButton guessBtn;
    private javax.swing.JSpinner guessingInput;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
