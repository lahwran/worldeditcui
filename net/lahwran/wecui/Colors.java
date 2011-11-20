/**
 * 
 */
package net.lahwran.wecui;

import net.lahwran.wecui.rendering.LineInfo;

import org.lwjgl.opengl.GL11;

/**
 * @author lahwran
 *
 */
public class Colors {

    public static LineInfo firstnormal = new LineInfo(3.0f, 0.2f, 0.8f, 0.2f, 0.8f, GL11.GL_LESS);
    public static LineInfo firsthidden = new LineInfo(2.0f, 0.2f, 0.8f, 0.2f, 0.2f, GL11.GL_GEQUAL);

    public static LineInfo secondnormal = new LineInfo(3.0f, 0.2f, 0.2f, 0.8f, 0.8f, GL11.GL_LESS);
    public static LineInfo secondhidden = new LineInfo(2.0f, 0.2f, 0.2f, 0.8f, 0.2f, GL11.GL_GEQUAL);

    public static LineInfo polynormal = new LineInfo(3.0f, 0.2f, 0.8f, 0.8f, 0.8f, GL11.GL_LESS);
    public static LineInfo polyhidden = new LineInfo(2.0f, 0.2f, 0.8f, 0.8f, 0.2f, GL11.GL_GEQUAL);

    public static LineInfo gridnormal = new LineInfo(2.0f, 0.8F, 0.2F, 0.2F, 0.6f, GL11.GL_LESS);
    public static LineInfo gridhidden = new LineInfo(1f, 0.8F, 0.2F, 0.2F, 0.15f, GL11.GL_GEQUAL);

    public static LineInfo boxnormal = new LineInfo(3.0f, 0.8F, 0.2F, 0.2F, 0.8f, GL11.GL_LESS);
    public static LineInfo boxhidden = new LineInfo(2.0f, 0.8F, 0.2F, 0.2F, 0.2f, GL11.GL_GEQUAL);
}
