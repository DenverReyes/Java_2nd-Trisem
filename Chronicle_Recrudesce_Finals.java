import java.io.*;
import java.lang.Math;

public class Chronicle_Recrudesce_Finals {

    public static String get_player_name;
    public static String player_name;

    // Response variables

    public static int response_1; // during your first conversation/encounter with the lotus eaters
    public static int response_2; // your decision about the lotus eaters asking you to eat the lotus
    public static int response_3; // your decision when facing cyclops polyphemus
    public static int response_4; // your decision when you're about to die to cyclops polyphemus
    public static int response_5; // your decision whether to heal your allies or not
    public static int response_6; // your decision on what to use as a weapon againts cyclops polyphemus
    public static int response_7; // your decision whether to continue traveling the Open Seas

    // Player Inventory
    public static int get_player_men;
    public static int player_men;
    public static int lotuseater_fruit;
    public static int goldenfleece;
    public static int sheep;
    public static int necklace_of_nyx;

    // Effects
    public static Boolean tamed_cyclopspolyphemus;
    public static Boolean animosity;
    public static Boolean epilogue_trigger;

    // Achievements
    public static Boolean anIslandofLotus = false; // You have found the island of Lotus Eaters
    public static Boolean oneEyedMaster = false; // You have found the Island of Polyphemus
    public static Boolean kingsofWinds = false; // You have found the Island of King Aeolus
    public static Boolean thereisnoPlaceLikeHome = false; // You have returned to Ithaca
    public static Boolean giantManEaters = false; // You have found the Island of Laestrygones
    public static Boolean enchantingwiththeWitch = false; // You have found the Island of Circe
    public static Boolean theAbodeoftheDamned = false; // You have visited the underworld
    public static Boolean songsofBewitchment = false; // You have encountered the Sirens
    public static Boolean inBetweentheTwoSeaMonster = false; // You have encountered the Scylla & Charybdis
    public static Boolean kelvin = false; // You have reached the Island of Sun-God Helios
    public static Boolean meetmyOneEyedFriend = false; // You have tamed the Cyclops Polyphemus
    public static Boolean myFaithwasTrueandsowasmyEnd = false; // You have reached the Epilogue
    public static Boolean perfectRun = false; // You have acquired all achievements and sailed through all adversities
    public static int achievementCounter = 0; // Keep track of how many achievement the player have

    public static void main(String args[]) throws Exception {

        InputStreamReader a = new InputStreamReader(System.in);
        BufferedReader ab = new BufferedReader(a);

        int menu;

        do {

            // Main Menu
            System.out.print("\033[H\033[2J");
            System.out.println("Welcome to Chronicle Recrudesce");
            System.out.println("[1] Start");
            System.out.println("[2] Information about the Game");
            System.out.println("[3] Credits");
            System.out.println("[4] Achievements");
            System.out.println("[5] Exit");
            System.out.print("Enter your choice : ");
            menu = Integer.parseInt(ab.readLine());

            switch (menu) {

                case 1: {

                    player_name = characterCreation(get_player_name);
                    promptAndWait();
                    intro();
                    lotusEater();
                    cyclopsPolyphemus();
                    aeolianIsland();
                    ithaca();

                    if (epilogue_trigger == true) {

                        epilogue();
                    }

                    if (Math.random() < 0.50) {

                        laestrygones();
                    }

                    if (Math.random() < 0.50) {

                        circe();
                    }

                    if (Math.random() < 0.50) {

                        sirens();
                    }

                    if (Math.random() < 0.50) {

                        scyllaAndCharybdis();
                    }

                    if (Math.random() < 0.20) {

                        islandOfSungodHelios();
                    }

                    ending();

                    break;
                }

                case 2: {

                    info();

                    break;
                }

                case 3: {

                    credits();

                    break;
                }

                case 4: {

                    File myFile = new File("Achievements.txt");
                    myFile.createNewFile();
                    System.out.print("\033[H\033[2J");
                    achievementRead();
                    promptAndWait();
                    break;
                }

                case 5: {
                    System.exit(0);
                    break;
                }

                default: {
                    System.out.println("Wrong input, Please try again.");
                    promptAndWait();
                }
            }

        } while (true);
    }

    // Method for asking the player to continue
    public static void promptAndWait() throws Exception {

        InputStreamReader a = new InputStreamReader(System.in);
        BufferedReader ab = new BufferedReader(a);

        String key;

        System.out.print("\nPress any key to continue");
        key = ab.readLine();

    }

    // Method for CharacterCreation
    public static String characterCreation(String get_player_name) throws Exception {

        InputStreamReader a = new InputStreamReader(System.in);
        BufferedReader ab = new BufferedReader(a);

        int final_name;

        do {
            System.out.print("\033[H\033[2J");
            System.out.println("What is your name?");
            System.out.print("Name : ");
            get_player_name = ab.readLine();

            System.out.println("\nIs " + get_player_name + " your name ?");
            System.out.println("[1] Yes");
            System.out.println("[2] No");
            System.out.print("Enter your choice : ");
            final_name = Integer.parseInt(ab.readLine());

            if (final_name > 2 || final_name <= 0) {

                System.out.println("Wrong Input, Please try again");
                promptAndWait();
            }
        } while (final_name >= 2 || final_name <= 0);

        return get_player_name;
    }

    // Method for randomizing player men/hp
    public static int randomPlayerMen(int get_player_men) {

        int min = 75;
        int max = 100;
        get_player_men = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return get_player_men;
    }

    // Method for displaying player's inventory
    public static void playerInventory(int player_men, int lotuseater_fruit, int goldenfleece, int sheep,
            int necklace_of_nyx) {

        if (player_men > 0) {
            System.out.println("-----------------------");
            System.out.println("Player Inventory");
            System.out.println("Player's Men / HP : " + player_men);
        }

        if (lotuseater_fruit > 0) {

            System.out.println("Lotus Eater Fruit : " + lotuseater_fruit);
        }

        if (goldenfleece > 0) {

            System.out.println("Golden Fleece : " + goldenfleece);
        }

        if (sheep == 1 && necklace_of_nyx == 1) {

            System.out.println("Necklace of Nyx : " + necklace_of_nyx);
        }

        System.out.println("-----------------------");
        System.out.println("\n\n");
    }

    // Method for game over
    public static void gameOver() {

        System.out.print("\033[H\033[2J");
        System.out.println("GAME OVER !!!");

        System.exit(0);

    }

    // ODYSSEUS's story

