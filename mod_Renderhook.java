import java.util.Map;

import net.minecraft.client.Minecraft;

public class mod_Renderhook extends BaseMod {

    public mod_Renderhook() {
        ModLoader.SetInGameHook(this, true, true);
    }

    @Override
    public String Version() {
        return "1.7_01";
    }

    public static World           lastworld = null;
    public static RenderEntity entity;

    public static void spawn(Minecraft mc) {
        entity = new RenderEntity(mc, mc.theWorld);
        entity.setPosition(mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ);
        mc.theWorld.a((Entity) entity);
        entity.setPosition(mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ);
    }

    public boolean OnTickInGame(Minecraft mc) {
        if (mc.theWorld != lastworld) {
            // do spawny stuff here
            spawn(mc);
            lastworld = mc.theWorld;
        }
        return true;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void AddRenderer(Map map) {
        map.put(RenderEntity.class, new RenderHooks());
    }
}
