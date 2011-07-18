import net.minecraft.client.Minecraft;

/**
 * 
 */

/**
 * @author lahwran
 * 
 */
public class RenderEntity extends Entity {

    Minecraft mc;
    
    public RenderEntity(Minecraft mc, World arg0) {
        super(arg0);
        ignoreFrustumCheck = true;
        this.mc = mc;
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound arg0) {
    }

    @Override
    protected void entityInit() {
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound arg0) {
    }

    @Override
    public void onUpdate() {
        this.setPosition(mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ);
    }

    @Override
    public void setEntityDead() {
    }
}
