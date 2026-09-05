# Command Line Arguments in Java

Command-line arguments are values passed to a Java program when it starts.

Syntax:

```java
public static void main(String[] args)
```

- `args` is an array of Strings.
- Each command-line argument is stored as one element in `args`.

Example:

```bash
java Test Hello 123
```

```java
public class Test {
    public static void main(String[] args) {
        System.out.println(args[0]); // Hello
        System.out.println(args[1]); // 123
    }
}
```

#### Notes:
- All command-line arguments are received as `String`s.
- Convert them if another type is needed:
    - `Integer.parseInt()`
    - `Double.parseDouble()`
    - etc.
- Accessing an invalid index causes `ArrayIndexOutOfBoundsException`.

#### Use Case:
- Passing values to a program when it starts.
- Commonly used by tools, scripts, and frameworks.


# Varargs (Variable Arguments)

Varargs allow a method to accept zero or more arguments of the same type.

Syntax:

```java
static int sum(int... nums) {
    int total = 0;

    for (int num : nums) {
        total += num;
    }

    return total;
}
```

Usage:

```java
sum();              // 0 arguments
sum(10);            // 1 argument
sum(10, 20, 30);    // 3 arguments
```

## Important

- Internally, varargs are treated as an array.
- A method can have only one varargs parameter.
- The varargs parameter must be the last parameter.
- All varargs values must be of the same type.

Valid:

```java
void show(String name, int... nums)
```

Invalid:

```java
void show(int... nums, String name)   // ❌ varargs must be last
```

```java
void show(int... a, double... b)      // ❌ only one varargs parameter
```

## Use Cases

- When the number of arguments is not known in advance.
- Provides a cleaner API for the caller.
- Avoids creating multiple overloaded methods.

Example without varargs:

```java
sum()
sum(int a)
sum(int a, int b)
sum(int a, int b, int c)
... need multiple methods
```

Example with varargs:

```java
sum(int... nums)
```

## Comparison with ArrayList

Varargs and ArrayList solve different problems:

```text
Varargs   → Variable number of method arguments
ArrayList → Dynamic collection of elements
```

Varargs are internally much closer to:

```java
int sum(int[] nums)
```

than to:

```java
ArrayList<Integer>
```

## Example from Java

```java
System.out.printf("%s %d", "Age", 20); // printf() uses varargs internally:
```