    // Method for the intro part
    public static void intro() throws Exception {

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Narrator: Sailing to the open sea ");
        System.out.println("Narrator: The deed is done.");
        System.out.println(
                "Narrator: Troy's walls have been torn and the Greeks are now sailing home with the victory under our belts.");
        System.out.println("Narrator: However...");
        promptAndWait();

        player_men = randomPlayerMen(get_player_men);

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Narrator: They won at the cost of many lives...");
        System.out.println("Narrator: - Sailing to the open sea -");
        System.out.println("Narrator: It was supposed to be a peaceful journey back home, but...");
        System.out.println("Narrator: A strorm brews");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println(
                "Narrator: The sky became dark, and the sea began to hurl large waves at the boat almost flipping it upside down.");
        System.out.println("Poseidon: YOU GREEK SCUM!");
        System.out.println("Poseidon: HOW DARE! YOU PREPOSTEROUS HUMANS!");
        System.out.println(
                "Poseidon: YOU HAVE THE AUDACITY TO SAIL THROUGH MY SEAS AFTER WHAT YOU HAVE DONE TO THE CITY!!");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println(
                "Poseidon: ESPECIALLY YOU ODYSSEUS! YOU AND YOUR MEN WILL GO THROUGH VARIOUS TRIALS AND TRIBULATIONS THAT I, POSEIDON, ESPECIALLY HAVE MADE.");
        System.out.println("Poseidon: MEET YOUR DEMISE GREEKS!");
        System.out.println(
                "Narrator: The boat was engulfed inside the stormy seas and eventually, it was brought ashore.");
        promptAndWait();

    }

    // Method for the Lotus Eater part
    public static void lotusEater() throws Exception {

        InputStreamReader a = new InputStreamReader(System.in);
        BufferedReader ab = new BufferedReader(a);

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Narrator: - Waves splashing at the shoreline -");
        System.out.println(player_name + ": Grunts");
        System.out.println("Soldier 1: Where are we general? It looks like we are washed away on an island.");
        System.out.println("- A woman holding a lotus appears -");
        promptAndWait();

        // your first conversation/encounter with the lotus eaters
        do {
            System.out.print("\033[H\033[2J");

            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
            System.out.println(player_name + ": This is the island of Lotus-Eaters");
            System.out.println("Lotus-Eater: Hello weary travelers. You seem to be in a lot of pain.");
            System.out.println("--------------------");
            System.out.println("[1] Who are you?");
            System.out.println("[2] Stay away, or I'll kill you");
            System.out.println("[3] (Silence)");
            System.out.print("Enter your response: ");
            response_1 = Integer.parseInt(ab.readLine());

            if (response_1 == 1) {

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println(player_name + ": Who are you ?");
                System.out.println(
                        "Lotus-Eater: I am a native of this paradise, we were abandoned and cast away by the people whom we've trusted.");
                System.out.println("Lotus-Eater: Betrayed by our dreams THAT EVERYTHING WILL BE FINE!");
                System.out.println("Lotus-Eater:  But, that's all in the past.");
                promptAndWait();

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println("Lotus-Eater: Fortunately, we found paradise on this island.");
                System.out.println("Lotus-Eater: We don't have to worry about food, shelter, and reputations here.");
                System.out.println("Lotus-eater: We have become FREE!");
                System.out.println("Lotus-Eater: It's all thanks to this lotus.");
                promptAndWait();
            }

            else if (response_1 == 2) {

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println(player_name + ": Stay away, or I'll kill you.");
                System.out.println("Lotus-Eater: There's no need to be wary, we don't mean you harm.");
                System.out.println("Lotus-Eater: We, being us the natives of this island. The paradise.");
                System.out.println("Lotus-Eater: Lotus-Eater: You're safe here on this island.");
                promptAndWait();
            }

            else if (response_1 == 3) {

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println(player_name + ": (Silence)");
                System.out.println("Lotus-Eater: Are you perhaps still dizzy?");
                System.out.println(
                        "Lotus-Eater: Take a seat first. There's nothing that will harm you on this island of paradise.");
                promptAndWait();
            }

            else {
                System.out.println("Wrong input, Please try again.");
                promptAndWait();
            }
        } while (response_1 <= 0 || response_1 > 3);

        // your decision about the lotus eaters asking you to eat the lotus
        do {
            System.out.print("\033[H\033[2J");

            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
            System.out
                    .println("Lotus-Eater: Take this lotus and eat it, it should replenish your strength right away.");
            System.out.println("--------------------");
            System.out.println("[1] We accept. Thank you.");
            System.out.println("[2] No, Thank you.");
            System.out.print("Enter your response: ");
            response_2 = Integer.parseInt(ab.readLine());

            if (response_2 == 1) {

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println(player_name + ": We accept. Thank you.");
                System.out.println("Soldier1: This lotus is so GOOD!");
                System.out.println("Soldier2:  I can feel my strength coming back!");
                System.out.println(player_name + ": Let's rest for a bit here.");
                System.out.println("Narrator: * A few hours later *");
                promptAndWait();

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println(player_name + ": This much rest should be enough now, let's continue sailing on.");
                System.out.println("Soldier1: But why should we? Can't we just stay here?");
                System.out.println(
                        "Narrator: * You noticed how your soldiers have started to change, they start to lose their longing for home. *");
                System.out.println(
                        "Narrator: Many of your men had to be dragged back to the ship but some were already gone and can't be retrieved.");
                promptAndWait();

                System.out.print("\033[H\033[2J");

                lotuseater_fruit = 10;
                player_men = player_men - 30;
                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println(player_name + ": Store away the fruits, it could come in handy later.");
                System.out.println("Narrator: * - 30 Soldiers in command. They've lost their longing for Home *");
                System.out.println("Narrator: * Lotus-Eaters' Fruit Acquired *");
                System.out.println("Narrator: * You have left the Island of Lotus-Eaters *");
                promptAndWait();
            }

            else if (response_2 == 2) {

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println(player_name + ": No, Thank you.");
                System.out.println("Soldier1: But why commander?");
                System.out
                        .println("Soldier2: We're starving and I don't the army can hold on much longer without food.");
                System.out.println(player_name
                        + ": Let's scavenge the island instead and look for other sources of food and rest for a bit. Move out!");
                promptAndWait();

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println("Narrator: * A few hours later *");
                System.out.println(player_name
                        + ": That should be plenty of rest. Let's start packing and start sailing once more.");
                System.out.println("Soldier1: But why? Can't we just stay a bit more? This Lotus is so GOOD!");
                System.out.println("Soldier2: He's right! You guys should try it too!");
                promptAndWait();

                System.out.print("\033[H\033[2J");

                player_men = player_men - 2;
                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println(player_name
                        + ": Hmm... Leave them. This is why I didn't what you guys to have the fruit. It makes you lose your longing for home. Furthermore, it's already plenty suspicious how that island native approached us and explained this place.");
                System.out.println(player_name
                        + ": Those who want to last till we reach home, you better start following me unfailingly.");
                System.out.println(
                        "Narrator: * - 2 Soldiers in command were left behind. They've lost their longing for Home *");
                System.out.println("Narrator: * You have left the Island of Lotus-Eaters *");
                promptAndWait();
            }

            else {
                System.out.println("Wrong input, Please try again.");
                promptAndWait();
            }
        } while (response_2 <= 0 || response_2 > 2);

        anIslandofLotus = true;
        achievementCounter++;
        achievementWrite();
    }

