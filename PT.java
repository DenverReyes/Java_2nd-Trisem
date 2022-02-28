import java.io.*; 
import java.lang.Math;

public class PT {

    public static String get_player_name;
    public static String player_name;
    public static int get_player_men;
    public static int player_men;

    //Response variables
    
    //Lotus Eater Area
    public static int response_1; //Checkpoint during your first conversation/encounter with the lotus eaters

    public static void main(String args[])throws Exception{

        InputStreamReader a=new InputStreamReader(System.in);    
        BufferedReader ab=new BufferedReader(a); 

        
        int menu;

        do{
            // Main Menu
            System.out.print("\033[H\033[2J");  
            System.out.println("Welcome to -Title here-"); 
            System.out.println("[1] Start"); 
            System.out.println("[2] Information about the Game"); 
            System.out.println("[3] Credits");
            System.out.println("[4] Exit");
            System.out.print("Enter your choice : ");
            menu = Integer.parseInt(ab.readLine());
            
            
            switch(menu){

                case 1:{
                    player_name = characterCreation(get_player_name);
                    promptAndWait();
                    intro();
                    lotusEater();
                    break;
                }

                case 2:{
                    break;
                }

                case 3:{
                    break;
                }

                case 4:{
                    System.exit(0);
                    break;
                }
            }



        }
        while(true);
    }


    //Method for asking the player to continue
    public static void promptAndWait()throws Exception{

        InputStreamReader a=new InputStreamReader(System.in);    
        BufferedReader ab=new BufferedReader(a);

        String key;

        System.out.print("\nPress any key to continue");
        key = ab.readLine();

    }

    //Method for asking the player to try again
    public static void tryAgain()throws Exception{

        InputStreamReader a=new InputStreamReader(System.in);    
        BufferedReader ab=new BufferedReader(a);
        
        int ans;

        System.out.print("\033[H\033[2J");  
        System.out.println("Do you want to try again?");
        System.out.println("[1] Yes");
        System.out.println("[2] Exit");
        System.out.print("Enter your choice : ");
        ans = Integer.parseInt(ab.readLine()); 

    }

    //Method for CharacterCreation
    public static  String characterCreation(String get_player_name)throws Exception{

        InputStreamReader a=new InputStreamReader(System.in);    
        BufferedReader ab=new BufferedReader(a);

        int final_name;

        do{
            System.out.print("\033[H\033[2J");  
            System.out.println("What is your name?");
            System.out.print("Name : ");
            get_player_name = ab.readLine();

            System.out.println("\nIs " + get_player_name + " your name ?");
            System.out.println("[1] Yes");
            System.out.println("[2] No");
            System.out.print("Enter your choice : ");
            final_name = Integer.parseInt(ab.readLine());  
        }
        while(final_name >= 2 );

        return get_player_name;
    }  
    
 
    //Method for randomizing player men/hp
    public static int randomPlayerMen(int get_player_men){

        int min = 50;
        int max = 100;
        get_player_men = (int)Math.floor(Math.random()*(max-min+1)+min);
        return get_player_men;
    }

    //Method for displaying player's inventory
    public static void playerInventory(int player_men){

        if(player_men > 0){
            System.out.println("-----------------------");
            System.out.println("Player Inventory");
            System.out.println("Player's Men / HP : " + player_men);
            System.out.println("-----------------------");
            System.out.println("\n\n");
        }
    }



    // ODYSSEUS's story

