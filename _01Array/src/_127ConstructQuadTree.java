import java.util.Arrays;

class Node1 {
    public boolean val;
    public boolean isLeaf;
    public Node1 topLeft;
    public Node1 topRight;
    public Node1 bottomLeft;
    public Node1 bottomRight;

    public Node1() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node1(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node1(boolean val, boolean isLeaf, Node1 topLeft, Node1 topRight, Node1 bottomLeft, Node1 bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

public class _127ConstructQuadTree {

    /**
     * 构建四叉树
     * @param grid 二维网格
     * @return 四叉树的根节点
     */
    public Node1 construct(int[][] grid) {
        return buildQuadTree(grid, 0, 0, grid.length);
    }

    /**
     * 递归构建四叉树
     * @param grid 二维网格
     * @param x 当前子区域的左上角横坐标
     * @param y 当前子区域的左上角纵坐标
     * @param size 子区域的大小
     * @return 当前子区域的四叉树节点
     */
    private Node1 buildQuadTree(int[][] grid, int x, int y, int size) {
        // 如果子区域内所有值相同，则构建叶子节点
        if (isUniform(grid, x, y, size)) {
            return new Node1(grid[x][y] == 1, true);
        }

        // 否则，递归构建四个子区域的四叉树
        int newSize = size / 2;
        Node1 topLeft = buildQuadTree(grid, x, y, newSize);
        Node1 topRight = buildQuadTree(grid, x, y + newSize, newSize);
        Node1 bottomLeft = buildQuadTree(grid, x + newSize, y, newSize);
        Node1 bottomRight = buildQuadTree(grid, x + newSize, y + newSize, newSize);

        return new Node1(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    /**
     * 检查子区域内所有值是否相同
     * @param grid 二维网格
     * @param x 当前子区域的左上角横坐标
     * @param y 当前子区域的左上角纵坐标
     * @param size 子区域的大小
     * @return 子区域内所有值是否相同
     */
    private boolean isUniform(int[][] grid, int x, int y, int size) {
        int initialValue = grid[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (grid[i][j] != initialValue) {
                    return false;
                }
            }
        }
        return true;
    }

    // 测试方法
    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0}
        };

        _127ConstructQuadTree quadTree = new _127ConstructQuadTree();
        Node1 root = quadTree.construct(grid);

        // 打印四叉树（此处省略打印逻辑）
        System.out.println("四叉树构建完成");
    }
}
