package `in`.vivek.interior.login

import `in`.vivek.interior.R
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import `in`.vivek.interior.ui.theme.NotesTheme
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel? = null,
    onNavToHomePage:() -> Unit,
    onNavToSignUpPage:() -> Unit,
) {
    val loginUiState = loginViewModel?.loginUiState
    val isError = loginUiState?.loginError != null
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .background(color = Color(0xFFA83FD5))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top

        //modifier = Modifier.fillMaxSize(),
        //horizontalAlignment = Alignment.CenterHorizontally,

    ) {

        Spacer(modifier = Modifier.size(20.dp))
       Text(

           text = "Welcome to Signin Screen",
           fontFamily = FontFamily.SansSerif,
           fontWeight = FontWeight.Bold,
           fontSize = 28.sp,
           modifier = Modifier.padding(top  = 16.dp)


           /* text = "Login",
           style = MaterialTheme.typography.h3,
           fontWeight = FontWeight.Black,
           color = MaterialTheme.colors.primary */
       )
        Spacer(modifier = Modifier.size(40.dp))
        Image(
            painterResource(id = R.drawable.lg),
            contentDescription = "Logo",
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.size(30.dp))
        Card(

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, Color.Black)
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(2.dp),
                modifier = Modifier.padding(all = 6.dp)
            ){

                if (isError){
                    Text(
                        text = loginUiState?.loginError ?: "unknown error",
                        color = Color.Red,
                    )
                }

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    placeholder = { Text(text = "example@domain.com")},
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Green,
                        unfocusedBorderColor = Color.DarkGray
                    ),
                    singleLine = true,

                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {focusManager.moveFocus(FocusDirection.Down)}
                    ),

                    value = loginUiState?.userName ?: "",
                    onValueChange = {loginViewModel?.onUserNameChange(it)},
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                        )
                    },
                    label = {
                        Text(text = "Email")
                    },
                    isError = isError
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    value = loginUiState?.password ?: "",
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Green,
                        unfocusedBorderColor = Color.DarkGray
                    ),
                    onValueChange = { loginViewModel?.onPasswordNameChange(it) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = null,
                        )
                    },
                    label = {
                        Text(text = "Password")
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    isError = isError
                )

                Button(onClick = { loginViewModel?.loginUser(context) }) {
                    Text(text = "Sign In")
                }

            }

        }




        Spacer(modifier = Modifier.size(16.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(text = "Don't have an Account?")
            Spacer(modifier = Modifier.size(1.dp))
            TextButton(onClick = { onNavToSignUpPage.invoke() }) {
                Text(text = "SignUp")
            }


        }

        if (loginUiState?.isLoading == true){
            CircularProgressIndicator()
        }

        LaunchedEffect(key1 = loginViewModel?.hasUser){
            if (loginViewModel?.hasUser == true){
                onNavToHomePage.invoke()
            }
        }


    }


}

@Composable
fun SignUpScreen(
    loginViewModel: LoginViewModel? = null,
    onNavToHomePage:() -> Unit,
    onNavToLoginPage:() -> Unit,
) {
    val loginUiState = loginViewModel?.loginUiState
    val isError = loginUiState?.signUpError != null
    val context = LocalContext.current

    Column(

        modifier = Modifier
            .background(color = Color(0xFFA83FD5))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top

        //modifier = Modifier.fillMaxSize(),
        //horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.size(20.dp))
       Text(

           text = "Welcome to Signup Screen",
           fontFamily = FontFamily.SansSerif,
           fontWeight = FontWeight.Bold,
           fontSize = 28.sp,
           modifier = Modifier.padding(top  = 16.dp)


           /*text = "Sign Up",
           style = MaterialTheme.typography.h3,
           fontWeight = FontWeight.Black,
           color = MaterialTheme.colors.primary*/
       )

        Spacer(modifier = Modifier.size(40.dp))
        Image(
            painterResource(id = R.drawable.lin),
            contentDescription = "Logo",
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.size(40.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, Color.Black)
        ){

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(2.dp),
                modifier = Modifier.padding(all = 6.dp)
            ){

                if (isError){
                    Text(
                        text = loginUiState?.signUpError ?: "unknown error",
                        color = Color.Red,
                    )
                }

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    value = loginUiState?.userNameSignUp ?: "",
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Green,
                        unfocusedBorderColor = Color.DarkGray
                    ),
                    onValueChange = {loginViewModel?.onUserNameChangeSignup(it)},
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                        )
                    },
                    label = {
                        Text(text = "Email")
                    },
                    isError = isError
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    value = loginUiState?.passwordSignUp ?: "",
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Green,
                        unfocusedBorderColor = Color.DarkGray
                    ),
                    onValueChange = { loginViewModel?.onPasswordChangeSignup(it) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = null,
                        )
                    },
                    label = {
                        Text(text = "Password")
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    isError = isError
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    value = loginUiState?.confirmPasswordSignUp ?: "",
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Green,
                        unfocusedBorderColor = Color.DarkGray
                    ),
                    onValueChange = { loginViewModel?.onConfirmPasswordChange(it) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = null,
                        )
                    },
                    label = {
                        Text(text = "Confirm Password")
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    isError = isError
                )

                Button(onClick = { loginViewModel?.createUser(context) }) {
                    Text(text = "Sign In")
                }


            }



        }



        Spacer(modifier = Modifier.size(16.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Already have an Account?")
            Spacer(modifier = Modifier.size(8.dp))
            TextButton(onClick = { onNavToLoginPage.invoke() }) {
                Text(text = "Sign In")
            }

        }

        if (loginUiState?.isLoading == true){
            CircularProgressIndicator()
        }

        LaunchedEffect(key1 = loginViewModel?.hasUser){
            if (loginViewModel?.hasUser == true){
                onNavToHomePage.invoke()
            }
        }



    }


}

@Preview(showSystemUi = true)
@Composable
fun PrevLoginScreen() {
    NotesTheme {
        LoginScreen(onNavToHomePage = { /*TODO*/ }) {

        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PrevSignUpScreen() {
    NotesTheme {
        SignUpScreen(onNavToHomePage = { /*TODO*/ }) {
            
        }
    }
}
















