package com.example.cryptocurrency.domain.use_case.get_coin

import com.example.cryptocurrency.data.remote.dto.toCoin
import com.example.cryptocurrency.data.remote.dto.toCoinDetails
import com.plcoding.cryptocurrency.common.Resource
import com.example.cryptocurrency.domain.model.Coin
import com.example.cryptocurrency.domain.model.CoinDetails
import com.example.cryptocurrency.domain.respository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val respository: CoinRepository
) {
    operator fun invoke(coinId: String) : Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading<CoinDetails>())
            val coin = respository.getCoinsById(coinId).toCoinDetails()
            emit(Resource.Success<CoinDetails>(coin))

        }catch (e: HttpException){
            emit(Resource.Error<CoinDetails>(e.localizedMessage ?: "An unexpected error occured"))

        }catch (e: IOException){
            emit(Resource.Error<CoinDetails>("Couldn't reach the server. Check you internet connection"))

        }


    }
}