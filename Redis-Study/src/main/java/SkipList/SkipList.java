package SkipList;

import java.util.Arrays;

/**
 * @author zwy
 * @version 1.0
 * @description: TODO
 * @date 2024/9/26 19:51
 */
public class SkipList {
    /**
     * 跳表索引最大高度为16
     */
    private static final int MAX_LEVEL = 16;
    /**
     * 每个节点添加一层索引高度的概率为二分之一
     */
    private static final float PROB = 0.5f;
    /**
     * 默认只有一层高度，一个结点
     */
    private int levelCount = 1;

    /**
     * 跳表最底层的头节点
     */
    private Node head = new Node();

    public SkipList() {}

    public class Node {
        private int data = -1;
        private Node[] forwards = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", maxLevel=" + maxLevel +
                    '}';
        }
    }

    public void add(int value){
        int level = randomLevel();

        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;

        Node[] maxOfMinArr = new Node[level];// 每一层中最后一个小于新节点值的节点
        Arrays.fill(maxOfMinArr, head);

        Node p = head;
        for(int i = level - 1; i >= 0; i--){
            while(p.forwards[i] != null && p.forwards[i].data < value){
                p = p.forwards[i];
            }
            maxOfMinArr[i] = p;// 找到新节点的插入位置
        }

        for(int i = 0; i < level; i++){
            newNode.forwards[i] = maxOfMinArr[i].forwards[i];// 新节点的 forward 指向下一个结点
            maxOfMinArr[i].forwards[i] = newNode;// 下一个结点定义为当前结点
        }

        if(levelCount < level){
            levelCount = level;
        }
    }
    /**
     * 理论来讲，一级索引中元素个数应该占原始数据的 50%，二级索引中元素个数占 25%，三级索引12.5% ，一直到最顶层。
     * 因为这里每一层的晋升概率是 50%。对于每一个新插入的节点，都需要调用 randomLevel 生成一个合理的层数。
     * 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
     * 50%的概率返回 1
     * 25%的概率返回 2
     *  12.5%的概率返回 3 ...
     * @return
     */
    private int randomLevel() {
        int level = 1;
        while(Math.random() < PROB && level < MAX_LEVEL){
            level++;
        }
        return level;
    }


    public Node get(int value){
        Node p = head;
        for(int i = levelCount - 1; i >= 0; i--){
            while(p.forwards[i] != null && p.forwards[i].data < value){
                p = p.forwards[i];
            }
        }
        if(p.forwards[0] != null && p.forwards[0].data == value){
            return p.forwards[0];
        }
        return null;
    }

    public void delete(int value){
        Node p = head;
        Node[] updateArr = new Node[levelCount];
        for(int i = levelCount - 1; i >= 0; i--){
            while(p.forwards[i] != null && p.forwards[i].data < value){
                p = p.forwards[i];
            }
            updateArr[i] = p;
        }

        if(p.forwards[0] != null && p.forwards[0].data == value) {
            for(int i = levelCount - 1; i >= 0; i--){
                if(updateArr[i].forwards[i] != null && updateArr[i].forwards[i].data == value){
                    updateArr[i].forwards[i] = updateArr[i].forwards[i].forwards[i];
                }
            }
        }

        while(levelCount > 1 && head.forwards[levelCount-1] == null){
            levelCount--;
        }
    }

    public void printAll() {
        Node p = head;
        //基于最底层的非索引层进行遍历，只要后继节点不为空，则速速出当前节点，并移动到后继节点
        while (p.forwards[0] != null) {
            System.out.println(p.forwards[0]);
            p = p.forwards[0];
        }

    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        for (int i = 0; i < 24; i++) {
            skipList.add(i);
        }

        System.out.println("**********输出添加结果**********");
        skipList.printAll();

        SkipList.Node node = skipList.get(22);
        System.out.println("**********查询结果:" + node+" **********");

        skipList.delete(22);
        System.out.println("**********删除结果**********");
        skipList.printAll();


    }
}
