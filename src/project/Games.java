package project;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;



public class Games{
    JFrame window;
    Container con;
    JPanel titleNamePanel,mainTextPanel,choiceButtonPanel;
    JLabel titleNameLabel,InsaneLabel,InsaneLabelnumber,itemLabel,itemLabelname,Earai,picLabel,Earai3,Earai4,Earai5,Earai6;
    JPanel startButtonPanel,playerPanel,picPanel;
    JButton startButton,choice1,choice2,choice3,choice4;
    JTextArea mainTextArea;
    int playerInsane,frontkey,invenkey,scene,shot,scene2,scene3,check,check2,code,kang;
    String item,position;
    File ni = new File("Onijang.wav");
    File knock = new File("KnockLong.wav");
    File grab = new File("ggg.wav");
    File drop = new File("Drop.wav");
    File wat = new File("Window.wav");
    File opendoor = new File("opendoor.wav");
    File lighton = new File("Lighton.wav");
    File Knock = new File("Knock.wav");
    File Win = new File("Winsound.wav");
    File Jump = new File("Jumpsound.wav");
    
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 45);
    Font normalFont = new Font("Times New Roman",Font.PLAIN,28);
                               //customize the font
    
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();
    
    public static void main(String[] args) {
        new Games();
    }
    public Games(){
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setTitle("There are something behind me!");
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();
        
        
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,100,600,90);
                                 //x  //y //width //height
        titleNamePanel.setBackground(Color.black);
        titleNameLabel= new JLabel("There are something Behind me!");
                            //Type Title
        titleNameLabel.setFont(titleFont);
         //show
        titleNameLabel.setForeground(Color.red);
                            //color of the text
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300,350,200,100);
        startButtonPanel.setBackground(Color.black);
        
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.red);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        //when you click start button will call tsHandler class
        startButton.setFocusPainted(false);
        
        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        con.add(titleNamePanel);
        con.add(startButtonPanel);
    }
    public void createGameScreen(){
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        
        mainTextPanel=new JPanel();
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);
        

        mainTextArea = new JTextArea("This is the main text are.");
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setEditable(false);
        //setLinewrap enter automatically
        mainTextPanel.add(mainTextArea);
        
        
        picPanel = new JPanel();
        picPanel.setBounds(570,375,200,100);
        picPanel.setBackground(Color.white);
        con.add(picPanel);
        Icon earai2 = new ImageIcon(this.getClass().getResource("bare.jpg"));
        picLabel=new JLabel(earai2);
        picLabel.setFont(normalFont);
        picLabel.setForeground(Color.black);
        picPanel.add(picLabel);
        
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250,350,300,150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);
        
        
        choice1 = new JButton("choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        
        choice2 = new JButton("choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        
        choice3 = new JButton("choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        
        choice4 = new JButton("choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);
        
        playerPanel = new JPanel();
        playerPanel.setBounds(100,30,600,50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);
        
        InsaneLabel=new JLabel("Insanity: ");
        InsaneLabel.setFont(normalFont);
        InsaneLabel.setForeground(Color.white);
        playerPanel.add(InsaneLabel);
        
        InsaneLabelnumber = new JLabel();
        InsaneLabelnumber.setFont(normalFont);
        InsaneLabelnumber.setForeground(Color.white);
        playerPanel.add(InsaneLabelnumber);
        
        itemLabel = new JLabel("Item: ");
        itemLabel.setFont(normalFont);
        itemLabel.setForeground(Color.white);
        playerPanel.add(itemLabel);
        
        itemLabelname = new JLabel();
        itemLabelname.setFont(normalFont);
        itemLabelname.setForeground(Color.white);
        playerPanel.add(itemLabelname);
        
        
      
        playerSetup();
    }

    public void playerSetup(){
        playerInsane=15;
        item = "Bare hand";
        //put to itemlabelname
        itemLabelname.setText(item);
        InsaneLabelnumber.setText("" + playerInsane);
        
        startup();
    }
    public void startup(){
        position = "On the bed";
        mainTextArea.setText("You eyes up on the bed you didn't see anything. \n\nWhat do you do?");
        choice1.setText("Walk to switch on light");
        choice2.setText("Get the flashlight");
        choice3.setText("Continue sleeping");
        choice4.setText("");
        
    }
    public void step2(){
        position = "Do something";
        mainTextArea.setText("It too dark we need somelight!!!.\n(you lost 3 insanity please save that point)");
        playerInsane = playerInsane - 3;
        InsaneLabelnumber.setText("" + playerInsane);
        choice1.setText("Go back to get light.");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void Getthelight(){
        position = "Light";
        mainTextArea.setText("Ok gonna be here! (You receive flashlight)");
        item = "Flashlight";
        itemLabelname.setText(item);
        choice1.setText("Open it!");
        choice2.setText("Drop the flashlight");
        choice3.setText("");
        choice4.setText("");
        
        picPanel = new JPanel();
        picPanel.setBounds(570,375,200,100);
        picPanel.setBackground(Color.white);
        con.add(picPanel);
        Icon earai2 = new ImageIcon(this.getClass().getResource("d.jpg"));
        picLabel=new JLabel(earai2);
        picLabel.setFont(normalFont);
        picLabel.setForeground(Color.black);
        picPanel.add(picLabel);
        
    }
    public void Openlight(){
        position = "Openlight";
        mainTextArea.setText("You are at center of a bed room, What do you do?");
        choice1.setText("Open the window");
        choice2.setText("Look back to the bed");
        choice3.setText("Check under the bed");
        choice4.setText("");
    }
   public void Dontsleep(){
       position = "Dontsleep";
       mainTextArea.setText("You can't sleep anymore cause something have \nwatching you");
       choice1.setText("Get the flashlight.");
       choice2.setText("");
       choice3.setText("");
       choice4.setText("");
   }
   public void Dropflash(){
       position = "Dropflash";
       mainTextArea.setText("You drop the flashlight on the ground\n(lost 3 insanity point.)");
       item = "Bare Hand";
       itemLabelname.setText(item);
       playerInsane = playerInsane - 3;
       InsaneLabelnumber.setText("" + playerInsane);
       choice1.setText("Get the flashlight.");
       choice2.setText("Ignore flashlight.");
       choice3.setText("");
       choice4.setText("");
       picPanel = new JPanel();
       picPanel.setBounds(570,375,200,100);
       picPanel.setBackground(Color.white);
       con.add(picPanel);
       Icon earai2 = new ImageIcon(this.getClass().getResource("bare.jpg"));
       picLabel=new JLabel(earai2);
       picLabel.setFont(normalFont);
       picLabel.setForeground(Color.black);
       picPanel.add(picLabel);
       
   }
  public void Openwindow(){
      position = "Openwindow";
      mainTextArea.setText("You open a window nothing you can see.");
      choice1.setText("Go back to the center.");
      choice2.setText("");
      choice3.setText("");
      choice4.setText("");
  }
   public void Lookbed(){
      position = "Lookbed";
      mainTextArea.setText("You look behind and nothing that.");
      choice1.setText("Go back to the center.");
      choice2.setText("");
      choice3.setText("");
      choice4.setText("");
  }
   public void Underbed(){
      position = "Underbed";
      mainTextArea.setText("You try to look at under the bed,Nothing there.");
      choice1.setText("Go back to the center.");
      choice2.setText("");
      choice3.setText("");
      choice4.setText("");
  }
     public void jumpone(){
      position = "jumpone";
      mainTextArea.setText("Knock Knock Knock ,someone knock your door!!!");
      choice1.setText("Open the door.");
      choice2.setText("Ignore it.");
      choice3.setText("Try to quiet.");
      choice4.setText("");
  }
    public void Opendoor(){
     position ="Opendoor";
     mainTextArea.setText("You see a woman standing with her back to you.\n\nNew Objective:Leave the house");
     choice1.setText("Close door!!!");
     choice2.setText("Talk to her");
     choice3.setText("Walk to 1st floor");
     choice4.setText("Pour light to woman");
}
    public void Ignore(){
     position ="Ignore";
     mainTextArea.setText("You ignore the sound but the sound didn't stop.\n\nNew Objective:Leave the house");
     choice1.setText("Open the door.");
     choice2.setText("Try to quiet.");
     choice3.setText("");
     choice4.setText("");
    }
    public void Quiet(){
      position = "Quiet";
      mainTextArea.setText("The sound it kinda stop.\n\nObjective:Leave the house");
      choice1.setText("Open the door.");
      choice2.setText("");
      choice3.setText("");
      choice4.setText("");
    }
    public void Goodend(){
         position = "win";
         mainTextArea.setText("You survive from that house and walk to forest.");
     }
    public void lose(){
        position = "lose";
        mainTextArea.setText("                    You are dead! GAME OVER");
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
        itemLabelname.setVisible(false);
        InsaneLabel.setVisible(false);
        Icon ego = new ImageIcon(this.getClass().getResource("Jump.gif"));
        Earai = new JLabel(ego);
        mainTextPanel.setBounds(0,0 ,800,600);
        mainTextPanel.add(Earai);
        window.getContentPane().add(mainTextPanel);
     }
     public void playerscare(){
         position = "playerscare";
         int playerDamage = 0;
         if(item.equals("Flashlight")){
             playerDamage = new java.util.Random().nextInt(0);
         }
         else if(item.equals("Bare Hand")){
             playerDamage= new java.util.Random().nextInt(5);
         }
        mainTextArea.setText("If you don't have light you lost " + playerDamage + " Insanity\n(The point will random lost)");
        playerInsane = playerInsane - playerDamage;
        InsaneLabelnumber.setText("" + playerInsane);
        choice1.setText("Get the flashlight.");
        choice2.setText("Ignore the flashlight.");
        choice3.setText("");
        choice4.setText("");
     }
     public void IgnoreFlash(){
        position = "IgnoreFlash";
        mainTextArea.setText("You ignore the flashlight (lost 3 insanity point.)");
        item = "Bare Hand";
        itemLabelname.setText(item);
        playerInsane = playerInsane - 3;
        InsaneLabelnumber.setText("" + playerInsane);
        choice1.setText("Get the flashlight.");
        choice2.setText("Ignore flashlight.");
        choice3.setText("");
        choice4.setText("");
     }
     public void Closedoor(){
         position = "closedoor";
         mainTextArea.setText("You get back to the room.We need to escape now!!!");
         choice1.setText("Open the door.");
         choice2.setText("");
         choice3.setText("");
         choice4.setText("");
     }
     public void Talktoher(){
         position = "Talktoher";
         mainTextArea.setText("Hello!\nShe was disappear,What happening!!!");
         choice1.setText("Walk to 1st floor");
         choice2.setText("");
         choice3.setText("");
         choice4.setText("");
     }
     public void Safeone(){
         position = "Safeone";
         mainTextArea.setText("She was disappear,What happening!!!");
         choice1.setText("Walk to 1st floor.");
         choice2.setText("");
         choice3.setText("");
         choice4.setText("");
     }
     public void walk(){
         position = "walk";
         mainTextArea.setText("She slowly turned her hed to you.Scream!!!\n(You lost 5 insanity point)");
         playerInsane = playerInsane - 5;
        InsaneLabelnumber.setText("" + playerInsane);
         choice1.setText("Run!!!");
         choice2.setText("");
         choice3.setText("");
         choice4.setText("");
     }
     public void Pour(){
         position = "pour";
         mainTextArea.setText("Scream sound!!!");
         choice1.setText("Run!!!");
         choice2.setText("");
         choice3.setText("");
         choice4.setText("");
     }
     public void firstfloor(){
         position = "firstfloor";
         mainTextArea.setText("You are at 1st floor but the front door is locked\n\nNew Objective:Find the front door key");
         choice1.setText("Check the living room.");
         choice2.setText("Check the bathroom.");
         choice3.setText("Check the office.");
         choice4.setText("Try to unlocked door.");
     }
     public void livingroom(){
         position = "livingroom";
         mainTextArea.setText("You are in living room (try to keep your sanity)");
         choice1.setText("Check under the sofa.");
         choice2.setText("Check behind TV.");
         choice3.setText("Check in the cupboard.");
         choice4.setText("Go back to main lobby.");
     }
     public void Sofa(){
         position = "Sofa";
         mainTextArea.setText("Nothing there!");
         choice1.setText("Get back.");
         choice2.setText("");
         choice3.setText("");
         choice4.setText("");
     }
      public void TV(){
         position = "TV";
         mainTextArea.setText("Nothing useful.");
         choice1.setText("Get back.");
         choice2.setText("");
         choice3.setText("");
         choice4.setText("");
     }
      public void TVCup(){
         position = "TVCup";
         mainTextArea.setText("You are in living room (try to keep your sanity)");
         choice1.setText("Check under the sofa.");
         choice2.setText("Check in the cupboard.");
         choice3.setText("Go back to main lobby.");
         choice4.setText("");
     }
      
      public void Cupboard(){
         position = "Cupboard";
         mainTextArea.setText("You hear the sound from cupboard\nWhat you want to do?.");
         choice1.setText("Open the cupboard.");
         choice2.setText("Pour light to it.");
         choice3.setText("");
         choice4.setText("");
     }
     public void Cupboardtwo(){
         position = "Cupboardtwo";
         mainTextArea.setText("You see the shadow inside,What you gonna do?");
         choice1.setText("Close and get back.");
         choice2.setText("Pour light to it.");
         choice3.setText("");
         choice4.setText("");
     }
     public void livingroomCup(){
         position = "livingroomCup";
         mainTextArea.setText("You are in living room (try to keep your sanity)");
         choice1.setText("Check under the sofa.");
         choice2.setText("Check behind TV.");
         choice3.setText("Go back to main lobby.");
         choice4.setText("");
     }
     public void ending(){
         position = "ending";
         mainTextArea.setText("You are surive!!!          Thanks ");
         choice1.setVisible(false);
         choice2.setVisible(false);
         choice3.setVisible(false);
         choice4.setVisible(false);
         itemLabelname.setVisible(false);
         InsaneLabel.setVisible(false);
         Icon ma = new ImageIcon(this.getClass().getResource("ending.gif"));
         Earai6 = new JLabel(ma);
         mainTextPanel.setBounds(0,0 ,800,600);
         mainTextPanel.add(Earai6);
         window.getContentPane().add(mainTextPanel);
     }
     public void cantopen(){
         position = "cantopen";
         mainTextArea.setText("Cant open...,We need infront key what we gonna do");
         choice1.setText("Go back to find.");
         choice2.setText("Break the door.");
         choice3.setText("");
         choice4.setText("");
     }
     public void SofaCup(){
         position = "SofaCup";
         mainTextArea.setText("You are in living room (try to keep your sanity)");
         choice1.setText("Check behind TV.");
         choice2.setText("Check in the cupboard.");
         choice3.setText("Go back to main lobby.");
         choice4.setText("");
     }
     public void Bathroom(){
         position = "Bathroom";
         mainTextArea.setText("You are in Bathroom(try to keep your sanity)");
         choice1.setText("Check the toilet.");
         choice2.setText("Check the shower.");
         choice3.setText("Go back to main lobby.");
         choice4.setText("Check under the sink.");
     }
     public void sink(){
         position="sink";
         mainTextArea.setText("You obtained 1 shotgun bullet");
         shot=1;
         scene3=1;
         choice1.setText("Go back.");
         choice2.setText("");
         choice3.setText("");
         choice4.setText("");
     }
     
     public void toilet(){
         position = "toilet";
         mainTextArea.setText("You see the blood in there(You lost 5 insanity point)");
         playerInsane = playerInsane - 5;
        InsaneLabelnumber.setText("" + playerInsane);
         choice1.setText("Get back.");
         choice2.setText("");
         choice3.setText("");
         choice4.setText("");
     }
     public void shower(){
         position = "shower";
         mainTextArea.setText("You see the number on the wall\n\n5 9 4 0");
         code=1;
         choice1.setText("Get back.");
         choice2.setText("");
         choice3.setText("");
         choice4.setText("");
     }
     public void shotsed(){
         position = "shotsed";
         mainTextArea.setText("Didn't see anything more");
         choice1.setText("Get back.");
         choice2.setText("");
         choice3.setText("");
         choice4.setText("");
     }
     public void Office(){
         position = "Office";
         mainTextArea.setText("You are in Office room(try to keep your sanity)");
         choice1.setText("Check the desk.");
         choice2.setText("Check the closet.");
         choice3.setText("Check the safe.");
         choice4.setText("Go back to main lobby.");
     }
     public void desk(){
         position="desk";
         mainTextArea.setText("You open the desk....Something stole your flashlight");
          item = "Bare Hand";
         itemLabelname.setText(item);
         picPanel = new JPanel();
        picPanel.setBounds(570,375,200,100);
        picPanel.setBackground(Color.white);
        con.add(picPanel);
        Icon earai2 = new ImageIcon(this.getClass().getResource("bare.jpg"));
        picLabel=new JLabel(earai2);
        picLabel.setFont(normalFont);
        picLabel.setForeground(Color.black);
        picPanel.add(picLabel);
        scene=1;
        choice1.setText("Try to keep flashlight.");
        choice2.setText("Let the flashlight.");
        choice3.setText("");
        choice4.setText("");
     }     
     public void Byeflash(){
         position="Byeflash";
         mainTextArea.setText("You can't keep that.");
         choice1.setText("Get back");
         choice2.setText("");
         choice3.setText("");
         choice4.setText("");
     }
     public void Perdmaidai(){
         position="Perdmaidai";
         mainTextArea.setText("You can't open it again");
         choice1.setText("Get back");
         choice2.setText("");
         choice3.setText("");
         choice4.setText("");
     }
     public void Closet(){
         
         if(check==1){
             Kubma();
         }else{
         position="Closet";
         mainTextArea.setText("It locked we need something to break the lock.");
         scene2=1;
         choice1.setText("Check under Closet.");
         choice2.setText("Get back.");
         choice3.setText("");
         choice4.setText("");
         }
        
     }
     public void UnderCloset(){
         position="UnderCloset";
         mainTextArea.setText("Something stole your item from your hand!!!");
         item = "Bare Hand";
         itemLabelname.setText(item);
         picPanel = new JPanel();
         picPanel.setBounds(570,375,200,100);
         picPanel.setBackground(Color.white);
         con.add(picPanel);
        Icon earai2 = new ImageIcon(this.getClass().getResource("bare.jpg"));
         picLabel=new JLabel(earai2);
         picLabel.setFont(normalFont);
         picLabel.setForeground(Color.black);
         picPanel.add(picLabel);
         choice1.setText("Check behind Closet.");
         choice2.setText("");
         choice3.setText("");
         choice4.setText("");
     }
     public void Shotget(){
         position="Shotget";
         mainTextArea.setText("You obtained Shotgun.");
         item = "Shotgun";
         itemLabelname.setText(item);
         check=1;
         picPanel = new JPanel();
         picPanel.setBounds(570,375,200,100);
         picPanel.setBackground(Color.white);
         con.add(picPanel);
        Icon earai4 = new ImageIcon(this.getClass().getResource("shotgun.jpg"));
         picLabel=new JLabel(earai4);
         picLabel.setFont(normalFont);
         picLabel.setForeground(Color.black);
         picPanel.add(picLabel);
         choice1.setText("Shoot the closet");
         choice2.setText("Go back");
         choice3.setText("");
         choice4.setText("");
     }
     public void shootthat(){
         position="shootthat";
         mainTextArea.setText("Bang! You can now open the closet but the \nsound call something(Out off ammo)");
         shot=0;
         choice1.setText("Open the closet");
         choice2.setText("");
         choice3.setText("");
         choice4.setText("");
     }
     public void cantshoot(){
         position="cantshoot";
         mainTextArea.setText("You didn't have ammo");
         choice1.setText("Go back.");
         choice2.setText("");
         choice3.setText("");
         choice4.setText("");
     }
     public void cantdo(){
         position="cantdo";
         mainTextArea.setText("You didn't have ammo");
         choice1.setText("Go back.");
         choice2.setText("");
         choice3.setText("");
         choice4.setText("");
     }
     public void cantany(){
         position="cantany";
         mainTextArea.setText("You can't do anything to closet anymore.");
         choice1.setText("Go back.");
         choice2.setText("");
         choice3.setText("");
         choice4.setText("");
     }
     public void Kubma(){
         position="Kubma";
         mainTextArea.setText("What do you gonna do?");
         scene2=1;
         choice1.setText("Shoot the closet.");
         choice2.setText("Go back.");
         choice3.setText("");
         choice4.setText("");
     }
     public void yingset(){
         position="yingset";
         mainTextArea.setText("You make loud voice...\nThere are something behind you");
         choice1.setText("Check the safe.");
         choice2.setText("Go back to front door.");
         choice3.setText("");
         choice4.setText("");
     }
     public void Nearend(){
         position="Nearend";
         mainTextArea.setText("You are at the main lobby,Can't get out");
         choice1.setText("Break the door");
         choice2.setText("");
         choice3.setText("");
         choice4.setText("");
     }
     public void Checkthesafe(){
         position="safe";
         mainTextArea.setText("You obtain the front key...Let get out here");
         frontkey=1;
         choice1.setText("Go back to front door.");
         choice2.setText("");
         choice3.setText("");
         choice4.setText("");
     }
     public void Checkthesafe2(){
         position="safe2";
         mainTextArea.setText("You didn't know the code");
         choice1.setText("Go back to front door.");
         choice2.setText("");
         choice3.setText("");
         choice4.setText("");
     }
     public void Openclose(){
         position="openc";
         mainTextArea.setText("You obtained the cross,shotgun is useless now.");
         item = "Cross";
         itemLabelname.setText(item);
         kang=1;
          picPanel = new JPanel();
          picPanel.setBounds(570,375,200,100);
         picPanel.setBackground(Color.white);
         con.add(picPanel);
         Icon earai5 = new ImageIcon(this.getClass().getResource("cross.jpg"));
         picLabel=new JLabel(earai5);
         picLabel.setFont(normalFont);
         picLabel.setForeground(Color.black);
         picPanel.add(picLabel);
         choice1.setText("Open safe.");
         choice2.setText("Go back to front door.");
         choice3.setText("");
         choice4.setText("");
     }
     public void Run(){
         position="Run";
         mainTextArea.setText("You are at the front door,Do you have a hope?");
         choice1.setText("Open the door");
         choice2.setText("");
         choice3.setText("");
         choice4.setText(""); 
     }
     public void Cross(){
         position="Cross";
         mainTextArea.setText("Can't Open now we need the hope!!!");
         choice1.setText("Go back.");
         choice2.setText("");
         choice3.setText("");
         choice4.setText(""); 
     }
     
   
   public void Sound(File name){
       try{
        Clip clierror = AudioSystem.getClip();
        clierror.open(AudioSystem.getAudioInputStream(name));
        clierror.start();
    }
    catch(Exception e){
        System.out.print("abae");
    }
}

        public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            createGameScreen();

        }
    }
       public class ChoiceHandler implements ActionListener{
           public void actionPerformed(ActionEvent event){
               //if you click choice 1 button we will put in the your Choice
               String yourChoice = event.getActionCommand();
               
               switch(position){
                   case "On the bed":
                       switch(yourChoice){
                           case "c1":
                               if(playerInsane<1){
                                   lose();Sound(Jump);
                               }
                               else{
                                   step2(); Sound(ni); 
                               }
                                break;
                           case "c2": Getthelight();Sound(grab); ; break;
                           case "c3": Dontsleep(); break;
                       }
                       break;
                   case "Do something":
                       switch(yourChoice){
                           case "c1": startup(); break;
                           
                       }
                       break;
                   case "Light":
                       switch(yourChoice){
                           case "c1": Openlight(); Sound(lighton); break;
                           case "c2": 
                               if(playerInsane<1){
                                   lose();Sound(Jump);
                               }
                               else{
                                   Dropflash(); Sound(drop);
                               }
                               break;
                               
                           case "c3": ; break;
                       }
                       break;
                   case"Dontsleep":
                       switch(yourChoice){
                           case "c1": Getthelight(); Sound(grab); break;
                       }
                       break;
                   case"Openlight":
                       switch(yourChoice){
                           case "c1": Openwindow();Sound(wat); break;
                           case "c2": ; Lookbed();break;
                           case "c3": ; Underbed();break;
                       }
                       break;
                    case"Lookbed":
                        switch(yourChoice){
                           case "c1": Openlight();  break;
                        }
                        break;
                    case"Underbed":
                        switch(yourChoice){
                            case "c1": jumpone();Sound(knock); break;
                            case "c2": jumpone(); break;
                        }
                        break;
                    case"Openwindow":
                        switch(yourChoice){
                            case "c1": Openlight(); break;
                        }
                        break;
                    case"Dropflash":
                        switch(yourChoice){
                            case "c1": Getthelight(); Sound(grab);break;
                            case "c2": IgnoreFlash(); break;
                        }
                        break;
                    case"IgnoreFlash":
                        switch(yourChoice){
                            case "c1": Getthelight(); Sound(grab);break;
                            case "c2": if(playerInsane<1){
                                   lose();Sound(Jump);
                               }else{
                                IgnoreFlash(); break;
                            }
                        }
                        break;
                    case"playerscare":
                        switch(yourChoice){
                            case "c1": Getthelight(); Sound(grab);break;
                            case "c2": playerscare(); break;
                        }
                    case"jumpone":
                        switch(yourChoice){
                            case "c1": Opendoor();Sound(opendoor);break;
                            case "c2": Ignore();Sound(Knock);break;
                            case "c3": Quiet(); break;
                        }
                        break;
                    case"Ignore":
                        switch(yourChoice){
                            case "c1": Opendoor();Sound(opendoor); break;
                            case "c2": Quiet(); break;
                        }
                        break;
                        
                    case"Quiet":
                        switch(yourChoice){
                        case "c1": Opendoor();Sound(opendoor); break;
               }break;
                    case"Opendoor":
                        switch(yourChoice){
                            case "c1": Closedoor(); break;
                            case "c2": Talktoher(); Sound(ni); break;
                            case "c3":
                                     if(playerInsane<1){
                                         lose();
                                     }
                                     else{
                                         walk(); Sound(ni); 
                                     }
                                     break;
                            case "c4": Pour(); lose(); Sound(Jump); break;
                        }
                        break;
                    case"closedoor":
                        switch(yourChoice){
                            case "c1": Safeone(); break;
                        }break;
                    case"walk":
                        switch(yourChoice){
                            case "c1": if(playerInsane<1){
                                         lose();Sound(Jump);
                                     }
                                     else{
                                         firstfloor();
                                     }break;

                        }break;
                        
                    case"Talktoher":
                          switch(yourChoice){
                            case "c1": firstfloor(); break;
                        }break;
                    case"Safeone":
                          switch(yourChoice){
                            case "c1": firstfloor(); break;
                        }break;
                    case"firstfloor":
                          switch(yourChoice){
                            case "c1": livingroom(); Sound(opendoor); break;
                            case "c2": Bathroom();Sound(opendoor); break;
                            case "c3": Office();Sound(opendoor);  break;
                            case "c4": if(frontkey==1){
                                ending();Sound(Win); 
                            }else{
                                cantopen();
                            }
                        }break;
                    case"livingroom":
                        switch(yourChoice){
                            case"c1": Sofa(); break;
                            case"c2": TV(); break;
                            case"c3": Cupboard(); break;
                            case"c4": firstfloor(); break;
                        }
                        break;
                    case"Cupboard":
                        switch(yourChoice){
                            case"c1":Cupboardtwo();  break;
                            case"c2":lose(); Sound(Jump); break;
                        }
                        break;
                        
                    case"Cupboardtwo":
                        switch(yourChoice){
                            case"c1": livingroomCup(); break;
                            case"c2": lose();Sound(Jump); break;
                        }
                        break;
                    case"livingroomCup":
                        switch(yourChoice){
                            case"c1": Sofa(); break;
                            case"c2": TV(); break;
                            case"c3": firstfloor(); break;
                        }
                        break;
                    case"TV":
                        switch(yourChoice){
                            case"c1": TVCup(); break;
                        }
                        break;    
                    case"TVCup":
                        switch(yourChoice){
                            case"c1": Sofa(); break;
                            case"c2": Cupboard(); break;
                            case"c3": firstfloor(); break;
                        } break;
                    case"cantopen":
                        switch(yourChoice){
                            case"c1": firstfloor(); break;
                            case"c2": lose();Sound(Jump); break;
                        } break;
                    case"Sofa":switch(yourChoice){
                            case"c1": livingroomCup(); break;
                    }
                    break;
                    case"SofaCup":switch(yourChoice){
                            case"c1": TV(); break;
                            case"c2": Cupboard(); break;
                            case"c3": firstfloor(); break;
                    }
                    break;
                    
                    case"Bathroom":switch(yourChoice){
                        case"c1":  if(playerInsane<1){
                                         lose();Sound(Jump);
                                     }
                                     else{
                                         toilet();
                                     }
                                     break;
                        case"c2": if(playerInsane<1){
                                         lose();Sound(Jump);
                                     }
                                     else{
                                         shower();
                                     }
                                     break;
                        case"c3":  firstfloor(); break;
                        case"c4": if(shot==1){
                            shotsed();
                        }else{
                            sink();
                        }
                    }break;
                    case"toilet":switch(yourChoice){
                            case"c1": Bathroom(); break;
                    }
                    break;
                    case"shower":switch(yourChoice){
                            case"c1": Bathroom(); break;
                    }
                    break;
                    case"sink":switch(yourChoice){
                            case"c1": Bathroom(); break;
                    }
                    break;
                    
                    case"Office":switch(yourChoice){
                            case"c1": if(scene == 1){
                                Perdmaidai();
                            }else{
                                desk(); 
                            }break;
                            //Ying pai laew
                            case"c2":if(scene2 == 1){
                                cantany();
                            //have ammo do you have gun?
                            }if(scene3==1){
                                Closet();
                            }else{
                                Closet();
                            }break;
                            
                            case"c3":if(kang==1){
                                Checkthesafe();
                            }else{
                                Cross();
                            }break;
                            case"c4":firstfloor(); break;
                    }
                    break;
                    case"desk":switch(yourChoice){
                            case"c1":Byeflash();break;
                            case"c2":Office(); break;
                    }
                    break;
                    case"Byeflash":switch(yourChoice){
                            case"c1":Office(); break;
                    }
                    break;
                    case"Perdmaidai":switch(yourChoice){
                            case"c1":Office(); break;
                    }
                    break;
                    case"shotsed":switch(yourChoice){
                            case"c1":Bathroom(); break;
                    }break;
                    
                    case"Closet":switch(yourChoice){
                            case"c1": UnderCloset();break;
                            case"c2": Office();break;
                    }break;
                    
                    case"UnderCloset":switch(yourChoice){
                            case"c1": Shotget();break;
                    }break;
                    case"Shotget":switch(yourChoice){
                            case"c1": if(shot==1){
                                shootthat();
                            }else{
                                cantdo();
                            }break;
                            case"c2": Office();break;
                    }break;
                   case"cantdo":switch(yourChoice){
                            case"c1": Office();break;
                    }break;
                    case"cantany":switch(yourChoice){
                            case"c1": Office();break;
                    }break;
                     case"Kubma":switch(yourChoice){
                            case"c1": if(shot==1){
                                shootthat();
                            }else{
                                cantdo();
                            }break;
                            case"c2": Office();break;
                    }break;
                    case"yingset":switch(yourChoice){
                            case"c1": if(code==1){
                                Checkthesafe();
                            }else{
                                Checkthesafe2();
                            }break;
                            
                            case"c2": Nearend(); break;
                    }break;
                    case"Nearend":switch(yourChoice){
                            case"c1": lose(); Sound(Jump);break;
                    }break;
                    case"shootthat":switch(yourChoice){
                            case"c1": Openclose(); break;
                    }break;
                    case"openc":switch(yourChoice){
                            case"c1": yingset(); break;
                            case"c2": Run(); break;
                    }break;
                    case"safe":switch(yourChoice){
                            case"c1": Run(); break;
                    }break;
                    case"safe2":switch(yourChoice){
                            case"c1": Run(); break;
                    }break;
                    case"Run":switch(yourChoice){
                            case"c1": if(frontkey==1){
                                ending(); Sound(Win);
                            }else{
                                lose();Sound(Jump);
                            }break;
                    }break;
                    case"Cross":switch(yourChoice){
                            case"c1": Office(); break;
                    }break;

                        
               }
           }
       }
}


