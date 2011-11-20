/**
 * 
 */
package net.lahwran.wecui;

import net.lahwran.wecui.rendering.HighlightPosition;
import net.lahwran.wecui.rendering.LineInfo;
import net.lahwran.wecui.rendering.RenderShapes;

import org.lwjgl.opengl.GL11;


/**
 * @author lahwran
 *
 */
public class CuboidRegion extends CuiRegion {

    /**
     * highlight points
     */
    protected HighlightPosition[] pts;

    /**
     * Bounding box
     */
    public double x1, y1, z1, x2, y2, z2;

    /**
     * Initializes the thingy
     */
    public CuboidRegion() {
        pts = new HighlightPosition[2];
        pts[0] = new HighlightPosition(Colors.firstnormal, Colors.firsthidden);
        pts[1] = new HighlightPosition(Colors.secondnormal, Colors.secondhidden);
    }

    @Override
    public void render() {
        pts[0].render();
        pts[1].render();
        if (pts[0].active && pts[1].active) {
            RenderShapes.gridSurface(Colors.gridnormal, x1, y1, z1, x2, y2, z2);
            RenderShapes.gridSurface(Colors.gridhidden, x1, y1, z1, x2, y2, z2);
            RenderShapes.box(Colors.boxhidden, x1, y1, z1, x2, y2, z2);
            RenderShapes.box(Colors.boxnormal, x1, y1, z1, x2, y2, z2);
        }
    }

    /**
     * recalculates the bounding box
     */
    private void calcBounds() {
        double off = 0.02;
        double off1 = 1 + off;
        x1 = Double.MAX_VALUE;
        y1 = Double.MAX_VALUE;
        z1 = Double.MAX_VALUE;
        x2 = -Double.MAX_VALUE;
        y2 = -Double.MAX_VALUE;
        z2 = -Double.MAX_VALUE;

        for (int index = 0; index < pts.length; index++) {
            HighlightPosition pos = pts[index];
            if (!pos.active)
                continue;
            if (pos.x + off1 > x2)
                x2 = pos.x + off1;

            if (pos.x - off < x1)
                x1 = pos.x - off;

            if (pos.y + off1 > y2)
                y2 = pos.y + off1;

            if (pos.y - off < y1)
                y1 = pos.y - off;

            if (pos.z + off1 > z2)
                z2 = pos.z + off1;

            if (pos.z - off < z1)
                z1 = pos.z - off;
        }
    }

    @Override
    public void setPoint(int id, int x, int y, int z, int regionSize) {
        if (id < pts.length) {
            pts[id].x = x;
            pts[id].y = y;
            pts[id].z = z;
            pts[id].active = true;
            calcBounds();
        }
    }

}
