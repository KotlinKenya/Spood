package app.spood.ui.signUp

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.spood.R
import app.spood.domain.usecase.SignUpUseCase
import app.spood.screens.signUp.SignUpAction
import app.spood.screens.signUp.SignUpState
import app.spood.screens.signUp.SignUpStore
import app.spood.theme.green
import app.spood.theme.greyLight
import app.spood.ui.components.*
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import kotlinx.coroutines.CoroutineScope

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    SignUp(rememberNavController())
}

@Composable
fun SignUp(
    navController: NavHostController,
    store: SignUpStore = remember { SignUpStore(SignUpUseCase()) },
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) {
    val state by store.state.collectAsState(initial = SignUpState())
    val action by store.state.collectAsState(initial = SignUpState())

    Scaffold(
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .verticalScroll(state = ScrollState(0))
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .navigationBarsPadding()
                    .padding(16.dp)
            ) {
                Logo(tint = green, width = 84)

                Header(title = "Sign Up", subTitle = "Let's do this once and for all")

                Inputs(
                    state = state,
                    onChangeFullName = { store.dispatch(SignUpAction.ChangeFullName(it)) },
                    onChangePhoneNumber = { store.dispatch(SignUpAction.ChangePhoneNumber(it)) }
                )

                ErrorMessage(state.signUpError?.localizedMessage.orEmpty())

                PrimaryActionButton(
                    text = "Sign Up",
                    action = { store.dispatch(SignUpAction.InitiateSignUp) }
                )

                SecondaryActionButton(
                    textPrimary = "Already have an account?",
                    textSecondary = "Sign in",
                    action = {})

                SecondaryActionButton(
                    textPrimary = "I'LL SIGN UP LATER",
                    icon = R.drawable.ic_arrow_right,
                    action = {})
            }
        }
    )
}

@Composable
private fun Inputs(
    state: SignUpState,
    onChangeFullName: (String) -> Unit,
    onChangePhoneNumber: (String) -> Unit,
) {
    Column(modifier = Modifier.padding(vertical = 24.dp)) {

        Text(
            "Full Name",
            modifier = Modifier.padding(bottom = 4.dp),
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Medium
        )

        OutlinedTextField(
            value = state.fullName,
            onValueChange = { onChangeFullName(it) },
            placeholder = { Text("Enter your full name") },
            modifier = Modifier.fillMaxWidth(),
            isError = state.fullNameError != null,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = greyLight,
                unfocusedBorderColor = greyLight
            )
        )

        ErrorMessage(error = state.fullNameError.orEmpty())

        Spacer(Modifier.size(16.dp))

        Text(
            "Phone Number",
            modifier = Modifier.padding(bottom = 4.dp),
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Medium
        )

        OutlinedTextField(
            value = state.phoneNumber,
            onValueChange = { onChangePhoneNumber(it) },
            placeholder = { Text("0700 000 000") },
            modifier = Modifier.fillMaxWidth(),
            isError = state.phoneNumberError != null,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = greyLight,
                unfocusedBorderColor = greyLight
            )
        )

        ErrorMessage(error = state.phoneNumberError.orEmpty())
    }
}