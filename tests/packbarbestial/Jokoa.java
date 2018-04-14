package packbarbestial;

public class Jokoa {

	Mahaia m=Mahaia.getnMahaia();
	ListaJokalariak l=ListaJokalariak.getNireLista();
	Tableroa t=Tableroa.getnTableroa();
	KartenBilera k=KartenBilera.getnKartenBilera();

	private static Jokoa nJokoa=new Jokoa();

	private Jokoa() {
		
	}
	
	public static Jokoa getnJokoa(){
		return nJokoa;
	}
	
	public String[] mahaiaPrestatu(){
		return m.mahaiaPrestatu();
	}
	
	public Karta bota(int pPosizioa){
		return l.jokLortu(1).bota(pPosizioa);
	}
	
	public int[] hartu(){
		return l.jokLortu(1).hartu();
	}
	
	public String getUrl(int indarra){
		return k.getURL(indarra, l.jokLortu(1).getKolore());
	}
	
	public void gehituTablerora(Karta k){
		t.gehituKarta(k);
	}
	
	public int getTableroKop(){ return t.getKop(); }
	
	public void ordenagailuaSortu(){
		String jokKolore=l.jokLortu(1).getKolore();
		String ordKolore="";
		if(jokKolore.equals("urdina")) ordKolore="berdea";
		else ordKolore="urdina";
		l.add(new Jokalaria("ordenagailua",ordKolore));
		//System.out.println(l.jokLortu(2).getKolore());
	}

}
