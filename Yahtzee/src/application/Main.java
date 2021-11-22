package application;
	
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Scanner input = new Scanner(System.in);
		Hand h = new Hand();
		
		BorderPane root = new BorderPane();
		Scene s = new Scene(root,900,700);
		primaryStage.setScene(s);
		primaryStage.setTitle("Yahtzee");
		primaryStage.show();
		
		System.out.printf("Enter number of human players: ");
		int numPlayers = input.nextInt();
		System.out.printf("Enter number of human players: ");
		int numAIPlayers = input.nextInt();
		ArrayList<GenericPlayer> players = new ArrayList<GenericPlayer>(numPlayers+numAIPlayers);
		
		/**
		 * gets all names for human players
		 */
		for(int i = 0; i<numPlayers; i++) {
			System.out.printf("Enter name for player %d: ", i + 1);
			String name = input.next();
			
			Player p = new Player(name);
			players.add(p);
		}
		/**
		 * sets names for all AI players
		 */
		for(int i = 1; i<=numAIPlayers; i++) {
			PlayerAI pAI = new PlayerAI("",i);
			players.add(pAI);
		}
		
		/**
		 * GamePlay/creating hands for each player
		 */
		for(int i = 0; i<players.size(); i++) {
			GenericPlayer pl = players.get(i);
			if (pl instanceof PlayerAI) {
				
			}
		}

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
