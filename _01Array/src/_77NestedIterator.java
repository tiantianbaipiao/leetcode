import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 给你一个嵌套的整数列表 nestedList 。每个元素要么是一个整数，要么是一个列表；该列表的元素也可能是整数或者是其他列表。
 * 请你实现一个迭代器将其扁平化，使之能够遍历这个列表中的所有整数。
 */
public class _77NestedIterator implements Iterator<Integer> {

    // 存储扁平化后的数据
    private List<Integer> flatList;
    // 当前访问的位置
    private int index;

    public _77NestedIterator(List<NestedInteger> nestedList) {
        // 初始化flatList
        flatList = new ArrayList<>();
        // 初始化，递归展开所有嵌套列表
        flatten(nestedList);
        index = 0; // 设置初始位置为0
    }

    @Override
    public Integer next() {
        return flatList.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < flatList.size();
    }

    // 递归方法来展开嵌套列表
    private void flatten(List<NestedInteger> list) {
        for (NestedInteger ni : list) {
            if (ni.isInteger()) {
                // 如果是整数，则直接添加到flatList中
                flatList.add(ni.getInteger());
            } else {
                // 如果是列表，则递归调用flatten方法
                flatten(ni.getList());
            }
        }
    }
}
