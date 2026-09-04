# una-gqs-listaSeis-Java

# TempoParaMarte

Calcula o tempo de viagem Terra → Marte usando uma **órbita de transferência de Hohmann** — a trajetória de mínima energia entre dois corpos orbitando o Sol.

## Como rodar

```bash
javac TempoParaMarte.java
java TempoParaMarte
```

## Saída esperada

```
=== Transferência de Hohmann Terra -> Marte ===
Semieixo da órbita de transferência: 188768694 km
Tempo de viagem: 258.9 dias
Tempo de viagem: 8.51 meses
```

## Método

1. Calcula o semieixo maior da órbita elíptica de transferência:
   `a = (r_Terra + r_Marte) / 2`
2. Aplica a 3ª Lei de Kepler para obter o período orbital completo:
   `T = 2π √(a³ / μ_Sol)`
3. O tempo de viagem é **metade** desse período (a nave percorre só a metade da elipse, de periélio a afélio).

## Constantes usadas

| Constante | Valor | Descrição |
|---|---|---|
| `MU_SOL` | 1.32712440018 × 10¹¹ km³/s² | μ = G × massa do Sol |
| `RAIO_ORBITA_TERRA` | 149.598.023 km | 1 UA |
| `RAIO_ORBITA_MARTE` | 227.939.366 km | ~1,524 UA |

## Limitações (leia antes de usar isso pra qualquer coisa séria)

- **Órbitas tratadas como circulares e coplanares.** Na realidade, Marte tem excentricidade ~0,093 e inclinação ~1,85° em relação ao plano da Terra — o resultado real varia com a janela de lançamento (a cada ~26 meses).
- **É a rota de menor energia, não a mais rápida.** Missões que priorizam velocidade sobre economia de combustível (ex: propulsão de alta potência) chegam mais rápido.
- **Baseado em dados de missões robóticas.** Não existe missão tripulada até o momento — qualquer estimativa para "o homem" chegar é extrapolação, e ignora fatores como tempo de espera em órbita de Marte para alinhamento de retorno e margens de segurança.

## Referência de validação

Missões reais (Curiosity, Perseverance) levaram entre 200 e 300 dias, o que bate com a faixa calculada aqui.
