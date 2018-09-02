package com.vijfhart.casus.tree;
import java.util.*;
import static java.util.Spliterator.*;

import java.math.BigInteger;
import java.util.function.*;
import java.util.stream.*;

import com.vijfhart.casus.tree.file.PathNode;
import com.vijfhart.casus.tree.file.TreeNode;
import com.vijfhart.casus.tree.stat.*;

/**
 * NodeTree is an implementation of {@link Tree}.
 * It uses an anonymous inner class to implement a TreeIterator.
 * The descendantsOf method is used to generate a list of descendants of a node.
 * This method is also used to calculate summary measures of a node.
 *
 * @author Marko Draisma
 * @version 1.0
 */

public class NodeTree<T extends Node<T>> implements Tree<T>{
  

  private List<T> nodeList = new ArrayList<>();
  private List<T> descendantsOf;
  private T current;
  private Predicate<T> filter = x -> true;
  /**
   * empty constructor
   */
  public NodeTree(){}

  /**
   * This constructor can be used to generate a copy of a NodeTree.
   * @param list: a node list
   */
  public NodeTree(List<T> list){
   nodeList=new ArrayList<>(list);
  }
  public void setFilter(Predicate<T> filter){
	    this.filter=filter;
	  }
  /**
   * Adds a node to the tree.
   * NodeTree uses a List for its elements. The add method is delegated to this list.
   * @param t: the node to add to the tree
   */ 
  public void add(T t){
    nodeList.add(t);
  }
  /**
   * Adds all of the elements in the specified NodeTree to this NodeTree 
   * @param tree
   */
  public void addAll(NodeTree<T> tree) {
	  TreeIterator<T> iterator = tree.iterator();
	    while(iterator.hasNext()){
	    	nodeList.add(iterator.next());
	      }	  
  }
/*
  public Stream<TreeNode<T>> stream() {
	  TreeIterator<T> iterator = this.iterator();

	  class MyTreeNode  implements TreeNode<T> {
            private final T node;
            public MyTreeNode (T node) {
            	this.node = node;
            }
			@Override
			public T node() {
				return node;
			}
			@Override
			public String path(String separator) {
				return iterator.path(separator); 
			}
			@Override
			public String path(String separator, Function<T, String> f) {
				return iterator.path(separator, f); 
			}
			@Override
			public boolean isLeaf() {
				return iterator.isLeaf();
			}
			@Override
			public int level() {
				return iterator.level();
			}
			public String toString() { return node.toString(); }
		  }

		  class MyIterator  implements Iterator<TreeNode<T>> {
			  @Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			@Override
			public TreeNode<T> next() {
				return new MyTreeNode (iterator.next());
			}
			public void remove() { 
				iterator.remove(); 
			}
		  }
		  
  //   Iterator<TreeNode<T>> iteratorImp = new IteratorImpl(iterator);
	 // Omsmurfen Iterator naar Stream
	//  Stream<TreeNode<T>> targetStream = StreamSupport.stream(
		//	  Spliterators.spliterator(iteratorImp, nodeList.size(), ORDERED),
	      //    false);		    
	 // return targetStream;
	  
	  return StreamSupport.stream(Spliterators.spliterator(new MyIterator(),nodeList.size(),ORDERED|SORTED|SIZED|DISTINCT|NONNULL),false);
	  
  } 
  */
  
  // private method streamHelper krijgt TreeIterator<T> mee als parameter, 
  // en maakt op basis daarvan een Stream<TreeNode<T>> aan 
  
  private Stream<TreeNode<T>> streamHelper(TreeIterator<T> iterator){
  
     // lokale class MyTreeNode heeft een node (T) en kan bij de TreeIterator

     class MyTreeNode implements TreeNode<T> { 
       private final T node;

       MyTreeNode(T node){
         this.node = node;
       }
       public T node() { return node; }
       public String path(String separator) { return iterator.path(separator); }
       public String path(String separator, Function<T, String> function) { return iterator.path(separator, function); }
       public boolean isLeaf() { return iterator.isLeaf(); }
       public int level() { return iterator.level(); }
       public String toString() { return node.toString(); }
     }


     // lokale class MyIterator is een Iterator<TreeNode<T>> die bij elke next() een TreeNode teruggeeft

     class MyIterator implements Iterator<TreeNode<T>> { 
       public boolean hasNext(){ return iterator.hasNext(); }
       public TreeNode<T> next() { return new MyTreeNode(iterator.next()); }
       public void remove() { iterator.remove(); }
     } 

     return StreamSupport.stream(Spliterators.spliterator(new MyIterator(),nodeList.size(),ORDERED|SORTED|SIZED|DISTINCT|NONNULL),false);
  }
  
  
  // public stream() methods hebben een TreeIterator, 
  // passen daar eventueel wat van aan, 
  // en maken met streamHelper(...) een stream aan
  
