package com.behradkoohy;
import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Main {

    public static void main(String[] args) throws Exception{
//    	Construct the scanner to take input from the CMD
//		BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
	    Scanner scanner = new Scanner(System.in);
	    String initials = scanner.nextLine();
//		Construct the appropiate URL
	    String url = "https://www.ecs.soton.ac.uk/people/"+ initials;
//	    System.out.println(url);
	    URL page = new URL(url);
		BufferedReader in = new BufferedReader(new InputStreamReader(page.openStream()));
		String htmlData;
		boolean found = false;
		while ((htmlData = in.readLine()) != null) {
			if ((htmlData.length() >=11) && htmlData.startsWith("    <title>") && !(htmlData.startsWith("    <title>People |"))){
				boolean finished = false;
				int x = 11;
				while (!finished){
					System.out.print(htmlData.charAt(x));
					x++;
					if (htmlData.charAt(x) == '|'){
						finished = true;
						found = true;
					}
				}
			}
		}
		if (!found){
			System.out.println("Person was not found.");
		}

		in.close();
    }
}
