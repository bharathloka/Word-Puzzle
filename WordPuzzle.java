import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;
import java.util.*;


public class WordPuzzle {
	static char data[][];
	static int row,col;
	public static void main(String args[]) throws FileNotFoundException{
		MyHashTable<String> H = new MyHashTable<>( );
		String filePath = "Dictionary.txt";
		
		File file = new File(args[0]);
        Scanner scanner  = new Scanner(file);
        
        while(scanner.hasNext())
        {
            String word = scanner.next(); 
            H.insert(word);
            
        }
		
		System.out.println(H.size());
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the row and coloumn sizes of the grid");
		row=sc.nextInt();
		col=sc.nextInt();
		data = new char[row][col];
		createpuzzle(row,col);
		printpuzzle();
		Set<String> result=FindwordsAlgorithm1(H);
		//Set<String> result2=findWordsAlgorithm2(H);
		System.out.println(result);
	}

	

	private static Set<String> FindwordsAlgorithm1(MyHashTable<String> h) {
		//List<String> output=new ArrayList<>();
		Set<String> output = new HashSet<String>();
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){

					if(h.contains(String.valueOf(data[i][j]))){
						
						output.add(String.valueOf(data[i][j]));
					}
					String temp =Character.toString(data[i][j]);
					
					int j1=j+1;
					 
					StringBuilder temp1=new StringBuilder(temp);//east
					while(j1<col){
						temp1.append(data[i][j1]);
						if(h.contains(temp1.toString())){
							output.add(temp1.toString());
						}
						j1++;
					}
					j1=j-1;
					StringBuilder temp2=new StringBuilder(temp);//west
					while(j1>=0){
						
						temp2.append(data[i][j1]);
						if(h.contains(temp2.toString())){
							output.add(temp2.toString());
						}
						j1--;
					}
					int i1=i+1;
					StringBuilder temp3=new StringBuilder(temp);//south
					while(i1<row){
						
						temp3.append(data[i1][j]);
						if(h.contains(temp3.toString())){
							output.add(temp3.toString());
						}
						i1++;
					}
					i1=i-1;
					StringBuilder temp4=new StringBuilder(temp);//north
					while(i1>=0){
						
						temp4.append(data[i1][j]);
						if(h.contains(temp4.toString())){
							output.add(temp4.toString());
						}
						i1--;
					}
					StringBuilder temp5=new StringBuilder(temp);//north east
					i1=i-1;
					j1=j+1;
					while(i1>=0&&j1<col){
						temp5.append(data[i1][j1]);
						if(h.contains(temp5.toString())){
							output.add(temp5.toString());
						}
						i1--;
						j1++;
					}
					StringBuilder temp6=new StringBuilder(temp);//south east
					i1=i+1;
					j1=j+1;
					while(i1<row&&j1<col){
						temp6.append(data[i1][j1]);
						if(h.contains(temp6.toString())){
							output.add(temp6.toString());
						}
						i1++;
						j1++;
					}
					StringBuilder temp7=new StringBuilder(temp);//North west
					i1=i-1;
					j1=j-1;
					while(i1>=0&&j1>=0){
						temp7.append(data[i1][j1]);
						if(h.contains(temp7.toString())){
							output.add(temp7.toString());
						}
						i1--;
						j1--;
					}
					StringBuilder temp8=new StringBuilder(temp);//South west
					i1=i+1;
					j1=j-1;
					while(i1<row&&j1>=0){
						temp8.append(data[i1][j1]);
						if(h.contains(temp8.toString())){
							output.add(temp8.toString());
						}
						i1++;
						j1--;
					}
				}
			}
		
		return output;
	}

	
	
	
	
	
	
	
	private static void printpuzzle() {
		System.out.println("The word puzzle is");
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				System.out.print(data[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	private static void createpuzzle(int row, int col) {
		for(int i = 0;i < row;i++)
	    {
	        for(int j = 0;j < col;j++)
	        {
	        	data[i][j] = (char) (97 + (int)(Math.random() * ((122 - 97) + 1)));
	        }
	    }
		
	}

	
}
