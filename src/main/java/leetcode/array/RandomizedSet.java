package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 * <p>
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 */
public class RandomizedSet {
    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        boolean insert1 = set.insert(1);
        System.out.println(insert1);
        boolean insert2 = set.insert(2);
        System.out.println(insert2);
        boolean remove1 = set.remove(1);
        System.out.println(remove1);
        set.insert(5);
        int random = set.getRandom();
        System.out.println(random);
    }


    //map的k-v都是val
    HashMap<Integer, Integer> map;
    //list存val
    ArrayList<Integer> list;

    //构造器中初始化map，list
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    //插入
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, val);
            list.add(val);
            return true;
        }
        return false;
    }

    //删除
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            map.remove(val);
            //val为数值，list的remove参数为数值时不会调用object参数，
            // 数字只能当做索引，所以只能调用索引的方法
            list.remove(list.indexOf(val));
            return true;
        }
        return false;
    }

    public int getRandom() {
        //(int) (Math.random() * n):返回[0-n)随机数，是线程安全的
        //Random.nextInt(n)返回[0-n]随机数，不是线程安全的
        //new Random(n)的n是种子，表示随机算法起源数字，和返回随机数无关，不传会默认按照时间生成个种子
        int random = (int) (Math.random() * list.size());
        Integer randomValue = list.get(random);
        return map.get(randomValue);
    }

    //小结：这里用map和list来做是因要求时间负载度为O(1)，具体用白话解释清到底是个什么原理还没想好


}
