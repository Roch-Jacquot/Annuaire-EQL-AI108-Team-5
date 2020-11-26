package fr.eql.ai108.TestBinaryTree;

public class TestBinaryTree {
	
	public static void main(String[] args) {	
	//test avec des int	
		BinaryTree bt = new BinaryTree();
		bt.addInt(5);
		bt.addInt(3);
		bt.addInt(7);
		bt.addInt(1);
		bt.addInt(4);
		bt.addInt(6);
		bt.addInt(8);
		bt.traverse();
		//System.out.println("\r");
		//bt.traversePreOrder();
		//System.out.println("\n");
		//bt.traversePostOrder();
		System.out.println("\r");
		bt.traverseLevelOrder();
		
	//test avec des Strings
		BinaryTreeString bts = new BinaryTreeString();
		bts.add("b");
		bts.add("a");
		bts.add("f");
		bts.add("d");
		bts.add("e");
		bts.add("c");
		bts.add("g");
		
		bts.containsNodeString("d");
		bts.delete("d");
		bts.containsNodeString("d");
		System.out.println("\r");
		bts.traverse();
		System.out.println("\r");
		bts.traverseLevelOrder();
	}
}
