import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import devandroid.rafael.telacadastro.R

class RegisterActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        sharedPreferences = getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)

        val buttonRegister = findViewById<Button>(R.id.buttonRegister)
        val editTextNewUsername = findViewById<EditText>(R.id.editTextNewUsername)
        val editTextNewPassword = findViewById<EditText>(R.id.editTextNewPassword)
        val textViewRegisterResult = findViewById<TextView>(R.id.textViewRegisterResult)

        buttonRegister.setOnClickListener {
            val newUsername = editTextNewUsername.text.toString()
            val newPassword = editTextNewPassword.text.toString()

            // Salvar os dados do novo usuário no SharedPreferences
            val editor = sharedPreferences.edit()
            editor.putString("username", newUsername)
            editor.putString("password", newPassword)
            editor.apply()

            textViewRegisterResult.text = "Novo usuário registrado:\nUsuário: $newUsername\nSenha: $newPassword"
        }
    }
}
