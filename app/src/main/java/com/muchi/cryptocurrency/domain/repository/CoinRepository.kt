package com.muchi.cryptocurrency.domain.repository

import com.muchi.cryptocurrency.data.remote.dto.CoinDetailDto
import com.muchi.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}