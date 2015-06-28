package HT;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Gihon {
	public static void main(/*String[ ] argv*/String[] args) {
	/*	String s1=argv[1];
		String s2=argv[2];*/
		String s1="臺南市";
		String s2="北門區";
		deletefile();
		String[]back=new String[3];
		back = find(s1, s2);
		try {
			PrintWriter writer = new PrintWriter(new FileOutputStream("d:\\outputname.txt"));
			for(int i=0;i<3;i++){
				writer.println( back[i]);	
			}
			writer.flush();
			writer.close();
			} catch (FileNotFoundException e) {
			e.printStackTrace();
			}
		
		for(int i=0;i<3;i++){
			String t = back[i];
		//	String[] aArray = t.split(",");
			for(int j=0;j<8;j++){
				int a=t.indexOf("|");
			
			
			if(j==0||j==3||j==7){
				System.out.print(t.substring(0, a));	
			}
			t=t.substring(a+1, t.length());
			}
			
			
		}
	}
		
	
	private static void deletefile(){
		try{
		File file = new File("d:\\outputname.txt");
		if(file.delete()){
		}else{
		}
		}catch(Exception e){
		e.printStackTrace();
		}
		}
	
	public static String[] find(String s1,String s2){
		int c = 0;
		String[]back=new String[3];
		try{
		Scanner scanner = new Scanner(new FileInputStream("d:\\output2.csv"));
		while(scanner.hasNextLine() && c < 3){
		String line = scanner.nextLine();
		if(line.indexOf(s1) != -1){
    		if( line.indexOf(s2) != -1){
    			if (line.indexOf("||") == -1 && line.indexOf("St.") == -1 && line.indexOf("Rd.") == -1){
    		
					//		System.out.println(line);
    				back[c] = line;
		    //		b = line.split("|");			    		
		    		c++;
		    //		System.out.println(b.length);
		    /*		for(int i=0;i< back.length;i++)
		    			System.out.println( back[i]);
		    		System.out.println();*/
    			}
    		}
    	}
		
	//	System.out.println(line);
		}
		
		
		}catch(Exception e){
		e.printStackTrace();
		}
		return back;
	}
	
}
