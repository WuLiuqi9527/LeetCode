package tip.p251_300;

import java.util.Iterator;

/**
 * 给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。
 * 设计并实现一个支持 peek() 操作的顶端迭代器 --
 * 其本质就是把原本应由 next() 方法返回的元素 peek() 出来。
 * <p>示例:
 * 假设迭代器被初始化为列表 [1,2,3]。
 * 调用 next() 返回 1，得到列表中的第一个元素。
 * 现在调用 peek() 返回 2，下一个元素。在此之后调用 next() 仍然返回 2。
 * 最后一次调用 next() 返回 3，末尾元素。在此之后调用 hasNext() 应该返回 false。
 * 进阶：你将如何拓展你的设计？使之变得通用化，从而适应所有的类型，而不只是整数型？
 *
 * @author hc
 */
public class Demo284 {

    class PeekingIterator implements Iterator<Integer> {

        private Iterator<Integer> iterator;
        private Integer cache = null;

        public PeekingIterator(Iterator<Integer> iterator) {
            this.iterator = iterator;
        }

        public Integer peek() {
            if (cache == null) {
                cache = iterator.next();
            }
            return cache;
        }

        @Override
        public Integer next() {
            if (cache == null) {
                return iterator.next();
            }
            Integer tem = cache;
            cache = null;
            return tem;
        }

        @Override
        public boolean hasNext() {
            return cache != null || iterator.hasNext();
        }
    }
}
