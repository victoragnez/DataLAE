package service.model;

/**
 * Representa as visitas de campo realizadas.
 * @author gabriel
 */
public final class Area {
    /**
     * Atributos básicos
     */
    private final String codigo;
    private String local;

    public Area(String codigo, String local)
    {
        this.codigo = codigo;
        this.local = local;
    }
    
    public String getLocal() {
    	return this.local;
    }
    
    public void setLocal(String s) {
    	this.local = s;
    }
    
    public String getCodigo() {
    	return this.codigo;
    }
}