  public Stream<TreeNode<T>> stream(){
     TreeIterator<T> iterator = iterator();
     return streamHelper(iterator);

  }

  public Stream<TreeNode<T>> stream(T startNode){
     TreeIterator<T> iterator = iterator();
     iterator.startWith(startNode);
     return streamHelper(iterator);
  }
  
  public Stream<TreeNode<T>> stream(T startNode, Comparator<T> comparator){
     TreeIterator<T> iterator = iterator();
     iterator.orderSiblingsBy(comparator);
     iterator.startWith(startNode);
     return streamHelper(iterator);
  }
  
  public Stream<TreeNode<T>> stream(Comparator<T> comparator){
     TreeIterator<T> iterator = iterator();
     iterator.orderSiblingsBy(comparator);
     return streamHelper(iterator);
  }



   /**
   * Generates a list of nodes descending a given node, including the given node itself.
   * It uses the startWith method to generate a sublist of the node itself and its descendants.
   * @param node: a node
   * @return a list of nodes descending and including the given node.
   */ 
//  public List<T> descendantsOf(T node){
//	 if (current == null ||
//		!current.equals(node)) {
//	    Tree<T> copy = new NodeTree<>(nodeList);
//	    TreeIterator<T> iterator = copy.iterator();
//	    iterator.startWith(node);
//	    List<T> list = new ArrayList<>();
//	    while(iterator.hasNext()){
//	      list.add(iterator.next());
//	    }
//	    descendantsOf = list;
//	 }
//    return descendantsOf;
//  } 

  // gebruik cache als node gelijk is aan vorige node waarmee descendantsOf is aangeroepen
  public List<T> descendantsOf(T node){
	  if(node==current){
		  return descendantsOf;
	  }
	  else{
		  current=node;
		  Tree<T> copy = new NodeTree<>(nodeList);
		  TreeIterator<T> iterator = copy.iterator();
		  iterator.startWith(node);
		  descendantsOf = new ArrayList<>();
		  while(iterator.hasNext()){
			  descendantsOf.add(iterator.next());
		  }
		  return descendantsOf;
	  }
  }
/**
   * A count of the nodes descending a given node.
   * It uses descendantsOf to get the list of nodes.
   * @param t: a node
   * @return the count of nodes descending the given node, excluding the given node.
   */

  public long descendantCount(T t){
    return descendantsOf(t).size()-1;
  }

 /**
   * Returns the sum of an attribute of the given node and all descendants, 
   * provided by the application using a lambda expression. 
   * @param  t: the node beneath which the sum is calculated.
   * @param  f: a ToDoubleFunction to extract a double value from a node
   * @return the sum of the extracted double values, for the given node and all descendants
   */
  public double descendantSum(T t, ToDoubleFunction<T> f){
    List<T> list = descendantsOf(t);
    double sum=0;
    for(T node:list){
      sum+=f.applyAsDouble(node);
    }
    return sum;
  }

   /**
   * Returns the sum of an attribute of the given node and all descendants, 
   * provided by the application using a lambda expression. 
   * @param  t: the node beneath which the sum is calculated.
   * @param  f: a ToLongFunction to extract a long value from a node
   * @return the sum of the extracted long values, for the given node and all descendants
   */

  public long descendantSum(T t, ToLongFunction<T> f){
    List<T> list = descendantsOf(t);
    long sum=0;
    for(T node:list){
      sum+=f.applyAsLong(node);
    }
    return sum;
  }

   /**
   * Returns the average of an attribute of the given node and all descendants, 
   * provided by the application using a lambda expression. 
   * @param  t: the node beneath which the sum is calculated.
   * @param  f: a ToDoubleFunction to extract a double value from a node
   * @return the sum of the extracted double values, divided by the count, for the given node and all descendants
   */

  public double descendantAverage(T t, ToDoubleFunction<T> f){
    return descendantSum(t, f)/(descendantCount(t) + 1);
  }

