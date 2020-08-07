//Gaving an array, build the binary tree and find the input two number distance.
//https://leetcode.com/discuss/interview-question/algorithms/125084/given-a-binary-search-tree-find-the-distance-between-2-nodes

//Node class
public class BinaryNode{
  public int val;
  public BinaryNode left;
  public BinaryNode right; 
}
//Build BST
public BinaryNode Build_BST(int[] input, int start, int end)
{

  if (start > end) { 
        return null; 
  }
  int mid = (start + end) / 2;
  BinaryNode node = new BinaryNode();

  node.val = input[mid];
  node.left = Build_BST(input, start, mid -1);
  node.right = Build_BST(input, mid + 1, end);
  return node;
}
//Main function
public int main(int[] input)
{
  Arrays.sort(input);
  BinaryNode node = new BinaryNode();
  node = Build_BST(input, 0, input.length - 1);
  
  int ans = TwoDistanceBST(node, 2, 9);
  return ans;
}
public int TwoDistanceBST(BinaryNode node, int a, int b)
{
  if(a < b)
    TwoDistanceBST(node, b, a);

  int findMax = 0;
  int findMin = 0;

  //LCA
  if(node.val < a && node.val < b)
  {
    TwoDistanceBST(node.left, a, b);
  }
  else if(node.val > a && node.val > b)
  {
    TwoDistanceBST(node.right, a, b);
  }
  else
  {
    findMax = dfs(node, a, 0);
    findMin = dfs(node, b, 0);
  }	
  return findMax + findMin;
}
public int dfs(BinaryNode node, int target, int step)
{
  if(node.val == step)
    return step;

  if(node.right != null && node.val < target)
    return dfs(node.right, target ,step + 1);
  else if (node.left != null && node.val > target)
    return dfs(node.left, target ,step + 1);

  return step;
}
//Test case
public static void main(String[] args) {

		int[] array= new int[]{2,1,8,7,9,0};//{1,2,3,4,5,6,7,8}; //{2,1,8,7,9,0};
		int ans = main(array);
}
