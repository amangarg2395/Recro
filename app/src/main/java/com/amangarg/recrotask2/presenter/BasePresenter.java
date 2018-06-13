package com.amangarg.recrotask2.presenter;

/**
 * Created by astrology on 27/01/17.
 */

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);

    void detachView();
}
