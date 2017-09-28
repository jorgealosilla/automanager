package br.com.alosilla.automanager.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsBuilder {
	private static final int INITIAL_CAPACITY = 5;
	
    public static List createDefaultArrayList() {
        return new ArrayList(INITIAL_CAPACITY);
    }

    public static Set createDefaultHashSet() {
        return new HashSet(INITIAL_CAPACITY);
    }
}
