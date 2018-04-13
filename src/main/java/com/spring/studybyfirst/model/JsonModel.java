package com.spring.studybyfirst.model;

import com.google.gson.Gson;

public class JsonModel {
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
