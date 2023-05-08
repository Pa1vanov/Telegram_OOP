package jk.uz.pdp.service.message;

import jk.uz.pdp.model.Message;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MessageServiceImpl implements MessageService{
    private Long id = 0L;

    @Override
    public int create(Message message) {
        message.setId(id++);
        messages.add(message);
        return 0;
    }

    @Override
    public Message getById(Long id) {
        for (Message message: messages) {
            if(message.getId().equals(id)) {
                return message;
            }
        }
        return null;
    }

    @Override
    public Message updateById(Message update) {
        int i = 0;
        for (Message message:messages) {
            if(message.getId().equals(update.getId())) {
                messages.set(i, update);
                return update;
            }
            i++;
        }
        return null;
    }

    @Override
    public int deleteById(Long id) {
        for (Message message: messages) {
            if(message.getId().equals(id)) {
                messages.remove(message);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public ArrayList<Message> getByUserIdAndReceiverId(Long userId, Long receiverId) {
        ArrayList<Message> chatMessages = new ArrayList<>();

        for(Message message:messages) {
            if (message.getFromId().equals(userId)
                && message.getToId().equals(receiverId)) {
                chatMessages.add(message);
            } else if (message.getFromId().equals(receiverId)
                       && message.getToId().equals(userId)) {
                chatMessages.add(message);
            }
        }

        return chatMessages;
    }

    public Set<Long> chats(Long userId) {
        Set<Long> userChats = new HashSet<>();

        for (Message message: messages) {
            if(message.getFromId().equals(userId)) {
                userChats.add(message.getToId());
            } else if (message.getToId().equals(userId)) {
                userChats.add(message.getFromId());
            }
        }
        return userChats;
    }
}
