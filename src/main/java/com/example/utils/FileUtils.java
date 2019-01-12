package com.example.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class FileUtils {
	
	public static BufferedReader getBufferedReader(File file, String delimiter){
	BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		return br;
	}
	

}
