//    uniCenta oPOS  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2010 uniCenta
//    http://www.unicenta.net/unicentaopos
//
//    This file is part of uniCenta oPOS
//
//    uniCenta oPOS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//   uniCenta oPOS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with uniCenta oPOS.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.printer.ticket;

import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class PrintItemLine implements PrintItem {

    protected Font font;
    protected int fontheight;
    protected int textsize;
    protected List<StyledText> m_atext;

    /** Creates a new instance of PrinterItemLine */
    public PrintItemLine(int textsize, Font font, int fontheight) {
        this.textsize = textsize;
        this.font = font;
        this.fontheight = fontheight;

        m_atext = new ArrayList<StyledText>();
    }

    public void addText(int style, String text) {
        m_atext.add(new StyledText(style, text));
    }

    public void draw(Graphics2D g, int x, int y, int width) {

        MyPrinterState ps = new MyPrinterState(textsize);
        float left = x;
        for (int i = 0; i < m_atext.size(); i++) {
            StyledText t = m_atext.get(i);
            g.setFont(ps.getFont(font, t.style));
            g.drawString(t.text, left, (float) y);
            left += g.getFontMetrics().getStringBounds(t.text, g).getWidth();
        }
    }

    public int getHeight() {
        return fontheight * MyPrinterState.getLineMult(textsize);
    }

    protected static class StyledText {

        public StyledText(int style, String text) {
            this.style = style;
            this.text = text;
        }
        public int style;
        public String text;
    }
}
