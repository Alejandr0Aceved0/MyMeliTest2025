package com.ingeacev.mymeliaplication.detail_product.domain.usecase

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.detail_product.data.model.ui.ItemDescription
import com.ingeacev.mymeliaplication.detail_product.data.respository.ProductRepository
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResultDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : ProductUseCase {

    override fun invoke(searchResultDto: SearchResultDto): Flow<Resource<ItemDescription>> {
        return productRepository.getProductDescription(product = searchResultDto)
    }

}
