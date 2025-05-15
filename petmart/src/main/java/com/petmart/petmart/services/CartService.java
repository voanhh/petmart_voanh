package com.petmart.petmart.services;

import com.petmart.petmart.dto.CartItemDTO;
import com.petmart.petmart.entity.Cart;
import com.petmart.petmart.entity.CartItem;
import com.petmart.petmart.reposistory.CartItemRepository;
import com.petmart.petmart.reposistory.CartRepository;
import com.petmart.petmart.reposistory.ProductRepository;
import com.petmart.petmart.reposistory.CartRepository;
import com.petmart.petmart.reposistory.CartItemRepository;
import com.petmart.petmart.reposistory.ProductRepository;
import com.petmart.petmart.services.imp.CartServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService implements CartServiceImp {
    @Autowired private CartRepository cartRepo;
    @Autowired private CartItemRepository itemRepo;
    @Autowired private ProductRepository productRepo;

    @Override
    @Transactional
    public List<CartItemDTO> addToCart(Integer userId, Integer productId, Integer qty) {
        Cart cart = cartRepo.findByUserId(userId)
                .orElseGet(() -> {
                    Cart c = new Cart();
                    c.setUserId(userId);
                    return cartRepo.save(c);
                });

        CartItem item = itemRepo.findByCart_CartIdAndProduct_ProductId(cart.getCartId(), productId)
                .orElseGet(() -> {
                    CartItem ci = new CartItem();
                    ci.setCart(cart);
                    ci.setProduct(productRepo.findById(productId)
                            .orElseThrow(() -> new RuntimeException("Product not found")));
                    ci.setQuantity(0);
                    return ci;
                });

        item.setQuantity(item.getQuantity() + qty);
        itemRepo.save(item);

        return getCartItems(userId);
    }

    @Override
    public List<CartItemDTO> getCartItems(Integer userId) {
        return cartRepo.findByUserId(userId)
                .map(c -> itemRepo.findByCart_CartId(c.getCartId()))
                .orElse(List.of())
                .stream()
                .map(i -> new CartItemDTO(
                        i.getCartItemId(),
                        i.getProduct().getProductId(),
                        i.getProduct().getProductName(),
                        i.getProduct().getPrice(),
                        i.getQuantity()))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<CartItemDTO> removeItem(Integer userId, Integer productId) {
        Cart cart = cartRepo.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        itemRepo.findByCart_CartIdAndProduct_ProductId(cart.getCartId(), productId)
                .ifPresent(itemRepo::delete);
        return getCartItems(userId);
    }
}