    // Method for Cyclops Polyphemus
    public static void cyclopsPolyphemus() throws Exception {

        InputStreamReader a = new InputStreamReader(System.in);
        BufferedReader ab = new BufferedReader(a);

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println(
                "Narrator: Your army has sailed was once more out into the seas. You wander once more towards the horizon and soon enough you've reached your next stop.");
        System.out.println("Soldier1: Commander! I see land!");
        System.out.println(
                player_name + ": Let's dock to it and find rest. We have been exhausted physically and mentally.");
        System.out.println("Narrator: * The ship is now docked at the island *");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println(player_name
                + ": Let's scout the area, I'll bring 12 men with me. Let's move. The others, start stocking up our food supply. Be ready to depart anytime.");
        System.out.println("Narrator: You began to scavenge the island with your men. When suddenly...");
        System.out.println("*STOMP* *STOMP* *STOMP*");
        System.out.println(player_name + ": Whispering* Shhh...Halt. The ground is shaking.");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("*Silence*");
        System.out.println("Soldier3: *Whispering* It stopped?");
        System.out.println("Cyclops Polyphemus: ROAAAR!! New food has come to my territory. Oh! What a lucky day!");
        System.out.println(player_name + ": MEN! Assume defensive formation! Prepare for combat!");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        player_men = player_men - 6;

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println(
                "Narrator: * You have been ambushed by Cyclops Polyphemus and engaged in a battle. You have lost 6 of your men in this encounter and the rest of you has become a captive. *");
        System.out.println("Narrator: * - 6 soldiers were lost in the encounter with Cyclops Polyphemus *");
        System.out.println("Narrator: * You have been captured by the Cyclops Polyphemus *");
        System.out.println(
                "Soldier12: *Whispering* Commander! We should escape immediately! This is Cyclops' Polyphemus' cave!");
        promptAndWait();

        // your decision when facing cyclops polyphemus
        do {
            System.out.print("\033[H\033[2J");

            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
            System.out.println("Soldier 10: *Whispering* We will be eaten alive! What should we do captain?");
            System.out.println("--------------------");
            System.out.println("[1] Do Nothing.");
            System.out.println("[2] Devise a plan.");
            System.out.print("Enter your response: ");
            response_3 = Integer.parseInt(ab.readLine());

            if (response_3 == 1) {

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println(player_name
                        + ": It's already over for us. We should accept the loss. He should have found the ship by now and eaten the rest.");
                System.out.println("Soldier9: HOW COULD YOU SAY THAT COMMANDER?!");
                System.out.println(
                        "Cyclops Polyphemus: Hmmm? Ahh, it seems you're awake. Should I start eating now? AH~~.");
                System.out.println("Soldier9: AHHHH!!! HELP ME!");
                promptAndWait();

                // your decision when you're about to die to cyclops polyphemus
                do {
                    System.out.print("\033[H\033[2J");

                    playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                    System.out.println("*You're about to die and the last one of the scouting team*");
                    System.out.println("*Do you still wish to do nothing?*");
                    System.out.println("--------------------");
                    System.out.println("[1] YES");
                    System.out.println("[2] NO");
                    System.out.print("Enter your response: ");
                    response_4 = Integer.parseInt(ab.readLine());

                    if (response_4 == 1) {

                        System.out.print("\033[H\033[2J");

                        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                        System.out.println(
                                "Cyclops Polyphemus: Hmmm??? What a failure of a commander. You were the first to lose the will to survive which led your men to their death. I won't let have an easy death.");
                        System.out.println(player_name + ": No..no..NO!!!! AHH!!!!");
                        promptAndWait();

                        System.out.print("\033[H\033[2J");

                        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                        System.out.println(
                                "Narrator: * You have been dismembered by Cyclops Polyphemus limb by limb while healing you with the golden fleece for 10 days. After which you have tied down on a big rock and thrown to the sea and perished.*");
                        promptAndWait();

                        gameOver();
                        promptAndWait();
                        break;
                    }

                    else if (response_4 == 2) {

                        System.out.print("\033[H\033[2J");

                        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                        System.out.println(player_name + ":  Tsk... POLYPHEMUS! I HAVE A BARGAIN!");
                        System.out.println(
                                "Cyclops Polyphemus: Hmm... What an indecisive commander you are. Did the death of your soldier have moved you?");
                        System.out.println(player_name
                                + " Not in the slightest! I just wanted to save myself in exchange for telling you where the others are!");
                        System.out.println("Soldier 10: COMMANDER?!");
                        promptAndWait();

                        System.out.print("\033[H\033[2J");

                        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                        System.out.println(
                                "Cyclops Polyphemus: Hmmm...How can I trust a word that comes from your mouth huh?");
                        System.out.println(player_name
                                + ": Untie me and I shall show you a recipe to make your sheep far more delicious we have recently acquired from our adventure.");
                        System.out.println("Cyclops Polyphemus: Very well... Satisfy me.");
                        System.out.println("*Lotus-eater's fruit Required*");
                        promptAndWait();

                        if (lotuseater_fruit == 0) {

                            System.out.print("\033[H\033[2J");

                            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                            System.out.println("Cyclops Polyphemus: What are you doing?");
                            System.out.println(player_name + ": Uhm...I...Uh-");
                            System.out
                                    .println("Cyclops Polyphemus: You are just wasting my time, all of will now die!");
                            System.out.println("Narrator: *The player has died*");
                            promptAndWait();

                            gameOver();
                            promptAndWait();
                            break;

                        }

                        else if (lotuseater_fruit > 0) {

                            System.out.print("\033[H\033[2J");

                            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                            System.out.println("* You have coated a sheep in Lotus-flower *");
                            System.out.println(
                                    "Cyclops Polyphemus: *Sniff* The sheep has become more fragrant and appealing. Let me have a taste.");
                            System.out.println(
                                    "Narrator: Cyclops Polyphemus has consumed Lotus-Eater fruit coated sheep. He has become addicted to it and lost his senses and craves for more.");
                            System.out.println("Cyclops Polyphemus: MORE! Give me more! Where is it!");

                            lotuseater_fruit = 0;
                            promptAndWait();

                            System.out.print("\033[H\033[2J");

                            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                            System.out.println("Odysseus: * Unties his soldiers * Now men attack all at once!");
                            System.out.println("Cyclops Polyphemus: GAHH!!");
                            System.out.println(player_name + ": This is for the men you've kill");
                            System.out.println("*Cyclops Polyphemus has died*");
                            tamed_cyclopspolyphemus = false;
                            promptAndWait();

                            // your decision whether to heal your allies or not
                            do {
                                System.out.print("\033[H\033[2J");

                                goldenfleece = 1;

                                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                                System.out.println("* You have obtained the Golden Fleece and heal your allies *");
                                System.out.println("Narrator: Would you like to heal your allies?");
                                System.out.println("--------------------");
                                System.out.println("[1] Yes.");
                                System.out.println("[2] No.");
                                System.out.print("Enter your response: ");
                                response_5 = Integer.parseInt(ab.readLine());

                                if (response_5 == 1) {

                                    System.out.print("\033[H\033[2J");

                                    playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                                    System.out.println(
                                            "Narrator: The captured men have been healed. They have a better opinion of you now.");
                                    animosity = false;
                                    promptAndWait();
                                }

                                else if (response_5 == 2) {

                                    System.out.print("\033[H\033[2J");

                                    playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                                    System.out.println(
                                            "Narrator: Your men's morale has reduced and started to have animosity towards you.");
                                    animosity = true;
                                    promptAndWait();
                                }

                                else {
                                    System.out.println("Wrong input, Please try again.");
                                    promptAndWait();
                                }

                                System.out.print("\033[H\033[2J");

                                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                                System.out.println(player_name + ": Let's head back and leave this place.");
                                System.out.println(
                                        "Narrator: *You and your men have made a grave for the fallen warriors and set sail once more.*");
                                System.out.println("Narrator: *You have left the Island of Cyclops Polyphemus*");
                                promptAndWait();
                            } while (response_5 <= 0 || response_5 > 2);
                        }

                    }

                    else {
                        System.out.println("Wrong input, Please try again.");
                        promptAndWait();
                    }
                } while (response_4 <= 0 || response_4 > 2);

            }

            else if (response_3 == 2) {

                // your decision on what to use as a weapon againts cyclops polyphemus
                cyclops_Checkpoint1();

                if (response_6 == 2 && lotuseater_fruit <= 0) {
                    cyclops_Checkpoint1();
                }

            }

            else {
                System.out.println("Wrong input, Please try again.");
                promptAndWait();
            }
        } while (response_3 <= 0 || response_3 > 2);

        oneEyedMaster = true;
        achievementCounter++;
        achievementWrite();

    }

