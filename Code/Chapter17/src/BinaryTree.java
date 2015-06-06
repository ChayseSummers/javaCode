
public class BinaryTree {

	private treeNode root;
	
	public void addBST(int val){
		treeNode newNode = new treeNode (val, null,null);
		if(root == null)
			root = newNode;
		else{
			treeNode cursor = root;
			boolean done = false;
			while(!done){
				if(val<=cursor.getData()){//go left
					if(cursor.getLeft() == null){
						cursor.setLeft(newNode);
						done = true;
					}
					else
						cursor = cursor.getLeft();
				}
				else{//go right
					if(cursor.getRight() == null){
						cursor.setRight(newNode);
						done = true;
					}
					else
						cursor = cursor.getRight();
				}
			}
		}
	}
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		for (int i = 1; i <= 10; i++){
			int val = (int)(Math.random()*100);
			System.out.println(val);
			bt.addBST(val);
		}
		System.out.println();

	}

}
