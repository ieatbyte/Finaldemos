package com.whlib.jlib.file;

import junit.framework.TestCase;

/**
 * Created by wanghui5-s on 2015/10/24.
 */
public class PathTest extends TestCase {

    public void testMergePathWithTailName() throws Exception {
        // normal test cases
        assertEquals("/data/data/file", Path.mergePathWithTailName("/data/data", "file", "/"));
        assertEquals("/data/data/file", Path.mergePathWithTailName("/data/data/", "file", "/"));
        assertEquals("/data/data/file", Path.mergePathWithTailName("/data/data", "/file", "/"));
        assertEquals("/data/data/file", Path.mergePathWithTailName("/data/data/", "/file", "/"));

        assertEquals("/file", Path.mergePathWithTailName("/", "/file", "/"));
        assertEquals("/file", Path.mergePathWithTailName("/", "file", "/"));
        assertEquals("/file", Path.mergePathWithTailName("", "file", "/"));
        assertEquals("data/", Path.mergePathWithTailName("data", "", "/"));

        assertEquals("/", Path.mergePathWithTailName("/", "/", "/"));
        assertEquals("/", Path.mergePathWithTailName("", "", "/"));

        assertNull(Path.mergePathWithTailName(null, "", "/"));
        assertNull(Path.mergePathWithTailName("", null, "/"));
        assertNull(Path.mergePathWithTailName(null, null, "/"));
    }
}