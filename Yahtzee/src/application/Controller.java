package application;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Label;

public class Controller {
	public int amtHum=0;
	public int amtAI=0;
	public int amtTotal=0;
	public ArrayList<String> playerNameStrings=new ArrayList<String>();
	public ArrayList<Label> playerNameLabels= new ArrayList<Label>();
	public ArrayList<Player> humPlayersList = new ArrayList<Player>();
	public ArrayList<Scene> humScenes = new ArrayList<Scene>();
	public ArrayList<Scene> AiScenes = new ArrayList<Scene>();
}
