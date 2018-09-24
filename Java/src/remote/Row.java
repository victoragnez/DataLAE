package remote;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Row implements Serializable{
	private static final long serialVersionUID = 82739273743928164L;
	
	public ArrayList<Object> row;
	
    public static Map <String, Class<?> > TYPE;

    static
    {
        TYPE = new HashMap<String, Class<?> >();

        TYPE.put("INTEGER", Integer.class);
        TYPE.put("TINYINT", Byte.class);
        TYPE.put("SMALLINT", Short.class);
        TYPE.put("BIGINT", Long.class);
        TYPE.put("REAL", Float.class);
        TYPE.put("FLOAT", Double.class);
        TYPE.put("DOUBLE", Double.class);
        TYPE.put("DECIMAL", BigDecimal.class);
        TYPE.put("NUMERIC", BigDecimal.class);
        TYPE.put("BOOLEAN", Boolean.class);
        TYPE.put("CHAR", String.class);
        TYPE.put("VARCHAR", String.class);
        TYPE.put("LONGVARCHAR", String.class);
        TYPE.put("DATE", Date.class);
        TYPE.put("TIME", Time.class);
        TYPE.put("TIMESTAMP", Timestamp.class);
    }

    public Row ()
    {
        row = new ArrayList<Object>();
    }

    public void add (String name, Object data, String sqlType)
    {
        row.add(Row.TYPE.get(sqlType).cast(data));
    }
}