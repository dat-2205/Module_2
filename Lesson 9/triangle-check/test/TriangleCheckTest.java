import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleCheckTest {
    @Test
    public void TriangleCheckTest01() {
        int side1 = 2;
        int side2 = 2;
        int side3 = 2;
        String expected = "Tam giac deu";
        String result = TriangleCheck.checkTriangle(side1,side2,side3);

        assertEquals(expected,result);
    }
    @Test
    public void TriangleCheckTest02() {
        int side1 = 2;
        int side2 = 2;
        int side3 = 3;
        String expected = "Tam giac can";
        String result = TriangleCheck.checkTriangle(side1,side2,side3);

        assertEquals(expected,result);
    }
    @Test
    public void TriangleCheckTest03() {
        int side1 = 2;
        int side2 = 2;
        int side3 = 8;
        String expected = "Khong phai tam giac";
        String result = TriangleCheck.checkTriangle(side1,side2,side3);

        assertEquals(expected,result);
    }
    @Test
    public void TriangleCheckTest04() {
        int side1 = -1;
        int side2 = 2;
        int side3 = 1;
        String expected = "Khong phai tam giac";
        String result = TriangleCheck.checkTriangle(side1,side2,side3);

        assertEquals(expected,result);
    }
}