package io.github.alexlondon07.finalproject.presenter;

import io.github.alexlondon07.finalproject.helper.IValidateInternet;
import io.github.alexlondon07.finalproject.view.IBaseView;

/**
 * Created by alexlondon07 on 9/16/17.
 */

public class BasePresenter<T extends IBaseView> {
   private T view;
   private IValidateInternet validateInternet;

   public BasePresenter() {
   }

   public void inject(T view, IValidateInternet validateInternet){
      this.view = view;
      this.validateInternet = validateInternet;
   }

   public T getView() {
      return view;
   }

   public IValidateInternet getValidateInternet() {
      return validateInternet;
   }

}
