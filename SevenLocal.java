package HT;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class SevenLocal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x=121.51886;
		double y=25.046010;
		deletefile();
		String[]back=new String[4];
		back = findseven(x,y);
		

	}
	
	private static void deletefile(){
		try{
		File file = new File("d:\\7-11output.txt");
		if(file.delete()){
	//		System.out.println(file.getName() + " is deleted!");
		}else{
	//	System.out.println("Delete operation is failed.");
		}
		}catch(Exception e){
		e.printStackTrace();
		}
		}
	
	public static String[] findseven(double x,double y){
		int c = 0;
		String[]back=new String[3];
		double search_range = 0.0004;
		int find = 0;
		try{
		Scanner scanner = new Scanner(new FileInputStream("d:\\7-11.csv"));
		String line = "";
	
		while(scanner.hasNextLine() && find == 0)
	    {
			line = scanner.nextLine();
			if(c>0){
			String[] b = line.split(",");
			if( Math.abs(x-Double.parseDouble(b[0]))<=search_range){
				if (Math.abs(y-Double.parseDouble(b[1]))<=search_range){
					find = 1;
					back = b;
					
					try {
						PrintWriter writer = new PrintWriter(new FileOutputStream("d:\\7-11output.txt"));
						for(int i=0;i<4;i++){
							writer.println(b[i]);
						}
						writer.flush();
						writer.close();
						} catch (FileNotFoundException e) {
						e.printStackTrace();
						}
					
					break;
				}
			}
			if(find == 0){
				search_range = search_range*2;
			}
			}
			c++;
	    }
		}catch(Exception e){
		e.printStackTrace();
		}
		return back;
	}
	}


