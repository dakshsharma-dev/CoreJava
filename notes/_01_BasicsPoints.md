## **_Functions vs Methods_**

* Function: Independent block of code that can exist outside a class (C++, C, etc.).  
* Method: A function that is associated with an object or class.  
* In Java, all functions are methods because everything is inside a class.  
* In C++, both standalone functions and class methods exist.  


## **_JDK vs JRE vs JVM_**

• JDK (Java Development Kit)
- Used for developing Java applications.
- Contains:
  • JRE
  • Compiler (javac)
  • Debugger, javadoc, and other development tools
- Can both develop and run Java programs.
- Platform-dependent (different builds for Windows, Linux, macOS).

• JRE (Java Runtime Environment)
- Used to run Java applications.
- Contains:
  • JVM
  • Core Java libraries
- Cannot compile Java source code.
- Platform-dependent (different builds for different OSes).

• JVM (Java Virtual Machine)
- Executes Java bytecode (.class files).
- Performs:
  • Bytecode execution
  • Memory management
  • Garbage collection
  • Runtime services
- JVM implementations are platform-dependent.

Compilation & Execution Flow  
JAVA Flow:  
MyProgram.java → javac → MyProgram.class (bytecode) → JVM → Machine
Code → CPU

C++ Flow:  
MyProgram.cpp → g++ → Machine Code (.exe) → CPU

Why Java is Platform Independent

• Java compiler (javac) produces bytecode, not machine code.  
• Bytecode is platform-independent.  
• Each OS has its own JVM implementation that translates bytecode into machine code.

Rule of Thumb

• If a compiler produces intermediate code (bytecode/IL) → potentially platform-independent.  
• If a compiler produces native machine code directly → platform-dependent.  


### **_IMPORTANT NOTE_**:  

boolean size is JVM implementation-dependent; Java does not specify a fixed size.


### **_TYPES OF DATATYPES:_**  

Primitive Data Types: Store simple values directly in memory.  
Non-Primitive (Reference) Data Types: Store MEMORY REFERENCES to objects.

### **_SORT A MAP ACCORDING TO VALUE NOT KEY IN DESCENDING ORDER(C++):_**

```cpp
map<int, int> mp = {
  {1, 40},
  {2, 10},
  {3, 30},
  {4, 20}
};  
vector<pair<int, int>> vec(mp.begin(), mp.end());

sort( vec.begin(), vec.end(), 
      [](const auto& a, const auto& b) {
         if(a.second == b.second){
             a.first < b.first;        // smaller interger first if freq are equal
         }
         return a.second > b.second;   // decreasing order of value (place element with larger freq before element with smaller freq)
      });

for (auto& [key, value] : vec) {  
  cout << key << " " << value << '\n';
}
```


Explanation:  
* Third argument in sort function is custom comparator that tells sort() how to compare two elements.  
* `[](...) { ... }` -> This is a lambda function. Think of it as a function written directly where it is needed.  
* `[]` -> Part of lambda syntax. Empty `[]` means the function does not use any outside variables.  
* (const auto& a, const auto& b) -> The two elements that sort() wants to compare.  
* return a.first < b.first;
* return a.second > b.second;  
* sort() asks: "Should a be placed before b?"  *******************************  [THIS IS THE MOST IMPORTANT THING]  
true → Place a before b  
false → Do not place a before b


## **_UNDERSTANDING JAVA'S CLASS AND FILE STRUCTURE:_**  

Java internally organizes code at the class level, not the file level.

Mental Model:

Package  
├── Class A  
├── Class B  
├── Class C

Files are just containers for class definitions; classes are the real entities Java tracks and compiles.

Rules:
1. A package cannot contain two classes with the same name.
2. A .java file can contain multiple classes.
3. At most one class can be public in a file.
4. If a public class exists, the file name must match that public class name.

Example:

Mobile.java  
├── public class Mobile  
├── class Battery  
└── class Charger  

Java treats Mobile, Battery, and Charger as three separate classes.

Compilation:  

Mobile.class  
Battery.class  
Charger.class  

The compiler ultimately cares about classes, not the source file that contained them.  

## **_ACCESS MODIFIERS:_**

Access Modifiers control the visibility/accessibility of classes, methods, variables, and constructors.

| Modifier    | Access |
|------------|---------|
| `public`    | Accessible everywhere |
| `protected` | Same package + subclasses in other packages |
| `default`   | Same package only (no keyword) |
| `private`   | Same class only |

### Visibility Table

| Modifier | Class | Package | Subclass | World |
|----------|:-----:|:-------:|:--------:|:-----:|
| `public` | ✔ | ✔ | ✔ | ✔ |
| `protected` | ✔ | ✔ | ✔ | ✘ |
| `default` | ✔ | ✔ | ✘ | ✘ |
| `private` | ✔ | ✘ | ✘ | ✘ |

### Notes

- Top-level classes can only be `public` or `default` (package-private).
- `private` and `protected` are allowed only for nested/inner classes, not top-level classes.
- `private`/`protected` require an enclosing class to define their scope.
- Prefer the most restrictive access modifier that works.
- `private` + getters/setters is the foundation of encapsulation.


## ADDRESS vs REFERENCE vs POINTER  
#### C++:
- Address  
  - &x         → gives the memory address of x  
- Pointer  
  ```int* p = &x;```
  - Stores an address  
  - Can be reseated  ```p = &y;   // valid```

- Reference  
  ```int& ref = x;```  
  - An alias (**ANOTHER NAME**) for x  
  - Must be initialized when declared  
  - Cannot be reseated  
  ```ref = 20;   // changes x```
- ```fun(int&)```  
  - pass by reference;
  - not passing an address.
  - Caller's variable can be modified.
  - no copy is made
- ```fun(int*)```
  - pass a pointer (address)  
  - Call: ```fun(&x);```

Java:
- No pointers exposed to the programmer
- No address manipulation (&, *, pointer arithmetic, etc.)
- Primitive variables store actual values
- Object variables store references
- A reference is a JVM-managed **HANDLE/LINK** to an object
- References allow access to objects but are not raw memory addresses

#### Therefore, a reference lets you reach and work with data stored in memory without exposing or requiring the raw memory address.