package Mancala;
//a class that mimics a node in a mancala board
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