    // Method for cyclops_Checkpoint
    public static void cyclops_Checkpoint1() throws Exception {

        InputStreamReader a = new InputStreamReader(System.in);
        BufferedReader ab = new BufferedReader(a);

        do {
            System.out.print("\033[H\033[2J");

            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
            System.out.println(player_name + ": Let me ponder for a moment. And observe what we have at our disposal.");
            System.out.println("--------------------");
            System.out.println("Choose:");
            System.out.println("[1] Use a heated Staff and stab Cyclops Polyphemus' Eye");
            System.out
                    .println("[2] Use the Lotus-Eaters' Fruit to tame Cyclops Polyphemus (Lotus Eater Fruit Required)");
            System.out.print("Enter your response: ");
            response_6 = Integer.parseInt(ab.readLine());

            if (response_6 == 1) {

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println(player_name
                        + ": He's currently eating sheep right now, let's until he sleeps and heat the staff over there and strike him down. And take the golden fleece from him too. Keep your wits with you.");
                System.out.println("* Nods *");
                System.out.println("Narrator: * Night Fell and Cyclops Polyphemus is fast asleep *");
                System.out.println(
                        "Narrator: * You have freed your men and heated the staff then stabbed Cyclops Polyphemus' eye *");
                promptAndWait();

                System.out.print("\033[H\033[2J");

                goldenfleece = 1;

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println("Narrator: * Cyclops Polyphemus has died *");
                tamed_cyclopspolyphemus = false;
                System.out.println("Narrator: * You have obtained the Golden Fleece, you can now heal your allies. *");
                animosity = false;
                System.out.println(player_name
                        + "We have avenged our comrades. Let's take the fleece and take our leave. Prepare to depart at once.");
                System.out.println("Soldiers: Yes sir!");
                promptAndWait();

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println("* You have left the Island of Cyclops Polyphemus *");
                promptAndWait();
            }

            else if (response_6 == 2 && lotuseater_fruit > 0) {

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println(player_name
                        + ": He's currently eating sheep right now, let's until he sleeps and feed him some of the Lotus-Eater's fruit. It should make him obsessed with the fruit.");
                System.out.println("Soldiers: * Nods *");
                System.out.println("Narrator: * Night Fell and Cyclops Polyphemus is fast asleep *");
                System.out.println("* You have freed your men and sneakily fed Cyclops Polyphemus with the fruit *");
                promptAndWait();

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println("* Cyclops Polyphemus has now become crazed and is obsessed with the fruit *");
                System.out.println(
                        "Cyclops Polyphemus: What is this?! MORE! I want MORE! Do you have more?! GIVE ME MORE!");
                System.out
                        .println(player_name + ":  I will give you more as long as you follow my orders. Understood?");
                System.out.println("Cyclops Polyphemus: YES!");
                lotuseater_fruit = 0;
                tamed_cyclopspolyphemus = true;
                promptAndWait();

                meetmyOneEyedFriend = true;
                achievementCounter++;
                achievementWrite();

                System.out.print("\033[H\033[2J");

                goldenfleece = 1;

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println("Narrator: * You have obtained the Golden Fleece, you can now heal your allies. *");
                System.out.println(player_name
                        + ": Use this fleece to heal yourselves, and recover from fatigue. Let's stay here for a while and stock up some more of this fruit and upgrade the ship to bring Cyclops Polyphemus with us.");
                animosity = false;
                System.out.println("Soldiers: YES SIR!");
                System.out.println("Narrator: * 5 months have passed *");
                promptAndWait();

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println("Narrator: * Your men and Polyphemus has upgraded the ships *");
                System.out.println("Narrator: * They cultivated the Lotus-Eater Fruit too *");
                System.out.println("Narrator: * The ships have been upgraded to bring Polyphemus with you *");
                System.out.println("Narrator: * Lotus-Eater Fruit has increased significantly *");
                lotuseater_fruit = 50;
                promptAndWait();

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println(player_name + ": Polyphemus! Do you wish to follow us?");
                System.out.println(
                        "Cyclops Polyphemus: YES! I didn't want to stay home anyway, I'll follow the fruit wherever~~ it goes!");
                System.out.println(player_name + ": Good response, all hands on deck! Let's depart!");
                System.out.println("Narrator: *You have left the Island of Cyclops Polyphemus*");
                promptAndWait();
            }

            else if (response_6 == 2 && lotuseater_fruit <= 0) {

                System.out.println("You don't have any lotus eater fruit available, please choose another option");
                promptAndWait();

            }

            else {
                System.out.println("Wrong input, Please try again.");
                promptAndWait();
            }
        } while (response_6 <= 0 || response_6 > 2);
    }

