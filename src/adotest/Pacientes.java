package adotest;

/**
 *
 * @author Gabriel Estevam
 */
class Pacientes {
    private final String nome;
    private final boolean preferencial;

    public Pacientes(String nome, boolean preferencial) {
        this.nome = nome;
        this.preferencial = preferencial;
    }

    public String getNome() {
        return nome;
    }

    public boolean isPreferencial() {
        return preferencial;
    }
}