   /**
   * Returns the maximal value of an attribute of the given node and all descendants, 
   * provided by the application using a lambda expression. 
   * @param  t: the node beneath which the maximum is calculated.
   * @param  f: a ToDoubleFunction to extract a double value from a node
   * @return the maximum value, for the given node and all descendants
   */
  public double descendantMax(T t, ToDoubleFunction<T> f){
    List<T> list = descendantsOf(t);
    double max=Double.MIN_VALUE;
    for(T node:list){
      double val = f.applyAsDouble(node);
      if(val>max)max=val;
    }
    return max;
  }
 /**
   * Returns the maximal value of an attribute of the given node and all descendants, 
   * provided by the application using a lambda expression. 
   * @param  t: the node beneath which the maximum is calculated.
   * @param  f: a ToLongFunction to extract a long value from a node
   * @return the maximum value, for the given node and all descendants
   */
  public long descendantMax(T t, ToLongFunction<T> f){
    List<T> list = descendantsOf(t);
    long max=Long.MIN_VALUE;
    for(T node:list){
      long val = f.applyAsLong(node);
      if(val>max)max=val;
    }
    return max;
  }
  /**
   * Returns the minimal value of an attribute of the given node and all descendants, 
   * provided by the application using a lambda expression. 
   * @param  t: the node beneath which the maximum is calculated.
   * @param  f: a ToDoubleFunction to extract a double value from a node
   * @return the minimal value, for the given node and all descendants
   */
  public double descendantMin(T t, ToDoubleFunction<T> f){
    List<T> list = descendantsOf(t);
    double min=Double.MAX_VALUE;
    for(T node:list){
      double val = f.applyAsDouble(node);
      if(val<min)min=val;
    }
    return min;
  }
 /**
   * Returns the minimal value of an attribute of the given node and all descendants, 
   * provided by the application using a lambda expression. 
   * @param  t: the node beneath which the maximum is calculated.
   * @param  f: a ToLongFunction to extract a long value from a node
   * @return the minimal value, for the given node and all descendants
   */
  public long descendantMin(T t, ToLongFunction<T> f){
    List<T> list = descendantsOf(t);
    long min=Long.MAX_VALUE;
    for(T node:list){
      long val = f.applyAsLong(node);
      if(val<min)min=val;
    }
    return min;
  }
  /**
    * Returns a TreeIterator to loop through the node elements in a Tree.
    * The TreeIterator uses the iterator of the nodeList of de NodeTree.
    * With every loop information is saved about the current node and the ancestors of the current node.
    */

