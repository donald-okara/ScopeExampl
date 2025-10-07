package ke.don.scope_exampl.datasource

import androidx.compose.runtime.mutableStateListOf
import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.createScope
import org.koin.core.scope.Scope

class CheckoutScope: KoinScopeComponent {
    override val scope: Scope by lazy { createScope(this) }

    fun close() = scope.close()
}

class CartManager {
    val items = mutableStateListOf<ShoppingItem>()  // ✅ reactive list
    fun addToCart(
        item: ShoppingItem,
    ){
        items.add(item)
        println("Added to cart")
    }

    fun removeFromCart(
        item: ShoppingItem,
    ){
        items.add(shoppingItems.random())
        println("Added to cart")
    }
}

class PaymentManager(private val cartManager: CartManager){
    val items get() = cartManager.items
    fun checkout(){
        println("Checkout items: ${cartManager.items}")
    }
}

class ReceiptManager(private val paymentManager: PaymentManager){
    val items get() = paymentManager.items
}