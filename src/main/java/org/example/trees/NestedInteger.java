package org.example.trees;

import java.util.List;

public interface NestedInteger {

    // Constructor initializes an empty nested list.

    // Constructor initializes a single integer.

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
              public boolean isInteger();
 
              // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();
 
              // Set this NestedInteger to hold a single integer.
              public void setInteger(int value);
 
              // Set this NestedInteger to hold a nested list and adds a nested integer to it.
              public void add(NestedInteger ni);
 
              // @return the nested list that this NestedInteger holds, if it holds a nested list
              // Return empty list if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
}
