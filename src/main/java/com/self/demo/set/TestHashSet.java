package com.self.demo.set;

import java.util.*;

/**
 * @description:
 * @author: JavJoker
 * @date: Created in 2020/1/19 15:48
 * @version: V1.0
 * @modified By:
 */
public class TestHashSet {
    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        /**
         * 我们期望 getAddCount 方法返回的结果是 3，但实际上返回了 6。哪里出来问题？在 HashSet 内部， addAll
         * 方法是基于它的 add 方法来实现的，即使 HashSet 文档中没有指名其实现细节，倒也是合理的。
         * InstrumentedHashSet 中的 addAll 方法首先给 addCount 属性设置为 3，然后使用 super.addAll 方法调
         * 用了 HashSet 的 addAll 实现。然后反过来又调用在 InstrumentedHashSet 类中重写的 add 方法，每个元
         * 素调用一次。这三次调用又分别给 addCount 加 1，所以，一共增加了 6：通过 addAll 方法每个增加的元素都被
         * 计算了两次。
         */
        System.out.println(s.getAddCount());
    }

    // Broken - Inappropriate use of inheritance!
    static class InstrumentedHashSet<E> extends HashSet<E> {
        // The number of attempted element insertions
        private int addCount = 0;
        public InstrumentedHashSet() {
        }
        public InstrumentedHashSet(int initCap, float loadFactor) {
            super(initCap, loadFactor);
        }
        @Override
        public boolean add(E e) {
            addCount++;
            return super.add(e);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            addCount += c.size();
            return super.addAll(c);
        }
        public int getAddCount() {
            return addCount;
        }
    }
}
