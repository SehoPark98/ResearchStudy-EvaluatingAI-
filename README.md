# Evaluating AI-Generated Unit Tests

A software testing research project comparing ChatGPT-generated JUnit test cases with human-written test suites for the `TriangleType` Java program.

The project evaluates whether AI-generated tests can provide reliable structural coverage while reducing the manual effort required to design test cases.

## Project Overview

We generated multiple sets of JUnit tests using different prompting strategies and compared them with manually written structural test suites.

The prompts targeted different testing strategies, including:

- Equilateral and isosceles triangle cases
- Scalene and invalid triangle cases
- Boundary-value analysis
- Branch-coverage optimization
- Edge and limit cases

## AI-Generated Test Suite

The generated test suite contains cases covering:

- Equilateral triangles
- Multiple isosceles configurations
- Valid scalene triangles
- Invalid triangle conditions
- Lower and upper input boundaries
- Out-of-range inputs

Example:

```java
@Test
public void testIsoscelesSide1EqualsSide2() {
    assertEquals(2, TriangleType.triangleType(6, 6, 5));
}
