package com.NextUp.nextup.services;

import org.springframework.stereotype.Service;


import com.NextUp.nextup.repository.NotificationRepository;



@Service
public class NotificationService {
    public NotificationService(NotificationRepository notificationRepo) {
    }

    public void markAsRead(Long notificationId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'markAsRead'");
    }

    public Object getNotifications(Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNotifications'");
    }

    public void send(Object student, String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'send'");
    }

   
}