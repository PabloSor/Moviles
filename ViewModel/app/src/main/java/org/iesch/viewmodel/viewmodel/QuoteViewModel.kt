package org.iesch.viewmodel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.iesch.viewmodel.model.QuoteModel
import org.iesch.viewmodel.model.QuoteProvider


//Para convertir esta clase en viewmodel ha de extender de viewmodel
class QuoteViewModel : ViewModel(){
    // Encapsulamos el model que queremos en un LiveData. Porque su valor va a ir cambiando
    val quoteModel = MutableLiveData<QuoteModel>()

    // Este quoteModel va a ir cambiando con esta función , que va a ser llamada desde la activity
    fun randomQuote(){
        val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }
}