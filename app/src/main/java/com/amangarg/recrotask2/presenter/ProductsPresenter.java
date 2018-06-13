//package com.amangarg.recrotask2.presenter;
//
//import com.amangarg.recrotask2.models.ProductsRequestBody;
//import com.amangarg.recrotask2.models.ProductsResponse;
//import com.amangarg.recrotask2.rest.RestProvider;
//import com.google.gson.Gson;
//
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import rx.Subscriber;
//import rx.schedulers.Schedulers;
//import rx.subscriptions.CompositeSubscription;
//
//public class ProductsPresenter implements ProductsContract.Presenter {
//
//    private CompositeSubscription mCompositeSubscription = new CompositeSubscription();
//    ProductsContract.View mView;
//
//    @Override
//    public void attachView(ProductsContract.View view) {
//
//        this.mView = view;
//
//    }
//
////    @Override
////    public void loadProducts() {
////
////        ProductsRequestBody productsRequestBody = new ProductsRequestBody(2.1,  123.1, "" );
////
////        mCompositeSubscription.add(RestProvider.getProductsService().getProductsList("",productsRequestBody, "")
////                .subscribeOn(Schedulers.io())
////                .observeOn(AndroidSchedulers.mainThread())
////                .subscribe(new Subscriber<ProductsResponse>() {
////                    @Override
////                    public void onCompleted() {
////
////                    }
////
////                    @Override
////                    public void onError(Throwable e) {
////
////                    }
////
////                    @Override
////                    public void onNext(ProductsResponse productsResponse) {
////
////                        mView.showProductListView(productsResponse);
////
////
//////
////                    }
////                }));
////
////
////    }
//
//    @Override
//    public void detachView() {
//
//    }
//}
