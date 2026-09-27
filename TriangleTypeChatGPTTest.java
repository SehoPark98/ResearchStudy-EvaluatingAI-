import static org.junit.Assert.*;

import org.junit.Test;

public class TriangleTypeChatGPTTest {

    // Test Case 1: Equilateral triangle — covers all three equality checks and valid triangle check
    @Test
    public void testEquilateralTriangle() {
        assertEquals(3, TriangleType.triangleType(5, 5, 5));
    }

    // Test Case 2: Isosceles triangle where Side1 == Side2, and Side1+Side2 > Side3
    // Covers triOut == 1 and that branch of the triangle validity check
    @Test
    public void testIsoscelesSide1EqualsSide2() {
        assertEquals(2, TriangleType.triangleType(6, 6, 5));
    }

    // Test Case 3: Isosceles triangle where Side1 == Side3, and Side1+Side3 > Side2
    // Covers triOut == 2 and that specific validation
    @Test
    public void testIsoscelesSide1EqualsSide3() {
        assertEquals(2, TriangleType.triangleType(7, 5, 7));
    }

    // Test Case 4: Isosceles triangle where Side2 == Side3, and Side2+Side3 > Side1
    // Covers triOut == 3 and that specific validation
    @Test
    public void testIsoscelesSide2EqualsSide3() {
        assertEquals(2, TriangleType.triangleType(5, 8, 8));
    }

    // Test Case 5: Isosceles triangle with largest valid sides under upper limit
    // Covers upper boundary logic without triggering the bounds error
    @Test
    public void testIsoscelesWithUpperBounds() {
        assertEquals(2, TriangleType.triangleType(1000, 1000, 999));
    }
    
    @Test
    public void testScaleneTriangle_AllSidesDifferent_ShouldReturn1() {
        // 6 + 7 > 8, 6 + 8 > 7, 7 + 8 > 6 --> Valid scalene triangle
        assertEquals(1, TriangleType.triangleType(6, 7, 8));
    }

    @Test
    public void testScaleneTriangle_LargerValues_ShouldReturn1() {
        // 50, 60, 70 form a valid scalene triangle
        assertEquals(1, TriangleType.triangleType(50, 60, 70));
    }

    @Test
    public void testNotATriangle_SumOfTwoSidesEqualsThird_ShouldReturn4() {
        // 5 + 10 = 15 --> Not a triangle
        assertEquals(4, TriangleType.triangleType(5, 10, 15));
    }

    @Test
    public void testNotATriangle_OneSideTooLong_ShouldReturn4() {
        // 1 + 2 < 10 --> Not a triangle
        assertEquals(4, TriangleType.triangleType(1, 2, 10));
    }

    @Test
    public void testNotATriangle_SymmetricalInvalidSides_ShouldReturn4() {
        // 100 + 100 = 200 --> Not a triangle
        assertEquals(4, TriangleType.triangleType(100, 100, 200));
    }
    
    // Test Case 1: Equilateral triangle — covers all three equality checks and valid triangle check
    @Test
    public void testSideOneIsZero_NotATriangle() {
        int result = TriangleType.triangleType(0, 50, 50);
        assertEquals(4, result);
    }

    // 2) Smallest positive side: side1=1 with two equal 50s --> valid isosceles (2)
    @Test
    public void testSmallestPositive_Isosceles() {
        int result = TriangleType.triangleType(1, 50, 50);
        assertEquals(2, result);
    }

    // 3) Largest allowed side: all sides=1000 --> equilateral (3)
    @Test
    public void testLargestAllowed_Equilateral() {
        int result = TriangleType.triangleType(1000, 1000, 1000);
        assertEquals(3, result);
    }

    // 4) Immediate neighbor above the largest allowed side: side1=1001 --> out of bounds (5)
    @Test
    public void testAboveLargest_OutOfBounds() {
        int result = TriangleType.triangleType(1001, 100, 100);
        assertEquals(5, result);
    }

    // 5) A typical “middle-of-range” scalene: (100, 200, 250) --> valid scalene (1)
    @Test
    public void testMiddleScalene() {
        int result = TriangleType.triangleType(100, 200, 250);
        assertEquals(1, result);
    }


}