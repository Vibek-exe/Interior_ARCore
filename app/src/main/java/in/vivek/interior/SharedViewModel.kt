package `in`.vivek.interior

import `in`.vivek.interior.models.FurnitureModel
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor() : ViewModel() {

    var data = FurnitureModel()

}