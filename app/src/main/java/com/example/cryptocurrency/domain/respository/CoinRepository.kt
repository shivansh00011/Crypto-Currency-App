package com.example.cryptocurrency.domain.respository

import android.adservices.adid.AdId
import com.example.cryptocurrency.data.remote.dto.CoinDetailDto
import com.example.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>
    suspend fun getCoinsById(coinId: String): CoinDetailDto
}