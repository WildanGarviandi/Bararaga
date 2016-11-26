package com.ragamania.bararaga.view.activity.message_list;

import com.ragamania.bararaga.model.ChatListModel.Object;
import com.ragamania.bararaga.view.MvpView;

import java.util.List;

/**
 * Created by wildan on 23/11/16.
 */

public interface MessageMvpView extends MvpView {
    void loadMessage(List<Object> listMessage);
}
