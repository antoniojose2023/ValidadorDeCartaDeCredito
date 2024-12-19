package br.com.antonio.validadordecartaodecredito.ui.theme.domain

class CreditCardValidator {
    enum class CardType {
        MASTERCARD,
        VISA,
        VISA_ELECTRON,
        AMERICAN_EXPRESS,
        DINERS_CLUB,
        DISCOVER,
        ENROUTE,
        JCB,
        MAESTRO,
        SOLO,
        SWITCH,
        LASER,
        UNKNOWN
    }

    companion object {
        // Padrões de números para cada bandeira
        private val patterns = mapOf(
            CardType.MASTERCARD to "^5[1-5][0-9]{14}$".toRegex(),
            CardType.VISA to "^4[0-9]{12}(?:[0-9]{3})?$".toRegex(), // Aceita 13 ou 16 dígitos
            CardType.VISA_ELECTRON to "^(4026|417500|4508|4844|491(3|7))[0-9]{12}$".toRegex(),
            CardType.AMERICAN_EXPRESS to "^3[47][0-9]{13}$".toRegex(),
            CardType.DINERS_CLUB to "^3(?:0[0-5]|[68][0-9])[0-9]{11}$".toRegex(),
            CardType.DISCOVER to "^6(?:011|5[0-9]{2})[0-9]{12}$".toRegex(),
            CardType.JCB to "^(?:2131|1800|35\\d{3})\\d{11}$".toRegex(),
            CardType.MAESTRO to "^(5018|5020|5038|6304|6759|6761|6763)[0-9]{8,15}$".toRegex(),
            CardType.SOLO to "^(6334|6767)[0-9]{12}|(6334|6767)[0-9]{14}|(6334|6767)[0-9]{15}$".toRegex(),
            CardType.SWITCH to "^(4903|4905|4911|4936|6333|6759)[0-9]{12}|(4903|4905|4911|4936|6333|6759)[0-9]{14}|(4903|4905|4911|4936|6333|6759)[0-9]{15}$".toRegex(),
            CardType.LASER to "^(6304|6706|6771|6709)[0-9]{12,15}$".toRegex()
        )
    }

    /**
     * Valida um número de cartão de crédito usando o algoritmo de Luhn
     * @param number Número do cartão de crédito
     * @return true se o cartão for válido, false caso contrário
     */
    fun isValidCard(number: String): Boolean {
        val cleanNumber = number.replace("\\s".toRegex(), "")
        if (!cleanNumber.matches("^[0-9]{12,19}$".toRegex())) return false
        return isValidLuhn(cleanNumber)
    }

    /**
     * Identifica a bandeira do cartão com base no número
     * @param number Número do cartão de crédito
     * @return CardType representando a bandeira do cartão
     */
    fun getCardType(number: String): CardType {
        val cleanNumber = number.replace("\\s".toRegex(), "")
        return patterns.entries.find { (_, pattern) ->
            cleanNumber.matches(pattern)
        }?.key ?: CardType.UNKNOWN
    }

    /**
     * Implementa o algoritmo de Luhn para validação do número do cartão
     * @param number Número do cartão sem espaços
     * @return true se passar na validação de Luhn, false caso contrário
     */
    private fun isValidLuhn(number: String): Boolean {
        var sum = 0
        var isEven = false

        // Percorre o número da direita para a esquerda
        for (i in number.length - 1 downTo 0) {
            var digit = number[i].toString().toInt()

            if (isEven) {
                digit *= 2
                if (digit > 9) {
                    digit -= 9
                }
            }

            sum += digit
            isEven = !isEven
        }

        return sum % 10 == 0
    }
}

// Exemplo de uso:
fun main() {
    val validator = CreditCardValidator()

    // Exemplos de números de cartão (números fictícios para teste)
    val testCards = listOf(
        "5555555555554444", // MasterCard
        "4111111111111111", // Visa
        "378282246310005",  // American Express
        "6011111111111117"  // Discover
    )

    testCards.forEach { cardNumber ->
        val isValid = validator.isValidCard(cardNumber)
        val cardType = validator.getCardType(cardNumber)

        println("Número: $cardNumber")
        println("Válido: $isValid")
        println("Tipo: $cardType")
        println("-------------------")
    }
}