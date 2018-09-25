package service.model;

public enum PesquisadorTipo {
	Professor, Doutorando, Mestrando, IC, Convidado;

	public static PesquisadorTipo getPesquisadorTipo(String string) {
		if(string.toLowerCase().equals("professor"))
			return Professor;
		if(string.toLowerCase().equals("doutorando"))
			return Doutorando;
		if(string.toLowerCase().equals("mestrando"))
			return Mestrando;
		if(string.toLowerCase().equals("ic"))
			return IC;
		if(string.toLowerCase().equals("convidado"))
			return Convidado;
		throw new RuntimeException("Banco de dados corrompido ou alterado");
	}
}
