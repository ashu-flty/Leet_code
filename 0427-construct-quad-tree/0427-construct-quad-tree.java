class Solution {
    public Node construct(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] prefixSum = buildPrefixSum(grid);

        return buildWithDFS(prefixSum, 0, rows - 1, 0, cols - 1);
    }
    
    // ps[i][j] is the sum grid[0][0] ... grid[i-1][j-1]
    private int[][] buildPrefixSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] ps = new int[rows+1][cols+1];

        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
                ps[row][col] = ps[row-1][col] + ps[row][col-1] - ps[row-1][col-1] + grid[row-1][col-1];
            }
        }
        
        return ps;
    }
    
    private Node buildWithDFS(int[][] prefixSum, int minRow, int maxRow, int minCol, int maxCol) {
        if (minRow > maxRow || minCol > maxCol) {
            return null;
        }
        
        int size = (maxRow - minRow + 1) * (maxCol - minCol + 1);
        int total = prefixSum[maxRow+1][maxCol+1] - prefixSum[maxRow+1][minCol] - prefixSum[minRow][maxCol+1] + prefixSum[minRow][minCol];
        
        Node root = new Node();
        if (total == size || total == 0) {
            if (total == size) {
                root.val = true;
            }
            root.isLeaf = true;
            return root;   
        }

        int midRow = (maxRow + minRow) / 2;
        int midCol = (maxCol + minCol) / 2;

        root.topLeft = buildWithDFS(prefixSum, minRow, midRow, minCol, midCol);
        root.topRight = buildWithDFS(prefixSum, minRow, midRow, midCol + 1, maxCol);
        root.bottomLeft = buildWithDFS(prefixSum, midRow+1, maxRow, minCol, midCol);
        root.bottomRight = buildWithDFS(prefixSum, midRow + 1, maxRow, midCol + 1, maxCol);
        
        return root;
    }
}