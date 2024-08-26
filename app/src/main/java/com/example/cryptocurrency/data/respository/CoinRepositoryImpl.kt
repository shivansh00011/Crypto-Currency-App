package com.example.cryptocurrency.data.respository

import com.example.cryptocurrency.data.remote.CoinPaprikaApi
import com.example.cryptocurrency.data.remote.dto.CoinDetailDto
import com.example.cryptocurrency.data.remote.dto.CoinDto
import com.example.cryptocurrency.domain.respository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinsById(coinId: String): CoinDetailDto {
        return api.getCoinsById(coinId)
    }
}