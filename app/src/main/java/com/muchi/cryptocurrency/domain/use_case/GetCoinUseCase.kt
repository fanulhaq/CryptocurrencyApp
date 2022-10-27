package com.muchi.cryptocurrency.domain.use_case

import android.util.Log
import com.muchi.cryptocurrency.common.Resource
import com.muchi.cryptocurrency.data.remote.dto.toCoinDetail
import com.muchi.cryptocurrency.domain.model.CoinDetail
import com.muchi.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            Log.d("asasasasasa", "invoke: $coinId")
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error(e.message ?: "An unexpected error occurred"))
        }
    }
}
