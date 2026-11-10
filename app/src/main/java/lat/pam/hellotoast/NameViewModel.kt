
package lat.pam.hellotoast

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameViewModel : ViewModel() {

    // Membuat LiveData untuk menyimpan angka
    val currentName: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
}
