/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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

        File highscore = new File("highscores.txt");

        try {
            highscore.createNewFile();
            //highscore.createNewFile()) {

        } catch (IOException ex) {

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
        FileWriter myWriter = new FileWriter("highscores.txt");

        myWriter.write(jTextArea2.getText());
        myWriter.close();

    }
    /*Metoden använder BufferedReader för att läsa highscore-filen rad för rad. För varje rad använder
    * den split metoden på första förekomsten av ":" och om det inte finns ignoreras raden.
    * På detta sätt får jag in det från textfilen och sätter tillbaks det i hashmapen playerData
    * för att vi sedan har datan där för sortering. */
    public void readHashMap() throws IOException {
        String filePath = "highscores.txt";
        String line;
        BufferedReader reader = new BufferedReader(new FileReader("highscores.txt"));
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        guessingInput = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        guessBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        feedbackArea = new javax.swing.JTextArea();
        guessAmount = new javax.swing.JLabel();
        highscore = new javax.swing.JLabel();
        difficultyLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        guessAmountLabel = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        highscoreLabel = new javax.swing.JLabel();
        name = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Make your guess below");

        guessingInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessingInputActionPerformed(evt);
            }
        });

        jButton1.setText("Give up");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Feedback:");

        guessBtn.setText("Guess");
        guessBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    guessBtnActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        feedbackArea.setColumns(20);
        feedbackArea.setRows(5);
        jScrollPane2.setViewportView(feedbackArea);

        guessAmount.setForeground(new java.awt.Color(255, 255, 255));
        guessAmount.setText("Guess amount:");

        highscore.setForeground(new java.awt.Color(255, 255, 255));
        highscore.setText("Highscore:");

        difficultyLabel.setForeground(new java.awt.Color(255, 255, 255));
        difficultyLabel.setText("   ");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Highscores:");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane1.setViewportView(jTextArea2);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Difficulty:");

        guessAmountLabel.setForeground(new java.awt.Color(255, 255, 255));
        guessAmountLabel.setText(" ");

        jButton2.setText("New Game");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("New Difficulty");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        highscoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        highscoreLabel.setText("0");

        name.setText("Enter name here");
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(guessAmount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(guessAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(highscore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(highscoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(guessingInput))
                            .addGap(12, 12, 12)
                            .addComponent(guessBtn))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(difficultyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(guessingInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(guessBtn))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(guessAmount)
                            .addComponent(guessAmountLabel)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(highscore)
                            .addComponent(highscoreLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(difficultyLabel)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(31, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    Boolean generateNumber = false;
    public void generateNumber(){
        
        
        
    }
    String data = "";
    public void readFile(String fileName){
        //data = "";
        try {
            File myObj = new File("highscores.txt");
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
    private void guessingInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guessingInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guessingInputActionPerformed

    private void guessBtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_guessBtnActionPerformed

            if (Integer.parseInt(guessingInput.getText()) > numberToGuess){
                feedbackArea.setText("You are too high!");
                amountOfGuesses += 1;
                guessAmountLabel.setText(Integer.toString(amountOfGuesses));
            }else if(Integer.parseInt(guessingInput.getText()) < numberToGuess){
                feedbackArea.setText("You are too low!");
                amountOfGuesses += 1;
                guessAmountLabel.setText(Integer.toString(amountOfGuesses));
            }else{

                elapsedTime = ((System.currentTimeMillis() - startTime)/1000)%60;
                feedbackArea.setText("You are correct! Congratulations");
                amountOfGuesses += 1;
                guessAmountLabel.setText(Integer.toString(amountOfGuesses));
                if(firstgame){
                    highscoreLabel.setText(Integer.toString(amountOfGuesses));
                    firstgame = false;
                }
                if(amountOfGuesses < Integer.parseInt(highscoreLabel.getText())){
                    highscoreLabel.setText(Integer.toString(amountOfGuesses));
                }
                //String[] outpt = data.split("\\|");
                // do a highscore data file and read in values here

                //readHighscore();
                //highScore.add(amountOfGuesses + name.getText());
                //System.out.println(highScoreData);
                //highScoreData.add(amountOfGuesses);
                //System.out.println(highScoreData);
                //System.out.println("hashmap" + playerData);
                playerData.put(name.getText() + " | "+elapsedTime + "s" + " | Guesses", amountOfGuesses);
                //readHashMap();
                sortHashMap();
                writeHighscoreData();
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

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
    private javax.swing.JTextArea feedbackArea;
    private javax.swing.JLabel guessAmount;
    private javax.swing.JLabel guessAmountLabel;
    private javax.swing.JButton guessBtn;
    private javax.swing.JTextField guessingInput;
    private javax.swing.JLabel highscore;
    private javax.swing.JLabel highscoreLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField name;
    // End of variables declaration//GEN-END:variables
}
