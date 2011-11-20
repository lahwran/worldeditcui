/**
 * 
 */
package net.lahwran.obf;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.Field;
import java.util.Map;

import net.lahwran.ChatCommandEvent;
import net.lahwran.ChatEvent;
import net.lahwran.ChatEvent.Direction;
import net.lahwran.fevents.EventManager;


import deobf.kx;
import deobf.vc;
import deobf.vl;
import deobf.yc;

/**
 * @author lahwran
 *
 */
public class Packet3EventChat extends yc {
    private static boolean registered = false;
    private boolean cancelled = false;

    public Packet3EventChat() {
        super();
    }

    public Packet3EventChat(String s) {
        super(s);
        ChatEvent chatevent = new ChatEvent(s, Direction.OUTGOING);
        EventManager.callEvent(chatevent);
        if (!chatevent.isCancelled() && s.startsWith("/") && s.length() > 1) {
            ChatCommandEvent commandevent = new ChatCommandEvent(s);
            EventManager.callEvent(chatevent);
            if (commandevent.isHandled())
                cancelled = true;
        } else {
            cancelled = true;
        }
    }

    @SuppressWarnings("unchecked")
    public static void register() {
        if (registered)
            return;
        registered = true;
        try {
            Class<vl> packetclass = vl.class;
            Field idstoclassesfield;
            Field classestoidsfield;
            try {
                idstoclassesfield = packetclass.getDeclaredField("a");
                classestoidsfield = packetclass.getDeclaredField("b");
            } catch (NoSuchFieldException e) {
                try {
                    idstoclassesfield = packetclass.getDeclaredField("packetIdToClassMap");
                    classestoidsfield = packetclass.getDeclaredField("packetClassToIdMap");
                } catch (NoSuchFieldException e1) {
                    e.printStackTrace();
                    throw e1;
                }
            }
            idstoclassesfield.setAccessible(true);
            classestoidsfield.setAccessible(true);
            vc idstoclasses = (vc) idstoclassesfield.get(null);
            Map<Class<?>, Integer> classestoids = (Map<Class<?>, Integer>) classestoidsfield.get(null);
            idstoclasses.a(3, Packet3EventChat.class);
            classestoids.put(Packet3EventChat.class, 3);
        } catch (Exception e) {
            throw new RuntimeException("Error inserting chat handler - WorldEditClientUserInterface and anything that depends on it will not work!", e);
        }
    }

    public void a(DataOutputStream dataoutputstream) {
        if (!cancelled)
            a(a, dataoutputstream);
    }

    public void a(kx kx1) {
        ChatEvent chatevent = new ChatEvent(a, Direction.INCOMING);
        EventManager.callEvent(chatevent);
        if (!chatevent.isCancelled())
            kx1.a(this);
    }
}
