package com.example.messagecenter.ui.fragment

import com.example.baselibrary.ui.fragment.BaseMvpFragment
import com.example.messagecenter.presenter.MessagePresenter
import com.example.messagecenter.presenter.view.MessageView

/**
 * Created by mac on 2018/7/8.
 */
class MessageFragment: BaseMvpFragment<MessagePresenter>(), MessageView {
    override fun injectComponent() {
    }
}