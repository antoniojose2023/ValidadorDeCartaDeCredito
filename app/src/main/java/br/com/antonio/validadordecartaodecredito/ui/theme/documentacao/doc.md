# Project Documentation: Credit Card Validator

## Project Description
The **Credit Card Validator** is an Android application developed in Kotlin that allows users to validate credit card numbers and identify the card type. The validation is performed using the **Luhn algorithm**.

## Features
- **Credit Card Validation**: Checks if the credit card number is valid using the Luhn algorithm.
- **Card Type Identification**: Identifies the credit card type (MasterCard, Visa, American Express, etc.) based on the card number.
- **User Interface**: Simple and intuitive interface for entering the card number and displaying validation results.

## Technologies Used
- **Languages**: Kotlin, Java
- **Frameworks**: Android, Jetpack Compose
- **Build System**: Gradle

## Project Structure
```plaintext
ValidadorDeCartaDeCredito/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   ├── br/
│   │   │   │   │   ├── antonio/
│   │   │   │   │   │   ├── validadordecartaodecredito/
│   │   │   │   │   │   │   ├── domain/
│   │   │   │   │   │   │   │   ├── CreditcardValidator.kt
│   │   │   │   │   │   │   ├── presentation/
│   │   │   │   │   │   │   │   ├── MainActivity.kt
│   │   │   ├── res/
│   │   ├── AndroidManifest.xml
├── README.md
```

## Project Versions
- **Project Version**: 1.0
- **Compile SDK**: 35
- **Min SDK**: 24
- **Target SDK**: 35
- **Kotlin Compiler Extension Version**: 1.5.1

## Dependencies
- `androidx.core:core-ktx`
- `androidx.lifecycle:lifecycle-runtime-ktx`
- `androidx.activity:activity-compose`
- `androidx.compose.ui:ui`
- `androidx.compose.ui:ui-graphics`
- `androidx.compose.ui:ui-tooling-preview`
- `androidx.compose.material3:material3`
- `junit:junit`
- `androidx.test.ext:junit`
- `androidx.test.espresso:espresso-core`
- `androidx.compose.ui:ui-test-junit4`
- `androidx.compose.ui:ui-tooling`
- `androidx.compose.ui:ui-test-manifest`


## Usage Example
```kotlin
fun main() {
    val validator = CreditCardValidator()

    // Example card numbers (fictitious numbers for testing)
    val testCards = listOf(
        "5555555555554444", // MasterCard
        "4111111111111111", // Visa
        "378282246310005",  // American Express
        "6011111111111117"  // Discover
    )

    testCards.forEach { cardNumber ->
        val isValid = validator.isValidCard(cardNumber)
        val cardType = validator.getCardType(cardNumber)

        println("Number: $cardNumber")
        println("Valid: $isValid")
        println("Type: $cardType")
        println("-------------------")
    }
} 
```

### Como Configurar o Projeto

1. Clone este repositório.
   ```bash
   git clone https://github.com/antoniojose2023/ValidadorDeCartaDeCredito.git
   ```
2. Abra o Android Studio e importe o projeto.
3. Conecte um dispositivo ou inicie um emulador.
4. Execute o projeto.

### Como Contribuir

1. Faça um fork deste repositório.
2. Crie uma branch para sua feature ou correção de bug.
   ```bash
   git checkout -b minha-feature
   ```
3. Faça commit das suas alterações.
   ```bash
   git commit -m 'Adiciona minha feature'
   ```
4. Envie para o branch original.
   ```bash
   git push origin minha-feature
   ```
5. Abra um Pull Request.

### Contato

- [GitHub](https://github.com/antoniojose2023)
- [LinkedIn](https://www.linkedin.com/in/antoniojoseuchoa/)

### Observações

Os dados de cartão usados aqui são todos fictícios 😱

---

Este é um exemplo de documentação para o repositório, com uma estrutura de pastas melhorada e explicações detalhadas de cada arquivo, incluindo a conversão da MainActivity para utilizar Jetpack Compose. Por favor, revise e ajuste conforme necessário.

## License
This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).