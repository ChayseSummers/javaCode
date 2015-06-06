
public class treeNode {
	private int data;
	private treeNode left, right;

	
	public treeNode(int data, treeNode left, treeNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}


	public int getData() {
		return data;
	}


	public void setData(int data) {
		this.data = data;
	}


	public treeNode getLeft() {
		return left;
	}


	public void setLeft(treeNode left) {
		this.left = left;
	}


	public treeNode getRight() {
		return right;
	}


	public void setRight(treeNode right) {
		this.right = right;
	}


	public static void main(String[] args) {
		treeNode tn1 = new treeNode(100,null,null);
		treeNode tn2 = new treeNode(200,null,null);
		treeNode tn3 = new treeNode(300,null,null);
		
		treeNode root = tn1;
		tn1.setLeft(tn2);
		tn1.setRight(tn3);
		
		tn1=tn2=tn3 = null;
		System.out.println();
	}

}
