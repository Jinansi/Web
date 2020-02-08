package com.easypost.app;

import com.easypost.EasyPost;
import com.easypost.exception.EasyPostException;
import com.easypost.model.Event;
import com.easypost.net.EasyPostResource;

public class Webhook {

    public static void main(String[] args) {
        EasyPost.apiKey = "xIPc8HjQvHBzivveZd5dpA";

        try {
            Event event = Event.retrieve("evt_ZzMEqURE");
            EasyPostResource tracker = event.getResult();

            System.out.println(event.getDescription());
            System.out.println(tracker.getStatus());
            System.out.println(tracker.prettyPrint());

        } catch (EasyPostException e) {
            e.printStackTrace();
        }
    }
}
