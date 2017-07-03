/**
 * 
 */
package acionaAgente;

/**
 * @author pedro
 *
 */
public class ChamaAgente {
	public static void chamaInserir(String category) {
		String args1 = "-gui";
		String args2=" pedro:tutorjade.InserirPreferencia("+category+")";
		String[] strArray = new String[] {args1,args2};
		jade.Boot.main(strArray);
		
	}
}
