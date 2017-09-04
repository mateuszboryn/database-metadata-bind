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

import javax.xml.bind.annotation.XmlRootElement;

/**
 * An entity class for binding the result of
 * {@link java.sql.DatabaseMetaData#getExportedKeys(java.lang.String, java.lang.String, java.lang.String)}.
 *
 * @author Jin Kwon &lt;jinahya_at_gmail.com&gt;
 * @see java.sql.DatabaseMetaData#getExportedKeys(java.lang.String,
 * java.lang.String, java.lang.String)
 * @see MetadataContext#getExportedKeys(java.lang.String, java.lang.String,
 * java.lang.String)
 */
@XmlRootElement
public class ExportedKey extends TableKey {

    private static final long serialVersionUID = 277210154172135556L;

    // -------------------------------------------------------------------------
}
