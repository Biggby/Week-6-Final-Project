package finalProject;

public class App {
    public static void main(String[] args) throws InterruptedException {
        // Initialize deck and players
        Deck deck = new Deck();
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        
        // Shuffle deck
        deck.shuffle();
        
        // Deal cards
        System.out.println("Dealing cards...");
        for (int i = 0; i < 26; i++) {
            player1.draw(deck);
            player2.draw(deck);
        }

        
        // Game starts here
        System.out.println("Game Start!\n");
        
        for (int i = 0; i < 26; i++) {
            System.out.println("Round " + (i + 1) + ":");
            
            Card card1 = player1.flip();
            Card card2 = player2.flip();
            
            // Players cards lay down
            System.out.print("Player 1: ");
            card1.describe();
            Thread.sleep(500);
            System.out.print("Player 2: ");
            card2.describe();
            
            // Compare cards and award points
            if (card1.getValue() > card2.getValue()) {
                player1.incrementScore();
                System.out.println("Player 1 wins this round!");
            } else if (card2.getValue() > card1.getValue()) {
                player2.incrementScore();
                System.out.println("Player 2 wins this round!");
            } else {
                System.out.println("It's a tie! No points awarded.");
            }
            
            // Print score
            System.out.println("\nCurrent scores:");
            System.out.println("Player 1: " + player1.getScore());
            System.out.println("Player 2: " + player2.getScore());
            System.out.println("------------------------");
        }
        
        // Compare final scores and announce winner
        System.out.println("\nGame Over!");
        System.out.println("Final Scores:");
        System.out.println("Player 1: " + player1.getScore());
        System.out.println("Player 2: " + player2.getScore());
        
        if (player1.getScore() > player2.getScore()) {
            System.out.println("Player 1 wins!");
        } else if (player2.getScore() > player1.getScore()) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("Draw!");
        }
    }
}