    // Method for Aeolian Island
    public static void aeolianIsland() throws Exception {

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println(
                "Narrator: Your army has sailed was once more out into the sea. You wander once more towards the horizon and soon enough you've reached your next stop.");
        System.out.println("Soldier: Commander! I can see a city- No a kingdom surrounded by various winds!");
        System.out.println(player_name + ": A kingdom of winds you say...");
        System.out.println("Aelian Soldier: HALT! State your purpose!");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println(player_name
                + ": At ease soldier, I am Commander Odysseus, the strategist. We are soldiers of the Greeks currently on our course way home. Due to unfortunate events, we are brought here. We humbly ask for your hospitality to take care of us.");
        System.out.println("King Aeolus: What seems to be the commotion?");
        System.out.println(
                "Aeolian Soldier: Your grace! *Bow* There seem to be Greeks right outside the borders who wish to be accommodated. The commander introduced himself to be Odysseus.");
        System.out.println("King Aeolus: " + player_name + " you say?! Let them in!");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println(
                "Narrator: * You have been invited by King Aeolus to his Kingdom and stayed there for a month *");
        System.out.println(
                "Narrator: * You and your men is well rested and fed, they are now able to perform much better than before *");
        System.out.println(player_name
                + ": King Aeolus, you have my highest gratitude for taking me and my men inside your borders with hospitality. I'll remember this favor.");
        System.out.println(
                "King Aeolus: Ho-ho-ho! I'll count on you then when the time comes. I'll send out some favorable winds for your travels. Oh and take this leather bag. Guard this bag at all times, it's a bag full of storm winds.");
        System.out.println(player_name + ": Thank you, I will keep this in mind. Goodbye.");
        promptAndWait();

        if (tamed_cyclopspolyphemus == true) {

            System.out.print("\033[H\033[2J");

            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
            System.out.println(player_name
                    + ": Polyphemus, keep this leather bag with you at all times. Guard it and don't let anyone open it. Understood?");
            System.out.println("Polyphemus: Yes, master.");
            System.out.println(player_name
                    + ": Let's set sail now my men! We should reach Ithaca soon! With our minds and bodies rejuvenated and the favorable winds set for us by King Aeolus, let's head home in 2 weeks' time!");
            System.out.println("Soldiers: YES SIR!");
            promptAndWait();

            System.out.print("\033[H\033[2J");

            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
            System.out.println(player_name + ": GREEKS!");
            System.out.println("Soldiers: AWOO! AWOO!");
            promptAndWait();
        }

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Narrator: * You have left the Aeolian Island * ");
        promptAndWait();

        kingsofWinds = true;
        achievementCounter++;
        achievementWrite();

    }

    // Method for Ithaca
    public static void ithaca() throws Exception {

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Narrator: You and your men have started sailing once more to Ithaca.");
        System.out.println("Narrator: The next destination is once more in view.");
        System.out.println("Soldier1: Commander! I can see it! The city of Ithaca is in view!");
        System.out.println(player_name + ": Finally, the long journey will finally come to an end.");
        System.out.println(player_name + ": MEN! Prepare to dock. We have reached Ithaca.");

        epilogue_trigger = true;
        promptAndWait();

        if (animosity == true || Math.random() < 0.75) {

            System.out.print("\033[H\033[2J");

            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
            System.out.println("Soldier 34: Hey! Hey! Look! It's the leather bag Odysseus got from King Aeolus.");
            System.out.println("Soldier 30: What about it?");
            System.out.println(
                    "Soldier 34: I bet it's a bag of gold he received. How selfish of him to keep it all for himself!");
            System.out.println("Soldier 30: Really? Is it really a bag of gold?");
            promptAndWait();

            System.out.print("\033[H\033[2J");

            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
            System.out.println("Soldier 34: Shall we take a peek?");
            System.out.println("Narrator: * The bag of storm winds have been opened *");
            System.out
                    .println("Narrator: * Island destination randomization has been enabled due to the Storm Winds *");
            System.out.println(player_name + ":  What? What's happening?");
            promptAndWait();

            System.out.print("\033[H\033[2J");

            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
            System.out.println("Narrator: * Aeolus' Storm Winds has appeared *");
            System.out.println(player_name + ": WHAT HAVE YOU DONE?!");
            System.out.println("Soldier 34: I- I'M SORRY! I DIDN'T KNOW!");
            System.out.println(player_name + ": TSK, MEN FIND SOMETHING TO HOLD ON!");
            promptAndWait();

            System.out.print("\033[H\033[2J");

            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
            System.out.println("Narrator: * Aeolus' Storm Winds has enlarged *");
            System.out.println("Narrator: * It has engulfed your battalion of ships *");
            System.out.println("Narrator: * You are now in the middle of the sea *");
            System.out.println(player_name
                    + ": My negligence and my men's folly have brought our demise. CURSES! Once more, we are lost in the sea again...");
            promptAndWait();

            epilogue_trigger = false;

        }

        if (tamed_cyclopspolyphemus == true) {

            System.out.print("\033[H\033[2J");

            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
            System.out.println("Soldier 34: Hey! Hey! Look! It's the leather bag Odysseus got from King Aeolus.");
            System.out.println("Soldier 30: What about it?");
            System.out.println(
                    "Soldier 34: I bet it's a bag of gold he received. How selfish of him to keep it all for himself!");
            System.out.println("Soldier 30: Really? Is it really a bag of gold?");
            promptAndWait();

            System.out.print("\033[H\033[2J");

            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
            System.out.println("Soldier 34: Shall we take a peek?");
            System.out.println(
                    "Cyclops Polyphemus: Hmm, the master said no one shall open this bag unless he told you so.");
            System.out.println("Soldier 34: Come on, just let me see it!");
            System.out.println("Cyclops Polyphemus: NO!");
            promptAndWait();

            System.out.print("\033[H\033[2J");

            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
            System.out.println("Narrator: * Soldier 34 has been pinned down by Cyclops Polyphemus *");
            System.out.println(player_name + ": What seems to be ruckus?");
            System.out.println(
                    "Cyclops Polyphemus: This man wants to open this leather bag you've entrusted to me master.");
            System.out.println(player_name + ": And why do you want to see what's inside, soldier?");
            promptAndWait();

            System.out.print("\033[H\033[2J");

            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
            System.out.println(
                    "Soldier 34: I just wanted to see what was inside, I suspected it was a bag of gold you're hoarding for yourself.");
            System.out.println(player_name
                    + ": - Sigh - This bag contains storm winds given to us by King Aeolus. Once we open it, we are probably going to be sent back from where we came from. The middle of the sea.");
            System.out.println("Soldier 34: I- I'm sorry.");
            System.out.println(player_name
                    + ": You should control yourself next time. Luckily Polyphemus is here to stop you. Start moving and dock already.");
            promptAndWait();

            System.out.print("\033[H\033[2J");

            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
            System.out.println("Narrator:  * Congratulations! You have reached Ithaca! *");
            System.out.println("Narrator: * You can now travel the remaining islands to obtain various items *");
            System.out.println("Narrator: * However, the island you are to find is randomized *");
            promptAndWait();

            System.out.print("\033[H\033[2J");

            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
            System.out.println("Penelope: ODYSSEUS! My love!");
            System.out.println(player_name + ":  Penelope! I'm home!");
            System.out.println("Telemachus: FATHER! WELCOME BACK!");
            System.out.println("Narrator: * Your wife and son hugged you tightly *");
            promptAndWait();

            System.out.print("\033[H\033[2J");

            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
            System.out.println("Penelope: Are you okay honey? You look so tired. You take a break first.");
            System.out.println(player_name + ": I'm fine now. I'm at ease now that I'm home.");
            System.out.println("Telemachus: Father! Father! Let's play after you've rested!");
            promptAndWait();

            epilogue_trigger = true;
        }

        thereisnoPlaceLikeHome = true;
        achievementCounter++;
        achievementWrite();

    }

