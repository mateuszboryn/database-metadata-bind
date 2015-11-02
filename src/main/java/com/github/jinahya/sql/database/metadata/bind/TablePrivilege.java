/*
 * Copyright 2013 Jin Kwon <onacit at gmail.com>.
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


import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


/**
 *
 * @author Jin Kwon <onacit at gmail.com>
 */
@XmlType(propOrder = {"grantor", "grantee", "privilege", "isGrantable"})
public class TablePrivilege {


    /**
     *
     * @param database
     * @param suppression
     * @param catalog
     * @param schemaPattern
     * @param tableNamePattern
     * @param tablePrivileges
     *
     * @throws SQLException
     *
     * @see DatabaseMetaData#getTablePrivileges(String, String, String)
     */
    public static void retrieve(
        final DatabaseMetaData database, final Suppression suppression,
        final String catalog, final String schemaPattern,
        final String tableNamePattern,
        final Collection<? super TablePrivilege> tablePrivileges)
        throws SQLException {

        if (database == null) {
            throw new NullPointerException("null database");
        }

        if (suppression == null) {
            throw new NullPointerException("null suppression");
        }

        if (tablePrivileges == null) {
            throw new NullPointerException("null tablePrivileges");
        }

        if (suppression.isSuppressed(Table.SUPPRESSION_PATH_TABLE_PRIVILEGES)) {
            return;
        }

        final ResultSet resultSet = database.getTablePrivileges(
            catalog, schemaPattern, tableNamePattern);
        try {
            while (resultSet.next()) {
                tablePrivileges.add(ColumnRetriever.retrieve(
                    TablePrivilege.class, suppression, resultSet));
            }
        } finally {
            resultSet.close();
        }
    }


    public static void retrieve(final DatabaseMetaData database,
                                final Suppression suppression,
                                final Table table)
        throws SQLException {

        if (database == null) {
            throw new NullPointerException("null database");
        }

        if (suppression == null) {
            throw new NullPointerException("null suppression");
        }

        if (table == null) {
            throw new NullPointerException("null table");
        }

        retrieve(database, suppression,
                 table.getSchema().getCatalog().getTableCat(),
                 table.getSchema().getTableSchem(),
                 table.getTableName(),
                 table.getTablePrivileges());

        for (final TablePrivilege tablePrivilege : table.getTablePrivileges()) {
            tablePrivilege.table = table;
        }
    }


    /**
     * Creates a new instance.
     */
    public TablePrivilege() {

        super();
    }


    // ----------------------------------------------------------------- grantor
    /**
     * Returns {@link #grantor}.
     *
     * @return {@link #grantor}.
     */
    public String getGrantor() {

        return grantor;
    }


    /**
     * Replaces {@link #grantor}.
     *
     * @param grantor {@link #grantor}.
     */
    public void setGrantor(final String grantor) {

        this.grantor = grantor;
    }


    // ----------------------------------------------------------------- grantee
    /**
     * Returns {@link #grantee}.
     *
     * @return {@link #grantee}.
     */
    public String getGrantee() {

        return grantee;
    }


    /**
     * Replaces {@link #grantee}.
     *
     * @param grantee {@link #grantee}.
     */
    public void setGrantee(final String grantee) {

        this.grantee = grantee;
    }


    // --------------------------------------------------------------- privilege
    public String getPrivilege() {

        return privilege;
    }


    public void setPrivilege(final String privilege) {

        this.privilege = privilege;
    }


    // ------------------------------------------------------------- isGrantable
    public String getIsGrantable() {

        return isGrantable;
    }


    public void setIsGrantable(final String isGrantable) {

        this.isGrantable = isGrantable;
    }


    // ------------------------------------------------------------------- table
    /**
     * Returns the parent table of this table privilege.
     *
     * @return the parent table.
     */
    public Table getTable() {

        return table;
    }


    public void setTable(final Table table) {

        this.table = table;
    }


    /**
     * table catalog (may be {@code null}).
     */
    @ColumnLabel("TABLE_CAT")
    @SuppressionPath("tablePrivilege/tableCat")
    @XmlAttribute
    private String tableCat;


    /**
     * table schema (may be {@code null}).
     */
    @ColumnLabel("TABLE_SCHEM")
    @SuppressionPath("tablePrivilege/tableSchem")
    @XmlAttribute
    private String tableSchem;


    /**
     * table name.
     */
    @ColumnLabel("TABLE_NAME")
    @XmlAttribute
    private String tableName;


    /**
     * grantor of access (may be {@code null}).
     */
    @ColumnLabel("GRANTOR")
    @SuppressionPath("tablePrivilege/grantor")
    @XmlElement(nillable = true, required = true)
    @NillableBySpecification
    private String grantor;


    /**
     * grantee of access.
     */
    @ColumnLabel("GRANTEE")
    @SuppressionPath("tablePrivilege/grantee")
    @XmlElement(nillable = false, required = true)
    private String grantee;


    /**
     * name of access (SELECT, INSERT, UPDATE, REFRENCES, ...).
     */
    @ColumnLabel("PRIVILEGE")
    @SuppressionPath("tablePrivilege/privilege")
    @XmlElement(nillable = false, required = true)
    private String privilege;


    /**
     * {@code YES} if grantee is permitted to grant to others; {@code NO} if
     * not; {@code null} if unknown.
     */
    @ColumnLabel("IS_GRANTABLE")
    @SuppressionPath("tablePrivilege/isGrantable")
    @XmlElement(nillable = true, required = true)
    @NillableBySpecification
    private String isGrantable;


    /**
     * parent table.
     */
    @XmlTransient
    private Table table;


}
