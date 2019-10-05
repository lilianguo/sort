class RankElementInStream {
    // Given a stream of integers, lookup the rank of a given integer x. 
    // Rank of an integer in stream is “Total number of elements less than or equal to x (not including x)”
  
        static class Node {  
            int data;  
            Node left, right;  
            int leftSize;  
        }  
          
        static Node newNode(int data)  
        {  
            Node temp = new Node();  
            temp.data = data;  
            temp.left = null; 
            temp.right = null;  
            temp.leftSize = 0;  
            return temp;  
        }  
          
        // Inserting a new Node.  
        static Node insert(Node root, int data)  
        {  
            if (root == null)  
                return newNode(data);  
          
            // Updating size of left subtree.  
            if (data <= root.data) {  
                root.left = insert(root.left, data);  
                root.leftSize++;  
            }  
            else
                root.right = insert(root.right, data);  
          
            return root;  
        }  
          
        // Function to get Rank of a Node x.  
        static int getRank(Node root, int x)  
        {  
            // Step 1.  
            if (root.data == x)  
                return root.leftSize;  
          
            // Step 2.  
            if (x < root.data) {  
                if (root.left == null)  
                    return -1;  
                else
                    return getRank(root.left, x);  
            }  
          
            // Step 3.  
            else {  
                if (root.right == null)  
                    return -1;  
                else {  
                    int rightSize = getRank(root.right, x);  
                    return root.leftSize + 1 + rightSize;  
                }  
            }  
        } 
        
        
    /////////

    // https://wdxtub.com/interview/14520604447071.html
    RankNode root = null;

    void track(int number){
        if (root == null){
            root = new RankNode(number);
        } else {
            root.insert(number);
        }
    }

    int getRankOfNumber(int number){
        return root.getRank(number);
    }

    public class RankNode {
        public int left_size = 0;
        public RankNode left, right;
        public int data = 0;
        public RankNode(int d){
            data = d;
        }

        public void insert(int d){
            if (d < data){
                if (left != null) left.insert(d);
                else left = new RankNode(d);
                left_size++;
            }
            else {
                if (right != null) right.insert(d);
                else right = new RankNode(d);
            }
        }

        public int getRank(int d){
            if (d == data){
                return left_size;
            }
            else if (d < data){
                if (left == null) return -1;
                else return left.getRank(d);
            }
            else {
                int right_rank = right == null ? -1 : right.getRank(d);
                if (right_rank == -1) return -1;
                else return left_size + 1 + right_rank;
            }
        }
    }
}