    // Method for Epilogue
    public static void epilogue() throws Exception {

        InputStreamReader a = new InputStreamReader(System.in);
        BufferedReader ab = new BufferedReader(a);

        do {
            System.out.print("\033[H\033[2J");

            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
            System.out.println("Dear player, Do you wish to continue traveling the Open Seas?");
            System.out.println("[1] Yes");
            System.out.println("[2] No");
            System.out.print("Enter your response: ");
            response_7 = Integer.parseInt(ab.readLine());
            myFaithwasTrueandsowasmyEnd = true;
            achievementCounter++;
            achievementWrite();

            if (response_7 == 1) {

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println("Narrator: You have reached home.");
                System.out.println(
                        "Narrator: The men that were with you eventually returned to their respected homes one by one.");
                System.out.println("Narrator: Cyclops Polyphemus has become a guardian of your city.");
                System.out.println(
                        "Narrator: The city has prospered from then on, crops have flourished, trade flows have developed.");
                promptAndWait();

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println("Narrator: Telemachus has become a fine warrior and a good tactician too.");
                System.out.println("Narrator: You also had another daughter with Penelope and named her Sophia.");
                System.out.println("Narrator: It was peaceful.");
                System.out.println("Narrator: * 5 years has passed *");
                promptAndWait();

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println("Narrator: * You are sparring with Telemachus in the backyard *");
                System.out.println("Telemachus: Hah! Hah! Hiya! AHH!");
                System.out.println(player_name + ": Hmph!");
                System.out.println("Telemachus: UAGH!! *Pant* *Pant*");
                promptAndWait();

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println("Narrator: * Penelope and Sophia comes out to the backyard *");
                System.out.println("Penelope: Boys! It's time to eat!");
                System.out.println("Sophia: Papa! Tel Adelfos! It's time to eat!");
                System.out.println(player_name + ": Yes honey! Papa and your brother will be there in a moment Sophie!");
                promptAndWait();

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println("Sophia: Okay papa!");
                System.out.println(player_name + ": Telemachus, wash up and help Sophie set up the table.");
                System.out.println("Telemachus: *Pant* *Pant* Okay father. Sophie! Let's set up the table!");
                System.out.println("Narrator: * Telemachus runs ahead and Penelope walks towards you *");
                promptAndWait();

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println("Penelope: Be careful Tel! Hm? What's the matter, dear?");
                System.out.println(player_name + ": Penelope, I want to travel once more to the open seas.");
                System.out.println("Penelope: Why? Do you still have things to do out there?");
                System.out.println(player_name + ":  You could say it's something like that");
                promptAndWait();

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println("Penelope: Okay... Be careful out there.");
                System.out.println(player_name + ":  I will.");
                System.out.println("* You kiss Penelope *");
                System.out.println("Narrator: You started preparing for the voyage the next day.");
                promptAndWait();

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println(
                        "Narrator: You gathered 3 ships, 100 skilled men and Cyclops Polyphemus to assist you.");
                System.out.println("Narrator: Ithaca has sent you off.");
                System.out.println("Narrator: Penelope, Telemachus and Sophia waves at you in the distance.");
                System.out.println(
                        "Poseidon: YOU SHOULD HAVE STAYED THERE ODYSSEUS! YOU SHALL NOW EXPERIENCE ISOLATION IN THE SEA ONCE MORE!");
                promptAndWait();

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println("Narrator: You have been washed away into the middle of the sea.");
                promptAndWait();
            }

            else if (response_7 == 2) {

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println("Narrator: You have reached home.");
                System.out.println(
                        "Narrator: The men that were with you eventually returned to their respected homes one by one.");
                System.out.println("Narrator: Cyclops Polyphemus has become a guardian of your city.");
                System.out.println(
                        "Narrator: The city has prospered from then on, crops have flourished, trade flows have developed.");
                promptAndWait();

                System.out.print("\033[H\033[2J");

                playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
                System.out.println("Narrator: Telemachus has become a fine warrior and a good tactician too.");
                System.out.println("Narrator: You also had another daughter with Penelope and named her Sophia.");
                System.out.println("Narrator: It was peaceful.");
                promptAndWait();

                ending();
            }
        } while (response_7 <= 0 || response_7 > 2);
    }

    // Method for Encounter with Laestrygones(30% chance)
    public static void laestrygones() throws Exception {

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Narrator: 10 days and 10 nights have passed.");
        System.out.println("Narrator: You are in the middle of the sea and an island in the mist is in view.");
        System.out.println("Soldier: Commander! There's an island up ahead.");
        System.out.println(player_name + ": Good, let's explore it.");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Soldier: But commander, it seems too suspicious. It is too quiet and covered in mist.");
        System.out.println("Odysseus: Let's just approach it with caution.");
        System.out.println("Narrator: * You have docked at the island *");
        System.out.println(player_name + ": Be on guard everyone. Assume defense position.");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Narrator: * The ground started to shake  *");
        System.out.println(player_name + ": Something big is coming! Brace yourselves!");
        System.out.println("* Giant Laestrygones has appeared *");
        System.out.println("Laestrygone 1: Oh would you look at that! Some delicious human flesh is here!");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Laestrygone 2: Thank you for the food! ");
        System.out.println("Laestrygone 3: NO! THEY'RE MINE!");
        System.out.println("Laestrygone 1: I SAW THEM FIRST! ");
        System.out.println(player_name + ": Let's retreat while they're still distracted.");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Narrator: * You have fled from the island and boarded the ship *");
        System.out.println("Laestrygone 1: HEY! THEY''RE GETTING AWAY!");
        System.out.println("Laestrygone 2: THIS IS ALL YOUR FAULT! *Hits Laestrygone 3*");
        System.out.println("Laestrygone 3: MY FAULT?! GRRR");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Laestrygone 1: STOP IT! FIRST ONE TO GET THE HUMANS GETS THEM GOT IT?!");
        System.out.println("Laestrygone 2: SURE!");
        System.out.println("Laestrygone 3: YEAH!");
        System.out.println("Narrator: * The Gigantic Laestrygones has started their barrage of stones *");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Soldier: COMMANDER! IT'S RAINING STONES!");
        System.out.println(player_name + ": TAKE COVER MEN!");
        System.out.println("* -30 soldiers have been crushed by the giant rocks hurled by Laestrygones *");
        player_men = player_men - 30;
        System.out.println(player_name + ": WE HAVE SUSTAINED TOO MUCH DAMAGE! RETREAT AT ONCE!");
        System.out.println("Narrator: * You have left the island *");
        promptAndWait();

        giantManEaters = true;
        achievementCounter++;
        achievementWrite();
    }

