//    SmartPos - Smart Touch Point of Sale
//    Copyright (c) 2009-20162009 Openbravo, S.L.
//    https://unicenta.com
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

package com.openbravo.pos.scale;

public class ScaleFake implements Scale {
    
    /** Creates a new instance of ScaleFake */
    public ScaleFake() {
    }
    
    /**
     *
     * @return
     * @throws ScaleException
     */
    @Override
    public Double readWeight() throws ScaleException {
        return new Double(Math.random() * 2.0);
    }
    
}
