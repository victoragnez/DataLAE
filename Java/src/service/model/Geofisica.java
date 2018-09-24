package service.model;

public interface Geofisica {
	enum Metodo{
		ERT, GPR, SismicaReflexao, SismicaRefracao;
	};
	enum Tipo{
		DadoBruto, DocumentacaoCampo, Imagem, Processamento, Report;
	};
}
