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


package com.openbravo.data.gui;

import javax.swing.*;
import com.openbravo.data.loader.QBFCompareEnum;
/**
 *
 * @author  adrian
 */
public class ListQBFModelNumber extends AbstractListModel implements ComboBoxModel {
    
private Object[] m_items;
private Object m_sel;

/** Creates a new instance of ListQBFModelNumber */
//    public ListQBFModelNumber() {
    private ListQBFModelNumber(Object... items) {
        m_items = items;
        m_sel = m_items[0];
    }

//    m_items = new Object[] {
    public static ListQBFModelNumber getMandatoryString() {
        return new ListQBFModelNumber(
              QBFCompareEnum.COMP_NONE,
              QBFCompareEnum.COMP_EQUALS,
              QBFCompareEnum.COMP_RE,
              QBFCompareEnum.COMP_DISTINCT,
//            QBFCompareEnum.COMP_GREATER,
            QBFCompareEnum.COMP_GREATER,
              QBFCompareEnum.COMP_LESS,
//            QBFCompareEnum.COMP_GREATEROREQUALS,
            QBFCompareEnum.COMP_GREATEROREQUALS,
            QBFCompareEnum.COMP_LESSOREQUALS
        );
    }

    public static ListQBFModelNumber getMandatoryNumber() {
        return new ListQBFModelNumber(
            QBFCompareEnum.COMP_NONE,
            QBFCompareEnum.COMP_EQUALS,
            QBFCompareEnum.COMP_DISTINCT,
            QBFCompareEnum.COMP_GREATER,
            QBFCompareEnum.COMP_LESS,
            QBFCompareEnum.COMP_GREATEROREQUALS,
            QBFCompareEnum.COMP_LESSOREQUALS
        );
    }

    public static ListQBFModelNumber getNonMandatoryString() {
        return new ListQBFModelNumber(
            QBFCompareEnum.COMP_NONE,
            QBFCompareEnum.COMP_EQUALS,
            QBFCompareEnum.COMP_RE,
            QBFCompareEnum.COMP_DISTINCT,
            QBFCompareEnum.COMP_GREATER,
            QBFCompareEnum.COMP_LESS,
            QBFCompareEnum.COMP_GREATEROREQUALS,
              QBFCompareEnum.COMP_LESSOREQUALS,
              QBFCompareEnum.COMP_ISNULL,
//            QBFCompareEnum.COMP_ISNOTNULL,
//        };
//        m_sel = m_items[0];
            QBFCompareEnum.COMP_ISNOTNULL
        );
    }

    public static ListQBFModelNumber getNonMandatoryNumber() {
        return new ListQBFModelNumber(
            QBFCompareEnum.COMP_NONE,
            QBFCompareEnum.COMP_EQUALS,
            QBFCompareEnum.COMP_DISTINCT,
            QBFCompareEnum.COMP_GREATER,
            QBFCompareEnum.COMP_LESS,
            QBFCompareEnum.COMP_GREATEROREQUALS,
            QBFCompareEnum.COMP_LESSOREQUALS,
            QBFCompareEnum.COMP_ISNULL,
            QBFCompareEnum.COMP_ISNOTNULL
        );
      }

      public Object getElementAt(int index) {

        return m_items[index];
    }
   
    public int getSize() {
        return m_items.length;
    }
    
    public Object getSelectedItem() {
        return m_sel;
    }
     
    public void setSelectedItem(Object anItem) {
        m_sel = anItem;
    }
}
