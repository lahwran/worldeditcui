/**
 * 
 */
package net.lahwran;

import java.util.HashMap;

import net.lahwran.fevents.Cancellable;
import net.lahwran.fevents.Event;
import net.lahwran.fevents.HandlerList;
import net.lahwran.fevents.Order;
import net.lahwran.wecui.WorldEditCUI;

/**
 * @author lahwran
 *
 */
public class ChatCommandEvent extends Event<ChatCommandEvent> {

    public final String chat;
    public final String command;
    public final String[] args;
    private boolean handled;
    

    public ChatCommandEvent(String chat) {
        this.chat = chat;
        int firstspace =  chat.indexOf(' ');
        if (firstspace < 0) {
            this.command = chat.substring(1);
            this.args = new String[0];
        } else {
            this.command = chat.substring(1, firstspace);
            if (chat.length() - firstspace > 0)
                this.args = chat.substring(firstspace+1).split(" ");
            else
                this.args = new String[0];
        }
    }

    @Override
    protected String getEventName() {
        return "ChatEvent";
    }

    public static final HashMap<String, HandlerList<ChatCommandEvent>> allhandlers =
            new HashMap<String, HandlerList<ChatCommandEvent>>();
    public static final HandlerList<ChatCommandEvent> defaulthandlers =
            new HandlerList<ChatCommandEvent>();
    public static HandlerList<ChatCommandEvent> getHandlers(String command) {
        HandlerList<ChatCommandEvent> handlers = allhandlers.get(command);
        if (handlers == null) {
            handlers = new HandlerList<ChatCommandEvent>();
            allhandlers.put(command, handlers);
        }
        return handlers;
    }

    @Override
    protected HandlerList<ChatCommandEvent> getHandlers() {
        HandlerList<ChatCommandEvent> handlers = allhandlers.get(command);
        if (handlers == null)
            handlers = defaulthandlers;
        return handlers;
    }

    public void markHandled() {
        handled = true;
    }

    public boolean isHandled() {
        return handled;
    }

    public boolean isCancelled() {
        return isHandled();
    }
}
