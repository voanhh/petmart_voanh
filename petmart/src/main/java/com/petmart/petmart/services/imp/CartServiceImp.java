package com.petmart.petmart.services.imp;

import com.petmart.petmart.dto.CartItemDTO;
import java.util.List;

public interface CartServiceImp {
    List<CartItemDTO> addToCart(Integer userId, Integer productId, Integer qty);
    List<CartItemDTO> getCartItems(Integer userId);
    List<CartItemDTO> removeItem(Integer userId, Integer productId);
}

