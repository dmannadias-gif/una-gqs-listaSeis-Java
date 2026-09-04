import java.util.Locale;

/**
 * Calcula o tempo de viagem Terra -> Marte usando uma órbita de
 * transferência de Hohmann (trajetória de mínima energia).
 *
 * Isso é uma aproximação: assume órbitas circulares e coplanares
 * para Terra e Marte, o que na realidade não são (Marte tem
 * excentricidade ~0.093 e inclinação ~1.85° em relação à Terra).
 * O valor real de uma missão específica varia com a posição relativa
 * dos planetas na "janela de lançamento" (a cada ~26 meses).
 */
public class TempoParaMarte {

    // Constante gravitacional do Sol (mu = G * M_sol), em km^3/s^2
    private static final double MU_SOL = 1.32712440018e11;

    // Semieixos maiores médios das órbitas (em km)
    private static final double RAIO_ORBITA_TERRA = 149_598_023.0; // 1 UA
    private static final double RAIO_ORBITA_MARTE = 227_939_366.0; // ~1.524 UA

    public static void main(String[] args) {
        double semiEixoTransferencia = (RAIO_ORBITA_TERRA + RAIO_ORBITA_MARTE) / 2.0;

        // 3ª Lei de Kepler: T = 2*pi*sqrt(a^3 / mu)
        // A viagem é metade dessa órbita elíptica (Terra -> Marte)
        double periodoOrbitaCompletaSegundos =
                2 * Math.PI * Math.sqrt(Math.pow(semiEixoTransferencia, 3) / MU_SOL);

        double tempoViagemSegundos = periodoOrbitaCompletaSegundos / 2.0;

        double tempoViagemDias = tempoViagemSegundos / 86400.0;
        double tempoViagemMeses = tempoViagemDias / 30.44;

        System.out.println("=== Transferência de Hohmann Terra -> Marte ===");
        System.out.printf(Locale.US, "Semieixo da órbita de transferência: %.0f km%n", semiEixoTransferencia);
        System.out.printf(Locale.US, "Tempo de viagem: %.1f dias%n", tempoViagemDias);
        System.out.printf(Locale.US, "Tempo de viagem: %.2f meses%n", tempoViagemMeses);
        System.out.println();
        System.out.println("Referência: missões reais (Curiosity, Perseverance) levaram");
        System.out.println("entre 200 e 300 dias, dependendo da janela de lançamento,");
        System.out.println("porque a trajetória real não é uma Hohmann pura.");
    }
}