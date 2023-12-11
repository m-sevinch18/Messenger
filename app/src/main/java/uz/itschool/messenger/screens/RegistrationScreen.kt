package uz.itschool.messenger.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.itschool.messenger.R
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uz.itschool.messenger.navigation.NavGraph


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(navController: NavHostController) {
    var passwordVisibility by remember { mutableStateOf(false) }
    var emailAddress by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {

                Text(text = "Hello, Welcome to Messenger",
                    style = LocalTextStyle.current.copy(fontSize = 40.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(15.dp)
                        )


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .padding(vertical = 16.dp)
                        .background(MaterialTheme.colorScheme.background)
                        .align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                    text = "Happy to see you , to use your account please sign up first",
                    style = LocalTextStyle.current.copy(fontSize = 16.sp),
                    modifier = Modifier.padding(start=15.dp)
                        .width(250.dp)
                )
                    Spacer(modifier = Modifier.height(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.reg_screen_img),
                        contentDescription = "reg_screen_img",
                        modifier = Modifier
                            .size(150.dp)
                            .clip(shape = MaterialTheme.shapes.medium)
                            .background(MaterialTheme.colorScheme.background)
                            .clickable { /* Handle image click if needed */ }
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .onSizeChanged { size -> /* Handle size change if needed */ }
                ) {
                    EmailAndPasswordFields(
                        name = name,
                        onNameChanged = { name = it },
                        emailAddress = emailAddress,
                        onEmailChanged = { emailAddress = it },
                        password = password,
                        onPasswordChanged = { password = it },
                        repeatPassword = repeatPassword,
                        onRepeatPasswordChanged = { repeatPassword = it },
                        passwordVisibility = passwordVisibility,
                        onTogglePasswordVisibility = { passwordVisibility = it }
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = { /* Handle login button click */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .padding(start=10.dp, end=10.dp)
                    ) {
                        Text(text = "Sign up")
                    }
                    Spacer(modifier = Modifier.height(35.dp))
                    Text(
                        text = "------------- Or Sign Up with -------------",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .align(Alignment.CenterHorizontally),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        SmallPicture(R.drawable.ic_google) // Replace R.drawable.ic_google with the actual resource IDs
                        SmallPicture(R.drawable.ic_facebook)
                        SmallPicture(R.drawable.ic_instagram)
                    }
                }
            }
        }
    )
}

@Composable
fun PasswordVisibilityToggle(
    passwordVisibility: Boolean,
    onTogglePasswordVisibility: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = { onTogglePasswordVisibility(!passwordVisibility) },
        modifier = modifier
    ) {
        Icon(
            imageVector = if (passwordVisibility) Icons.Default.Done else Icons.Default.Close,
            contentDescription = null,
            tint = Color.Black // Change the tint color as needed
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailAndPasswordFields(
    name: String,
    onNameChanged: (String) -> Unit,
    emailAddress: String,
    onEmailChanged: (String) -> Unit,
    password: String,
    onPasswordChanged: (String) -> Unit,
    repeatPassword: String,
    onRepeatPasswordChanged: (String) -> Unit,
    passwordVisibility: Boolean,
    onTogglePasswordVisibility: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { onNameChanged(it) },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = emailAddress,
            onValueChange = { onEmailChanged(it) },
            label = { Text("Email Address") },
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { onPasswordChanged(it) },
            label = { Text("Password") },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(
                    onClick = { onTogglePasswordVisibility(!passwordVisibility) }
                ) {

                        Icon(
                            imageVector = if (passwordVisibility) Icons.Default.Done else Icons.Default.Close,
                            contentDescription = null,
                            tint = Color.Black // Change the tint color as needed
                        )
                    }

            },
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = repeatPassword,
            onValueChange = { onRepeatPasswordChanged(it) },
            label = { Text("Repeat Password") },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                PasswordVisibilityToggle(
                    passwordVisibility = passwordVisibility,
                    onTogglePasswordVisibility = onTogglePasswordVisibility,
                   // modifier = Modifier.align(Alignment.CenterVertically)
                )
            },
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
        )
    }
}
@Composable
fun SmallPicture(iconResId: Int) {
    Image(
        painter = painterResource(id = iconResId),
        contentDescription = null,
        modifier = Modifier.size(40.dp)
        .fillMaxWidth()
        .padding(horizontal = 8.dp)
//        .align(Alignment.CenterHorizontally),
//        alignment = Alignment.Center// Optional padding for separation

        )
}
@Preview(showBackground = true)
@Composable
fun showRegister(){
    val navController = rememberNavController()
    NavGraph(navController = navController)
    SplashScreen(navController = navController)
}