package com.gundom.Service;

import com.gundom.Domain.User;

import java.util.List;

public interface OrderService {
    public User initOrder(String userId);

    public List<User> queryByRange();
}
