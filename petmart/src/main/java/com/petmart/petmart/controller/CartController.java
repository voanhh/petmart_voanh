package com.petmart.petmart.controller;

import com.petmart.petmart.dto.CartItemDTO;
import com.petmart.petmart.services.imp.CartServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CartController {
    @Autowired private CartServiceImp cartService;

    /** Thêm hoặc cập nhật số lượng trong giỏ **/
    @PostMapping("/items")
    public List<CartItemDTO> addToCart(
            @RequestParam Integer userId,
            @RequestParam Integer productId,
            @RequestParam Integer quantity
    ) {
        return cartService.addToCart(userId, productId, quantity);
    }

    /** Lấy toàn bộ item trong giỏ **/
    @GetMapping("/items")
    public List<CartItemDTO> getCartItems(@RequestParam Integer userId) {
        return cartService.getCartItems(userId);
    }

    /** Xóa một item khỏi giỏ **/
    @DeleteMapping("/items")
    public List<CartItemDTO> removeItem(
            @RequestParam Integer userId,
            @RequestParam Integer productId
    ) {
        return cartService.removeItem(userId, productId);
    }
}

