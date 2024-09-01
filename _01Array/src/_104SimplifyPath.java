import java.util.Stack;

/**
 * 给你一个字符串 path ，
 * 表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 */
public class _104SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        // 分割路径字符串
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) {
                continue; // 忽略空字符串和 "."
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // 移除上一级目录
                }
            } else {
                stack.push(part); // 添加当前目录
            }
        }

        // 构建简化后的路径
        StringBuilder simplifiedPath = new StringBuilder();

        // 如果栈不为空，则构建路径
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                simplifiedPath.insert(0, "/" + stack.pop());
            }
        }

        // 如果栈为空，则返回 "/"
        return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
    }

    public static void main(String[] args) {
        _104SimplifyPath solution = new _104SimplifyPath();
        String path = "/home/";
        String simplifiedPath = solution.simplifyPath(path);
        System.out.println(simplifiedPath); // 输出: "/home"
    }
}
