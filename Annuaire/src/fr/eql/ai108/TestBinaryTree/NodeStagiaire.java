package fr.eql.ai108.TestBinaryTree;

public class NodeStagiaire {
	   Stagiaire stagiaire;
	    NodeStagiaire left;
	    NodeStagiaire right;
		int index;
		int indexRight;
		int indexLeft;
	 
	NodeStagiaire(Stagiaire stagiaire, int index) {
	    this.stagiaire = stagiaire;
	    right = null;
	    left = null;
	    this.index = index;
		this.indexRight = -1;
		this.indexLeft = -1;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	public NodeStagiaire getLeft() {
		return left;
	}

	public void setLeft(NodeStagiaire left) {
		this.left = left;
	}

	public NodeStagiaire getRight() {
		return right;
	}

	public void setRight(NodeStagiaire right) {
		this.right = right;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndexRight() {
		return indexRight;
	}

	public void setIndexRight(int indexRight) {
		this.indexRight = indexRight;
	}

	public int getIndexLeft() {
		return indexLeft;
	}

	public void setIndexLeft(int indexLeft) {
		this.indexLeft = indexLeft;
	}
	
	
}
