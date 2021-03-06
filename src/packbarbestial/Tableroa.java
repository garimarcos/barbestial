package packbarbestial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

public class Tableroa extends Observable{
	
	private static Tableroa nTableroa=new Tableroa();
	private ArrayList<Karta> kartak;

	private Tableroa() {
		kartak=new ArrayList<Karta>();
	}
	
	public ArrayList<Karta> hartuKartak(){ return kartak; }
	
	public static Tableroa getnTableroa(){
		return nTableroa;
	}
	
	public void gehituKarta(Karta pKarta){
		kartak.add(pKarta);
	}
	/** test **/
	public void setKartak(ArrayList<Karta> k){ kartak=k;} //test gauzatzeko
	public int getKop(){ return kartak.size(); } //test gauzatzeko
	
	public void animaladakGauzatu(int indarra, int jok){
		kartak.get(kartak.size()-1).egikaritu();
		boolean amaitu=false;
		int k=0;
		while(!amaitu){
			while(!kartak.get(k).errekurrenteaDa() && k<kartak.size()-1){
				k++;
			}if(k==kartak.size()-1) amaitu=true;
			else{
				kartak.get(k).egikaritu();
				k++;
			}
		}

		if(kartak.size()==5){
			Mahaia m=Mahaia.getnMahaia();
			m.inpernura(kartak.get(kartak.size()-1));
			kartak.remove(kartak.size()-1);
			int i=0;
			while(i<2){
				m.zerura(kartak.get(0));
				kartak.remove(0);
				i++;
			}
		}
		
		egoeraAldatua(kartak);
	}
	
	public boolean amaituta(){
		return ListaJokalariak.getNireLista().jokLortu(1).amaituDu()&&ListaJokalariak.getNireLista().jokLortu(2).amaituDu();
	}
	
	public void kanporatu(int pPosizioa) throws IndexOutOfBoundsException{
		if(kartak.get(pPosizioa)!=null)Mahaia.getnMahaia().inpernura(kartak.remove(pPosizioa-1));
	}
	
	public void aurreratu(int pKopuru){
		int pPosizioa=kartak.size()-1;
		if(pKopuru==1) Collections.swap(kartak, pPosizioa, pPosizioa-1);
		else if(pKopuru==2){
			Collections.swap(kartak, pPosizioa, pPosizioa-1);
			Collections.swap(kartak, pPosizioa-1, pPosizioa-2);
		}
	}
	
	public int[] indarrakLortu(){
		int[] indarrak = new int[kartak.size()];
		int i = 0;
		while(i<kartak.size()){
			indarrak[i]=kartak.get(i).getIndarra();
			i++;
		}
		return indarrak;
	}
	
	private void egoeraAldatua(ArrayList<Karta> k){
		ArrayList<Integer> kartak = new ArrayList<Integer>(); //posizio bikoitiak = indarra
									//posizio bakoitiak = kolorea --> 0=berdea 1=urdina 2=gorria 3=horia
		int i = 0;
		int j = 0;
		while (j < k.size()){
			kartak.add(k.get(j).getIndarra());
			//System.out.println(k.get(j).getKolore());
			if(k.get(j).getKolore().equalsIgnoreCase("berdea")) kartak.add(0);
			else if(k.get(j).getKolore().equalsIgnoreCase("urdina")) kartak.add(1);
			else if(k.get(j).getKolore().equalsIgnoreCase("gorria")) kartak.add(2);
			else if(k.get(j).getKolore().equalsIgnoreCase("horia")) kartak.add(3);
			j++;
			i=i+2;
		}
		setChanged();
		notifyObservers(kartak);
	}
	
	public void clear(){
		kartak.clear();
	}
	
}
