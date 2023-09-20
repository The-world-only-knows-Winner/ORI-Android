package com.onlywin.ori_android.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onlywin.ori_android.util.MutableEventFlow
import com.onlywin.ori_android.util.asEventFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<S : State, E : SideEffect>(default: S) : ViewModel() {
    private val _state: MutableStateFlow<S> = MutableStateFlow(default)
    val state = _state.asStateFlow()

    private val _sideEffect: MutableEventFlow<E> = MutableEventFlow()
    val sideEffect = _sideEffect.asEventFlow()

    internal fun setState(newState: S) {
        _state.tryEmit(newState)
    }

    internal fun postSideEffect(sideEffect: E) {
        viewModelScope.launch(Dispatchers.IO) {
            _sideEffect.emit(sideEffect)
        }
    }
}
