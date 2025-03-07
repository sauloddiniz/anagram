## **Anagram Generator**

Este projeto se trata de um **gerador de anagramas**, que utiliza um conjunto de validações de entrada, geração de anagramas e exibição dos resultados. Ele foi estruturado em torno de boas práticas, com separação de responsabilidades entre validações, orquestração e lógica de geração de anagramas.

---

### **Funcionalidades**
- Recebe um conjunto de caracteres como argumentos a partir da linha de comando.
- Valida os caracteres para garantir que sejam válidos:
    - Não podem estar nulos.
    - Devem ser apenas caracteres alfabéticos (de A-Z, maiúsculas ou minúsculas).
    - **Letras repetidas são descartadas**: cada caractere no conjunto final é **único**.

- Gera todas as combinações possíveis (anagramas) do conjunto fornecido.
- Exibe os anagramas no console e também registra os eventos importantes da execução usando `Logger`.

---

### **Como Executar**

1. **Pré-requisitos**
    - **Java 21** ou superior.
    - Build system: **Maven**
    - Console configurado para executar comandos Java.

2. **Execução**
    - Execute o comando abaixo para rodar a aplicação passando os caracteres como argumentos:

```shell script
java -jar anagram-generator.jar a b c
```

     Neste exemplo, o programa irá gerar todos os anagramas das letras "a", "b" e "c".

- Para caracteres separados por vírgulas (ex.: "a,b,c"), execute:

```shell script
java -jar anagram-generator.jar "a,b,c"
```

3. **Saída Esperada**
   A saída no console apresentará:
    - Os anagramas gerados.
    - O total de anagramas gerados.

   Exemplo:
```
 abc
 acb
 bac
 bca
 cab
 cba
 total anagrams: 6
```

---

### **Como Rodar os Testes**

1. **Usando Maven**:
```shell script
mvn test
```


Os testes validarão as funcionalidades principais e cenários de erro previstos.

---

### **Estrutura do Código**
O código é dividido em pacotes para facilitar a organização:
- **`br.com.main`**: Contém a classe `Main`.
- **`br.com.anagram`**: Contém as classes relacionadas à geração e orquestração de anagramas.
- **`br.com.validation`**: Define as interfaces e implementações para validações.

---
