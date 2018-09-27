/**
 * @program: test1
 * @description:
 * @author: Chao Qian
 * @create: 2018-08-20 21:23
 **/
public class MyStack {

    class StackTest {
        private int[] data = null;
        private int maxSize = 0;   //栈容量
        private int top = -1;  //栈顶指针

        StackTest() {
            this(10);   //默认栈大小为10
        }

        StackTest(int initialSize) {
            if (initialSize >= 0) {
                this.maxSize = initialSize;
                data = new int[initialSize];
                top = -1;
            } else {
                throw new RuntimeException("初始化大小不能小于0：" + initialSize);
            }
        }

        public boolean empty() {
            return top == -1 ? true : false;
        }

        public boolean push(int e) {
            if (top == maxSize - 1) {
                throw new RuntimeException("栈已满，无法将元素入栈！");
            } else {
                data[++top] = e;
                return true;
            }
        }

        public int pop() {
            if (top == -1) {
                throw new RuntimeException("栈为空！");
            } else {
                return data[top--];
            }
        }

        public int peek() {
            if (top == -1) {
                throw new RuntimeException("栈为空！");
            } else {
                return data[top];
            }
        }
    }

    StackTest minStack = new StackTest(1024);
    StackTest maxStack = new StackTest(1024);
    StackTest valueStack = new StackTest(1024);

    public Integer getMax() {
        return maxStack.peek();
    }

    public Integer getMin() {
        return minStack.peek();
    }

    public boolean push(int e) {
        valueStack.push(e);
        minStack.push(e < (minStack.empty() ? Integer.MAX_VALUE : minStack.peek())
                ? e : minStack.peek());
        return maxStack.push(e > (maxStack.empty() ? Integer.MIN_VALUE : maxStack.peek())
                ? e : maxStack.peek());
    }

    public Integer pop() {
        maxStack.pop();
        minStack.pop();
        return valueStack.pop();
    }
}