    //Method for the intro part
    public static void intro()throws Exception{

        System.out.print("\033[H\033[2J");

        playerInventory(player_men);
        System.out.println("Narrator: Sailing to the open sea ");
        System.out.println("Narrator: The deed is done.");
        System.out.println("Narrator: Troy's walls have been torn and the Greeks are now sailing home with the victory under our belts.");
        System.out.println("Narrator: However...");
        promptAndWait();

        player_men = randomPlayerMen(get_player_men);
        

        System.out.print("\033[H\033[2J");

        playerInventory(player_men);
        System.out.println("Narrator: They won at the cost of many lives...");
        System.out.println("Narrator: - Sailing to the open sea -");
        System.out.println("Narrator: It was supposed to be a peaceful journey back home, but...");
        System.out.println("Narrator: A strorm brews");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men);
        System.out.println("Narrator: The sky became dark, and the sea began to hurl large waves at the boat almost flipping it upside down.");
        System.out.println("Poseidon: YOU GREEK SCUM!");
        System.out.println("Poseidon: HOW DARE! YOU PREPOSTEROUS HUMANS!");
        System.out.println("Poseidon: YOU HAVE THE AUDACITY TO SAIL THROUGH MY SEAS AFTER WHAT YOU HAVE DONE TO THE CITY!!");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men);
        System.out.println("Poseidon: ESPECIALLY YOU ODYSSEUS! YOU AND YOUR MEN WILL GO THROUGH VARIOUS TRIALS AND TRIBULATIONS THAT I, POSEIDON, ESPECIALLY HAVE MADE.");
        System.out.println("Poseidon: MEET YOUR DEMISE GREEKS!");
        System.out.println("Narrator: The boat was engulfed inside the stormy seas and eventually, it was brought ashore.");
        promptAndWait();

    }

    //Method for the Lotus Eater part
    public static void lotusEater()throws Exception{
        System.out.print("\033[H\033[2J");

        playerInventory(player_men);
        System.out.println("Narrator: - Waves splashing at the shoreline -");
        System.out.println(player_name + ": Grunts");
        System.out.println("Soldier 1: Where are we general? It looks like we are washed away on an island.");
        System.out.println("- A woman holding a lotus appears -");
        promptAndWait();

        do{
            lotusEaterCheckpoint1();
        }
        while(response_1 <= 0 || response_1 > 3);

    }

      //Method for Lotus Eater Checkpoint1
      public static void lotusEaterCheckpoint1()throws Exception{

        InputStreamReader a=new InputStreamReader(System.in);    
        BufferedReader ab=new BufferedReader(a);
        
        System.out.print("\033[H\033[2J");

        playerInventory(player_men);
        System.out.println(player_name + ": This is the island of Lotus-Eaters");
        System.out.println("Lotus-Eater: Hello weary travelers. You seem to be in a lot of pain.");
        System.out.println("--------------------");
        System.out.println("[1] Who are you?");
        System.out.println("[2] Stay away, or I'll kill you");
        System.out.println("[3] (Silence)");
        System.out.print("Enter your response: ");
        response_1 = Integer.parseInt(ab.readLine());

        if(response_1 == 1){

            System.out.print("\033[H\033[2J");

            playerInventory(player_men);
            System.out.println(player_name + ": Who are you ?");
            System.out.println("Lotus-Eater: I am a native of this paradise, we were abandoned and cast away by the people whom we’ve trusted.");
            System.out.println("Lotus-Eater: Betrayed by our dreams THAT EVERYTHING WILL BE FINE!");
            System.out.println("Lotus-Eater:  But, that’s all in the past.");
            promptAndWait();


            System.out.print("\033[H\033[2J");

            playerInventory(player_men);
            System.out.println("Lotus-Eater: Fortunately, we found paradise on this island.");
            System.out.println("Lotus-Eater: We don’t have to worry about food, shelter, and reputations here.");
            System.out.println("Lotus-eater: We have become FREE!");
            System.out.println("Lotus-Eater: It’s all thanks to this lotus.");
            promptAndWait();
        }

        else if(response_1 == 2){

            System.out.print("\033[H\033[2J");

            playerInventory(player_men);
            System.out.println(player_name + ": Stay away, or I'll kill you.");
            System.out.println("Lotus-Eater: There’s no need to be wary, we don’t mean you harm.");
            System.out.println("Lotus-Eater: We, being us the natives of this island. The paradise.");
            System.out.println("Lotus-Eater: Lotus-Eater: You’re safe here on this island.");
            promptAndWait();
        }

        else if(response_1 == 3){

            System.out.print("\033[H\033[2J");

            playerInventory(player_men);
            System.out.println(player_name + ": (Silence)");
            System.out.println("Lotus-Eater: Are you perhaps still dizzy?");
            System.out.println("Lotus-Eater: Take a seat first. There’s nothing that will harm you on this island of paradise.");
            promptAndWait();
        }

        else{
            System.out.println("Wrong input, Please try again.");
            promptAndWait();
        }

        System.out.print("\033[H\033[2J");
        System.out.println("Lotus-Eater: Take this lotus and eat it, it should replenish your strength right away.");

    }
}
