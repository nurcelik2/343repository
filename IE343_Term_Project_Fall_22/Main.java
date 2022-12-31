import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
public static void main(String[] args) throws IOException{
        List<List<String>> list = readValues();
                
        System.out.println(list.get(0));
                
		List<Double> popularity_no = new ArrayList<Double>();
		List<Double> sarký_sure = new ArrayList<Double>();
		
		for(int i=1;i<list.size();i++) {
			popularity_no.add(Double.parseDouble(list.get(i).get(4))); 
			sarký_sure.add(Double.parseDouble(list.get(i).get(5)));
			
		}
		
		
		ArrayList <Double> deger = new ArrayList <Double> ();
		Double[][] deger_sorted=new Double [50][2];
		
		for(int i=0;i<50;i++) {
			
			deger.add(popularity_no.get(i)/(sarký_sure.get(i)/60000));
			
		}
		int index_no=0;
		Double max_deger=0.0;
		ArrayList <Double> deger_silinicek = new ArrayList <Double> ();
		
		for(int i=0;i<50;i++) {
			
			deger_silinicek.add(deger.get(i));
			
			}
		
		for(int k=0;k<50;k++) {
			
			for(int l=0;l<50 ;l++) {
				
				if(max_deger<deger_silinicek.get(l) && deger_silinicek.get(l)==deger.get(l)) {
					max_deger=deger_silinicek.get(l);
					index_no=l;
					
				}

			}
			
			deger_sorted[k][0]= (double) index_no;
			deger_sorted[k][1]= max_deger;
			deger_silinicek.set(index_no,0.0);	
			max_deger=0.0;
			
		}
		
		double total_sure=0.0;
		int sarký_sayýsý=0;
		double total_deger=0;
		
		for(int i=0;i<50;i++) {
			
			double index_double0=deger_sorted[i][1];
			int index_int0=(int) index_double0;
			
			double index_double1=deger_sorted[i][0];
			int index_int1=(int) index_double1;
				
			if(total_sure<=30 && (30-total_sure>(sarký_sure.get(index_int0)/60000))) {

				total_sure=total_sure + (sarký_sure.get(index_int0)/60000);
				
				total_deger=total_deger+popularity_no.get(index_int1);
				
			}
			
		}
		
		double kaybedilen_value=((30-(total_sure))*60*0.02);
		double album_deger=total_deger-(kaybedilen_value);
		
		
		
		
		//PART2//
		
		
		List<List<String>> list1 = readSequential();
		double [][] sýralama_degerleri=new double [50][50];;
		
		List<ArrayList<Double>> sequential_data = new ArrayList<ArrayList<Double>>();
		for (int i=1;i<list1.size();i++){
			ArrayList<Double> row = new ArrayList<>();
			for (int j=1;j<list1.get(0).size();j++){
				row.add(Double.parseDouble(list1.get(i).get(j)));
				sýralama_degerleri[i-1][j-1]=Double.parseDouble(list1.get(i).get(j));
		
			}
			sequential_data.add(row);
			
		}
		System.out.println(sequential_data.get(0).get(1));
		
		
		int [] caldý_calmadý= new int [50];
		int [] doldu_dolmadý= new int [50];
		
		for(int i=0;i<50;i++) {
			
			caldý_calmadý[i]=0;		//þarkýlar için
			doldu_dolmadý[i]=0;		//sýralar için
			
		}
		
		double [][] sarký_degerleri=new double[2500][3];  //þarkýlardan 1 den fazla olucak þekilde sýralandý
		double [][] sarký_sýralama=new double [50][3];   //þarkýlardan 1 tane olucak þekilde sýralanýcak
	
		for(int m=0;m<2500;m++) {
			for(int k=0;k<50;k++) {
				for(int l=0;l<50;l++) {
			
					if(sýralama_degerleri[l][k]>=sarký_degerleri[m][1]) {
						
						sarký_degerleri[m][0]=l;
						sarký_degerleri[m][1]=sýralama_degerleri[l][k];
						sarký_degerleri[m][2]=k;
						
					}
				}
			}	
			sýralama_degerleri[(int) sarký_degerleri[m][0]][(int) sarký_degerleri[m][2]]=-1;
		}	
		
		int hangi_indexde=0;
		
		for(int n=0;n<50;n++) {
			for(int m=hangi_indexde;m<2500;m++) {
				
				if(doldu_dolmadý[(int) sarký_degerleri[m][2]]==0 && caldý_calmadý[(int) sarký_degerleri[m][0]]==0) {
					
					sarký_sýralama[n][0]=sarký_degerleri[m][0];
					sarký_sýralama[n][1]=sarký_degerleri[m][1];
					sarký_sýralama[n][2]=sarký_degerleri[m][2];
					int sýra_no=(int) sarký_sýralama[n][2];
					int sarký_no=(int) sarký_sýralama[n][0];
					doldu_dolmadý[sýra_no]=1;
					caldý_calmadý[sarký_no]=1;
					hangi_indexde=m;
				
					break;
				}
				
			}
			
				
			}
			
		
		ArrayList <Double> sarký = new ArrayList <Double> ();
		ArrayList <Double> value = new ArrayList <Double> ();
		ArrayList <Double> sýra = new ArrayList <Double> ();
		
			for(int n=0;n<50;n++) {
				
				sarký.add(sarký_sýralama[n][0]);
				
				value.add(sarký_sýralama[n][1]);
				
				sýra.add(sarký_sýralama[n][2]);
	
			}	
			
			
			sarký.remove(1);
			sarký.add(sarký_sýralama[1][0]);
			value.remove(1);
			value.add(sarký_sýralama[1][1]);
			sýra.remove(1);
			sýra.add(sarký_sýralama[1][2]);

			
			
					
		
for(int n=0;n<50;n++) {
				
				sarký_sýralama[n][0]=sarký.get(n);
				
				sarký_sýralama[n][1]=value.get(n);
				
				sarký_sýralama[n][2]=sýra.get(n);
				
			}	
			
		
			
		
		
		

        }
        public static List<List<String>> readValues() throws IOException { 
                try
		{
			List< List<String> > data = new ArrayList<>();//list of lists to store data
			String file = "term_project_value_data.csv";//file path
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			//Reading until we run out of lines
			String line = br.readLine();
			while(line != null)
			{
				List<String> lineData = Arrays.asList(line.split(","));//splitting lines
				data.add(lineData);
				line = br.readLine();
			}
			
			//printing the fetched data
			for(List<String> list : data)
			{
				for(String str : list)
					System.out.print(str + " ");
				System.out.println();
			}
			br.close();
                        return data;
		}
		catch(Exception e)
		{
			System.out.print(e);
                        List< List<String> > data = new ArrayList<>();//list of lists to store data
                        return data;
		}
                
        }
	public static List<List<String>> readSequential() throws IOException { 
                try
		{
			List< List<String> > data = new ArrayList<>();//list of lists to store data
			String file = "term_project_sequential_data.csv";//file path
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			//Reading until we run out of lines
			String line = br.readLine();
			while(line != null)
			{
				List<String> lineData = Arrays.asList(line.split(","));//splitting lines
				data.add(lineData);
				line = br.readLine();
			}
			
			//printing the fetched data
			for(List<String> list : data)
			{
				for(String str : list)
					System.out.print(str + " ");
				System.out.println();
			}
			br.close();
                        return data;
		}
		catch(Exception e)
		{
			System.out.print(e);
                        List< List<String> > data = new ArrayList<>();//list of lists to store data
                        return data;
		}
                
        }
}
