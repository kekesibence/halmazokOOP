package hu.petrik.Set;

import java.util.ArrayList;
import java.util.List;

public class Set<T> {
    private List<T> elements;

    public Set() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        if (!this.elements.contains(element)) {
            this.elements.add(element);
        }
    }

    public boolean remove(T element) {
        boolean isRemoved = false;

        if (elements.contains(element)) {
            elements.remove(element);
            isRemoved = true;
        }

        return  isRemoved;
    }

    public int getSize() {
        return elements.size();
    }

    public void clear() {
        this.elements.clear();
    }

    public boolean isElement(T element) {
        int i = 0;
        while (i < this.elements.size() && this.elements.get(i) != element) {
            i++;
        }

        return  i<this.elements.size();
    }

    public boolean isEmpty() {
        return elements.size() == 0;
    }

    public boolean isEquals(Set<T> otherSet) {
        return this.getSize() == otherSet.getSize() && this.isPartOf(otherSet);
    }

    public boolean isPartOf(Set<T> otherSet) {
        boolean isBigger = this.getSize() > otherSet.getSize();
        boolean isPartOf = false;
        if (!isBigger) {
            int i = 0;
            while (i < this.getSize() && otherSet.isElement(this.elements.get(i))) {
                i++;
            }
           isPartOf = i == this.getSize();
        }
        return isPartOf;
    }

    public Set<T> unio(Set<T> otherSet) {
        Set<T> unioSet = new Set<>();
        for (T element: this.elements){
            unioSet.add(element);
        }
        for (T element: otherSet.elements){
            unioSet.add(element);
        }
        return unioSet;
    }

    public Set<T> intersect(Set<T> otherSet) {
        Set<T> intersectSet = new Set<>();
        for (T element: this.elements) {
            for (T otherElement: otherSet.elements) {
                if (element == otherElement){
                    intersectSet.add(element);
                }
            }
        }
        return intersectSet;
    }

    @Override
    public String toString() {
        String s = "";
        for (T element: this.elements
              ) {
            s += element + "\n";
        }
        return s;
    }
}
