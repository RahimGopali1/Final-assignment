package com.example.todomvvm.addTask;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

public class ModelFactory extends ViewModelProvider.NewInstanceFactory {

    Application application;
    int taskId;

    public ModelFactory(Application application, int taskId){
        this.application = application;
        this.taskId = taskId;
    }

    @NonNull
    @Override
    public <T extends androidx.lifecycle.ViewModel> T create(@NonNull Class<T> modelClass) {
        return  (T) new ViewModel(application, taskId);
    }
}
