# **Anagram Generator**

Este projeto é um **gerador de anagramas** que implementa um conjunto de validações, geração de anagramas e exibição dos resultados. Ele foi desenvolvido seguindo boas práticas, como a separação de responsabilidades entre validações, lógica de geração e orquestração da aplicação.

---

## **Funcionalidades**
- Recebe um conjunto de caracteres como argumentos a partir da linha de comando.
- Valida os caracteres de entrada:
   - Não podem ser nulos.
   - Devem ser somente caracteres alfabéticos (`A-Z`, maiúsculas ou minúsculas).
   - **Letras repetidas são descartadas**: cada caractere no conjunto final é **único**.
- Gera todas as combinações possíveis (anagramas) do conjunto fornecido.
- Exibe os anagramas no console, além de registrar eventos importantes da execução usando `Logger`.

---

## **Como Executar**

### **Pré-requisitos**
- **Java 21** ou superior.
- Build system: **Maven**.
- Console configurado para execução de comandos Java.

### **Passos para Execução**

1. **Gerar o arquivo JAR**:
   Na raiz do projeto, execute o comando abaixo para criar o JAR da aplicação:

   ```bash
   mvn clean install
   ```

2. **Executar a aplicação**:
   Execute o comando abaixo para rodar a aplicação, passando os caracteres como argumentos:

   ```bash
   java -jar target/anagram-1.0-SNAPSHOT.jar a b c
   ```

   Caso os caracteres estejam separados por vírgulas (por exemplo, "a,b,c"), execute:

   ```bash
   java -jar target/anagram-1.0-SNAPSHOT.jar "a,b,c"
   ```

### **Saída Esperada**
No console, você verá:
- Os anagramas gerados.
- O total de anagramas gerados.

Exemplo de saída:

```text
abc
acb
bac
bca
cab
cba
total anagrams: 6
```

---

## **Como Rodar os Testes**

Para rodar os testes do projeto, use o comando abaixo:

```bash
mvn test
```

Os testes incluem validações das funcionalidades principais e tratamento de cenários de erro.

---

## **Estrutura do Código**

O código está organizado com pacotes para facilitar a legibilidade e manutenção:

- **`br.com.main`**: Contém a classe `Main`, que é o ponto de entrada da aplicação.
- **`br.com.anagram`**: Contém as classes responsáveis pela geração e orquestração dos anagramas.
- **`br.com.validation`**: Define as interfaces e implementações utilizadas nas validações do programa.

---