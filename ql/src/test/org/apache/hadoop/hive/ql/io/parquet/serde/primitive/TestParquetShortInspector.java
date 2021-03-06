package org.apache.hadoop.hive.ql.io.parquet.serde.primitive;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.apache.hadoop.hive.serde2.io.ShortWritable;
import org.apache.hadoop.io.IntWritable;
import org.junit.Before;
import org.junit.Test;

public class TestParquetShortInspector {

  private ParquetShortInspector inspector;

  @Before
  public void setUp() {
    inspector = new ParquetShortInspector();
  }

  @Test
  public void testShortWritable() {
    ShortWritable obj = new ShortWritable((short) 5);
    assertEquals(obj, inspector.getPrimitiveWritableObject(obj));
    assertEquals((short) 5, inspector.getPrimitiveJavaObject(obj));
  }

  @Test
  public void testIntWritable() {
    IntWritable obj = new IntWritable(10);
    assertEquals(new ShortWritable((short) 10), inspector.getPrimitiveWritableObject(obj));
    assertEquals((short) 10, inspector.getPrimitiveJavaObject(obj));
  }

  @Test
  public void testNull() {
    assertNull(inspector.getPrimitiveWritableObject(null));
    assertNull(inspector.getPrimitiveJavaObject(null));
  }

  @Test
  public void testCreate() {
    assertEquals(new ShortWritable((short) 8), inspector.create((short) 8));
  }

  @Test
  public void testSet() {
    ShortWritable obj = new ShortWritable();
    assertEquals(new ShortWritable((short) 12), inspector.set(obj, (short) 12));
  }

  @Test
  public void testGet() {
    ShortWritable obj = new ShortWritable((short) 15);
    assertEquals((short) 15, inspector.get(obj));
  }
}
