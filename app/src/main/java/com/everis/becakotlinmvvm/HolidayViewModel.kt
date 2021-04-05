package com.everis.becakotlinmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.everis.becakotlinmvvm.data.HolidayModel

class HolidayViewModel: ViewModel() {
    
    var holidayRepository: HolidayRepository? = null
    var mutableLiveData: MutableLiveData<List<HolidayModel>>? = null

    init {
        holidayRepository = HolidayRepository()
    }

    fun getHolidays(): LiveData<List<HolidayModel>> {
        if (mutableLiveData == null) {
            mutableLiveData = holidayRepository!!.fetchHolidays()
        }

        return mutableLiveData!!
    }

}