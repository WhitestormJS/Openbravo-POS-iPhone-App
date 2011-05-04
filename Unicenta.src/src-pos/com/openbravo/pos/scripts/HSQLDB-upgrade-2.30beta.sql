--    uniCenta oPOS - Touch Friendly Point Of Sale
--    Copyright (C) 2009 Openbravo, S.L.
--    http://sourceforge.net/projects/unicentaopos
--
--    This file is part of uniCenta oPOS.
--
--    uniCenta oPOS is free software: you can redistribute it and/or modify
--    it under the terms of the GNU General Public License as published by
--    the Free Software Foundation, either version 3 of the License, or
--    (at your option) any later version.
--
--    uniCenta oPOS is distributed in the hope that it will be useful,
--    but WITHOUT ANY WARRANTY; without even the implied warranty of
--    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
--    GNU General Public License for more details.
--
--    You should have received a copy of the GNU General Public License
--    along with uniCenta oPOS.  If not, see <http://www.gnu.org/licenses/>.

-- Database upgrade script for HSQLDB

-- v2.30beta - v2.30

ALTER TABLE ATTRIBUTEVALUE DROP CONSTRAINT ATTVAL_ATT;
ALTER TABLE ATTRIBUTEVALUE ADD CONSTRAINT ATTVAL_ATT FOREIGN KEY (ATTRIBUTE_ID) REFERENCES ATTRIBUTE(ID) ON DELETE CASCADE;

ALTER TABLE ATTRIBUTEUSE DROP CONSTRAINT ATTUSE_SET;
ALTER TABLE ATTRIBUTEUSE ADD CONSTRAINT ATTUSE_SET FOREIGN KEY (ATTRIBUTESET_ID) REFERENCES ATTRIBUTESET(ID) ON DELETE CASCADE;

ALTER TABLE ATTRIBUTESETINSTANCE DROP CONSTRAINT ATTSETINST_SET;
ALTER TABLE ATTRIBUTESETINSTANCE ADD CONSTRAINT ATTSETINST_SET FOREIGN KEY (ATTRIBUTESET_ID) REFERENCES ATTRIBUTESET(ID) ON DELETE CASCADE;

ALTER TABLE ATTRIBUTEINSTANCE DROP CONSTRAINT ATTINST_SET;
ALTER TABLE ATTRIBUTEINSTANCE ADD CONSTRAINT ATTINST_SET FOREIGN KEY (ATTRIBUTESETINSTANCE_ID) REFERENCES ATTRIBUTESETINSTANCE(ID) ON DELETE CASCADE;

ALTER TABLE PRODUCTS ALTER COLUMN ISCOM SET DEFAULT FALSE;
ALTER TABLE PRODUCTS ALTER COLUMN ISSCALE SET DEFAULT FALSE;
ALTER TABLE TAXES ALTER COLUMN RATECASCADE SET DEFAULT FALSE;
ALTER TABLE CUSTOMERS ALTER COLUMN VISIBLE SET DEFAULT TRUE;

-- final script

DELETE FROM SHAREDTICKETS;

UPDATE APPLICATIONS SET NAME = $APP_NAME{}, VERSION = $APP_VERSION{} WHERE ID = $APP_ID{};