# MyDeveloperSketches

> **Are you a non-Portuguese speaker?** No worries — [read the English version](./README.en.md).

Meu mapa público de estudos em desenvolvimento de software.

Este repositório reúne anotações, exercícios e pequenos experimentos que uso para transformar conceitos em prática. O conteúdo cresce junto com meus estudos e registra tanto fundamentos quanto investigações mais específicas.

[Estudo em destaque](#estudo-em-destaque) · [Mapa de estudos](#mapa-de-estudos) · [Leituras acompanhadas](#leituras-acompanhadas) · [Material de referência](#material-de-referência)

## Estudo em destaque

### Coordenação entre produtor e consumidores

Um experimento com uma fila, uma pilha e threads que aguardam a chegada de novos dados.

- **Pergunta investigada:** como coordenar a espera e o consumo de dados entre threads?
- **Recursos explorados:** `synchronized`, `wait`, `notifyAll` e `join`.
- **O que observar:** a proteção das coleções compartilhadas e a sequência de execução das threads.

➡️ [Abrir o estudo de concorrência](./Java/resume_java_lang/S06_)

### Outros destaques

| Estudo | O que foi explorado |
| --- | --- |
| [Igualdade e cópia de objetos](./Java/resume_java_lang/S05_) | Comparações com `equals`, `hashCode` e cópia com `clone`. |
| [Ponto flutuante na prática](./Java/resume_java_lang/S13_) | O comportamento de `0.1 + 0.2`, infinito e `NaN`. |

## Mapa de estudos

### Java · fundamentos

| Conceito | Onde explorar |
| --- | --- |
| Classes, módulos e runtime | [S04 · Metadados e execução](./Java/resume_java_lang/S04_) |
| Contratos de objetos | [S05 · Igualdade, hash e cópia](./Java/resume_java_lang/S05_) |
| Concorrência | [S06 · Monitores e threads](./Java/resume_java_lang/S06_) |
| Strings e comparação | [S07 · String Pool e comparação](./Java/resume_java_lang/S07_) · [S08 · Operações com strings](./Java/resume_java_lang/S08_) |
| Unicode e construção de texto | [S09 · Character e Unicode](./Java/resume_java_lang/S09_) · [S10 · StringBuilder](./Java/resume_java_lang/S10_) |
| Wrappers e conversões | [S11 · Wrappers](./Java/resume_java_lang/S11_) · [S12 · Base64 e bases numéricas](./Java/resume_java_lang/S12_) |
| Ponto flutuante | [S13 · Double, infinito e NaN](./Java/resume_java_lang/S13_) |

## Leituras acompanhadas

### Head First Java

Exercícios feitos durante a leitura, organizados por capítulo ou parte.

➡️ [Explorar os exercícios de Head First Java](./Java/Head-First%20Java%20%28Book%29/)

## Material de referência

### Resumo de `java.lang`

Material de consulta sobre classes e APIs fundamentais, incluindo objetos, texto, números, execução, threads, exceções, reflexão, módulos e tipos especiais.

➡️ [Abrir o resumo de java.lang para Java 25](./Java/resume_java_lang/java.lang-resumo-java-25.html)

---

Mantido por [Gabriel Setznagl](https://github.com/Setznagl) · Veja também o projeto Java [MyBelovedSmartLibrary](https://github.com/Setznagl/MyBelovedSmartLibrary)
