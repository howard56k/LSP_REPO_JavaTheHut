package org.howard.edu.lsp.assignment5;
import java.util.ArrayList;
import java.util.List;

/**
 * This is my implemented IntegerSet class
 */
public class IntegerSet  {
	// Store the set elements in an ArrayList.
	private List<Integer> set = new ArrayList<Integer>();

    /**
     * The Default Constructor, to initialize an empty set
     */
	public IntegerSet() {
	}


    /**
     * Constructor if you want to pass in already initialized list of integers.
     * 
     * @param set takes in an ArrayList of integers used to initialize the IntegerSet.
     */
	public IntegerSet(ArrayList<Integer> set) {
		this.set = set;
	}

    /**
	 * Returns an Item from set by index
	 * 
	 * @param index is a int object, that is the index of a item from the set that you want returned
 	 * @return Interger value from the index of the Set
	 */
 	public Integer get(int index) {
        return set.get(index);
    }

    /**
     * Clears the internal representation of the set.
     */
    public void clear() {
        set.clear();
    };

    /**
     * Returns the length of the set.
     * 
     * @return interger of the length of the set
     */
    public int length() {
        return set.size();
    }; 

    /**
    * Two sets are equal if they contain all of the same values in ANY order.  This overrides the equal method from the Object class. 10 pts.

    * @param o takes in a Set to compare against the current set
    * @return boolean that is true if the 2 sets are equal, false otherwise;
    */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            // Checks if the object is being compared against itself
            return true;
        if (o == null || getClass() != o.getClass())
            // Checks if Obj is even comparable / is a Book
            return false;
        
        IntegerSet otherIntegerSet = (IntegerSet) o;

        if (otherIntegerSet.length() == set.size()){
            for (int i = 0; i < set.size(); i++) {
                if(otherIntegerSet.contains(set.get(i))){
                    continue;
                }else{
                //if not found it will break the look and return false
                    return false;
                }
		    }
        }else{
            // Checks if they are the same length and if not returns false since can not be equal
            return false;
        }

        //Since it was able to run through without breaking means the sets are equal
        return true;
    }; 

    /**
     * Returns true if the set contains the value, otherwise false. 5 pts.
     * 
     * @param value a value you want to check if it is in the IntergerSet
     * @return boolean that is true if the set contains the value, false otherwise;
     */
    public boolean contains(int value) {
        return set.contains(value);
    };    

    /**
     * Returns the largest item in the set. 5 pts.
     * 
     * @return int value of the largest value in the set
     */
    public int largest(){
        int largeVal = set.get(0);
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i) > largeVal) {
				largeVal = set.get(i);
			}
		}
		return largeVal;
    }; 


    /**
     * Returns the smallest item in the set. 5 pts.
     * 
     * @return int value of the smallest value in the set
     */
    public int smallest(){
        int smallVal = set.get(0);
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i) < smallVal) {
				smallVal = set.get(i);
			}
		}
		return smallVal;
    }; 


    /**
	 * Adds an item to the set or does nothing it already there. 5 pts.	
	 * 
	 * @param item is a int object that you want added to the set
	 */
 	public void add(int item) {
		if(!(set.contains(item))){
 			set.add(item);
		}
 	}

    /**
 	 * Removes an item from the set or does nothing if not there. 5 pts.e
 	 * 
 	 * @param item is a int object that you want removed from the set
 	 */
	public void remove(int item){
		if (set.indexOf(item) != -1) {
			set.remove(set.indexOf(item));
		}
		
	}

    /**
     * Creates the Set union. 11 pts
     *
     * @param intSetb The IntegerSet to union with this set.
     */
    public void union(IntegerSet intSetb) {
        for (int i = 0; i < intSetb.length(); i++) {
            if (!this.set.contains(intSetb.get(i))) {
                this.set.add(intSetb.get(i));
            }
        }
    }

    /**
     * Creates Set intersection, all elements in s1 and s2. 12 pts.
     *
     * @param intSetb The IntegerSet to intersect with this set.
     */
    public void intersect(IntegerSet intSetb) {
        ArrayList<Integer> intersection = new ArrayList<>();
        for (int i = 0; i < set.size(); i++) {
            if (intSetb.contains(set.get(i))) {
                intersection.add(set.get(i));
            }
        }
        this.set = intersection;
    }

    /**
     * Creates Set difference, i.e., s1 –s2. 12 pts.
     *
     * @param intSetb The IntegerSet to subtract from this set.
     */
    public void diff(IntegerSet intSetb) {
        ArrayList<Integer> difference = new ArrayList<>();
        for (int i = 0; i < set.size(); i++) {
            if (!intSetb.contains(set.get(i))) {
                difference.add(set.get(i));
            }
        }
        this.set = difference;
    }

    /**
     * Creates Set complement, all elements not in s1. 11 pts.
     *
     * @param intSetb The IntegerSet to compare against for the complement.
     */
    public void complement(IntegerSet intSetb) {
        ArrayList<Integer> complement = new ArrayList<>();
        for (int i = 0; i < intSetb.length(); i++) {
            if (!this.set.contains(intSetb.get(i))) {
                complement.add(intSetb.get(i));
            }
        }
        this.set = complement;
    }

    /**
	 * Returns true if the set is empty, false otherwise. 5 pts.
	 * 
	 * @return boolean whether the set is empty or not
	 */
	public boolean isEmpty() {
		if (set.size() == 0) {
			return true;
		}
		return false;
	}

    // Return String representation of your set.  This overrides the equal method from 
    // the Object class. 5 pts.
    // return String representation of your set
    @Override
    public String toString() {
        return set.toString();
    };	
    
}