    // Method for Encounter with Circe(50% chance)
    public static void circe() throws Exception {

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Narrator: 10 days and 10 nights have passed.");
        System.out.println("Narrator: You are in the middle of the sea and an island in the mist is in view.");
        System.out.println(
                "Soldier: Commander! There's an island up ahead. There's a stone tower that can be seen that seems to be at the center of the island.");
        System.out.println(player_name + ": What kind of monstrosity is on this island now?");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Narrator: * You have docked at the shoreline *");
        System.out.println("Narrator: * A group of boars passes by *");
        System.out.println("Soldier: The island is peaceful at least.");
        System.out.println(player_name
                + ": People should be here too since there's a tower obviously made by man. What's more there's a food source of boar.");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Soldier: Let's rest here for a bit and catch some boar! I'm hungry!");
        System.out.println(player_name + ": Okay, men set up a camp and rest.");
        System.out.println("Soldiers: YES SIR!");
        System.out.println("Narrator: * You and your men have set up camp and cooked some boar *");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Narrator: * Night falls, you and your men take turns to sleep and be on patrol. *");
        System.out.println("Narrator: * Hermes then sneaked a herb in your pocket *");
        System.out.println("Narrator: * You failed to notice due to how quick Hermes was *");
        System.out.println("Narrator: * Morning came *");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Soldier: Oink! Oink!");
        System.out.println(player_name + ": Ughh- Why's there a boar in my face? Huh-");
        System.out.println("Narrator: * You exit the tent and a horde of boars swarms your camp  *");
        System.out.println(player_name + ": : What's going on here? Where's my men?");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Circe: You're looking right at them.");
        System.out.println(player_name + ": Gah! Who are you?!");
        System.out.println("Circe: You know it's rude to ask a woman's name without giving yours first, correct");
        System.out.println(player_name + ": ...Odysseus, commander of the fleet.");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Cice: Circe, the owner of this island. Hmm.");
        System.out.println("Narrator: * Circe stares at you intently  *");
        System.out.println(player_name + ": What?");
        System.out.println(
                "Cice: It's surprising, I certainly saw that you ate the boar of this island too but you didn't turn into a boar? Oh?");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Narrator: * A warm feeling is in your pocket, light emitting  *");
        System.out.println(player_name + ":  Huh?");
        System.out.println(
                "Cice: So that's what it was, Herme's all cure herb. It seems you're favored by the gods themselves.");
        System.out.println(player_name + ": Nevermind that, turn back my men to humans.");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println(
                "Circe: Hmm sure! But! In exchange, you have to stay here and do my bidding for a year. Deal?");
        System.out.println(player_name + ": Deal.");
        System.out.println("Narrator: * You have been bound to Circe by her magic to do her bidding for a year *");
        System.out.println("Narrator: * Your men have turned back to humans in exchange *");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Narrator: * A year has passed. *");
        System.out.println(
                "Circe: Wel, today's the day. You're free now Odysseus. Thank you for your assistance in my activities. ");
        System.out.println(player_name + ": It was the deal.");
        System.out.println(
                "Circe: True, here's a lead for you. Go to the Underworld and look for Teiresias there. He should know the way for you to get home safely. Use this to get to the underworld with your men and bring this sheep with you. Use this sheep to lure Teiresias out.");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println(player_name + ": Thank you Circe.");
        System.out.println("* +1 sheep *");
        System.out.println("Narrator: * You have obtained The necklace of Nyx *");
        System.out.println("Narrator: * You are now able to travel through in and out of the Underworld *");
        System.out.println("Narrator: * You have left the island *");
        sheep = 1;
        necklace_of_nyx = 1;
        promptAndWait();

        enchantingwiththeWitch = true;
        achievementCounter++;

        // Encouter with Teiresias
        if (Math.random() < 0.50) {

            System.out.print("\033[H\033[2J");

            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
            System.out.println("Narrator: 10 days and 10 nights have passed.");
            System.out.println("Narrator: You are now in the underworld.");
            System.out.println(player_name + ": We're here. Kill the sheep.");
            System.out.println("Narrator: * The cries of pain by the sheep echoed *");
            promptAndWait();

            System.out.print("\033[H\033[2J");

            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
            System.out.println("Narrator: * A silhouette comes into view *");
            System.out.println("Teiresias: I have been expecting you, Odysseus.");
            System.out.println(player_name + ": Then you must be Teiresias?");
            System.out.println("Teiresias: Yes I am.");
            promptAndWait();

            System.out.print("\033[H\033[2J");

            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
            System.out.println(player_name + ": Take this sheep and tell us where to go.");
            System.out.println(
                    "Teiresias: Continue down this path it should take you to your destination. Remember do not bring harm to the animals at the island of the Sun-god Helios. It will be your last if you do so.");
            System.out.println(player_name + ": ... we'll take heed.");
            System.out.println("Narrator: * You have sailed through the underworld *");
            promptAndWait();

            System.out.print("\033[H\033[2J");

            playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
            System.out.println("* You can see some of the wandering souls of those fallen like Achilles and Ajax *");
            System.out.println("* They seem to be empty *");
            System.out.println("* You have left the Underworld *");
            promptAndWait();

            theAbodeoftheDamned = true;
            achievementCounter++;
            achievementWrite();
        }

    }

    // Method for Encouter with the Sirens(50% chance)
    public static void sirens() throws Exception {

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Narrator: 10 days and 10 nights have passed.");
        System.out.println("Narrator: You are in the middle of the sea and the fog has engulfed your ship.");
        System.out.println("Soldier: Commander! It's too foggy to see what's ahead!");
        System.out.println("Siren: Commander! Straight ahead!");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println(player_name + ": What? Straight ahead?");
        System.out.println("Soldier: That's not me commander!");
        System.out.println(player_name
                + ":  Huh? Voice mimicry... Men! Cover your ears with wax! We're dealing with the Sirens! Once you're enchanted by their singing, you'll forget who you are and lure you down the sea and feast on you like piranhas.");
        System.out.println("Soldier: Yes commander!");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println(player_name
                + ": Now tie me up at the beam, let me hear them sing. I want to forget my bad memories. DO NOT let me jump out of this ship. That is an order");
        System.out.println("Narrator: * The sirens have started their ensemble *");
        System.out.println("Narrator: * Your men have been protected from charm *");
        System.out.println("Narrator: * You have been charmed *");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Narrator: * You have forgotten some part of your memories *");
        System.out.println("Narrator: * You have left the Siren Seas *");
        promptAndWait();

        songsofBewitchment = true;
        achievementCounter++;
        achievementWrite();

    }

