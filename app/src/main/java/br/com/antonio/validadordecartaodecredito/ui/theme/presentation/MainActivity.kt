package br.com.antonio.validadordecartaodecredito.ui.theme.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.antonio.validadordecartaodecredito.ui.theme.ValidadorDeCartaoDeCreditoTheme
import br.com.antonio.validadordecartaodecredito.ui.theme.domain.CreditCardValidator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ValidadorDeCartaoDeCreditoTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->

                        createMain(paddingValues = innerPadding)

                }
            }
        }
    }
}


@SuppressLint("UnrememberedMutableState")
@Composable
fun createMain(paddingValues: PaddingValues){

    var numeroDoCartao by remember {
         mutableStateOf("")
    }

    var respostaCartao by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        verticalArrangement = Arrangement.Center

        
    ) {

        Text(
            text = "Inserir Número do cartão para validação",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 16.dp, 16.dp),
            value =  numeroDoCartao,
            onValueChange = { aa ->
                numeroDoCartao = aa
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )

        )
        
        Button(
            onClick = {

                respostaCartao = if(numeroDoCartao.isNotEmpty()){
                    callValidator(numeroDoCartao)
                }else{
                    "Campo esta vázio."
                }


            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 16.dp, 16.dp),
        ) {
            Text(text = "Validar")
        }

        Text(
            text = "$respostaCartao",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ValidadorDeCartaoDeCreditoTheme {

    }
}

fun callValidator(numeroDoCartao: String): String{
    val cardValidator = CreditCardValidator()

    if(cardValidator.isValidCard(numeroDoCartao)){
          return "Cartão válido: Seu cartão é o ${cardValidator.getCardType(numeroDoCartao)}"
    }else{
        return "Cartão inválido"
    }
}