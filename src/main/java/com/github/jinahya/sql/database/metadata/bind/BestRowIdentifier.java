/*
 * Copyright 2011 Jin Kwon <jinahya at gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jinahya.sql.database.metadata.bind;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

/**
 * An entity class for binding the result of
 * {@link java.sql.DatabaseMetaData#getBestRowIdentifier(java.lang.String, java.lang.String, java.lang.String, int, boolean)}.
 *
 * @author Jin Kwon &lt;jinahya_at_gmail.com&gt;
 */
@XmlRootElement
@XmlType(propOrder = {
    "scope", "columnName", "dataType", "typeName", "columnSize",
    "bufferLength", "decimalDigits", "pseudoColumn"
})
public class BestRowIdentifier implements Serializable {

    private static final long serialVersionUID = -6733770602373723371L;

    // -------------------------------------------------------------------------
    @Override
    public String toString() {
        return super.toString() + "{"
               + "scope=" + getScope()
               + ",columnName=" + columnName
               + ",dataType=" + dataType
               + ",typeName=" + typeName
               + ",columnSize=" + columnSize
               + ",bufferLength=" + bufferLength
               + ",decimalDigits=" + decimalDigits
               + ",pseudoColumn=" + pseudoColumn
               + "}";
    }

    // ------------------------------------------------------------------- scope
//    public short getScope() {
//        return scope;
//    }
//
//    public void setScope(final short scope) {
//        this.scope = scope;
//    }
    // -------------------------------------------------------------- columnName
//    public String getColumnName() {
//        return columnName;
//    }
//
//    public void setColumnName(final String columnName) {
//        this.columnName = columnName;
//    }
    // ---------------------------------------------------------------- dataType
//    public int getDataType() {
//        return dataType;
//    }
//
//    public void setDataType(final int dataType) {
//        this.dataType = dataType;
//    }
    // ---------------------------------------------------------------- typeName
//    public String getTypeName() {
//        return typeName;
//    }
//
//    public void setTypeName(final String typeName) {
//        this.typeName = typeName;
//    }
    // -------------------------------------------------------------- columnSize
//    public int getColumnSize() {
//        return columnSize;
//    }
//
//    public void setColumnSize(final int columnSize) {
//        this.columnSize = columnSize;
//    }
    // ------------------------------------------------------------ bufferLength
//    public Integer getBufferLength() {
//        return bufferLength;
//    }
//
//    public void setBufferLength(final Integer bufferLength) {
//        this.bufferLength = bufferLength;
//    }
    // ----------------------------------------------------------- decimalDigits
//    public Short getDecimalDigits() {
//        return decimalDigits;
//    }
//
//    public void setDecimalDigits(final Short decimalDigits) {
//        this.decimalDigits = decimalDigits;
//    }
    // ------------------------------------------------------------ pseudoColumn
//    public short getPseudoColumn() {
//        return pseudoColumn;
//    }
//
//    public void setPseudoColumn(final short pseudoColumn) {
//        this.pseudoColumn = pseudoColumn;
//    }
    // -------------------------------------------------------------------------
    @Getter
    @Setter
    @Labeled("SCOPE")
    @XmlElement(required = true)
    private short scope;

    @Getter
    @Setter
    @Labeled("COLUMN_NAME")
    @XmlElement(required = true)
    private String columnName;

    @Getter
    @Setter
    @Labeled("DATA_TYPE")
    @XmlElement(required = true)
    private int dataType;

    @Getter
    @Setter
    @Labeled("TYPE_NAME")
    @XmlElement(required = true)
    private String typeName;

    @Getter
    @Setter
    @Labeled("COLUMN_SIZE")
    @XmlElement(required = true)
    private int columnSize;

    @Getter
    @Setter
    @Labeled("BUFFER_LENGTH")
    @Unused
    @XmlElement(nillable = true, required = true)
    private Integer bufferLength;

    @Getter
    @Setter
    @Labeled("DECIMAL_DIGITS")
    @Nillable
    @XmlElement(nillable = true, required = true)
    private Short decimalDigits;

    @Getter
    @Setter
    @Labeled("PSEUDO_COLUMN")
    @XmlElement(required = true)
    private short pseudoColumn;
}
