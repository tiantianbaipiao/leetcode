package suanfa;

public class _20ThreeStacks {
  private int[] data;
  private int stackSize;
  private int[] tops;

  // Constructor to initialize the three stacks
  public _20ThreeStacks(int stackSize) {
    this.stackSize = stackSize;
    this.data = new int[stackSize * 3]; // Allocate space for three stacks
    this.tops = new int[]{0, stackSize, stackSize * 2}; // Initialize top indices
  }

  // Push element x into stackNum
  public void push(int stackNum, int value) {
    if (tops[stackNum] < (stackNum + 1) * stackSize) {
      data[tops[stackNum]] = value;
      tops[stackNum]++;
    } else {
      System.out.println("Stack " + stackNum + " is full.");
    }
  }

  // Pop element from stackNum
  public int pop(int stackNum) {
    if (!isEmpty(stackNum)) {
      tops[stackNum]--;
      return data[tops[stackNum]];
    } else {
      System.out.println("Stack " + stackNum + " is empty.");
      return -1; // Return -1 or throw an exception based on requirements
    }
  }

  // Check if stackNum is empty
  public boolean isEmpty(int stackNum) {
    return tops[stackNum] == stackNum * stackSize;
  }

  // Peek at the top element of stackNum
  public int peek(int stackNum) {
    if (!isEmpty(stackNum)) {
      return data[tops[stackNum] - 1];
    } else {
      System.out.println("Stack " + stackNum + " is empty.");
      return -1; // Return -1 or throw an exception based on requirements
    }
  }
}
