package application;

public class ScoreCard {
	
	int[] upper = new int[6];
	// upper[0]=ones, upper[1]=twos, upper[2]=threes, upper[3]=fours, upper[4]=fives], upper[5]=sixes
	int[] lower = new int[6];
	// lower[0]=three of a kind, lower[1]=four of a kind, lower[2]= full house, lower[3]= small straight
	// lower[4]=large straight, lower[5]=chance
	
	
	public ScoreCard() {
		for (int i=0; i<6; i++) {
			upper[i]=0;
			lower[i]=0;
		}
	}
	
	public int getTotalScore() {
		int total = 0;
		for (int i=0; i<6; i++) {
			total+=upper[i]+lower[i];
		}
		return total;
	}
	
	public void setOnes(int amt) {
		upper[0]=amt;
	}
	
	public void setTwos(int amt) {
		upper[1]=amt;
	}
	
	public void setThrees(int amt) {
		upper[2]=amt;
	}
	
	public void setFours(int amt) {
		upper[3]=amt;
	}
	
	public void setFives(int amt) {
		upper[4]=amt;
	}
	
	public void setSixes(int amt) {
		upper[5]=amt;
	}
	
	public void setThreeOfAKind(int total) {
		lower[0]=total;
	}
	
	public void setFourOfAKind(int total) {
		lower[1]=total;
	}
	
	public void setFullHouse() {
		lower[2]=25;
	}
	
	public void setSmallStraight() {
		lower[3]= 30;
	}
	
	public void setLargeStraight() {
		lower[4]=40;
	}
	
	public void setChance(int total) {
		lower[5]=total;
	}
	
	
	
	
	
}
