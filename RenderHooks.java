import java.util.ArrayList;

import net.minecraft.client.Minecraft;

import org.lwjgl.opengl.GL11;

public class RenderHooks extends Render {
    
    @SuppressWarnings("static-access")
    private void render(float renderTick) {
        RenderHelper.disableStandardItemLighting();
        Minecraft game = ModLoader.getMinecraftInstance();
        
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        
        //render here
        
        
        RenderHelper.enableStandardItemLighting();
    }

    @Override
    public void doRender(Entity dontcare0, double dontcare1, double dontcare2, double dontcare3, float dontcare4, float renderTick) {
        render(renderTick);
    }

}
