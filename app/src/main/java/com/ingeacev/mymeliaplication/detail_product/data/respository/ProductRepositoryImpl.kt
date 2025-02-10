package com.ingeacev.mymeliaplication.detail_product.data.respository

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.detail_product.data.datasource.remote.GetProductDescriptionDataSource
import com.ingeacev.mymeliaplication.detail_product.data.model.remote.toItemDescription
import com.ingeacev.mymeliaplication.detail_product.data.model.ui.ItemDescription
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResultDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val getProductDescriptionDataSource: GetProductDescriptionDataSource
) : ProductRepository {


    override fun getProductDescription(product: SearchResultDto): Flow<Resource<ItemDescription>> {
        return flow {
            when (val response = getProductDescriptionDataSource.getItemDescription(product.id.toString())) {
                is Resource.Success -> {
                    emit(Resource.Success(response.data?.toItemDescription(product)))
                }

                else -> {
                    emit(
                        Resource.GenericDataError(
                            response.errorCode,
                            response.errorMessage
                        )
                    )
                }
            }
        }
    }
}