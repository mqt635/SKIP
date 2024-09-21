package com.android.skip.ui.settings.recent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.skip.R
import com.android.skip.util.DataStoreUtils
import com.blankj.utilcode.util.StringUtils.getString
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecentViewModel @Inject constructor() : ViewModel() {
    private val _excludeFromRecent = MutableLiveData(
        DataStoreUtils.getSyncData(
            getString(R.string.store_exclude_from_recent),
            false
        )
    )
    val excludeFromRecent: LiveData<Boolean> = _excludeFromRecent

    fun changeExcludeFromRecent(excludeFromRecent: Boolean) {
        _excludeFromRecent.postValue(excludeFromRecent)
    }
}