  public TreeIterator<T> iterator(){
     return new TreeIterator<T>(){
         
         private Iterator<T> iterator; 
         private T current;
         private List<T> ancestors = new ArrayList<>();
         private boolean nextCalled;
         private T startWith;
         private boolean firstNextCalled;
         private boolean started;

         /**
          * Initializer of this anonymous inner class.
          * The nodeList is sorted and the inner iterator is refreshed.
          */

         {
          Collections.sort(nodeList);
          iterator=nodeList.iterator();
         }
 
         /**
          * Specifies how siblings are to be sorted.
          * This method uses a local {@link TreeComparator} to specify the global ordering,
          * in which the given Comparator is used to specify the ordering of siblings.
          * @param comparator: a Comparator to specify the ordering of siblings.
		  * @throws IllegalStateException if this method is called after a call to next.
          */

         public void orderSiblingsBy(Comparator<T> comparator){
           // orderSiblingsBy can only be used as the first statement
           if (started){
             throw new IllegalStateException(
                "orderSiblingsBy can only be called as the first statement of a TreeIterator"
             );
           }
           TreeComparator<T> treeComparator = new TreeComparator<>(comparator);
           Collections.sort(nodeList, treeComparator);
           iterator=nodeList.iterator();
         }
         /**
          * Specifies at what start node the iterator will be looping through the NodeTree.
          *
          * @param startWith: the node where to start the iteration.
          * @throws IllegalStateException if this method is called after a call to next.
          */
         public void startWith(T startWith){
           if(firstNextCalled)
             throw new IllegalStateException(
              "startWith can only be called before the first call to next");
           List<T> list=new ArrayList<>();
           this.startWith=startWith;
           T node = null;
           while(iterator.hasNext()){
              node = iterator.next();
              if(childOfStartWith(node))
                list.add(node);
            }
           this.iterator=list.iterator();
           started=true;
         }


         private boolean childOfStartWith(T t){
           T node = t;
           if(node == startWith) return true;
           while(node.getParent() != null){
             if(node.getParent()==startWith) return true;
             node=node.getParent();
           }
           return false;
         }
  
        /**
         * Returns true if there are more nodes in the node list.
         * This method is delegated to the local iterator.
         */
         public boolean hasNext(){
           return iterator.hasNext();
         }
 
         /**
          * Retrieves the next node.
          * For convenience in other methods, the current node is saved, 
          * along with the ancestors of the current node.
          * @return the next node in the iteration
          * @throws NoSuchElementException if the iterattion has no more elements.
          */
         public T next(){
           if(iterator.hasNext()){
             ancestors.clear();
             current=iterator.next();
             fillAncestors(current);
             nextCalled=true;
             started=true;
             return current;
           }
           else throw new IllegalStateException("Last element has been reached");
         }
		 
         /**
          * Returns the relative level of the current node.
          * @return the level of the current node, relative to the node at which the iteration is started.
          */
         public int level(){
           return ancestors.size();
         }
         
         private void fillAncestors(T t){
           if(t==startWith) return ;
           T node=t;
           while(node.getParent()!=null){
             if(node.getParent()==startWith){
               ancestors.add(node.getParent());
               return;
             }
             ancestors.add(node.getParent());
             node=node.getParent();
           }
         }
 
         /**
          * Returns true if the node is a leaf node.
          * This method uses the size of the descendants of the current node.
		  * @return true if the node is a leaf node.
          */
         public boolean isLeaf(){
           return descendantCount(current)==0;
         }
 
         /**
          * Removes the current node.
          * @throws RuntimeException if this node is a parent of another node. 
          * @throws IllegalStateException if remove is called without a previous call to next
          */
         public void remove(){
            if(nextCalled){
              if(isLeaf()){
                nodeList.remove(current);
                iterator.remove();
                nextCalled=false;
              }
              else {
                throw new RuntimeException(String.format( "%s is a parent, so can't be removed", current));
              }
            }
            else {
              throw new IllegalStateException("remove can only be called after a call to next");
            }
         }
 
         /**
          * Returns the path from the ancestors to the current node.
          * This method uses toString as part of the node to be shown in the path
          * @param separator: the String to separate the parts of a path
          */
         public String path(String separator){
           StringBuilder sb = new StringBuilder();
           sb.append(new StringBuilder(separator).append(current));
           for(T t:ancestors){
              sb.insert(0,new StringBuilder(separator).append(t));
           }
           return sb.deleteCharAt(0).toString();
         }
 
         /**
          * Returns the path from the ancestors to the current node.
          * This method uses a Function implementation (lambda expression or method reference) 
		  * to specify what part of a node is shown in the path
          * @param f: a Function  to specify what String value 
          *                    of the node will be shown as part of the path. 
          * @param separator: the String to separate the parts of a path
          */
         public String path(String separator, Function<T,String> f){
           StringBuilder sb = new StringBuilder();
           sb.append(new StringBuilder(separator).append(f.apply(current)));
           for(T t:ancestors){
              sb.insert(0,new StringBuilder(separator).append(f.apply(t)));
           }
           return sb.deleteCharAt(0).toString();
         }

     };
  }
/*
	@Override
	public OptionalLongSummaryStatistics descendantLongStatistics(T t, Function<T,OptionalLong> f) {
		List<T> lijst = descendantsOf(t);
		OptionalLongSummaryStatistics ret =  lijst.parallelStream()
				                                  .map(node -> f.apply(node) )    // maak er een OptionalLong van
	 		                                      .collect(OptionalLongSummaryStatistics::new       //Supplier
				                                         ,OptionalLongSummaryStatistics::accept     //Accumulator
				                                         ,OptionalLongSummaryStatistics::combine); 
		
		
		return ret;
	}
  */
  public OptionalLongSummaryStatistics descendantLongStatistics(T t, Function<T,OptionalLong> function) {
	    return descendantsOf(t).stream()
	               .parallel()
	               .filter(e -> filter==null||filter.test(e))
	               .map(e ->function.apply(e))
	               .collect(OptionalLongSummaryStatistics::new, 
	                        OptionalLongSummaryStatistics::accept,  
	                        OptionalLongSummaryStatistics::combine);
	  }


	  public OptionalDoubleSummaryStatistics descendantDoubleStatistics(T t, Function<T,OptionalDouble> function) {
	    return descendantsOf(t).stream()
	               .parallel()
	               .filter(e -> filter==null||filter.test(e))
	               .map(e ->function.apply(e))
	               .collect(OptionalDoubleSummaryStatistics::new, 
	                        OptionalDoubleSummaryStatistics::add,  
	                        OptionalDoubleSummaryStatistics::combine);
	  }


	  public <R extends Comparable<R>> OptionalComparableSummaryStatistics<R> descendantComparableStatistics(T t, Function<T,Optional<R>> function){
	    return descendantsOf(t).stream()
	               .parallel()
	               .filter(e -> filter==null||filter.test(e))
	               .map(e -> function.apply(e))
	               .collect(OptionalComparableSummaryStatistics::new,
	                        OptionalComparableSummaryStatistics::add,
	                        OptionalComparableSummaryStatistics::combine);
	  }
}
