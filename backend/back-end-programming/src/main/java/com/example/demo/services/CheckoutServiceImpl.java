package com.example.demo.services;

import com.example.demo.dao.CartItemRepository;
import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Excursion;
import com.example.demo.entities.StatusType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse checkout(Purchase purchase) {
        try {
            Cart cart = purchase.getCart();
            if (cart == null || purchase.getCartItems() == null || purchase.getCartItems().isEmpty()) {
                throw new IllegalArgumentException("Cart is null or cart items are empty");
            }
            Customer customer = purchase.getCustomer();

            if (customer == null){
                throw new IllegalArgumentException("Customer is null.");
            }

            if (cart == null){
                throw new IllegalArgumentException("Cart is null");
            }

            if (customer.getId() == null) {
                customer = customerRepository.save(customer);
            }

            String orderTrackingNumber = generateOrderTrackingNumber();
            cart.setOrderTrackingNumber(orderTrackingNumber);
            cart.setStatus(StatusType.ordered);

            customer.add(cart);

            cart = cartRepository.save(cart);

            Set<CartItem> cartItems = purchase.getCartItems();
            for (CartItem cartItem : cartItems) {
                cartItem.setCart(cart);
                cartItem = cartItemRepository.save(cartItem);

                Set<Excursion> excursions = cartItem.getExcursions();
                for (Excursion excursion : excursions) {
                    excursion.getCartItems().add(cartItem);
                }
            }
            return new PurchaseResponse(orderTrackingNumber);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            return new PurchaseResponse("Error: " + e.getMessage());
        }
    }
    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}