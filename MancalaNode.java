package Mancala;
public class MancalaNode {
	String player;
	Integer pieces;
	Boolean pit;
	Integer boardNum;
	MancalaNode next;
	
	public MancalaNode(String player, Integer pieces, Boolean pit,Integer boardNum, MancalaNode next){
		this.player=player;
		this.pieces=pieces;
		this.pit=pit;
		this.boardNum=boardNum;
		this.next=next;
	}
	
	
}
