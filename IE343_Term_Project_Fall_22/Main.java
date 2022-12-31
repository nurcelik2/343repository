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
		List<Double> sark�_sure = new ArrayList<Double>();
		
		for(int i=1;i<list.size();i++) {
			popularity_no.add(Double.parseDouble(list.get(i).get(4))); 
			sark�_sure.add(Double.parseDouble(list.get(i).get(5)));
			
		}
		
		
		ArrayList <Double> deger = new ArrayList <Double> ();
		Double[][] deger_sorted=new Double [50][2];
		
		for(int i=0;i<50;i++) {
			
			deger.add(popularity_no.get(i)/(sark�_sure.get(i)/60000));
			
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
		int sark�_say�s�=0;
		double total_deger=0;
		
		for(int i=0;i<50;i++) {
			
			double index_double0=deger_sorted[i][1];
			int index_int0=(int) index_double0;
			
			double index_double1=deger_sorted[i][0];
			int index_int1=(int) index_double1;
				
			if(total_sure<=30 && (30-total_sure>(sark�_sure.get(index_int0)/60000))) {

				total_sure=total_sure + (sark�_sure.get(index_int0)/60000);
				
				total_deger=total_deger+popularity_no.get(index_int1);
				
			}
			
		}
		
		double kaybedilen_value=((30-(total_sure))*60*0.02);
		double album_deger=total_deger-(kaybedilen_value);
		
		
		
		
		//PART2//
		
		
		List<List<String>> list1 = readSequential();
		double [][] s�ralama_degerleri=new double [50][50];;
		
		List<ArrayList<Double>> sequential_data = new ArrayList<ArrayList<Double>>();
		for (int i=1;i<list1.size();i++){
			ArrayList<Double> row = new ArrayList<>();
			for (int j=1;j<list1.get(0).size();j++){
				row.add(Double.parseDouble(list1.get(i).get(j)));
				s�ralama_degerleri[i-1][j-1]=Double.parseDouble(list1.get(i).get(j));
		
			}
			sequential_data.add(row);
			
		}
		System.out.println(sequential_data.get(0).get(1));
		
		
		int [] cald�_calmad�= new int [50];
		int [] doldu_dolmad�= new int [50];
		
		for(int i=0;i<50;i++) {
			
			cald�_calmad�[i]=0;		//�ark�lar i�in
			doldu_dolmad�[i]=0;		//s�ralar i�in
			
		}
		
		double [][] sark�_degerleri=new double[2500][3];  //�ark�lardan 1 den fazla olucak �ekilde s�raland�
		double [][] sark�_s�ralama=new double [50][3];   //�ark�lardan 1 tane olucak �ekilde s�ralan�cak
	
		for(int m=0;m<2500;m++) {
			for(int k=0;k<50;k++) {
				for(int l=0;l<50;l++) {
			
					if(s�ralama_degerleri[l][k]>=sark�_degerleri[m][1]) {
						
						sark�_degerleri[m][0]=l;
						sark�_degerleri[m][1]=s�ralama_degerleri[l][k];
						sark�_degerleri[m][2]=k;
						
					}
				}
			}	
			s�ralama_degerleri[(int) sark�_degerleri[m][0]][(int) sark�_degerleri[m][2]]=-1;
		}	
		
		int hangi_indexde=0;
		
		for(int n=0;n<50;n++) {
			for(int m=hangi_indexde;m<2500;m++) {
				
				if(doldu_dolmad�[(int) sark�_degerleri[m][2]]==0 && cald�_calmad�[(int) sark�_degerleri[m][0]]==0) {
					
					sark�_s�ralama[n][0]=sark�_degerleri[m][0];
					sark�_s�ralama[n][1]=sark�_degerleri[m][1];
					sark�_s�ralama[n][2]=sark�_degerleri[m][2];
					int s�ra_no=(int) sark�_s�ralama[n][2];
					int sark�_no=(int) sark�_s�ralama[n][0];
					doldu_dolmad�[s�ra_no]=1;
					cald�_calmad�[sark�_no]=1;
					hangi_indexde=m;
				
					break;
				}
				
			}
			
				
			}
			
		
		ArrayList <Double> sark� = new ArrayList <Double> ();
		ArrayList <Double> value = new ArrayList <Double> ();
		ArrayList <Double> s�ra = new ArrayList <Double> ();
		
			for(int n=0;n<50;n++) {
				
				sark�.add(sark�_s�ralama[n][0]);
				
				value.add(sark�_s�ralama[n][1]);
				
				s�ra.add(sark�_s�ralama[n][2]);
	
			}	
			
			
			sark�.remove(1);
			sark�.add(sark�_s�ralama[1][0]);
			value.remove(1);
			value.add(sark�_s�ralama[1][1]);
			s�ra.remove(1);
			s�ra.add(sark�_s�ralama[1][2]);

			
			
					
		
for(int n=0;n<50;n++) {
				
				sark�_s�ralama[n][0]=sark�.get(n);
				
				sark�_s�ralama[n][1]=value.get(n);
				
				sark�_s�ralama[n][2]=s�ra.get(n);
				
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
