package com.example.demo.services;

import com.example.demo.entities.StatusType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PurchaseResponse {
    private final String orderTrackingNumber;
    private StatusType status;

}
