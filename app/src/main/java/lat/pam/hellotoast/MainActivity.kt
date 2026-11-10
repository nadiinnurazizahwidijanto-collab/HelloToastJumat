
package lat.pam.hellotoast

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private var mCount = 0

    private lateinit var mShowCount: TextView
    private lateinit var buttonCountUp: Button
    private lateinit var buttonToast: Button

    // Mendeklarasikan ViewModel
    private val model: NameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menghubungkan komponen XML
        mShowCount = findViewById(R.id.show_count)
        buttonCountUp = findViewById(R.id.button_count)
        buttonToast = findViewById(R.id.button_toast)

        // Membuat observer untuk memperbarui tampilan
        val nameObserver = Observer<Int> { newName ->
            mShowCount.text = newName.toString()
        }

        // Mengamati perubahan LiveData
        model.currentName.observe(this, nameObserver)

        // Menampilkan nilai awal
        if (model.currentName.value == null) {
            model.currentName.value = mCount
        }

        // Tombol Count Up
        buttonCountUp.setOnClickListener {
            mCount = (model.currentName.value ?: 0) + 1

            // Mengirim nilai ke LiveData
            model.currentName.value = mCount
        }

        // Tombol Toast
        buttonToast.setOnClickListener {
            android.widget.Toast.makeText(
                this,
                "Hello Toast!",
                android.widget.Toast.LENGTH_SHORT
            ).show()
        }
    }
}
