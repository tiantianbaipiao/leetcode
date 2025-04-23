import java.util.Stack;

/**
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 */
public class _15IsValid {
  // 括号匹配用栈来存入左括号 栈的特性是先进后出
  public boolean isValid(String s) {
    // 判断是否为空
    if(s == null){
      return true;
    }
    // 初始化栈来存入左括号
    Stack<Character> stack = new Stack<>();
    for (char c: s.toCharArray()){
      if(c == '(' || c == '[' || c=='{'){
        stack.push(c);
      }else {
        if(stack.isEmpty()){
          return false; //如果全是右括号栈里就是空的就放回false
        }
        char top = stack.pop(); // 弹出栈顶元素
        if(c == ')' && top != '('||
            c == '}' && top != '{' ||
            c == ']' && top != '['
        ){
          return false;
        }
      }
    }
    // 如果栈为空则全部匹配完毕
    return stack.isEmpty();
  }
}
