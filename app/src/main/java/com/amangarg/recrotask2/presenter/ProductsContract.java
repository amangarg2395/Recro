package com.amangarg.recrotask2.presenter;

import com.amangarg.recrotask2.models.ProductsResponse;

public interface ProductsContract {

    interface View extends BaseView{
        void showMainLoader();
        void showProductListView(ProductsResponse productsResponse);
    }

    interface Presenter extends BasePresenter<View>{
        void loadProducts();
    }
}