    // Method for Encouter with Scylla and Charybdis(50% chance)
    public static void scyllaAndCharybdis() throws Exception {

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Narrator: 10 days and 10 nights have passed.");
        System.out.println("Narrator: You are in the middle of the sea and the fog has engulfed your ship.");
        System.out.println("Soldier: Commander! It's too foggy to see what's ahead!");
        System.out.println(player_name + ": Stay on guard. Anything could happen at any moment");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Narrator: * A whirlpool has started to form and waves are starting to get violent *");
        System.out.println("Soldier: Commander! The fog has started to clear up and it's terrible!");
        System.out.println(player_name + ": What's the situation?");
        System.out.println("Soldier: Where in between Charybdis and Scylla! AHHHH!");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("* -6 has been eaten by Scylla, the six-headed monster *");
        player_men = player_men - 6;
        System.out.println(
                player_name + ": FULL SPEED AHEAD! WE CAN''T WIN AGAINST THEM IN THIS CONDITION. PRIORITIZE ESCAPE!");
        System.out.println("Soldiers: YES COMMANDER!");
        System.out.println("Narrator: * You have passed through Scylla and Charybdis *");
        promptAndWait();

        inBetweentheTwoSeaMonster = true;
        achievementCounter++;
        achievementWrite();
    }

    // Method for Encounter with Island of Sun-god Helios(20% chance)
    public static void islandOfSungodHelios() throws Exception {

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Narrator: 10 days and 10 nights have passed.");
        System.out.println("Narrator: You are in the middle of the sea and the fog has engulfed your ship.");
        System.out.println("Soldier: Commander! There's a bright island ahead!");
        System.out.println(player_name + ": Light huh, we're probably at Sun-god Helios's Island. Let's rest here.");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Narrator: * You and your men have set up camp in the island *");
        System.out.println("Narrator: * You decided to take nap *");
        System.out.println(
                "Narrator: * While you're asleep the food ration has run out and your men decided to hunt instead *");
        System.out.println("Soldier: Hey over there! That should be a tasty meal for later! Hunt it!");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println("Helios: Huh? Who DARES to kill an animal in MY DOMAIN? Zeus shall hear about THIS!");
        System.out.println("Narrator: * Helios asked Zeus to sent a storm on your ship and your men *");
        System.out.println("Soldier: AHHHH!! COMMAANDERR!! SAVE US!!! AGGHHH!!");
        System.out.println("Narrator: * Your ship has been destroyed and the rest of your men have died *");
        promptAndWait();

        System.out.print("\033[H\033[2J");

        playerInventory(player_men, lotuseater_fruit, goldenfleece, sheep, necklace_of_nyx);
        System.out.println(player_name + ": ... What have I done...to deserve this punishment...");
        player_men = 1;
        System.out.println("Narrator: * You have left the island on a canoe *");
        promptAndWait();

        kelvin = true;
        achievementCounter++;
        achievementWrite();
    }

    // Method for Ending
    public static void ending() throws Exception {

        System.out.print("\033[H\033[2J");

        System.out.println("THE END");
        System.out.println("Thank You for Playing");
        System.exit(0);
    }

    // Method for information about the game
    public static void info() throws Exception {

        System.out.print("\033[H\033[2J");

        System.out.println(
                "In this text-based adventure game, you play as Odysseus and go on some of his epic adventures, deciding how to approach each encounter.");
        promptAndWait();

    }

    // Method for Credits
    public static void credits() throws Exception {

        System.out.print("\033[H\033[2J");

        System.out.println("Created by: ");
        System.out.println("Bajade, Darvin Kobe M.");
        System.out.println("De Jesus, Keene Keannu Kurt C.");
        System.out.println("Novillos, Kyle Christian T.");
        System.out.println("Reyes, Denver S.");
        System.out.println("Surabasquez, John Carlo");
        promptAndWait();
    }

    // Method for writing the achievements in a text file
    public static void achievementWrite() throws Exception {

        FileWriter myWriter = new FileWriter("Achievements.txt", false);

        myWriter.write("Achievements\n");
        myWriter.write("You have unlocked " + achievementCounter + " / 13\n");

    
        if (anIslandofLotus == true) {

            myWriter.write("[ An Island of Lotus ] - You have found the island of Lotus Eaters\n");
        }

        if (oneEyedMaster == true) {

            myWriter.write("[ One Eyed Master ] - You have found the Island of Polyphemus\n");
        }

        if (kingsofWinds == true) {

            myWriter.write("[ King of Winds ] - You have found the Island of King Aeolus\n");
        }

        if (thereisnoPlaceLikeHome == true) {

            myWriter.write("[ There is no place like home ] - You have returned to Ithaca\n");
        }

        if (giantManEaters == true) {

            myWriter.write("[ Giant Man-Eaters! ] - You have found the Island of Laestrygones\n");
        }

        if (enchantingwiththeWitch == true) {

            myWriter.write("[ Enchanting with the Witch ] - You have found the Island of Circe\n");
        }

        if (theAbodeoftheDamned == true) {

            myWriter.write("[ The Abode of the Damned ] - You have visited the underworld\n");
        }

        if (songsofBewitchment == true) {

            myWriter.write("[ Songs of Bewitchment ] - You have encountered the Sirens\n");
        }

        if (inBetweentheTwoSeaMonster == true) {

            myWriter.write("[ In-between the Two Sea Monsters ] - You have encountered the Scylla & Charybdis\n");
        }

        if (kelvin == true) {

            myWriter.write("[ 5,778 Kelvin ] - You have reached the Island of Sun-God Helios\n");
        }

        if (meetmyOneEyedFriend == true) {

            myWriter.write("[ Meet my One-Eyed Friend ] - You have tamed the Cyclops Polyphemus\n");
        }

        if (myFaithwasTrueandsowasmyEnd == true) {

            myWriter.write("[ My Faith was True, and so was my End ] - You have reached the Epilogue\n");
        }

        if(achievementCounter == 12){

            perfectRun = true;
        }

        if (perfectRun == true) {

            myWriter.write("[ My Faith was True, and so was my End ] - You have reached the Epilogue\n");
        }

        myWriter.close();
    }

    // Method for reading the achievements in a text file
    public static void achievementRead() throws Exception {

        FileReader reader = new FileReader("Achievements.txt");
        int achieve = reader.read();

        while(achieve != -1){

            System.out.print((char)achieve);
            achieve = reader.read();

        }
        
        reader.close();

    }

}