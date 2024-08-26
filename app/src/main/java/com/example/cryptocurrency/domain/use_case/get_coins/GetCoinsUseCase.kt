package com.example.cryptocurrency.domain.use_case.get_coins

import com.example.cryptocurrency.data.remote.dto.toCoin
import com.plcoding.cryptocurrency.common.Resource
import com.example.cryptocurrency.domain.model.Coin
import com.example.cryptocurrency.domain.model.CoinDetails
import com.example.cryptocurrency.domain.respository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val respository: CoinRepository
) {
    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = respository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))

        }catch (e: HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))

        }catch (e: IOException){
            emit(Resource.Error<List<Coin>>("Couldn't reach the server. Check you internet connection"))

        }


    }
}