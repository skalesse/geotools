package org.geotools.data.oracle;

import java.io.IOException;
import java.util.Map;

/**
 * Oracle Database (JDBC, OCI wallet support) -
 *
 * <p>This store works in principle just like 'Oracle NG' but makes no restrictions on the input of the database
 * connection string. It supports all allowed forms of Oracle JDBC URI syntax by preceding the input to the field:
 * 'dbconnection' by 'jdbc:oracle:thin:@'. In particular, this allows use of database aliases in combination with OCI
 * wallets.
 *
 * <p>This implementation is basically necessary. because {@link OracleNGDataStoreFactory} has some complex parsing of
 * the 'database' input string, that leads to the fact that OCI wallet aliases from 'tnsnames.ora' files, won't work.
 * The {@link OracleNGOCIDataStoreFactory} class could have been an alternative, but unfortunately relies on the
 * existence of a native library, which is not desirable in most cases. Hence, this class: it combines the pure JDBC
 * functionality of {@link OracleNGDataStoreFactory} with the flexibility of the connection input string.
 *
 * <p>Some useful links
 *
 * <ul>
 *   <li><a href="https://www.oracle.com/database/technologies/java-connectivity-to-atp.html#pre-requisites-tab">...</a>
 *   <li><a href="https://docs.oracle.com/en/database/oracle/oracle-database/21/jajdb/index.html">...</a>
 *   <li><a
 *       href="https://docs.oracle.com/en/database/oracle/oracle-database/19/jjdbc/data-sources-and-URLs.html">...</a>
 * </ul>
 *
 * @author Soeren Kalesse
 * @since 2024-01-22
 */
public class OracleJDBCThinDataStoreFactory extends OracleNGDataStoreFactory {

    private static final String JDBC_PATH = "jdbc:oracle:thin:@";

    /** The connection input string parameter used to specify the database to connect to */
    public static final Param DB_CONNECTION = new Param(
            "dbconnection",
            String.class,
            "The database connection (will be preceded by '" + JDBC_PATH + "'). "
                    + "This can be either a TNS alias, or a db connection string, or //host:port:db, "
                    + "or whatever is a correct database URI notation",
            true);

    @Override
    public String getDisplayName() {
        return "Oracle NG+";
    }

    @Override
    public String getDescription() {
        return "Oracle Database (JDBC, OCI wallet support) - "
                + "This store works in principle just like 'Oracle NG' "
                + "but makes no restrictions on the input of the database connection string. "
                + "It supports all allowed forms of Oracle JDBC URI syntax by preceding "
                + "the input to the field: '" + DB_CONNECTION.key + "' by '" + JDBC_PATH + "'. In particular, "
                + "this allows use of database aliases in combination with OCI wallets.";
    }

    @Override
    protected String getJDBCUrl(Map<String, ?> params) throws IOException {
        return JDBC_PATH + DB_CONNECTION.lookUp(params);
    }

    @Override
    protected void setupParameters(Map<String, Object> parameters) {
        parameters.put(
                DBTYPE.key, new Param(DBTYPE.key, DBTYPE.type, DBTYPE.description, DBTYPE.required, getDatabaseID()));
        parameters.put(SCHEMA.key, SCHEMA);

        parameters.put(DB_CONNECTION.key, DB_CONNECTION);

        parameters.put(USER.key, USER);
        parameters.put(PASSWD.key, PASSWD);
        parameters.put(NAMESPACE.key, NAMESPACE);
        parameters.put(MAXCONN.key, MAXCONN);
        parameters.put(MINCONN.key, MINCONN);
        parameters.put(FETCHSIZE.key, FETCHSIZE);
        parameters.put(BATCH_INSERT_SIZE.key, BATCH_INSERT_SIZE);
        parameters.put(MAXWAIT.key, MAXWAIT);

        parameters.put(PK_METADATA_TABLE.key, PK_METADATA_TABLE);

        parameters.put(LOOSEBBOX.key, LOOSEBBOX);
        parameters.put(MAX_OPEN_PREPARED_STATEMENTS.key, MAX_OPEN_PREPARED_STATEMENTS);

        parameters.put(ESTIMATED_EXTENTS.key, ESTIMATED_EXTENTS);
        parameters.put(GEOMETRY_METADATA_TABLE.key, GEOMETRY_METADATA_TABLE);
        parameters.put(METADATA_BBOX.key, METADATA_BBOX);
        parameters.put(GET_REMARKS.key, GET_REMARKS);

        if (getValidationQuery() != null) {
            parameters.put(VALIDATECONN.key, VALIDATECONN);
        }
    }
}
