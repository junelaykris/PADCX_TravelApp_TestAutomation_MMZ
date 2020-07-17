package com.padcx.travelapp.travelapp_testautomation_mmz.mvp.impls

import com.padcx.travelapp.travelapp_testautomation_mmz.mvp.AbstractBasePresenter
import com.padcx.travelapp.travelapp_testautomation_mmz.mvp.BasePresenter
import com.padcx.travelapp.travelapp_testautomation_mmz.mvp.views.BaseView

/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
abstract class BaseAppPresenterImpl<V : BaseView> : AbstractBasePresenter<V>(), BasePresenter<V>