public class AVL {
  static AVLNode root;


  public static class AVLNode {
    LinkedList LL;
    int height;
    AVLNode left;
    AVLNode right;


    AVLNode(LinkedList LL) {
      this.LL = LL;
      height = 1;
      left = null;
      right = null;
    }
  }


  int height(AVLNode N) {
    if (N == null)
      return 0;

    return N.height;
  }

  int max(int a, int b) {
    return (a > b) ? a : b;
  }

  int getBalance(AVLNode N) {
    if (N == null)
      return 0;

    return height(N.left) - height(N.right);
  }

  AVLNode leftRotate(AVLNode x) {
    AVLNode y = x.right;
    AVLNode T2 = y.left;

    // Perform rotation
    y.left = x;
    x.right = T2;

    //  Update heights
    x.height = max(height(x.left), height(x.right)) + 1;
    y.height = max(height(y.left), height(y.right)) + 1;

    // Return new root
    return y;
  }


  AVLNode rightRotate(AVLNode y) {
    AVLNode x = y.left;
    AVLNode T2 = x.right;

    // Perform rotation
    x.right = y;
    y.left = T2;

    // Update heights
    y.height = max(height(y.left), height(y.right)) + 1;
    x.height = max(height(x.left), height(x.right)) + 1;

    // Return new root
    return x;
  }

  private AVLNode doubleWithLeft(AVLNode AVLNode) {
    AVLNode.left = rightRotate(AVLNode.left);
    return leftRotate(AVLNode);
  }

  private AVLNode doubleWithRight(AVLNode avlnode) {
    avlnode.right = leftRotate(avlnode.right);
    return rightRotate(avlnode.right);
  }


  private AVLNode creatNewAVLNode(String[] data) {
    LinkedList list = new LinkedList();
    list.insert(data[0]);
    list.insert(data[1]);
    AVLNode newTreeNode = new AVLNode(list);
    return newTreeNode;
  }


  public void insert(String[] data) {
    root = insertRecursion(root, data);
  }

  AVLNode insertRecursion(AVLNode root, String[] data) {

//    // checking if root is null
    if (root == null)
      return root = creatNewAVLNode(data);


    if (data[0].substring(0, data[0].indexOf(".")).equals(root.LL.head.data.substring(0, root.LL.head.data.indexOf(".")))) {
      root.LL.insert(data[1]);
    } else if (data[0].charAt(0) > root.LL.head.data.charAt(0)) {
      root.right = insertRecursion(root.right, data);
      if (height(root.right) - height(root.left) == 2)
        if (data[0].charAt(0) > root.right.LL.head.data.charAt(0))
          root = rightRotate(root);
        else
          root = doubleWithRight(root);
    } else if (data[0].charAt(0) < root.LL.head.data.charAt(0)) {
      root.left = insertRecursion(root.left, data);
      if (height(root.left) - height(root.right) == 2)
        if (data[0].charAt(0) < root.left.LL.head.data.charAt(0))
          root = leftRotate(root);
        else
          root = doubleWithLeft(root);
    } else {
      return root;
    }


    return root;
  }


  public void inorder() {
    inorderRecursion(root);
  }


  private void inorderRecursion(AVLNode root) {
    if (root != null) {
      inorderRecursion(root.left);
      root.LL.display();
      inorderRecursion(root.right);
    }
  }

  public AVLNode searchForIP (String IP ) {
    AVLNode current = searchForIPRecursion(IP , root );
    if (current != null){
      return current;
    }else {
      return null ;
    }
  }

  private AVLNode searchForIPRecursion (String IP  ,AVLNode root){
    if ( root == null){
      return root ;
    }

    boolean x = root.LL.search(IP);
    if (x == true ){
      return root ;
    }

  AVLNode left = searchForIPRecursion(IP , root.left );
    if ( left != null && left.LL.search(IP) == true){
      return left ;
    }

   AVLNode right = searchForIPRecursion(IP , root.right);
    if ( right != null && right.LL.search(IP) == true ){
      return right ;
    }

    return root ;
  }

  public AVLNode searchForURl (String url){
    if ( root == null ){
      return root ;
    }
    else {
      AVLNode current = root ;
      current = searchForURLRec(root, url);
      if ( current != null){
        return current ;
      }
      else{
        return null ;
      }
    }

  }
  AVLNode searchForURLRec(AVLNode root, String url) {
    int rootIndex = root.LL.head.data.indexOf(".");

    String rootValue = root.LL.head.data.substring(0, rootIndex);
    int urlIndex = url.indexOf(".");
    String urlValue = url.substring(0, urlIndex);
    if (root == null || rootValue.equals(urlValue)) {
      return root;
    }
    if (root.left != null) {
      if (rootValue.charAt(0) > url.charAt(0)) {
        return searchForURLRec(root.left, urlValue);
      }
    }
    if (root.right != null) {
      if (rootValue.charAt(0) < url.charAt(0)) {
        return searchForURLRec(root.right, urlValue);
      }
    }
return root;
  }

  }

