package Mancala;

//a class that creates a Mancala board
public class MancalaBoard{
	private MancalaNode a;
	private MancalaNode b;
	private MancalaNode c;
	private MancalaNode d;
	private MancalaNode e;
	private MancalaNode f;
	private MancalaNode pitA;
	private MancalaNode g;
	private MancalaNode h;
	private MancalaNode i;
	private MancalaNode j;
	private MancalaNode k;
	private MancalaNode l;
	private MancalaNode pitB;
	private java.util.ArrayList<MancalaNode> sideA;
	private java.util.ArrayList<MancalaNode> sideB;
	
	//constructor
	public  MancalaBoard(){
		sideA=new java.util.ArrayList<>();
		sideB=new java.util.ArrayList<>();
		
		a= new MancalaNode("player1", 4,false,1,null); 
		b= new MancalaNode("player1", 4,false,2,null); 
		c= new MancalaNode("player1", 4,false,3,null);
		d= new MancalaNode("player1", 4,false,4,null);
		e= new MancalaNode("player1", 4,false,5,null);
		f= new MancalaNode("player1", 4,false,6,null);
		pitA= new MancalaNode("player1", 0,true,13,null);
		g= new MancalaNode("player2", 4,false,7,null);
		h= new MancalaNode("player2", 4,false,8,null);
		i= new MancalaNode("player2", 4,false,9,null);
		j= new MancalaNode("player2", 4,false,10,null);
		k= new MancalaNode("player2", 4,false,11,null);
		l= new MancalaNode("player2", 4,false,12,null);
		pitB=new MancalaNode("player2", 0, true, 14, null);
		
		a.next=b;b.next=c;c.next=d;d.next=e;e.next=f;f.next=pitA;
		pitA.next=g;g.next=h;h.next=i;i.next=j;j.next=k; k.next=l; l.next=pitB;
		pitB.next=a;
		
		sideA.add(a);sideA.add(b);sideA.add(c);sideA.add(d);sideA.add(e);sideA.add(f);
		sideB.add(g);sideB.add(h);sideB.add(i);sideB.add(j);sideB.add(k);sideB.add(l);

	}
	
	//public method to determine if the game is over and if there's a winner
	public String isWinner(){
		Boolean A=true;
		Boolean B=true;
		for(MancalaNode n: sideA){
			if(n.pieces==0){
				continue;
			}
			else{
				A=false;
				break;
			}
		}
		if(A==true){
			return "Player 1 has won";
		}
		for(MancalaNode n: sideB){
			if(n.pieces==0){
				continue;
			}
			else{
				B=false;
				break;
			}
		}
		if(B==true){
			return "Player 2 has won";
		}
		
		return "Nobody has won yet";
	}
	
	//given a number corresponding to a position in the board, get the node of that position
	private MancalaNode getNode(Integer n){
		for(MancalaNode node : sideA){
			if(node.boardNum==n){
				return node;
			}
		}
		for(MancalaNode node : sideB){
			if(node.boardNum.equals(n)){
				return node;
			}
		}
		
		return null;
	}
	
	//determine if the board is empty
	public Boolean emptyBoard(){
		Boolean Empty=true;
		for(MancalaNode n: sideB){
			if(n.pieces==0){
				continue;
			}
			else{
				Empty=false;
				return Empty;			}
		}
		
		for(MancalaNode n: sideA){
			if(n.pieces==0){
				continue;
			}
			else{
				Empty=false;
				return Empty;
			}
		}
		return Empty;
	}
	
	//public method to pick a node, empty it and move its pieces
	public String pickNode(Integer n, String player){
		MancalaNode node =getNode(n);
		if (node!=null){
			String t=movePieces(node, player);
			return t;
		}
		else{
			return "DNE";
		}
	}
	
	//determine if there are no pieces in a MancalaNode
	public Boolean noPieces(MancalaNode n){
		if(n.pieces==0){
			return true;
		}
		return false;
	}
	//private method to empty a node and move its pieces
	private String movePieces(MancalaNode n, String player){
		if(!n.player.equals(player)){
			return "Not your side! You are not allowed to move this node!!!";
		}
		else{
			int orig=n.pieces;
			n.pieces=0;
			MancalaNode next=n.next;
			if(next==null){
				return "DNE";
			}
			for(int i=orig; i>=0; i--){
				addPieces(n.next);
				n=n.next;
			}
			if(n.pit==true && n.player.equals(player)){
				movePieces(n,player );
			}
		}
		return "OK";
		
	}
	//add a piece to a node
	public void addPieces(MancalaNode x){
		x.pieces++;
	}
	//print out how the board is looking
	public void BoardStanding(){
		System.out.println("Node 1 has " +a.pieces + " pieces");
		System.out.println("Node 2 has " +b.pieces + " pieces");
		System.out.println("Node 3 has " +c.pieces + " pieces");
		System.out.println("Node 4 has " +d.pieces + " pieces");
		System.out.println("Node 5 has " +e.pieces + " pieces");
		System.out.println("Node 6 has " +f.pieces + " pieces");
		System.out.println("Node 7 has " +g.pieces + " pieces");
		System.out.println("Node 8 has " +h.pieces + " pieces");
		System.out.println("Node 9 has " +i.pieces + " pieces");
		System.out.println("Node 10 has " +j.pieces + " pieces");
		System.out.println("Node 11 has " +k.pieces + " pieces");
		System.out.println("Node 12 has " +l.pieces + " pieces");
		System.out.println("Player 1's pit has " +pitA.pieces + " pieces");
		System.out.println("Player 2's pit has " +pitB.pieces + " pieces");

		
	}
	
}
