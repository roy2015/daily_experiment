package com.guo.roy.research.misc.cryptography;

import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 *
 * 堆对象
 * 1. 建堆
 * 2. 新增元素
 * 3. 删除元素
 * 4. 堆排序（建堆，排序）
 *
 * @author guojun
 * @date 2021/6/11
 */
public class TestSolutionHeap {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionHeap.class);

    /**
     * 我的堆
     */
    static class MyHeap {
        /**
         * 大小不定，随时新增元素
         */
        private int[] dataArray;

        /**
         * 堆大小
         */
        private int dataLength;

        private boolean asc;

        public MyHeap() {
            this.asc = true;
        }

        public MyHeap(boolean asc) {
            this.asc = asc;
        }

        /**
         * 带数组的建heap
         * @param dataArray
         */
        public MyHeap(int[] dataArray, boolean asc) {
            this.dataArray = Arrays.copyOfRange(dataArray, 0, dataArray.length);
            this.dataLength = dataArray.length;
            this.asc = asc;
            createHeap(asc);
        }

        /**
         * 构建堆
         * tips:
         * 1. 从第一个非叶子接的开始
         */
        private void createHeap (boolean isMinHeap) {
            int idx = dataLength /2 -1;
            int endIdx = dataLength - 1;
            for (int i = idx; i >= 0 ; i--) {
                if (isMinHeap) {
                    siftDownN(i, endIdx);
                } else siftDown(i, endIdx);


            }
        }


        /**
         * 沉降(大顶)
         * @param idx
         * @param endIdx
         */
        private void siftDown(int idx, int endIdx) {
            while (idx <= endIdx) {
                int maxIdx;
                int leftIdx = (idx << 1) + 1;
                int rightIdx = (idx << 1) + 2;
                if (leftIdx > endIdx) {
                    break;
                }

                if (rightIdx > endIdx) {
                    maxIdx = leftIdx;
                } else {
                    maxIdx = (dataArray[leftIdx] > dataArray[rightIdx]) ? leftIdx : rightIdx;
                }
                if (dataArray[idx] >= dataArray[maxIdx]) {
                    break;
                }
                int temp;
                temp = dataArray[idx];
                dataArray[idx] = dataArray[maxIdx];
                dataArray[maxIdx] = temp;
                idx = maxIdx;
            }
        }

        /**
         * 沉降(小顶)
         * @param idx
         * @param endIdx
         */
        private void siftDownN(int idx, int endIdx) {
            while (idx <= endIdx) {
                int maxIdx;
                int leftIdx = (idx << 1) + 1;
                int rightIdx = (idx << 1) + 2;
                if (leftIdx > endIdx) {
                    break;
                }

                if (rightIdx > endIdx) {
                    maxIdx = leftIdx;
                } else {
                    maxIdx = dataArray[leftIdx] < dataArray[rightIdx] ? leftIdx : rightIdx;
                }
                if (dataArray[idx] <= dataArray[maxIdx]) {
                    break;
                }
                int temp;
                temp = dataArray[idx];
                dataArray[idx] = dataArray[maxIdx];
                dataArray[maxIdx] = temp;
                idx = maxIdx;
            }
        }

        /**
         * 上浮，主要用于add元素时, 大顶
         */
        private void siftUp(int idx) {
            while (idx > 0) {
                int parentIdx = idx >>1;
                if ((idx & 1) == 0) {
                    parentIdx --;
                } else {}
                if (dataArray[idx] <= dataArray[parentIdx]) {
                    break;
                }
                int temp = dataArray[idx];
                dataArray[idx] = dataArray[parentIdx];
                dataArray[parentIdx] = temp;
                idx = parentIdx;
            }
        }

        /**
         * 上浮，主要用于add元素时 小顶
         */
        private void siftUpN(int idx) {
            while (idx > 0) {
                int parentIdx = idx >>1;
                if ((idx & 1) == 0) {
                    parentIdx --;
                } else {}
                if (dataArray[idx] >= dataArray[parentIdx]) {
                    break;
                }
                int temp = dataArray[idx];
                dataArray[idx] = dataArray[parentIdx];
                dataArray[parentIdx] = temp;
                idx = parentIdx;
            }
        }


        /**
         *
         * @param isMinHeap 是否小顶
         */
        private void doHeapSort(boolean isMinHeap) {
            for (int i = dataLength - 1; i >0 ; i--) {
                int temp = dataArray[0];
                dataArray[0] = dataArray[i];
                dataArray[i] = temp;

                if (isMinHeap) {
                    siftDownN(0, i - 1);
                } else siftDown(0, i - 1);

            }
        }

        /**
         * 新增元素
         */
        public void addEl(int el) {
            if (dataLength == 0) {
                dataArray = new int[]{el};
                dataLength++;
                return;
            }

            int[] newDataArray = new int[dataLength + 1];
            System.arraycopy(dataArray, 0, newDataArray,0, dataLength);
            dataArray = newDataArray;
            dataArray[dataLength] = el;
            dataLength ++;
            if (asc) {
                siftUpN(dataLength -1);
            } else {
                siftUp(dataLength - 1);
            }
        }



        /**
         * 删除元素
         */
        public int deleteEl() {
            if (dataLength == 0) {
                return -1;
            }

            int retVal = dataArray[0];
            int temp = dataArray[0];
            dataArray[0] = dataArray[dataLength -1];
            dataArray[dataLength -1] = temp;

            dataLength --;
            if (asc) {
                siftDownN(0, dataLength -1);
            } else {
                siftDown(0, dataLength -1);
            }
            dataArray = Arrays.copyOfRange(dataArray, 0, dataLength);
            return retVal;
        }

        /**
         * 堆排序
         * @return
         */
        public int[] heapSort(int[] dataArray) {
            this.dataArray = Arrays.copyOfRange(dataArray, 0, dataArray.length);
            this.dataLength = dataArray.length;
            createHeap(!asc);
            doHeapSort(!asc);
            return this.dataArray;
        }

        public void print() {
            logger.info("{}", dataArray);
        }

    }

    public static void main(String[] args) {
        MyHeap myHeap;
//        myHeap = new MyHeap(false);
//        logger.info("{}", myHeap.heapSort(new int[]{4,5,8,2,3,9,7,1}));

        myHeap = new MyHeap(false);
        myHeap.addEl(10);
        myHeap.print();
        myHeap.addEl(11);
        myHeap.print();
        myHeap.addEl(8);
        myHeap.print();
        logger.info("{}", myHeap.deleteEl());
        myHeap.print();
        myHeap.addEl(28);
        myHeap.print();


    }
}
