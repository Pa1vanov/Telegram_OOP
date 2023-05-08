package jk.uz.pdp.service.message;

import jk.uz.pdp.model.Message;
import jk.uz.pdp.service.BaseService;

import java.util.ArrayList;

public interface MessageService extends BaseService<Message> {
    ArrayList<Message> messages = new ArrayList<>();

    Message[] getByUserIdAndReceiverId(Long userId, Long receiverId);

}
