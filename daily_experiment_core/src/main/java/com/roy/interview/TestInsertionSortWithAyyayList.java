package com.roy.interview;

import org.slf4j.LoggerFactory;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2019/4/16.
 *
 * 从大到小排序 3，4，1 -》 1， 3， 4
 * 这是一个泛型类哦，可以兼容Integer, Long,Double,其他的自己扩展去！
 *
 */
public class TestInsertionSortWithAyyayList<T extends Number> {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestInsertionSortWithAyyayList.class);

    private ArrayList<T> list = new ArrayList<>();

    /**
     * 打印数值
     * @param array
     * @param
     */
    public static  void printArray(Object[] array) {
        for (Object t : array) {
            logger.debug("{}", t.toString());
        }
        logger.debug("==================");
    }

    /**
     * 打印list
     * @param list
     */
    public static void printList(List list) {
        for ( Object t : list) {
            logger.debug("{}", t.toString());
        }
        logger.debug("==================");
    }

    private void add (T arrayEl) {
        if (list.isEmpty()) {
            list.add(arrayEl);
        } else {
            int listLength = list.size();
            for (int i = 0; i < listLength; i++) {
                T listEl = list.get(i);
                if (listEl instanceof Integer) {
                    if ((Integer) arrayEl.intValue() < listEl.intValue()) {
                        list.add(i, arrayEl);
                        break;
                    }
                } else if (listEl instanceof Double) {
                    if ((Double) arrayEl.doubleValue() < listEl.doubleValue()) {
                        list.add(i, arrayEl);
                        break;
                    }
                } else if (listEl instanceof Long) {
                    if ((Long) arrayEl.longValue() < listEl.longValue()) {
                        list.add(i, arrayEl);
                        break;
                    }
                } else {
                    try {
                        throw new UnsupportedOperationException("不支持的类型");
                    } catch (UnsupportedOperationException e) {
                        logger.error("不支持的类型", e);
                    }
                }
            }
            if (list.size() == listLength) {//未扩容说明是最大的，直接加到末尾
                list.add(arrayEl);
            }
        }
    }


    public void  testInsertionSortUseArrayList( T[] array) throws OperationNotSupportedException {
        for (T arrayEl : array) {
            add(arrayEl);
        }
    }

    public ArrayList<T> getList() {
        return list;
    }
}
