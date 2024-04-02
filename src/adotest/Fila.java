package adotest;

/**
 *
 * @author Gabriel Estevamm
 */

class Fila {
    private Loop inicioNormal = null;
    private Loop fimNormal = null;
    private Loop inicioPreferencial = null;
    private Loop fimPreferencial = null;
    private int contadorPreferencial = 0;

    private final class Loop {
        Pacientes paciente;
        Loop proximo;

        public Loop(Pacientes paciente) {
            this.paciente = paciente;
            this.proximo = null;
        }
    }

    public void enfileirar(Pacientes paciente) {
        Loop novoNome = new Loop(paciente);
        if (paciente.isPreferencial()) {
            if (fimPreferencial != null) {
                fimPreferencial.proximo = novoNome;
            }
            fimPreferencial = novoNome;
            if (inicioPreferencial == null) {
                inicioPreferencial = novoNome;
            }
        } else {
            if (fimNormal != null) {
                fimNormal.proximo = novoNome;
            }
            fimNormal = novoNome;
            if (inicioNormal == null) {
                inicioNormal = novoNome;
            }
        }
    }

    public Pacientes desenfileirar() {
        if (inicioPreferencial != null && contadorPreferencial < 3) {
            contadorPreferencial++;
            Pacientes pacienteAtual = inicioPreferencial.paciente;
            inicioPreferencial = inicioPreferencial.proximo;
            if (inicioPreferencial == null) {
                fimPreferencial = null;
            }
            return pacienteAtual;
        } else if (inicioNormal != null) {
            contadorPreferencial = 0;
            Pacientes pacienteNormal = inicioNormal.paciente;
            inicioNormal = inicioNormal.proximo;
            if (inicioNormal == null) {
                fimNormal = null;
            }
            return pacienteNormal;
        } else if (inicioPreferencial != null) {
            contadorPreferencial = 0;
            Pacientes pacientePreferencial = inicioPreferencial.paciente;
            inicioPreferencial = inicioPreferencial.proximo;
            if (inicioPreferencial == null) {
                fimPreferencial = null;
            }
            return pacientePreferencial;
        } else {
            return null;
        }
    }

public void consultarFila() {
    if (inicioPreferencial == null && inicioNormal == null) {
        System.out.println("A fila esta vazia.");
        return;
    }
    
    Loop current = inicioPreferencial;
    System.out.println("Fila Preferencial:");
    while (current != null) {
        System.out.println(current.paciente.getNome() + " (Preferencial)");
        current = current.proximo;
    }
    
    current = inicioNormal;
    System.out.println("Fila Normal:");
    while (current != null) {
        System.out.println(current.paciente.getNome() + " (Normal)");
        current = current.proximo;
    }
}
}

