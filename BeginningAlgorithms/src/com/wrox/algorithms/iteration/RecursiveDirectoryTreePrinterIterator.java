package com.wrox.algorithms.iteration;

import java.io.File;

public final class RecursiveDirectoryTreePrinterIterator {
	private static final String SPACES = " ";

	public static void main(String[] args) {
		String name = "C:\\Users\\Ivaylo\\workspace\\BeginningAlgorithms";
		print(new File(name), "");
	}

	private static void print(File file, String indent) {
		assert file != null : "file can’t be null";
		assert indent != null : "indent can’t be null";
		System.out.print(indent);
		System.out.println(file.getName());
		if (file.isDirectory()) {
			print(new ArrayIterator<File>(file.listFiles()), indent + SPACES);
		}

	}

	private static void print(Iterator<File> iterator, String indent) {
		assert iterator != null : "files can’t be null";
		iterator.first();
		while(!iterator.isDone()){
			print(iterator.current(), indent);
			iterator.next();
		}

	}
}