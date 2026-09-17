# MyDeveloperSketches

> **Prefere ler em português?** [Acesse a versão em português](./README.md).

My public study map for software development.

This repository brings together notes, exercises, and small experiments that I use to turn concepts into practice. It grows alongside my studies and records both foundational topics and more focused investigations.

[Featured study](#featured-study) · [Study map](#study-map) · [Guided reading](#guided-reading) · [Reference material](#reference-material)

## Featured study

### Coordinating a producer and consumers

An experiment with a queue, a stack, and threads waiting for new data to arrive.

- **Question explored:** how can waiting and data consumption be coordinated across threads?
- **APIs and concepts:** `synchronized`, `wait`, `notifyAll`, and `join`.
- **What to observe:** how shared collections are protected and how the threads execute in sequence.

➡️ [Open the concurrency study](./Java/resume_java_lang/S06_)

### More highlights

| Study | What it explores |
| --- | --- |
| [Object equality and copying](./Java/resume_java_lang/S05_) | Comparisons using `equals` and `hashCode`, plus copying with `clone`. |
| [Floating-point numbers in practice](./Java/resume_java_lang/S13_) | The behavior of `0.1 + 0.2`, infinity, and `NaN`. |

## Study map

### Java · fundamentals

| Concept | Where to explore |
| --- | --- |
| Classes, modules, and runtime | [S04 · Metadata and execution](./Java/resume_java_lang/S04_) |
| Object contracts | [S05 · Equality, hashing, and copying](./Java/resume_java_lang/S05_) |
| Concurrency | [S06 · Monitors and threads](./Java/resume_java_lang/S06_) |
| Strings and comparison | [S07 · String Pool and comparison](./Java/resume_java_lang/S07_) · [S08 · String operations](./Java/resume_java_lang/S08_) |
| Unicode and text construction | [S09 · Character and Unicode](./Java/resume_java_lang/S09_) · [S10 · StringBuilder](./Java/resume_java_lang/S10_) |
| Wrappers and conversions | [S11 · Wrappers](./Java/resume_java_lang/S11_) · [S12 · Base64 and numeric bases](./Java/resume_java_lang/S12_) |
| Floating-point numbers | [S13 · Double, infinity, and NaN](./Java/resume_java_lang/S13_) |

## Guided reading

### Head First Java

Exercises completed while reading the book, organized by chapter or part.

➡️ [Explore the Head First Java exercises](./Java/Head-First%20Java%20%28Book%29/)

## Reference material

### `java.lang` overview

A reference covering foundational classes and APIs, including objects, text, numbers, runtime behavior, threads, exceptions, reflection, modules, and special types.

➡️ [Open the Java 25 java.lang overview](./Java/resume_java_lang/java.lang-resumo-java-25.html)

---

Maintained by [Gabriel Setznagl](https://github.com/Setznagl) · See also the Java project [MyBelovedSmartLibrary](https://github.com/Setznagl/MyBelovedSmartLibrary)
