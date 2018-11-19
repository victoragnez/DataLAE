package framework.service;

class Wrapper<T> {
	public final T instancia;
    public Wrapper(T service) {
        this.instancia = service;
    }
    public T getInstancia() {
        return instancia;
    }
}
