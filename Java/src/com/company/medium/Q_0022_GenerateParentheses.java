package com.company.medium;

import javafx.scene.control.TableRow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q_0022_GenerateParentheses {

    public static void main(String[] args) {
        List<String> list = new Q_0022_GenerateParentheses().generateParenthesis(5);
        System.out.print(list);
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        addParentheses(list, "", 0, 0, n);
        return list;
    }

    /**
     *
     * @param list 用于存储可行的括号方案
     * @param curStr 当前括号字符串
     * @param openCnt 用于记录当前还有多少个括号没闭合
     * @param closeCnt 用于记录当前已经闭合的括号数量
     * @param targetCnt 目标括号数 n
     */
    private void addParentheses(List<String> list, String curStr, int openCnt, int closeCnt, int targetCnt) {
        if (openCnt == 0 && closeCnt == targetCnt) {
            list.add(curStr);
            return;
        }
        if (openCnt < targetCnt) {
            addParentheses(list, curStr + "(", openCnt+1, closeCnt, targetCnt);
        }
        if (openCnt > 0 && closeCnt < targetCnt) {
            addParentheses(list, curStr + ")", openCnt-1, closeCnt+1, targetCnt);
        }
    }

}
