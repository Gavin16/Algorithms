package leetcode.oneMoreHundred;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * AC自动机实现多模式匹配
 *
 * (1) 字符串多模式匹配仅考虑a-z 26 个英文字母
 *
 */
public class ACMachine {

    /** 根节点不存储任何信息用 '/' 标识 */
    private AcNode root;

    public ACMachine(HashSet<String> templateStrs){
        root = new AcNode('/');
        for(String str : templateStrs){
            if(str.length() > 0){
                insert(str.toCharArray());
            }
        }
        // 构建完Trie树后增加失败指针
        buildFailurePointer();

    }


    /** 插入单个模式串 */
    public void insert(char[] text) {
        AcNode p = root;
        for (int i = 0; i < text.length; ++i) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                AcNode newNode = new AcNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    private void buildFailurePointer() {
        Queue<AcNode> queue = new LinkedList<>();
        root.fail = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            AcNode p = queue.remove();
            for (int i = 0; i < 26; ++i) {
                AcNode pc = p.children[i];
                if (pc == null) continue;
                if (p == root) {
                    pc.fail = root;
                } else {
                    AcNode q = p.fail;
                    while (q != null) {
                        AcNode qc = q.children[pc.data - 'a'];
                        if (qc != null) {
                            pc.fail = qc;
                            break;
                        }
                        q = q.fail;
                    }
                    if (q == null) {
                        pc.fail = root;
                    }
                }
                queue.add(pc);
            }
        }
    }




    class AcNode {
        /** 当前节点字符存储内容 */
        public char data;
        /**  字符集只包含a~z这26个字符 */
        public AcNode[] children = new AcNode[26];
        /** 结尾字符为true */
        public boolean isEndingChar = false;
        /** 当isEndingChar=true时，记录模式串长度 */
        public int length = -1;
        /** 失败指针 */
        public AcNode fail;
        public AcNode(char data) {
            this.data = data;
        }
    }
}
