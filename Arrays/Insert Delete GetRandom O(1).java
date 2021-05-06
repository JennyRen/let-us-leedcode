class RandomizedSet {
    
    /*
    * 暴力解： 直接用array 和 randmom 暴力解， 時間複雜度：insert O(n)直接append 後面,  
    * remove(n^2) 因爲查找需要n的時間然後remove后還需要shifting， getRandom O(1)
    * 優化解： 用以個Map 來優化 Insert(), remove(), getRandom 都是O(1)
    */
    Random rand = new Random();
    Map<Integer, Integer> valueToIndex = new HashMap<>();
    List<Integer> values = new ArrayList<>();
    

    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valueToIndex.containsKey(val)) return false;
        values.add(val);
        valueToIndex.put(val, values.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valueToIndex.containsKey(val)) return false;
        int index = valueToIndex.get(val);
        
        int last = values.get(values.size() - 1);
        
        values.set(index, last);
        valueToIndex.put(last, index);
        
        // delete last
        values.remove(values.size() - 1);
        valueToIndex.remove(val);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int n = rand.nextInt(values.size());
        return values.get(n);
    }
}
