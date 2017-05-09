package connectto;

import java.util.ArrayList;

public class ourKonnektorDriver {
	public static void main(String[] args)	{
	ourKonnektor o=new ourKonnektor();
	o.insertItem("hello","bu kalbimden daha temiz sayfayý sana açýyorum, mesgulsun herhalde cnm..");
	ArrayList<datamodel>d=o.getitems();
	for(datamodel d2:d)
	{
		System.out.println(d2.topic);
		System.out.println("!!!!!!!");
		System.out.println(d2.getContent());
		System.out.println("----");
	}
}
}
