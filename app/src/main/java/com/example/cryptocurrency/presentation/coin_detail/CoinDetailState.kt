package com.example.cryptocurrency.presentation.coin_detail

import com.example.cryptocurrency.domain.model.Coin
import com.example.cryptocurrency.domain.model.CoinDetails
import java.lang.Error

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetails? = null,
    val error: String = ""
)
