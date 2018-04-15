package com.vijfhart.casus.tree;

public interface LevelComparable<T> {
	/**
	 * Vergelijk op basis van niveau. Siblings hebben return 0
	 * @param o
	 * @return
	 */
	int compareLevelTo(T o);
}
