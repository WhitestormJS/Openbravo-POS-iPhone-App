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

package com.openbravo.pos.catalog;

import java.awt.Component;
import java.awt.event.ActionListener;
import com.openbravo.basic.BasicException;

/**
 *
 * @author adrianromero
 */
public interface CatalogSelector {
    
    public void loadCatalog() throws BasicException;
    public void showCatalogPanel(String id);
    public void setComponentEnabled(boolean value);
    public Component getComponent();
    
    public void addActionListener(ActionListener l);  
    public void removeActionListener(ActionListener l);    
}
