public class KthLargestElementInAnArray_215 {

    public int findKthLargest(int[] nums, int k) {
        NPriorityQueue nPQueue = new NPriorityQueue(nums, k);
        return nPQueue.removePriorElement();
    }

    private static class NPriorityQueue {

        private final int[] array;
        private final int n;

        private final int[] nPriorityQueue;
        private int length;

        NPriorityQueue(int[] array, int n) {
            this.array = array;
            this.n = n;
            this.nPriorityQueue = new int[n];
            this.length = 0;

            constructNPQueue();
        }

        private void constructNPQueue() {
            for (int element : array) {
                if (length < n) insertElement(element);
                else {
                    if (comparator(element, nPriorityQueue[0])) {
                        removePriorElement();
                        insertElement(element);
                    }
                }
            }
        }

        private void insertElement(int element) {
            nPriorityQueue[length] = element;
            upHeap(length++);
        }

        private int removePriorElement() {
            int priorElem = nPriorityQueue[0];
            nPriorityQueue[0] = nPriorityQueue[--length];
            downHeap();
            return priorElem;
        }

        private void upHeap(int insertedPos) {
            int curPos = insertedPos;
            while (curPos != 0) {
                int parentPos = (curPos - 1) / 2;
                if (comparator(nPriorityQueue[parentPos], nPriorityQueue[curPos])) {
                    swap(curPos, parentPos);
                    curPos = parentPos;
                } else break;
            }
        }

        private void downHeap() {
            int curPos = 0;
            while (curPos * 2 + 1 < length) {
                int lChildPos = curPos * 2 + 1, rChildPos = curPos * 2 + 2;
                int lChild = nPriorityQueue[lChildPos];
                int priorChild, priorPos;
                if (rChildPos < length) {
                    int rChild = nPriorityQueue[rChildPos];
                    boolean compare = comparator(lChild, rChild);
                    priorChild = compare ? rChild : lChild;
                    priorPos = compare ? rChildPos : lChildPos;
                } else {
                    priorChild = lChild;
                    priorPos = lChildPos;
                }
                if (comparator(nPriorityQueue[curPos], priorChild)) {
                    swap(curPos, priorPos);
                    curPos = priorPos;
                } else break;
            }
        }

        private void swap(int index1, int index2) {
            int temp = nPriorityQueue[index1];
            nPriorityQueue[index1] = nPriorityQueue[index2];
            nPriorityQueue[index2] = temp;
        }

        private boolean comparator(int n1, int n2) {
            return n1 > n2;
        }
    }

}
