package HT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Seven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x=121.51886;
		double y=25.046010;
		String[]back=new String[4];
		back = findseven(x,y);
		for(int i=0;i<4;i++){
			System.out.println( back[i]);	
		}
		
		
	}
	
	public static String[] findseven(double x,double y){
		String[]back=new String[4];
		
		double search_range = 0.0004;
		int find = 0;
			try {
	            URL url = new URL("http://140.116.245.148/WebCourse/students/f74016213/test/7-11.csv");
	            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	            String line;
	            String s;
	            int c = 0;
			    System.out.println("Waiting");
			
				while((line = in.readLine())!=null && find == 0)
			    {
					if(c>0){
						
					
					String[] b = line.split(",");
			//		System.out.println(b[0]+" ");
					
					if( Math.abs(x-Double.parseDouble(b[0]))<=search_range){
						if (Math.abs(y-Double.parseDouble(b[1]))<=search_range){
							find = 1;
						/*	for(int i=0;i<b.length;i++){
								System.out.print(b[i]+" ");
								//return b;
							}*/
							back = b;
							break;
					//		System.out.println();
						}
					}
					
					if(find == 0){
						search_range = search_range*2;
					}
					}
					c++;
			    	
			         //   System.out.println(line);
			    }
	            in.close();
	        }
	        catch (MalformedURLException e) {
	            System.out.println("Malformed URL: " + e.getMessage());
	        }
	        catch (IOException e) {
	            System.out.println("I/O Error: " + e.getMessage());
	        }
			return back;
			
	}

}
