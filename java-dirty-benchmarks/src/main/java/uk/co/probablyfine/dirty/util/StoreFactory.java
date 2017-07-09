package uk.co.probablyfine.dirty.util;

import uk.co.probablyfine.dirty.Store;

import java.io.File;
import java.io.IOException;

public class StoreFactory {

    public static <T> Store<T> createStore(Class<T> klass) throws IOException {
        File file = File.createTempFile("java-dirty-", ".db");
        file.deleteOnExit();
        return Store.of(klass).from(file.getCanonicalPath());
    }
    
    public static void main(String[] args) throws IOException {
    	File file = File.createTempFile("java-dirty-", ".db");
    	file.deleteOnExit();
    	System.out.println(file.getAbsolutePath());
    	System.out.println(file.getCanonicalPath());
	}
}
