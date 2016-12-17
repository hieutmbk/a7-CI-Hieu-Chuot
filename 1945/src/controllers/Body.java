package controllers;

import models.Model;

/**
 * Created by minhh on 14/12/2016.
 */
public interface Body { // Pure abstract
    Model getModel();
    void onContact(Body other);
}
