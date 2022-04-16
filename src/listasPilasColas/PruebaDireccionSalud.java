package listasPilasColas;

public class PruebaDireccionSalud {

	public static void main(String[] args) {
		DireccionSalud consultorio = new DireccionSalud();
		consultorio.addMedico("Juanipis");
		try {
			consultorio.addPaciente("Juanipis", "Rodrigo");
		} catch (MedicoNoEncontrado e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(consultorio.getPacienteMedico("Juanipis"));
		} catch (MedicoNoCitas | MedicoNoEncontrado e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			consultorio.atenderPaciente("Juanipis");
		} catch (MedicoNoEncontrado | MedicoNoCitas e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println(consultorio.getPacienteMedico("Juanipis"));
		} catch (MedicoNoCitas | MedicoNoEncontrado e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
